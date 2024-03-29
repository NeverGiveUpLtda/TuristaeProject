package com.app.turistae.ui.turismo;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;


import android.provider.MediaStore;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


import droidninja.filepicker.FilePickerBuilder;
import droidninja.filepicker.FilePickerConst;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;
import java.util.List;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.app.turistae.ErrorResponse;
import com.app.turistae.R;
import com.app.turistae.adapter.FotosPickerTurismoAdapter;
import com.app.turistae.api.ApiClient;
import com.app.turistae.api.CategoriaService;
import com.app.turistae.api.ImagemService;
import com.app.turistae.api.TurismoService;
import com.app.turistae.databinding.FragmentTurismoBinding;
import com.app.turistae.model.Categoria;
import com.app.turistae.model.Imagem;
import com.app.turistae.model.Turismo;
import com.google.gson.Gson;
import com.santalu.maskara.widget.MaskEditText;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TurismoFragment extends Fragment implements EasyPermissions.PermissionCallbacks {

    private FragmentTurismoBinding binding;

    Spinner Catspinner;

    TextView txtCidadeCadTur, txtBairroCadTur, txtRuaCadTur, txtNomeCadTur, txtDescricaoCadTur, txtNumeroLocal;

    Button btnCancelarCadTur, btnCadastrarCadTur;

    private List<Categoria> categorias;

    private MaskEditText txtCNPJCadTur, txtEstadoCadTur, txtTelefoneCadTur;

    private SharedPreferences sharedPreferences;

    private TurismoService turismoService;
    private CategoriaService categoriaService;

    private ImagemService imagemService;

    RecyclerView recyclerView;

    ArrayList<Uri> listaImagens = new ArrayList<>();

    Button btnFoto;

    private static final int REQUEST_IMAGE_PICK = 1;
    private static final int MAX_IMAGE_COUNT = 3;


    public TurismoFragment() {
        // Construtor público vazio necessário
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTurismoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        btnFoto = root.findViewById(R.id.btnPick);
        recyclerView = root.findViewById(R.id.recyclerFotosTurismo);

        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    abrirSelecionadorImagem();
                } else {
                    requestLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE);
                }
            }
        });

        turismoService = ApiClient.getTurismoService();
        categoriaService = ApiClient.getCategoriaService();
        imagemService = ApiClient.getImagemService();

        btnCancelarCadTur = root.findViewById(R.id.btnCancelarCadTur);
        btnCadastrarCadTur = root.findViewById(R.id.btnCadastrarTurismo);

        sharedPreferences = getActivity().getSharedPreferences("user_pref", Context.MODE_PRIVATE);

        Catspinner = root.findViewById(R.id.spinnerCategoria);

        // Campos do formulário de cadastro do turismo
        txtCidadeCadTur = root.findViewById(R.id.txtCadTurCidade);
        txtBairroCadTur = root.findViewById(R.id.txtCadTurBairro);
        txtRuaCadTur = root.findViewById(R.id.txtCadTurRua);
        txtNomeCadTur = root.findViewById(R.id.txtCadTurNome);
        txtDescricaoCadTur = root.findViewById(R.id.txtCadTurDescricao);
        txtCNPJCadTur = root.findViewById(R.id.txtCadTurCnpj);
        txtEstadoCadTur = root.findViewById(R.id.txtCadTurEstado);
        txtTelefoneCadTur = root.findViewById(R.id.txtCadTurTelefone);
        txtNumeroLocal = root.findViewById(R.id.txtCadTurNumeroLocal);


        getCategorias();


        btnCadastrarCadTur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Turismo turismo = new Turismo();
                try {
                    turismo.setCidade(txtCidadeCadTur.getText().toString());
                    turismo.setBairro(txtBairroCadTur.getText().toString());
                    turismo.setRua(txtRuaCadTur.getText().toString());
                    turismo.setNome(txtNomeCadTur.getText().toString());
                    turismo.setDescricao(txtDescricaoCadTur.getText().toString());
                    turismo.setCadastroNacionalPessoasJuridicas(txtCNPJCadTur.getText().toString());
                    turismo.setEstado(txtEstadoCadTur.getText().toString());
                    turismo.setTelefone(Long.valueOf(txtTelefoneCadTur.getText().toString().replaceAll("[^0-9]", "")));
                    turismo.setNumeroLocal(Integer.parseInt(txtNumeroLocal.getText().toString()));
                    turismo.setUsuarioId(getUsuarioIdFromSharedPreferences());

                    int categoriaPosition = Catspinner.getSelectedItemPosition();
                    Categoria categoriaSelecionada = categorias.get(categoriaPosition);
                    int categoriaId = categoriaSelecionada.getId();
                    turismo.setCategoriaId(categoriaId); // Definir o categoriaId

                    // Chame um método para cadastrar o turismo usando o serviço/API correspondente
                    inserirTurismo(turismo);


                } catch (Exception e) {
                    // Exibe uma mensagem de erro utilizando o Toast
                    Log.i("ERRO AQUI!", e.getMessage());
                    Toast.makeText(getContext(), "Atenção: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        });

        return root;
    }

    private void abrirSelecionadorImagem() {
        try {
            if (listaImagens.size() >= MAX_IMAGE_COUNT) {
                throw new IllegalStateException("Você já selecionou o número máximo de imagens permitidas.");
            }

            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
            startActivityForResult(Intent.createChooser(intent, "Selecione as imagens"), REQUEST_IMAGE_PICK);
        } catch (IllegalStateException e) {
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Ocorreu um erro ao abrir o seletor de imagens.", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    private void inserirTurismo(Turismo turismo) {
        Call<Integer> call = turismoService.postTurismo(turismo);
        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (response.isSuccessful()) {
                    int turismoId = response.body();
                    Toast.makeText(getContext(), "Cadastro turismo realizado com sucesso!", Toast.LENGTH_SHORT).show();



                    if (turismoId != 0) {
                        try {
                            inserirImagem(turismoId); // Chama o método inserirImagem() passando o ID do turismo cadastrado
                            limparCampos();
                        } catch (IOException e) {
                            Toast.makeText(getContext(), "Não foi possível converter/acessar imagem", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getContext(), "ID de turismo inválido", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    ErrorResponse erro = new Gson().fromJson(response.errorBody().charStream(), ErrorResponse.class);

                    String erros = "";
                    for (String e : erro.getErrors()) {
                        erros += "- " + e + "\n";
                    }

                    AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                    alert.setMessage(erros);
                    alert.setPositiveButton("Fechar", null);
                    alert.show();
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Toast.makeText(getContext(), "Falha na requisição: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void limparCampos() {
        // Limpar os campos
        txtCidadeCadTur.setText("");
        txtBairroCadTur.setText("");
        txtRuaCadTur.setText("");
        txtNomeCadTur.setText("");
        txtDescricaoCadTur.setText("");
        txtCNPJCadTur.setText("");
        txtEstadoCadTur.setText("");
        txtTelefoneCadTur.setText("");
        txtNumeroLocal.setText("");

        // Limpar a lista de imagens
        listaImagens.clear();
        recyclerView.setAdapter(null);
    }



    private void inserirImagem(int turismoId) throws IOException {
        if (listaImagens.size() != MAX_IMAGE_COUNT) {
            Toast.makeText(getActivity(), "Selecione exatamente 3 imagens", Toast.LENGTH_SHORT).show();
            return;
        }

        // Para cada imagem selecionada, converta em base64 e envie para a API
        for (int i = 0; i < listaImagens.size(); i++) {
            Uri imageUri = listaImagens.get(i);
            String imageBase64 = uriToBase64(imageUri);

            // Chame um método para enviar a imagem usando o serviço/API correspondente,
            // passando o ID do turismo e a imagem base64
            Imagem imagemTur = new Imagem(turismoId, imageBase64);
            enviarImagem(imagemTur);
        }
    }


    private void enviarImagem(Imagem imagem) {
        Call<Integer> call = imagemService.postImagem(imagem);
        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (response.isSuccessful()) {
                    Integer imagemCadastrada = response.body();
                    Toast.makeText(getContext(), "Imagem cadastrada com sucesso!", Toast.LENGTH_SHORT).show();

                    // Realize as ações adicionais necessárias após cadastrar a imagem
                } else {
                    // Tratamento de erro para o cadastro da imagem
                    Toast.makeText(getContext(), "Erro ao cadastrar imagem, tente novamente!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                // Tratamento de falha na conexão com a API
                Log.e("Falha ao conectar a API", t.getMessage());
                Toast.makeText(getContext(), "Erro ao conectar à API, verifique sua conexão de internet!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String uriToBase64(Uri uri) throws IOException {
        Context context = requireContext();
        InputStream inputStream = context.getContentResolver().openInputStream(uri);
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();

        int bufferSize = 4096;
        byte[] buffer = new byte[bufferSize];
        int len;
        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }

        byte[] byteArray = byteBuffer.toByteArray();
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }


    // Método para obter as categorias do serviço categoriaService
    private void getCategorias() {
        Call<List<Categoria>> call = categoriaService.getCategorias();
        call.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                if (response.isSuccessful()) {
                    categorias = response.body(); // Atualizar a lista categorias do escopo da classe
                    if (categorias != null) {
                        List<String> categoriaNames = new ArrayList<>();
                        for (Categoria categoria : categorias) {
                            categoriaNames.add(categoria.getNome());
                        }

                        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, categoriaNames);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Catspinner.setAdapter(adapter);


                    }
                } else {
                    Toast.makeText(getContext(), "Erro ao obter categorias, tente novamente!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {
                Log.e("Falha ao conectar a API", t.getMessage());
            }
        });
    }

    private int getUsuarioIdFromSharedPreferences() {
        return sharedPreferences.getInt("usuarioId", 0); // 0 é o valor padrão caso a chave não seja encontrada
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        if (requestCode == 100 && perms.size() == 2) {
            imagePicker();
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder((Activity) requireContext()).build().show();
        } else {
            Toast.makeText(getContext(), "Permissão recusada", Toast.LENGTH_SHORT).show();
        }
    }


    private final ActivityResultLauncher<String> requestLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(),
            new ActivityResultCallback<Boolean>() {
                @Override
                public void onActivityResult(Boolean result) {
                    if(result){
                        abrirSelecionadorImagem();

                    }
                }
            });

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_PICK && resultCode == getActivity().RESULT_OK) {
            if (data != null) {
                if (data.getClipData() != null) {
                    int count = data.getClipData().getItemCount();
                    if (count > MAX_IMAGE_COUNT) {
                        Toast.makeText(getActivity(), "Selecione no máximo 3 imagens", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    for (int i = 0; i < count; i++) {
                        Uri imageUri = data.getClipData().getItemAt(i).getUri();
                        listaImagens.add(imageUri);
                    }
                    exibirImagensSelecionadas();
                } else if (data.getData() != null) {
                    Uri imageUri = data.getData();
                    listaImagens.add(imageUri);
                    exibirImagensSelecionadas();
                }
            }
        }
    }

    private void exibirImagensSelecionadas() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new FotosPickerTurismoAdapter(listaImagens));
    }


    private void imagePicker() {
        FilePickerBuilder.getInstance()
                .setActivityTitle("Selecione as imagens")
                .setSpan(FilePickerConst.SPAN_TYPE.FOLDER_SPAN, 3)
                .setSpan(FilePickerConst.SPAN_TYPE.DETAIL_SPAN, 3)
                .setMaxCount(3)
                .setSelectedFiles(listaImagens)
                .setActivityTheme(R.style.CustomTheme)
                .pickPhoto(requireActivity());
    }
}



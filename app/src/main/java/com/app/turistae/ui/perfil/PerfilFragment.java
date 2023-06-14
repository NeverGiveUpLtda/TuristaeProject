package com.app.turistae.ui.perfil;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.turistae.ErrorResponse;
import com.app.turistae.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.turistae.api.ApiClient;
import com.app.turistae.api.UsuarioService;
import com.app.turistae.databinding.FragmentPerfilBinding;
import com.app.turistae.model.Turismo;
import com.app.turistae.model.Usuario;
import com.google.gson.Gson;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilFragment extends Fragment {

    Button btnExcluir, btnSalvarEdicao;

    TextView txtEditUser, txtCidadeEditarUser, txtEstadoEditarUser, txtBairroEditarUser, txtRuaEditarUser, txtNumeroEditarUser, txtEmailEditarUser, txtTelefoneEditUser, txtLoginEditarUser;
    private SharedPreferences sharedPreferences;
    private FragmentPerfilBinding binding;

    UsuarioService usuarioService;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPerfilBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        usuarioService = ApiClient.getUsuarioService();

        txtEditUser = root.findViewById(R.id.txtUserNome);
        txtEmailEditarUser = root.findViewById(R.id.txtEmailUser);
        txtCidadeEditarUser = root.findViewById(R.id.txtCidadeUser);
        txtEstadoEditarUser = root.findViewById(R.id.txtEstadoUser);
        txtBairroEditarUser = root.findViewById(R.id.txtBairroUser);
        txtRuaEditarUser = root.findViewById(R.id.txtRuaUser);
        txtNumeroEditarUser = root.findViewById(R.id.txtNumeroUser);
        txtTelefoneEditUser = root.findViewById(R.id.txtTelefoneUser);
        txtLoginEditarUser = root.findViewById(R.id.txtLoginUser);

        btnExcluir = root.findViewById(R.id.btnExcluirEdicarUser);
        btnSalvarEdicao= root.findViewById(R.id.btnSalvarEdicaoUser);

        btnSalvarEdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = obterUsuarioEditado(); // Obtém o objeto do usuário editado
                editarUsuario(usuario.getId(), usuario); // Chama o método para editar o usuário
            }
        });

        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = obterUsuarioEditado(); // Obtém o objeto do usuário editado

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("Tem certeza de que deseja excluir o usuário? Todos turismoa cadastrado por você será apagado!")
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                excluirUsuario(usuario.getId()); // Chama o método para excluir o usuário
                            }
                        })
                        .setNegativeButton("Não", null)
                        .show();
            }
        });

        sharedPreferences = requireActivity().getSharedPreferences("user_pref", Context.MODE_PRIVATE);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtEditUser.setText(sharedPreferences.getString("usuarioNomeUser", ""));
        txtEmailEditarUser.setText(sharedPreferences.getString("usuarioEmail", ""));
        txtCidadeEditarUser.setText(sharedPreferences.getString("usuarioCidade", ""));
        txtEstadoEditarUser.setText(sharedPreferences.getString("usuarioEstado", ""));
        txtBairroEditarUser.setText(sharedPreferences.getString("usuarioBairro", ""));
        txtRuaEditarUser.setText(sharedPreferences.getString("usuarioRua", ""));
        txtNumeroEditarUser.setText(sharedPreferences.getString("usuarioLogradouro", ""));
        txtTelefoneEditUser.setText(sharedPreferences.getString("usuarioTelefone", ""));
        txtLoginEditarUser.setText(sharedPreferences.getString("usuarioNomeUser", ""));
    }

    private Usuario obterUsuarioEditado() {
        // Crie um objeto de usuário com os dados editados dos campos de texto
        // Exemplo:
        String nome = txtEditUser.getText().toString();
        String email = txtEmailEditarUser.getText().toString();
        String cidade = txtCidadeEditarUser.getText().toString();
        String estado = txtEstadoEditarUser.getText().toString();
        String bairro = txtBairroEditarUser.getText().toString();
        String rua = txtRuaEditarUser.getText().toString();
        String numero = txtNumeroEditarUser.getText().toString();
        String telefone = txtTelefoneEditUser.getText().toString();
        String login = txtLoginEditarUser.getText().toString();

        Usuario usuario = new Usuario();


        usuario.setId(sharedPreferences.getInt("usuarioId", 0));
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setCidade(cidade);
        usuario.setEstado(estado);
        usuario.setBairro(bairro);
        usuario.setRua(rua);
        usuario.setNumeroCasa(numero);
        usuario.setTelefone(Long.valueOf(telefone));
        usuario.setNomeUsuario(login);

        // Preencha os demais campos do objeto de usuário conforme necessário

        return usuario;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    private void editarUsuario(int idUser, Usuario usu) {
        Call<Void> call = usuarioService.editUsuario(idUser, usu);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getContext(), "Usuário editado com sucesso!", Toast.LENGTH_SHORT).show();
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
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("Falha ao conectar a API", t.getMessage());
                Toast.makeText(getContext(), "Falha ao conectar a API", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void excluirUsuario(int idUser) {
        Call<Void> call = usuarioService.deleteUsuario(idUser);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getContext(), "Usuário excluído com sucesso!", Toast.LENGTH_SHORT).show();
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
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e("Falha ao conectar a API", t.getMessage());
                Toast.makeText(getContext(), "Falha ao conectar a API", Toast.LENGTH_SHORT).show();
            }
        });
    }

}

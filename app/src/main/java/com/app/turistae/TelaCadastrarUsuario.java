package com.app.turistae;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.turistae.api.ApiClient;
import com.app.turistae.api.UsuarioService;
import com.app.turistae.model.Usuario;
import com.santalu.maskara.widget.MaskEditText;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TelaCadastrarUsuario extends AppCompatActivity {

    Button btnCancelarUser, btnCadastrarUser;
    UsuarioService usuarioService;

    TextView txtLoginCadUser, txtCidadeCadUser, txtBairroCadUser, txtRuaCadUser,
            txtSenhaCadUser, txtConfirmaSenhaCadUser, txtNomeCadUser,
            txtEmailCadUser, txtNumeroCasaCadUser, txtProfissaoCadUser;

    private MaskEditText txtCPFCadUser, txtNascimentoCadUser, txtRGCadUser, txtEstadoCadUser, txtTelefoneCadUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastrar_usuario);
        usuarioService = ApiClient.getUsuarioService();
        btnCancelarUser = (Button) findViewById(R.id.btnCancelarCadUser);
        btnCadastrarUser = (Button) findViewById(R.id.btnCadastrarUsuario);

        //campos do forms de cadastro do usuário
        txtLoginCadUser = findViewById(R.id.txtLoginUser);
        txtCidadeCadUser = findViewById(R.id.txtCidadeUser);
        txtBairroCadUser = findViewById(R.id.txtBairroUser);
        txtRuaCadUser = findViewById(R.id.txtRuaUser);
        txtNumeroCasaCadUser = findViewById(R.id.txtNumeroUser);
        txtTelefoneCadUser = findViewById(R.id.txtTelefoneUser);
        txtNascimentoCadUser = findViewById(R.id.txtNascimentoCadUser);
        txtConfirmaSenhaCadUser = findViewById(R.id.txtSenhaConfirmaCadUser);
        txtNomeCadUser = findViewById(R.id.txtUserNome);
        txtEstadoCadUser = findViewById(R.id.txtEstadoUser);
        txtCPFCadUser = findViewById(R.id.txtCPFCadUser);
        txtEmailCadUser = findViewById(R.id.txtEmailUser);
        txtRGCadUser = findViewById(R.id.txtRGCadUser);
        txtProfissaoCadUser = findViewById(R.id.txtProfissaoCadUser);
        txtSenhaCadUser = findViewById(R.id.txtSenhaCadUser);



        btnCancelarUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnCadastrarUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usu = new Usuario();
                try {

                    // Obter a senha do campo de texto
                    String senha = txtSenhaCadUser.getText().toString();
                    String confirmarSenha = txtConfirmaSenhaCadUser.getText().toString();
                    // Definir a expressão regular para validar a senha
                    String regexSenha = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{5,25}$";
                    // Realizar a validação da senha
                    if (!senha.matches(regexSenha)) {
                        // A senha atende aos critérios
                        throw new Exception("Senha deve conter caractere especial, número, letra minúscula e maiscúla, no min 5 ");
                    }
                    if(!senha.equals(confirmarSenha)) {
                        throw new Exception("Confirmação de senha inválido!");
                    }




                    //Convertendo a data
                    // Obter a data de nascimento do campo de texto
                    String dataNascimentoStr = txtNascimentoCadUser.getText().toString();
                    // Definir o formato de entrada da data de nascimento
                    SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
                    // Converter a string da data em um objeto Date
                    Date dataNascimento = formatoEntrada.parse(dataNascimentoStr);
                    // Definir o formato de saída desejado
                    SimpleDateFormat formatoSaida = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                    // Converter a data para o formato desejado
                    String dataNascimentoFormatada = formatoSaida.format(dataNascimento);
                    // Definir a data de nascimento no objeto Usuario
                    usu.setDataNascimento(dataNascimentoFormatada);



                    // Obter o email do campo de texto
                    String email = txtEmailCadUser.getText().toString();
                    // Definir a expressão regular para validar o email
                    String regexEmail = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
                    // Realizar a validação do email
                    if (email.matches(regexEmail)) {
                        // O email é válido
                        usu.setEmail(email);
                    } else {
                        // O email não é válido
                        Toast.makeText(getApplicationContext(), "Email inválido.", Toast.LENGTH_SHORT).show();
                    }


                    usu.setNomeUsuario(txtLoginCadUser.getText().toString());
                    usu.setNome(txtNomeCadUser.getText().toString());
                    usu.setBairro(txtBairroCadUser.getText().toString());
                    usu.setCidade(txtCidadeCadUser.getText().toString());
                    usu.setEstado(txtEstadoCadUser.getText().toString());
                    usu.setNumeroCasa(txtNumeroCasaCadUser.getText().toString());
                    usu.setRegistroGeral(txtNomeCadUser.getText().toString());
                    usu.setTelefone(Long.valueOf(txtTelefoneCadUser.getText().toString().replaceAll("[^0-9]", "")));
                    usu.setRua(txtNomeCadUser.getText().toString());
                    usu.setProfissao(txtProfissaoCadUser.getText().toString());
                    usu.setCadastroPessoaFisica(txtCPFCadUser.getText().toString());
                    usu.setRegistroGeral(txtRGCadUser.getText().toString());
                    usu.setRua(txtRuaCadUser.getText().toString());

                    // Chama o método para inserir o usuário
                    inserirUsuario(usu);

                    finish();


                } catch (Exception e) {
                    // Exibe uma mensagem de erro utilizando o Toast
                    Toast.makeText(getApplicationContext(), "Atenção: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void inserirUsuario(Usuario usu) {
        Call<Integer> call = usuarioService.postUsuario(usu);
        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(TelaCadastrarUsuario.this,
                            "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(TelaCadastrarUsuario.this,
                            "Erro ao cadastrar, tente novamente!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Log.e("Falha ao conectar a API", t.getMessage());
            }
        });
    }
}
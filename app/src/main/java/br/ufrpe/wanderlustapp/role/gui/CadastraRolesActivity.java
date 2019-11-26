package br.ufrpe.wanderlustapp.role.gui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import br.ufrpe.wanderlustapp.R;
import br.ufrpe.wanderlustapp.infra.Sessao;
import br.ufrpe.wanderlustapp.role.dominio.Role;

public class CadastraRolesActivity extends AppCompatActivity {

    public static final String TITULO_APPVAR_INSERE = "Insere rolê";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_roles);
        setTitle(TITULO_APPVAR_INSERE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formulario_role_salva, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_formulario_role_ic_salva){
            Role role = criaRole();
            if(verficaCampos()) {
                Sessao.instance.setRole(role);
            }
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean verficaCampos(){
        EditText nome = findViewById(R.id.formulario_role_nome);
        EditText descricao = findViewById(R.id.formulario_role_descricao);
        return nome.length() > 0 && descricao.length() > 0;
    }

    private Role criaRole(){
        Role role = new Role();
        if(verficaCampos()){
            preencheAtributosRole(role);
        }
        return role;
    }

    private void preencheAtributosRole(Role role) {
        EditText nome = findViewById(R.id.formulario_role_nome);
        EditText descricao = findViewById(R.id.formulario_role_descricao);
        role.setNome(nome.getText().toString());
        role.setDescricao(descricao.getText().toString());
    }


}

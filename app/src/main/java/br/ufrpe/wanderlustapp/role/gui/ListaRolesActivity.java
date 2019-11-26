package br.ufrpe.wanderlustapp.role.gui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.ufrpe.wanderlustapp.R;
import br.ufrpe.wanderlustapp.infra.Sessao;
import br.ufrpe.wanderlustapp.pontoTuristico.dominio.PontoTuristico;
import br.ufrpe.wanderlustapp.pontoTuristico.gui.OnItemClickListener;
import br.ufrpe.wanderlustapp.pontoTuristico.gui.PontoItemTouchHelperCallback;
import br.ufrpe.wanderlustapp.pontoTuristico.gui.adapter.ListPontosAdapter;
import br.ufrpe.wanderlustapp.role.dominio.Role;
import br.ufrpe.wanderlustapp.role.gui.adapter.ListRolesAdapter;
import br.ufrpe.wanderlustapp.role.negocio.RoleServices;

import static br.ufrpe.wanderlustapp.pontoTuristico.gui.pontosActivityConstantes.CODIGO_RESULTADO_PONTO_CRIADO;

public class ListaRolesActivity extends AppCompatActivity {

    RoleServices roleServices = new RoleServices(this);
    public static final String TITULO_APP_BAR = "Lista de Rolês";
    private ListRolesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_roles);
        setTitle(TITULO_APP_BAR);
        configuraRecyclerview();
        configuraBtnInsereRole();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        Role role = Sessao.instance.getRole();
        if (role != null){
            insereRole(role);
            Sessao.instance.resetRole();
        }
        super.onResume();
    }

    public void insereRole(Role role){
        roleServices.cadastrar(role);
        adapter.adiciona(role);
        Toast.makeText(getApplicationContext(), "Rolê cadastrado", Toast.LENGTH_SHORT).show();
    }

    private void configuraBtnInsereRole(){
        TextView btnInsereRole = findViewById(R.id.lista_roles_insere_role);
        btnInsereRole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaRolesActivity.this, CadastraRolesActivity.class));
            }
        });
    }

    private void configuraRecyclerview() {
        RecyclerView listaRoles = findViewById(R.id.lista_roles_recyclerview);
        setAdapter(listaRoles);
    }

    private List<Role> geraLista(){
        return roleServices.getListRole();
    }

    private void setAdapter (RecyclerView recyclerView){
        adapter = new ListRolesAdapter(this,geraLista());
        recyclerView.setAdapter(adapter);
    }
}

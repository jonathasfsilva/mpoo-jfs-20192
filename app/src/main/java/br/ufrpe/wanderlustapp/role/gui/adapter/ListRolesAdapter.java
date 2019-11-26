package br.ufrpe.wanderlustapp.role.gui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.ufrpe.wanderlustapp.R;
import br.ufrpe.wanderlustapp.role.dominio.Role;
import br.ufrpe.wanderlustapp.role.gui.ListaRolesActivity;

public class ListRolesAdapter extends RecyclerView.Adapter<ListRolesAdapter.RoleViewHolder>{

    private final Context context;
    private final List<Role> roles;
    private ListaRolesActivity listaRoles = new ListaRolesActivity();

    public ListRolesAdapter(Context context,List<Role> roles) {
        this.context = context;
        this.roles = roles;
    }

    public List<Role> getList(){
        return this.roles;
    }

    @Override
    public ListRolesAdapter.RoleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_role, parent, false);
        return new ListRolesAdapter.RoleViewHolder(viewCriada);
    }


    @Override
    public void onBindViewHolder(@NonNull ListRolesAdapter.RoleViewHolder holder, int position) {
        Role role = roles.get(position);
        holder.vincula(role);
    }

    @Override
    public int getItemCount() {
        return roles.size();
    }

    public void adiciona(Role role){
        roles.add(role);
        notifyDataSetChanged();
    }

    class RoleViewHolder extends RecyclerView.ViewHolder {
        private final TextView titulo;
        private final TextView descricao;
        private Role role;

        public RoleViewHolder(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.item_role_nome);
            descricao = itemView.findViewById(R.id.item_role_descricao);
        }

        public void vincula(Role role) {
            this.role = role;
            titulo.setText(this.role.getNome());
            descricao.setText(this.role.getDescricao());
        }
    }
}

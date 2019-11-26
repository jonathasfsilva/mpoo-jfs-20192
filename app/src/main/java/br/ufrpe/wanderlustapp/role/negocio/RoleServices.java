package br.ufrpe.wanderlustapp.role.negocio;

import android.content.Context;

import java.util.List;

import br.ufrpe.wanderlustapp.role.dominio.Role;
import br.ufrpe.wanderlustapp.role.persistencia.RoleDAO;

public class RoleServices {
    private RoleDAO roleDAO;

    public RoleServices(Context context){
        roleDAO = new RoleDAO(context);
    }

    public void cadastrar(Role role){
        long id = roleDAO.cadastrar(role);
        role.setId(id);
    }

    public List<Role> getListRole(){
        return roleDAO.getListRole();
    }
}

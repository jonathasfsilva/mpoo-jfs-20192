package br.ufrpe.wanderlustapp.role.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.ufrpe.wanderlustapp.infra.persistencia.AbstractDAO;
import br.ufrpe.wanderlustapp.infra.persistencia.DBHelper;
import br.ufrpe.wanderlustapp.role.dominio.Role;


public class RoleDAO extends AbstractDAO {
    private SQLiteDatabase db;
    private DBHelper helper;
    private Context context;

    public RoleDAO(Context context){
        this.context = context;
        helper = new DBHelper(this.context);
    }

    public long cadastrar(Role role){
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.CAMPO_NOME_ROLE, role.getNome());
        values.put(DBHelper.CAMPO_DESCRICAO_ROLE, role.getDescricao());
        long id = db.insert(DBHelper.TABELA_ROLE, null, values);
        super.close(db);
        return id;
    }

    public List<Role> getListRole(){
        List<Role> roles = new ArrayList<>();
        db = helper.getReadableDatabase();
        String sql = "SELECT * FROM " + DBHelper.TABELA_ROLE;
        Cursor cursor = db.rawQuery(sql, new String[]{});
        while (cursor.moveToNext()){
            roles.add(createRole(cursor));
        }
        cursor.close();
        db.close();
        return roles;
    }

    private Role createRole(Cursor cursor) {
        Role role = new Role();
        int columnIndex = cursor.getColumnIndex(DBHelper.CAMPO_ID_ROLE);
        role.setId(Integer.parseInt(cursor.getString(columnIndex)));
        columnIndex = cursor.getColumnIndex(DBHelper.CAMPO_NOME_ROLE);
        role.setNome(cursor.getString(columnIndex));
        columnIndex = cursor.getColumnIndex(DBHelper.CAMPO_DESCRICAO_ROLE);
        role.setDescricao(cursor.getString(columnIndex));
        return role;
    }
}

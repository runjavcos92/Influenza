/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import dao.usuarioDAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author FRANCISCONAVA
 */
@Named(value = "usuarioTable")
@SessionScoped
public class Usuario implements Serializable {
private String nombre_personal;
private String nombre_usuario;
private String privilegio;
private List<Usuario> usuarios;
@Inject
private institutoDTO instituto;

    public String getNombre_personal() {
        return nombre_personal;
    }

    public void setNombre_personal(String nombre_personal) {
        this.nombre_personal = nombre_personal;
    }

    public String getNombre_usuario()  {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(String privilegio) {
        this.privilegio = privilegio;
    }

    public List<Usuario> getUsuarios() throws SQLException {
        usuarioDAO userDao = new usuarioDAO();
        usuarios = userDao.loadTable(instituto.getId_instituto());
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}

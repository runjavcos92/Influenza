/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import conexion.conectar;
import dao.usuarioDAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;


/**
 *
 * @author FRANCISCONAVA
 */
@Named(value = "userBeanUpdate")
@SessionScoped
public class UserBeanUpdate implements Serializable {

    /**
     * Creates a new instance of UserBeanUpdate
     */
    public UserBeanUpdate() {
    }
    
    private String id_usuario;
    private String nombre;
    private String usuario;
    private String contraseña;
    private String id_rol;
    private String id_instituto;
    @Inject
    private institutoDTO instituto;
    private List<SelectItem> listaUsuarioU;
    private List<SelectItem> listaAdministradores;
    private List<UserBeanUpdate> usuarios = new ArrayList();

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getId_rol() {
        return id_rol;
    }

    public void setId_rol(String id_rol) {
        this.id_rol = id_rol;
    }

    public String getId_instituto() {
        return id_instituto;
    }

    public void setId_instituto(String id_instituto) {
        this.id_instituto = id_instituto;
    }

    public List<SelectItem> getListaAdministradores()throws SQLException {
        this.listaAdministradores = new ArrayList<SelectItem>();
        usuarioDAO userDao = new usuarioDAO();
        List<UserBeanUpdate> r = userDao.loadAllUsers();
        listaAdministradores.clear();
        for(UserBeanUpdate usuarios2 : r){
            SelectItem userItem = new SelectItem(usuarios2.getId_usuario(),usuarios2.getUsuario());
            this.listaAdministradores.add(userItem);
        }
        return listaAdministradores;
    }

    public void setListaAdministradores(List<SelectItem> listaAdministradores) {
        this.listaAdministradores = listaAdministradores;
    }
 

        
    public List<SelectItem> getListaUsuarioU() throws SQLException {
        this.listaUsuarioU = new ArrayList<SelectItem>();
        usuarioDAO userDao = new usuarioDAO();
        List<UserBeanUpdate> r = userDao.loadAllU(instituto.getId_instituto());
        listaUsuarioU.clear();
        for(UserBeanUpdate usuarios2 : r){
            SelectItem userItem = new SelectItem(usuarios2.getId_usuario(),usuarios2.getUsuario());
            this.listaUsuarioU.add(userItem);
        }
        return listaUsuarioU;
    }
    
    public void setListaUsuarioU(List<SelectItem> listaUsuarioU) {
        this.listaUsuarioU = listaUsuarioU;
    }

    public List<UserBeanUpdate> getUsuarios() throws SQLException {
        usuarioDAO userDao = new usuarioDAO();
        usuarios = userDao.loadAllU(instituto.getId_instituto());
        return usuarios;
    }

    public void setUsuarios(List<UserBeanUpdate> usuarios) {
        this.usuarios = usuarios;
    }
    
    
    
    public void changeUser(AjaxBehaviorEvent event)throws SQLException{
        String query = "Select nombre_personal,usuario,contraseña from usuario where id_usuario="+id_usuario+";";
        //nombreUpdate = id_usuario;
        conectar con = new conectar();
        Connection conn = con.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement(query);
            //ps.setString(1, id_instituto);
            rs = ps.executeQuery();
            //java.util.List results = new ArrayList();
            while(rs.next()){
                setNombre(rs.getString("nombre_personal"));
                setUsuario(rs.getString("usuario"));
                setContraseña(rs.getString("contraseña"));
                }
        }catch(SQLException e){
            System.out.println(""+e);
        }
    }
}

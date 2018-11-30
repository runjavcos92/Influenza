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
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;

/**
 *
 * @author FRANCISCONAVA
 */
@Named(value = "userBean")
@SessionScoped
public class userBean implements Serializable {

    /**
     * Creates a new instance of userBean
     */
    public userBean() {
    }
    
    private String id_usuario;
    private String usuario;
    private String usuarioCreate;
    private String contraseñaCreate;
    private String contraseña;
    private String id_instituto;
    private String id_rol;
    private String nombreCreate;
    private String nombreUpdate;
    private String usuarioUpdate;
    private String contraseñaUpdate;
    private List<SelectItem> listaUsuario;
    @Inject
    private institutoDTO instituto;

        
    public String getNombreUpdate() {
        return nombreUpdate;
    }

    public void setNombreUpdate(String nombreUpdate) {
        this.nombreUpdate = nombreUpdate;
    }

    public String getUsuarioUpdate() {
        return usuarioUpdate;
    }

    public void setUsuarioUpdate(String usuarioUpdate) {
        this.usuarioUpdate = usuarioUpdate;
    }

    public String getContraseñaUpdate() {
        return contraseñaUpdate;
    }

    public void setContraseñaUpdate(String contraseñaUpdate) {
        this.contraseñaUpdate = contraseñaUpdate;
    }
    
    public String getUsuarioCreate() {
        return usuarioCreate;
    }

    public void setUsuarioCreate(String usuarioCreate) {
        this.usuarioCreate = usuarioCreate;
    }

    public String getContraseñaCreate() {
        return contraseñaCreate;
    }

    public void setContraseñaCreate(String contraseñaCreate) {
        this.contraseñaCreate = contraseñaCreate;
    }
    
    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
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

    public String getId_instituto() {
        return id_instituto;
    }

    public void setId_instituto(String id_instituto) {
        this.id_instituto = id_instituto;
    }

    public String getId_rol() {
        return id_rol;
    }

    public void setId_rol(String id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombreCreate() {
        return nombreCreate;
    }

    public void setNombreCreate(String nombreCreate) {
        this.nombreCreate = nombreCreate;
    }
    
    public List<SelectItem> getListaUsuario() throws SQLException {
        this.listaUsuario = new ArrayList<SelectItem>();
        usuarioDAO userDao = new usuarioDAO();
        List<userBean> r = userDao.loadAll(instituto.getId_instituto());
        listaUsuario.clear();
        for(userBean usuarios1 : r){
            SelectItem userItem = new SelectItem(usuarios1.getId_usuario(),usuarios1.getUsuario());
            this.listaUsuario.add(userItem);
        }
        return listaUsuario;
    }
    

    public void mensajes(){
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,"Confirmación","Usuario Borrado!"));
        }
    
    public void mensajesUpdate(){
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,"Confirmación","Usuario Modificado!"));
        }
    
    public void setListaUsuario(List<SelectItem> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;


import conexion.conectar;
import dao.LogInfluenzaDAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import dao.usuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import sesion.SessionUtils;
import javax.validation.constraints.NotNull;
import dto.AcuInfluenzaDTO;
/**
 *
 * @author FRANCISCONAVA
 */
@Named(value = "usuario")
@SessionScoped
public class usuarioDTO implements Serializable {

    
    private String id_usuario;
    @NotNull
    private String usuario;
    @NotNull
    private String contraseña;
    private String id_instituto;
    private boolean loggedIn = false;
    private String id_rol;
    private String nombre;
    private List<SelectItem> listaUsuario;
    private String id_userList;
    @Inject
    private institutoDTO instituto;
    @Inject
    private LogInfluenzaDAO log;
    
    public String getId_usuario(){
        return id_usuario;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId_usuario(String user) throws SQLException{
                Connection con = null;
		PreparedStatement ps = null;
                conectar conexion = new conectar();
                con = conexion.conectar();
                String userid = null;
                try{
                    ps = con.prepareStatement("SELECT ID_USUARIO "
                                            + "FROM USUARIO "
                                            + "WHERE USUARIO = ?");
                    ps.setString(1,user );
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()){
                        userid = rs.getString(1);
                    }   
                }catch(SQLException ex){
                    System.out.println("Login error -->" + ex.getMessage());
                }
        this.id_usuario = userid;
    }

    public institutoDTO getInstituto() {
        return instituto;
    }

    public void setInstituto(institutoDTO instituto) {
        this.instituto = instituto;
    }

    public String getId_userList() {
        return id_userList;
    }

    public void setId_userList(String id_userList) {
        this.id_userList = id_userList;
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

    

    /*public List<SelectItem> getListaUsuario() throws SQLException {
        this.listaUsuario = new ArrayList<SelectItem>();
        usuarioDAO usuarioDao = new usuarioDAO();
        List<usuarioDTO> r = usuarioDao.loadSelect(instituto);
        listaUsuario.clear();
        for(usuarioDTO usuarios : r){
            SelectItem usuariosItem = new SelectItem(usuarios.getUsuario());
            this.listaUsuario.add(usuariosItem);
        }
        return listaUsuario;
    }
*/
    public void setListaUsuario(List<SelectItem> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    /**
     * Creates a new instance of usuario
     */
    public usuarioDTO() {
    }
    
    public String inicioSesion() throws SQLException{
        boolean validar = usuarioDAO.validarSesion(usuario, contraseña);
        id_rol = usuarioDAO.validarRol(usuario);
        String username;
        if(validar && "2".equals(id_rol)){
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("usuario", usuario);
            username = (String)session.getAttribute("usuario");
            instituto.setNombre(username);
            instituto.setId_instituto(username);
            setId_usuario(username);
            return "index";
        } else if(validar && "1".equals(id_rol)){
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("usuario", usuario);
            username = (String)session.getAttribute("usuario");
            instituto.setNombre(username);
            instituto.setId_instituto(username);
            setId_usuario(username);
            return "gestionAdmin";
        }else if(validar && "3".equals(id_rol)) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("usuario", usuario);
            username = (String)session.getAttribute("usuario");
            instituto.setNombre(username);
            instituto.setId_instituto(username);
            setId_usuario(username); 
            log.loadAcu(username);
            log.loadAcu2(username);
            log.loadHIM();
            return "gestionSAdmin";
        }else if(validar && "4".equals(id_rol)){
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("usuario", usuario);
            username = (String)session.getAttribute("usuario");
            instituto.setNombre(username);
            instituto.setId_instituto(username);
            setId_usuario(username);
            return "visualizar";
        }else{
            return "login";
        }
    }
    
    public void mensaje() throws SQLException{
        boolean validacion = usuarioDAO.validarSesion(usuario, contraseña);
        if(validacion==true){
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Bienvenido",""+usuario));
        }else{
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Error Usuario o Contraseña Incorrecta","usuario "+usuario+" incorrectos"));
        }
    }

    public String cerrarSesion(){
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        loggedIn = false;
        return "login";
    }
}
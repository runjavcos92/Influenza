/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import dao.RolDAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author FRANCISCONAVA
 */
@Named(value = "rolDTO")
@SessionScoped
public class RolDTO implements Serializable {

    /**
     * Creates a new instance of RolDTO
     */
    private String idRol;
    private String rol;
    private String roles;
    private List<SelectItem> listaRol;
    private List<SelectItem> listaRolSA;
    
    public RolDTO() {
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<SelectItem> getListaRol() throws SQLException {
        this.listaRol = new ArrayList<SelectItem>();
        RolDAO rolDao = new RolDAO();
        List<RolDTO> r = rolDao.loadAll();
        listaRol.clear();
        
        for(RolDTO roles : r){
            SelectItem rolItem = new SelectItem(roles.getIdRol(),roles.getRol());
            this.listaRol.add(rolItem);
        }
        return listaRol;
    }

    public void setListaRol(List<SelectItem> listaRol) {
        this.listaRol = listaRol;
    }
    
    public List<SelectItem> getListaRolSA() throws SQLException {
        this.listaRolSA = new ArrayList<SelectItem>();
        RolDAO rolDao = new RolDAO();
        List<RolDTO> r = rolDao.loadAllSA();
        listaRolSA.clear();
        
        for(RolDTO roles : r){
            SelectItem rolItem = new SelectItem(roles.getIdRol(),roles.getRol());
            this.listaRolSA.add(rolItem);
        }
        return listaRolSA;
    }

    public void setListaRolSA(List<SelectItem> listaRolSA) {
        this.listaRolSA = listaRolSA;
    }
    
}

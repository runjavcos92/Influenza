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
@Named(value = "rolDTOUpdate")
@SessionScoped
public class RolDTOUpdate implements Serializable {

    /**
     * Creates a new instance of RolDTO
     */
    private String idRolUpdate;
    private String rolUpdate;
    private String rolesUpdate;
    private List<SelectItem> listaRolUpdate;
    
    public RolDTOUpdate() {
    }

    public String getIdRolUpdate() {
        return idRolUpdate;
    }

    public void setIdRolUpdate(String idRol) {
        this.idRolUpdate = idRol;
    }

    public String getRolUpdate() {
        return rolUpdate;
    }

    public void setRolUpdate(String rol) {
        this.rolUpdate = rol;
    }

    public List<SelectItem> getListaRolUpdate() throws SQLException {
        this.listaRolUpdate = new ArrayList<SelectItem>();
        RolDAO rolDao = new RolDAO();
        List<RolDTOUpdate> r = rolDao.loadAllUpdate();
        listaRolUpdate.clear();
        
        for(RolDTOUpdate roles : r){
            SelectItem rolItem = new SelectItem(roles.getIdRolUpdate(),roles.getRolUpdate());
            this.listaRolUpdate.add(rolItem);
        }
        return listaRolUpdate;
    }

    public void setListaRolUpdate(List<SelectItem> listaRolUpdate) {
        this.listaRolUpdate = listaRolUpdate;
    }
    
}

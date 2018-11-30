/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import conexion.conectar;
import dao.institutoDAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author FRANCISCONAVA
 */
@Named(value = "institutoBean")
@SessionScoped
public class InstitutoBean implements Serializable {

    /**
     * Creates a new instance of InstitutoBean
     */
    public InstitutoBean() {
    }
    
    private String id_instituto;
    private String nombre;
    private List<SelectItem> listaInstituto;
    private static final String SQL_SELECT_ALL
		= "SELECT * "
		+ "FROM INSTITUTO";

    public String getId_instituto() {
        return id_instituto;
    }

    public void setId_instituto(String id_instituto) {
        this.id_instituto = id_instituto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public List<SelectItem> getListaInstituto() throws SQLException {
        this.listaInstituto = new ArrayList<SelectItem>();
        institutoDAO dao = new institutoDAO();
        List<InstitutoBean> r = dao.loadAll();
        listaInstituto.clear();
        
        for(InstitutoBean institutos : r){
            SelectItem instItem = new SelectItem(institutos.getId_instituto(),institutos.getNombre());
            this.listaInstituto.add(instItem);
        }
        return listaInstituto;
    }
    
    public void setListaInstituto(List<SelectItem> listaInstituto) {
        this.listaInstituto = listaInstituto;
    }
    
	
}

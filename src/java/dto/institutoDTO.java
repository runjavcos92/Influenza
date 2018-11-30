/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import conexion.conectar;
import dao.LogInfluenzaDAO;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author FRANCISCONAVA
 */
@Named(value = "instituto")
@SessionScoped
public class institutoDTO implements Serializable {

    /**
     * Creates a new instance of institutoDTO
     */
    public institutoDTO() {
    }
    
    private String id_instituto;
    private String nombre;
    private String lastUpdate;
    private String lastTimeUpdate;
    @Inject
    private LogInfluenzaDAO log;

    public String getLastTimeUpdate() {
        return lastTimeUpdate;
    }

    public void setLastTimeUpdate(String id_ins) {
                Connection con = null;
		PreparedStatement ps = null;
                conectar conexion = new conectar();
                con = conexion.conectar();
                java.sql.Time lastTime;
                String time= null;
                try{
                    ps = con.prepareStatement("SELECT MAX(TIEMPO) "
                                             + "FROM LOG_INFLUENZA "
                                            + "WHERE ID_INSTITUTO = ?");
                    ps.setString(1, id_ins);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()){
                        lastTime = rs.getTime(1);
                        time = lastTime.toString(); 
                        
                    }else {
                        time = "Sin registro";
                    }   
                }catch(SQLException ex){
                    System.out.println("Login error -->" + ex.getMessage());
                }
        this.lastTimeUpdate = time;
    }
    

    public String getLastUpdate() {
        return lastUpdate;
    }
    
    public String getId_instituto() {
        return id_instituto;
    }

    public void setId_instituto(String user)throws SQLException {
                Connection con = null;
		PreparedStatement ps = null;
                conectar conexion = new conectar();
                con = conexion.conectar();
                String IDINSTITUTO = null;
                try{
                    ps = con.prepareStatement("SELECT ID_INSTITUTO "
                                            + "FROM USUARIO "
                                            + "WHERE USUARIO = ?");
                    ps.setString(1, user);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()){
                        IDINSTITUTO = rs.getString(1);
                    }   
                }catch(SQLException ex){
                    System.out.println("Login error -->" + ex.getMessage());
                }
                this.id_instituto = IDINSTITUTO;
                setLastUpdate(IDINSTITUTO);
                setLastTimeUpdate(IDINSTITUTO);
                //tabla 1
                log.load(IDINSTITUTO);
                log.loadSums(IDINSTITUTO);
    }
    
    public void setLastUpdate(String id_ins) throws SQLException{
                Connection con = null;
		PreparedStatement ps = null;
                conectar conexion = new conectar();
                con = conexion.conectar();
                Date lastDateUpdate = null;
                String date= null;
                try{
                    ps = con.prepareStatement("SELECT MAX(FECHA) "
                                            + "FROM LOG_INFLUENZA "
                                            + "WHERE ID_INSTITUTO = ?");
                    ps.setString(1, id_ins);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()){
                        lastDateUpdate = rs.getDate(1);
                        date = lastDateUpdate.toString(); 
                        
                    }else {
                        date = "Sin registro";
                    }   
                }catch(SQLException ex){
                    System.out.println("Login error -->" + ex.getMessage());
                }
        this.lastUpdate = date;   
    }

    public String getNombre() { 
        return nombre;
    }
    
    public void setNombre(String user)throws SQLException{
                Connection con = null;
		PreparedStatement ps = null;
                conectar conexion = new conectar();
                con = conexion.conectar();
                String instituto = null;
                try{
                    ps = con.prepareStatement("SELECT NOMBRE "
                                            + "FROM INSTITUTO "
                                            + "INNER JOIN USUARIO ON USUARIO.ID_INSTITUTO = INSTITUTO.ID_INSTITUTO "
                                            + "WHERE USUARIO = ?");
                    ps.setString(1, user);
                    ResultSet rs = ps.executeQuery();
                  
                    if (rs.next()){
                        instituto = rs.getString(1);
                    }   
                }catch(SQLException ex){
                    System.out.println("Login error -->" + ex.getMessage());
                }
                this.nombre = instituto;   
    }
    
}

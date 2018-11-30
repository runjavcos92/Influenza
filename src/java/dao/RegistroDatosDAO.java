/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.conectar;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dto.RegistroDatosDTO;
import dto.institutoDTO;
import dto.usuarioDTO;
import java.sql.ResultSet;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;

/**
 *
 * @author FRANCISCONAVA
 */
@Named(value = "registroDatosDAO")
@SessionScoped
public class RegistroDatosDAO implements Serializable {

    /**
     * Creates a new instance of RegistroDatosDAO
     */
    public RegistroDatosDAO() {
    }
    
    private static final String SQL_INSERT = "INSERT INTO LOG_INFLUENZA (ID_USUARIO,ID_INSTITUTO,T1_A_A,T1_A_H,T1_H1_A,T1_H1_H,T1_H3_A,T1_H3_H,T1_B_A,"
                                           + "T1_B_H,T2_24,T2_H_M,T2_I_M,T2_C_UTI,T2_C_U,T3_DF_NA,T3_DF_PCR,T4_DF_A,T4_DF_H1,T4_DF_H3,T4_DF_B,T5_PS_A_A,"
                                           + "T5_PS_A_H,T5_PS_H1_A,T5_PS_H1_H,T5_PS_H3_A,T5_PS_H3_H,T5_PS_B_A,T5_PS_B_H,T6_V_TRGB,T6_V_VAPS,T6_V_PSV,"
                                           + "T6_V_VAP,T6_V_VAF,T7_OA_TP_A,T7_OA_TP_H,T7_OA_EI_A,FECHA,TIEMPO)"
                                            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
    private RegistroDatosDTO dto;
    @Inject 
    private usuarioDTO user_dto;
    @Inject
    private institutoDTO instdDto;
    LocalDateTime ldt = LocalDateTime.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
    
    public void insertarValores() throws SQLException{
        PreparedStatement ps = null;
        conectar con = new conectar();
        Connection conn = null;
        conn = con. conectar();  
        try{
            java.sql.Date sqlDate = java.sql.Date.valueOf(ldt.toLocalDate());
            java.sql.Time time = java.sql.Time.valueOf(ldt.toLocalTime());
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, user_dto.getId_usuario());
            ps.setString(2, instdDto.getId_instituto());
            ps.setString(3, dto.getT1_A_A_1());
            ps.setString(4, dto.getT1_A_H_1());
            ps.setString(5, dto.getT1_H1_A_1());
            ps.setString(6, dto.getT1_H1_H_1());
            ps.setString(7, dto.getT1_H3_A_1());
            ps.setString(8, dto.getT1_H3_H_1());
            ps.setString(9, dto.getT1_B_A_1());
            ps.setString(10, dto.getT1_B_H_1());
            ps.setString(11, dto.getT2_24_2());
            ps.setString(12, dto.getT2_H_M_2());
            ps.setString(13, dto.getT2_I_M_2());
            ps.setString(14, dto.getT2_C_UTI_2());
            ps.setString(15, dto.getT2_C_U_2());
            ps.setString(16, dto.getT3_DF_NA_3());
            ps.setString(17, dto.getT3_DF_PCR_3());
            ps.setString(18, dto.getT4_DF_A_4());
            ps.setString(19, dto.getT4_DF_H1_4());
            ps.setString(20, dto.getT4_DF_H3_4());
            ps.setString(21, dto.getT4_DF_B_4());
            ps.setString(22, dto.getT5_PS_A_A_5());
            ps.setString(23, dto.getT5_PS_A_H_5());
            ps.setString(24, dto.getT5_PS_H1_A_5());
            ps.setString(25, dto.getT5_PS_H1_H_5());
            ps.setString(26, dto.getT5_PS_H3_A_5());
            ps.setString(27, dto.getT5_PS_H3_H_5());
            ps.setString(28, dto.getT5_PS_B_A_5());
            ps.setString(29, dto.getT5_PS_B_H_5());
            ps.setString(30, dto.getT6_V_TRGB_6());
            ps.setString(31, dto.getT6_V_VAPS_6());
            ps.setString(32, dto.getT6_V_PSV_6());
            ps.setString(33, dto.getT6_V_VAP_6());
            ps.setString(34, dto.getT6_V_VAF_6());
            ps.setString(35, dto.getT7_OA_TP_A_7());
            ps.setString(36, dto.getT7_OA_TP_H_7());
            ps.setString(37, dto.getT7_OA_EI_A_7());
            ps.setDate(38, sqlDate);
            ps.setTime(39, time);
            ps.executeUpdate();

        }catch(SQLException e){
            System.err.println(""+e);
      
        }finally{
            cerrar(ps);
            cerrar(conn);
     
        }
    }
    
    public void showMessage(){
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,"Confirmación","Datos Guardados"));
    }
    
    private void cerrar(PreparedStatement ps) throws SQLException {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
			}
		}
	}
	
	private void cerrar(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
	}
	
	private void cerrar(Connection cnn) {
		if (cnn != null) {
			try {
				cnn.close();
			} catch (SQLException e) {
			}
		}
	}
}

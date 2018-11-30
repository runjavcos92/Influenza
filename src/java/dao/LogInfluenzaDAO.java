/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import conexion.conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dto.LogInfluenzaDTO;
import dto.institutoDTO;
import dto.usuarioDTO;
import java.sql.ResultSet;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;
import dto.AcuInfluenzaDTO;
import dto.HimAcuDTO;
import dto.IncanAcuDTO;

/**
 *
 * @author FRANCISCONAVA
 */
@Named(value = "logInfluenzaDAO")
@SessionScoped
public class LogInfluenzaDAO implements Serializable {

    /**
     * Creates a new instance of LogInfluenzaDAO
     */
    public LogInfluenzaDAO() {
    }
    
    private static final String SQL_SELECT = "SELECT TOP(1) T1_A_A,T1_A_H,T1_H1_A,T1_H1_H,T1_H3_A,T1_H3_H,T1_B_A,T1_B_H,"
                                           + "T2_24,T2_H_M,T2_I_M,T2_C_UTI,T2_C_U,"
                                           + "T3_DF_NA,T3_DF_PCR,"
                                           + "T4_DF_A,T4_DF_H1,T4_DF_H3,T4_DF_B,"
                                           + "T5_PS_A_A,T5_PS_A_H,T5_PS_H1_A,T5_PS_H1_H,T5_PS_H3_A,T5_PS_H3_H,T5_PS_B_A,T5_PS_B_H,"
                                           + "T6_V_TRGB,T6_V_VAPS,T6_V_PSV,T6_V_VAP,T6_V_VAF,"
                                           + "T7_OA_TP_A,T7_OA_TP_H,T7_OA_EI_A "
                                           + "FROM LOG_INFLUENZA "
                                           + "WHERE ID_INSTITUTO = ? "
                                           + "ORDER BY CAST(FECHA AS DATETIME) + CAST(TIEMPO AS DATETIME) DESC";
    
     private static final String SQL_SUMA = "SELECT TOP(1) (log_influenza.T1_A_A + log_influenza.T1_A_H) as S1_T1,"
                                           + "(log_influenza.T1_H1_A + log_influenza.T1_H1_h) as S2_T1,"
                                           + "(log_influenza.T1_H3_A + log_influenza.T1_H3_H) as S3_T1,"
                                           + "(log_influenza.T1_B_A + log_influenza.T1_B_H) as S4_T1,"
                                           + "(log_influenza.T4_DF_A + log_influenza.T4_DF_H1 + log_influenza.T4_DF_H3 + log_influenza.T4_DF_B) as S1_T4,"
                                           + "(log_influenza.T5_PS_A_A + log_influenza.T5_PS_A_H) as S1_T5,"
                                           + "(log_influenza.T5_PS_H1_A + log_influenza.T5_PS_H1_H) as S2_T5,"
                                           + "(log_influenza.T5_PS_H3_A + log_influenza.T5_PS_H3_H) as S3_T5,"
                                           + "(log_influenza.T5_PS_B_A + log_influenza.T5_PS_B_A) as S4_T5,"
                                           + "(log_influenza.T6_V_PSV + log_influenza.T6_V_TRGB + log_influenza.T6_V_VAF + log_influenza.T6_V_VAP + log_influenza.T6_V_VAPS) as S1_T6,"
                                           + "(log_influenza.T7_OA_TP_A + log_influenza.T7_OA_TP_H) as S1_T7 "             
                                           + "FROM LOG_INFLUENZA "
                                           + "WHERE ID_INSTITUTO = ? "
                                           + "ORDER BY CAST(FECHA AS DATETIME) + CAST(TIEMPO AS DATETIME) DESC";
     
    private static final String SQL_SELECT_HIM = "SELECT TOP(1) T1_A_A,T1_A_H,T1_H1_A,T1_H1_H,T1_H3_A,T1_H3_H,T1_B_A,T1_B_H,"
                                           + "T2_24,T2_H_M,T2_I_M,T2_C_UTI,T2_C_U,"
                                           + "T3_DF_NA,T3_DF_PCR,"
                                           + "T4_DF_A,T4_DF_H1,T4_DF_H3,T4_DF_B,"
                                           + "T5_PS_A_A,T5_PS_A_H,T5_PS_H1_A,T5_PS_H1_H,T5_PS_H3_A,T5_PS_H3_H,T5_PS_B_A,T5_PS_B_H,"
                                           + "T6_V_TRGB,T6_V_VAPS,T6_V_PSV,T6_V_VAP,T6_V_VAF,"
                                           + "T7_OA_TP_A,T7_OA_TP_H,T7_OA_EI_A "
                                           + "FROM LOG_INFLUENZA "
                                           + "WHERE ID_INSTITUTO = 1 "
                                           + "ORDER BY CAST(FECHA AS DATETIME) + CAST(TIEMPO AS DATETIME) DESC";
    
     private static final String SQL_SUMA_HIM = "SELECT TOP(1) (log_influenza.T1_A_A + log_influenza.T1_A_H) as S1_T1,"
                                           + "(log_influenza.T1_H1_A + log_influenza.T1_H1_h) as S2_T1,"
                                           + "(log_influenza.T1_H3_A + log_influenza.T1_H3_H) as S3_T1,"
                                           + "(log_influenza.T1_B_A + log_influenza.T1_B_H) as S4_T1,"
                                           + "(log_influenza.T4_DF_A + log_influenza.T4_DF_H1 + log_influenza.T4_DF_H3 + log_influenza.T4_DF_B) as S1_T4,"
                                           + "(log_influenza.T5_PS_A_A + log_influenza.T5_PS_A_H) as S1_T5,"
                                           + "(log_influenza.T5_PS_H1_A + log_influenza.T5_PS_H1_H) as S2_T5,"
                                           + "(log_influenza.T5_PS_H3_A + log_influenza.T5_PS_H3_H) as S3_T5,"
                                           + "(log_influenza.T5_PS_B_A + log_influenza.T5_PS_B_A) as S4_T5,"
                                           + "(log_influenza.T6_V_PSV + log_influenza.T6_V_TRGB + log_influenza.T6_V_VAF + log_influenza.T6_V_VAP + log_influenza.T6_V_VAPS) as S1_T6,"
                                           + "(log_influenza.T7_OA_TP_A + log_influenza.T7_OA_TP_H) as S1_T7 "             
                                           + "FROM LOG_INFLUENZA "
                                           + "WHERE ID_INSTITUTO = 1 "
                                           + "ORDER BY CAST(FECHA AS DATETIME) + CAST(TIEMPO AS DATETIME) DESC";
     

     private static final String SQL_DROP = "DROP table temp";
     
     private static final String SQL_INSERT = "INSERT INTO LOG_INFLUENZA (ID_USUARIO,ID_INSTITUTO,T1_A_A,T1_A_H,T1_H1_A,T1_H1_H,T1_H3_A,T1_H3_H,T1_B_A,"
                                           + "T1_B_H,T2_24,T2_H_M,T2_I_M,T2_C_UTI,T2_C_U,T3_DF_NA,T3_DF_PCR,T4_DF_A,T4_DF_H1,T4_DF_H3,T4_DF_B,T5_PS_A_A,"
                                           + "T5_PS_A_H,T5_PS_H1_A,T5_PS_H1_H,T5_PS_H3_A,T5_PS_H3_H,T5_PS_B_A,T5_PS_B_H,T6_V_TRGB,T6_V_VAPS,T6_V_PSV,"
                                           + "T6_V_VAP,T6_V_VAF,T7_OA_TP_A,T7_OA_TP_H,T7_OA_EI_A,FECHA,TIEMPO)"
                                            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
     
    
    @Inject
    private LogInfluenzaDTO dto;
    @Inject 
    private usuarioDTO user_dto;
    @Inject
    private institutoDTO instdDto;
    @Inject
    private AcuInfluenzaDTO acuDto;
    @Inject 
    private HimAcuDTO acuHim;
    
    public void load(String id_instituto)throws SQLException{
        conectar con = new conectar();
        Connection conn = con.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setString(1, id_instituto);
            rs = ps.executeQuery();
            java.util.List results = new ArrayList();
            while(rs.next()){
                //LogInfluenzaDTO logDto = new LogInfluenzaDTO();
                dto.setT1_A_A(rs.getString("T1_A_A"));
                dto.setT1_A_H(rs.getString("T1_A_H"));
                dto.setT1_H1_A(rs.getString("T1_H1_A"));
                dto.setT1_H1_H(rs.getString("T1_H1_H"));
                dto.setT1_H3_A(rs.getString("T1_H3_A"));
                dto.setT1_H3_H(rs.getString("T1_H3_H"));
                dto.setT1_B_A(rs.getString("T1_B_A"));
                dto.setT1_B_H(rs.getString("T1_B_H"));
                dto.setT2_24(rs.getString("T2_24"));
                dto.setT2_H_M(rs.getString("T2_H_M"));
                dto.setT2_I_M(rs.getString("T2_I_M"));
                dto.setT2_C_UTI(rs.getString("T2_C_UTI"));
                dto.setT2_C_U(rs.getString("T2_C_U"));
                dto.setT3_DF_NA(rs.getString("T3_DF_NA"));
                dto.setT3_DF_PCR(rs.getString("T3_DF_PCR"));
                dto.setT4_DF_A(rs.getString("T4_DF_A"));
                dto.setT4_DF_H1(rs.getString("T4_DF_H1"));
                dto.setT4_DF_H3(rs.getString("T4_DF_H3"));
                dto.setT4_DF_B(rs.getString("T4_DF_B"));
                dto.setT5_PS_A_A(rs.getString("T5_PS_A_A"));
                dto.setT5_PS_A_H(rs.getString("T5_PS_A_H"));
                dto.setT5_PS_H1_A(rs.getString("T5_PS_H1_A"));
                dto.setT5_PS_H1_H(rs.getString("T5_PS_H1_H"));
                dto.setT5_PS_H3_A(rs.getString("T5_PS_H3_A"));
                dto.setT5_PS_H3_H(rs.getString("T5_PS_H3_H"));
                dto.setT5_PS_B_A(rs.getString("T5_PS_B_A"));
                dto.setT5_PS_B_H(rs.getString("T5_PS_B_H"));
                dto.setT6_V_TRGB(rs.getString("T6_V_TRGB"));
                dto.setT6_V_VAPS(rs.getString("T6_V_VAPS"));
                dto.setT6_V_PSV(rs.getString("T6_V_PSV"));
                dto.setT6_V_VAP(rs.getString("T6_V_VAP"));
                dto.setT6_V_VAF(rs.getString("T6_V_VAF"));
                dto.setT7_OA_TP_A(rs.getString("T7_OA_TP_A"));
                dto.setT7_OA_TP_H(rs.getString("T7_OA_TP_H"));
                dto.setT7_OA_EI_A(rs.getString("T7_OA_EI_A"));
                results.add(dto);
            }
        }finally {
            cerrar(rs);
            cerrar(ps);
            cerrar(conn);
        }
    }
    
    public void loadSums(String id_instituto)throws SQLException{
        conectar con = new conectar();
        Connection conn = con.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement(SQL_SUMA);
            ps.setString(1, id_instituto);
            rs = ps.executeQuery();
            java.util.List results = new ArrayList();
            while(rs.next()){
                //LogInfluenzaDTO logDto = new LogInfluenzaDTO();
                dto.setSuma1(rs.getString("S1_T1"));
                dto.setSuma2(rs.getString("S2_T1"));
                dto.setSuma3(rs.getString("S3_T1"));
                dto.setSuma4(rs.getString("S4_T1"));
                dto.setSuma5(rs.getString("S1_T4"));
                dto.setSuma6(rs.getString("S1_T5"));
                dto.setSuma7(rs.getString("S2_T5"));
                dto.setSuma8(rs.getString("S3_T5"));
                dto.setSuma9(rs.getString("S4_T5"));
                dto.setSuma10(rs.getString("S1_T6"));
                dto.setSuma11(rs.getString("S1_T7"));
                results.add(dto);
            }
        }finally {
            cerrar(rs);
            cerrar(ps);
            cerrar(conn);
        }
    }
    
    public void loadHIM()throws SQLException{
        conectar con = new conectar();
        Connection conn = con.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement(SQL_SELECT_HIM);
            //ps.setString(1, id_instituto);
            rs = ps.executeQuery();
            java.util.List results = new ArrayList();
            while(rs.next()){
                //LogInfluenzaDTO logDto = new LogInfluenzaDTO();
                acuHim.setT1_A_A(rs.getString("T1_A_A"));
                acuHim.setT1_A_H(rs.getString("T1_A_H"));
                acuHim.setT1_H1_A(rs.getString("T1_H1_A"));
                acuHim.setT1_H1_H(rs.getString("T1_H1_H"));
                acuHim.setT1_H3_A(rs.getString("T1_H3_A"));
                acuHim.setT1_H3_H(rs.getString("T1_H3_H"));
                acuHim.setT1_B_A(rs.getString("T1_B_A"));
                acuHim.setT1_B_H(rs.getString("T1_B_H"));
                acuHim.setT2_24(rs.getString("T2_24"));
                acuHim.setT2_H_M(rs.getString("T2_H_M"));
                acuHim.setT2_I_M(rs.getString("T2_I_M"));
                acuHim.setT2_C_UTI(rs.getString("T2_C_UTI"));
                acuHim.setT2_C_U(rs.getString("T2_C_U"));
                acuHim.setT3_DF_NA(rs.getString("T3_DF_NA"));
                acuHim.setT3_DF_PCR(rs.getString("T3_DF_PCR"));
                acuHim.setT4_DF_A(rs.getString("T4_DF_A"));
                acuHim.setT4_DF_H1(rs.getString("T4_DF_H1"));
                acuHim.setT4_DF_H3(rs.getString("T4_DF_H3"));
                acuHim.setT4_DF_B(rs.getString("T4_DF_B"));
                acuHim.setT5_PS_A_A(rs.getString("T5_PS_A_A"));
                acuHim.setT5_PS_A_H(rs.getString("T5_PS_A_H"));
                acuHim.setT5_PS_H1_A(rs.getString("T5_PS_H1_A"));
                acuHim.setT5_PS_H1_H(rs.getString("T5_PS_H1_H"));
                acuHim.setT5_PS_H3_A(rs.getString("T5_PS_H3_A"));
                acuHim.setT5_PS_H3_H(rs.getString("T5_PS_H3_H"));
                acuHim.setT5_PS_B_A(rs.getString("T5_PS_B_A"));
                acuHim.setT5_PS_B_H(rs.getString("T5_PS_B_H"));
                acuHim.setT6_V_TRGB(rs.getString("T6_V_TRGB"));
                acuHim.setT6_V_VAPS(rs.getString("T6_V_VAPS"));
                acuHim.setT6_V_PSV(rs.getString("T6_V_PSV"));
                acuHim.setT6_V_VAP(rs.getString("T6_V_VAP"));
                acuHim.setT6_V_VAF(rs.getString("T6_V_VAF"));
                acuHim.setT7_OA_TP_A(rs.getString("T7_OA_TP_A"));
                acuHim.setT7_OA_TP_H(rs.getString("T7_OA_TP_H"));
                acuHim.setT7_OA_EI_A(rs.getString("T7_OA_EI_A"));
                results.add(acuHim);
            }
        }finally {
            cerrar(rs);
            cerrar(ps);
            cerrar(conn);
        }
    }
    
    public void loadSumsHIM()throws SQLException{
        conectar con = new conectar();
        Connection conn = con.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement(SQL_SUMA_HIM);
            //ps.setString(1, id_instituto);
            rs = ps.executeQuery();
            java.util.List results = new ArrayList();
            while(rs.next()){
                //LogInfluenzaDTO logDto = new LogInfluenzaDTO();
                acuHim.setSuma1(rs.getString("S1_T1"));
                acuHim.setSuma2(rs.getString("S2_T1"));
                acuHim.setSuma3(rs.getString("S3_T1"));
                acuHim.setSuma4(rs.getString("S4_T1"));
                acuHim.setSuma5(rs.getString("S1_T4"));
                acuHim.setSuma6(rs.getString("S1_T5"));
                acuHim.setSuma7(rs.getString("S2_T5"));
                acuHim.setSuma8(rs.getString("S3_T5"));
                acuHim.setSuma9(rs.getString("S4_T5"));
                acuHim.setSuma10(rs.getString("S1_T6"));
                acuHim.setSuma11(rs.getString("S1_T7"));
                results.add(acuHim);
            }
        }finally {
            cerrar(rs);
            cerrar(ps);
            cerrar(conn);
        }
    }
    
    
     public void loadAcu(String username)throws SQLException{
        conectar con = new conectar();
        Connection conn = con.conectar();
        PreparedStatement ps = null;
        java.sql.Statement st = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement("create table  "+username+"  (T1_A_A int ,T1_A_H int,T1_H1_A int,T1_H1_H int,T1_H3_A int,T1_H3_H int,T1_B_A int,T1_B_H int,T2_24 int,"+
						"			T2_H_M int,T2_I_M int,T2_C_UTI int,T2_C_U int,T3_DF_NA int,T3_DF_PCR int,"+
						"			T4_DF_A int,T4_DF_H1 int,T4_DF_H3 int,T4_DF_B int,"+
						"			T5_PS_A_A int,T5_PS_A_H int,T5_PS_H1_A int,T5_PS_H1_H int,T5_PS_H3_A int,T5_PS_H3_H int,T5_PS_B_A int,T5_PS_B_H int,"+
						"			T6_V_TRGB int,T6_V_VAPS int,T6_V_PSV int,T6_V_VAP int,T6_V_VAF int,T7_OA_TP_A int,T7_OA_TP_H int,T7_OA_EI_A int); "+					             
				
				"declare @cont int = 1;"+
				"while @cont < 26 "+
				"begin "+
					"INSERT INTO log_influenza "+
					"VALUES (1,@cont,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,'2017-11-12','12:15:20');"+
					
					  "insert into "+username+" (T1_A_A,T1_A_H,T1_H1_A,T1_H1_H,T1_H3_A,T1_H3_H,T1_B_A,T1_B_H,"+
										 "T2_24,T2_H_M,T2_I_M,T2_C_UTI,T2_C_U,"+
										 "T3_DF_NA,T3_DF_PCR,"+
										 "T4_DF_A,T4_DF_H1,T4_DF_H3,T4_DF_B,"+
										 "T5_PS_A_A,T5_PS_A_H,T5_PS_H1_A,T5_PS_H1_H,T5_PS_H3_A,T5_PS_H3_H,T5_PS_B_A,T5_PS_B_H,"+
										 "T6_V_TRGB,T6_V_VAPS,T6_V_PSV,T6_V_VAP,T6_V_VAF,"+
										 "T7_OA_TP_A,T7_OA_TP_H,T7_OA_EI_A) "+
					  "select top(1) T1_A_A,T1_A_H,T1_H1_A,T1_H1_H,T1_H3_A,T1_H3_H,T1_B_A,T1_B_H,"+
									"T2_24,T2_H_M,T2_I_M,T2_C_UTI,T2_C_U,"+
									"T3_DF_NA,T3_DF_PCR,"+
									"T4_DF_A,T4_DF_H1,T4_DF_H3,T4_DF_B,"+
									"T5_PS_A_A,T5_PS_A_H,T5_PS_H1_A,T5_PS_H1_H,T5_PS_H3_A,T5_PS_H3_H,T5_PS_B_A,T5_PS_B_H,"+
									"T6_V_TRGB,T6_V_VAPS,T6_V_PSV,T6_V_VAP,T6_V_VAF,"+
									"T7_OA_TP_A,T7_OA_TP_H,T7_OA_EI_A  "+
					  "from log_influenza "+
					  "where id_instituto = @cont "+
					  "ORDER BY CAST(FECHA AS DATETIME) + CAST(TIEMPO AS DATETIME) DESC "+
					  "SET @cont = @cont + 1; "+
                                          "end; ");
            ps.executeUpdate();
            /*java.util.List results = new ArrayList();
            */
        }catch(SQLException e){
                    System.err.println(""+e);}
        finally {
            cerrar(rs);
            cerrar(ps);
            cerrar(conn);
        }
     }
     
      public void loadAcu2(String username)throws SQLException{
        conectar con = new conectar();
        Connection conn = con.conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement("SELECT SUM(T1_A_A) as acu1,SUM(T1_A_H) as acu2,CAST(SUM(T1_H1_A)as INT) as acu3,CAST(SUM(T1_H1_H) as INT) as acu4,CAST(SUM(T1_H3_A) as INT)as acu5,CAST(SUM(T1_H3_H) as INT)as acu6,CAST(SUM(T1_B_A) as INT)as acu7,CAST(SUM(T1_B_H) as INT) as acu8,"
                                            + "CAST(SUM(T2_24)as INT) as acu9,CAST(SUM(T2_I_M) as INT) as acu10,CAST(SUM(T2_I_M)as INT) as acu11,CAST(SUM(T2_C_UTI) as INT) as acu12,CAST(SUM(T2_C_U) as INT) as acu13,"
                                            + "CAST(SUM(T3_DF_NA) as INT) as acu14,CAST(SUM(T3_DF_PCR) as INT) as acu15,"
                                            + "CAST(SUM(T4_DF_A) as INT) as acu16,CAST(SUM(T4_DF_H1) as INT) as acu17,CAST(SUM(T4_DF_H3) as INT) as acu18,CAST(SUM(T4_DF_B) as INT) as acu19,"
                                            + "CAST(SUM(T5_PS_A_A) as INT) as acu20,CAST(SUM(T5_PS_A_H) as INT) as acu21,CAST(SUM(T5_PS_H1_A) as INT) as acu22,CAST(SUM(T5_PS_H1_H) as INT) as acu23,CAST(SUM(T5_PS_H3_A) as INT) as acu24,CAST(SUM(T5_PS_H3_H) as INT) as acu25,CAST(SUM(T5_PS_B_A) as INT) as acu26,CAST(SUM(T5_PS_B_H) as INT) as acu27,"
                                            + "CAST(SUM(T6_V_TRGB) as INT) as acu28,CAST(SUM(T6_V_VAPS) as INT) as acu29,CAST(SUM(T6_V_PSV) as INT) as acu30,CAST(SUM(T6_V_VAP) as INT) as acu31,CAST(SUM(T6_V_VAF) as INT) as acu32,"
                                            + "CAST(SUM(T7_OA_TP_A) as INT) as acu33,CAST(SUM(T7_OA_TP_H) as INT) as acu34,CAST(SUM(T7_OA_EI_A) as INT) as acu35 "
                                            + "FROM "+username+";");
            
            rs = ps.executeQuery();
            java.util.List results = new ArrayList();
            while(rs.next()){
                acuDto.setT1_A_A(rs.getString("acu1"));
                acuDto.setT1_A_H(rs.getString("acu2"));
                acuDto.setT1_H1_A(rs.getString("acu3"));
                acuDto.setT1_H1_H(rs.getString("acu4"));
                acuDto.setT1_H3_A(rs.getString("acu5"));
                acuDto.setT1_H3_H(rs.getString("acu6"));
                acuDto.setT1_B_A(rs.getString("acu7"));
                acuDto.setT1_B_H(rs.getString("acu8"));
                acuDto.setT2_24(rs.getString("acu9"));
                acuDto.setT2_H_M(rs.getString("acu10"));
                acuDto.setT2_I_M(rs.getString("acu11"));
                acuDto.setT2_C_UTI(rs.getString("acu12"));
                acuDto.setT2_C_U(rs.getString("acu13"));
                acuDto.setT3_DF_NA(rs.getString("acu14"));
                acuDto.setT3_DF_PCR(rs.getString("acu15"));
                acuDto.setT4_DF_A(rs.getString("acu16"));
                acuDto.setT4_DF_H1(rs.getString("acu17"));
                acuDto.setT4_DF_H3(rs.getString("acu18"));
                acuDto.setT4_DF_B(rs.getString("acu19"));
                acuDto.setT5_PS_A_A(rs.getString("acu20"));
                acuDto.setT5_PS_A_H(rs.getString("acu21"));
                acuDto.setT5_PS_H1_A(rs.getString("acu22"));
                acuDto.setT5_PS_H1_H(rs.getString("acu23"));
                acuDto.setT5_PS_H3_A(rs.getString("acu24"));
                acuDto.setT5_PS_H3_H(rs.getString("acu25"));
                acuDto.setT5_PS_B_A(rs.getString("acu26"));
                acuDto.setT5_PS_B_H(rs.getString("acu27"));
                acuDto.setT6_V_TRGB(rs.getString("acu28"));
                acuDto.setT6_V_VAPS(rs.getString("acu29"));
                acuDto.setT6_V_PSV(rs.getString("acu30"));
                acuDto.setT6_V_VAP(rs.getString("acu31"));
                acuDto.setT6_V_VAF(rs.getString("acu32"));
                acuDto.setT7_OA_TP_A(rs.getString("acu33"));
                acuDto.setT7_OA_TP_H(rs.getString("acu34"));
                acuDto.setT7_OA_EI_A(rs.getString("acu35"));
                results.add(acuDto);
                acuDto.sumar();
            }
            }catch(SQLException e){
                    System.err.println(""+e);}
        finally {
            cerrar(rs);
            cerrar(ps);
            cerrar(conn);
        }
     }
      
     public void DropAcu(String username)throws SQLException{
        conectar con = new conectar();
        Connection conn = con.conectar();
        PreparedStatement ps = null;
        java.sql.Statement st = null;
        ResultSet rs = null;
        try{
            st = conn.createStatement();
            st.executeUpdate("DROP table "+username+"");
            /*java.util.List results = new ArrayList();
            */
        }catch(SQLException e){
                    System.err.println(""+e);}
        finally {
            cerrar(rs);
            cerrar(ps);
            cerrar(conn);
        }
     }
    
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
            ps.setString(3, dto.getT1_A_A());
            ps.setString(4, dto.getT1_A_H());
            ps.setString(5, dto.getT1_H1_A());
            ps.setString(6, dto.getT1_H1_H());
            ps.setString(7, dto.getT1_H3_A());
            ps.setString(8, dto.getT1_H3_H());
            ps.setString(9, dto.getT1_B_A());
            ps.setString(10, dto.getT1_B_H());
            ps.setString(11, dto.getT2_24());
            ps.setString(12, dto.getT2_H_M());
            ps.setString(13, dto.getT2_I_M());
            ps.setString(14, dto.getT2_C_UTI());
            ps.setString(15, dto.getT2_C_U());
            ps.setString(16, dto.getT3_DF_NA());
            ps.setString(17, dto.getT3_DF_PCR());
            ps.setString(18, dto.getT4_DF_A());
            ps.setString(19, dto.getT4_DF_H1());
            ps.setString(20, dto.getT4_DF_H3());
            ps.setString(21, dto.getT4_DF_B());
            ps.setString(22, dto.getT5_PS_A_A());
            ps.setString(23, dto.getT5_PS_A_H());
            ps.setString(24, dto.getT5_PS_H1_A());
            ps.setString(25, dto.getT5_PS_H1_H());
            ps.setString(26, dto.getT5_PS_H3_A());
            ps.setString(27, dto.getT5_PS_H3_H());
            ps.setString(28, dto.getT5_PS_B_A());
            ps.setString(29, dto.getT5_PS_B_H());
            ps.setString(30, dto.getT6_V_TRGB());
            ps.setString(31, dto.getT6_V_VAPS());
            ps.setString(32, dto.getT6_V_PSV());
            ps.setString(33, dto.getT6_V_VAP());
            ps.setString(34, dto.getT6_V_VAF());
            ps.setString(35, dto.getT7_OA_TP_A());
            ps.setString(36, dto.getT7_OA_TP_H());
            ps.setString(37, dto.getT7_OA_EI_A());
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
    
    public void insertarValoresIniciales(String id_instituto) throws SQLException{
        PreparedStatement ps = null;
        conectar con = new conectar();
        Connection conn = null;
        conn = con. conectar();  
        try{
            java.sql.Date sqlDate = java.sql.Date.valueOf(ldt.toLocalDate());
            java.sql.Time time = java.sql.Time.valueOf(ldt.toLocalTime());
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, user_dto.getId_usuario());
            ps.setString(2, id_instituto);
            ps.setString(3, "0");
            ps.setString(4, "0");
            ps.setString(5, "0");
            ps.setString(6, "0");
            ps.setString(7, "0");
            ps.setString(8, "0");
            ps.setString(9, "0");
            ps.setString(10, "0");
            ps.setString(11, "0");
            ps.setString(12, "0");
            ps.setString(13, "0");
            ps.setString(14, "0");
            ps.setString(15, "0");
            ps.setString(16, "0");
            ps.setString(17, "0");
            ps.setString(18, "0");
            ps.setString(19, "0");
            ps.setString(20, "0");
            ps.setString(21, "0");
            ps.setString(22, "0");
            ps.setString(23, "0");
            ps.setString(24, "0");
            ps.setString(25, "0");
            ps.setString(26, "0");
            ps.setString(27, "0");
            ps.setString(28, "0");
            ps.setString(29, "0");
            ps.setString(30, "0");
            ps.setString(31, "0");
            ps.setString(32, "0");
            ps.setString(33, "0");
            ps.setString(34, "0");
            ps.setString(35, "0");
            ps.setString(36, "0");
            ps.setString(37, "0");
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

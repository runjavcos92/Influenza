/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dto.institutoDTO;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import dto.InstitutoBean;

/**
 *
 * @author FRANCISCONAVA
 */

@Named(value = "InstitutoDAO")
@SessionScoped
public class institutoDAO implements Serializable{
    private static final String SQL_INSERT
		= "INSERT INTO INSTITUTO("
		+ "NOMBRE"
		+ ")VALUES(?)";
	private static final String SQL_SELECT_WHEN
		= "SELECT * "
		+ " FROM INSTITUTO WHERE "
		+ "ID_INSTITUTO=? OR "
		+ "NOMBRE=?";
	private static final String SQL_SELECT
		= "SELECT NOMBRE "
		+ " FROM INSTITUTO WHERE ID_INSTITUTO=?";
	private static final String SQL_SELECT_ALL
		= "SELECT * "
		+ "FROM INSTITUTO";
	private static final String SQL_UPDATE
		= "UPDATE INSTITUTO SET "
		+ "NOMBRE=?"
		+ " WHERE "
		+ " ID_INSTITUTO=?";
	private static final String SQL_DELETE
		= "DELETE FROM INSTITUTO WHERE "
		+ "ID_INSTITUTO=?";
	
	public void create(institutoDTO dto, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(SQL_INSERT);
			ps.setString(1, dto.getNombre());
			ps.executeUpdate();
		} finally {
			cerrar(ps);
			cerrar(conn);
		}
	}
        
        /*public void queryInstituto(String user) throws SQLException{
                Connection con = null;
		PreparedStatement ps = null;
                conectar conexion = new conectar();
                con = conexion.conectar();
                String instituto;
                institutoDTO dto = new institutoDTO();
                try{
                    ps = con.prepareStatement("SELECT NOMBRE "
                                            + "FROM INSTITUTO "
                                            + "INNER JOIN USUARIO ON USUARIO.ID_INSTITUTO = INSTITUTO.ID_INSTITUTO "
                                            + "WHERE USUARIO = ?");
                    ps.setString(1, user);
                    ResultSet rs = ps.executeQuery();
                  
                    if (rs.next()){
                        instituto = rs.getString(1);
                        dto.setNombre(instituto);
                    }   
                }catch(SQLException ex){
                    System.out.println("Login error -->" + ex.getMessage());
                } finally{
                    cerrar(ps);
                    cerrar(con);
                }     
        }*/
	
	public institutoDTO load(institutoDTO dto, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_SELECT);
			ps.setString(1, dto.getId_instituto());
			rs = ps.executeQuery();
			List results = getResults(rs);
			if (results.size() > 0) {
				return (institutoDTO) results.get(0);
			} else {
				return null;
			}
		} finally {
			cerrar(rs);
			cerrar(ps);
			cerrar(conn);
		}
	}
	
	public List<InstitutoBean> loadAll() throws SQLException {
		conectar con = new conectar();
                Connection conn = con.conectar();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_SELECT_ALL);
			rs = ps.executeQuery();
			List results = getResults(rs);
			if (results.size() > 0) {
				return results;
			} else {
				return null;
			}
		} finally {
			cerrar(rs);
			cerrar(ps);
			cerrar(conn);
		}
	}
	
	public List loadSelect(institutoDTO dto, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_SELECT_WHEN);
			ps.setString(1, dto.getId_instituto());
			ps.setString(2, dto.getNombre());
			rs = ps.executeQuery();
			List results = getResults(rs);
			if (results.size() > 0) {
				return results;
			} else {
				return null;
			}
		} finally {
			cerrar(rs);
			cerrar(ps);
			cerrar(conn);
		}
	}
	
	public void update(institutoDTO dto, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(SQL_UPDATE);
			ps.setString(1, dto.getNombre());
			ps.setString(2, dto.getId_instituto());
			ps.executeUpdate();
		} finally {
			cerrar(ps);
			cerrar(conn);
		}
	}
	
	public void delete(institutoDTO dto, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(SQL_DELETE);
			ps.setString(1, dto.getId_instituto());
			ps.executeUpdate();
		} finally {
			cerrar(ps);
			cerrar(conn);
		}
	}
	
	private List getResults(ResultSet rs) throws SQLException {
		List results = new ArrayList();
		while (rs.next()) {
			InstitutoBean dto = new InstitutoBean();
			dto.setId_instituto(rs.getString("ID_INSTITUTO"));
			dto.setNombre(rs.getString("NOMBRE"));
			results.add(dto);
		}
		return results;
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

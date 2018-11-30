/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.conectar;
import dto.RolDTO;
import dto.RolDTOUpdate;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FRANCISCONAVA
 */
@Named(value = "rolDAO")
@SessionScoped
public class RolDAO implements Serializable {

    /**
     * Creates a new instance of RolDAO
     */
    public RolDAO() {
    }
    
    private final String SQL_SELECT_ALL = "SELECT * FROM ROL WHERE ROL='CAPTURAR' OR ROL='VISUALIZAR';";
    private final String SQL_SELECT_ALLSA = "SELECT * FROM ROL;";
    
    public List<RolDTO> loadAll() throws SQLException {
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
    
    public List<RolDTO> loadAllSA() throws SQLException {
                conectar con = new conectar();
                Connection conn = con.conectar();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_SELECT_ALLSA);
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
    
    public List<RolDTOUpdate> loadAllUpdate() throws SQLException {
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
    
    private List getResults(ResultSet rs) throws SQLException {
		List results = new ArrayList();
		while (rs.next()) {
			RolDTO dto = new RolDTO();
			dto.setIdRol(rs.getString("ID_ROL"));
			dto.setRol(rs.getString("ROL"));
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

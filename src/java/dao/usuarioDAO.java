/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dto.usuarioDTO;
import conexion.conectar;
import dto.UserBeanUpdate;
import dto.userBean;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import dto.Usuario;
/**
 *
 * @author FRANCISCONAVA
 */
@Named(value = "UsuarioDAO")
@SessionScoped
public class usuarioDAO implements Serializable{
    
    private static final String SQL_INSERT
		= "INSERT INTO USUARIO("
		+ "USUARIO,CONTRASEÑA,ID_ROL,ID_INSTITUTO,NOMBRE_PERSONAL"
		+ ")VALUES(?,?,?,?,?)";
	private static final String SQL_SELECT_WHEN
		= "SELECT * "
		+ " FROM USUARIO WHERE"
		+ " ID_INSTITUTO=?";
        private static final String SQL_SELECT_ADMIN
		= "SELECT * "
		+ " FROM USUARIO WHERE"
		+ " ID_ROL=?";
	private static final String SQL_SELECT
		= "SELECT ID_USUARIO "
		+ " FROM USUARIO WHERE USUARIO=?";
	private static final String SQL_SELECT_ALL
		= "SELECT * "
		+ " FROM USUARIO";
	private static final String SQL_UPDATE
		= "UPDATE USUARIO SET "
		+ "NOMBRE_PERSONAL=?,USUARIO=?,CONTRASEÑA=?"
		+ " WHERE "
		+ " ID_USUARIO=?";
	private static final String SQL_DELETE
		= "DELETE FROM USUARIO WHERE "
		+ "ID_USUARIO=?";
        private static final String SQL_SELECT_UPDATE 
                = "SELECT USUARIO,CONTRASEÑA,NOMBRE_PERSONAL FROM USUARIO WHERE ID_USUARIO=?";
        private static final String SQL_SELECT_USER_TABLE
                = "SELECT nombre_personal,usuario,rol " 
                + "from usuario "
                + "inner join rol on usuario.id_rol = rol.id_rol "
                + "where id_instituto = ?";
        private usuarioDTO userdto;
        @Inject
        private userBean dto;
        @Inject
        private UserBeanUpdate userB;
        @Inject
        private LogInfluenzaDAO logDao;
        @Inject
        private Usuario setTable;
        
    public void create(userBean dto, String id_rol, String id_instituto) throws SQLException {
                        conectar con = new conectar();
                        Connection conn = null;
                        conn = con. conectar();
                        PreparedStatement ps = null;
                        try {
                                ps = conn.prepareStatement(SQL_INSERT);
                                ps.setString(1, dto.getUsuarioCreate());
                                ps.setString(2, dto.getContraseñaCreate());
                                ps.setString(3, id_rol);
                                ps.setString(4, id_instituto);
                                ps.setString(5, dto.getNombreCreate());
                                ps.executeUpdate();
                                logDao.insertarValoresIniciales(id_instituto);
                        } finally {
                                cerrar(ps);
                                cerrar(conn);
                        }
	}
	
    public void createNoAdmin(userBean dto, String id_rol, String id_instituto) throws SQLException {
                        conectar con = new conectar();
                        Connection conn = null;
                        conn = con. conectar();
                        PreparedStatement ps = null;
                        try {
                                ps = conn.prepareStatement(SQL_INSERT);
                                ps.setString(1, dto.getUsuarioCreate());
                                ps.setString(2, dto.getContraseñaCreate());
                                ps.setString(3, id_rol);
                                ps.setString(4, id_instituto);
                                ps.setString(5, dto.getNombreCreate());
                                ps.executeUpdate();
                        } finally {
                                cerrar(ps);
                                cerrar(conn);
                        }
	}
    
	public void load(String usernombre) throws SQLException {
                PreparedStatement ps = null;
                conectar con = new conectar();
                Connection conn = null;
                conn = con. conectar(); 
		ResultSet rs = null;
                String iduser = null;
		try {
			ps = conn.prepareStatement(SQL_SELECT);
			ps.setString(1, usernombre);
			rs = ps.executeQuery();
                        if (rs.next()){
                        iduser = rs.getString(1);
                        }
                       } catch(SQLException ex){
                    System.out.println("Login error -->" + ex.getMessage());
		} finally {
			cerrar(rs);
			cerrar(ps);
			cerrar(conn);
		}
                 userdto.setId_usuario(iduser);
	}
        
        public static boolean validarSesion(String usuario, String contraseña) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
                conectar conexion = new conectar();
                con = conexion.conectar();
		try {
			ps = con.prepareStatement("Select usuario, contraseña "
                                                + "from usuario where usuario = ? and contraseña = ?");
			ps.setString(1, usuario);
			ps.setString(2, contraseña);
                       
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
                        con.close();       
		}
		return false;
	}
        
        public void mensajes(){
            RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,"Confirmación","Usuario Creado!"));
           // dto.setNombreCreate(null);
            //dto.setUsuarioCreate(null);
            //dto.setContraseñaCreate(null);
            
        }
        
        public static String validarRol(String usuario) throws SQLException{
                Connection con = null;
		PreparedStatement ps = null;
                conectar conexion = new conectar();
                con = conexion.conectar();
                String id_rol = null;
                try {
			ps = con.prepareStatement("Select id_rol "
                                                + "from usuario where usuario = ?");
			ps.setString(1, usuario);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				//result found, means valid inputs
				 id_rol = rs.getString(1);
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
		} finally {
                        con.close();       
		}
		return id_rol;
        }
	
	public List<userBean> loadAll(String id_instituto) throws SQLException {
                conectar con = new conectar();
                Connection conn = con.conectar();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_SELECT_WHEN);
                        ps.setString(1, id_instituto);
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
        
        public List<UserBeanUpdate> loadAllUsers() throws SQLException {
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
        
        
        
        public List<UserBeanUpdate> loadAllU(String id_instituto) throws SQLException {
                conectar con = new conectar();
                Connection conn = con.conectar();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_SELECT_WHEN);
                        ps.setString(1, id_instituto);
			rs = ps.executeQuery();
			List results = getResultsU(rs);
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
        
        public List<Usuario> loadTable(String id_instituto) throws SQLException {
                conectar con = new conectar();
                Connection conn = con.conectar();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_SELECT_USER_TABLE);
                        ps.setString(1, id_instituto);
			rs = ps.executeQuery();
			List results = getResultsT(rs);
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
        
        public List<UserBeanUpdate> loadAdmins(String id_instituto) throws SQLException {
                conectar con = new conectar();
                Connection conn = con.conectar();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_SELECT_ADMIN);
                        ps.setString(1, id_instituto);
			rs = ps.executeQuery();
			List results = getResultsU(rs);
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
	
	
	public List<userBean> loadSelect(String id_instituto) throws SQLException {
                conectar con = new conectar();
                Connection conn = con.conectar();
		PreparedStatement ps = null;
		ResultSet rs = null;
    
		try {
			ps = conn.prepareStatement(SQL_SELECT_WHEN);
			//ps.setString(1, id_instituto);
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
	
        
        
	public void update(String id_usuario,UserBeanUpdate dtoU) throws SQLException {
                conectar con = new conectar();
                Connection conn = con.conectar();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(SQL_UPDATE);
                        ps.setString(1, dtoU.getNombre());
			ps.setString(2, dtoU.getUsuario());
			ps.setString(3, dtoU.getContraseña());
                        ps.setString(4, id_usuario);
			ps.executeUpdate();
                        //System.out.println(" -"+id_usuario+""+dto.getNombreUpdate());
		} finally {
			cerrar(ps);
			cerrar(conn);
		}
	}
	
        
        
        
        public boolean existeIdUsuario(String id_usuario) throws SQLException{
                boolean idResult = false;
                conectar con = new conectar();
                Connection conn = con.conectar();
		PreparedStatement ps = null;
                ResultSet rs = null;
                try{
                    ps = conn.prepareStatement(SQL_SELECT_UPDATE);
                    ps.setString(1, id_usuario);
                    rs = ps.executeQuery();
                    if (rs.next()){
                        idResult = true;
                        }
                }
                 finally {
			cerrar(rs);
			cerrar(ps);
			cerrar(conn);
		}
                return idResult;
        }
        
	public void delete(String id_user) throws SQLException {
                conectar con = new conectar();
                Connection conn = con.conectar();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(SQL_DELETE);
			ps.setString(1, id_user);
			ps.executeUpdate();
		} finally {
			cerrar(ps);
			cerrar(conn);
		}
	}
	
	private List getResults(ResultSet rs) throws SQLException {
		List results = new ArrayList();
		while (rs.next()) {
			userBean userB = new userBean();
			userB.setId_usuario(rs.getString("ID_USUARIO"));
			userB.setUsuario(rs.getString("USUARIO"));
			userB.setContraseña(rs.getString("CONTRASEÑA"));
			userB.setId_rol(rs.getString("ID_ROL"));
			userB.setId_instituto(rs.getString("ID_INSTITUTO"));
			results.add(userB);
		}
		return results;
	}
        
        private List getResultsU(ResultSet rs) throws SQLException {
		List results = new ArrayList();
		while (rs.next()) {
			UserBeanUpdate userUpdate = new UserBeanUpdate();
			userUpdate.setId_usuario(rs.getString("ID_USUARIO"));
			userUpdate.setUsuario(rs.getString("USUARIO"));
			userUpdate.setContraseña(rs.getString("CONTRASEÑA"));
			userUpdate.setId_rol(rs.getString("ID_ROL"));
			userUpdate.setId_instituto(rs.getString("ID_INSTITUTO"));
			results.add(userUpdate);
		}
		return results;
	}
        
        private List getResultsT(ResultSet rs) throws SQLException {
		List results = new ArrayList();
		while (rs.next()) {
			Usuario user = new Usuario();
			user.setNombre_usuario(rs.getString("USUARIO"));
			user.setNombre_personal(rs.getString("NOMBRE_PERSONAL"));
			user.setPrivilegio(rs.getString("ROL"));
			results.add(user);
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

    private void mensajesError() {
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Verifica los datos"));
    }
}

package tienda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {
    protected Connection conexion = null;
    protected Statement sentencia = null;
    protected ResultSet resultado = null;
    
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    
    protected void conectarBase() throws ClassNotFoundException, SQLException{
        try{
            Class.forName(DRIVER);
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
        }catch(ClassNotFoundException | SQLException ex){
            throw ex;
        }
    }
    
    protected void desconectarBase() throws SQLException {
        try{
            if(conexion != null){
                conexion.close();
            }
            
            if(sentencia != null){
                sentencia.close();
            }
            
            if(resultado != null){
                resultado.close();
            }
        }catch(SQLException e){
            throw e;
        }
    }
    
    protected void insertarModificarEliminar(String sentenciaSQL) throws ClassNotFoundException, SQLException{
        try{
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sentenciaSQL);
            
        }catch(ClassNotFoundException | SQLException ex){
            throw ex;
        }finally{
            desconectarBase();
        }
    }
    
    protected void consultas(String sentenciaSQL) throws Exception{
        try{
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sentenciaSQL);
            
        }catch(Exception ex){
            throw ex;
        }
    }
}

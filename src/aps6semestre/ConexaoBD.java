
package aps6semestre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBD {
    
    private Connection conexion;
    private Statement statement;   

    public ConexaoBD() {
    }        
    
    public void conectar(){
        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:aps6.db");
            statement = conexion.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {           
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet CONSULTAR(String sql) throws SQLException{
        System.out.println(sql);
        return statement.executeQuery(sql);
    }
    
    public int GUARDAR(String sql) throws SQLException{
        int n = statement.executeUpdate(sql);
        return n;
    }
    
    public void CERRAR(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }
}

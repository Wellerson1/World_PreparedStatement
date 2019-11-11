
package aps_word;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Conexao {
 
    private String driver = "com.mysql.jdbc.Driver";
    private String URL = "jdbc:mysql://localhost:3306/world";
    private String USER = "root";
    private String SENHA ="";
    private Connection conn;
 
    public Conexao() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(URL, USER, SENHA);
        } catch (SQLException | ClassNotFoundException e) {
            throw e;
        }
    }
 
    public Connection getConn() {
        return conn;
    }
 
    public void fecharConexao() throws SQLException {
        try {
            conn.close();
        } catch (SQLException e) {
            throw e;
        }
    }
    public ResultSet listar(String queryStr) throws SQLException{
        try{
            PreparedStatement pstmt = conn.prepareStatement(queryStr);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        }catch (SQLException e) {
            throw e;
        }
    }
      public ResultSet listarNome(String nome, String queryStr) throws SQLException{
        try{
            PreparedStatement pstmt = conn.prepareStatement(queryStr);
            pstmt.setString(1,  "%" + nome + "%");
            
            ResultSet rs = pstmt.executeQuery();
            return rs;
        }catch (SQLException e) {
            throw e;
        }
    }
}

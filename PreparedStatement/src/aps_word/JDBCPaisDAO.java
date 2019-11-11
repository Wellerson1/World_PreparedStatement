
package aps_word;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class JDBCPaisDAO implements PaisDAO {
 
    private Conexao conexao;
    private Statement stmt;
    
    public JDBCPaisDAO() throws SQLException, ClassNotFoundException {
        conexao = new Conexao();
        try {
            stmt = (Statement) conexao.getConn().createStatement();
        } catch (SQLException ex) {
            throw ex;
        }
    }
 
    @Override
    
    public List<Pais> listar() throws SQLException {
        
        
        List<Pais> pais = new ArrayList<Pais>();
        try {
            String queryStr = "SELECT * FROM Country ORDER BY nome";
            ResultSet rs = conexao.listar(queryStr);
                   
            while (rs.next()) {
                Pais cliente = new Pais();
                cliente.setNome(rs.getString("nome"));
                cliente.setCode(rs.getString("code"));
                pais.add(cliente);
            }
         } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return pais;
    }

    public List<Pais> listarNome(String nome) throws SQLException {
        List<Pais> pais = new ArrayList<Pais>();
        try {
            String queryStr = "SELECT * FROM Country WHERE code like ?";
            ResultSet rs = conexao.listarNome(nome, queryStr);
                        
            while (rs.next()) {
                Pais cliente = new Pais();
                cliente.setNome(rs.getString("name"));
                cliente.setCode(rs.getString("code"));
                cliente.setContinente(rs.getString("continent"));
                pais.add(cliente);
            }
         } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }
        return pais;
    }
}


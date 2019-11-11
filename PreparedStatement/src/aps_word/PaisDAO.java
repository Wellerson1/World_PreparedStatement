
package aps_word;
import java.sql.SQLException;
import java.util.List;


public interface PaisDAO {
    public List<Pais> listarNome(String nome) throws SQLException;
    public List<Pais> listar() throws SQLException;
}
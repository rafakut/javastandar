package dario.java.std.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface LugarDAO {
    
    void grabar(Connection connection , Lugar lugar) throws SQLException;
    List<Lugar> obtenerTodos(Connection connection) throws SQLException;
    void actualizar(Connection connection,Lugar lugar) throws SQLException;
    void borrar(Connection connection, Lugar lugar) throws SQLException;
    Lugar buscarPorId (Connection connection, int id) throws SQLException;
        
}

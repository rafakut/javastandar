package dario.java.std.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LugarDAOImpl implements LugarDAO {

    @Override
    public void grabar(Connection connection, Lugar lugar) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("insert into lugar (id, NombreResponsable, Direccion, Router) values (?, ?,?,?) ");
        stmt.setInt(1, lugar.getId());
        stmt.setString(2, lugar.getNombreResponsable());
        stmt.setString(3, lugar.getDireccion());
        stmt.setString(4, lugar.getRouter());
        stmt.executeUpdate();
    }

    @Override
    public List<Lugar> obtenerTodos(Connection connection) throws SQLException {
        List<Lugar> lugares = new ArrayList();
        Statement smtm = connection.createStatement();

        ResultSet result = smtm.executeQuery("select * from lugar");

        while (result.next()) {
            int id = result.getInt("id");
            String nombreResponsable = result.getString("NombreResponsable");
            String direccion = result.getString("direccion");
            String router = result.getString("Router");
            lugares.add(new Lugar(id, nombreResponsable, direccion, router));
        }
        
        return lugares;
    }

    @Override
     public void actualizar(Connection connection, Lugar lugar) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement("update  lugar set (NombreResponsable ='´?', Direccion='?', Router='?') where id=?");
        
        
        stmt.setString(1, lugar.getNombreResponsable());
        stmt.setString(2, lugar.getDireccion());
        stmt.setString(3, lugar.getRouter());
        stmt.setInt(4,lugar.getId ());
        stmt.executeUpdate();
    }

    @Override
    public void borrar(Connection connection, Lugar lugar)  throws SQLException {
    PreparedStatement stmt = connection.prepareStatement("delete  lugar where id=?");
    stmt.setInt(1,lugar.getId ());
    stmt.executeUpdate();
    }

    @Override
    public Lugar buscarPorId(Connection connection, int id)throws SQLException {
        Lugar lugar = null;
            
        PreparedStatement smtm = connection.prepareStatement("select * from lugar where id=?");
        smtm.setInt(1, id);
        ResultSet result = smtm.executeQuery();

        if ( result.next()) {
            String nombreResponsable = result.getString("NombreResponsable");
            String direccion = result.getString("direccion");
            String router = result.getString("Router");
            lugar = new Lugar(id, nombreResponsable, direccion, router);
        }
        
        return lugar;
    }

}

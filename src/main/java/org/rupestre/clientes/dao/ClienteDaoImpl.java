package org.rupestre.clientes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.rupestre.clientes.bean.Cliente;
import org.rupestre.clientes.conexion.Conexion;

public class ClienteDaoImpl implements ClienteDao {

	private Connection conn;

	public ClienteDaoImpl() {
		conn = Conexion.getCoonection();
	}

	public void addCliente(Cliente cliente) {
		String sql = "INSERT INTO Cliente (nombre, apellido_paterno) values (?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellidoPaterno());

			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("::: Fallo al insertar");
			e.printStackTrace();
		}
	}

	public void removeCliente(int id) {
		String sql = "DELETE FROM Cliente WHERE id_cliente = ? ";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void editCliente(Cliente cliente) {

		String sql = "UPDATE Cliente set nombre=?, apellido_paterno = ? where id_cliente=?";

		try {
			PreparedStatement pt = conn.prepareStatement(sql);
			pt.setString(1, cliente.getNombre());
			pt.setString(2, cliente.getApellidoPaterno());
			pt.setInt(3, cliente.getId_cliente());
			pt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Cliente> getAllClientes(){		
		List<Cliente> clientes = new ArrayList<>();
		
		String sql = "SELECT * FROM Cliente";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Cliente cliente = new Cliente();
				cliente.setId_cliente(rs.getInt("id_cliente"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellidoPaterno(rs.getString("apellido_paterno"));
				clientes.add(cliente);
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clientes;
	}
	
	public Cliente getClienteById(int clienteId){
		Cliente cliente = new Cliente();
		
		String sql = "SELECT * FROM Cliente WHERE id_cliente = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, clienteId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				cliente.setId_cliente(rs.getInt("id_cliente"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellidoPaterno(rs.getString("apellido_paterno"));
				cliente.setApellidoMaterno(rs.getString("apellido_materno"));
				cliente.setEmail(rs.getString("email"));
				cliente.setTelefono(rs.getString("telefono"));
				
			}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	
	

}

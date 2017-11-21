package org.rupestre.clientes.dao;

import java.util.List;

import org.rupestre.clientes.bean.Cliente;

public interface ClienteDao {
	
	public void addCliente(Cliente cliente);
	
	public void removeCliente(int id);
	
	public void editCliente(Cliente cliente);
	
	public List<Cliente> getAllClientes();
	
	public Cliente getClienteById(int clienteId);

}

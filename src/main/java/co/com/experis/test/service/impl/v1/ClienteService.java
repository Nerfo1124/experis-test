package co.com.experis.test.service.impl.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.experis.test.domain.request.CrearClienteRequest;
import co.com.experis.test.model.entities.Cliente;
import co.com.experis.test.model.repositories.ClienteRepository;
import co.com.experis.test.service.v1.IClienteService;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private ClienteRepository clienteDB;
	
	@Override
	public Long crearCliente(CrearClienteRequest request) {
		Cliente cliente = new Cliente();
		cliente.setNombre(request.getNombre());
		cliente = clienteDB.save(cliente);
		return cliente.getId();
	}

}

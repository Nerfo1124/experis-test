package co.com.experis.test.model.repositories;

import org.springframework.data.repository.CrudRepository;

import co.com.experis.test.model.entities.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{

}

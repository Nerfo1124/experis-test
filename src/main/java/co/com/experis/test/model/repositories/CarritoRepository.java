package co.com.experis.test.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.com.experis.test.model.entities.Carrito;

public interface CarritoRepository extends JpaRepository<Carrito, Long>{
	
//	List<Carrito> (Long idCliente);

	@Query(value = "SELECT id_producto FROM CARRITO WHERE id_cliente = ?1", nativeQuery = true)
	List<Long> findAllByIdClient(Long idClient);

	@Query(value = "INSERT INTO carrito (id_cliente, id_producto, cantidad) VALUES (?1,?2,?3)", nativeQuery = true)
	void saveProducto(Long idClient, Long idProducto, Integer cantidad);
}

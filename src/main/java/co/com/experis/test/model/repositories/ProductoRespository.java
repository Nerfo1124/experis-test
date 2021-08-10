package co.com.experis.test.model.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import co.com.experis.test.model.entities.Producto;

public interface ProductoRespository extends PagingAndSortingRepository<Producto, Long>{

	List<Producto>findByNombre(String nombre, Pageable pageable);
}

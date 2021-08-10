package co.com.experis.test.batch.processors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import co.com.experis.test.model.entities.Producto;

public class ProductoItemProccesor implements ItemProcessor<Producto, Producto> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductoItemProccesor.class);

	@Override
	public Producto process(Producto item) throws Exception {
		String nombreProducto = item.getNombre().toUpperCase();
		String marcaProducto = item.getMarca().toUpperCase();
		Long precioProducto = item.getPrecio();
		Integer cantidadProducto = item.getCantidad();
		String estadoProducto = item.getEstado().toUpperCase();
		Integer procDescProducto = item.getPorcDescuento();

		Producto processProducto = new Producto(null, nombreProducto, marcaProducto, precioProducto, cantidadProducto,
				estadoProducto, procDescProducto);
		LOGGER.info(String.format("Convirtiendo [%s] a [%s]", item.toString(), processProducto.toString()));
		return processProducto;
	}

}

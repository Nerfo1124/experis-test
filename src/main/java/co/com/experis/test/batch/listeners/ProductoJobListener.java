package co.com.experis.test.batch.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import co.com.experis.test.model.entities.Producto;

@Component
public class ProductoJobListener extends JobExecutionListenerSupport {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductoJobListener.class);

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public ProductoJobListener(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			LOGGER.info("FINALIZÓ EL JOB!! Verifica los resultado!");
			jdbcTemplate
					.query("SELECT id, nombre, marca, precio, cantidad, estado, porc_descuento FROM producto",
							(rs, row) -> new Producto(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getInt(5),
									rs.getString(6), rs.getInt(7)))
					.forEach(producto -> LOGGER.info(String.format("Registro <%s>", producto)));
		}
	}
}

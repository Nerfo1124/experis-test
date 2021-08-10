package co.com.experis.test.configuration;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import co.com.experis.test.batch.listeners.ProductoJobListener;
import co.com.experis.test.batch.processors.ProductoItemProccesor;
import co.com.experis.test.model.entities.Producto;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BatchConfiguration.class);
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public FlatFileItemReader<Producto> readerProducto() {
		LOGGER.info("Inicializando Reader...");
		return new FlatFileItemReaderBuilder<Producto>()
				   .name("personaItemReader")
				   .resource(new ClassPathResource("Productos.csv"))
				   .delimited()
				   .names(new String[] {"nombre","marca","precio","cantidad","estado","porcDescuento"})
				   .fieldSetMapper(new BeanWrapperFieldSetMapper<Producto>() {{
					   setTargetType(Producto.class);
				   }})
				   .build();
	}
	
	@Bean
	public ProductoItemProccesor processorProducto() {
		LOGGER.info("Inicializando Processor...");
		return new ProductoItemProccesor();
	}
	
	@Bean
	public JdbcBatchItemWriter<Producto> writerProducto(DataSource dataSource) {
		LOGGER.info("Inicializando Writer...");
		return new JdbcBatchItemWriterBuilder<Producto>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO producto (nombre, marca, precio, cantidad, estado, porc_descuento) VALUES (:nombre, :marca, :precio, :cantidad, :estado, :porcDescuento)")
				.dataSource(dataSource)
				.build();
	}
	
	@Bean
	public Job importProductoJob(ProductoJobListener listener, Step step) {
		LOGGER.info("Inicializando Job...");
		return jobBuilderFactory.get("importProductoJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(step)
				.end()
				.build();
	}
	
	@Bean
	public Step step1(JdbcBatchItemWriter<Producto> writer) {
		LOGGER.info("Inicializando Step 1...");
		return stepBuilderFactory.get("step1")
				.<Producto, Producto>chunk(5)
				.reader(readerProducto())
				.processor(processorProducto())
				.writer(writer)
				.build();
	}
}

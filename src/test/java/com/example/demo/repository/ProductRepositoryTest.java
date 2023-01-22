package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Entity.Product;
 
/**
 * Clase que simula el ProductRepository 
 * para probar de forma efectiva el CRUD
 */
@SpringBootTest
class ProductRepositoryTest {

	/**
	 * Así se permite inyectar la dependencia (objetos)
	 * de forma implícita, esto lo hace spring.
	 * 
	 * De esta forma se puede usar los métodos de ProductRepository
	 */
	@Autowired
	ProductRepository productRepository;
	
	// La anotación corre el siguiente código en el entorno de pruebas
	@Test
	void saveMethod() 
	{
		// Se instancia la entidad
		Product product = new Product();
		
		// Definir valores en la instancia
		product.setName("Product 1");
		product.setDescription("Product 1 Description");
		product.setSku("100ABC");
		product.setPrice(new BigDecimal(100));
		product.setActive(true);
		product.setImgUrl("product1.png");
		
		// Guardar el producto en la BD
		/**
		 * Se almacena el objeto en la BD usando los 
		 * métodos de la clase con los métodos para el CRUD.
		 * 
		 * Retorna los un objeto con los datos de la BD recién
		 * almacenados por la entidad.
		 */
		Product savedProduct = productRepository.save(product);
		
		
		// Imprimir el id del objeto recién guardado
		System.out.println(savedProduct.getId());
		System.out.println(savedProduct);
	}
	
	@Test
	void UpdateUsingSaveMethod()
	{
		/* BUSCAR EL REGISTRO EN LA BD */
		Long id = 1L;
		
		/**
		 * Se usa el método de findById para buscar el registro
		 * según el "id", este lo retorna como un objeto de la
		 * entidad, el método get se encarga de validar que exista
		 * de lo contrario, lanzará una excepción.
		 */
		Product product = productRepository.findById(id).get();
		
		product.setName("Update product 1");
		product.setDescription("Update product 1 desc");
		
		// ACTUALIZAR EL REGISTRO EN LA BD
		
		/**
		 * Se actualiza el registro porque la entidad posee
		 * una primary key, que ya está en la BD, por ende, 
		 * JPA sabe que debe actualizarlo, sin primary key,
		 * lo insertaría como nuevo.
		 */
		productRepository.save(product);
	}
	
	@Test
	void saveMultipleRecords()
	{
		Product product1 = new Product();
		
		product1.setName("Product 2");
		product1.setDescription("Product 2 Description");
		product1.setSku("200ABC");
		product1.setPrice(new BigDecimal(100));
		product1.setActive(true);
		product1.setImgUrl("product1.png");

		Product product2 = new Product();
		
		product2.setName("Product 3");
		product2.setDescription("Product 3 Description");
		product2.setSku("300ABC");
		product2.setPrice(new BigDecimal(100));
		product2.setActive(true);
		product2.setImgUrl("product1.png");

		Product product3 = new Product();
		
		product3.setName("Product 4");
		product3.setDescription("Product 4 Description");
		product3.setSku("400ABC");
		product3.setPrice(new BigDecimal(100));
		product3.setActive(true);
		product3.setImgUrl("product1.png");
		
		/*
		 * Para almacenar varias entidades a la vez,
		 * se puede usar el método saveAll, que recibe
		 * listas o arrays que contengan las entidades.
		 * */
		productRepository.saveAll(List.of(product1, product2, product3));
	}
	
	// OBTENER TODOS LOS REGISTROS EN LA TABLA
	@Test
	void findAllRecords ()
	{
		/*
		 * Se usa dicho método y se almacenan todos en
		 * una lista que almacenará objetos tipo Product
		 * */
		List<Product> products = productRepository.findAll();
		
		/*
		 * Con el método forEach de la entidad y una 
		 * función lambda se logra iterar a través de toda
		 * la lista.
		 * */
		products.forEach((product) -> {
			System.out.println(product);
		});
	}
	
	// DELETE A RECORD FOR ITS ID
	@Test
	void deleteRecordID ()
	{
		Long id = 1L;
		productRepository.deleteById(id);
	}
	
	// DELETE A RECORD by ENTITY
	@Test
	void deleteRecordEntity ()
	{
		// First look up the entity
		Long id = 2L;
		
		Product product = productRepository.findById(id).get();
		
		// Doesn't return any value
		productRepository.delete(product);
	}


	// DELETE ALL RECORDS 
	@Test
	void deleteWithoutEntity ()
	{
		productRepository.deleteAll();
	}

	// DELETE ALL RECORDS by way ENTITY LIST
	@Test
	void deleteAllRecordsEntity ()
	{
		Product product1 = productRepository.findById(2L).get();
		Product product2 = productRepository.findById(4L).get();
		
		/**
		 * Este método elimina todos las entidades que estén
		 * dentro de una lista iterable que le sea pasada como
		 * argumento.
		 * */
		productRepository.deleteAll(List.of(product1, product2));
	}
	
	// Count all records into the DB
	@Test
	void countRecords()
	{
		Long count = productRepository.count();
		
		System.out.println("Number of Records: " + count);
	}
	
	
}

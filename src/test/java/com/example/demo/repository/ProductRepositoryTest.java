package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

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
}

package com.example.demo.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// Importaciones para todas las dependencias de JPA
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

// Está clase representa una tabla en la BD

/* La anotación @Entity, indica que la clase es una entidad
 * en la BD y que representa una tabla de la misma, la tabla
 * recibe el nombre de la clase.
 * 
 * Nota: Siempre debe ser puesta al nivel de la clase.
 *  */
@Entity

/*
 * Esta anotación permite definir atributos propios a la tabla
 * sin depender de la notación de la clase, en este caso,
 * 
 * <<< Nota >>>
 *  Si se crea una tabla primero con el nombre de la clase
 *  y después se usa esta anotación para asignarle uno nuevo,
 *  la tabla no se actualizar, creará una nueva con ese nombre y
 *  mantendra la otra con el nombre anterior.
 * */
@Table(
  // se define que la tabla se llamará "products"
  name = "products", 
  // Se creará en la la BD "ecommerce" (schema) 
  schema = "ecommerce",
  // Definir que una columna es una unique constraint
  // requiere de dos definiciones.
  
  /* Al ser un array se puede definir más de una unique constraint 
   * usando otra anotación similar y con la misma estructura.*/
  uniqueConstraints = {
		  @UniqueConstraint(
				  // Nombre de la llave única
				  name = "sku_unique",
				  // Columna(s) a la que hace referencia
//				  columnNames = "sku" (La columna se ha especificado con otro nombre en la BD)
				  columnNames = "stock_keeping_unit"
		  )
  }
)
public class Product {
	 /*
	  * Las VI representan las columnas de la tabla 
	  * 
	  * Hibernate separa los nombres de las columnas en la BD
	  * con "_", separando las palabras con camel case.
	  * */
	
	// Esta anotación indica que la VI debajo es la primary key
	@Id
	/*
	 * Anotación para estrategia de generación de primary keys,
	 * dentro de los paréntesis se pone strategy y se le asigna
	 * la estrategia, en este caso es IDENTITY que significa
	 * que será autincrement.
	 * */
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/* Anotación para personalizar la columna */
	@Column (
	  // Nombre de la columna
	  name = "stock_keeping_unit",
	  // NOT NULL
	  nullable = false
	)
	private String sku;
	
	@Column(nullable = false)
	private String name;
	private String description;
	private BigDecimal price;
	private boolean active;
	private String imgUrl;
	private LocalDateTime dateCreated;
	private LocalDateTime lastUpdated;

	//  GETTERS AND SETTER FOR ALL VI
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
}

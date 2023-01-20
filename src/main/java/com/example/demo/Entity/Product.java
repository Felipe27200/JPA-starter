package com.example.demo.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// Está clase representa una tabla en la BD

/* La anotación @Entity, indica que la clase es una entidad
 * en la BD y que representa una tabla de la misma.
 * 
 * Nota: Siempre debe ser puesta al nivel de la clase.
 *  */
@Entity
public class Product {
	// Las VI representan las columnas de la tabla
	
	// Esta anotación indica que la VI debajo es la primary key
	@Id
	private Long id;
	
	private String sku;
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

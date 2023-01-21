package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Product;

/*
 * Interface para extender los métodos para el CRUD que contiene la 
 * interfaz "JpaRepository", la cual necesita dos argumentos: 
 * 	1. Tipo de la entidad: en este caso la entidad es producto
 * 	2. Tipo de la primary key de la entidad: en este caso es Long;
 * */

/*
 * +----------------------------------------------+
 * | No se debe declarar ninguna clase para poder |
 * | implementar y hacer uso de esta interfaz     |
 * +----------------------------------------------+
 * */
public interface ProductRepository extends JpaRepository<Product, Long>{

}

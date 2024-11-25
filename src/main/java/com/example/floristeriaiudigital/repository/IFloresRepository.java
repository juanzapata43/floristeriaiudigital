package com.example.floristeriaiudigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.floristeriaiudigital.model.FloresModel;

@Repository
public interface IFloresRepository extends JpaRepository<FloresModel, Long> {
  // Métodos personalizados (si necesitas agregar lógica de consultas)
}


package com.example.salvador_20202152_lab3.repository;

import com.example.salvador_20202152_lab3.entity.Shipper;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface repository extends JpaRepository<Htmls, Integer> {

    List<Htmls> findByName(String textoIngresado);

    @Query(nativeQuery = true, value = "SELECT * FROM employees where first_name = ?1")
    List<Htmls> buscarPorNombre(String textoIngreso);

    @Query(nativeQuery = true, value = "SELECT * FROM employees where last_name = ?1")
    List<Htmls> buscarPorApellido(String textoIngreso);

}
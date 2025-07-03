package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.ZonaTrabajo;

@Repository
public interface IZonaTrabajo extends JpaRepository<ZonaTrabajo, Long> {

}

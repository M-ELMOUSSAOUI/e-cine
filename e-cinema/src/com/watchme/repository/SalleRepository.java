package com.watchme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.watchme.models.Salle;

@Repository
public interface  SalleRepository extends JpaRepository<Salle, Long> {

}

package com.watchme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.watchme.models.Programme;

@Repository
public interface ProgrammeRepository  extends JpaRepository<Programme, Long> {

}

package com.watchme.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.watchme.models.Salle;
import com.watchme.repository.SalleRepository;

@Service
public class SalleService  extends AbstractService<Salle, Long> {

    @Autowired
    private SalleRepository sallesRepository;

    @Override
    protected JpaRepository<Salle, Long> getRepository() {
        return sallesRepository;
    }

}

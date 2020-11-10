package com.watchme.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.watchme.models.Programme;
import com.watchme.repository.ProgrammeRepository;

@Service
public class ProgrammeService extends AbstractService<Programme, Long> {

    @Autowired
    private ProgrammeRepository programmesRepository;

    @Override
    protected JpaRepository<Programme, Long> getRepository() {
        return programmesRepository;
    }


}

package com.codegym.service.national;

import com.codegym.model.Nation;
import com.codegym.repository.INationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NationService implements INationService {
    @Autowired
    INationRepo nationRepo;
    @Override
    public List<Nation> findAll() {
        List<Nation> list = (List<Nation>) nationRepo.findAll();
        return list;
    }

    @Override
    public Nation findOne(Long id) {
        Nation nation = (nationRepo.findById(id)).get();
        return nation;
    }
}

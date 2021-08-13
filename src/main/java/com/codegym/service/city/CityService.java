package com.codegym.service.city;

import com.codegym.model.City;
import com.codegym.repository.ICityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService implements ICityService {

    @Autowired
    ICityRepo cityRepo;
    @Override
    public Iterable<City> findAll() {
        return cityRepo.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepo.findById(id);
    }

    @Override
    public void save(City city) {
        cityRepo.save(city);
    }

    @Override
    public void remove(Long id) {
    cityRepo.deleteById(id);
    }
}

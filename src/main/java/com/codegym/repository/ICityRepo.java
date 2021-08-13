package com.codegym.repository;

import com.codegym.model.City;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepo extends PagingAndSortingRepository<City,Long> {
}

package com.codegym.repository;

import com.codegym.model.Nation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INationRepo extends PagingAndSortingRepository<Nation,Long> {
}
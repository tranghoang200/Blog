package com.trang2k.demo.repositories;

import com.trang2k.demo.entities.Log;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestController
public interface LogRepository extends PagingAndSortingRepository<Log, Integer> {

    List<Log> findAllBy(Pageable pageable);

}

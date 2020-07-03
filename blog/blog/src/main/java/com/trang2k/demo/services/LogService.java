package com.trang2k.demo.services;

import com.trang2k.demo.entities.Log;
import com.trang2k.demo.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired
    LogRepository logRepository;

    public List<Log> getAll(final Integer index) {
        Pageable pageable = PageRequest.of(index, 5);
        return logRepository.findAllBy(pageable);
    }

    public Log save(Log log) {
        return logRepository.save(log);
    }

}

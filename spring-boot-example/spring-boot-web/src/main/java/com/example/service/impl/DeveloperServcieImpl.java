package com.example.service.impl;

import com.example.domain.Developer;
import com.example.service.DeveloperServcie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * DeveloperServcieImpl
 *
 * @author Kyrie.Wang
 */
@Service
@Slf4j
public class DeveloperServcieImpl implements DeveloperServcie {

    @Override
    public List<Developer> findAll() {
        log.info("findAll is running....");
        return Collections.emptyList();
    }
}

package com.example.service;

import com.example.domain.Developer;

import java.util.List;

/**
 * DeveloperServcie
 *
 * @author Kyrie.Wang
 */
public interface DeveloperServcie {
    /**
     * 查找全部
     *
     * @return Developer集合
     */
    List<Developer> findAll();
}

package com.api.cities.controller;

import com.api.cities.entity.City;
import com.api.cities.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cities")
@AllArgsConstructor
public class CityController {
    private final CityRepository repository;

    @GetMapping
    public Page<City> cities(final Pageable page) {
        return repository.findAll(page);
    }
}

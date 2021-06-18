package com.api.cities.controller;

import com.api.cities.service.DistanceService;
import com.api.cities.utils.EarthRadius;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distances")
@AllArgsConstructor
public class DistanceController {
    private final DistanceService service;

    private static final Logger log = LoggerFactory.getLogger(DistanceController.class);

    @GetMapping("/by-points")
    public Double byPoints(@RequestParam(name = "from") final Long cityFrom,
                           @RequestParam(name = "to") final Long cityTo) {
        log.info("Getting distance by points");
        return service.distanceByPointsInMiles(cityFrom, cityTo);
    }

    @GetMapping("/by-cube")
    public Double byCube(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2) {
        log.info("Getting distance by cube");
        return service.distanceByCubeInMeters(city1, city2);
    }

    @GetMapping("/by-math")
    public Double byMath(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2,
                         @RequestParam final EarthRadius unit) {
        log.info("Getting distance by math");
        return service.distanceUsingMath(city1, city2, unit);
    }
}

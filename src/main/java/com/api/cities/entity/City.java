package com.api.cities.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    private String uf;

    private String ibge;

    @Column(name = "lat_lon")
    private String geolocation;

    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Point location;
}

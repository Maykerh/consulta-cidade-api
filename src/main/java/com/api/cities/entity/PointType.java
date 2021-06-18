package com.api.cities.entity;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;
import org.springframework.data.geo.Point;

@AllArgsConstructor
@Getter
@Setter
public class PointType implements UserType {
    public double x;

    public double y;

    public String getValue() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public int[] sqlTypes() {
        return new int[] {java.sql.Types.OTHER};
    }

    @Override
    public Class returnedClass() {
        return PointType.class;
    }
}

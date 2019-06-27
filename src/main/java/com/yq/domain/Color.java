package com.yq.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class Color {

    private Car car;

    public Color(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Color{" +
                "car=" + car +
                '}';
    }
}

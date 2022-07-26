package com.designpattern.creational.builder;

class Vehicle {

    //required parameters
    private String engine;
    private int wheel;

    //optional parameter
    private int airbags;

    //only getters
    public String getEngine() {
        return engine;
    }

    public int getWheel() {
        return wheel;
    }

    public int getAirbags() {
        return airbags;
    }

    //private constructor as the object will be created by Builder class only
    private Vehicle(VehicleBuilder builder) {
        this.engine = builder.engine;
        this.wheel = builder.wheel;
        this.airbags = builder.airbags;
    }

    //Builder class is static inner class
    public static class VehicleBuilder {
        //required parameter
        private final String engine;
        private final int wheel;
        //optional parameter
        private int airbags;

        public VehicleBuilder(String engine, int wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        //setter method returns VehicleBuilder, not void
        public VehicleBuilder setAirbags(int airbags) {
            this.airbags = airbags;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}

public class BuilderPatternClient {
    public static void main(String[] args) {
        Vehicle car = new Vehicle.VehicleBuilder("2500cc", 4).setAirbags(2).build();
        Vehicle bike = new Vehicle.VehicleBuilder("220cc", 2).build();

        System.out.println(car.getEngine());
        System.out.println(car.getWheel());
        System.out.println(car.getAirbags());

        System.out.println(bike.getEngine());
        System.out.println(bike.getWheel());
        System.out.println(bike.getAirbags());
    }
}

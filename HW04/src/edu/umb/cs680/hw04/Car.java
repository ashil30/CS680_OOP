package edu.umb.cs680.hw04;

public class Car {

    private String make;
    private String model;
    private int mileage;
    private int year;
    private float price;

    public Car(String make, String model, int mileage, int year, float price) {
        super();
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }

    public Car(String make, String model, int year) {
        this.year = year;
        this.model = model;
        this.make = make;
    }
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    public int getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }

    public static void main(String[] args) {
        Car car = new Car("BMW", "330",21, 2020,35000);
        System.out.println("Make : "+car.getMake()+"\n"
                +"Model : "+car.getModel()+"\n"
                +"Mileage : "+car.getMileage()+"\n"
                +"Year : "+car.getYear()+"\n"
                +"Price : "+car.getPrice());

    }

}
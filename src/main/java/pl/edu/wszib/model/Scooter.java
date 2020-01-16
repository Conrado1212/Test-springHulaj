package pl.edu.wszib.model;

import javax.persistence.*;

@Entity
@Table(name="tscooter")
public class Scooter {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String brand;
    private String model;
    private int price;

    public Scooter(){

    }

    public Scooter(int id, String brand, String model, int price) {
        Id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Scooter{" +
                "Id=" + Id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}

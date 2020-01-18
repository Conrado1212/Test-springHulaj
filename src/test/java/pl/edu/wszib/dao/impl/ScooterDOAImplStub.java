package pl.edu.wszib.dao.impl;

import pl.edu.wszib.dao.IScooterDAO;
import pl.edu.wszib.model.Scooter;

import java.util.ArrayList;
import java.util.List;

public class ScooterDOAImplStub implements IScooterDAO {
    @Override
    public void addScooter(Scooter scooter) {

    }

    @Override
    public Scooter getScooter(int Id) {
        Scooter scooter = new Scooter();
        scooter.setId(1);
        scooter.setBrand("Xiaomi");
        scooter.setModel("Mijia M365");
        scooter.setPrice(40);

        return scooter;
    }

    @Override
    public void getUpdate(int Id, Scooter scooter) {

    }

    @Override
    public void getUpdateScooter(int Id, Scooter scooter) {

    }

    @Override
    public void removeScooterId(int Id) {

    }
    List<Scooter> scooters = new ArrayList<>();
    @Override
    public List<Scooter>  getAllScooterXiaomi(){

    Scooter scooter = new Scooter();

        scooter.setId(1);
        scooter.setBrand("Xiaomi");
        scooter.setModel("Mijia M365");
        scooter.setPrice(40);

        Scooter scooter1 = new Scooter();
        scooter1.setId(2);
        scooter1.setBrand("Xiaomi");
        scooter1.setModel("Mijia M365 PRO");
        scooter1.setPrice(40);



        this.scooters.add(scooter);
        this.scooters.add(scooter1);


        return scooters;

    }

    @Override
    public List<Scooter> getAllScooters() {
        Scooter scooter = new Scooter();

        scooter.setId(1);
        scooter.setBrand("Xiaomi");
        scooter.setModel("Mijia M365");
        scooter.setPrice(40);

        Scooter scooter1 = new Scooter();
        scooter1.setId(2);
        scooter1.setBrand("Xiaomi");
        scooter1.setModel("Mijia M365 PRO");
        scooter1.setPrice(45);

        Scooter scooter2 = new Scooter();
        scooter2.setId(3);
        scooter2.setBrand("Fiat");
        scooter2.setModel("M500");
        scooter2.setPrice(30);

        Scooter scooter3 = new Scooter();

        scooter3.setId(4);
        scooter3.setBrand("Fiat");
        scooter3.setModel("M500 8.5");
        scooter3.setPrice(40);

        this.scooters.add(scooter);
        this.scooters.add(scooter1);
        this.scooters.add(scooter2);
        this.scooters.add(scooter3);

        return scooters;

    }

    @Override
    public List<Scooter> getAllScooterFiat() {
        Scooter scooter2 = new Scooter();
        scooter2.setId(3);
        scooter2.setBrand("Fiat");
        scooter2.setModel("M500");
        scooter2.setPrice(30);

        Scooter scooter3 = new Scooter();

        scooter3.setId(4);
        scooter3.setBrand("Fiat");
        scooter3.setModel("M500 8.5");
        scooter3.setPrice(40);

        this.scooters.add(scooter2);
        this.scooters.add(scooter3);
        return scooters;
    }
}

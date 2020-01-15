package pl.edu.wszib.dao.impl;

import pl.edu.wszib.dao.IScooterDAO;
import pl.edu.wszib.model.Scooter;

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
    public void removeScooterId(int Id) {

    }

    @Override
    public List<Scooter> getAllScooterXiaomi() {
        return null;
    }

    @Override
    public List<Scooter> getAllScooters() {
        return null;
    }

    @Override
    public List<Scooter> getAllScooterFiat() {
        return null;
    }
}

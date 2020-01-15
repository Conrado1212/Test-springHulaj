package pl.edu.wszib.services;

import pl.edu.wszib.model.Scooter;

import java.util.List;

public interface IScooterService {
    void addScooter(Scooter scooter);

    void removeScooterId(int Id);

    void getUpdate(int Id, Scooter scooter);

    Scooter getScooter(int id);

    List<Scooter> getAllScooterXiaomi();

    List<Scooter> getAllScooters();

    List<Scooter> getAllScooterFiat();
}

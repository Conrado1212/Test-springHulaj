package pl.edu.wszib.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.IScooterDAO;
import pl.edu.wszib.model.Scooter;
import pl.edu.wszib.services.IScooterService;

import java.util.List;

public class ScooterServiceImpl implements IScooterService {

    @Autowired
    IScooterDAO scooterDAO;

    public ScooterServiceImpl(IScooterDAO scooterDAO){
        this.scooterDAO=scooterDAO;
    }

    @Override
    public void addScooter(Scooter scooter){

    }

    @Override
    public void removeScooterId(int Id){

    }

    @Override
    public void getUpdate(int Id, Scooter scooter){

    }

    @Override
    public Scooter getScooter(int Id){
        return this.scooterDAO.getScooter(Id);
    }

    @Override
    public List<Scooter> getAllScooters(){
        return this.scooterDAO.getAllScooters();
    }

    @Override
    public List<Scooter> getAllScooterXiaomi(){
        return this.scooterDAO.getAllScooterXiaomi();
    }

    @Override
    public List<Scooter> getAllScooterFiat(){
        return this.scooterDAO.getAllScooterFiat();
    }
}

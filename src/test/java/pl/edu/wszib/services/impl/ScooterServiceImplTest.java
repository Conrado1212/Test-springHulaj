package pl.edu.wszib.services.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.edu.wszib.configuration.AppConfigurationTest;
import pl.edu.wszib.dao.IScooterDAO;
import pl.edu.wszib.model.Scooter;
import pl.edu.wszib.services.IScooterService;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =  {AppConfigurationTest.class})
@WebMvcTest
public class ScooterServiceImplTest {

    @Autowired
    IScooterService scooterService;

    @MockBean
    IScooterDAO scooterDAO;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addScooterTest(){
        Scooter scooter = new Scooter();
        scooter.setId(1);
        scooter.setBrand("Xiaomi");


       /// Mockito.when(this.scooterDAO.addScooter( scooter)).thenReturn(new Scooter(1,"Xiaomi","Mijia M365",40));


    }


    @Test
    public void getUpdate(){

    }


    @Test
    public void removeScooterId(){

    }

    @Test
    public void getScooter(){
        Scooter scooter = new Scooter();
        scooter.setId(1);
        scooter.setBrand("Xiaomi");


       // Mockito.when(this.scooterDAO.getScooter(2)).thenReturn(new Scooter(1,"Xiaomi","Mijia M365",40));


    }

    @Test
    public  void allScooter(){
        List<Scooter> getAllScooters = new ArrayList<>();
        Mockito.when(scooterDAO.getAllScooters()).thenReturn(getAllScooters);


      //  boolean result = this.scooterDAO.getAllScooters();
     //   Assert.assertTrue(result);

    }

    @Test
    public  void getAllScooterXiaomi(){
        List<Scooter> getAllScooterXiaomi = new ArrayList<>();
        Mockito.when(scooterDAO.getAllScooterXiaomi()).thenReturn(getAllScooterXiaomi);


    }

    @Test
    public  void getAllScooterFiat(){
        List<Scooter> getAllScooterFiat = new ArrayList<>();
        Mockito.when(scooterDAO.getAllScooterFiat()).thenReturn(getAllScooterFiat);
    }


}

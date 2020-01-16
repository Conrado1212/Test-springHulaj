package pl.edu.wszib.services.impl;

import org.junit.Assert;
import org.junit.BeforeClass;
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
import pl.edu.wszib.dao.impl.ScooterDAOImpl;
import pl.edu.wszib.model.Scooter;
import pl.edu.wszib.services.IScooterService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
        Scooter scooter = new Scooter();
        scooter.setId(1);
        scooter.setBrand("Xiaomi");

        //Mockito.when(this.scooterDAO.getUpdate(1,scooter)).thenReturn()
    }


    @Test
    public void removeScooterId(){
        Scooter scooter = new Scooter();
        scooter.setId(1);
        scooter.setBrand("Xiaomi");

       // Mockito.when(this.scooterDAO.removeScooterId(1)).thenReturn(new Scooter(1,"Xiaomi","Mijia M365",40));
    }

    @Test
    public void getScooter(){
        Scooter scooter = new Scooter();
        scooter.setId(1);
        scooter.setBrand("Xiaomi");


        Mockito.when(this.scooterDAO.getScooter(2)).thenReturn(new Scooter(1,"Xiaomi","Mijia M365",40));
        Scooter result = this.scooterService.getScooter(1);
        Assert.assertNull(result);

    }

    @Test
    public  void allScooter(){
        List<Scooter> getAllScooters = new ArrayList<>();

        Mockito.when(scooterDAO.getAllScooters()).thenReturn(getAllScooters);


      List result = this.scooterDAO.getAllScooters();
        Assert.assertEquals(result,scooterDAO.getAllScooters());
    }

    @Test
    public  void getAllScooterXiaomi(){
        List<Scooter> getAllScooterXiaomi = new ArrayList<>();

        Mockito.when(scooterDAO.getAllScooterXiaomi()).thenReturn(getAllScooterXiaomi);

        List result = this.scooterService.getAllScooterXiaomi();
        Assert.assertEquals(result,scooterDAO.getAllScooterXiaomi());
    }

    @Test
    public  void getAllScooterFiat(){
        List<Scooter> getAllScooterFiat = new ArrayList<>();
        when(scooterDAO.getAllScooterFiat()).thenReturn(getAllScooterFiat);

        List result = this.scooterService.getAllScooterFiat();
        Assert.assertEquals(result,scooterDAO.getAllScooterFiat());
    }


    private static ScooterServiceImplTest scooterServiceImplTest;
   private static Scooter scooter1;
    private static Scooter scooter2;

    @BeforeClass
    public static void setUp(){
   scooterServiceImplTest = mock(ScooterServiceImplTest.class);

   scooter1 = new Scooter(1,"Xiaomi","Mijia M365",40);
   scooter2 = new Scooter(2,"Xiaomi","Mijia M365 PRO",45);

        ScooterDAOImpl mockedScooter = mock(ScooterDAOImpl.class);

        scooter1 = new Scooter(1,"Xiaomi","Mijia M365",40);
        scooter2 = new Scooter(2,"Xiaomi","Mijia M365 PRO",45);

        when(mockedScooter.getScooter(1)).thenReturn(scooter1);

   }

   @Test
   public void getScooterTest(){

        Scooter scooter = scooterDAO.getScooter(1);

        Assert.assertNull(scooter);
   }

}

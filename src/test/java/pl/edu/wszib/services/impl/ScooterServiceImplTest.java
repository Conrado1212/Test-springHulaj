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

import static org.mockito.ArgumentMatchers.anyInt;
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
    public void getScooter(){
        Scooter scooter = new Scooter();
        scooter.setId(1);
        scooter.setBrand("Xiaomi");
        scooter.setModel("Mijia M365");

        Mockito.when(this.scooterDAO.getScooter(anyInt())).thenReturn(new Scooter(1,"Xiaomi","Mijia M365",40));
        Scooter result = this.scooterService.getScooter(1);
        Assert.assertNotNull(result);

    }

    @Test
    public void getUpdate(){
        Scooter scooter = new Scooter();
        scooter.setId(1);
        scooter.setBrand("Xiaomi");
        scooter.setModel("Mijia M365");
       // Mockito.when(this.scooterDAO.getUpdate(anyInt(),anyObject())).thenReturn()
    }

    @Test
    public  void allScooter(){
        List<Scooter> getAllScooters = new ArrayList<>();
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

        Mockito.when(scooterDAO.getAllScooters()).thenReturn(getAllScooters);


      List result = this.scooterDAO.getAllScooters();
        Assert.assertEquals(result,scooterDAO.getAllScooters());
    }

    @Test
    public  void getAllScooterXiaomi(){
        List<Scooter> getAllScooterXiaomi = new ArrayList<>();
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
        Mockito.when(scooterDAO.getAllScooterXiaomi()).thenReturn(getAllScooterXiaomi);

        List result = this.scooterService.getAllScooterXiaomi();
        Assert.assertEquals(result,scooterDAO.getAllScooterXiaomi());
    }

    @Test
    public  void getAllScooterFiat(){
        List<Scooter> getAllScooterFiat = new ArrayList<>();
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

        Assert.assertNotNull(scooter);
   }

}

package pl.edu.wszib.configuration;


import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.wszib.dao.IScooterDAO;
import pl.edu.wszib.dao.impl.ScooterDAOImpl;
import pl.edu.wszib.services.IScooterService;
import pl.edu.wszib.services.impl.ScooterServiceImpl;

@Configuration
public class AppConfiguration {

    @Bean
    public SessionFactory hibernateSessionFactory(){
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }

    @Bean
    public IScooterDAO scooterDAO(SessionFactory hibernateSessionFactory){
        return new ScooterDAOImpl(hibernateSessionFactory);
    }

    @Bean
    public IScooterService scooterService(IScooterDAO scooterDAO){
        return new ScooterServiceImpl(scooterDAO);
    }


}
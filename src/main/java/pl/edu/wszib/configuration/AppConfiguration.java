package pl.edu.wszib.configuration;


import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import pl.edu.wszib.SessionObject;
import pl.edu.wszib.dao.IScooterDAO;
import pl.edu.wszib.dao.IUserDAO;
import pl.edu.wszib.dao.impl.ScooterDAOImpl;
import pl.edu.wszib.dao.impl.UserDAOImpl;
import pl.edu.wszib.services.IAuthenticationService;
import pl.edu.wszib.services.IScooterService;
import pl.edu.wszib.services.IUserService;
import pl.edu.wszib.services.impl.AuthenticationServiceImpl;
import pl.edu.wszib.services.impl.ScooterServiceImpl;
import pl.edu.wszib.services.impl.UserServiceImpl;

@Configuration
public class AppConfiguration {

    @Bean
    @SessionScope
    public SessionObject sessionObject(){
        return new SessionObject();
    }

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

    @Bean
    public IUserDAO userDAO(SessionFactory hibernateSessionFactory){
        return new UserDAOImpl(hibernateSessionFactory);
    }

    @Bean
    public IAuthenticationService authenticationService(IUserDAO userDAO){
        return new AuthenticationServiceImpl(userDAO);
    }

    @Bean
    public IUserService userService(IUserDAO userDAO){
        return new UserServiceImpl(userDAO);
    }
}

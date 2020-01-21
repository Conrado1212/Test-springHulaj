package pl.edu.wszib.services.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.wszib.dao.IUserDAO;
import pl.edu.wszib.model.User;
import pl.edu.wszib.services.IAuthenticationService;

public class AuthenticationServiceImpl implements IAuthenticationService {

    @Autowired
    IUserDAO userDAO;

    public AuthenticationServiceImpl(IUserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public boolean authenticationUser(User user){
        User userFromDb = this.userDAO.getUserByLogin(user.getLogin());
        return userFromDb != null && userFromDb.getPass().equals(DigestUtils.md5Hex(user.getPass()));
    }
}

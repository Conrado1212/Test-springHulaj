package pl.edu.wszib.services;

import pl.edu.wszib.model.User;

import java.util.List;

public interface IUserService {
    void registerUser(User user);

    User getUserByLogin(String login);

    List<User> getAllUser();
}

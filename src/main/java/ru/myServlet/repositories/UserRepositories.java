package ru.myServlet.repositories;

import ru.myServlet.models.User;

import java.util.List;

public interface UserRepositories {
    List<User> findAll();
    void save(User user);
    boolean isExist(String name, String password);
}

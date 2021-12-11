package ru.myServlet.repositories;

import ru.myServlet.models.User;

import java.util.List;

public interface UserRepositories {
    List<User> findAll();
}

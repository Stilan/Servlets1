package ru.myServlet.repositories;

import ru.myServlet.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Репозиторий это объект доступв к данным
 */
public class UserRepositoriesInMemoryImpl implements UserRepositories{

    private List<User> userList;

    public UserRepositoriesInMemoryImpl() {
        this.userList = new ArrayList<>();
        User user1 = new User("Alex1", "QWE", LocalDate.parse("1989-12-12"));
        User user2 = new User("Alex1", "QWE", LocalDate.parse("1989-12-12"));
        User user3 = new User("Alex1", "QWE", LocalDate.parse("1989-12-12"));
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
    }

    public List<User> findAll() {
        return this.userList;
    }

    /**
     * Добовляет User в хранилище
     * @param user
     */
    @Override
    public void save(User user) {
        userList.add(user);
    }


}

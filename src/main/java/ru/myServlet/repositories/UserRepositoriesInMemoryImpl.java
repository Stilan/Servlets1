package ru.myServlet.repositories;

import ru.myServlet.fake.FakeStorage;
import ru.myServlet.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Репозиторий это объект доступв к данным
 *  Реализация объекта доступа к данным с испольованием фейкового хранилища
 */
public class UserRepositoriesInMemoryImpl implements UserRepositories{

    public List<User> findAll() {
        return FakeStorage.storage().users();
    }

    /**
     * Добовляет User в хранилище
     * @param user
     */
    @Override
    public void save(User user) {
        FakeStorage.storage().users().add(user);
    }

    @Override
    public boolean isExist(String name, String password) {
        for (User user: FakeStorage.storage().users()) {
            if (user.getName().equals(name) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }


}

package ru.myServlet.fake;

import ru.myServlet.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс, реализующий паттеррн Singleton
 *  Представляет собой InMemory-хранилище для получения информации о зарегистрированных пользователях
 */
public class FakeStorage {
    // переменная, которая хранит ссылку на единственный экземпляр объекта класса FakeStorage
    private static final FakeStorage storage;
    // поле-список, хранящее список пользователей системы
    private List<User> userList;
    // статически инициализатор, создающий объект класса FakeStorage. Вызывается один раз при загрузке класса в JVM
    static {
        storage = new FakeStorage();
    }
    // приватный констуктор, выполняющий инициализацию списка
    private FakeStorage(){
        this.userList = new ArrayList<>();
        User user1 = new User("Alex1", "QWE", LocalDate.parse("1989-12-12"));
        User user2 = new User("Alex1", "QWE", LocalDate.parse("1989-12-12"));
        User user3 = new User("Alex1", "QWE", LocalDate.parse("1989-12-12"));
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
    }
    // метод, предоставляющий доступ к объекту класса
    public static  FakeStorage storage(){
        return storage;
    }
    // метод, возвращающий список пользователей
    public List<User> users() {
        return userList;
    }
}

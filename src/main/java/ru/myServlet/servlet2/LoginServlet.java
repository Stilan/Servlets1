package ru.myServlet.servlet2;

import ru.myServlet.repositories.UserRepositories;
import ru.myServlet.repositories.UserRepositoriesInMemoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *  Реализация объекта доступа к данным с испольованием фейкового хранилища
 */
@WebServlet("/login")
public class LoginServlet  extends HttpServlet {
    // ссылка на хранилище пользователей
    private UserRepositories userRepositories;

    @Override
    public void init() throws ServletException {
        this.userRepositories = new UserRepositoriesInMemoryImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // вытаскиваем из запроса имя пользователя и его пароль
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        // если пользователь есть в системе
        if (userRepositories.isExist(name, password)) {
            // создаем для него сессию
            HttpSession session = req.getSession();
            // кладем в атрибуты сессии атрибут user с именем пользователя
            session.setAttribute("user", name);
            // перенаправляем на страницу home
            req.getServletContext().getRequestDispatcher("/home").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }

    }
}

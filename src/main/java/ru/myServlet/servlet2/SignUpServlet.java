package ru.myServlet.servlet2;

import ru.myServlet.models.User;
import ru.myServlet.repositories.UserRepositories;
import ru.myServlet.repositories.UserRepositoriesInMemoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

/**
 * Сервлет отвечает за регистрацию
 * @WebServlet("/signUp") он реагирует на signUp это специальная анатация
 */

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    private UserRepositories userRepositories;
    @Override
    public void init() throws ServletException {
       this.userRepositories = new UserRepositoriesInMemoryImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = userRepositories.findAll();
        /**
         * Вывод чере jsp
         * req.setAttribute() ладутся user из userList
         * RequestDispatcher requestDispatcher диспечер на строницу signUp_old.jsp
         *  requestDispatcher.forward(req,resp); перенапровления запроса
         */
        System.out.println(userList.toString());
        req.setAttribute("usersFromServer",userList);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/signUp.jsp");
        dispatcher.forward(req,resp);
    }

    /**
     * данные на сервер всегда отпровляются post запросом
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // из запоса забираем параметры
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthDate"));
        // создаем и сохраняем пользавателя
        User user = new User(name, password, birthDate);
        userRepositories.save(user);
        doGet(req, resp);
    }
}

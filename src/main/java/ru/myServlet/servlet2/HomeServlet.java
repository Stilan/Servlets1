package ru.myServlet.servlet2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          req.getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // получаем параметр запроса
        String color = req.getParameter("color");
        // создаем Cookie с данным значением
        Cookie colorCookie = new Cookie("color", color);
        // кладем в ответ
        resp.addCookie(colorCookie);
        // перенаправляем пользователя обратно на страницу home
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}

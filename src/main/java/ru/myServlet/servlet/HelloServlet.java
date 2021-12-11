package ru.myServlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    /**
     * метод вывода на строници браузера
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("<h1>Hello!</h1>");
        printWriter.write("<h1>Hello!</h1>");
        printWriter.write("<h1>Hello!</h1>");
        printWriter.write("<h1>Hello!</h1>");

    }
}

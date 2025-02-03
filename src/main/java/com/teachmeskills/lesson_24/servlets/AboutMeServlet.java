package com.teachmeskills.lesson_24.servlets;

import com.teachmeskills.lesson_24.service.Logger;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;


@WebServlet("/aboutMe")
public class AboutMeServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            Logger.log("AboutMe servlet initialized ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger.log("AboutMe servlet at stage DoGet ");

        resp.setContentType("text/html;charset=UTF-8");

        resp.sendRedirect("aboutMe.html");
    }

    @Override
    public void destroy() {
        try {
            Logger.log("AboutMe servlet destroyed ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

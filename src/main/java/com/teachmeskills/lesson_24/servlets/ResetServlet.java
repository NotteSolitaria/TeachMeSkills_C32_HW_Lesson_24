package com.teachmeskills.lesson_24.servlets;

import com.teachmeskills.lesson_24.service.Logger;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/reset")
public class ResetServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            Logger.log("Reset servlet initialized " + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger.log("Reset servlet at stage DoGet " + "\n");

        HttpSession session = req.getSession();

        session.invalidate();

        PrintWriter writer = resp.getWriter();

        resp.setContentType("text/html");

        writer.println("Count is reset");
        writer.close();
    }

    @Override
    public void destroy() {
        try {
            Logger.log("Reset servlet destroyed " + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

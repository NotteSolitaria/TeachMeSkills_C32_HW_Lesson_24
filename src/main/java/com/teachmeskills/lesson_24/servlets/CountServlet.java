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

@WebServlet("/count")
public class CountServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            Logger.log("Count servlet initialized " + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger.log("Count servlet at stage DoGet " + "\n");

        PrintWriter out = resp.getWriter();

        HttpSession session = req.getSession();

        Integer count = (Integer) session.getAttribute("count");

        if (count == null) {
            count = 0;
        }

        count++;

        session.setAttribute("count", count);

        out.println("Number of visits: " + count);
        out.close();
    }

    @Override
    public void destroy() {
        try {
            Logger.log("Count servlet destroyed " + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

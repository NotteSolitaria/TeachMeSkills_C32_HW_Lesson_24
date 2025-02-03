package com.teachmeskills.lesson_24.servlets;

import com.teachmeskills.lesson_24.service.Logger;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/settings")
public class SettingsServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {

        super.init(config);

        try {
            Logger.log("Settings servlet initialized " + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.log("Settings servlet at stage DoGet " + "\n");

        ServletContext context = req.getServletContext();
        String appName = getServletContext().getInitParameter("appName");
        String appVersion = getServletContext().getInitParameter("appVersion");
        String developerName = getServletContext().getInitParameter("developerName");
        String supportEmail = getServletContext().getInitParameter("supportEmail");

        try {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();

            out.println("<h1>App Settings</h1>");
            out.println("<p>App Name: " + appName + "</p>");
            out.println("<p>App Version: " + appVersion + "</p>");
            out.println("<p>Developer Name: " + developerName + "</p>");
            out.println("<p>Support Email: " + supportEmail + "</p>");

            out.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {
        try {
            Logger.log("Settings servlet destroyed " + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

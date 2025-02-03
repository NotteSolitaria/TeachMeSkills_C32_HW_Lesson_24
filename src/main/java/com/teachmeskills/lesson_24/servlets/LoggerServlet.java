package com.teachmeskills.lesson_24.servlets;

import com.teachmeskills.lesson_24.service.Logger;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logs")
public class LoggerServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            Logger.log("Logger servlet initialized ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Logger.log("Logger servlet at stage DoGet ");

        resp.setContentType("text/html");

        try(BufferedReader reader = new BufferedReader(new FileReader("logs.txt"))) {

            PrintWriter writer = new PrintWriter(resp.getWriter());
            String line;

            while ((line = reader.readLine()) != null) {
                writer.println(line);
            }

            writer.close();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error reading logs.txt ", e);
        }
    }

    @Override
    public void destroy() {
        try {
            Logger.log("Logger servlet destroyed ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

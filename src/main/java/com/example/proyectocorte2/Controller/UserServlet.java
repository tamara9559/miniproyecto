package com.example.proyectocorte2.Controller;

import Service.UserService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet({"/user", "/user.html"})
public class UserServlet extends HttpServlet {

    @Inject
    private LoginSessionServlet auth;

    @Inject
    private UserService users;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Optional<String> usernameOptional = auth.getUsername(req);

        resp.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = resp.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Listado de Usuarios</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Listado de Usuarios!</h1>");

            if (usernameOptional.isPresent()) {
                out.println("<p> Hola " + usernameOptional.get() + " Bienvenido! </p>");
            }

            out.println("<table>");
            out.println("<tr>");
            out.println("<th>id</th>");
            out.println("<th>nombre</th>");
            out.println("<th>apellido</th>");

            if (usernameOptional.isPresent()) {
                out.println("<th>Numero Telefonico</th>");
                out.println("<th>contraseña</th>");
            }

            out.println("</tr>");

            users.list().forEach(user -> {
                out.println("<tr>");
                out.println("<td>" + user.id() + "</td>");
                out.println("<td>" + user.username() + "</td>");
                out.println("<td>" + user.email() + "</td>");

                if (usernameOptional.isPresent()) {
                    out.println("<td>" + user.password()+ "</td>");
                }

                out.println("</tr>");
            });

            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}

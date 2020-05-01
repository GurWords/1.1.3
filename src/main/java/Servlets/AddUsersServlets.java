package Servlets;

import Model.User;
import Service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addusers")
public class AddUsersServlets extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Long age = Long.parseLong(req.getParameter("age"));
        User user = new User.Builder().withName(name).withAge(age).build();
        UsersService.getInstance().insertUser(user);

        req.getRequestDispatcher("users.jsp").forward(req, resp);
    }
}

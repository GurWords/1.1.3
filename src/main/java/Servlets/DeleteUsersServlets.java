package Servlets;

import Model.User;
import Service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteusers")
public class DeleteUsersServlets extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nameDelete = req.getParameter("nameDelete");
        Long ageDelete = Long.parseLong(req.getParameter("ageDelete"));
        User userDelete = new User.Builder().withName(nameDelete).withAge(ageDelete).build();
        UsersService.getInstance().deleteUser(userDelete);
        req.getRequestDispatcher("users.jsp").forward(req, resp);
    }
}

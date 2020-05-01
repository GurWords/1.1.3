package Servlets;

import Model.User;
import Service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/updateusers")
public class UpdateUsersServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("name_old",req.getParameter("name_old"));
        httpSession.setAttribute("age_old",req.getParameter("age_old"));
        req.getRequestDispatcher("updateusers.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name_new = req.getParameter("name_new");
        Long age_new = Long.parseLong(req.getParameter("age_new"));
        Long id = UsersService.getInstance().getIdByName((String)req.getSession().getAttribute("name_old"));
        User newUser = new User.Builder().withId(id).withName(name_new).withAge(age_new).build();
        UsersService.getInstance().updateUser(newUser);
        req.getRequestDispatcher("users.jsp").forward(req, resp);
    }
}

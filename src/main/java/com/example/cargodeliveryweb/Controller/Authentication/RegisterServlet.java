package com.example.cargodeliveryweb.Controller.Authentication;
import com.example.cargodeliveryweb.Model.Security.MD5;
import com.example.cargodeliveryweb.Model.Security.UserService;
import com.example.cargodeliveryweb.Model.Security.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
    private UserService userService;
    public void init(){
        userService = new UserService();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("register_account.jsp");
        dispatcher.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        registerUser(request,response);
    }
    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String role = request.getParameter("roles");
        String password = request.getParameter("password");
        String verifyPassword = request.getParameter("verify_password");
        if(password.equals(verifyPassword)) {
            User user = new User(email, role, MD5.encrypt(password));
            int result = userService.registerUser(user);
            System.out.println(result);

            if (result == 0) {
                //Update with response to notify that cargo was not registered
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/cargo");
            dispatcher.forward(request, response);
        }

    }
}

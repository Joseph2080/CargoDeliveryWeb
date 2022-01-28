package com.example.cargodeliveryweb.Controller.Authentication;

import com.example.cargodeliveryweb.Model.Security.UserService;
import com.example.cargodeliveryweb.Model.Security.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserService userService;
    public void init(){
        userService = new UserService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login_screen.jsp");
            dispatcher.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        login(request,response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        if(userService.verifyUser(email,password)){
                String role = userService.getRole();
                int id = userService.getId();
                session.setAttribute("userEmail",email);
                session.setAttribute("role",role);
                session.setAttribute("id",id);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/cargo");;

                if(role.equals("manager")){
                    dispatcher = request.getRequestDispatcher("/admin");
                }
                dispatcher.forward(request, response);
        }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("authentication_failed.jsp");
            dispatcher.forward(request,response);
        }
    }



}

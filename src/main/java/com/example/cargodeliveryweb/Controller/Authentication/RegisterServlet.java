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
import java.util.regex.Pattern;

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

        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";


        boolean matches = Pattern
                .compile(regexPattern)
                .matcher(email)
                .matches();

        if(password.equals(verifyPassword)&&matches) {
            User user = new User(email, role, MD5.encrypt(password));
            int result = userService.registerUser(user);
            System.out.println(result);

            if (result == 0) {
                //Update with response to notify that cargo was not registered
                response.sendRedirect("registration_failed.jsp");
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/cargo");
            if(role.equals("manager")){
                dispatcher = request.getRequestDispatcher("/admin");
            }
            dispatcher.forward(request, response);
        }else{
            response.sendRedirect("registration_failed.jsp");
        }

    }
}

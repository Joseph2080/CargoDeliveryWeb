package com.example.cargodeliveryweb.Controller.Cargo;

import com.example.cargodeliveryweb.Model.Cargo.CargoService;
import com.example.cargodeliveryweb.Model.Security.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cargoDelivered")
public class ConfirmDeliveryServlet extends HttpServlet {

    private CargoService cargoService;
    public void init(){
        cargoService = new CargoService();
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            cargoService.cargoDelivered(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("cargo_delivered.jsp");
            dispatcher.forward(request, response);
    }
}

package com.example.cargodeliveryweb.Controller.Cargo;

import com.example.cargodeliveryweb.Model.Cargo.Cargo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/calculateCargo")
public class GenerateCargoFare extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("calculate_cargo_fare.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cargoType = request.getParameter("types");
        double weight = Double.parseDouble(request.getParameter("weight"));
        double volume = Double.parseDouble(request.getParameter("volume"));
        String country = request.getParameter("country");
        double calcluate = Cargo.calculateDelivery(cargoType,weight,volume,country);
        request.setAttribute("cost",calcluate);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cargo_fee.jsp");
        dispatcher.forward(request,response);
    }

}

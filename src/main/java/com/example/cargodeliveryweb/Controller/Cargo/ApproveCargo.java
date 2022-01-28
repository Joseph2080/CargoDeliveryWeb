package com.example.cargodeliveryweb.Controller.Cargo;

import com.example.cargodeliveryweb.Model.Cargo.CargoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/approveCargo")
public class ApproveCargo extends HttpServlet {

    private CargoService cargoService;
    public void init(){
        cargoService = new CargoService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int result = cargoService.cargoApproved(id);
        if(result!=0) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("cargo_approved.jsp");
            dispatcher.forward(request, response);
        }
    }
}

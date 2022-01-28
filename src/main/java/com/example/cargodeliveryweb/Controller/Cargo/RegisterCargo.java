package com.example.cargodeliveryweb.Controller.Cargo;

import com.example.cargodeliveryweb.Model.Cargo.Cargo;
import com.example.cargodeliveryweb.Model.Cargo.CargoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/registerCargo")

    public class RegisterCargo extends HttpServlet {
    CargoService service;
    public void init(){
        service =  new CargoService();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("register_cargo.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session!=null){
            registerCargo(request, response,session);
        }else{
            response.sendRedirect("login_screen.jsp");
        }
    }

    private void registerCargo(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws ServletException, IOException{

        String cargoType = request.getParameter("types");
        double weight = Double.parseDouble(request.getParameter("weight"));
        double volume = Double.parseDouble(request.getParameter("volume"));
        String startDateStr = request.getParameter("delivery_date");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //surround below line with try catch block as below code throws checked exception
        Date date = null;
        try {
            date = sdf.parse(startDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String street = request.getParameter("street");
        String town = request.getParameter("town");
        String country = request.getParameter("country");
        String postCode = request.getParameter("postal_code");
        int id = Integer.parseInt(session.getAttribute("id").toString());
        Cargo cargo = new Cargo(cargoType,weight,volume,date,street,town,country,postCode,false,false,id);

        try {
            int result = service.registerCargo(cargo);

            if(result == 0){
                //Update with response to notify that cargo was not registered
                response.sendRedirect("authentication_failed.jsp");
            }else{
                response.sendRedirect("cargo_list.jsp");

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

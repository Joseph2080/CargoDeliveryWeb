package com.example.cargodeliveryweb.Controller.Cargo;



import com.example.cargodeliveryweb.Model.Cargo.Cargo;
import com.example.cargodeliveryweb.Model.Cargo.CargoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//This class is the controller which has similar tasks as the servlet.
@WebServlet("/cargo")
public class CargoController extends HttpServlet {
    CargoService service;
    public void init(){
        service =  new CargoService();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listCargo(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws  IOException, ServletException {
        String action = request.getServletPath();

            switch (action) {
                case "cargo/new":
                    registerCargo(request, response);
                    break;
                default:
                    listCargo(request, response);
                    break;
            }
    }

    private void listCargo( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Cargo> listCargo = service.getCargoList();
        request.setAttribute("listCargo", listCargo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("cargo_list.jsp");
        dispatcher.forward(request, response);
    }

    private void registerCargo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String cargoType = request.getParameter("cargo_type");
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
        Cargo cargo = new Cargo(cargoType,weight,volume,date,street,town,country,postCode);

        try {
            int result = service.registerCargo(cargo);
            System.out.println(result);
            response.sendRedirect("cargo_list.jsp");
            if(result == 0){
                //Update with response to notify that cargo was not registered
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}

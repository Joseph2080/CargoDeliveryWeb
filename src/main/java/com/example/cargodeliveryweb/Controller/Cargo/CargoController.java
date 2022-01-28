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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//This class is the controller which has similar tasks as the servlet.
@WebServlet({"/","/cargo"})
public class CargoController extends HttpServlet {
    CargoService service;
    public void init(){
        service =  new CargoService();
    }


    //Search
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listCargo(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws  IOException, ServletException {

        if(request!=null||response!=null) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                String role = session.getAttribute("role").toString();
                listCargo(request, response);
            } else {
                response.sendRedirect("login_screen.jsp");
            }
        }else{
            response.sendRedirect("login_screen.jsp");
        }

    }

    private void listCargo( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        HttpSession session = request.getSession();
        if(session!=null) {
            String email = session.getAttribute("userEmail").toString();
            String role = session.getAttribute("role").toString();
            String search = request.getParameter("searchCargo");
            String sort = request.getParameter("filter");
            List<Cargo> listCargo = service.getCargoList(email,false);
            if (sort != null && listCargo != null) {
                if (!listCargo.isEmpty()) {
                    if (sort.contains("Sort By Cargo ID")) {
                        Collections.sort(listCargo, Cargo.compareById);
                    } else if (sort.contains("Sort By Type")) {
                        Collections.sort(listCargo, Cargo.compareByType);
                    } else if (sort.contains("Sort By Country")) {
                        Collections.sort(listCargo, Cargo.compareByCountry);
                    }
                }
            }

            request.setAttribute("listCargo", listCargo);
            if (search != null) {
                if (!search.isEmpty()) {
                    Collections.sort(listCargo, Cargo.compareById);
                    request.setAttribute("listCargo", search(listCargo, search));
                } else {
                    request.setAttribute("listCargo", listCargo);
                }
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("cargo_list.jsp");

            if(role.equals("manager")){
                dispatcher = request.getRequestDispatcher("/admin");
            }
            dispatcher.forward(request, response);
        }
    }

    private List<Cargo> search(List<Cargo> list,String value){

        List<Cargo> temp = new ArrayList<>();
        for(Cargo cargo:list){
            try{
                int id = Integer.parseInt(value);
                if(cargo.getCargoId()==id){
                    temp.add(cargo);
                }
            }catch(NumberFormatException nE){
                if(cargo.getCargoType().contains(value)||cargo.getAddress().contains(value)){
                    temp.add(cargo);
                }
            }
        }
        return temp;
    }



}

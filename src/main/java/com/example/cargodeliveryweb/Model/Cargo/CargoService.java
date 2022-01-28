package com.example.cargodeliveryweb.Model.Cargo;


import com.example.cargodeliveryweb.Model.Cargo.Cargo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CargoService {

    private static final String SELECT_UPCOMING_CARGOS = "select * from cargodb.tblcargo where deliveryDate > getdate(); ";

    public int registerCargo(Cargo cargo) throws ClassNotFoundException {
            String insert_cargo = "INSERT INTO tblcargo(CargoType, weight, volume, deliveryDate,street,town, country, postalCode,userId,delivered,approved) VALUES(?,?,?,?,?,?,?,?,?,?,?);";
            int result = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");

        try(Connection connection =getConnection()){

                PreparedStatement preparedStatement = connection.prepareStatement(insert_cargo);
                preparedStatement.setString(1,cargo.getCargoType());
                preparedStatement.setDouble(2,cargo.getWeight());
                preparedStatement.setDouble(3,cargo.getVolume());
                java.sql.Date sqlDate=new java.sql.Date(cargo.getDeliveryDate().getTime());
                preparedStatement.setDate(4,sqlDate);
                preparedStatement.setString(5,cargo.getAddressArr()[0]);
                preparedStatement.setString(6,cargo.getAddressArr()[1]);
                preparedStatement.setString(7,cargo.getAddressArr()[2]);
                preparedStatement.setString(8,cargo.getAddressArr()[3]);
                preparedStatement.setInt(9,cargo.getUserId());
                preparedStatement.setBoolean(10,false);
                preparedStatement.setBoolean(11,false);

                result = preparedStatement.executeUpdate();
                System.out.println(cargo);

            }catch(SQLException se){
                printSQLException(se);
            }
            return result;
        }

        protected Connection getConnection(){
            Connection connection = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cargodb?useSSL=false","root","Sandile12");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return connection;
        }

        public List<Cargo> getCargoList(String email,boolean admin){
        String SELECT_ALL_CARGOS = "select cargoId,cargoType,weight,volume,deliveryDate,street,town,country,postalCode,delivered,approved\n" +
                "from tblcargo INNER JOIN tbluser t on tblcargo.userId = t.userId\n" +
                "where email = '" + email + "'and approved = 1;";
        if(admin){
            SELECT_ALL_CARGOS  = "select*\n" +
                    "from tblcargo where approved = false;";
        }
        List<Cargo> cargoList = new ArrayList<>();
        // Step 1: Establishing a Connection
            try (Connection connection = getConnection();

                 // Step 2:Create a statement using connection object
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CARGOS);) {
                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                ResultSet rs = preparedStatement.executeQuery();

                // Step 4: Process the ResultSet object.
                while (rs.next()) {
                    int id = rs.getInt("cargoId");
                    String cargoType = rs.getString("CargoType");
                    double weight = rs.getDouble("weight");
                    double volume = rs.getDouble("volume");
                    Date date = rs.getDate("deliveryDate");
                    String street = rs.getString("street");
                    String town = rs.getString("town");
                    String country = rs.getString("country");
                    String postalCode = rs.getString("postalCode");
                    boolean delivered = rs.getBoolean("delivered");
                    boolean confirmed = rs.getBoolean("approved");
                    System.out.println(cargoType);
                    cargoList.add(new Cargo(id, cargoType, weight, volume, date, street, town, country, postalCode, delivered,confirmed));

                }
            } catch (SQLException e) {
                printSQLException(e);
            }
            return cargoList;
        }

        public int cargoDelivered(int cargoId){
            String updateCargo = "update tblcargo " +
                    "set delivered = 1\n" +
                    "where cargoId = " + cargoId + "; ";
            try(Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(updateCargo);){
                return preparedStatement.executeUpdate();

            } catch (SQLException e) {
                printSQLException(e);
                return 0;
            }
        }

    public int cargoApproved(int cargoId){
        String updateCargo = "update tblcargo " +
                "set approved = 1\n" +
                "where cargoId = " + cargoId + "; ";
        try(Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(updateCargo);){
            return preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
            return 0;
        }
    }

        public int approveCargo(int cargoId){
            String approveCargo = "update tblcargo set confirmed = 1\n" +
                    "where cargoId = " + cargoId + ";";
            try(Connection connection = getConnection();

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(approveCargo);){
                return preparedStatement.executeUpdate();

            } catch (SQLException e) {
                printSQLException(e);
                return 0;
            }
        }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

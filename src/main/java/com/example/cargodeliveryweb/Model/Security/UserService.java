package com.example.cargodeliveryweb.Model.Security;

import com.example.cargodeliveryweb.Model.Security.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    protected Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
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
    public int registerUser(User user){
        String insert_user = "INSERT INTO cargodb.tbluser(email, role, password) VALUES(?,?,?); ";
        int result = 0;
        try(Connection connection =getConnection()){

            PreparedStatement preparedStatement = connection.prepareStatement(insert_user);
            preparedStatement.setString(1,user.getEmail());
            preparedStatement.setString(2,user.getRole());
            preparedStatement.setString(3,user.getPassword());
            System.out.println(user);
            result = preparedStatement.executeUpdate();

        }catch(SQLException se){
            printSQLException(se);
        }
        return result;
    }

    public boolean verifyUser(String e,String p){
        String VERIFY_USER = "select* from cargodb.tbluser;";
        List<User> userList = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(VERIFY_USER)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            int count = 0;
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("userId");
                String email = rs.getString("email");
                String role = rs.getString("role");
                String password = rs.getString("password");
                if(email.equals(e)&&password.equals(MD5.encrypt(p))){
                    return true;
                }
                count++;
            }
            return false;
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
            return false;
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

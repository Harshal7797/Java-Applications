package ca.jrvs.apps.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCExecutor {
    public static void main(String[] args) {
        DatabseConnectionManager dcm =new DatabseConnectionManager("localhost","hplussport","postgres","password");
        try{
            Connection connection = dcm.getConnection();

           //Ordering by lastname, firstname and Limiting the result by 20 and Paging
           CustomerDAO customerDAO= new CustomerDAO(connection);
           customerDAO.findAllSorted(20).forEach(System.out::println);
            System.out.println("Paged");
            for (int i = 1 ;i <3 ; i++) {
                System.out.println("Page Number "+i);
                customerDAO.findAllPaged(10,i).forEach(System.out::println);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
package jdbc;

import java.sql.*;

public class MyJDBC02 {

    public static void main(String[] args) {

        Connection connection = null;

        try{
            Connection connection1 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc", "root", "");

            PreparedStatement consultaPrep = connection1.prepareStatement("INSERT INTO estudiante (dni, nombre, apellido) VALUES (?,?,?)");

            connection1.setAutoCommit(false);

            consultaPrep.setInt(1, 42998836);
            consultaPrep.setString(2, "Gonzalo");
            consultaPrep.setString(3, "Acero");
            consultaPrep.executeUpdate();

            String consultaSQL = "SELECT * FROM estudiante";

            ResultSet resultSet = consultaPrep.executeQuery("SELECT * FROM estudiante");

            connection1.commit();

            while (resultSet.next()){
                System.out.println(resultSet.getString("id") + " " + resultSet.getString("nombre") + " " + resultSet.getString("apellido") + " " + resultSet.getString("dni")); // muestro los datos
            }

        } catch (SQLException sqlException){

            System.out.println(sqlException);
            if(connection != null){
                try{
                    connection.rollback();
                } catch (SQLException sqlException1){
                    System.out.println(sqlException1);
                }
            }

        }finally{

            try{
                if(connection != null){
                    connection.close();
                }
            }catch (SQLException sqlException){
                System.out.println(sqlException);
            }

        }

    }

}

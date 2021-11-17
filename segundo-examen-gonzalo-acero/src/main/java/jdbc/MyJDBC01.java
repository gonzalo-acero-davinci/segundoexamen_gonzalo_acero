package jdbc;

import java.sql.*;

public class MyJDBC01 {


    public static void main(String[] args) {
        Connection connection = null;

        try {
            Connection conection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc", "root", ""); // se establece la conexion

            Statement statement = conection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM estudiante"); // se ejecuta la query para mostrar todos los datos

            while (resultSet.next())
            {
                System.out.println(resultSet.getString("id") + " " + resultSet.getString("nombre") + " " + resultSet.getString("apellido") + " " + resultSet.getString("dni")); // muestro los datos



            }
        } catch (SQLException sqlE){

            System.out.println(sqlE);

        }finally {
            try {
                    if(connection != null){
                        connection.close(); // se cierra la conexion cuando es distinta de null
                    }
            } catch (SQLException sqlEx){
                System.out.println(sqlEx);
            }
        }
    }


}

package JDBC;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        String userName = "1TEST";
        String password = "1";
        String connectionURL = "jdbc:firebirdsql://10.4.5.180:3050/W:/Exchange/35_ADMIN_KIEV.FDB?encoding=WIN1251";

        Class.forName("org.firebirdsql.jdbc.FBDriver");

        try (Connection connection = DriverManager.getConnection(connectionURL, userName, password);) {
            System.out.println("Connected");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select userid, orgid, realname from dbuser where userid = -15");

//            PreparedStatement preparedStatement = connection.prepareStatement("select userid, orgid, realname from dbuser where userid = ?");
//            preparedStatement.setInt(1, 125);
//            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.print("USERID = " + resultSet.getInt("userid") + " ");
                System.out.print("ORGID = " + resultSet.getInt("orgid") + " ");
                System.out.println("REALNAME = " + resultSet.getString("realname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

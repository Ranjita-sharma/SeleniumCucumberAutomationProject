package qaFactory;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import java.sql.*;

public class DBConnections {
    int userId = 0;
    @Test
    public void DB() throws SQLException {

       // int  userId = 10148;
        String userEmail = "ranjeeta@lendo.sa";
        Connection con = connect_to_db("stg_user_service", "dblenadmin", "lendbk3s");
        ResultSet rs = read_data( con, userEmail);
        System.out.println("Result id : "+ rs.getInt("id"));
        System.out.println("Result email : "+ rs.getString("email"));
        if (rs.getString("email") .equals(userEmail)   ) {
              update_user_data(con,userEmail);
              update_investor_data(con,userId);
            //  get_otp(con);
           //   update_email_verification(con);
              String query2 = String.format("Select * from Users where id =" +userId );
              Statement statement = con.createStatement();
                rs = statement.executeQuery(query2);
                System.out.println("rs "+ rs);
        } else {
            System.out.println("Email is not exist");
        }

    }

    public void update_email_verification() {
        Statement stmt = null;
        Connection con = connect_to_db("stg_user_service", "dblenadmin", "lendbk3s");
      //  ResultSet rs = read_data( con, userEmail);
        try {
            con.setAutoCommit(false);
            stmt = con.createStatement();
            String email = "ranjeeta@lendo.sa";
            String sql = String.format("UPDATE users "
                    + "SET email_verified = true  "
                    + "WHERE email = '"+ email+"'" );
            System.out.println("Sql : "+ sql);
            stmt.executeUpdate(sql);
            con.commit();
            ResultSet rs = stmt.executeQuery("SELECT * from users where email ='" + email+"'");
            while (rs.next()) {
                String firstName = rs.getString("firstName");
                System.out.println("firstName = " + firstName);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Email Verified successfully");
    }
    public String get_otp_ChangePassword() {
        Connection con = connect_to_db("stg_user_service", "dblenadmin", "lendbk3s");
        //  ResultSet rs = read_data( con, userId);
        Statement statement;
        ResultSet rs = null;
        String otp = null;
        try {
            String phone_number = "+966534221248";
            statement = con.createStatement();
            String query = String.format("Select * from phone_number_otp_details where phone_number like '" + phone_number + "' and otp_type = 'changePassword'");
            System.out.println("Get OTP query" + query);
            rs = statement.executeQuery(query);
            while (rs.next()) {
                otp = rs.getString("otp");
                System.out.println("otp = " + otp);
                return otp;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("OTP created successfully");
        return otp;
    }
    public String get_otp() {
        Connection con = connect_to_db("stg_user_service", "dblenadmin", "lendbk3s");
      //  ResultSet rs = read_data( con, userId);
        Statement statement;
        ResultSet rs = null;
        String otp = null;
        try {
            String phone_number = "+966534221248";
            statement = con.createStatement();
            String query = String.format("Select * from phone_number_otp_details where phone_number like '" + phone_number + "' and otp_type = 'signup'");
            System.out.println("Get OTP query" + query);
            rs = statement.executeQuery(query);
            while (rs.next()) {
                otp = rs.getString("otp");
                System.out.println("otp = " + otp);
                return otp;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("OTP created successfully");
        return otp;
    }

    public Connection connect_to_db(String dbname, String username, String password) {
        System.out.println("connection db name" + dbname +" username " + username + " password " + password);
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(
                    "jdbc:postgresql://10.0.1.66:5432/" + dbname, username, password);
            System.out.println("conn "+ con);
            if (con != null) {
                System.out.println("Connection established");
            } else {
                System.out.println("Connection failed");
            }


        } catch (Exception e) {
            System.out.println(e);

        }
        return con;
    }

    public ResultSet read_data(Connection con, String userEmail) {
        Statement statement;
        ResultSet rs = null;
        try {
            statement = con.createStatement();
            String query = String.format("Select * from Users where email ='" + userEmail+"'" );
            System.out.println("read data query "+ query);
            rs = statement.executeQuery(query);
            if (rs.next()) {
                System.out.println("User is exist");
                userId = rs.getInt("id");
            } else {
                System.out.println("User is not exist");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    public void read_dataWithFirstName(Connection con, String tablename) {
        Statement statement;
        ResultSet rs = null;
        // Scanner sc = new Scanner(System.in);
        try {
            String query = String.format("Select * from %s", tablename);
            statement = con.createStatement();
            //  String email =sc.next();
            //    String query = String.format("Select * from Users where firstname ='" + firstname + "'");
            rs = statement.executeQuery(query);

            //stmt.executeUpdate(sql);
            // con.commit();
            while (rs.next()) {
                System.out.println(rs.getString("firstname") + " ");

//            if (rs.next()) {
//                System.out.println("Email is exist");
//         String randNum = RandomStringUtils.randomNumeric(10);
//        System.out.println("Random number is : " + randNum );
//
//        String ranString = RandomStringUtils.randomAlphanumeric(3);
//        System.out.println("random string is : " + ranString);
                //   update_data(con, "Users", UserEmail, UserEmail+ranString , "+919211057857", "+91"+randNum);
//                String query2 = String.format("Select * from Users where email ='" +UserEmail + "'");
//                rs = statement.executeQuery(query2);
//            } else {
//                System.out.println("Email is not exist");
//            }
//
//        } catch (Exception e) {
//            System.out.println(e);
//
//        }

                //       return rs;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void update_user_data(Connection con,  String  userEmail) {
        Statement stmt = null;

        try {
            con.setAutoCommit(false);
            stmt = con.createStatement();
            String randNum = RandomStringUtils.randomNumeric(10);
            System.out.println("Random Phone number is : " + randNum );
            String ranString = RandomStringUtils.randomAlphanumeric(3);
            System.out.println("Random Email is : " + ranString);
            String sql = String.format("UPDATE users "
                    + "SET phone_number = '"+ randNum +"' , email = '"+ranString+"'  "
                    + "WHERE id = "+ userId );
            System.out.println("Sql : "+ sql);
            stmt.executeUpdate(sql);
            con.commit();
            ResultSet rs = stmt.executeQuery("SELECT * from users where id =" + userId);
            while (rs.next()) {
                String phone_number = rs.getString("phone_number");
                String email = rs.getString("email");
//                userId = rs.getInt("id");
                System.out.println("phone number = " + phone_number);
                System.out.println("email = " + email);

            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("User data updated successfully");
    }

    public void update_investor_data(Connection con,  int  userId) {
        Statement stmt = null;

        try {
            con.setAutoCommit(false);
            stmt = con.createStatement();
            String randNum = RandomStringUtils.randomNumeric(10);
            System.out.println("Random Iqama number is : " + randNum );
            String sql = String.format("UPDATE investor "
                    + "SET iqama_id = "+ randNum
                    + " WHERE user_id = "+ userId );
            System.out.println("Update investor Sql : "+ sql);
            stmt.executeUpdate(sql);
            con.commit();
            ResultSet rs = stmt.executeQuery("SELECT * from investor where user_id =" + userId);
            while (rs.next()) {
                String iqamaId = rs.getString("iqama_id");
                System.out.println("new Iqama = " + iqamaId);
                System.out.println();
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Investor data updated successfully");
    }


    public void update_datawithfirstname(Connection con, String tablename, String oldfirstName, String newfirstName) {
        Statement stmt = null;

        try {
  //          con.setAutoCommit(false);

//            String sql = String.format("UPDATE users "
//                    + "SET phone_number = '+966333969856' "
//                    + "WHERE email = ' " + oldEmail + "'");
            String sql = String.format("update %s  set firstname ='%s' where firstname = '%s'",tablename,newfirstName,oldfirstName);
            stmt = con.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("data updated");
         //   con.commit();
//            ResultSet rs = stmt.executeQuery("SELECT * from users where email ='" + oldEmail+ "'");
//            while (rs.next()) {
//                //String id = rs.getInt("email");
//                String phone_number = rs.getString("phone_number");
//                String email = rs.getString("email");
//                System.out.println("phone number = " + phone_number);
//                System.out.println("email = " + email);
//                System.out.println();
//            }
//            rs.close();
//            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
    public void update_datawithPN(Connection con, String tablename, String oldphoneNumber, String newphoneNumber) {
        Statement stmt = null;

        try {
            //          con.setAutoCommit(false);

//            String sql = String.format("UPDATE users "
//                    + "SET phone_number = '+966333969856' "
//                    + "WHERE email = ' " + oldEmail + "'");
            String sql = String.format("update %s  set phone_number ='%s' where firstname = '%s'",tablename,newphoneNumber,oldphoneNumber);
            stmt = con.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("data updated");
            //   con.commit();
//            ResultSet rs = stmt.executeQuery("SELECT * from users where email ='" + oldEmail+ "'");
//            while (rs.next()) {
//                //String id = rs.getInt("email");
//                String phone_number = rs.getString("phone_number");
//                String email = rs.getString("email");
//                System.out.println("phone number = " + phone_number);
//                System.out.println("email = " + email);
//                System.out.println();
//            }
//            rs.close();
//            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
    public void update_datawithEmail(Connection con, String tablename, String oldEmail, String newEmail) {
        Statement stmt = null;

        try {
            //          con.setAutoCommit(false);

//            String sql = String.format("UPDATE users "
//                    + "SET phone_number = '+966333969856' "
//                    + "WHERE email = ' " + oldEmail + "'");
            String sql = String.format("update %s  set email ='%s' where email = '%s'",tablename,newEmail,oldEmail);
            stmt = con.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("data updated");
            //   con.commit();
//            ResultSet rs = stmt.executeQuery("SELECT * from users where email ='" + oldEmail+ "'");
//            while (rs.next()) {
//                //String id = rs.getInt("email");
//                String phone_number = rs.getString("phone_number");
//                String email = rs.getString("email");
//                System.out.println("phone number = " + phone_number);
//                System.out.println("email = " + email);
//                System.out.println();
//            }
//            rs.close();
//            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
           System.out.println("Operation done successfully");
    }
}

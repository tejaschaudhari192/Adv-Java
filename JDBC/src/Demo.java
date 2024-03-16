import java.sql.*;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

//
        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5050/demo";
        String user = "postgres";
        String password = "1922";
        Connection conn = DriverManager.getConnection(url,user,password );
        System.out.println("Connection successful");

        Statement st = conn.createStatement();

        String searchQuery = "select * from student";
//        System.out.println(res.next());
//        String name = res.getString("name");
//        System.out.println(name);
        String insertQuery = "insert into student values(3, 'sagar',90);";
//        boolean isInserted = st.execute(insertQuery);
//        System.out.println(isInserted);

        String updateQuery = "update student set marks = 80 where name = 'uday'";
//        boolean isUpdate = st.execute(updateQuery);
//        System.out.println(isUpdate);

        String deleteQuery = "delete from student where name = 'sagar'";
//        boolean isDelete = st.execute(deleteQuery);
//        System.out.println(isDelete);

        ResultSet res = st.executeQuery(searchQuery);

        while (res.next()) {
            int rn = res.getInt("roll no");
            String name = res.getString("name");
            int marks = res.getInt("marks");
            System.out.println(rn+ " " +name+" "+marks);

        }
        conn.close();


    }
}

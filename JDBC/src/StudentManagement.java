import java.sql.*;
import java.util.Scanner;

public class StudentManagement {
//    Class.forName("org.postgresql.Driver");

    static String url = "jdbc:postgresql://localhost:5050/demo";
    static String user = "postgres";
    static String password = "1922";
    static Connection conn;

    static {
        try {
            conn = DriverManager.getConnection(url,user,password );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//        System.out.println("Connection successful");

    static Statement st;

    static {
        try {
            st = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public StudentManagement() throws SQLException {
    }

    static Scanner sc = new Scanner(System.in);


    private static boolean insertItem() throws SQLException {
        System.out.print("Enter Roll no of Student : ");
        int rn=sc.nextInt();
        System.out.print("Enter name of Student : ");
        String name=sc.next();
        System.out.print("Enter marks of Student : ");
        int marks=sc.nextInt();
        String insertQuery = "insert into student values("+rn+", '"+name+"',"+marks+");";
        return st.execute(insertQuery);
    }

    static void displayMenu() throws SQLException {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Read");
            System.out.println("2. Create");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    readItem();
                    break;
                case 2:
                    System.out.println(insertItem());

                    break;
                case 3:
                    updateItem();
                    break;
                case 4:
                    deleteItem();
                    break;
                case 5:

                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }

    private static void deleteItem() throws SQLException {
        String name = sc.next();
        String deleteQuery = "delete from student where name = '"+name+"'";

        st.executeQuery(deleteQuery);

    }

    private static void updateItem() {
        System.out.println("Out of Service, visit later :)");
        
    }

    private static void readItem() throws SQLException {
        String searchQuery = "select * from student";

        ResultSet res = st.executeQuery(searchQuery);

        while (res.next()) {
            int rn = res.getInt("roll no");
            String name = res.getString("name");
            int marks = res.getInt("marks");
            System.out.println(rn+ " " +name+" "+marks);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {



        displayMenu();

    }
}

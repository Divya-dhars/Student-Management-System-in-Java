import java.util.*;
import java.sql.*;
public class Students{
    Connection con=null;
    void CreateTable()throws Exception{
        String query="Create table Stud(Stud_id integer(20),Stud_name varchar(50),Stud_age integer(50),Stud_dob integer(50),Stud_addr varchar(50))";
        Statement stmt=(Statement)con.createStatement();
        int res=stmt.executeUpdate(query);
        System.out.println(res);
        if(res==0){
            System.out.println("Table Created");
        }
        else{
            System.out.println("Error!");
        }
    }
    void getConnection()throws Exception{
        con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","Divya29*");
        System.out.println(con);
    }
    void insert()throws Exception{
        Statement stmt1 =(Statement)con.createStatement();
        String query1="insert into mark values('Maths',90),('Tamil',99),('Science',98)";
        int res1=stmt1.executeUpdate(query1);
        System.out.println("Inserted");
        
    }
    void delete()throws Exception{
            Statement stmt2 =(Statement)con.createStatement();
            String query2="delete from mark where subject='Maths'";
            int res2=stmt2.executeUpdate(query2);
            System.out.println(res2);
            if(res2==0){
                System.out.println("Deleted");
            }
            else{
                System.out.println("Error:");
            }
        }
        void update()throws Exception{
            Statement stmt3 =(Statement)con.createStatement();
            String query3="update mark set score='90' where subject='Science'";
            int res3=stmt3.executeUpdate(query3);
            System.out.println(res3);
            if(res3==1){
                System.out.println("Updated");
            }
            else{
                System.out.println("Error:");
            }
        }
        void display()throws Exception{
            Statement st=con.createStatement();
            String q="Select * from mark";
            ResultSet  rs=st.executeQuery(q);
            while(rs.next()){
                System.out.println("Subject:" +rs.getString(1) + "Mark :" +rs.getInt(2));
            }
        }
    public static void main(String[] args)throws Exception{
        Students obj=new Students();
        obj.getConnection();
        //obj.CreateTable();
        //obj.insert();
       // obj.delete();
       //obj.update();
       obj.display();
    }
}   
package com.student.manage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

    public static boolean insertStudentToDB(Student st)
    {
        boolean f=false;
        try{

            Connection con = CP.createC();
            String q="insert into students(sname,sphone,scity) values(?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, st.getStudentName());
            pstmt.setString(2, st.getStudentPhone());
            pstmt.setString(3, st.getStudentCity());

            pstmt.executeUpdate();
            f=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public static boolean deleteStudent(int userID) {
        boolean f=false;
        try{

            Connection con = CP.createC();
            String q="delete from student where sid=?";
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1, userID);
            pstmt.executeUpdate();
            f=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public static boolean showAllStudent() {
        boolean f=false;
        try{

            Connection con = CP.createC();
            String q="select * from students;";
            Statement stmt = con.createStatement();
            

            ResultSet set = stmt.executeQuery(q);
            while(set.next())
            {
                int id=set.getInt(1);
                
                String name=set.getString(2);
                
                String phone=set.getString("sphone");
                
                String city=set.getString("scity");

                System.out.println("ID : "+ id);
                System.out.println("Name : "+ name);
                System.out.println("Phone : "+ phone);
                System.out.println("City : "+ city);
                System.out.println("===============================");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public static boolean updateStudent() {
        boolean f=false;
            try{
    
                Connection con = CP.createC();
                
                String q="update students set sname=?, sphone=?, scity=? where sid=?";
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                System.out.print("name:"+" ");
                String name=br.readLine();

                System.out.print("phone:"+" ");
				String phone=br.readLine();

                System.out.print("city:"+" ");
				String city=br.readLine();

				System.out.print("enter sid:"+" ");
                int userID=Integer.parseInt(br.readLine());
               
                PreparedStatement pstmt = con.prepareStatement(q);

                pstmt.setString(1, name);
                pstmt.setString(2, phone);
                pstmt.setString(3, city);
                pstmt.setInt(4, userID);

                pstmt.executeUpdate();
                f=true;

            }catch(Exception e){
                e.printStackTrace();
            }
            return f;
    }

    // public static boolean updateStudent(Student st) {
    //     boolean f=false;
    //     try{

    //         Connection con = CP.createC();
    //         String q="alter table students modify sname=?, sphone=?, scity=? where sid=?)";
            
           
    //         PreparedStatement pstmt = con.prepareStatement(q);
    //         pstmt.setString(1, st.getStudentName());
    //         pstmt.setString(2, st.getStudentPhone());
    //         pstmt.setString(3, st.getStudentCity());
    //         pstmt.setInt(4, st.getStudentID());
    //         pstmt.executeUpdate();
    //         f=true;
    //     }catch(Exception e){
    //         e.printStackTrace();
    //     }
    //     return f;
    // }

}

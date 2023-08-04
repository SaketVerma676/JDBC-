import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.Statement;

import java.sql.ResultSet;

public class StudentDao {
	
  public static boolean insertStudentToDb(Student st) {
	  
	  boolean f=false;
	  try {
		  Connection con = ConnectionProvider.createC();
		  String q ="insert into students(sname,sphone,scity) values(?,?,?)";
		  PreparedStatement pst=con.prepareStatement(q);
		  
		  //set values parameters
		  pst.setString(1,st.getStudentName());
		  pst.setString(2, st.getStudentPhone());
		  pst.setString(3, st.getStudentCity());
		  
		  // execute
		  pst.executeUpdate();
		  f=true;
		  
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	  return f;
  }

public static boolean deleteStudent(int userId) {
	// TODO Auto-generated method stub
	
	boolean f=false;
	  try {
		  Connection con = ConnectionProvider.createC();
		  String q ="delete from student where sid=?";
		  PreparedStatement pst=con.prepareStatement(q);
		  
		  //set values parameters
		  pst.setInt(1,userId);
		  
		  
		  // execute
		  pst.executeUpdate();
		  f=true;
		  
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	  return f;

	
}

public static void showAllStudents() {
	// TODO Auto-generated method stub
	boolean f=false;
	  try {
		  Connection con = ConnectionProvider.createC();
		  String q ="select * from students";
		  Statement st = con.createStatement();
		 ResultSet set= st.executeQuery(q);
		 
		 while(set.next()) {
			 int id=set.getInt(1);
			 String name =set.getString(2);
			 String phone=set.getString(3);
			 String city=set.getString(4);
			 
			 System.out.println("id" + id);
			 System.out.println("Name" + name);
			 System.out.println("phone" + phone);
			 System.out.println("city" + city);
			 System.out.println("--------");
			 
			 
		 }
	       
		  
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	 
}
}

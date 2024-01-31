package com.sms.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentMainpro {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	intro();
	//step :1
	Class.forName("com.mysql.cj.jdbc.Driver");
	Scanner s1=new Scanner(System.in);
	while(true) {
		intro();
		System.out.println("====================");
		System.out.println("choose the operation:");
		int o=s1.nextInt();
		
		switch (o) {
		case 1:
			System.out.println("====================");
			System.out.println("* INSERT RECORD *");
			System.out.println("=================");;
			System.out.println("choose the operation:");
			insert();
			System.out.println("===================\n");
			
			break;
		case 2:
			System.out.println("====================");
			System.out.println("* EDIT RECORD *");
			System.out.println("=================");;
			System.out.println("choose the operation:");
			edit();
			System.out.println("===================\n");
			break;
		case 3:
			view();
			break;
		case 4:
			System.out.println("====================");
			System.out.println("* DELETE RECORD *");
			System.out.println("=================");;
			System.out.println("choose the operation:");
			delete();
			System.out.println("===================\n");
			break;
		case 5:
			System.out.println("====================");
			System.out.println("* EXIT RECORD *");
			System.out.println("=================\n");;
			System.out.println("choose the operation:");
			System.exit(o);
			break;
			
		default:
			System.out.println("program stopped:");
			break;
		}
		}
	}

	
	

public static void delete() throws SQLException {
	String url="jdbc:mysql://localhost:3306/sms_db";
	Connection con=DriverManager.getConnection(url, "root", "mysql@2003");
	view();
	
	String q="DELETE FROM student_info WHERE (id=?);";
	PreparedStatement ps=con.prepareStatement(q);
	Scanner s=new Scanner(System.in);
	System.out.println("select ID to DELETE:");
	int id=s.nextInt();
	ps.setInt(1, id);
ps.executeUpdate();
System.out.println("Record deleted sucessfully");
	
	
}
public static void edit() throws SQLException {
	String url3="jdbc:mysql://localhost:3306/sms_db";
	Connection con3=DriverManager.getConnection(url3, "root", "mysql@2003");
	view();
	String query="UPDATE student_info SET Name =?,std =?,fname = ?,mobile=? WHERE (id= ?);";
		
	PreparedStatement ps=con3.prepareStatement(query);
	Scanner s=new Scanner(System.in);
	System.out.println("select the id to EDIT:");
	int i=s.nextInt();
	System.out.println("enter your name");
	s.nextLine();
	String n=s.nextLine();
	System.out.println("enter your class");
	String c=s.nextLine();
	System.out.println("enter your father name");
	String fn=s.nextLine();
	System.out.println("enter your Mobile no:");
	String mob=s.nextLine();
	

	ps.setString(1, n);
	ps.setNString(2, c);
	ps.setString(3, fn);
	ps.setString(4, mob);
	ps.setInt(5, i);
	ps.executeUpdate();
	System.out.println("Data updated sucessfully....");

}


public static void view() throws SQLException {
	String url1="jdbc:mysql://localhost:3306/sms_db";

	Connection con1=DriverManager.getConnection(url1, "root", "mysql@2003");

	Statement st=con1.createStatement();
	ResultSet rs=st.executeQuery("select*from student_info");
	System.out.println("ID | Name |std | father |Mobile");
	System.out.println("-------------------------------");
	while(rs.next()) {
		System.out.println(rs.getInt(1)+"|"+rs.getString(2)+"|"+rs.getString(3)
		+"|"+rs.getString(4)+"|"+rs.getNString(5));
	}
}
public static void insert()throws ClassNotFoundException, SQLException {
	Scanner s=new Scanner(System.in);
	String url="jdbc:mysql://localhost:3306/sms_db";
	Connection con=DriverManager.getConnection(url, "root", "mysql@2003");
	System.out.println("enter your name");
	s.nextLine();
	String n=s.nextLine();
	System.out.println("enter your class");
	String c=s.nextLine();
	System.out.println("enter your father name");
	String f=s.nextLine();
	System.out.println("enter your Mobile no:");
	String m=s.nextLine();
	String query="insert into student_info(name,std,fname,mobile)"
	+"value(?,?,?,?)";
	PreparedStatement ps=con.prepareStatement(query);
	ps.setString(1,n);
	ps.setString(2,c);
	ps.setString(3,f);
	ps.setString(4,m);
	
	ps.executeUpdate();
	System.out.println("Data inserted sucessfully....");

	
}
	public static void intro() { 
	System.out.println("***********");
	System.out.println("* STUDENT'S MODULE*");
	System.out.println("************");
	System.out.println("\n 1.insert");
	System.out.println("\n 2.edit");
	System.out.println("\n 3.view");
	System.out.println("\n 4.delete");
	System.out.println("\n 5.stop");{

}
}
}


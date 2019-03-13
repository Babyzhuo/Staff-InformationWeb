package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class userGetDAta implements IuserGetData {    
	public  Map<String,String> Select(String str){
		Map<String,String> bookmap = new HashMap<String,String >();
		String className = "com.mysql.jdbc.Driver"; 	    
		String url = "jdbc:mysql://127.0.0.1:3306/employees?characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&useSSL=false";
		String dbusername = "用户名";	    
		String password = "数据库密码";
		try {
			Class.forName(className);
			System.out.println("Success loading Mysql driver!");
			Connection cnn = DriverManager.getConnection(url, dbusername, password);
			System.out.println("Success connect Mysql server!");
			Statement stmt = cnn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT DISTINCT (e.emp_no ),d.dept_no,dept_name,first_name,last_name,title,salary,gender,birth_date,hire_date,dept_emp.from_date,dept_emp.to_date\r\n" + 
					"from employees AS e,departments AS d,dept_emp,salaries,titles \r\n" + 
					"WHERE e.emp_no =  dept_emp.emp_no and dept_emp.dept_no = d.dept_no \r\n" + 
					"  and e.emp_no = salaries.emp_no and e.emp_no = titles.emp_no\r\n" + 
					" and e.emp_no="+str+";");//调用sql语句从数据库中提取数据，存到resultset中。
			rs.last();
			if(rs.getRow() == 0) {
				return null;
			}else {
				rs.first();
				bookmap.put("e_emp_no", rs.getString("e.emp_no"));
				bookmap.put("d_dept_no", rs.getString("d.dept_no"));
				bookmap.put("dept_name", rs.getString("dept_name"));
				bookmap.put("first_name", rs.getString("first_name"));
				bookmap.put("last_name", rs.getString("last_name"));
				bookmap.put("title", rs.getString("title"));
				bookmap.put("salary", rs.getString("salary"));
				bookmap.put("gender", rs.getString("gender"));
				bookmap.put("birth_date", rs.getString("birth_date"));
				bookmap.put("hire_date", rs.getString("hire_date"));
				bookmap.put("dept_emp_from_date", rs.getString("dept_emp.from_date"));
				bookmap.put("dept_emp_to_date", rs.getString("dept_emp.to_date"));
			}	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error loading Mysql driver!");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("Error loading Mysql driver!");
			e.printStackTrace();
		}
		return bookmap;
	}
}



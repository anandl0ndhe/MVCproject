package in.anand.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.protocol.Resultset;

import in.anand.dbconnection.DBconnection;
import in.anand.user.User;
@WebServlet("/loginForm")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws IOException {
		
		PrintWriter out=  resp.getWriter();
		resp.setContentType("text/html");
		
		String myemail = req.getParameter("email1");
		String mypassword = req.getParameter("pass1");
		
		try {
			Connection con = DBconnection.getconnection();
			String sql = "select * from register where email=? and password=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, myemail);
			ps.setString(2, mypassword);
			ResultSet rs= ps.executeQuery();
			if(rs.next()) {
				User user = new User();
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setCity(rs.getString("city"));
				
				HttpSession session = req.getSession();
				session.setAttribute("session_user", user);
				RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
				rd.forward(req, resp);
			}else {
				out.println("<center><h1 style='color:red'>Email OR Password didnt match</h1></center>");
				RequestDispatcher rd = req.getRequestDispatcher("/login.html");
				rd.include(req, resp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}

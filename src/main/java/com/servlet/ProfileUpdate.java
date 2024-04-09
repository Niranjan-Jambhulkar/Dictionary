package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import com.java.MyProfileClass;

/**
 * Servlet implementation class ProfileUpdate
 */
public class ProfileUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession Session = request.getSession(false);
		String user = (String) Session.getAttribute("name");
		
		if(Session != null) {
			
			MyProfileClass mp = new MyProfileClass(user);
			String fname = mp.getfname();
			String lname = mp.getlname();
			String email = mp.getemail();
			String pass = mp.getpass();
			response.getWriter().println(fname + lname + email);
			request.setAttribute("fname", fname);
			request.setAttribute("lname", lname);
			request.setAttribute("email", email);
			request.setAttribute("user", user);
			request.setAttribute("pass", pass);
			request.getRequestDispatcher("SaveChange.jsp").forward(request, response);
		}
	}
}

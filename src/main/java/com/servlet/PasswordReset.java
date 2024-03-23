package com.servlet;

import com.java.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class PasswordReset
 */
public class PasswordReset extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordReset() {
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
		/*String mail = request.getParameter("email");*/
		String pass = request.getParameter("password");
		HttpSession Session = request.getSession(false);
		String mail = (String) Session.getAttribute("email");
		if(Session != null) {
			Reset rs = new Reset(mail, pass);
			int result = rs.status();
			if(result == 1) {
				response.getWriter().println("Pass change");
			}
			else {
				response.getWriter().println("Pass not change");
			}
		}
	}

}

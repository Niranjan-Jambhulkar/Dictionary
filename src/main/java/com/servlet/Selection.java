package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Selection
 */
public class Selection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Selection() {
        super();
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
		String select = request.getParameter("select");
		HttpSession Session = request.getSession(false);
		if(Session != null) {
		if(select == null) {
			//String na = (String) Session.getAttribute("us");
			//request.setAttribute("name", na);
			request.getRequestDispatcher("Home").forward(request, response);
		}
		switch(select) {
		case "Meaning":
			request.getRequestDispatcher("Home").forward(request, response);
			break;
			
		case "Add Word":
			request.getRequestDispatcher("AddWord").forward(request, response);
			break;
		}
		}
	}

}

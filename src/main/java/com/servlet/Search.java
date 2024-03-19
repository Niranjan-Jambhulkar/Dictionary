package com.servlet;

import com.java.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Search
 */
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
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
		String meaning = null;
		String word = request.getParameter("word");
		// make word capitalize
		SearchClass sc = new SearchClass(word);
		meaning = sc.status();
		if (meaning!=null) {
			request.setAttribute("a", meaning);
			request.getRequestDispatcher("Home.jsp").forward(request, response);
			//response.getWriter().println("Meaning: " + meaning);
		}
		else {
			response.getWriter().println("No Word Found");
		}
		
	}

}

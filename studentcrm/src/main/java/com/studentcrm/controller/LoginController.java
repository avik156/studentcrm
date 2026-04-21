package com.studentcrm.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.studentcrm.model.DBServiceImpl;



@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
        }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		DBServiceImpl service=new DBServiceImpl();
		service.connectDb();
		boolean status=service.loginStatus(email, password);
		
		if(status) {
			HttpSession session = request.getSession(true);
			session.setAttribute("email", email);
			session.setMaxInactiveInterval(60);
			
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/registration.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("error","Invalid userName/Password");
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

}

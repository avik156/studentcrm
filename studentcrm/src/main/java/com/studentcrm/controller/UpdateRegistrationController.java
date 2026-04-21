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




@WebServlet("/updateReg")
public class UpdateRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateRegistrationController() {
        super();
        }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		try {
			session.setMaxInactiveInterval(60);
			if(session.getAttribute("email")!=null) {
				String email=request.getParameter("email");
				String mobile=request.getParameter("mobile");
				
				request.setAttribute("email", email);
				request.setAttribute("mobile", mobile);
				
				RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/update_registration.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		try {
			session.setMaxInactiveInterval(60);
			if(session.getAttribute("email")!=null) {
				String email=request.getParameter("email");
				String mobile=request.getParameter("mobile");
				
				DBServiceImpl service=new DBServiceImpl();
				service.connectDb();
				service.updateRegistration(email,mobile);
				
				
				request.setAttribute("email","");
				request.setAttribute("mobile", "");
				request.setAttribute("msg","Mobile number is Updated");
				RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/update_registration.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

}

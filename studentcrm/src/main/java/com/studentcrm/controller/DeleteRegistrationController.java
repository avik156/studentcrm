package com.studentcrm.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;

import com.studentcrm.model.DBServiceImpl;



@WebServlet("/deleteReg")
public class DeleteRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteRegistrationController() {
        super();
        }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		try {
			session.setMaxInactiveInterval(60);
			if(session.getAttribute("email")!=null) {
				String email=request.getParameter("email");
				DBServiceImpl service =new DBServiceImpl();
				service.connectDb();
				service.deleteRegistration(email);
				
				ResultSet result = service.getStudents();
				request.setAttribute("result", result);
				RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/list_students.jsp");
				rd.forward(request, response);
				
			}else {
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
	
	}

}

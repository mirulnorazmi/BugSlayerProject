package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.DoctorService;

import java.io.IOException;
import java.sql.SQLException;

import bean.Doctor;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DoctorService doctorService;
	
	public void init() {
		doctorService = new DoctorService();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		Doctor doctor = new Doctor();
		doctor.setEmail(request.getParameter("email"));
		doctor.setPassword(request.getParameter("password"));
		
		try {
			if(doctorService.loginDoctor(doctor)) {
				HttpSession session = request.getSession();
				session.setAttribute("email", request.getParameter("email"));
				response.sendRedirect(request.getContextPath() + "/dashboard");
			}else {
				response.sendRedirect(request.getContextPath());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

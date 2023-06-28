package controller;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.ClinicService;
import services.DoctorService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import bean.Clinic;
import bean.Doctor;
import helper.EncryptDecryptPass;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClinicService clinicService;
	private DoctorService doctorService;
	private EncryptDecryptPass EDycript;

	public void init() {
		clinicService = new ClinicService();
		doctorService = new DoctorService();
		EDycript = new EncryptDecryptPass();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Clinic> listClinic = clinicService.selectAllClinics();
		request.setAttribute("clinicList", listClinic);
		System.out.println(request.getAttribute("clinicList"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);

		try {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = EDycript.encryptPassword(request.getParameter("password"));
			String phone = request.getParameter("phone");
			String specialization = request.getParameter("specialization");
			String clinic_name = request.getParameter("clinicName");
			int clinic_id = clinicService.getClinicId(clinic_name);
			System.out.println("Clinic_id : " + clinic_id);
			Doctor doctor = new Doctor(name, email, password, specialization, phone, clinic_id);
			
			if (doctorService.checkEmail(doctor)) {
				doctorService.insertDoctor(doctor);
				System.out.println("success created...");
				response.sendRedirect(request.getContextPath());
			}else {
				System.out.println("Email already exist...");
				response.sendRedirect(request.getContextPath() + "/register?error=102");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/register");
		}

	}

}

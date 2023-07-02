package controller.patient;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.AppointmentService;
import services.BillServices;
import services.DoctorService;
import services.PatientService;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import bean.Appointment;
import bean.Doctor;
import bean.Patient;

/**
 * Servlet implementation class CreatePatient
 */
@WebServlet("/add-patient")
public class CreatePatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatientService patientService;
	
	public void init() {
//		doctorService = new DoctorService();
		patientService = new PatientService();
//		appointmentService = new AppointmentService();
//		billService = new BillServices();
	}

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("create-patient.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String ic = request.getParameter("ic");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		try {
			Patient patient = new Patient(name, email, ic, phone, address);
			patientService.insertPatient(patient);
			response.sendRedirect(request.getContextPath()+"/my-patient");
			
		}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}

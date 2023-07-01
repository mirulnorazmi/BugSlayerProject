package controller.appointment;

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
import bean.Bill;
import bean.Doctor;

/**
 * Servlet implementation class CreateAppointment
 */
@WebServlet("/create-appointment")
public class CreateAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DoctorService doctorService;
	private PatientService patientService;
	private AppointmentService appointmentService;
	private BillServices billService;

	public void init() {
		doctorService = new DoctorService();
		patientService = new PatientService();
		appointmentService = new AppointmentService();
		billService = new BillServices();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateAppointment() {
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
		HttpSession session = request.getSession();
		Doctor doctor = new Doctor();
		doctor.setEmail((String) session.getAttribute("email"));
		Doctor doc = doctorService.getInformation(doctor);
//		request.setAttribute("doctor", doc);
		session.setAttribute("doctor", doc);

		RequestDispatcher dispatcher = request.getRequestDispatcher("create-appointment.jsp");
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
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String ic = request.getParameter("ic");
		Date date = Date.valueOf(request.getParameter("date"));
		Time time = Time.valueOf(request.getParameter("time"));
		String duration = request.getParameter("duration");

		

		System.out.println("email : " + email);
		System.out.println("ic : " + ic);
		System.out.println("date : " + date);
		System.out.println("time : " + time);
		System.out.println("duration : " + duration);

		try {
			int patient_id = patientService.getPatientIdbyEmailIc(email, ic);
			int doctor_id = (int) session.getAttribute("doctor_id");
			
			
			if (patient_id != 0) {
				
				int bill_id = billService.insertDefaultBill(date);
				Appointment appointment = new Appointment(doctor_id, patient_id, date, time, duration, bill_id);
				appointmentService.insertAppointment(appointment);
				response.sendRedirect(request.getContextPath() + "/my-appointment");
			} else {
//				error cannot find patient id by email and ic number
				doGet(request, response);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

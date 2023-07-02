package controller.patient;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AppointmentService;
import services.PatientService;

import java.io.IOException;
import java.util.List;

import bean.Appointment;
import bean.Patient;

/**
 * Servlet implementation class MyPatient
 */
@WebServlet("/my-patient")
public class MyPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatientService patientService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		patientService = new PatientService();
	}
	
    public MyPatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Patient> listPatient = patientService.selectAllPatient();
		request.setAttribute("listPatient", listPatient);
//		System.out.println();
		RequestDispatcher dispatcher = request.getRequestDispatcher("my-patients.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}

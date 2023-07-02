package controller.patient;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AppointmentService;
import services.BillServices;
import services.PatientService;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import bean.Appointment;
import bean.Bill;
import bean.Patient;

/**
 * Servlet implementation class EditPatient
 */
@WebServlet("/edit-patient")
public class EditPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatientService patientService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		patientService = new PatientService();
	}
    public EditPatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		Patient patient = new Patient();
		int id = Integer.parseInt(request.getParameter("id"));
		String success = request.getParameter("success");
		System.out.println("success : " + success);
		patient = patientService.getOnePatient(id);
		
		request.setAttribute("patient", patient);

		System.out.println(patient);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit-patient.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		int patient_id = Integer.parseInt(request.getParameter("patientId"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String ic = request.getParameter("ic");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
			
		Patient patient = new Patient(patient_id, name, email, ic, phone, address);
		
		System.out.println(patient_id);
		System.out.println(name);
		System.out.println(patient.getEmail());
		System.out.println(ic);
		System.out.println(phone);
		System.out.println(address);
		
			try {
				boolean statusUpdate = patientService.updatePatient(patient);
				if(statusUpdate) {
					response.sendRedirect(request.getContextPath() + "/my-patient?id=" + patient.getPatient_id() + "&success=true");
				}else {
					response.sendRedirect(request.getContextPath() + "/edit-patient?id=" + patient.getPatient_id() + "&success=false");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

}

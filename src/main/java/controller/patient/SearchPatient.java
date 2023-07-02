package controller.patient;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.PatientService;

import java.io.IOException;
import java.util.List;

import bean.Patient;

/**
 * Servlet implementation class SearchPatient
 */
@WebServlet("/search-patient")
public class SearchPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatientService patientService;
    
	public void init() {
		patientService = new PatientService();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String search = request.getParameter("search");
		List<Patient> listPatient = patientService.getPatientByIcName(search);
		request.setAttribute("listPatient", listPatient);
//		System.out.println();
		RequestDispatcher dispatcher = request.getRequestDispatcher("my-patients.jsp");
		dispatcher.forward(request, response);
	}

}

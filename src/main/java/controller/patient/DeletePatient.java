package controller.patient;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AppointmentService;
import services.BillServices;
import services.PatientService;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet implementation class DeletePatient
 */
public class DeletePatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatientService patientService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		patientService = new PatientService();
	}
	
    public DeletePatient() {
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
		int id = Integer.parseInt(request.getParameter("appointmentId"));

		try {
			boolean statusPatient = patientService.deletePatient(id);
			if (statusPatient) {
				response.sendRedirect(request.getContextPath() + "/my-patient?id=" + id + "&delete=false");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

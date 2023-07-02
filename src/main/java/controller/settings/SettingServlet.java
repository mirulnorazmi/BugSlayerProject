package controller.settings;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.ClinicService;
import services.DoctorService;

import java.io.IOException;

import bean.Clinic;
import bean.Doctor;

/**
 * Servlet implementation class SettingServlet
 */
@WebServlet("/setting")
public class SettingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DoctorService doctorService;
	private ClinicService clinicService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	public void init() {
		doctorService = new DoctorService();
		clinicService = new ClinicService();
	}
	
    public SettingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Doctor doctor = new Doctor();
		Clinic clinic = new Clinic();
		HttpSession session = request.getSession();
		doctor.setEmail((String) session.getAttribute("email"));
		
		doctor = doctorService.getFullInformation(doctor);
		clinic.setId(doctor.getClinic_id());
		clinic = clinicService.getFullInformation(clinic);
		
		request.setAttribute("doc_profile", doctor);
		request.setAttribute("clinic_profile", clinic);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("settings.jsp");
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

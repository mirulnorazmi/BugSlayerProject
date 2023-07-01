package controller.settings;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.ClinicService;
import services.DoctorService;

import java.io.IOException;
import java.sql.SQLException;

import bean.Clinic;
import bean.Doctor;

/**
 * Servlet implementation class UpdateSetting
 */
public class UpdateSetting extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DoctorService doctorService;
	private ClinicService clinicService;
      
    /**
     * @see HttpServlet#HttpServle at()
     */
	public void init() {
		doctorService = new DoctorService();
		clinicService = new ClinicService();
	}
	
    public UpdateSetting() {
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
//		Doctor param
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String specialization = request.getParameter("specialization");
		String phone = request.getParameter("phone");
//		Clinic param
		int clinic_id = Integer.parseInt(request.getParameter("clinic_id"));
		String clinic_name = request.getParameter("clinic_name");
		String address = request.getParameter("address");
		
		try {
			boolean statusD = doctorService.updateDoctor(new Doctor(id, name, email, specialization, phone));
			boolean statusC = clinicService.updateClinic(new Clinic(clinic_id, clinic_name, address));
			if(statusD && statusC) {
				response.sendRedirect(request.getContextPath() + "/setting");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

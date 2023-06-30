package controller.appointment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.BillServices;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import bean.Bill;

/**
 * Servlet implementation class UpdateBill
 */
@WebServlet("/update-bill")
public class UpdateBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BillServices billServices;
    
	public void init() {
		billServices = new BillServices();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBill() {
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
		String id = request.getParameter("id");
		int bill_id = Integer.parseInt(request.getParameter("billId"));
		Date date = Date.valueOf(request.getParameter("date"));
		String status = request.getParameter("status");
		float amount = Float.parseFloat(request.getParameter("amount"));
		
		System.out.println("bill id : " + bill_id);
		System.out.println("date : " + date);
		System.out.println("amount : " + amount);
		System.out.println("status: " + status);
		try {
			billServices.updateBill(new Bill(bill_id, date, status, amount));
//			success mapping
			response.sendRedirect(request.getContextPath() + "/edit-appointment?id=" + id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/edit-appointment?id=" + id + "?error");
		}
		
	}

}

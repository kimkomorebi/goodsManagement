package order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GoodsGuestsList;

/**
 * Servlet implementation class OrderUpdateDoServlet
 */
@WebServlet("/orderUpdate.do")
public class OrderUpdateDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderUpdateDoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String id = request.getParameter("G_ID");
		String no = request.getParameter("NO");
		String date = request.getParameter("DATE");
		GoodsGuestsList gg = new GoodsGuestsList();
		gg.setG_id(id);
		gg.setNo(Integer.parseInt(no));
		gg.setO_date(date);
		
	}

}

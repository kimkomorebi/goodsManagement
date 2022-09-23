package order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goods.DBExpert;
import model.GoodsGuestsList;

/**
 * Servlet implementation class OrderUpdateServlet
 */
@WebServlet("/orderUpdate.do")
public class OrderUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String g_id = request.getParameter("G_ID");
		String btn = request.getParameter("BTN");
		DBExpert dbe = new DBExpert();
		GoodsGuestsList view = dbe.orderListDetailView(g_id);
		request.setAttribute("LIST", view);
		if(btn.equals("수정")) {
			RequestDispatcher rd = request.getRequestDispatcher("orderUpdateList.jsp");
			rd.forward(request, response);
		}else if(btn.equals("삭제")) {
			RequestDispatcher rd = request.getRequestDispatcher("");
			rd.forward(request, response);
		}
		
	}

}

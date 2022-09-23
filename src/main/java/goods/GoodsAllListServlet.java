package goods;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GoodsGuestsList;

/**
 * Servlet implementation class GoodsAllListServlet
 */
@WebServlet("/goodsAllList.do")
public class GoodsAllListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoodsAllListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBExpert dbe = new DBExpert();
		ArrayList<GoodsGuestsList> list = dbe.getOrderList();
		request.setAttribute("LIST", list);
		RequestDispatcher rd = request.getRequestDispatcher("orderList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

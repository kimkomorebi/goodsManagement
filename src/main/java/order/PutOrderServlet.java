package order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goods.DBExpert;
import model.GoodsGuestsList;

@WebServlet("/putOrder.do")
public class PutOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PutOrderServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String id = request.getParameter("G_ID");
		String num = request.getParameter("NUM");
		String o_date = request.getParameter("DATE");
		GoodsGuestsList list = new GoodsGuestsList();
		list.setG_id(id);
		list.setNo(Integer.parseInt(num));
		list.setO_date(o_date);
		DBExpert dbe = new DBExpert();
		boolean result = dbe.putOrder(list);
		if(result) {
			response.sendRedirect("");
		}else {
			response.sendRedirect("");
		}
	}

}

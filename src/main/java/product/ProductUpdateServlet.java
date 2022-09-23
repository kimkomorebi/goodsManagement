package product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goods.DBExpert;
import model.GoodsGuestsList;

/**
 * Servlet implementation class ProductUpdateServlet
 */
@WebServlet("/productUpdate.do")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String id = request.getParameter("P_ID");
		String btn = request.getParameter("BTN");
		DBExpert dbe = new DBExpert();
		GoodsGuestsList gg = dbe.ProductUpdateView(id);
		ArrayList<String> made = dbe.getMadeList();
		request.setAttribute("LIST", gg);
		request.setAttribute("MADE", made);
		if(btn.equals("수 정")) {
			RequestDispatcher rd = request.getRequestDispatcher("productDetailView.jsp");
			rd.forward(request, response);
		}else if(btn.equals("삭 제")) {
			RequestDispatcher rd = request.getRequestDispatcher("productDeleteView.jsp");
			rd.forward(request, response);
		}
	}

}

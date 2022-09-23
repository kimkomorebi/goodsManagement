package product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goods.DBExpert;
import model.GoodsGuestsList;

/**
 * Servlet implementation class PutProductServlet
 */
@WebServlet("/putProduct.do")
public class PutProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PutProductServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String pid = request.getParameter("P_ID");
		String pname = request.getParameter("P_NAME");
		String price = request.getParameter("PRICE");
		String made = request.getParameter("MADE");
		DBExpert dbe = new DBExpert();
		GoodsGuestsList gg = new GoodsGuestsList();
		gg.setG_id(pid);
		gg.setG_name(pname);
		gg.setPrice(Integer.parseInt(price));
		gg.setMade(made);
		boolean result = dbe.putProduct(gg);
		if(result) {
			response.sendRedirect("putProductResult.jsp?R=Y");
		}else {
			response.sendRedirect("putProductResult.jsp?R=N");
		}
	}

}

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
 * Servlet implementation class PutUpdateServlet
 */
@WebServlet("/putUpdate.do")
public class PutUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PutUpdateServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		String pid = request.getParameter("P_ID");
		String pname = request.getParameter("P_NAME");
		String price = request.getParameter("PRICE");
		String made= request.getParameter("MADE");
		GoodsGuestsList gg = new GoodsGuestsList();
		gg.setG_id(pid);
		gg.setG_name(pname);
		gg.setPrice(Integer.parseInt(price));
		gg.setMade(made);
		DBExpert dbe = new DBExpert();
		boolean result = dbe.putProductUpdate(gg);
		if(result) {
			response.sendRedirect("productUpdateResult.jsp?R=Y");
		}else {
			response.sendRedirect("productUpdateResult.jsp?R=N");
		}
	}

}

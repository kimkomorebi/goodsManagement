package product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import goods.DBExpert;

/**
 * Servlet implementation class PutProductDeleteServlet
 */
@WebServlet("/putProductDelete.do")
public class PutProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PutProductDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("P_ID");
		DBExpert dbe = new DBExpert();
		boolean result = dbe.putProductDelete(pid);
		if(result) {
			response.sendRedirect("productDeleteResult.jsp?R=Y");
		}else {
			response.sendRedirect("productDeleteResult.jsp?R=N");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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

@WebServlet("/productAllList.do")
public class ProductAllListServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductAllListServelt() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBExpert dbe = new DBExpert();
		GoodsGuestsList gg = new GoodsGuestsList();
		ArrayList<GoodsGuestsList> list = dbe.getAllProduct();
		request.setAttribute("LIST", list);
		RequestDispatcher rd = request.getRequestDispatcher("productList.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package goods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.GoodsGuestsList;

public class DBExpert {
	final private String driver = "oracle.jdbc.OracleDriver";
	final private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	
	public GoodsGuestsList orderListUpdateDo(String id) {
		String update = "update goods_guests set id = ?, no = ?, o_date = ?"
				+" where = ?";
		Connection con = null; PreparedStatement pstmt = null;
		GoodsGuestsList gg = null;
		try {
			
		}catch(Exception e) {
			
		}finally {
			
		}
		return gg;
	}
	
	public GoodsGuestsList orderListDetailView(String id) {
		String select = "select * from goods_guests where id = ?";
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		GoodsGuestsList gg = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				gg = new GoodsGuestsList();
				gg.setG_id(rs.getString(1));
				gg.setNo(rs.getInt(2));
				gg.setO_date(rs.getString(3));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return gg;
	}
	
	public boolean putProductDelete(String pid) {
		String delete = "delete from goods_info where id = ?";
		Connection con = null; PreparedStatement pstmt = null;
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(delete);
			pstmt.setString(1, pid);
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	public boolean putProductUpdate(GoodsGuestsList gg) {
		String update = "update goods_info set "
				+" name=?, price=?,made=? where id =?";
		Connection con = null; PreparedStatement pstmt = null;
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(update);
			pstmt.setString(1, gg.getG_name());
			pstmt.setInt(2, gg.getPrice());
			pstmt.setString(3, gg.getMade());
			pstmt.setString(4, gg.getG_id());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	public GoodsGuestsList ProductUpdateView(String id) {
		String select = "select * from goods_info where id = ?";
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		GoodsGuestsList gg = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			con.commit();
			if(rs.next()) {
				gg = new GoodsGuestsList();
				gg.setG_id(rs.getString(1));
				gg.setG_name(rs.getString(2));
				gg.setPrice(rs.getInt(3));
				gg.setMade(rs.getString(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return gg;
	}
	
	public boolean putProduct(GoodsGuestsList gg) {
		String insert = "insert into goods_info values (?,?,?,?)";
		Connection con = null; PreparedStatement pstmt = null;
		boolean result = false;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, gg.getG_id());
			pstmt.setString(2, gg.getG_name());
			pstmt.setInt(3, gg.getPrice());
			pstmt.setString(4, gg.getMade());
			pstmt.executeUpdate();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	public ArrayList<String> getMadeList() {
		String select ="select distinct made from goods_info";
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<String>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String made = rs.getString(1);
				list.add(made);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
	
	public ArrayList<GoodsGuestsList> getAllProduct(){
		String select = "select * from goods_info";
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<GoodsGuestsList> list = new ArrayList<GoodsGuestsList>();
		GoodsGuestsList gg = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				gg = new GoodsGuestsList();
				gg.setG_id(rs.getString(1));
				gg.setG_name(rs.getString(2));
				gg.setPrice(rs.getInt(3));
				gg.setMade(rs.getString(4));
				list.add(gg);
			}		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
	
	public boolean putOrder(GoodsGuestsList list) {
		String insert = "insert into goods_guests values("
				+ "?, ?, ?)";
		boolean result = false;
		Connection con = null; PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(insert);
			pstmt.setString(1, list.getG_id());
			pstmt.setInt(2, list.getNo());
			pstmt.setString(3, list.getO_date());
			pstmt.executeUpdate();
			con.commit();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return result;
	}
	
	public ArrayList<GoodsGuestsList> getOrderList(){
		String select = "select go.id, go.name, gu.name, go.price, gu.address, gu.phone, gg.o_date"
				+ " from goods_info go, guests_info gu, goods_guests gg"
				+ " where go.id = gg.id"
				+ " and gu.no = gg.no";
		Connection con = null; PreparedStatement pstmt = null;
		ResultSet rs = null;
		GoodsGuestsList ggList = null;
		ArrayList<GoodsGuestsList> list = new ArrayList<GoodsGuestsList>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pstmt = con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ggList = new GoodsGuestsList();
				ggList.setG_id(rs.getString(1));
				ggList.setG_name(rs.getString(2));
				ggList.setName(rs.getString(3));
				ggList.setPrice(rs.getInt(4));
				ggList.setAddress(rs.getString(5));
				ggList.setPhone(rs.getString(6));
				ggList.setO_date(rs.getString(7));
				list.add(ggList);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
}

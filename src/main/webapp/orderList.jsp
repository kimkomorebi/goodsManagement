<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*, model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<section>
		<div class="goodsAllList.do" align="center">
			<%
				ArrayList<GoodsGuestsList> list = (ArrayList<GoodsGuestsList>)request.getAttribute("LIST");
			%>
				<table border="1">
					<tr>
						<th>상품번호</th>
						<th>상품명</th>
						<th>주문자명</th>
						<th>상품가격</th>
						<th>주문자 주소</th>
						<th>주문자 연락처</th>
						<th>주문일</th>
						<th>삭제</th>
					</tr>
						<%
							for(GoodsGuestsList l : list){
						%>
				
						<tr>
								<td><%= l.getG_id() %></td>
								<td><%= l.getG_name() %></td>
								<td><%= l.getName() %></td>
								<td><%= l.getPrice() %></td>
								<td><%= l.getAddress() %></td>
								<td><%= l.getPhone() %></td>
								<td><%= l.getO_date() %></td>
								<td>
									<form action="orderUpdate.do" method="post">
										<input type="hidden" value="<%= l.getG_id() %>" name="G_ID"/>
										<input type="submit" value="수정" name="BTN"/>
										<input type="submit" value="삭제" name="BTN"/>
									</form>
								</td>
						</tr>

						<%
							}
						%>
				</table><br/>
				<form action="putOrder.jsp">
					<input type="submit" value="주문 등록"/>
				</form>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
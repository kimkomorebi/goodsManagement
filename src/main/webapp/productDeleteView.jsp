<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<section>
		<div class="" align="center">
			<%
			GoodsGuestsList list = (GoodsGuestsList)request.getAttribute("LIST");
			//ArrayList<String> made = (ArrayList<String>)request.getAttribute("MADE");
			%>
			<form action="putProductDelete.do" method="get">
				<input type="hidden" value="<%= list.getG_id() %>" name="P_ID"/>
				<table border="1">
					<tr>
						<th>상품번호</th>
						<td><%= list.getG_id() %></td>
					</tr>
					<tr>
						<th>상품 이름</th>
						<td><%= list.getG_name()%></td>
					</tr>
					<tr>
						<th>상품 가격</th>
						<td><%= list.getPrice()%></td>
					</tr>
					<tr>
						<th>원산지</th>
						<td>
							<%= list.getMade() %>
						</td>
					</tr>
				</table><br/>
				<input type="submit" value="삭제하기"/>
			</form>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
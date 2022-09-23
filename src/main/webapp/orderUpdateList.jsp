<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="model.*" %>
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
			%>
			<form action="orderUpdate.do" method="post">
				<table border="1">
					<tr>
						<th>상품번호</th>
						<td><input type="text" name="G_ID" value="<%= list.getG_id() %>"/></td>
					</tr>
					<tr>
						<th>고객번호</th>
						<td><input type="text" name="NO" value="<%= list.getNo() %>"/></td>
					</tr>
					<tr>
						<th>주문일</th>
						<td><input type="text" name="DATE" value="<%= list.getO_date() %>"/></td>
					</tr>
				</table><br/>
				<input type="submit" value="주문 정보 수정"/>
			</form>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
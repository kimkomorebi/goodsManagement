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
		<div class="" align="center">
		<%
			ArrayList<GoodsGuestsList> list = (ArrayList<GoodsGuestsList>)request.getAttribute("LIST");
		%>
		
			<table border="1">
				<tr>
					<th>��ǰ ��ȣ</th>
					<th>��ǰ �̸�</th>
					<th>��ǰ ����</th>
					<th>������</th>
					<th>���� �� ����</th>
				</tr>
				<%
					for(GoodsGuestsList l : list){
				%>
				<tr>
					<td><%= l.getG_id() %></td>
					<td><%= l.getG_name() %></td>
					<td><%= l.getPrice() %></td>
					<td><%= l.getMade() %></td>
					<td>
						<form action="productUpdate.do" method="post">
							<input type="hidden" name="P_ID" value="<%= l.getG_id() %>"/>
							<input type="submit" value="�� ��" name="BTN"/>
							<input type="submit" value="�� ��" name="BTN"/>
						</form>
					</td>
				</tr>
				<%
					}
				%>
			</table><br/>
		<form action="registerProduct.do" method="post">
			<input type="submit" value="��ǰ ���"/>
		</form>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
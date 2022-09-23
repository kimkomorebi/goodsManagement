<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
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
				ArrayList<String> made = (ArrayList<String>)request.getAttribute("MADE");
			%>
			<form action="putProduct.do" method="post">
				<table border="1">
					<tr>
						<th>��ǰ ��ȣ</th>
						<td><input type="text" name="P_ID"/></td>
					</tr>
					<tr>
						<th>��ǰ �̸�</th>
						<td><input type="text" name="P_NAME"/></td>
					</tr>
					<tr>
						<th>��ǰ ����</th>
						<td><input type="text" name="PRICE"/></td>
					</tr>
					<tr>
						<th>������</th>
						<td>
							<select name="MADE">
								<%
									for(String m : made){
								%>
								<option><%= m %></option>
								<%
									}
								%>
							</select>
						</td>
					</tr>
				</table><br/>
				<input type="submit" value="��ǰ ����ϱ�"/>
			</form>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
			<h3>�ֹ� ���� ���</h3>
			<form action="putOrder.do" method="post">
				<table border="1">
					<tr>
						<th>��ǰ��ȣ</th>
						<td><input type="text" name="G_ID"/></td>
					</tr>
					<tr>
						<th>����ȣ</th>
						<td><input type="text" name="NUM"/></td>
					</tr>
					<tr>
						<th>�ֹ���</th>
						<td><input type="text" name="DATE"/></td>
					</tr>
				</table><br/>
				<input type="submit" value="�ֹ� ���""/>
			</form>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
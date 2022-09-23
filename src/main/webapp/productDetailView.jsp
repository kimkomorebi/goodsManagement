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
			ArrayList<String> made = (ArrayList<String>)request.getAttribute("MADE");
			%>
			<form action="putUpdate.do" method="post">
				<table border="1">
					<tr>
						<th>상품번호</th>
						<td><input type="text" name="P_ID" value="<%= list.getG_id() %>" readOnly="readOnly"/></td>
					</tr>
					<tr>
						<th>상품 이름</th>
						<td><input type="text" name="P_NAME" value="<%= list.getG_name()%>"/></td>
					</tr>
					<tr>
						<th>상품 가격</th>
						<td><input type="text" name="PRICE" value="<%= list.getPrice()%>"/></td>
					</tr>
					<tr>
						<th>원산지</th>
						<td>
							<select name="MADE">
								<%
									for(String m : made){
										if(m.equals(list.getMade())){
								%>
								<option selected="selected"><%= m %></option>
								<%
										}else{
								%>
								<option><%= m %></option>
								<%			
										}
									}
								%>
							</select>
						</td>
					</tr>
				</table><br/>
				<input type="submit" value="수정 완료"/>
			</form>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
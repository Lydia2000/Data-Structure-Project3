<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bookle</title>
</head>
<body >
  <table width="100%" height="30">
  <form action='${requestUri}' method='get'>
    <img src="Bookle3.png"width="100" height="30" style="height: 22px; width: 71px">
    　<input type='text' name='keyword' placeholder = '請輸入要查詢的書名' style="margin-left:5px; margin-top:20px"/>
    <input type='submit' value='搜尋' style="margin-left:20px"/>
    </table>   
  </form>
  <div style="margin-left:100px">
	 <%
	String[][] orderList = (String[][])  request.getAttribute("query");
	for(int i =0 ; i < orderList.length;i++){%>
		<a href='<%= orderList[i][1] %>'><%= orderList[i][0] %></a><br><h style="font-size:5px ;"><%= orderList[i][1] %></h><br><br>
	<%
	}
	%>
  </div>
</body>
</html>


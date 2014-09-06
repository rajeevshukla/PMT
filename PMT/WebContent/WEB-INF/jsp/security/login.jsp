<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="height: 100px; background-color: gray;">This is
		header</div>

	<div style="width: 50%; height: 400px; background-color: yellow; float: left;">

		<table>
			<tr>
				<td>User Name</td>
				<td><input name="j_username"  type="text"  > </td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input name="j_password" type="password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</div>
	<div style="width: 50%; height:400px;  background-color: red; float: left;"> 
	 <table>
			<tr>
				<td>Email Id</td>
				<td><input type="text" name="emailId"></td>
			</tr>
	
			<tr>
				<td></td>
				<td><input type="submit" value="Register"></td>
			</tr>
	 </table>
	
	</div>

	<div style="height: 100px; clear:both; background-color: lime;">
	This is footer
	 </div>
</body>
</html>
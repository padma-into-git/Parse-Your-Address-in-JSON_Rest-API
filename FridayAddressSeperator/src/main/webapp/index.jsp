<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Friday Address Parser</title>
	</head>
	<body>
		<form action="address_seperator" method="post">
			<table style="with: 50%">
				<tr>
					<td>Input Address</td>
					<td><input type="text" name="address_line" /></td>
				</tr>
			</table>
			<input type="submit" value="Submit" />
		</form>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http equiv="Content-Type" content="text/html; charset="ISO-8859-1">
<title>Shop</title>
</head>
<body>
<form action="tcon" method="post">
T-shirt Accessories<input type="checkbox" name="access" value="Belt"/>Belt
<input type="checkbox" name="access" value="cap"/>cap
<input type="checkbox" name="access" value="hair-band"/>hair-band<br>
Tag-Line<input type="text" name="tagline" size="50"/><br>
TshirtOption:
<input type="radio" name="pocket" value="ChestPocket"/>ChestPocket
<input type="radio" name="pocket" value="NoChestPocket"/>NoChestPocket<br>
T-shirt Color:<select name="Tshirtcolor">
<option>blue</option>option>
<option>red</option>option>
<option>green</option>option>
</select><br>
<input type="submit" value="place order"/>



</form>

</body>
</html>
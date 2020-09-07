<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0" />
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet" />
<title>会員管理</title>
</head>
<body>
	<h1>会員管理</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>名前</th>
			<th>年齢</th>
			<th>住所</th>
			<th>会員種別</th>
			<th>登録日</th>
		</tr>

		<c:forEach items="${memberList}" var="member">
			<tr>
				<td><c:out value="${member.id}" /></td>
				<td><c:out value="${member.name}" /></td>
				<td><c:out value="${member.age}" /></td>
				<td><c:out value="${member.address}" /></td>
				<%-- <td><c:out value="${member.typeId}" /></td> //練習9－2 --%>
				<td><c:out value="${member.typeName}"></c:out><!-- 練習9－3 追加 -->
				<td><c:out value="${member.created}" /></td>
			</tr>
		</c:forEach>
	</table>
	<p><a href="addMember">会員の追加</a>

	<script src="js/jquery-2.2.4.min.js"></script>
	<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>
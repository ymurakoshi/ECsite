<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>admin画面</title>
</head>
<body>
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>管理者画面</p>
		</div>
		<div id="admin">
			<div id="item_admin">
				<h1>商品管理</h1>
				<table>
					<tr>
						<td>
							<s:form action="ItemCreateAction">
								<s:submit value="新規登録"/>
							</s:form>
						</td>
						<td>
							<s:form action="ItemListAction">
								<s:submit value="一覧"/>
							</s:form>
						</td>
					</tr>
				</table>
			</div>

			<div id="user_admin">
				<h1>ユーザー管理</h1>
				<table>
					<tr>
						<td>
							<s:form action="uerCreateAction">
								<s:submit value="新規登録"/>
							</s:form>
						</td>
						<td>
							<s:form action="">
								<s:submit value="一覧"/>
							</s:form>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<div id="text-link">
				<p>Homeへ戻る場合は
					<a href='<s:url action="GoHomeAction" /> '>こちら</a></p>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>UserCreate画面</title>
</head>
<body>
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>UserCreate</p>
		</div>
			<s:if test="errorMessage != ''">
				<s:property value="errorMessage" escape="false"/>
			</s:if>
			<table>
				<s:form action="ItemCreateConfirmAction">
					<tr>
						<td>
							<label>商品名:</label>
						</td>
						<td>
							<input type="text" name="itemName" value="" />
						</td>
					</tr>
					<tr>
						<td>
							<label>値段:</label>
						</td>
						<td>
							<input type="text" name="itemPrice" value="" /><span>円</span>
						</td>
					</tr>
					<tr>
						<td>
							<label>在庫数:</label>
						</td>
						<td>
							<input type="text" name="itemStock" value="" /><span>個</span>
						</td>
					</tr>
					<s:submit value="登録"/>
				</s:form>
			</table>
			<div>
				<span>前画面に戻る場合は</span>
				<a href='<s:url action="HomeAction" />'>こちら</a>
			</div>
	</div>
	<div id="footer"></div>
</body>
</html>
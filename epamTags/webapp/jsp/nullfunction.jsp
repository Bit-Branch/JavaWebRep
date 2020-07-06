<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="ctg" uri="customtags" %>
<html>
<head><title>tag: function</title></head>
<body>
Не пустой параметр: ${ctg:notnull("Oracle Java")}
<br/>
Строка нулевой длины: ${ctg:notnull("")}
</body></html>
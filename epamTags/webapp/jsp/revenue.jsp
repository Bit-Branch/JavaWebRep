<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="ctg" uri="customtags"%>
<html><head><title>tag: custom table</title></head>
<body>
<ctg:table-revenue rows="${ rw.size }" head="Revenue">
    ${ rw.revenue }
</ctg:table-revenue >
<br/>
<ctg:table-revenue>5 rub BulbaComp</ctg:table-revenue >
</body></html>

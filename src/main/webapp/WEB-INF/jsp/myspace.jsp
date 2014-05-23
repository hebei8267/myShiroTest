<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="sc_ctx">${ctx}/sc</c:set>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
    	<a href="${sc_ctx}/logout">logout</a><br><br><br>
    
    
    	<a href="${sc_ctx}/Link01?search=123">Link01</a><br>
    	<a href="${sc_ctx}/Link0101">Link0101</a><br>
    	<a href="${sc_ctx}/Link0102">Link0102</a><br>
    	<a href="${sc_ctx}/Link0103">Link0103</a><br><br>
    	<a href="${sc_ctx}/Link02">Link02</a><br>
    	<a href="${sc_ctx}/Link0201">Link0201</a>
    </body>
</html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="sc_ctx">${ctx}/sc</c:set>
<!DOCTYPE HTML>
<html>
	<head>
	    <title>shiro login page</title>
	    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	    <script src="${ctx}/static/js/jquery-1.7.2.min.js"></script>
	    <script>
            $(function() {
                
                
                $("#loginBtn").click(function() {
		        	_userLoginFun();
		        	return false;
	       		});
            });
            
            function _userLoginFun() {
            	
					
				$("#inputForm").attr('target', '_self');
				$("#inputForm").attr("action", "${sc_ctx}/login");
	          	$("#inputForm").submit();
            }
        </script>
	</head>
  	<body>
	    <form action="${sc_ctx}/login" method="post" id="inputForm">
	    <ul>
	    	<li>姓　名：<input type="text" name="loginName" /> </li>
	    	<li>密　码：<input type="text" name="passWord" /> </li>
	    	<li><input type="button" id="loginBtn" value="确认" /> </li>
	    </ul>
	    </form>
	</body>
</html>
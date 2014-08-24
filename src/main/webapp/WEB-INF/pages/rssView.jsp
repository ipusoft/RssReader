<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
<style>
  .row0 {background-color:#F2F2F2;}
  .row1 {background-color:#FAFAFA;}
</style>
</head> 

<html>
<body>
	 <p>RSS feed listat  <a href="<c:url value="/rssload" />">Päivitä</a></p>
	 
	 <c:if test="${not empty errorMessage}">
	 	<p style="color:red"><c:out value="${errorMessage}"/></p>
	 </c:if>
	 
	 <ul>
	 	<c:forEach var="item" items="${rssheaders}">
		 	<li>
		 	  <a href="<c:out value="${item.link}"/>" target="_blank"><c:out value="${item.title}"/></a>
		 	</li>
	 	</c:forEach>
	 </ul>
 		
	 <table>
	 	<c:forEach var="item" items="${rssitems}" varStatus="var">
    	   <tr class="row${var.index % 2}">	 		
			  <td width="10%"><fmt:formatDate value="${item.publishDate}" type="both"  pattern="MM-dd-yyyy HH:mm:ss" /></td>
			  <td width="30%"><a href="<c:out value="${item.link}"/>" target="_blank"><c:out value="${item.title}"/></a></td>
			  <td width="60%"><c:out value="${item.description}"/></td>
		   </tr>
			<tr >
		   </tr>
		   
		</c:forEach>
	</table>
		

		
</body>
</html>
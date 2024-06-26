<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="<%=request.getContextPath()%>"/>
<c:set var="dt" value="<%=System.currentTimeMillis()%>"/>

<jsp:include page="../layout/header.jsp">
  <jsp:param value="${blog.blogNo}번 블로그" name="title"/>
</jsp:include>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<h1 class="title">블로그 상세화면</h1>

  <div>
    <span>작성자</span>
    <span>${blog.user.email}</span>
  </div>
  
  <div>
    <span>제목</span>
    <span>${blog.title}</span>
  </div>
  
  <div>
    <span>내용</span>
    <span>${blog.contents}</span>
  </div>
  
  <hr>
  
  <form id="frm-comment">
    <textarea id="contents" name="contents"></textarea>
    <input type="hidden" name="blogNo" value="${blog.blogNo}">
    <c:if test="${not empty sessionScope.user}">
    <input type="hidden" name="userNo" value="${sessionScope.user.userNo}">
    </c:if>
    <button id="btn-comment-register">댓글등록</button>
  </form>
  
  <hr>
  
  <div id="comment-list"></div>
  
<script>

  
</script>

<%@ include file="../layout/footer.jsp" %>
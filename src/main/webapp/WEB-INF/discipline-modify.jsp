<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Kelly+Slab&display=swap" rel="stylesheet">
  <script type="application/javascript " src="../resources/js/functions.js"></script>
  <title>discipline-modify</title>
</head>
<body>
<aside class="navigation">
  <a href="/" class="navigation-item">на главную</a>
  <a href="/disciplines" class="navigation-item">назад</a>

</aside>

<main class="main">
  <h1 class="main-heading"> система управления студентами и их успеваемостью</h1>
  <h3 class="heading-secondary">для редактирования дисциплины отредактируйте поле и нажмите кнопку "применить":</h3>
  <br>
  <form action="/discipline-modify" method="post" >
    <input type="hidden" name="id" value="${discipline.id}">
    <div class="name-window">
      <label for="discipline"><h3>название :</h3> </label>

      <input name="name" type="text" id="discipline" value="${discipline.discipline}">
    </div>
    <br>


    <input type="submit" value=" применить" class="field">

  <c:if test="${message eq 1}">
    <h3>Поле не должно быть пустым</h3>
  </c:if>

  </form>


</main>
<aside class="logout">
  <c:choose>
    <c:when test="${isLogin eq 1}">
      <a href="/logout" class="logout-btn">logout, ${login}</a>
    </c:when>

    <c:otherwise>
      <a href="/login" class="logout-btn">login</a>
    </c:otherwise>
  </c:choose>

</aside>


</body>
</html>
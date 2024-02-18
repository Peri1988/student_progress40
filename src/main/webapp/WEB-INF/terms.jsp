
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
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
    <title>terms-list</title>
</head>
<body>
<aside class="navigation">
    <a href="/" class="navigation-item">на главную</a>

</aside>

<main class="main">
    <h1 class="main-heading"> система управления студентами и их успеваемостью</h1>
    <div class="choice-semestr1">
        <h2> выбрать семестр       : </h2>
        <form method="get" action="/terms">
        <select border="1" name="idSelectedTerm">
            <c:forEach items="${terms}" var="term">
                <c:choose>
                    <c:when test="${term.id eq SelectedTerm.id}">
                        <option selected value="${term.id}" class="choice"> ${term.term} </option>
                    </c:when>

                    <c:otherwise>
                        <option  value="${term.id}" class="choice"> ${term.term} </option>
                    </c:otherwise>
                </c:choose>



            </c:forEach>

        </select>

            <input type="submit" class="choice-btn" value="выбрать">
        </form>

    </div>
    <br>


    <h2>
        длительность семестра: 24 недели
    </h2>
    <br>
    <h2>
        список дисциплин семестра
    </h2>
    <br>
    <div class="term">
        <table border="1">
            <tr>
                <th> название дисциплин</th>
            </tr>

            <c:forEach items="${disciplines}" var="discipline">
            <tr>
                <td>${discipline.discipline}</td>
            </tr>

            </c:forEach>
        </table>
        <div class="discipline-btns">
            <form action="/term-create" method="get">
            <input type="submit" value="создать семестр"/></form>
            <button>модифицировать текущий семестр</button>
            <input type="submit" onclick="deleteTerm()" value="удалить текущий семестр"/></form>
        </div>
        <table>
            <tr>
                <td></td>
            </tr>
        </table>
    </div>



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

<form action="/discipline-delete" method="post" id="deleteDisciplineForm">
    <input type="hidden" value="" id="deleteDisciplineHidden" name="deleteDisciplineHidden" >

</form>

</body>
</html>
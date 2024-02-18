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

    <title>term-creating</title>
</head>
<body>
<aside class="navigation">
    <a href="/" class="navigation-item">на главную</a>
    <a href="/terms" class="navigation-item">назад</a>

</aside>

<main class="main">
    <h1 class="main-heading"> система управления студентами и их успеваемостью</h1>
    <h2 class="heading-secondary">для создания семестра заполните следующие данные и нажмите кнопку "создать":</h2>
    <br>
    <form action="/term-create" method="post">
        <div class="name-window">
            <label for="name"><h3>длительность (в неделях)</h3></label>

            <input name="duration" type="text" id="name">
        </div>
        <br>


        <br>

        <div class="discip-in-sem">
            <h3> дисциплины в семестре :</h3>
            <select multiple class="select-discip">
                <option>информатика</option>
                <option>политология</option>
                <option>социология</option>
                <option>высшая математика</option>

            </select>
            <table>
                <tr>
                    <td></td>
                </tr>
            </table>
            <table>
                <tr>
                    <td></td>
                </tr>
            </table>
        </div>
        <br>

        <input type="submit" value=" создать" class="field">
        <c:if test="${message eq 1}">
            <h3>Поля не должны быть пустыми</h3>
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
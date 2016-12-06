<h3 class="text-muted">Task Management</h3>
<nav>
    <a href="/">Home</a> |
    <a href="/tasks">Color</a> |
    <a href="/users">Engine</a> |
</nav>

<%-- user authentication --%>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<sec:authentication property="name"/>

<sec:authorize access="isAuthenticated()">

    <form:form action="logout" method="post">
        <button>logout</button>
    </form:form>
</sec:authorize>

<sec:authorize access="!isAuthenticated()">
    <br>
    <a href="loginpage">login</a>
    <br>
    <a href="registration">registration</a>
    <br>
</sec:authorize>


<sec:authorize access="hasRole('ROLE_ADMIN')">

    <a href="admin">admin page</a>

</sec:authorize>

<sec:authorize access="isAuthenticated()">
    <a href="profile">profile</a>
</sec:authorize>

<%-- / user authentication --%>
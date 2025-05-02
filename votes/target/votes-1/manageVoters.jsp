<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.voting.models.Voter" %>
<%@ page import="com.voting.dao.VoterDao" %>
<%@ page import="com.voting.implementation.VoterDaoImpl" %>

<%
    VoterDao voterDao = new VoterDaoImpl();
    List<Voter> voters = voterDao.getAllVoters();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Manage Voters</title>
</head>
<body>
    <h1>Manage Voters</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <% for (Voter voter : voters) { %>
                <tr>
                    <td><%= voter.getId() %></td>
                    <td><%= voter.getName() %></td>
                    <td><%= voter.getEmail() %></td>
                    <td><a href="editVoter.jsp?id=<%= voter.getId() %>">Edit</a></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>

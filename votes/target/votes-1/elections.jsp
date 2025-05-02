<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.voting.models.Election"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="com.voting.dao.ElectionDao"%>
<%@page import="com.voting.implementation.ElectionDaoImpl"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>election list</title>
       
        <script>
            function confirmDelete(id) {
                if (confirm("Are you sure you want to delete this election?")) {
                    fetch('ElectionServlet?id=' + id, {
                        method: 'DELETE'
                    }).then(response => {
                        if (response.ok) {
                            alert("Election deleted successfully!");
                            window.location.reload(); // Refresh the page
                        } else {
                            alert("Failed to delete the election.");
                        }
                    }).catch(error => {
                        console.error('Error:', error);
                        alert("An error occurred.");
                    });
                }
            }
        </script>
    </head>
    <body>
        <h1>Manage Elections</h1>

        <%
            ElectionDao electionDao = new ElectionDaoImpl();
            List<Election> elections = (List<Election>) request.getAttribute("elections");
            try {
                elections = electionDao.getAllElections();
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Status</th>
                    <th>Positions</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <% if (elections != null && !elections.isEmpty()) {
                        for (Election election : elections) {%>
                <tr>
                    <td><%= election.getId()%></td>
                    <td><%= election.getName()%></td>
                    <td><%= election.getDescription()%></td>
                    <td><%= election.getStartDate()%></td>
                    <td><%= election.getEndDate()%></td>
                    <td><%= election.getStatus()%></td>
                    <td><%= election.getPositions()%></td>
                    <td>
                        <form action="ElectionServlet" method="post">
                            <input type="hidden" name="id" value="<%= election.getId()%>">
                            <input type="submit" value="Edit">
                        </form>
                        <button onclick="confirmDelete(<%= election.getId()%>)">Delete</button>
                    </td>
                </tr>
                <%  }
                } else { %>
                <tr>
                    <td colspan="8">No elections found.</td>
                </tr>
                <% }%>
            </tbody>
        </table>
    </body>
</html>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.voting.models.Candidate" %>
<%
// Assuming you have a list of candidates available in the request or session scope
List<Candidate> candidates = (List<Candidate>) request.getAttribute("candidates");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vote</title>
    <<link rel="stylesheet" href="style/votes.css"/> >
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: left;
        }
        img {
            width: 100px; /* Adjust the size as needed */
            height: auto;
        }
        .candidate {
            display: flex;
            align-items: center;
        }
        .candidate img {
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <h1>Vote for Your Candidates</h1>
    <form action="SubmitVoteServlet" method="POST">
        <input type="hidden" name="voterId" value="${sessionScope.voterId}">
        <input type="hidden" name="electionId" value="${electionId}">
        
        <table>
            <thead>
                <tr>
                    <th>Position</th>
                    <th>Candidate</th>
                    <th>Vote</th>
                </tr>
            </thead>
            <tbody>
                <% if (candidates != null && !candidates.isEmpty()) { %>
                    <% for (Candidate candidate : candidates) { %>
                        <tr>
                            <td><%= candidate.getPosition() %></td>
                            <td>
                                <div class="candidate">
                                    <img src="<%= candidate.getProfilePicture() %>" alt="Candidate">
                                    <span><%= candidate.getFullName() %> (ID: <%= candidate.getCandidateId() %>, Party: <%= candidate.getPartyAffiliation() %>)</span>
                                </div>
                            </td>
                            <td>
                                <input type="radio" name="<%= candidate.getPosition().toLowerCase() %>" value="<%= candidate.getCandidateId() %>" required> Vote
                            </td>
                        </tr>
                    <% } %>
                <% } else { %>
                    <tr>
                        <td colspan="3">No candidates available for voting.</td>
                    </tr>
                <% } %>
            </tbody>
        </table>
        
        <% if (candidates != null && !candidates.isEmpty()) { %>
            <button type="submit">Submit Votes</button>
        <% } %>
    </form>
</body>
</html>

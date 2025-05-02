<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manage Candidates</title>
    <link rel="stylesheet" href="style/manageCandidate.css"> 
</head>
<body>
    <h1>Manage Applications</h1>
    
    <c:if test="${not empty candidates}">
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Full Name</th>
                    <th>Date of Birth</th>
                    <th>Party Affiliation</th>
                    <th>Position</th>
                    <th>Profile Picture</th>
                    <th>Supporting Documents</th>
                    <th>Manifesto Video</th>
                    <th>Qualifications</th>
                    <th>Biography</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="candidate" items="${candidates}">
                    <tr>
                        <td>${candidate.candidateId}</td>
                        <td>${candidate.fullName}</td>
                        <td>${candidate.dateOfBirth}</td>
                        <td>${candidate.partyAffiliation}</td>
                        <td>${candidate.position}</td>
                        <td>
                            <img src="data:image/png;base64,${fn:escapeXml(Base64.getEncoder().encodeToString(candidate.profilePicture))}" alt="${candidate.fullName}'s Profile Picture" />
                        </td>
                        <td>
                            <c:if test="${not empty candidate.supportingDocuments}">
                                <a href="data:application/pdf;base64,${fn:escapeXml(Base64.getEncoder().encodeToString(candidate.supportingDocuments))}" target="_blank">View Documents</a>
                            </c:if>
                        </td>
                        <td>
                            <c:if test="${not empty candidate.manifestoVideo}">
                                <a href="data:video/mp4;base64,${fn:escapeXml(Base64.getEncoder().encodeToString(candidate.manifestoVideo))}" target="_blank">Watch Video</a>
                            </c:if>
                        </td>
                        <td>${candidate.qualifications}</td>
                        <td>${candidate.biography}</td>
                        <td>
                            <form method="post" action="CandidateManagementServlet">
                                <input type="hidden" name="candidateId" value="${candidate.candidateId}" />
                                <button type="submit" name="action" value="approve">Approve</button>
                                <button type="submit" name="action" value="reject">Reject</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    
    <c:if test="${empty candidates}">
        <p class="no-data">No candidates found in the database.</p>
    </c:if>

    <script>
        document.querySelectorAll('form').forEach(form => {
            form.addEventListener('submit', function(event) {
                const action = event.submitter.value;
                const confirmed = confirm(`Are you sure you want to ${action} this candidate?`);
                if (!confirmed) {
                    event.preventDefault(); // Prevent form submission
                }
            });
        });
    </script>
</body>
</html>

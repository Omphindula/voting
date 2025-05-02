<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Election</title>
    <script>
        function validateDates() {
            const startDate = new Date(document.getElementById("startDate").value);
            const endDate = new Date(document.getElementById("endDate").value);
            if (startDate > endDate) {
                alert("End date must be later than start date.");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <h1>Create a New Election</h1>
    
    <form action="ElectionServlet" method="post" onsubmit="return validateDates();">
        <input type="hidden" name="action" value="create">
        
        <label for="name">Election Name:</label>
        <input type="text" id="name" name="name" required><br><br>
        
        <label for="description">Description:</label>
        <textarea id="description" name="description" required></textarea><br><br>
        
        <label for="startDate">Start Date:</label>
        <input type="date" id="startDate" name="startDate" required><br><br>
        
        <label for="endDate">End Date:</label>
        <input type="date" id="endDate" name="endDate" required><br><br>
        
        <label for="status">Status:</label>
        <select id="status" name="status" required>
            <option value="Active">Active</option>
            <option value="Inactive">Inactive</option>
        </select><br><br>

        <label for="positions">Available Positions (comma separated):</label>
        <input type="text" id="positions" name="positions" required placeholder="e.g., President, Treasurer, Secretary"><br><br>
        
        <button type="submit">Create Election</button>
    </form>
    
    <br>
    <a href="elections.jsp">Back to Elections List</a>
</body>
</html>

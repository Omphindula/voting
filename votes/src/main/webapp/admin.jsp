<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Admin Dashboard</title>

        <script>
            function toggleSidebar() {
                var sidebar = document.querySelector('.sidebar');
                var mainContent = document.querySelector('.main-content');
                var toggleBtn = document.querySelector('.toggle-btn');
                sidebar.classList.toggle('hide');
                if (sidebar.classList.contains('hide')) {
                    mainContent.style.marginLeft = '0';
                } else {
                    mainContent.style.marginLeft = '250px';
                }
            }

            function loadContent(page) {
                // Create an AJAX request to load the content dynamically
                fetch(page)
                        .then(response => {
                            if (!response.ok) {
                                throw new Error('Network response was not ok.');
                            }
                            return response.text();
                        })
                        .then(html => {
                            document.getElementById("main-content").innerHTML = html;
                        })
                        .catch(error => {
                            console.error('There has been a problem with your fetch operation:', error);
                        });
            }

            // Load a default page when the dashboard first opens
            window.onload = function () {
                loadContent('dashboard.jsp');
            };
        </script>
    </head>
    <body>
        <div class="container">
            <!-- Sidebar -->
            <div class="sidebar">
                <div class="sidebar-title">Admin Dashboard</div>
                <a onclick="loadContent('dashboard.jsp')">Dashboard</a>
                <a onclick="loadContent('createElection.jsp')">Create Election</a>
                <a onclick="loadContent('createPoll.jsp')">Create Poll</a>
                <a onclick="loadContent('manageVoters.jsp')">Manage Voters</a>
                <a onclick="loadContent('monitorVoting.jsp')">Monitor Voting</a>
                <a onclick="loadContent('manageCandidates.jsp')">Manage Candidates</a>
                <a onclick="loadContent('viewStatistics.jsp')">View Statistics</a>
                <a onclick="loadContent('applicationOverview.jsp')">Applicatiotogglen Overview</a>
                <a onclick="loadContent('manageApplications.jsp')">Manage Applications</a>
                <a onclick="loadContent('generateReports.jsp')">Generate Reports</a>
                <a onclick="loadContent('settings.jsp')">Settings</a>
            </div>

            <!-- Toggle Button -->
            <button class="-btn" onclick="toggleSidebar()"></button>

            <div id="main-content" class="main-content">
            </div>
        </div>
    </body>
</html>

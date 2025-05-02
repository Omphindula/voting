<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Live Vote Count</title>
        <<link rel="stylesheet" href="style/home.css"/>>
    </head>
    <body>
        <!-- Header -->
        <header>
            <h1>Welcome to the Online Voting System</h1>
        </header>

        <!-- Main Content -->
        <nav>
            <section class="welcome-section">
                <ul class="nav-menu">
                    <li><b>Welcome, <%= ((com.voting.models.Voter) session.getAttribute("voter")).getName()%>!</b></li>
                    <li><a href="home.jsp">Live Votes</a></li>
                    <li><a href="vote.jsp">Vote Here</a></li>
                    <li><a href="vote-stats.jsp">Voting Statistics</a></li>
                    <li><a href="contact.html">Contact Us</a></li>
                    <li><a href="about.html">About Us</a></li>
                    <li><a href="logout.jsp" class="btn-logout">Logout</a></li>
                </ul>
            </section>
        </nav>

        <h1>Live Vote Count</h1>

        <!-- President Section -->
        <div class="vote-section">
            <h2>President</h2>
            <div class="header-row">
                <div>Candidates</div>
                <div>Votes</div>
                <div>Status Bar</div>
                <div>Position</div>
            </div>

            <!-- Candidate 1 -->
            <div class="candidate-info">
                <div class="candidate-left">
                    <div class="candidate-image">
                        <img src="path-to-image1.jpg" alt="Candidate 1 Image">
                    </div>
                    <div class="candidate-details">
                        <p><strong>Full Name:</strong> Candidate 1</p>
                        <p><strong>Candidate ID:</strong> 1234</p>
                        <p><strong>Party:</strong> Party A</p>
                    </div>
                </div>
                <div class="votes-info">
                    <span id="president1-votes">100</span>
                    <div class="progress-bar">
                        <div class="progress-bar-fill" id="president1-bar" style="width: 90%;"></div>
                        <span class="percentage" id="president1-percent">90%</span>
                    </div>
                    <span>1</span>
                </div>
            </div>

            <!-- Candidate 2 -->
            <div class="candidate-info">
                <div class="candidate-left">
                    <div class="candidate-image">
                        <img src="path-to-image2.jpg" alt="Candidate 2 Image">
                    </div>
                    <div class="candidate-details">
                        <p><strong>Full Name:</strong> Candidate 2</p>
                        <p><strong>Candidate ID:</strong> 5678</p>
                        <p><strong>Party:</strong> Party B</p>
                    </div>
                </div>
                <div class="votes-info">
                    <span id="president2-votes">80</span>
                    <div class="progress-bar">
                        <div class="progress-bar-fill" id="president2-bar" style="width: 60%;"></div>
                        <span class="percentage" id="president2-percent">60%</span>
                    </div>
                    <span>2</span>
                </div>
            </div>
        </div>

        <!-- Treasurer Section -->
        <div class="vote-section">
            <h2>Treasurer</h2>
            <div class="header-row">
                <div>Candidates</div>
                <div>Votes</div>
                <div>Status Bar</div>
                <div>Position</div>
            </div>

            <!-- Candidate 1 -->
            <div class="candidate-info">
                <div class="candidate-left">
                    <div class="candidate-image">
                        <img src="path-to-image3.jpg" alt="Candidate 3 Image">
                    </div>
                    <div class="candidate-details">
                        <p><strong>Full Name:</strong> Candidate 3</p>
                        <p><strong>Candidate ID:</strong> 91011</p>
                        <p><strong>Party:</strong> Party A</p>
                    </div>
                </div>
                <div class="votes-info">
                    <span id="treasurer1-votes">60</span>
                    <div class="progress-bar">
                        <div class="progress-bar-fill" id="treasurer1-bar" style="width: 50%;"></div>
                        <span class="percentage" id="treasurer1-percent">50%</span>
                    </div>
                    <span>1</span>
                </div>
            </div>

            <!-- Candidate 2 -->
            <div class="candidate-info">
                <div class="candidate-left">
                    <div class="candidate-image">
                        <img src="path-to-image4.jpg" alt="Candidate 4 Image">
                    </div>
                    <div class="candidate-details">
                        <p><strong>Full Name:</strong> Candidate 4</p>
                        <p><strong>Candidate ID:</strong> 121314</p>
                        <p><strong>Party:</strong> Party B</p>
                    </div>
                </div>
                <div class="votes-info">
                    <span id="treasurer2-votes">30</span>
                    <div class="progress-bar">
                        <div class="progress-bar-fill" id="treasurer2-bar" style="width: 25%;"></div>
                        <span class="percentage" id="treasurer2-percent">25%</span>
                    </div>
                    <span>2</span>
                </div>
            </div>
        </div>

        <!-- Footer -->
        <footer>
            <p>&copy; 2024 Online Voting System. All Rights Reserved.</p>
        </footer>
    </body>
</html>

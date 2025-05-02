package com.voting.servlets;

import com.voting.dao.VotesDAO;
import com.voting.implementation.VotesDAOImpl;
import com.voting.models.Votes; // Correct import for the Votes class

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SubmitVoteServlet", urlPatterns = {"/SubmitVoteServlet"})
public class SubmitVoteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dbUrl = "jdbc:mysql://localhost:3306/yourdb"; // Update to your database
        String dbUser = "user"; // Update with your database user
        String dbPassword = "password"; // Update with your database password

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword)) {
            VotesDAO votesDAO = new VotesDAOImpl(connection);

            // Get voter ID from the request
            int voterId = Integer.parseInt(request.getParameter("voterId"));
            int electionId = Integer.parseInt(request.getParameter("electionId"));

            // Check and save president votes
            String presidentVote = request.getParameter("president");
            if (presidentVote != null) {
                Votes vote = new Votes(); // Use the Votes class
                vote.setElectionId(electionId);
                vote.setCandidateId(Integer.parseInt(presidentVote)); // Ensure proper parsing
                vote.setVoterId(voterId);
                vote.setTimestamp(LocalDateTime.now().toString());
                votesDAO.saveVote(vote);
            }

            // Check and save treasurer votes
            String treasurerVote = request.getParameter("treasurer");
            if (treasurerVote != null) {
                Votes vote = new Votes(); // Use the Votes class
                vote.setElectionId(electionId);
                vote.setCandidateId(Integer.parseInt(treasurerVote)); // Ensure proper parsing
                vote.setVoterId(voterId);
                vote.setTimestamp(LocalDateTime.now().toString());
                votesDAO.saveVote(vote);
            }

            // Redirect to thank you page
            response.sendRedirect("thankYou.jsp");
        } catch (Exception e) {
            e.printStackTrace(); // For debugging; consider using a logger for production
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error processing vote: " + e.getMessage());
        }
    }
}

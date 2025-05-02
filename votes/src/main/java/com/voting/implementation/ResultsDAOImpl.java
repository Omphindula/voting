package com.voting.implementation;

import com.voting.dao.ResultsDAO;
import com.voting.models.Results;
import java.sql.*;

public class ResultsDAOImpl implements ResultsDAO {
    private Connection connection;

    public ResultsDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Results getResultsForElection(int electionId) {
        Results results = new Results(electionId);
        String sql = "SELECT candidate_id, COUNT(*) as vote_count FROM votes WHERE election_id = ? GROUP BY candidate_id";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, electionId);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                int candidateId = rs.getInt("candidate_id");
                int voteCount = rs.getInt("vote_count");
                results.addVote(candidateId, voteCount); // Adds the candidate and their vote count
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return results;
    }
}

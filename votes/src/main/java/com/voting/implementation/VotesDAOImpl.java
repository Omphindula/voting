package com.voting.implementation;

import com.voting.dao.VotesDAO;
import com.voting.models.Votes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VotesDAOImpl implements VotesDAO {
    private Connection connection;

    // Constructor to inject connection
    public VotesDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Votes> getVotesForElection(int electionId) {
        List<Votes> votes = new ArrayList<>();
        String sql = "SELECT id, election_id, candidate_id, voter_id, timestamp FROM votes WHERE election_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, electionId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Votes vote = new Votes();
                vote.setId(rs.getInt("id"));
                vote.setElectionId(rs.getInt("election_id"));
                vote.setCandidateId(rs.getInt("candidate_id"));
                vote.setVoterId(rs.getInt("voter_id"));

                // Handle timestamp safely
                Timestamp timestamp = rs.getTimestamp("timestamp");
                if (timestamp != null) {
                    vote.setTimestamp(timestamp.toString());
                } else {
                    vote.setTimestamp(null);
                }

                votes.add(vote);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return votes;
    }

    @Override
    public boolean hasVoted(int electionId, int voterId) {
        String sql = "SELECT COUNT(*) FROM votes WHERE election_id = ? AND voter_id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, electionId);
            pstmt.setInt(2, voterId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void saveVote(Votes vote) {
        String sql = "INSERT INTO votes (election_id, candidate_id, voter_id, timestamp) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, vote.getElectionId());
            pstmt.setInt(2, vote.getCandidateId());
            pstmt.setInt(3, vote.getVoterId());

            if (vote.getTimestamp() != null && !vote.getTimestamp().isEmpty()) {
                pstmt.setTimestamp(4, Timestamp.valueOf(vote.getTimestamp()));
            } else {
                pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            }

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.err.println("Error with timestamp format: " + e.getMessage());
        }
    }
}

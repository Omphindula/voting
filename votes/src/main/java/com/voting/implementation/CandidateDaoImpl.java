package com.voting.implementation;

import com.voting.dao.CandidateDao;
import com.voting.models.Candidate;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Base64;

public class CandidateDaoImpl implements CandidateDao {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/voting_system";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Saar5048?";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void registerCandidate(Candidate candidate) {
        String sql = "INSERT INTO candidates (fullName, dateOfBirth, email, phoneNumber, address, candidateId, partyAffiliation, position, profilePicture, slogan, biography, qualifications, manifestoTitle, manifestoText, endorsements, manifestoVideo, supportingDocuments, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, candidate.getFullName());
            statement.setString(2, candidate.getDateOfBirth());
            statement.setString(3, candidate.getEmail());
            statement.setString(4, candidate.getPhoneNumber());
            statement.setString(5, candidate.getAddress());
            statement.setString(6, candidate.getCandidateId());
            statement.setString(7, candidate.getPartyAffiliation());
            statement.setString(8, candidate.getPosition());
            statement.setBytes(9, candidate.getProfilePicture());
            statement.setString(10, candidate.getSlogan());
            statement.setString(11, candidate.getBiography());
            statement.setString(12, candidate.getQualifications());
            statement.setString(13, candidate.getManifestoTitle());
            statement.setString(14, candidate.getManifestoText());
            statement.setString(15, candidate.getEndorsements());
            statement.setBytes(16, candidate.getManifestoVideo());
            statement.setBytes(17, candidate.getSupportingDocuments());
            statement.setString(18, candidate.getStatus());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Candidate> getAllCandidates() {
        List<Candidate> candidates = new ArrayList<>();
        String sql = "SELECT * FROM candidates";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Candidate candidate = new Candidate();
                // Set properties from resultSet
                candidate.setId(resultSet.getInt("id"));
                candidate.setFullName(resultSet.getString("fullName"));
                candidate.setDateOfBirth(resultSet.getString("dateOfBirth"));
                candidate.setEmail(resultSet.getString("email"));
                candidate.setPhoneNumber(resultSet.getString("phoneNumber"));
                candidate.setAddress(resultSet.getString("address"));
                candidate.setCandidateId(resultSet.getString("candidateId"));
                candidate.setPartyAffiliation(resultSet.getString("partyAffiliation"));
                candidate.setPosition(resultSet.getString("position"));
                candidate.setProfilePicture(resultSet.getBytes("profilePicture"));
                candidate.setSlogan(resultSet.getString("slogan"));
                candidate.setBiography(resultSet.getString("biography"));
                candidate.setQualifications(resultSet.getString("qualifications"));
                candidate.setManifestoTitle(resultSet.getString("manifestoTitle"));
                candidate.setManifestoText(resultSet.getString("manifestoText"));
                candidate.setEndorsements(resultSet.getString("endorsements"));
                candidate.setManifestoVideo(resultSet.getBytes("manifestoVideo"));
                candidate.setSupportingDocuments(resultSet.getBytes("supportingDocuments"));
                candidate.setStatus(resultSet.getString("status"));

                // Convert byte arrays to Base64 strings for JSP rendering
                candidate.setSupportingDocumentsUrl("data:application/pdf;base64," + Base64.getEncoder().encodeToString(candidate.getSupportingDocuments()));
                candidate.setManifestoVideoUrl("data:video/mp4;base64," + Base64.getEncoder().encodeToString(candidate.getManifestoVideo()));

                candidates.add(candidate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidates;
    }

    @Override
    public Candidate getCandidateById(int id) {
        String sql = "SELECT * FROM candidates WHERE id = ?";
        Candidate candidate = null;

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                candidate = new Candidate();
                // Set properties from resultSet
                candidate.setId(resultSet.getInt("id"));
                candidate.setFullName(resultSet.getString("fullName"));
                candidate.setDateOfBirth(resultSet.getString("dateOfBirth"));
                candidate.setEmail(resultSet.getString("email"));
                candidate.setPhoneNumber(resultSet.getString("phoneNumber"));
                candidate.setAddress(resultSet.getString("address"));
                candidate.setCandidateId(resultSet.getString("candidateId"));
                candidate.setPartyAffiliation(resultSet.getString("partyAffiliation"));
                candidate.setPosition(resultSet.getString("position"));
                candidate.setProfilePicture(resultSet.getBytes("profilePicture"));
                candidate.setSlogan(resultSet.getString("slogan"));
                candidate.setBiography(resultSet.getString("biography"));
                candidate.setQualifications(resultSet.getString("qualifications"));
                candidate.setManifestoTitle(resultSet.getString("manifestoTitle"));
                candidate.setManifestoText(resultSet.getString("manifestoText"));
                candidate.setEndorsements(resultSet.getString("endorsements"));
                candidate.setManifestoVideo(resultSet.getBytes("manifestoVideo"));
                candidate.setSupportingDocuments(resultSet.getBytes("supportingDocuments"));
                candidate.setStatus(resultSet.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidate;
    }

    @Override
    public void updateCandidateStatus(int id, String status) {
        String sql = "UPDATE candidates SET status = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, status);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void approveCandidate(int id) {
        updateCandidateStatus(id, "Approved");
    }

    @Override
    public void rejectCandidate(int id) {
        updateCandidateStatus(id, "Rejected");
    }
}

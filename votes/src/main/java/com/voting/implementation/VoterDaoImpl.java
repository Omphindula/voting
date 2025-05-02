/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.voting.implementation;

/**
 *
 * @author USER
 */
import com.voting.dao.VoterDao;
import com.voting.models.Voter;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoterDaoImpl implements VoterDao {

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
    public void registerVoter(Voter voter) throws Exception {
        if (findVoterByEmail(voter.getEmail()) != null) {
            throw new Exception("Email already registered.");
        }

        //insatnce of bcyrptor for pswd
        voter.setPassword(BCrypt.hashpw(voter.getPassword(), BCrypt.gensalt()));

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); 
            PreparedStatement statement = connection.prepareStatement("INSERT INTO voters (name, surname, email, studentNumber, phoneNumber, password) VALUES (?, ?, ?, ?, ?, ?)")) {
            statement.setString(1, voter.getName());
            statement.setString(2, voter.getSurName());
            statement.setString(3, voter.getEmail());
            statement.setString(4, voter.getStudentNumber());
            statement.setString(5, voter.getPhoneNumber());
            statement.setString(6, voter.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Registration failed: " + e.getMessage(), e);
        }
    }

    @Override
    public Voter authenticateVoter(String email, String password) throws Exception {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); 
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM voters WHERE email = ?")) {
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                Voter voter = new Voter();
                voter.setId(rs.getInt("id"));
                voter.setName(rs.getString("name"));
                voter.setSurName(rs.getString("surname"));
                voter.setEmail(rs.getString("email"));
                voter.setStudentNumber(rs.getString("studentNumber"));
                voter.setPhoneNumber(rs.getString("phoneNumber"));
                voter.setPassword(rs.getString("password"));

                if (BCrypt.checkpw(password, voter.getPassword())) {
                    return voter;
                }
            }
        } catch (SQLException e) {
            throw new Exception("Authentication failed: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public Voter findVoterByEmail(String email) throws Exception {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); 
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM voters WHERE email = ?")) {
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                Voter voter = new Voter();
                voter.setId(rs.getInt("id"));
                voter.setName(rs.getString("name"));
                voter.setSurName(rs.getString("surname"));
                voter.setEmail(rs.getString("email"));
                voter.setStudentNumber(rs.getString("studentNumber"));
                voter.setPhoneNumber(rs.getString("phoneNumber"));
                voter.setPassword(rs.getString("password"));
                return voter;
            }
        } catch (SQLException e) {
            throw new Exception("Find by email failed: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Voter> getAllVoters() {
        List<Voter> voters = new ArrayList<>();
        String sql = "SELECT * FROM voters";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                Statement statement = connection.createStatement(); 
                ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                
                }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return voters;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.voting.implementation;

import com.voting.dao.ElectionDao;
import com.voting.models.Election;
import java.sql.*;
import java.util.*;

/**
 *
 * @author USER
 */
public class ElectionDaoImpl implements ElectionDao {

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
    public void addElection(Election election) throws SQLException {
        String sql = "INSERT INTO elections (name, description, startDate, endDate, status, positions) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, election.getName());
            stmt.setString(2, election.getDescription());
            stmt.setString(3, election.getStartDate());
            stmt.setString(4, election.getEndDate());
            stmt.setString(5, election.getStatus());
            stmt.setString(6, election.getPositions());
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Election> getAllElections() throws SQLException {
        List<Election> elections = new ArrayList<>();
        String sql = "SELECT * FROM elections";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Election election = new Election(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("startDate"),
                        rs.getString("endDate"),
                        rs.getString("status"),
                        rs.getString("positions")
                );
                elections.add(election);
            }
        }
        return elections;
    }

    @Override
    public Election getElectionById(int id) throws SQLException {
        Election election = null;
        String sql = "SELECT * FROM elections WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    election = new Election(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("description"),
                            rs.getString("startDate"),
                            rs.getString("endDate"),
                            rs.getString("status"),
                            rs.getString("positions")
                    );
                }
            }
        }
        return election;
    }

    @Override
    public List<String> getElectionPositions(int id) throws SQLException {
        List<String> positions = new ArrayList<>();
        String sql = "SELECT positions FROM elections WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String positionsStr = rs.getString("positions");
                    positions = Arrays.asList(positionsStr.split("\\s*,\\s*"));
                }
            }
        }
        return positions;
    }
   @Override
    public void updateElection(Election election) throws SQLException {
        String sql = "UPDATE elections SET name = ?, description = ?, startDate = ?, endDate = ?, status = ?, positions = ? WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, election.getName());
            stmt.setString(2, election.getDescription());
            stmt.setString(3, election.getStartDate());
            stmt.setString(4, election.getEndDate());
            stmt.setString(5, election.getStatus());
            stmt.setString(6, election.getPositions());
            stmt.setInt(7, election.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteElection(int id) throws SQLException {
        String sql = "DELETE FROM elections WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
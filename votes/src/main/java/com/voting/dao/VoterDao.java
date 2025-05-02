/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.voting.dao;

/**
 *
 * @author USER
 */
import com.voting.models.Candidate;
import com.voting.models.Voter;
import java.util.List;

public interface VoterDao {
    void registerVoter(Voter voter) throws Exception;
    Voter authenticateVoter(String email, String password) throws Exception;
    Voter findVoterByEmail(String email) throws Exception;
    List<Voter> getAllVoters();
}
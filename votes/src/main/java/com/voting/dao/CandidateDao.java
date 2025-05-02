/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.voting.dao;

import com.voting.models.Candidate;
import java.util.List;

/**
 *
 * @author USER
 */
public interface CandidateDao {
    void registerCandidate(Candidate candidate);
    List<Candidate> getAllCandidates();
    Candidate getCandidateById(int id);
    void updateCandidateStatus(int id, String status);
    void approveCandidate(int id);
    void rejectCandidate(int id);
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.voting.dao;

import com.sun.xml.ws.tx.at.v10.types.Vote;
import com.voting.models.Votes;
import java.util.List;



public interface VotesDAO {
    // Save a vote
    void saveVote(Votes vote);

    // Get all votes for a specific election
    List<Votes> getVotesForElection(int electionId);

    // Check if a voter has already voted in a specific election
    boolean hasVoted(int electionId, int voterId);
}

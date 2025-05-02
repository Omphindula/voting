package com.voting.models;

import java.util.HashMap;
import java.util.Map;

public class Results {
    private int electionId;
    private Map<Integer, Integer> candidateVotes; // Stores candidateId -> voteCount

    // Constructor to initialize with electionId
    public Results(int electionId) {
        this.electionId = electionId;
        this.candidateVotes = new HashMap<>();
    }

    // Method to add votes for a candidate
    public void addVote(int candidateId, int voteCount) {
        this.candidateVotes.put(candidateId, voteCount);
    }

    // Getter for electionId
    public int getElectionId() {
        return electionId;
    }

    // Getter for candidateVotes
    public Map<Integer, Integer> getCandidateVotes() {
        return candidateVotes;
    }
}

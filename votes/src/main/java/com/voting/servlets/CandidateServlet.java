/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.voting.servlets;
import com.voting.dao.CandidateDao;
import com.voting.implementation.CandidateDaoImpl;
import com.voting.models.Candidate;


/**
 *
 * @author USER
 */
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;


public class CandidateServlet extends HttpServlet {
    private CandidateDao candidateDao = new CandidateDaoImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fullName = request.getParameter("fullName");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String candidateId = request.getParameter("candidateId");
        String partyAffiliation = request.getParameter("partyAffiliation");
        String position = request.getParameter("position");
        String slogan = request.getParameter("slogan");
        String biography = request.getParameter("biography");
        String qualifications = request.getParameter("qualifications");
        String manifestoTitle = request.getParameter("manifestoTitle");
        String manifestoText = request.getParameter("manifestoText");
        String endorsements = request.getParameter("endorsements");

        // File uploads (profile picture, manifesto video, supporting documents)
        byte[] profilePicture = null;
        byte[] manifestoVideo = null;
        byte[] supportingDocuments = null;

        Part profilePicturePart = request.getPart("profilePicture");
        if (profilePicturePart != null) {
            try (InputStream profilePictureStream = profilePicturePart.getInputStream()) {
                profilePicture = profilePictureStream.readAllBytes();
            }
        }

        Part manifestoVideoPart = request.getPart("manifestoVideo");
        if (manifestoVideoPart != null) {
            try (InputStream manifestoVideoStream = manifestoVideoPart.getInputStream()) {
                manifestoVideo = manifestoVideoStream.readAllBytes();
            }
        }

        Part supportingDocumentsPart = request.getPart("supportingDocuments");
        if (supportingDocumentsPart != null) {
            try (InputStream supportingDocumentsStream = supportingDocumentsPart.getInputStream()) {
                supportingDocuments = supportingDocumentsStream.readAllBytes();
            }
        }

        // Create and populate the Candidate object
        Candidate candidate = new Candidate();
        candidate.setFullName(fullName);
        candidate.setDateOfBirth(dateOfBirth);
        candidate.setEmail(email);
        candidate.setPhoneNumber(phoneNumber);
        candidate.setAddress(address);
        candidate.setCandidateId(candidateId);
        candidate.setPartyAffiliation(partyAffiliation);
        candidate.setPosition(position);
        candidate.setProfilePicture(profilePicture);
        candidate.setSlogan(slogan);
        candidate.setBiography(biography);
        candidate.setQualifications(qualifications);
        candidate.setManifestoTitle(manifestoTitle);
        candidate.setManifestoText(manifestoText);
        candidate.setEndorsements(endorsements);
        candidate.setManifestoVideo(manifestoVideo);
        candidate.setSupportingDocuments(supportingDocuments);
        candidate.setStatus("Pending"); // Default status

        // Register the candidate
        candidateDao.registerCandidate(candidate);
        
        // Redirect to success page
        request.setAttribute("message", "Your application is under review. We will contact you via email. Status: Pending.");
        request.getRequestDispatcher("candidatesuccess.html").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle getting candidates and displaying them
        List<Candidate> candidates = candidateDao.getAllCandidates();
        request.setAttribute("candidates", candidates);
        request.getRequestDispatcher("candidates.jsp").forward(request, response);
    }
}
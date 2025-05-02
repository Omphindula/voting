/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.voting.models;

/**
 *
 * @author USER
 */
import java.io.Serializable;
import java.util.Base64;

public class Candidate implements Serializable {

    private int id;
    private String fullName;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;
    private String address;
    private String candidateId;
    private String partyAffiliation;
    private String position;
    private byte[] profilePicture;
    private String slogan;
    private String biography;
    private String qualifications;
    private String manifestoTitle;
    private String manifestoText;
    private String endorsements;
    private byte[] manifestoVideo;
    private byte[] supportingDocuments;
    private String status;
    private String supportingDocumentsUrl; // URL for supporting documents
    private String manifestoVideoUrl;

    public Candidate() {
    }

    public Candidate(String fullName, String dateOfBirth, String email, String phoneNumber, String address, String candidateId, String partyAffiliation, String position, byte[] profilePicture, String slogan, String biography, String qualifications, String manifestoTitle, String manifestoText, String endorsements, byte[] manifestoVideo, byte[] supportingDocuments, String status) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.candidateId = candidateId;
        this.partyAffiliation = partyAffiliation;
        this.position = position;
        this.profilePicture = profilePicture;
        this.slogan = slogan;
        this.biography = biography;
        this.qualifications = qualifications;
        this.manifestoTitle = manifestoTitle;
        this.manifestoText = manifestoText;
        this.endorsements = endorsements;
        this.manifestoVideo = manifestoVideo;
        this.supportingDocuments = supportingDocuments;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getPartyAffiliation() {
        return partyAffiliation;
    }

    public void setPartyAffiliation(String partyAffiliation) {
        this.partyAffiliation = partyAffiliation;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getManifestoTitle() {
        return manifestoTitle;
    }

    public void setManifestoTitle(String manifestoTitle) {
        this.manifestoTitle = manifestoTitle;
    }

    public String getManifestoText() {
        return manifestoText;
    }

    public void setManifestoText(String manifestoText) {
        this.manifestoText = manifestoText;
    }

    public String getEndorsements() {
        return endorsements;
    }

    public void setEndorsements(String endorsements) {
        this.endorsements = endorsements;
    }

    public byte[] getManifestoVideo() {
        return manifestoVideo;
    }

    public void setManifestoVideo(byte[] manifestoVideo) {
        this.manifestoVideo = manifestoVideo;
    }

    public byte[] getSupportingDocuments() {
        return supportingDocuments;
    }

    public void setSupportingDocuments(byte[] supportingDocuments) {
        this.supportingDocuments = supportingDocuments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
////////////////////

    public String getSupportingDocumentsUrl() {
        return supportingDocumentsUrl;
    }

    public void setSupportingDocumentsUrl(String supportingDocumentsUrl) {
        this.supportingDocumentsUrl = supportingDocumentsUrl;
    }

    public String getManifestoVideoUrl() {
        return manifestoVideoUrl;
    }

    public void setManifestoVideoUrl(String manifestoVideoUrl) {
        this.manifestoVideoUrl = manifestoVideoUrl;
    }
    // Method to convert profile picture byte array to Base64 string

    public String getProfilePictureBase64() {
        return profilePicture != null ? Base64.getEncoder().encodeToString(profilePicture) : null;
    }

    // Method to convert manifesto video byte array to Base64 string (if needed)
    public String getManifestoVideoBase64() {
        return manifestoVideo != null ? Base64.getEncoder().encodeToString(manifestoVideo) : null;
    }

    // Method to convert supporting documents byte array to Base64 string (if needed)
    public String getSupportingDocumentsBase64() {
        return supportingDocuments != null ? Base64.getEncoder().encodeToString(supportingDocuments) : null;
    }
}

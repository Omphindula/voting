/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.voting.servlets;

import com.voting.models.Voter;
import com.voting.dao.VoterDao;
import com.voting.implementation.VoterDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;


import java.io.IOException;

//@WebServlet("/VoterRegisterServlet")
public class VoterRegisterServlet extends HttpServlet {
 private VoterDao voterDao = new VoterDaoImpl(); // Use DAO implementation

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String surName = request.getParameter("surName");
        String email = request.getParameter("email");
        String studentNumber = request.getParameter("studentNumber");
        String phoneNumber = request.getParameter("phoneNumber");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (name == null || surName == null || email == null || studentNumber == null || phoneNumber == null || password == null || confirmPassword == null) {
            request.setAttribute("errorMessage", "Form parameters are missing.");
            request.getRequestDispatcher("voterRegister.jsp").forward(request, response);
            return;
        }

        if (!password.equals(confirmPassword)) {
            request.setAttribute("errorMessage", "Passwords do not match.");
            request.getRequestDispatcher("voterRegister.jsp").forward(request, response);
            return;
        }

        try {
            Voter voter = new Voter(name, surName, email, studentNumber, phoneNumber, password);
            voterDao.registerVoter(voter); // Use DAO directly
            response.sendRedirect("registrationSuccess.jsp");
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Registration failed: " + e.getMessage());
            request.getRequestDispatcher("voterRegister.jsp").forward(request, response);
        }
    }
}
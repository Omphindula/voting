/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.voting.servlets;

import com.voting.dao.CandidateDao;
import com.voting.implementation.CandidateDaoImpl;
import com.voting.models.Candidate;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USER
 */
public class CandidateManagementServlet extends HttpServlet {

    private CandidateDao candidateDao;

    @Override
    public void init() throws ServletException {
        candidateDao = new CandidateDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Candidate> candidates = candidateDao.getAllCandidates();
        request.setAttribute("candidates", candidates);
        request.getRequestDispatcher("candidates.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int candidateId = Integer.parseInt(request.getParameter("candidateId"));

        if ("approve".equals(action)) {
            candidateDao.approveCandidate(candidateId);
        } else if ("reject".equals(action)) {
            candidateDao.rejectCandidate(candidateId);
        }

        response.sendRedirect("manageCandidates");
    }
}

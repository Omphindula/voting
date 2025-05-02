/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.voting.servlets;

import com.voting.dao.ResultsDAO;
import com.voting.implementation.ResultsDAOImpl;
import com.voting.models.Results;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ResultsServlet", urlPatterns = {"/ResultsServlet"})
public class ResultsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int electionId = Integer.parseInt(request.getParameter("electionId")); // Get election ID from request

            // Establish database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "user", "password");
            ResultsDAO resultsDAO = new ResultsDAOImpl(connection);

            // Retrieve results for the specified election
            Results results = resultsDAO.getResultsForElection(electionId);

            // Set results as a request attribute to forward to the JSP page
            request.setAttribute("results", results);

            // Forward to the results JSP page
            request.getRequestDispatcher("results.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error retrieving results.");
        }
    }
}

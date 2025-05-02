/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.voting.servlets;

import com.google.gson.Gson;
import com.voting.dao.ElectionDao;
import com.voting.implementation.ElectionDaoImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class GetPositionsServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(GetPositionsServlet.class.getName());

    private ElectionDao electionDao = new ElectionDaoImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        int electionId = Integer.parseInt(request.getParameter("electionId"));

        try {
            List<String> positions = electionDao.getElectionPositions(electionId);
            String jsonResponse = new Gson().toJson(Collections.singletonMap("positions", positions));
            response.getWriter().write(jsonResponse);
        } catch (SQLException | NumberFormatException e) {
            LOGGER.severe("SQL Exception: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"Unable to fetch positions\"}");
        }
    
    }
}
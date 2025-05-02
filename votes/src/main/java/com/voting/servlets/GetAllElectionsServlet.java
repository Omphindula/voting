/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.voting.servlets;

/**
 *
 * @author USER
 */
import com.google.gson.Gson;
import com.voting.dao.ElectionDao;
import com.voting.implementation.ElectionDaoImpl;
import com.voting.models.Election;
import java.io.*;
import java.sql.SQLException;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


public class GetAllElectionsServlet extends HttpServlet {

    private ElectionDao electionDao = new ElectionDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Election> elections = electionDao.getAllElections();
            response.setContentType("application/json");
            response.getWriter().write(new Gson().toJson(Collections.singletonMap("elections", elections)));
        } catch (SQLException e) {
            
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error while fetching elections.");
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.web;

import edu.iit.itmd4515.smuthyala.domain.Staff;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

/**
 *
 * @author sanjayreddy
 */
@WebServlet(name = "StaffServlet", urlPatterns = {"/staff"})
public class StaffServlet extends HttpServlet {
    
    @Resource
    Validator validator;
    
    @Resource(lookup = "java:app/jdbc/itmd4515DS")
    DataSource ds;

    private static final Logger LOG = Logger.getLogger(StaffServlet.class.getName());

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LOG.info("StaffServlet doGet Method");
        
        Staff newStaff = new Staff();
        
        //response.sendRedirect("/smuthyala-fp/staff.jsp");
        request.setAttribute("staff", newStaff);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/staff.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LOG.info("StaffServlet doPost Method");
        
        String staffIdParam = request.getParameter("staffId");
        String staffFNParam = request.getParameter("firstName");
        String staffLNParam = request.getParameter("lastName");
        String staffUNParam = request.getParameter("userName");
        String staffActiveParam = request.getParameter("active");
        String staffStoreParam = request.getParameter("storeId");
        String staffAddressParam = request.getParameter("addressId");
        String staffEmailParam = request.getParameter("email");
        
        
        LOG.info("Staff ID: " + staffIdParam);
        LOG.info("Staff FirstName: " + staffFNParam);
        LOG.info("Staff LastName: " + staffLNParam);
        LOG.info("Staff UserName: " + staffUNParam);
        LOG.info("Staff Active: " + staffActiveParam);
        LOG.info("Staff Store ID: " + staffStoreParam);
        LOG.info("Staff AddressID: " + staffAddressParam);
        LOG.info("Staff Email: " + staffEmailParam);
        
        Integer staffId = null;
        if(staffIdParam != null && !staffIdParam.isBlank()){
            staffId = Integer.valueOf(staffIdParam);
        }
        
        Integer storeId = null;
        if(staffStoreParam != null && !staffStoreParam.isBlank()){
            storeId = Integer.valueOf(staffStoreParam);
        }
        
        Integer addressId = null;
        if(staffAddressParam != null && !staffAddressParam.isBlank()){
            addressId = Integer.valueOf(staffAddressParam);
        }
        
        Boolean active;
        if(staffActiveParam != null && staffActiveParam.equalsIgnoreCase("ON")){
            active = true;
        }
        else{
            active = false;
        }
        
        Staff buildStaffFromUserInput = new Staff(staffId, storeId, staffFNParam, staffLNParam, staffUNParam, staffEmailParam, addressId,active,LocalDate.now());
        
        LOG.info("The staff built from user Input" + buildStaffFromUserInput.toString());
        
        Set<ConstraintViolation<Staff>> violations = validator.validate(buildStaffFromUserInput);
        
        if(violations.size() > 0){
            for(ConstraintViolation<Staff> violation : violations){
                LOG.info(violation.toString());
            }
            
            request.setAttribute("staff", buildStaffFromUserInput);
            request.setAttribute("errors", violations);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/staff.jsp");
            dispatcher.forward(request, response);
            
        }else{
            
            createAStaff(buildStaffFromUserInput);
            
            request.setAttribute("staff", buildStaffFromUserInput);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/confirmation.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void createAStaff(Staff s){
        String INSERT_SQl = "insert into staff "
                + "(staff_id, store_id, first_name, last_name, username, email, address_id, active, last_update) "
                + "values (?,?,?,?,?,?,?,?,?)";
        
        try(Connection con = ds.getConnection();
                PreparedStatement ps = con.prepareStatement(INSERT_SQl);){
            ps.setInt(1, s.getStaffId());
            ps.setInt(2, s.getStoreId());
            ps.setString(3, s.getFirstName());
            ps.setString(4, s.getLastName());
            ps.setString(5, s.getUserName());
            ps.setString(6, s.getEmail());
            ps.setInt(7, s.getAddressId());
            ps.setBoolean(8, s.isActive());
            ps.setObject(9, s.getLastUpdate());

            ps.executeUpdate();
        } catch (SQLException ex) {
           LOG.log(Level.SEVERE, null, ex);
        }
                
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

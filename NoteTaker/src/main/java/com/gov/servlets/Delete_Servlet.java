package com.gov.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

/**
 * Servlet implementation class Delete_Servlet
 */
public class Delete_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int noteid = Integer.parseInt(request.getParameter("note_id"));
		
		Session s = FactoryProvider.getFactory().openSession();
		
		Note n = s.get(Note.class, noteid);
		Transaction tx = s.beginTransaction();
		s.delete(n);
		tx.commit();
		
		
		s.close();
		
		response.sendRedirect("All_Notes.jsp");
	}

}

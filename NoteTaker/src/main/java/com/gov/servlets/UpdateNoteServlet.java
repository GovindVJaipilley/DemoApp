package com.gov.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

/**
 * Servlet implementation class UpdateNoteServlet
 */
public class UpdateNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int noteid = Integer.parseInt(request.getParameter("note_id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Session s =FactoryProvider.getFactory().openSession();
		Transaction tx = s.beginTransaction();
		Note n = s.get(Note.class, noteid);
		n.setTitle(title);
		n.setContent(content);
		n.setAddedDate(new Date());
		tx.commit();
		s.close();
		response.sendRedirect("All_Notes.jsp");
	}

}

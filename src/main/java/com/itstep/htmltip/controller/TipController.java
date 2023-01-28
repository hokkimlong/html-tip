package com.itstep.htmltip.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itstep.htmltip.model.Tip;
import com.itstep.htmltip.model.TipDao;

/**
 * Servlet implementation class TipController
 */
@WebServlet("/tips/*")
public class TipController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TipController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "";

		HttpSession session = request.getSession();

		if (session.getAttribute("userId") == null) {
			response.sendRedirect(request.getContextPath() + "/admin");
			return;
		}

		if (request.getPathInfo() != null) {
			String name = request.getPathInfo().substring(1);
			if (name != null) {

				switch (name) {
				case "create": {
					page = "tipCreation.jsp";
					break;
				}
				case "not-found": {
					page = "tip-404.jsp";
					break;
				}
				default: {
					try {
						page = "tipDetails.jsp";
						int id = Integer.parseInt(name);
						Tip foundTip = TipDao.findOneById(id);
						if (foundTip == null) {
							response.sendRedirect(request.getContextPath() + "/tips/not-found");
							return;
						}
						request.setAttribute("tip", foundTip);
					} catch (Exception e) {
						response.sendRedirect(request.getContextPath() + "/");
						return;
					}
				}
				}
			}
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/" + page);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String exampleHtmlEscape = request.getParameter("exampleHtmlEscape");

		String action = request.getParameter("action");

		switch (action) {
		case "create": {
			Tip tip = new Tip(title, description, exampleHtmlEscape);
			TipDao.create(tip);
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
		}

	}

}

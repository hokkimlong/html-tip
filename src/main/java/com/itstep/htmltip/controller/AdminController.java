package com.itstep.htmltip.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itstep.htmltip.model.User;
import com.itstep.htmltip.model.UserDao;
import com.itstep.htmltip.model.UserManager;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/admin/*")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getPathInfo() != null) {
			String name = request.getPathInfo().substring(1);

			if (name != null && name.equals("logout")) {
				HttpSession session = request.getSession();
				session.invalidate();
				response.sendRedirect(request.getContextPath() + "/admin");
				return;
			}

		}

		HttpSession session = request.getSession();

		if (session.getAttribute("userId") != null) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		} else {
			int totalAdmin = UserDao.getTotal();

			String page = "login.jsp";
			if (totalAdmin <= 0) {
				page = "register.jsp";
			}
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/" + page);
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String action = request.getParameter("action");
		String page = "login.jsp";

		switch (action) {
		case "register": {
			UserManager.register(username, password);
			break;
		}
		default:
			User user = UserManager.login(username, password);
			HttpSession session = request.getSession();

			if (user != null) {
				session.setAttribute("userId", user.getId());
				session.setAttribute("username", user.getUsername());
				response.sendRedirect(request.getContextPath() + "/");
				return;
			}
			break;
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/" + page);
		dispatcher.forward(request, response);
	}

}

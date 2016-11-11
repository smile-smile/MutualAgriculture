package com.geowind.hunong.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geowind.hunong.entities.User;
import com.geowind.hunong.entities.UserDAO;
import com.geowind.hunong.service.UserService;
import com.geowind.hunong.service.impl.UserServiceImpl;

public class BUserServlet extends BasicServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		String op = request.getParameter("op");
		switch (op) {
		// 查找所有
		case "searchAll":
			searchAll(request, response);
			break;
		// 编辑信息
		case "detail":
			detail(request, response);
			break;
		case "isExistUser":
			isExistUser(request, response);
		default:
			break;
		}
	}

	private void isExistUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		UserDAO userDAO = new UserDAO();
		User user = userDAO.findById(request.getParameter("username"));
		if (user != null) {
			// System.out.println("{\"mark\":\"1\",\"realname\":\""+user.getRealname()+"\"}");
			// this.out(response, "1");
			if (user.getValid() == 1) {
				this.out(response, "{\"mark\":\"1\",\"realname\":\"" + user.getRealname() + "\",\"phone\":\""
						+ user.getPhone() + "\"}");
			} else {
				this.out(response, "{\"mark\":\"0\"}");
			}
		} else {
			this.out(response, "{\"mark\":\"0\"}");
		}
	}

	/**
	 * 用户详情
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void detail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String type = request.getParameter("type");
		if (type.equals("v_farmer")) {
			UserDAO userDAO = new UserDAO();
			User currentFarmer = userDAO.findById(request.getParameter("username"));
			request.getSession().setAttribute("currentFarmer", currentFarmer);
			response.sendRedirect("editorfarmer.jsp");
		} else if (type.equals("v_machiner")) {
			UserDAO userDAO = new UserDAO();
			User currentMachiner = userDAO.findById(request.getParameter("username"));
			request.getSession().setAttribute("currentMachienr", currentMachiner);
			response.sendRedirect("editormachiner.jsp");
		}

	}

	/**
	 * 查找所有用户
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void searchAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
		UserService userService = new UserServiceImpl();
		String type = request.getParameter("type");
		int centerId = (int) request.getSession().getAttribute("currentCenterId");
		if (type.equals("v_farmer")) {
			if (request.getSession().getAttribute("allFarmer") == null) {
				List<User> farmerList = userService.search(centerId, type);
				request.getSession().setAttribute("allFarmer", farmerList);
			}
			response.sendRedirect("farmer.jsp");
		} else if (type.equals("v_machiner")) {
			if (request.getSession().getAttribute("allMachiner") == null) {
				List<User> farmerList = userService.search(centerId, type);
				request.getSession().setAttribute("allMachiner", farmerList);
			}
			response.sendRedirect("machiner.jsp");
		}

	}

}

package view.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.intf.modelJPA.Cat;
import ru.intf.modelJPA.Menu;
import view.classes.ConverterUserOv;
import view.classes.GetData;

/**
 * Сервлет подгрузки всех данных с примитивным редиректом
 * @author Новотельнов А.Д.
 * @version 1.0
 */
@WebServlet("/sGetAllMenu")
public class SGetAllData extends HttpServlet {
	private static final long serialVersionUID = 7626192582341292495L;

	//Я выбрал способ обращение через отдельный класс 
	//@EJB
	//private MenuEJBLocal mjb;
	
	//Переменные
	private static ConverterUserOv cv;
	private GetData gd = new GetData();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SGetAllData() {
		super();
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int id = cv.useStrToInt(request.getParameter("setMenuId"));
		
		List<Menu> menuData = gd.getMenuAll();
		List<Cat> catData = gd.getCat();
		
		request.setAttribute("menuData", menuData);
		request.setAttribute("catData", catData);
		
		if (request.getParameter("SetNewItem") != null) {
			getServletContext().getRequestDispatcher("/add.jsp").forward(request, response);
		} else if (request.getParameter("idItemEdit") != null) {
			request.setAttribute("editableElement", gd.getMenuSearchByParam(cv.useStrToInt(request.getParameter("idItemEdit"))));
			request.setAttribute("idItemEdit", request.getParameter("idItemEdit")); 
			request.setAttribute("idItemCatEdit", request.getParameter("idItemCatEdit"));
			
			getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
		} else {
			getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
}

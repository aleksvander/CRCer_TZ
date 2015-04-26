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
 * Сервлет для поиска элемента меню по заданым параметрам
 * @author Новотельнов А.Д.
 * @version 1.0
 */
@WebServlet("/sSearchItem")
public class SSearchItem extends HttpServlet {

	private static final long serialVersionUID = 2553783494487472799L;
	
	//Переменные
	private static ConverterUserOv cv;
	private GetData gd = new GetData();
	
    public SSearchItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Инициализируем id - и парсим инт
		int id = cv.useStrToInt(request.getParameter("setMenuId"));
		String value = request.getParameter("setSelectedMenuInput");;
		
		//Проверяем поиска на категорию
		if (id == 3)
			value = request.getParameter("searchByCatListing");
		
		List<Menu> menuData = gd.getMenuByParam(id, value);
		List<Cat> catData = gd.getCat();
		
		request.setAttribute("menuData", menuData);
		request.setAttribute("catData", catData);
		
		getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);
	}

}

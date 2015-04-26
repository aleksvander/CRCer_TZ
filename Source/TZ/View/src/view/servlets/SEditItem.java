package view.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.intf.model.ejb.MenuEJBLocal;
import view.classes.ConverterUserOv;

/**
 * Сервлет для обновления выбранных данных - Меню
 * @author Новотельнов А.Д.
 * @version 1.0
 */
@WebServlet("/sEditItem")
public class SEditItem extends HttpServlet {
	private static final long serialVersionUID = -1625603559889326046L;
	
	@EJB
	private MenuEJBLocal mjb;
	
	private ConverterUserOv cv;
    
    public SEditItem() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Обновляем выбранный элемент
		if (mjb.updateItem
			(
					cv.useStrToInt(request.getParameter("idItemEdit")), 
					request.getParameter("name"), 
					cv.useStrToFloat(request.getParameter("price")), 
					cv.useStrToInt(request.getParameter("catId"))
			)
		) request.setAttribute("result", "Element edit - ok"); else request.setAttribute("result", "Element NOT edit");
		//Возвращаемся к меню через редирект страницу
		response.sendRedirect("/View/redirect.jsp");
	}

}

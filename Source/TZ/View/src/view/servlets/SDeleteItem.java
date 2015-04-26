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
 * Servlet implementation class SDeleteItem
 */
@WebServlet("/sDeleteItem")
public class SDeleteItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@EJB
	private MenuEJBLocal mjb;
	
	private static ConverterUserOv cv;
	//private GetData gd = new GetData();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SDeleteItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id;
		try {
			//Удаляем элемент по ID своевременно преобразовывая в int
			id = cv.useStrToInt(request.getParameter("IdItemDelete"));
			if (mjb.deleteItem(id)) {
				System.out.println("Element #" + id + " remove");
			}
			
			//Возвращаемся к меню через редирект страницу
			response.sendRedirect("/View/redirect.jsp");
		} catch (Exception e) { //NullPointer - ?
			System.out.println("Error " + e.getStackTrace() + " ! : "+ e);
		}
	}
}

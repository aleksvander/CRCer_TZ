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
 * ������� ��� ���������� �������� � ����
 * @author ����������� �.�.
 * @version 1.0
 */
@WebServlet("/sEditItem")
public class SAddItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private MenuEJBLocal mjb;
	//����� ���������
	private ConverterUserOv cv;
	
    public SAddItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//��������� ������� � ����� ������ ������� (INSERT)
			if (mjb.createMenu(
					request.getParameter("name"), 
					cv.useStrToFloat(request.getParameter("price")), 
					cv.useStrToInt(request.getParameter("catId"))
					)
			) request.setAttribute("result", "Element add - ok"); else request.setAttribute("result", "Element NOT add"); 
			getServletContext().getRequestDispatcher("/redirect.jsp").forward(request, response);
		} catch (NullPointerException e){
			System.out.println("Error " + e.getStackTrace() + " ! : "+ e);
		}
	}

}

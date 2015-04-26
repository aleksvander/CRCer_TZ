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
 * ������� ��� ������ �������� ���� �� ������� ����������
 * @author ����������� �.�.
 * @version 1.0
 */
@WebServlet("/sSearchItem")
public class SSearchItem extends HttpServlet {

	private static final long serialVersionUID = 2553783494487472799L;
	
	//����������
	private static ConverterUserOv cv;
	private GetData gd = new GetData();
	
    public SSearchItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �������������� id - � ������ ���
		int id = cv.useStrToInt(request.getParameter("setMenuId"));
		String value = request.getParameter("setSelectedMenuInput");;
		
		//��������� ������ �� ���������
		if (id == 3)
			value = request.getParameter("searchByCatListing");
		
		List<Menu> menuData = gd.getMenuByParam(id, value);
		List<Cat> catData = gd.getCat();
		
		request.setAttribute("menuData", menuData);
		request.setAttribute("catData", catData);
		
		getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);
	}

}

package view.classes;

import java.util.List;

import javax.naming.InitialContext;

import ru.intf.model.ejb.CatEJBLocal;
import ru.intf.model.ejb.MenuEJBLocal;
import ru.intf.modelJPA.Cat;
import ru.intf.modelJPA.Menu;

/**
 * ����� ��� ������������ ������� ������ �� ejb
 * @author ����������� �.�.
 * @version 1.0
 * @date 13.04.2015
 */
public class GetData {
	
	private InitialContext ctx;
	private MenuEJBLocal menuEJBLocal;
	private CatEJBLocal catEJBLocal;
	
	/**
	 * �������������� ���������� ��� ����
	 * @return MenuEJBLocal
	 */
	private MenuEJBLocal initializeMenuEJBLocal() {
		try {
			ctx = new InitialContext();
			//JNDI
			menuEJBLocal = (MenuEJBLocal) ctx.lookup("java:global/App1/Model/MenuEJB");			
		} catch (Exception e) {
			
		}
		return menuEJBLocal;
	}
	
	/**
	 * �������������� ���������� ��� ���������
	 * @return CatEJBLocal
	 */
	private CatEJBLocal initializeCatEJBLocal() {
		try {
			ctx = new InitialContext();
			//JNDI
			catEJBLocal = (CatEJBLocal) ctx.lookup("java:global/App1/Model/CatEJB");			
		} catch (Exception e) {
			
		}
		return catEJBLocal;
	}
	
	/**
	 * ����� ��� �������� ������������������� ���������� 
	 * @return MenuEJBLocal
	 */
	private MenuEJBLocal getEJBMenuLocal() {
		if (menuEJBLocal != null) {
			return menuEJBLocal;
		} else {
			return initializeMenuEJBLocal();
		}
	}
	
	/**
	 * ����� ��� �������� ������������������� ���������� 
	 * @return CatEJBLocal
	 */
	private CatEJBLocal getEJBCatLocal() {
		if (catEJBLocal != null) {
			return catEJBLocal;
		} else {
			return initializeCatEJBLocal();
		}
	}
	
	/**
	 * ����� ��� ��������� ��������� �� �������� ����
	 * @return
	 */
	public List<Menu> getMenuAll() {
		//���������� � ���� ����� ��� ���������
		try {
			return (getEJBMenuLocal().getAllMenu());
		} catch (Exception e) {
			return null;
		} 
	}
	
	/**
	 * ����� ��� ��������� ��������� �� �������� ���������
	 * @return
	 */
	public List<Cat> getCat() {
		//���������� � ���� ����� ��� ���������
		try {
			return (getEJBCatLocal().getAllCat());
		} catch (Exception e) {
			return null;
		} 
	}
	
	/**
	 * ����� ��� ��������� ��������� �� �������� ���� � ������ ��
	 * @param id
	 * @return
	 */
	public List<Menu> getMenuSearchByParam(int id) {
		return getEJBMenuLocal().getById(id);
	}

	/**
	 * ����� �������������� ����� �� �������� ����������
	 * @param id - ��� ������ (������: 1 - �� �����, 2 - �� ����, 3 - �� ���������)
	 * @param value - ������� ��������
	 * @return
	 */
	public List<Menu> getMenuByParam(int id, String value) {
		return getEJBMenuLocal().getMenuByParam(id, value);
	}
}

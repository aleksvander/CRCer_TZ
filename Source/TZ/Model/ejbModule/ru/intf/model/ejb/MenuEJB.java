package ru.intf.model.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ru.intf.model.classes.ConverterUserOv;
import ru.intf.model.classes.MessangerException;
import ru.intf.model.classes.OtherOpertation;
import ru.intf.model.ejb.dao.CatDaoEJB;
import ru.intf.model.ejb.dao.MenuDaoEJB;
import ru.intf.modelJPA.Cat;
import ru.intf.modelJPA.Menu;

/**
 * @author ����������� �.�.
 * @version 1.0
 * EJB Session Stateless
 * ����� ����������� ������ ������ � ��������� jpa / Menu.
 * ������������ ������ ��� ������ / ������� / ���������� / �������� - ������.
 */
@Stateless(name = "MenuEJB", mappedName="ejb/menuEJB")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class MenuEJB implements MenuEJBLocal {

	@EJB(name = "nameDaoEJB")
	private MenuDaoEJB menuDaoEJB;
	@EJB(name = "catEJB")
	private CatDaoEJB catEJB;
	
	private OtherOpertation op = new OtherOpertation();
	private static ConverterUserOv cv;
	private static MessangerException me;
	
    /**
     * ����� ��� ����� ���� ������ �� ������� ����
     * @return List<Menu>
     */
	@Override
	public List<Menu> getAllMenu() {
    	return menuDaoEJB.findAllEntities();
	}
	
	/**
	 * ����� ������� �� ��
	 * @param id - �� �������� ��������
	 */
	@Override
	public List<Menu> getById(int id) { 
		return menuDaoEJB.findAllMenuEntities(id);
	}

	/**
	 * ����� ��������� ������� ����
	 * @param id �� ������
	 * @return ���������� true ���� �������� ������ �������, ��� ������������� ������� ���������� false
	 */
	@Override
	public boolean deleteItem(int id){
		Menu menu = menuDaoEJB.findById(id);
		menuDaoEJB.remove(menu);
		return true;
	}
	
	/**
	 * ����� UPDATE ��������� ������ � ������� ����
	 * @param id - ������� ��
	 * @param name - ����� ���
	 * @param price - ����� ����
	 * @param catId - �� ��������� ���������
	 * @return ��������� (������)
	 */
	@Override
	public boolean updateItem(int id, String name, Float price, int catId) {
		Menu menu = menuDaoEJB.findById(id);
		Cat cat = selectedCat(catId);
		setAllValues(menu, name, price, cat);
		menuDaoEJB.persist(menu);
		return true;
	}
	
	/**
	 * ����� INSERT ����� ������ � ������� ����
	 * @param name - ���
	 * @param price - ����
	 * @param catId - ��������� ���������
	 * @return ��������� (������)
	 */
	@Override
	public boolean createMenu(String name, Float price, int catId) {
		if (catId != 0) {
			menuDaoEJB.persist(setAllValues(name, price, catId));
		} else {
			menuDaoEJB.persist(setAllValues(name, price));
		}
		return true;
	}
	
	/**
	 * ��� ��������� ������ �������� ��� Cat
	 */
	private Menu setAllValues(String name, Float price) {
		Menu menu = new Menu();
		menu.setName(name);
		menu.setPrice(price);
		return menu;
	}

	/**
	 * ����� ��� �������� ������� / �������� ���������� ������ Cat
	 * @param id - �� ���������
	 * @return - ��������� ������� / ������ �������� Cat 
	 */
	private Cat selectedCat(int id) {
		if (id == 0) {
			return new Cat();
		} else {
			return catEJB.findById(id);
		}
	}
	
	/**
	 * ���������������� 
	 * "������� �����������" ��� �������� ����.
	 * @param menu - ����
	 * @param name - ����
	 * @param price - ����
	 * @param cat - ����
	 * @return - ���������� ��������� ������ ����
	 */
	private Menu setAllValues(Menu menu, String name, Float price, Cat cat) {
		menu.setName(name);
		menu.setPrice(price);
		menu.setCat(cat);
		return menu; 
	}
	
	/**
	 * ���������������� 
	 * "������� �����������" ��� �������� ����.
	 * @param name - ����
	 * @param price - ����
	 * @param catId - ����
	 * @return - ���������� ��������� ������ ����
	 */
	private Menu setAllValues(String name, Float price, int catId) {
		return new Menu(name, price, selectedCat(catId));
	}
	
	/**
	 * � �������� �� ���������� Local
	 * ������������� ����� ���������� FacadeLocal
	 * ����� ��� ������ �������� �� ��������� ����������� � ����� ������� ��� ������� Menu
	 * @param id - �� ������ �������
	 * @param value - �������� �������� ��������
	 * @return - ��������� ���������� �������� - List<Menu>
	 */
	@Override
	public List<Menu> getMenuByParam(int id, String value) {
		String nameColumn = op.switchNameColumn(id);
		String str = value; //value.toString();;
		String method = "LIKE";
		if(nameColumn != null) {
			//�� ������ ������������ ���� �������� ������������ ���������� ���������� ��� "����� ���������������" ������������ �������
			if (id == 2) { if (cv.useToFloat(value) == null) str = ""; } 
			if (id == 3) { if (cv.useStrToInt(str) == 0) { str = "NULL"; method = "IS"; } 
			} else if (id != 3) { str = "'%" + str + "%'"; }
			if (str == null) str = "";

			//���������� ���������
			return menuDaoEJB.findAllMenuEntitiesByParam(nameColumn, method, str);
		} else {
			return null;
		}
	}
}


package ru.intf.model.ejb;

import java.util.List;

import javax.ejb.Local;

import ru.intf.modelJPA.Menu;

/**
 * ��������� ��������� ��� ������� � ejb ����������
 * @author ����������� �.�.
 * @version 1.0
 */
@Local
public interface MenuEJBLocal {
	/*** ���������� ������� */
	public boolean deleteItem(int id);
	public boolean updateItem(int id, String name, Float price, int catId);
	public boolean createMenu(String name, Float price, int catId);

	/*** ������� ������ */
	public List<Menu> getAllMenu();
	public List<Menu> getById(int id);
	public List<Menu> getMenuByParam(int id, String value);
}

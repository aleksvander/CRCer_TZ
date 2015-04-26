package ru.intf.model.ejb;

import java.util.List;

import javax.ejb.Local;

import ru.intf.modelJPA.Menu;

/**
 * Локальный интерфейс для доступа к ejb компоненту
 * @author Новотельнов А.Д.
 * @version 1.0
 */
@Local
public interface MenuEJBLocal {
	/*** Управление данными */
	public boolean deleteItem(int id);
	public boolean updateItem(int id, String name, Float price, int catId);
	public boolean createMenu(String name, Float price, int catId);

	/*** Выборка данных */
	public List<Menu> getAllMenu();
	public List<Menu> getById(int id);
	public List<Menu> getMenuByParam(int id, String value);
}

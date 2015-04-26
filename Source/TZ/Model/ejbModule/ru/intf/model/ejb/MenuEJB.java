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
 * @author Новотельнов А.Д.
 * @version 1.0
 * EJB Session Stateless
 * Класс реализующий логику работы с сущностью jpa / Menu.
 * Представляет методы для поиска / выборки / обновления / удаления - данных.
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
     * Метод для сбора всех данных из таблицы меню
     * @return List<Menu>
     */
	@Override
	public List<Menu> getAllMenu() {
    	return menuDaoEJB.findAllEntities();
	}
	
	/**
	 * Метод выборки по ид
	 * @param id - ид искомого элемента
	 */
	@Override
	public List<Menu> getById(int id) { 
		return menuDaoEJB.findAllMenuEntities(id);
	}

	/**
	 * Метод удаляющий элемент меню
	 * @param id ИД товара
	 * @return возвращает true если удаление прошло успешно, при возникновении проблем возвращает false
	 */
	@Override
	public boolean deleteItem(int id){
		Menu menu = menuDaoEJB.findById(id);
		menuDaoEJB.remove(menu);
		return true;
	}
	
	/**
	 * Метод UPDATE выбранной записи в таблице меню
	 * @param id - искомый ид
	 * @param name - новое имя
	 * @param price - новая цена
	 * @param catId - ид выбранной категории
	 * @return результат (булеан)
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
	 * Метод INSERT новой записи в таблице меню
	 * @param name - имя
	 * @param price - цена
	 * @param catId - выбранная категория
	 * @return результат (булеан)
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
	 * Для заведения нового элемента без Cat
	 */
	private Menu setAllValues(String name, Float price) {
		Menu menu = new Menu();
		menu.setName(name);
		menu.setPrice(price);
		return menu;
	}

	/**
	 * Метод для возврата пустого / искомого экземпляра класса Cat
	 * @param id - ид категории
	 * @return - Экземпляр искомой / пустой сущности Cat 
	 */
	private Cat selectedCat(int id) {
		if (id == 0) {
			return new Cat();
		} else {
			return catEJB.findById(id);
		}
	}
	
	/**
	 * Переопределенный 
	 * "Внешний конструктор" для сущности меню.
	 * @param menu - поле
	 * @param name - поле
	 * @param price - поле
	 * @param cat - поле
	 * @return - возвращает экземпляр класса Меню
	 */
	private Menu setAllValues(Menu menu, String name, Float price, Cat cat) {
		menu.setName(name);
		menu.setPrice(price);
		menu.setCat(cat);
		return menu; 
	}
	
	/**
	 * Переопределенный 
	 * "Внешний конструктор" для сущности меню.
	 * @param name - поле
	 * @param price - поле
	 * @param catId - поле
	 * @return - возвращает экземпляр класса Меню
	 */
	private Menu setAllValues(String name, Float price, int catId) {
		return new Menu(name, price, selectedCat(catId));
	}
	
	/**
	 * С доступом из интерфейса Local
	 * Реализованный метод интерфейса FacadeLocal
	 * Метод для поиска элемента по указанным параметрами и имени колонки для таблицы Menu
	 * @param id - ид номера колонки
	 * @param value - значение искомого элемента
	 * @return - результат выполнения операции - List<Menu>
	 */
	@Override
	public List<Menu> getMenuByParam(int id, String value) {
		String nameColumn = op.switchNameColumn(id);
		String str = value; //value.toString();;
		String method = "LIKE";
		if(nameColumn != null) {
			//На основе определнного типа значений производится подготовка переменных для "некой универсальности" формирования запроса
			if (id == 2) { if (cv.useToFloat(value) == null) str = ""; } 
			if (id == 3) { if (cv.useStrToInt(str) == 0) { str = "NULL"; method = "IS"; } 
			} else if (id != 3) { str = "'%" + str + "%'"; }
			if (str == null) str = "";

			//Возвращаем результат
			return menuDaoEJB.findAllMenuEntitiesByParam(nameColumn, method, str);
		} else {
			return null;
		}
	}
}


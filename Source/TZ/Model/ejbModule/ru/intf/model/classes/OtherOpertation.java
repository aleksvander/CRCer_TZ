package ru.intf.model.classes;

/**
 * Класс для прочих задач
 * @author Новотельнов А.Д.
 * @version 1.0
 * @date 13.04.2015
 */
public class OtherOpertation {
	
	/**
	 * Метод для выбора искомой колонки - для подстановки в запрос
	 * @param id
	 * @return
	 */
	public String switchNameColumn(int id) {
		switch(id) {
		case 1:
			return "name";
		case 2:
			return "price";
		case 3:
			return "cat";
		default:
			break;
		}
		return null;
	}
}

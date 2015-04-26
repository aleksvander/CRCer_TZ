package ru.intf.model.ejb.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import ru.intf.modelJPA.Menu;


/**
 * @author Новотельнов А.Д.
 * @version 1.0
 * EJB Session Stateless
 * Класс реализует шаблон DAO для сущности model/jpa, наследуется от параметризированного класса JPADaoEJB
 * в который мы передаем model/jpa/Menu. Класс позволяет найти все сущности Menu(jpa).
 * Методы: поиск / выборка данных
 */
@Stateless(name = "menuDaoEJB", mappedName="ejb/menuDaoEJB")
@Local
public class MenuDaoEJB extends JPADaoEJB<Menu> {

	/**
	 * Метод для отображения всех записей
	 * @return - List<Menu>
	 */
	@Override
	public List<Menu> findAllEntities() {
		return em.createNamedQuery("Menu.findAll").getResultList();
	}
	
	/**
	 * Метод для поиска записей по ид
	 * @param id
	 * @return - List<Menu>
	 */
	public List<Menu> findAllMenuEntities(int id) {
		TypedQuery<Menu> query = em.createQuery("SELECT m FROM Menu m WHERE m.id = :id", Menu.class);
		query.setParameter("id", id);
		return query.getResultList();
	}
	
	/**
	 * ---- (как способ реализации простого полиморфизма)
	 * Метод для выборки данных по определенным условям
	 * Используется для поиска
	 * @param nameColumn - имя колонки
	 * @param method - метод поиска IS / LIKE 
	 * @param str - искомое значение
	 * @return - List<Menu>
	 */
	public List<Menu> findAllMenuEntitiesByParam(String nameColumn, String method, String str) {
		//Формируем запрос
		StringBuilder sb = new StringBuilder("SELECT m FROM Menu m WHERE m." + nameColumn + " " + method + " " + str);
		return em.createQuery(sb.toString()).getResultList();
	}
}

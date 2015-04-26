package ru.intf.model.ejb.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import ru.intf.modelJPA.Cat;

/**
 * @author Новотельнов А.Д.
 * @version 1.0
 * EJB Session Stateless
 * Класс реализует шаблон DAO для сущности cat/jpa, наследуется от параметризированного класса JPADaoEJB
 * в который мы передаем model/jpa/Cat. Класс позволяет найти все сущности Cat(jpa).
 * Методы: поиск / выборка данных
 */
@Stateless(name = "catDaoEJB", mappedName="ejb/catDaoEJB")
@Local
public class CatDaoEJB extends JPADaoEJB<Cat> {

	/**
	 * Осуществляет выборку всех данных категории
	 * @return - List<Cat>
	 */
	@Override
	public List<Cat> findAllEntities() {
		return em.createNamedQuery("Cat.findAll").getResultList();
	}

	/**
	 * Осуществляет поиск категории по ид 
	 * @param id - ид категории 
	 * @return - List<Cat>
	 */
	public List<Cat> findAllCatEntities(int id) {
		TypedQuery<Cat> query = em.createQuery("SELECT c FROM Cat c WHERE c.id = :id", Cat.class);
		query.setParameter("id", id);
		return query.getResultList();
	}
}

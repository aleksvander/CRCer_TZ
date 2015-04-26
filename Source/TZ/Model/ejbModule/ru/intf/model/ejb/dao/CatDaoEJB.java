package ru.intf.model.ejb.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import ru.intf.modelJPA.Cat;

/**
 * @author ����������� �.�.
 * @version 1.0
 * EJB Session Stateless
 * ����� ��������� ������ DAO ��� �������� cat/jpa, ����������� �� �������������������� ������ JPADaoEJB
 * � ������� �� �������� model/jpa/Cat. ����� ��������� ����� ��� �������� Cat(jpa).
 * ������: ����� / ������� ������
 */
@Stateless(name = "catDaoEJB", mappedName="ejb/catDaoEJB")
@Local
public class CatDaoEJB extends JPADaoEJB<Cat> {

	/**
	 * ������������ ������� ���� ������ ���������
	 * @return - List<Cat>
	 */
	@Override
	public List<Cat> findAllEntities() {
		return em.createNamedQuery("Cat.findAll").getResultList();
	}

	/**
	 * ������������ ����� ��������� �� �� 
	 * @param id - �� ��������� 
	 * @return - List<Cat>
	 */
	public List<Cat> findAllCatEntities(int id) {
		TypedQuery<Cat> query = em.createQuery("SELECT c FROM Cat c WHERE c.id = :id", Cat.class);
		query.setParameter("id", id);
		return query.getResultList();
	}
}

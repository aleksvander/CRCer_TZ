package ru.intf.model.ejb.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import ru.intf.modelJPA.Menu;


/**
 * @author ����������� �.�.
 * @version 1.0
 * EJB Session Stateless
 * ����� ��������� ������ DAO ��� �������� model/jpa, ����������� �� �������������������� ������ JPADaoEJB
 * � ������� �� �������� model/jpa/Menu. ����� ��������� ����� ��� �������� Menu(jpa).
 * ������: ����� / ������� ������
 */
@Stateless(name = "menuDaoEJB", mappedName="ejb/menuDaoEJB")
@Local
public class MenuDaoEJB extends JPADaoEJB<Menu> {

	/**
	 * ����� ��� ����������� ���� �������
	 * @return - List<Menu>
	 */
	@Override
	public List<Menu> findAllEntities() {
		return em.createNamedQuery("Menu.findAll").getResultList();
	}
	
	/**
	 * ����� ��� ������ ������� �� ��
	 * @param id
	 * @return - List<Menu>
	 */
	public List<Menu> findAllMenuEntities(int id) {
		TypedQuery<Menu> query = em.createQuery("SELECT m FROM Menu m WHERE m.id = :id", Menu.class);
		query.setParameter("id", id);
		return query.getResultList();
	}
	
	/**
	 * ---- (��� ������ ���������� �������� ������������)
	 * ����� ��� ������� ������ �� ������������ �������
	 * ������������ ��� ������
	 * @param nameColumn - ��� �������
	 * @param method - ����� ������ IS / LIKE 
	 * @param str - ������� ��������
	 * @return - List<Menu>
	 */
	public List<Menu> findAllMenuEntitiesByParam(String nameColumn, String method, String str) {
		//��������� ������
		StringBuilder sb = new StringBuilder("SELECT m FROM Menu m WHERE m." + nameColumn + " " + method + " " + str);
		return em.createQuery(sb.toString()).getResultList();
	}
}

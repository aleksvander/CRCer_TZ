package ru.intf.model.ejb.dao.interfaces;

import java.util.List;

/**
 * ��������� - ����������/��������, �������� � �����
 * @author ����������� �.�.
 * @version 1.0
 * @param <T>
 */
public interface IDaoEJB<T> {

	/**
	 * �������� ����� ������, ���� ���������� ������������
	 * @param entity ��������� ��������
	 */
	void persist(T entity);
	
	/**
	 * �������� ������
	 * @param entity ��������� ��������
	 */
	void remove(T entity);
	
	/**
	 * ����� ���� �������
	 * @return ������ �������� ���������
	 */
	List<T> findAllEntities();
}

package ru.intf.model.ejb.dao;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ru.intf.model.ejb.dao.interfaces.IDaoEJB;

/**
 * ���������� ���������� ������������ ������ DAO 
 * ��������� ���������� ��������� IDaoEJB
 * @author ����������� �.�.
 * @version 1.0
 * @param <E>
 */
public abstract class JPADaoEJB<E> implements IDaoEJB<E> {
	/** ��������� �������� �������� */
	protected Class<E> entityClass;
	
	@PersistenceContext
	protected EntityManager em;
	
	/**
	 * ����������� �� ��������� 
	 * �������� ��� ����������� ������
	 */
	@SuppressWarnings("unchecked")
	public JPADaoEJB() {
		Class<?> cl = getClass();
		//��������� �� ����������� �������� ����������
		 if (Object.class.getSimpleName().equals(cl.getSuperclass().getSimpleName())) {
			 throw new IllegalArgumentException(
					 "Default constructor can't create instance");
		 }

		 //
		 while
			 (!JPADaoEJB.class.getSimpleName().equals(cl.getSuperclass().getSimpleName())) {
			 if (cl.getGenericSuperclass() instanceof ParameterizedType) {
				 break;
			 }
			 cl = cl.getSuperclass();
		 }
		 if (cl.getGenericSuperclass() instanceof ParameterizedType) {
			 this.entityClass = (Class<E>) ((ParameterizedType) cl.getGenericSuperclass()).getActualTypeArguments()[0];	 
		 }
	}
	
	public void persist(E entity) {
		em.persist(entity);
	}
	
	/**
	 * ����� ��� �������� ������
	 * @param E
	 */
	public void remove(E entity) {
		entity = (E) em.merge(entity);
		em.remove(entity);
	}
	
	/**
	 * ����� ������������ ����� �������� �� ��
	 * @param id �� ��������
	 * @return ��������� ��������
	 */
	public E findById(int id) {
		return em.find(entityClass, id);
	}
}

package ru.intf.model.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ru.intf.model.ejb.dao.CatDaoEJB;
import ru.intf.modelJPA.Cat;

/**
 * @author ����������� �.�.
 * @version 1.0
 * EJB Session Stateless
 * ����� ����������� ������ ������ � ��������� jpa / Cat.
 * ������������ ������ ��� ������ / ������� / ���������� / �������� - ������.
 */
@Stateless(name = "CatEJB", mappedName="ejb/catEJB")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class CatEJB implements CatEJBLocal {

	@EJB(name = "catDaoEJB")
	private CatDaoEJB catDaoEJB;

	@Override
	public List<Cat> getAllCat() {
    	return catDaoEJB.findAllEntities();
	}
	
	@Override
	public List<Cat> getById(int id) { 
		return catDaoEJB.findAllCatEntities(id);
	}
}

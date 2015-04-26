package ru.intf.model.ejb;

import java.util.List;

import javax.ejb.Local;

import ru.intf.modelJPA.Cat;

/**
 * ��������� ��������� ��� ������� � ejb ����������
 * @author ����������� �.�.
 * @version 1.0
 */
@Local
public interface CatEJBLocal {
	public List<Cat> getAllCat();
	public List<Cat> getById(int id);
}

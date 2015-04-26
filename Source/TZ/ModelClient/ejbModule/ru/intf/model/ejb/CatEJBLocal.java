package ru.intf.model.ejb;

import java.util.List;

import javax.ejb.Local;

import ru.intf.modelJPA.Cat;

/**
 * Локальный интерфейс для доступа к ejb компоненту
 * @author Новотельнов А.Д.
 * @version 1.0
 */
@Local
public interface CatEJBLocal {
	public List<Cat> getAllCat();
	public List<Cat> getById(int id);
}

package ru.intf.model.classes;

/**
 * ����� ��� ������ �����
 * @author ����������� �.�.
 * @version 1.0
 * @date 13.04.2015
 */
public class OtherOpertation {
	
	/**
	 * ����� ��� ������ ������� ������� - ��� ����������� � ������
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

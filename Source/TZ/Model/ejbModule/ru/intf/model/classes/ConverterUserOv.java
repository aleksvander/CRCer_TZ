package ru.intf.model.classes;

/**
 * Класс для конвертирования данных
 * @author Новотельнов А.Д.
 * @version 1.0
 */
public class ConverterUserOv {
	public static final ConverterUserOv INSTANCE = new ConverterUserOv();
	
	public static Float useToFloat(String value) {
		try {
			return Float.parseFloat(value);
		} catch (NumberFormatException e) {
			return null;
		}
	}
	
	public static Float useToFloat(Object value) {
		try {
			return (Float)value;
		} catch (NumberFormatException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static int useStrToInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return -1;
		}
	}
}

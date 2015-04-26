package view.classes;

/**
 * Класс для конвертирования данных
 * @author Новотельнов А.Д.
 * @version 1.0
 */
public class ConverterUserOv {
	public static final ConverterUserOv INSTANCE = new ConverterUserOv();

	private ConverterUserOv() {
	}
	
	public static ConverterUserOv getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	public static int useStrToInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return -1;
		}
	}
	
	public static Float useStrToFloat(String value) {
		try {
			return Float.parseFloat(value);
		} catch (NumberFormatException e) {
			return -1f;
		}
	}
}

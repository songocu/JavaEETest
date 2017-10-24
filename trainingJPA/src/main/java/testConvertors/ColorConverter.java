package testConvertors;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ColorConverter implements AttributeConverter<String, String> {

	/**
	 * Convert Color object to a String with format red|green|blue|alpha
	 */
	public String convertToDatabaseColumn(String color) {
		if (color.toString().equalsIgnoreCase("red"))
			return color.toString()+" discovered";
		return "Other value";
	}

	/**
	 * Convert a String with format red|green|blue|alpha to a Color object
	 */
	public String convertToEntityAttribute(String colorString) {
		if (colorString.equals("red discovered"))
			return colorString.replace(" discovered", "");
		return "Other value";
	}

}
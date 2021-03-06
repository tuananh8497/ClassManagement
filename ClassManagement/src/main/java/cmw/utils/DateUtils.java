package cmw.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {
	public static Date formatDate(String dateStr) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(dateStr);
		Date date = null;
		try {
			System.out.println(df);
			date = df.parse(dateStr);
		} catch (ParseException e1) {
			System.out.println("Exception occurred in parsing date : " + e1);
		}
		return date;
	}

	public static String date2String(LocalDate localDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		String stringDate = localDate.format(formatter);
		return stringDate;
	}
}

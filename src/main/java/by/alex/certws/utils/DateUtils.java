package by.alex.certws.utils;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

	public static ZonedDateTime CurrentUTCDateTime() {
		return ZonedDateTime.now(ZoneOffset.UTC);
	}

	public static String CurrentUTCDateTime(ZonedDateTime DT) {
		return DT.format(DateTimeFormatter.ISO_INSTANT);
	}

}

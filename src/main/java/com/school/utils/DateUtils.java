package com.school.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import com.school.exception.CustomException;

public class DateUtils {

	public static Date increaseDate(Date date, Integer daysToIncrease, Integer monthsToIncrease,
			Integer yearsToIncrease) {
		Calendar c = dateToCalendar(date);
		if (daysToIncrease != null) {
			c.add(Calendar.DATE, daysToIncrease.intValue());
		}
		if (monthsToIncrease != null) {
			c.add(Calendar.MONTH, monthsToIncrease.intValue());
		}
		if (yearsToIncrease != null) {
			c.add(Calendar.YEAR, yearsToIncrease.intValue());
		}
		return c.getTime();
	}

	public static Date increaseDateCeil(Date date, Integer daysToIncrease, Integer monthsToIncrease,
			Integer yearsToIncrease) {
		Calendar c = dateToCalendar(date);
		if (daysToIncrease != null) {
			c.add(Calendar.DATE, daysToIncrease.intValue());
		}
		if (monthsToIncrease != null) {
			c.add(Calendar.MONTH, monthsToIncrease.intValue());
		}
		if (yearsToIncrease != null) {
			c.add(Calendar.YEAR, yearsToIncrease.intValue());
		}
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		return c.getTime();
	}

	public static Date increaseDateFloor(Date date, Integer daysToIncrease, Integer monthsToIncrease,
			Integer yearsToIncrease) {
		Calendar c = dateToCalendar(date);
		if (daysToIncrease != null) {
			c.add(Calendar.DATE, daysToIncrease.intValue());
		}
		if (monthsToIncrease != null) {
			c.add(Calendar.MONTH, monthsToIncrease.intValue());
		}
		if (yearsToIncrease != null) {
			c.add(Calendar.YEAR, yearsToIncrease.intValue());
		}
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	public static Date increaseTime(Date date, Integer hoursToIncrease, Integer minutesToIncrease) {
		Calendar c = dateToCalendar(date);
		if (hoursToIncrease != null) {
			c.add(Calendar.HOUR_OF_DAY, hoursToIncrease.intValue());
		}
		if (minutesToIncrease != null) {
			c.add(Calendar.MINUTE, minutesToIncrease.intValue());
		}
		return c.getTime();
	}

	// Convert Date to Calendar
	private static Calendar dateToCalendar(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;

	}

	// Convert Calendar to Date
//	private static Date calendarToDate(Calendar calendar) {
//		return calendar.getTime();
//	}

	public static Date convertStrToDate(String dobStr) {
		Date formattedDate = null;
		if (StringUtils.hasText(dobStr)) {
			SimpleDateFormat formatter = new SimpleDateFormat(IConstants.PATTERN_DATE);
			String dateInString = dobStr;
			try {
				formattedDate = formatter.parse(dateInString);
			} catch (ParseException e) {
				throw new CustomException(HttpStatus.BAD_REQUEST, "Invalid Date");
			}
		}
		return formattedDate;
	}

	public static String convertDateToStr(Date dob) {
		String dateStr = null;
		if (dob != null) {
//			DateFormat inputFormat = new SimpleDateFormat(IConstants.PATTERN_DB_DATE_FORMAT);
//			Date date = inputFormat.parse(inputFormat);

//			DateFormat df = new SimpleDateFormat(IConstants.PATTERN_DB_DATE_FORMAT);
			try {
				DateFormat outputFormat = new SimpleDateFormat(IConstants.PATTERN_DATE);
				dateStr = outputFormat.format(dob);
//				dateStr = df.format(dateStr);
			} catch (Exception e) {
				throw new CustomException(HttpStatus.BAD_REQUEST, "Invalid Date");
			}
		}
		return dateStr;
	}

	public static long getTimeDifferenceInMinutes(Date startDate, Date endDate) {
		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		calendar1.setTime(startDate);
		calendar2.setTime(endDate);
		long milsecs1 = calendar1.getTimeInMillis();
		long milsecs2 = calendar2.getTimeInMillis();

		long diff = milsecs2 - milsecs1;
		long dminutes = diff / (60 * 1000);

		return dminutes;
	}

}

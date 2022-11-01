package com.LGQ.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @className DateUtil.java
 * @description
 * @author 刘国强
 * @version 1.0
 * @since 1.0
 * @date 2022年6月2日
 */
public class DateUtil {
	public static Timestamp now() {
		Date date = new Date();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return Timestamp.valueOf(sFormat.format(date));
	}
}

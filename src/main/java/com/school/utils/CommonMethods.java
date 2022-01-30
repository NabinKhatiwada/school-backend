package com.school.utils;

import java.util.List;

import org.springframework.data.domain.Page;

import com.school.dto.payload.PaginationInfo;



public class CommonMethods {

	public static boolean isEmpty(Integer i) {
		boolean isEmpty = false;
		if (i == null || i <= 0) {
			isEmpty = true;
		}
		return isEmpty;
	}

	public static boolean isEmpty(List<?> list) {
		boolean isEmpty = false;
		if (list == null || list.size() == 0) {
			isEmpty = true;
		}
		return isEmpty;
	}

	public static String generateOTP() {
//		return new DecimalFormat("0000").format(new Random().nextInt(9999));
		return "1234";
	}


	public static boolean isEmpty(String userName) {
		return userName == null || userName.length() == 0;
	}

	public static boolean isEmpty(Double d) {
		boolean isEmpty = false;
		if (d == null || d <= 0) {
			isEmpty = true;
		}
		return isEmpty;
	}

	public static PaginationInfo getPaginationInfo(Page<?> page) {
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setTotal(page.getTotalElements());
		paginationInfo.setPageSize(page.getSize());
		paginationInfo.setPageNo(page.getNumber());
		paginationInfo.setTotalPages(page.getTotalPages());
		return paginationInfo;
	}

	

}

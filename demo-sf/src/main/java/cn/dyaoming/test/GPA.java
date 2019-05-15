package cn.dyaoming.test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;


public class GPA {

	private static boolean check(int[] kcsl) {
		int i = 0;
		for(int sl : kcsl) {
			i += sl;
		}
		if (i <= 20) {
			return true;
		} else {
			return false;
		}
	}



	public static void main(String[] args) {

		String[] kclb = new String[] { "语文", "数学", "英语" };

		int[] kcsl = new int[] { 3, 3, 2 };

		String[][] kcjg = new String[5][4];
		
		
		// 判断是否可以排下
		if (check(kcsl)) {
			
			
			
			
		}else {
			System.out.println("课程超出预算");
		}

		
	}

}
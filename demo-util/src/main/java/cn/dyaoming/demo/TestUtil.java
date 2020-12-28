package cn.dyaoming.demo;

import java.util.ArrayList;
import java.util.List;

public class TestUtil {

	public class Model{
		private String nameString;
	}
	
	public class Model2{
		private String nameString;
	}
	
	public class Model3{
		private String nameString;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> sfList = new ArrayList<>();
		
		
		Model model = getBean();
		Model2 model2 = getBean();
		Model3 model3 = getBean();
	}

	public static <T> T getBean() {
		Object object = null;
		return (T) object;
	}
	
}

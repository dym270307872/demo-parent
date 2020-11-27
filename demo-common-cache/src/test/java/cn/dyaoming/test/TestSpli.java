package cn.dyaoming.test;
import org.springframework.cache.annotation.AnnotationCacheOperationDefinitionSource;
public class TestSpli {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String name = "name#600#true#2";
		String separator = "#";
		
		String[] arg = name.split(separator);
		System.out.println(arg.length);
		
		System.out.println(arg[0]);
		if(arg.length>1) {
			System.out.println(arg[1]);		
		}
		if(arg.length>2) {
			System.out.println(arg[2]);		
		}
		if(arg.length>3) {
			System.out.println(arg[3]);		
		}
	}

}

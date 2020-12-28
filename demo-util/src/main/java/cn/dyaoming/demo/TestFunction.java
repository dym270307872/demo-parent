package cn.dyaoming.demo;

import java.util.Arrays;
import java.util.List;

public class TestFunction {

	public static void main(String[] args) {
		sayHi("dyaoming", (x) -> {
			System.out.println("操作第2步");
			String result = selfSayImpl(x);
			System.out.println("操作第4步：" + result);
		});
		
		
	}

	// 自定义 sayHello 里面的 say 方法的实现
	public static String selfSayImpl(String name) {
		System.out.println("操作第3步");
		return "Hello " + name;
	}

	public static void sayHi(String name, Green green) {
		System.out.println("操作第1步");
		green.say(name);
		System.out.println("操作第5步");
		green.say2(name);
	}

	@FunctionalInterface
	public interface Green {
		void say(String name);
		default void say2(String test) {
			System.out.println("操作第6步");
		}
	}

}

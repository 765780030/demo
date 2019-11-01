package day01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo01 {
	public static void main(String[] args) {
		/*
		 * 第一次使用Spring
		 * ClassPathXmlApplicationContext
		 * 是Spring提供的对象工厂
		 */
		//ctx对象在创建的过程中,会自动的读取beans.xml 并且根据beans.xml的文件内容
		//创建本Spring IOC容器管理的对象
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		//ctx 提供了 getBean 方法可以获取被Spring IOC 创建好的对象
		DemoBean bean = (DemoBean)ctx.getBean("demo");
		//测试被创建的对象
		System.out.println(bean);
	}
}

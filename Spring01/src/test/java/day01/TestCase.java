package day01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *test 测试
 *case 案例
 *
 *测试案例类型,必须是公有类
 */
public class TestCase {
	ClassPathXmlApplicationContext ctx ;
	@Before //init() 方法在测试方法之前执行
	public void init(){
		//初始化资源
		ctx = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	@After //destroy() 方法在测试方法执行之后执行
	public void destroy(){
		//回收资源
		ctx.close();
	}
	
	@Test //必须是无参数,无返回值,公有方法
	public void testHello(){
		System.out.println("Hello World");
	}

	@Test
	public void testKitty() {
		System.out.println("Hello Kitty");
	}
	
	@Test
	public void testDemoBean(){
		DemoBean bean = (DemoBean) ctx.getBean("demo");
		System.out.println(bean);
	}
	
	@Test
	public void testGerBean(){
		/*
		 * Spring 提供了重载的getBean
		 * 可以不用写类型转换了
		 */
		DemoBean bean = ctx.getBean("demo", DemoBean.class);
		System.out.println(bean);
	}
	
	@Test
	public void testSingleton(){
		/*
		 * 默认情况下 Spring按照单例规则管理对象
		 */
		DemoBean b1 = ctx.getBean("demo", DemoBean.class);
		DemoBean b2 = ctx.getBean("demo", DemoBean.class);
		//如果b1 b2引用同一个对象 则结果为true
		System.out.println(b1 == b2);
	}
	
	@Test
	public void testPrototype(){
		/*
		 * 测试Spring创建了多个bean实例
		 */
		DemoBean b1 = ctx.getBean("demo2", DemoBean.class);
		DemoBean b2 = ctx.getBean("demo2", DemoBean.class);
		//如果b1 b2引用不同个对象 则结果为false
		System.out.println(b1==b2);
	}
	
	@Test
	public void testLogger(){
		/*
		 * 测试Spring自动调用对象的生命周期管理方法
		 */
		LogWriter logger = ctx.getBean("logger",LogWriter.class);
		logger.log("Hello");
		logger.log("吃饭没");
		logger.log("回家了");
	}
}

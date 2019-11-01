package day01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *test ����
 *case ����
 *
 *���԰�������,�����ǹ�����
 */
public class TestCase {
	ClassPathXmlApplicationContext ctx ;
	@Before //init() �����ڲ��Է���֮ǰִ��
	public void init(){
		//��ʼ����Դ
		ctx = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	@After //destroy() �����ڲ��Է���ִ��֮��ִ��
	public void destroy(){
		//������Դ
		ctx.close();
	}
	
	@Test //�������޲���,�޷���ֵ,���з���
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
		 * Spring �ṩ�����ص�getBean
		 * ���Բ���д����ת����
		 */
		DemoBean bean = ctx.getBean("demo", DemoBean.class);
		System.out.println(bean);
	}
	
	@Test
	public void testSingleton(){
		/*
		 * Ĭ������� Spring���յ�������������
		 */
		DemoBean b1 = ctx.getBean("demo", DemoBean.class);
		DemoBean b2 = ctx.getBean("demo", DemoBean.class);
		//���b1 b2����ͬһ������ ����Ϊtrue
		System.out.println(b1 == b2);
	}
	
	@Test
	public void testPrototype(){
		/*
		 * ����Spring�����˶��beanʵ��
		 */
		DemoBean b1 = ctx.getBean("demo2", DemoBean.class);
		DemoBean b2 = ctx.getBean("demo2", DemoBean.class);
		//���b1 b2���ò�ͬ������ ����Ϊfalse
		System.out.println(b1==b2);
	}
	
	@Test
	public void testLogger(){
		/*
		 * ����Spring�Զ����ö�����������ڹ�����
		 */
		LogWriter logger = ctx.getBean("logger",LogWriter.class);
		logger.log("Hello");
		logger.log("�Է�û");
		logger.log("�ؼ���");
	}
}

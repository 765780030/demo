package day01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo01 {
	public static void main(String[] args) {
		/*
		 * ��һ��ʹ��Spring
		 * ClassPathXmlApplicationContext
		 * ��Spring�ṩ�Ķ��󹤳�
		 */
		//ctx�����ڴ����Ĺ�����,���Զ��Ķ�ȡbeans.xml ���Ҹ���beans.xml���ļ�����
		//������Spring IOC��������Ķ���
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		//ctx �ṩ�� getBean �������Ի�ȡ��Spring IOC �����õĶ���
		DemoBean bean = (DemoBean)ctx.getBean("demo");
		//���Ա������Ķ���
		System.out.println(bean);
	}
}

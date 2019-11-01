package day01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * LogWriter ��һ����־����� ʹ��ʱ����봴�������,������open��������־�ļ�
 * ʹ���ڼ�,���Զ�ε���log������¼��Ϣ
 * ʹ���Ժ�Ҫ����close() �ر��ļ�
 */
public class LogWriter {
	private PrintWriter out;
	
	public void open() throws IOException{
		out = new PrintWriter("demo.log");
		System.out.println("Open File");
	}
	
	public void close(){
		out.close();
		System.out.println("Close File");
	}
	
	public void log(String msg){
		out.println(msg);
		out.flush();
		System.out.println("Append:"+msg);
	}
}

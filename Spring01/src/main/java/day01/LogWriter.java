package day01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * LogWriter 是一个日志输出类 使用时候必须创建对象后,调用其open方法打开日志文件
 * 使用期间,可以多次调用log方法记录信息
 * 使用以后要调用close() 关闭文件
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

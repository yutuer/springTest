package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.SpringContextUtil;
import spring.UserService;

public class TestServlet extends HttpServlet {
	static {
		new ClassPathXmlApplicationContext("Application.xml");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = (UserService) SpringContextUtil.getBean(UserService.class.getSimpleName());
		long beginTime = System.nanoTime();
		userService.testSpeed(1);
		long endTime = System.nanoTime();
		System.out.println((endTime - beginTime) / 1000 / 1000 / 1000.0);
		response.setStatus(response.SC_OK);
		PrintWriter out = response.getWriter();
		out.println("hello world!!");// 利用PrintWriter对象的方法将数据发送给客户端
		out.close();
	}
}

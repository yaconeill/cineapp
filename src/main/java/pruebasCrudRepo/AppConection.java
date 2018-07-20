package pruebasCrudRepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppConection {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		
		context.close();

	}

}

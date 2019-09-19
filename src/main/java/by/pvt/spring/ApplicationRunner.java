package by.pvt.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        Object dataSource = context.getBean("dataSource");
        System.out.println(dataSource);
    }
}

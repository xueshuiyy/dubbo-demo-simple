package org.apache.dubbo.demo.consumer;

import java.io.IOException;

import org.apache.dubbo.demo.DemoEntity;
import org.apache.dubbo.demo.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"dubbo-demo-consumer.xml"});
        // Obtaining a remote service proxy
        DemoService demoService = context.getBean(DemoService.class);
        while (!read().equals("exit")) {
        	// Executing remote methods
        	DemoEntity hello = demoService.sayHello("world");
            // Display the call result
            System.out.println(hello);
        }
	}
	private static String read() throws IOException {
        byte[] b = new byte[1024];
        int size = System.in.read(b);
        return new String(b, 0, size).trim();
    }

}

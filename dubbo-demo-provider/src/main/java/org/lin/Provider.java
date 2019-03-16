package org.lin;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Title: dubbo
 * @Auth: lenovo
 * @Date: 2018/12/8
 */
public class Provider {
    public static void main(String[] args) throws Exception {
        System.setProperty("java.net.preferIPv4Stack", "true");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"provider.xml"});
        context.start();
        System.out.println("Provider started.");
        System.in.read(); // press any key to exit
    }
}

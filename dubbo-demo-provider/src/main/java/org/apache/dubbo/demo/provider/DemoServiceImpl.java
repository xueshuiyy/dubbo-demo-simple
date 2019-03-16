package org.apache.dubbo.demo.provider;

import java.lang.management.ManagementFactory;

import org.apache.dubbo.demo.DemoEntity;
import org.apache.dubbo.demo.DemoService;

public class DemoServiceImpl implements DemoService {
	int port;
	
	public DemoEntity sayHello(String name) {
		DemoEntity demoEntity = new DemoEntity();
		demoEntity.setName(ManagementFactory.getRuntimeMXBean().getName());
		demoEntity.setPort(port);
		if (port == 20880) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
		return demoEntity;
	}
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}

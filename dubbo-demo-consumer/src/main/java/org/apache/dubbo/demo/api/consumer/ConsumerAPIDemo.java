package org.apache.dubbo.demo.api.consumer;

import java.io.IOException;

import org.apache.dubbo.demo.DemoService;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;

public class ConsumerAPIDemo {
	
	public static void main(String[] args) throws IOException {
		
		// Application Info
		ApplicationConfig application = new ApplicationConfig();
		application.setName("demo-consumer");
		
		// Registry Info
		RegistryConfig registry = new RegistryConfig();
		registry.setAddress("172.27.112.3:2181,172.27.112.4:2181,172.27.112.5:2181");
		registry.setClient("zkclient");
		registry.setProtocol("zookeeper");
		
		// NOTES: ReferenceConfig holds the connections to registry and providers, please cache it for performance.
		// Refer remote service
		ReferenceConfig<DemoService> reference = new ReferenceConfig<DemoService>(); // In case of memory leak, please cache.
		reference.setApplication(application);
		reference.setRegistry(registry); 
		reference.setInterface(DemoService.class);
		reference.setVersion("1.0.0");
		
		// Use demoService just like a local bean
		DemoService demoService = reference.get(); // NOTES: Please cache this proxy instance.
		demoService.sayHello("hello");		
		
		System.out.println("consumer end");
		System.in.read(); // press any key to exit
	}

}

package org.apache.dubbo.demo.api.provider;

import java.io.IOException;

import org.apache.dubbo.demo.DemoService;
import org.apache.dubbo.demo.provider.DemoServiceImpl;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;

public class ProviderAPIDemo {

	public static void main(String[] args) throws IOException {
		
		// Implementation
		DemoService demoService = new DemoServiceImpl();
		 
		// Application Info
		ApplicationConfig application = new ApplicationConfig();
		application.setName("demo-provider");
		 
		// Registry Info
		RegistryConfig registry = new RegistryConfig();
		registry.setAddress("172.27.112.3:2181,172.27.112.4:2181,172.27.112.5:2181");
		registry.setClient("zkclient");
		registry.setProtocol("zookeeper");
		// Protocol
		ProtocolConfig protocol = new ProtocolConfig();
		protocol.setName("dubbo");
		protocol.setPort(-1);
		protocol.setThreads(200);
		 
		// NOTES: ServiceConfig holds the serversocket instance and keeps connections to registry, please cache it for performance.
		 
		// Exporting
		ServiceConfig<DemoService> service = new ServiceConfig<DemoService>(); // In case of memory leak, please cache.
		service.setApplication(application);
		service.setRegistry(registry); // Use setRegistries() for multi-registry case
		service.setProtocol(protocol); // Use setProtocols() for multi-protocol case
		service.setInterface(DemoService.class);
		service.setRef(demoService);
		service.setVersion("1.0.0");
//		service.setAccesslog(accesslog);
		 
		// Local export and register
		service.export();
		
		System.out.println("服务已开启!端口:"+service.getExportedUrls().get(0).getPort());
        System.in.read(); // press any key to exit
		
	}
}

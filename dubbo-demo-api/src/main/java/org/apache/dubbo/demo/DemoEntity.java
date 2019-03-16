package org.apache.dubbo.demo;

import java.io.Serializable;

public class DemoEntity implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String name;
    int port;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	@Override
	public String toString() {
		return "DemoEntity [name=" + name + ", port=" + port + "]";
	}

}

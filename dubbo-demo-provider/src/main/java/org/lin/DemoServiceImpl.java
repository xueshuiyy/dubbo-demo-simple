package org.lin;

/**
 * @Title: dubbo
 * @Auth: lenovo
 * @Date: 2018/12/8
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "hello" + name;
    }
}

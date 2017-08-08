package com.capitalone.lambda;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * Created by Rob on 3/22/2016.
 */
public class Hello implements RequestHandler <Map<String,Object>, String> {
    
	public String handleRequest(Map<String,Object> name, Context context) {
        System.out.println(name);
        System.out.println("Invoking");
        InvokeApi invokeApi = new InvokeApi();
        try {
			invokeApi.sendGet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "Hello Worlds";
    }

    public static void main(String[] args) {
    	Hello hello = new Hello();
    	hello.handleRequest(null, null);
//        SpringBootInvocation springBootInvocation =  new SpringBootInvocation();
//        springBootInvocation.run();
//        springBootInvocation.getApplicationContext().getBean(RequestComponent.class).processRequest("Robert",null);
    }
}

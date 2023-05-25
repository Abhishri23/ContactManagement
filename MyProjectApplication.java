package com.sts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyProjectApplication {
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(MyProjectApplication.class, args);
		
		
	List<Integer> list=new ArrayList<>();
	
	
	
	list.add(10);
	list.add(20);
	list.add(30);
	list.add(40);
	list.add(50);
	list.add(60);
	list.add(70);
	list.add(80);
	list.add(90);
	
	
	
	/*HashMap<Integer,Integer> map=list.stream().collect(Collector.groupingBy(e->e),Collectors.toList());
	
	int sec=list.stream().sorted().distinct().limit(1).findFirst().get();
	System.out.println(sec);*/
	
		
	
		 
}
}

package com.mirim.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// container 설정
		String config1 = "classpath:applicationCTX.xml";
		String config2 = "classpath:applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config1, config2);	// container파일 2개 불러올수 있음
	
		// 방법 1 : 설정
		Student student1 = ctx.getBean("student1", Student.class);	
		// 방법 2 : 설정
		StudentInfo studentInfo = ctx.getBean("studentInfo1", StudentInfo.class);
		
		// 방법 1 : 출력
		System.out.println(student1.getName());
		System.out.println(student1.getHobbys());
		// 방법 2 : 출력
		Student stu1 = studentInfo.getStudent();
		System.out.println(stu1.getName());
		System.out.println(stu1.getHobbys());
		
		
		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println(student2.getName());
		System.out.println(student2.getHobbys());
		
		
		Family family = ctx.getBean("family", Family.class);
		System.out.println(family.getPapaName());
		System.out.println(family.getMamiName());
		System.out.println(family.getSisterName());
		System.out.println(family.getBrotherName());
		 
		ctx.close(); 	// 닫아야지만 bean 객체들이 메모리에서 사라짐
	}

}

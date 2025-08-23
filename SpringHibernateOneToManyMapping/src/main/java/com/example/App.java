package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.AppConfig;
import com.example.entity.Courses;
import com.example.entity.ReportCard;
import com.example.entity.Student;
import com.example.service.StudentService;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        
	    
        StudentService service =  ctx.getBean(StudentService.class);
        Student student = new Student("jiya");
        student.addCourse(new Courses("java"));
        student.addCourse(new Courses("servlet"));
        
        ReportCard rc = new ReportCard(490);
      
         student.setReportcard(rc);
         service.saveData(student);
       
         
       
    }
}
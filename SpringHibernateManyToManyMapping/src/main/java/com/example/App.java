package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.AppConfig;
import com.example.entity.Courses;
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
        Student student = new Student("Vinitha");
        student.addCourse(new Courses("java"));
        student.addCourse(new Courses("servlet"));
        
       
      
         service.saveData(student);
         Student fetchedStudent = service.getStudent(1L);
      // fetchedStudent.getCourses().forEach(c->System.out.println(c.getTitle()));
         System.out.println(fetchedStudent);
    
         
       
    }
}

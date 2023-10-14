package com.example.demo;

import com.example.demo.dao.AppDAO;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
            //createInstructor(appDAO);
            //findInstructor(appDAO);
            deleteInstructor(appDAO);
        };
    }

    private void createInstructor(AppDAO appDAO) {
        Instructor instructor = new Instructor("abc", "efg", "abc@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("abc.com/youtube", "love to code");

		/*Instructor instructor = new Instructor("xyz", "efg", "xyz@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("xyz.com/youtube", "love to code");
*/
        instructor.setInstructorDetail(instructorDetail);

        // Save the instructor
        // NOTE -  THIS WILL ALSO SAVE THE DETAILS OBJECT BECAUSE OF CascadeType.ALL
        System.out.println("Saving instructor...\n" + instructor);
        appDAO.save(instructor);
        System.out.println("Done!");
    }

    private void findInstructor(AppDAO appDAO) {
        int id = 1;
        System.out.println("Finding instructor by id: " + id);

        Instructor instructor = appDAO.findById(id);

        System.out.println("Instructor: " + instructor);
        System.out.println("Detail of the instructor: " + instructor.getInstructorDetail());
    }

    private void deleteInstructor(AppDAO appDAO) {
        int id = 1;
        System.out.println("Deleting instructor with id: " + id);
        appDAO.deleteById(id);
        System.out.println("Done!");
    }
}

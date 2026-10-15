package com.shivam.jobs;
import org.springframework.boot.CommandLineRunner;import org.springframework.context.annotation.Bean;import org.springframework.context.annotation.Configuration;
@Configuration public class SeedData {
 @Bean CommandLineRunner seed(JobRepository r){return args->{if(r.count()==0){
 r.save(new Job("Junior Java Developer","CodeNova","Bengaluru","Full-time","₹3–5 LPA","Build Java services and REST APIs.","Java,Spring Boot,SQL,REST","https://example.com"));
 r.save(new Job("Associate Software Engineer","BrightByte","Hyderabad","Full-time","₹4–6 LPA","Work on APIs, SQL and automated tests.","Java,SQL,Git,REST","https://example.com"));
 r.save(new Job("Java Full Stack Trainee","NextLayer Tech","Noida","Trainee","₹3–4 LPA","Contribute to frontend and backend features.","Java,Spring Boot,HTML,CSS,JavaScript,MySQL","https://example.com"));
 r.save(new Job("Backend Developer Intern","Orbit Systems","Remote","Internship","Stipend","Assist with API development.","Java,Spring Boot,MySQL,REST","https://example.com"));
 r.save(new Job("Frontend Developer","PixelWorks","Pune","Full-time","₹3–5 LPA","Create responsive interfaces.","HTML,CSS,JavaScript,React,Git","https://example.com"));
 }};}
}

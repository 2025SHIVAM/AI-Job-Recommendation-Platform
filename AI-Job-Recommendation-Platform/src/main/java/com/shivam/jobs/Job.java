package com.shivam.jobs;
import jakarta.persistence.*;
@Entity public class Job {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private String title,company,location,jobType,salary,skills,applyUrl;
 @Column(length=1800) private String description;
 public Job(){}
 public Job(String t,String c,String l,String type,String sal,String d,String s,String url){title=t;company=c;location=l;jobType=type;salary=sal;description=d;skills=s;applyUrl=url;}
 public Long getId(){return id;} public String getTitle(){return title;} public String getCompany(){return company;}
 public String getLocation(){return location;} public String getJobType(){return jobType;} public String getSalary(){return salary;}
 public String getDescription(){return description;} public String getSkills(){return skills;} public String getApplyUrl(){return applyUrl;}
 public void setTitle(String v){title=v;} public void setCompany(String v){company=v;} public void setLocation(String v){location=v;}
 public void setJobType(String v){jobType=v;} public void setSalary(String v){salary=v;} public void setDescription(String v){description=v;}
 public void setSkills(String v){skills=v;} public void setApplyUrl(String v){applyUrl=v;}
}

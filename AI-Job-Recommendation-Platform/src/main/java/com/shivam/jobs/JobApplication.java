package com.shivam.jobs;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity public class JobApplication {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 private Long jobId; private String candidateName,email; @Column(length=1500) private String note; private LocalDateTime appliedAt=LocalDateTime.now();
 public JobApplication(){} public JobApplication(Long j,String n,String e,String note){jobId=j;candidateName=n;email=e;this.note=note;appliedAt=LocalDateTime.now();}
 public Long getId(){return id;} public Long getJobId(){return jobId;} public String getCandidateName(){return candidateName;}
 public String getEmail(){return email;} public String getNote(){return note;} public LocalDateTime getAppliedAt(){return appliedAt;}
}

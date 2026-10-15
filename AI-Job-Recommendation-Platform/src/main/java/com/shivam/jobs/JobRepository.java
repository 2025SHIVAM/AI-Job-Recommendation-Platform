package com.shivam.jobs;
import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface JobRepository extends JpaRepository<Job,Long>{
 List<Job> findByTitleContainingIgnoreCaseOrCompanyContainingIgnoreCaseOrSkillsContainingIgnoreCaseOrLocationContainingIgnoreCase(String a,String b,String c,String d);
}

package com.shivam.jobs;
import org.springframework.web.bind.annotation.*; import org.springframework.http.HttpStatus; import org.springframework.web.server.ResponseStatusException;
import java.util.*; import java.util.stream.Collectors;
@RestController @RequestMapping("/api") @CrossOrigin
public class JobController {
 private final JobRepository jobs; private final JobApplicationRepository apps;
 public JobController(JobRepository j,JobApplicationRepository a){jobs=j;apps=a;}
 @GetMapping("/jobs") public List<Job> jobs(@RequestParam(required=false) String q){
  return q==null||q.isBlank()?jobs.findAll():jobs.findByTitleContainingIgnoreCaseOrCompanyContainingIgnoreCaseOrSkillsContainingIgnoreCaseOrLocationContainingIgnoreCase(q,q,q,q);
 }
 @PostMapping("/jobs") @ResponseStatus(HttpStatus.CREATED) public Job create(@RequestBody Job j){return jobs.save(j);}
 @PutMapping("/jobs/{id}") public Job update(@PathVariable Long id,@RequestBody Job in){
  Job j=jobs.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Job not found"));
  j.setTitle(in.getTitle());j.setCompany(in.getCompany());j.setLocation(in.getLocation());j.setJobType(in.getJobType());j.setSalary(in.getSalary());j.setDescription(in.getDescription());j.setSkills(in.getSkills());j.setApplyUrl(in.getApplyUrl());return jobs.save(j);
 }
 @DeleteMapping("/jobs/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){jobs.deleteById(id);}
 @GetMapping("/recommendations") public List<Map<String,Object>> recommendations(@RequestParam(defaultValue="Java,Spring Boot,SQL") String skills){
  Set<String>wanted=Arrays.stream(skills.toLowerCase().split("[,; ]+")).filter(x->!x.isBlank()).collect(Collectors.toSet());
  return jobs.findAll().stream().map(j->{Set<String>js=Arrays.stream(Optional.ofNullable(j.getSkills()).orElse("").toLowerCase().split("[,; ]+")).filter(x->!x.isBlank()).collect(Collectors.toSet());
   int score=js.isEmpty()?0:(int)Math.round(100.0*js.stream().filter(wanted::contains).count()/js.size());Map<String,Object>m=new LinkedHashMap<>();m.put("job",j);m.put("matchScore",score);return m;})
   .filter(m->(int)m.get("matchScore")>0).sorted((a,b)->Integer.compare((int)b.get("matchScore"),(int)a.get("matchScore"))).collect(Collectors.toList());
 }
 @PostMapping("/applications") @ResponseStatus(HttpStatus.CREATED) public JobApplication apply(@RequestBody Map<String,Object> b){
  Long id=Long.valueOf(String.valueOf(b.get("jobId")));String name=String.valueOf(b.get("candidateName")),email=String.valueOf(b.get("email"));
  if(name.isBlank()||email.isBlank())throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Name and email are required");
  jobs.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Job not found"));
  return apps.save(new JobApplication(id,name,email,String.valueOf(b.getOrDefault("note",""))));
 }
 @GetMapping("/applications") public List<JobApplication> applications(){return apps.findAll();}
}

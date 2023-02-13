package Data;
import java.time.LocalDateTime;
import java.util.UUID;


public class Task {
     private UUID id;
     private String number;
     private String title;
     private String details;
     private String author;
     private String status;
     private LocalDateTime deadline;
     private Priority priority;
     protected LocalDateTime created;
     protected LocalDateTime updated;


     public Task(String number,String title,String details,LocalDateTime deadline,Priority priority){
          this.id =UUID.randomUUID();
          this.number =number;
          this.title =title;
          this.details= details;
          this.deadline =deadline;
          this.priority =priority;
          this.created =LocalDateTime.now();
          this.updated =LocalDateTime.now();
     }

     public Task() {
     }

     public static Task buildTask(String title,  String details,LocalDateTime deadline, String status) {
          Task task = new Task();
  
          task.setId(UUID.randomUUID());
          task.setTitle(title);
          task.setDeadline(deadline);
          task.setStatus(status);
          task.setDetails(details);
          task.created =LocalDateTime.now();
          task.updated =LocalDateTime.now();
  
          return task;
      }
  

     public void setTitle(String title) {
          this.title =title;
     }

     public void setStatus(String status) {
          this.status =status;
     }
     public void setDetails(String details) {
          this.details =details;
     }

     private void setDeadline(LocalDateTime deadline) {
          this.deadline =deadline;
     }


     private void setId(UUID id) {
          this.id = id;
     }

     public UUID getId() {
          return id;
     }
     public String getTitle() {
          return title;
     }
     public String getStatus() {
          return status;
     }
     public String getNumber() {
          return number;
     }
     public String getDetails() {
          return details;
     }
     public String getAuthor() {
          return author;
     }     public LocalDateTime getDeadline() {
          return deadline;
     }     public Priority getPriority() {
          return priority;
     }

     public void setNumber(String number) {
          this.number =number;
     }

     public void setPriority(Priority priority) {
          this.priority =priority;
     }
}

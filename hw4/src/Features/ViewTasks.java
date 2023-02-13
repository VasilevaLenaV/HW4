package Features;

import Data.TodoList;

public class ViewTasks extends Actions {
     @Override
     public void showActionsInformation() {
         System.out.println("");
         System.out.println("Here are all the tasks: ");
     }
 
     @Override
     public String readUserInput() {
         throw new UnsupportedOperationException("The requested operation is not supported.");
     }
 
     
     @Override
     public void executeAction(String command) {
         TodoList.tasks.forEach((key, task) -> {
             System.out.printf("\nID: " + key + ", \nTitle: " + task.getTitle() + ", \nDeadline: "
                     + task.getDeadline(), "dd-MM-yyyy" + ", \nStatus: "
                     + task.getPriority().name() + ", \nDetails: " + task.getDetails()
                     + "\n");
         });
 
     }
 }

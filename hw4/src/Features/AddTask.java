package Features;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import Data.Priority;
import Data.Task;
import Data.TodoList;

public class AddTask extends Actions {

     @Override
     public void showActionsInformation() {
          System.out.println(
                    "\nЧтобы добавить новую задачу, пожалуйста, заполните поле и нажмите ENTER: Введите 0, чтобы прервать добавление");
     }

     @Override
     public String readUserInput() {
          String[] fieldTitles = { "№ задачи", "Заголовок", "Описание", "Крайний срок", "Приоритет", "Автор" };
          ArrayList<String> responseInput = new ArrayList<>();
          Scanner scanner = new Scanner(System.in);

          System.out.print("\nВвод информации: ");
          for (String field : fieldTitles) {
               System.out.printf("\nВведите %s: ", field);
               String res = scanner.nextLine();
               responseInput.add(res);
          }
          System.out.println(responseInput.toString());

          return responseInput.toString();
     }

     @Override
     public void executeAction(String command) {
          String[] fields = command.split(",");
          Task task = new Task(fields[0], fields[1], fields[2], LocalDateTime.now(), Data.Priority.LOW);

          TodoList.tasks.put(task.getId(), task);
          System.out.println("Задача успешно добавлена!");
     }
}

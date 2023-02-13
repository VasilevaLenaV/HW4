package Features;

import java.util.List;
import java.util.Scanner;

import Data.Priority;
import Data.Task;
import Data.TodoList;

public class EditTask extends Actions {
     @Override
     public void showActionsInformation() {
          System.out.println(
                    "\nРедактирование списка дел, Введите № задачи, после поиска поочередно заполните значения параметров, используйте ввод что бы перейти к следующему.");
          System.out.println(
                    "Если обновление параметра не требуется, укажите символ (-)\nДля возврата в меню введите 0\n");
     }

     @Override
     public String readUserInput() {
          Scanner in = new Scanner(System.in);

          while (true) {
               System.out.println("\nВведите № задачи для редакитирования:\n");
               String userInput = in.nextLine();

               if (!userInput.equals("0")) {
                    if (TodoList.findByNumber(userInput).isEmpty()) {
                         System.out.println("\nВведите № задачи для редакитирования:\n");
                    } else {
                         return userInput;
                    }
               } else {
                    return userInput;
               }
          }
     }

     @Override
     public void executeAction(String command) {
          List<Task> tasks = TodoList.findByNumber(command);

          Scanner scanner = new Scanner(System.in);

          tasks.forEach(t -> {
               String userInput = "";
               try {
                    System.out.printf("\nВведите № задачи: ", t.getNumber());
                    userInput = scanner.nextLine();

                    if (!userInput.isEmpty() || !userInput.equals("-") || userInput.equals(t.getNumber())) {
                         t.setNumber(userInput);
                    }
                    System.out.printf("\nВведите Заголовок: ", t.getTitle());
                    userInput = scanner.nextLine();

                    if (!userInput.isEmpty() || !userInput.equals("-") || userInput.equals(t.getTitle())) {
                         t.setTitle(userInput);
                    }
                    System.out.printf("\nВведите Описание: ", t.getDetails());
                    userInput = scanner.nextLine();

                    if (!userInput.isEmpty() || !userInput.equals("-") || userInput.equals(t.getDetails())) {
                         t.setDetails(userInput);
                    }
                    System.out.printf("\nВведите № задачи: ", t.getPriority());
                    userInput = scanner.nextLine();

                    if (!userInput.isEmpty() || !userInput.equals("-") || userInput.equals(t.getPriority().name())) {
                         t.setPriority(Priority.valueOf(userInput));
                    }
               } catch (Exception e) {
                    System.out.println(e);
               }

          });

          System.out.println("Обновление задач успешно завершено");
     }
}

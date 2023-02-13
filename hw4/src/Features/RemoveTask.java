package Features;

import java.util.Scanner;

import Data.TodoList;

public class RemoveTask extends Actions {

     @Override
     public void showActionsInformation() {
          System.out.println("");
          System.out.printf("\nДля удаление задачи из списка дел,введите  ее № и нажмите Ввод\n\nДля возрата к меню нажмите 0\n");
     }

     @Override
     public String readUserInput() {
          Scanner in = new Scanner(System.in);
          while (true) {
               System.out.println("");
               System.out.print("Введите № задачи: ");

               String userInput = in.nextLine();

               if (!userInput.isEmpty()) {
                    if (userInput == "0")
                         return userInput;

                    if (TodoList.findByNumber(userInput).isEmpty()) {
                         System.out.println("В списке дел нет задач с таким №");
                    } else {
                         return userInput;
                    }
               } else {
                    System.out.println("Введите № задачи или 0 для возрата к меню");
               }
          }
     }

     @Override
     public void executeAction(String command) {

          TodoList.findByNumber(command).clear();

          System.out.println("Задачи с номером №: " + command + ", были успешно удалены");
     }
}

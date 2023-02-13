package Features;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Scanner;

import Data.Task;
import Data.TodoList;

public class LoadFromFile extends Actions {
     @Override
     public void showActionsInformation() {
          System.out.println("\nУкажите файл для загрузки:\nДля воврата в меню введите 0");
     }

     @Override
     public String readUserInput() {
          Scanner scan = new Scanner(System.in);

          while (true) {
               System.out.println("");
               System.out.print("Путь:");

               String userInput = scan.nextLine();

               return userInput;
          }
     }


     @Override
     public void executeAction(String path) {
          try {
               Scanner scanner = new Scanner(new File(path));
               while (scanner.hasNextLine()) {
                    String file = scanner.nextLine();
                    //String[] parts = file.split(";");
                    // Task task = Task.buildTask(parts[0], parts[1],parts[2],parts[3], parts[4]);
               }
               scanner.close();
               System.out.println("Все задачи загружены!");
          } catch (FileNotFoundException e) {
               System.out.println("Путь или файл не существуют...");

          }

     }
}

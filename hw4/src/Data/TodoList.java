package Data;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import Data.TodoList;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Collectors;

import Features.Actions;
import Features.AddTask;
import Features.EditTask;
import Features.LoadFromFile;
import Features.MarkAsDone;
import Features.RemoveTask;
import Features.SaveToFile;
import Features.ViewTasks;
import Features.Sorting.DeadlineSorting;
import Features.Sorting.PrioritySorting;

public class TodoList {
     public static Map<UUID, Task> tasks = new LinkedHashMap<>();
     public static boolean applicationRunning = true;

     public void start() {
          showApplicationTitle();
          while (applicationRunning) {
               showAvailableActions();
               int actionNumber = readAction();
               executeAction(actionNumber);
          }
     }

     public static List<Task> findByNumber(String number) {
          return tasks.entrySet()
                    .stream()
                    .filter(ent -> ent.getValue().getNumber() == number)
                    .map(Map.Entry::getValue)
                    .collect(Collectors.toList());
     }

     public void executeAction(int actionNumber) {
          Runnable tasksEmpty = () -> System.out.println("В списке дел пусто");

          Actions action;
          switch (actionNumber) {
               case Actions.ADD_TASK:
                    action = new AddTask();
                    action.showActionsInformation();
                    String command = action.readUserInput();
                    if (!command.equals("0"))
                         action.executeAction(command);
                    break;

               case Actions.MARK_AS_DONE:
                    if (tasks.size() > 0) {
                         action = new MarkAsDone();
                         action.showActionsInformation();
                         String id = action.readUserInput();
                         if (!id.equals("0"))
                              action.executeAction(id);
                    } else {
                         tasksEmpty.run();
                    }
                    break;
               case Actions.REMOVE_TASK:
                    if (tasks.size() > 0) {
                         action = new RemoveTask();
                         action.showActionsInformation();
                         String id = action.readUserInput();
                         if (!id.equals("0"))
                              action.executeAction(id);
                    } else {
                         tasksEmpty.run();
                    }
                    break;

               case Actions.EDIT_TASK:
                    if (tasks.size() > 0) {
                         action = new EditTask();
                         action.showActionsInformation();
                         String editCommand = action.readUserInput();
                         if (!editCommand.equals(0))
                              action.executeAction(editCommand);
                    } else {
                         tasksEmpty.run();
                    }
                    break;

               case Actions.DISPLAY_ALL_TASKS:
                    if (tasks.size() > 0) {
                         action = new ViewTasks();
                         action.showActionsInformation();
                         action.executeAction(null);
                    } else {
                         tasksEmpty.run();
                    }
                    break;

               case Actions.SORT_TASKS_BY_DATE:
                    action = new DeadlineSorting();
                    action.executeAction(null);
                    break;

               case Actions.SORT_TASKS_PRIORITY:
                    action = new PrioritySorting();
                    action.executeAction(null);
                    break;

               case Actions.SAVE_TO_FILE:
                    if (tasks.size() > 0) {

                         action = new SaveToFile();
                         action.showActionsInformation();
                         String path = action.readUserInput();

                         if (!path.equals("0"))
                              action.executeAction(path);
                    } else {
                         tasksEmpty.run();
                    }
                    break;

               case Actions.LOAD_FROM_FILE:
                    action = new LoadFromFile();
                    action.showActionsInformation();
                    String path = action.readUserInput();

                    if (!path.equals("0"))
                         action.executeAction(path);
                    break;

               case Actions.EXIT:
                    applicationRunning = false;
                    break;

          }
     }

     public void showApplicationTitle() {
          System.out.println("Планировщик дел для работы с задачами разных приоритетов");
          System.out.println("--------------------------------------------------------");
     }

     public void showAvailableActions() {
          System.out.println(
                    "\n1. Добавить задачу\n2. Установить признак \"Выполнено\"\n3. Удалить задачу\n4. Редактировать задачу\n5. Показать список дел\n6. Отсортировать по дате\n7. Отсортировать по приоритету\n8. Сохранить в файл\n9. Загрузить из файла\n0. Выход\n");
     }

     public int readAction() {
          List<Integer> availableActions = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
          int action = 0;
          Scanner userInput = new Scanner(System.in);
          while (true) {
               System.out.print("Введите № действие: ");
               action = userInput.nextInt();
               if (availableActions.contains(action)) {
                    break;
               } else {
                    System.out.println("Для выбора доступны значения, только от 0 до 9: ");
               }
          }
          return action;
     }
}
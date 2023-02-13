package Features;

import java.util.Scanner;
import Data.TodoList;


public class MarkAsDone extends Actions {

    @Override
    public void showActionsInformation() {
        System.out.println("\nДля перевода задачи в \"Выполнено\", укажите № задачи в поиске\nВведите 0 для возрата в Меню\n");
    }

    
    @Override
    public String readUserInput() {
        while (true) {
            System.out.print("\nВведите № задачи:");
            Scanner in = new Scanner(System.in);
            try {
                String userInput = in.nextLine();
                if (userInput != "") {
                    if (TodoList.findByNumber(userInput).isEmpty()) {
                        return userInput;
                    } else {
                        System.out.println("Задачи с данным номером не найдены, попробуйте другой №: ");
                    }
                } else {
                    return userInput;
                }
            } catch (Exception err) {
                System.out.println("Введите № задачи и 0 для возврата в Меню");
            }
        }
    }

    
    @Override
    public void executeAction(String command) {
        TodoList.findByNumber(command).forEach(a ->{ a.setStatus("Done"); });
        System.out.println("Задачи с №: " + command + " переведены в статус ВЫПОЛНЕНО");
    }
}

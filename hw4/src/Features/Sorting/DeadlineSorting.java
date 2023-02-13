package Features.Sorting;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import Data.Task;
import Data.TodoList;
import Features.Actions;

public class DeadlineSorting extends Actions {

    @Override
    public void showActionsInformation() {
        throw new UnsupportedOperationException();
    }
    @Override
    public String readUserInput() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void executeAction(String command) {
        List<Map.Entry<UUID, Task>> entries = new ArrayList<>(TodoList.tasks.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<UUID, Task>>() {
            @Override
            public int compare(Map.Entry<UUID, Task> task1, Map.Entry<UUID, Task> task2) {
                LocalDateTime deadlineFirstTask = task1.getValue().getDeadline();
                LocalDateTime deadlineSecondTask = task2.getValue().getDeadline();
                int result = deadlineFirstTask.compareTo(deadlineSecondTask);
                return result;
            }

        });

        TodoList.tasks.clear();
        entries.forEach((entry) -> {
            TodoList.tasks.put(entry.getKey(), entry.getValue());
        });

        System.out.println("Задачи успешноо отсортированы по крайнему сроку!");

    }

    public static boolean isDateValid(String format, String value) {
        DateTimeFormatter formattings = DateTimeFormatter.ofPattern(format);
        try {
          LocalDateTime localDate = LocalDateTime.parse(value, formattings);
            String result = localDate.format(formattings);
            return result.equals(value);
        } catch (DateTimeParseException err) {
          System.out.println(err);
        }
        return false;
    }

    
    public static String convertDateToString(LocalDateTime date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String result = null;
        try {
            result = date.format(formatter);

        } catch (DateTimeParseException e) {
          System.out.println(e);
        }
        return result;
    }

    
    public static LocalDateTime parseDate(String format, String value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDateTime localDate = LocalDateTime.parse(value, formatter);
        return localDate;
    }
}

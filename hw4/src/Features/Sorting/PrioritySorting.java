package Features.Sorting;

import java.util.*;

import Data.Priority;
import Data.Task;
import Data.TodoList;
import Features.Actions;

public class PrioritySorting extends Actions {
    @Override
    public void showActionsInformation() {
        throw new UnsupportedOperationException("");
    }

    @Override
    public String readUserInput() {

        throw new UnsupportedOperationException("");
    }

    @Override
    public void executeAction(String command) {
        List<Map.Entry<UUID, Task>> entries = new ArrayList<>(TodoList.tasks.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<UUID, Task>>() {
            @Override
            public int compare(Map.Entry<UUID, Task> firstTask, Map.Entry<UUID, Task> secondTask) {

               Priority firstPriority = firstTask.getValue().getPriority();
               Priority secondPriority = secondTask.getValue().getPriority();

                int result = firstPriority.compareTo(secondPriority);
                return result;
            }
        });

        TodoList.tasks.clear();
        entries.forEach(entry -> {
            TodoList.tasks.put(entry.getKey(), entry.getValue());
        });

        System.out.println("Список дел успешно отсортирован по приоритету");
    }
}

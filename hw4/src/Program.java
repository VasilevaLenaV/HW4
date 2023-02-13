import java.util.ArrayList;
import java.util.Collection;

import Data.TodoList;

public class Program {
    static Collection<String> currentList = new ArrayList<String>();

    public static void main(String[] args) {
        final TodoList toDoList = new TodoList();
        toDoList.start();
    }
}
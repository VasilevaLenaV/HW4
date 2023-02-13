package Features;

public abstract class Actions {
     public static final int ADD_TASK = 1;
     public static final int MARK_AS_DONE = 2;
     public static final int REMOVE_TASK = 3;
     public static final int EDIT_TASK = 4;
     public static final int DISPLAY_ALL_TASKS = 5;
     public static final int SORT_TASKS_BY_DATE = 6;
     public static final int SORT_TASKS_PRIORITY = 7;
     public static final int SAVE_TO_FILE = 8;
     public static final int LOAD_FROM_FILE = 9;
     public static final int EXIT = 0;

     public abstract void showActionsInformation();

     public abstract String readUserInput();

     public abstract void executeAction(String command);
}


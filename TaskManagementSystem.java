class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

public class TaskManagementSystem {

    private Task head;

    // Add Task
    public void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);

        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }

        System.out.println("Task Added");
    }

    // Search Task
    public Task searchTask(int id) {
        Task temp = head;

        while (temp != null) {
            if (temp.taskId == id) {
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    // Traverse Tasks
    public void displayTasks() {
        Task temp = head;

        while (temp != null) {
            System.out.println(
                "ID: " + temp.taskId +
                ", Name: " + temp.taskName +
                ", Status: " + temp.status
            );
            temp = temp.next;
        }
    }

    // Delete Task
    public void deleteTask(int id) {

        if (head == null)
            return;

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task Deleted");
            return;
        }

        Task temp = head;

        while (temp.next != null && temp.next.taskId != id) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("Task Deleted");
        } else {
            System.out.println("Task Not Found");
        }
    }

    public static void main(String[] args) {

        TaskManagementSystem tms = new TaskManagementSystem();

        tms.addTask(101, "Design Module", "Pending");
        tms.addTask(102, "Develop Code", "In Progress");
        tms.addTask(103, "Testing", "Pending");

        System.out.println("\nTask List:");
        tms.displayTasks();

        System.out.println("\nSearch Result:");
        Task task = tms.searchTask(102);

        if (task != null) {
            System.out.println("Found: " + task.taskName);
        }

        tms.deleteTask(102);

        System.out.println("\nAfter Deletion:");
        tms.displayTasks();
    }
}
import java.util.*;

public class GradeTracker {

    static double[] cutoffs = {90, 80, 70, 60};
    static char[] letters = {'A', 'B', 'C', 'D'};

    static char letterFor(double grade) {
        for (int i = 0; i < cutoffs.length; i++) {
            if (grade >= cutoffs[i]) {
                return letters[i];
            }
        }
        return 'F';
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> roster = new ArrayList<>();

        boolean running = true;

        while (running) {

            System.out.println("\n===== GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Class Average");
            System.out.println("4. Exit");

            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Student Name: ");
                String name = sc.nextLine();

                System.out.print("Student Grade: ");
                double grade = sc.nextDouble();
                sc.nextLine();

                roster.add(new Student(name, grade));

                System.out.println("Student added successfully!");

            } else if (choice == 2) {

                if (roster.isEmpty()) {
                    System.out.println("No students yet.");
                } else {
                    System.out.println("\n--- Student List ---");
                    for (Student s : roster) {
                        System.out.println(s.name + " - " + s.grade + " (" + letterFor(s.grade) + ")");
                    }
                }

            } else if (choice == 3) {

                if (roster.isEmpty()) {
                    System.out.println("No students yet.");
                } else {

                    double total = 0;

                    for (Student s : roster) {
                        total += s.grade;
                    }

                    double average = total / roster.size();

                    System.out.printf("Class Average: %.2f (%c)%n",
                            average,
                            letterFor(average));
                }

            } else if (choice == 4) {

                running = false;
                System.out.println("Goodbye!");

            } else {

                System.out.println("Invalid choice!");

            }
        }

        sc.close();
    }
}

class Student {

    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}
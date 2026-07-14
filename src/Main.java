import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[] studentID = new int[10];
        String[] fullName = new String[10];
        int[] age = new int[10];
        String[] course = new String[10];
        double[] grade = new double[10];
        boolean[] enrolled = new boolean[10];

        int count = 0;
        int choice;

        while (true) {

            System.out.println("\n===== STUDENT INFORMATION SYSTEM =====");
            System.out.println("[1] Add Student");
            System.out.println("[2] View All Students");
            System.out.println("[3] Search Student by ID");
            System.out.println("[4] View Statistics");
            System.out.println("[5] Exit");

            System.out.print("Enter choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:

                    if (count == 10) {
                        System.out.println("Student list is full!");
                        break;
                    }

                    System.out.print("Enter Student ID: ");
                    studentID[count] = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Full Name: ");
                    fullName[count] = input.nextLine();

                    System.out.print("Enter Age: ");
                    age[count] = input.nextInt();

                    if (age[count] <= 0) {
                        System.out.println("Invalid age!");
                        break;
                    }

                    input.nextLine();

                    System.out.print("Enter Course: ");
                    course[count] = input.nextLine();

                    System.out.print("Enter Grade: ");
                    grade[count] = input.nextDouble();

                    if (grade[count] < 0 || grade[count] > 100) {
                        System.out.println("Invalid grade!");
                        break;
                    }

                    System.out.print("Is Enrolled (true/false): ");
                    enrolled[count] = input.nextBoolean();

                    count++;

                    System.out.println(">> Student added successfully!");
                    break;

                case 2:

                    if (count == 0) {
                        System.out.println("No student records.");
                        break;
                    }

                    System.out.println("\n----- STUDENT RECORDS -----");
                    System.out.printf("%-5s %-20s %-5s %-10s %-8s %-15s\n",
                            "ID", "NAME", "AGE", "COURSE", "GRADE", "STANDING");

                    for (int i = 0; i < count; i++) {

                        String standing;

                        if (grade[i] >= 90)
                            standing = "Dean's Lister";
                        else if (grade[i] >= 75)
                            standing = "Passed";
                        else
                            standing = "Failed";

                        System.out.printf("%-5d %-20s %-5d %-10s %-8.2f %-15s\n",
                                studentID[i],
                                fullName[i],
                                age[i],
                                course[i],
                                grade[i],
                                standing);
                    }

                    break;

                case 3:

                    if (count == 0) {
                        System.out.println("No student records.");
                        break;
                    }

                    System.out.print("Enter Student ID: ");
                    int searchID = input.nextInt();

                    boolean found = false;

                    for (int i = 0; i < count; i++) {

                        if (studentID[i] == searchID) {

                            System.out.println("\nStudent Found!");
                            System.out.println("ID: " + studentID[i]);
                            System.out.println("Name: " + fullName[i]);
                            System.out.println("Age: " + age[i]);
                            System.out.println("Course: " + course[i]);
                            System.out.println("Grade: " + grade[i]);
                            System.out.println("Enrolled: " + enrolled[i]);

                            found = true;
                            break;
                        }

                    }

                    if (!found)
                        System.out.println("Student not found.");

                    break;

                case 4:

                    if (count == 0) {
                        System.out.println("No student records.");
                        break;
                    }

                    double total = 0;
                    double highest = grade[0];
                    String topStudent = fullName[0];

                    for (int i = 0; i < count; i++) {

                        total += grade[i];

                        if (grade[i] > highest) {

                            highest = grade[i];
                            topStudent = fullName[i];

                        }

                    }

                    System.out.println("\n----- STATISTICS -----");
                    System.out.println("Total Students : " + count);
                    System.out.printf("Average Grade : %.2f\n", total / count);
                    System.out.printf("Top Student : %s (%.2f)\n", topStudent, highest);

                    break;

                case 5:

                    System.out.println("Thank you for using the Student Information System. Goodbye!");
                    input.close();
                    return;

                default:

                    System.out.println("Invalid choice.");

            }

        }

    }
}
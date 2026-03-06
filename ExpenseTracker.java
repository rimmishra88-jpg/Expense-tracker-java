import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    String title;
    double amount;

    Expense(String title, double amount) {
        this.title = title;
        this.amount = amount;
    }
}

public class ExpenseTracker {

    static ArrayList<Expense> expenses = new ArrayList<>();

    public static void addExpense(Scanner sc) {
        System.out.print("Enter expense title: ");
        String title = sc.next();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        expenses.add(new Expense(title, amount));
        System.out.println("Expense added successfully!\n");
    }

    public static void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses recorded.\n");
            return;
        }

        double total = 0;

        System.out.println("\nYour Expenses:");
        for (int i = 0; i < expenses.size(); i++) {
            Expense e = expenses.get(i);
            System.out.println((i + 1) + ". " + e.title + " - ₹" + e.amount);
            total += e.amount;
        }

        System.out.println("Total Expense: ₹" + total + "\n");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("===== Expense Tracker =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");

            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addExpense(sc);
                    break;

                case 2:
                    viewExpenses();
                    break;

                case 3:
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid choice\n");
            }
        }
    }
}
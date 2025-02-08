package com.gomi;

import java.util.Scanner;

public class ATMSimulator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        // Initialize balance & PIN
        double balance = 1000.0;
        int pin;
        
        System.out.print("Create Your ATMSimulator PIN: ");
        pin = in.nextInt();
        
        // PIN verification with 3 attempts
        int attempts = 3;
        while (attempts > 0) {
            System.out.print("Enter Your PIN: ");
            int enteredPin = in.nextInt();
            
            if (enteredPin == pin) {
                // If PIN is correct, show menu inside a loop
                while (true) {
                    System.out.println("\nSelect a number:");
                    System.out.println("1. Check balance");
                    System.out.println("2. Deposit money");
                    System.out.println("3. Withdraw money");
                    System.out.println("4. Exit");
                    System.out.print("Enter your choice: ");

                    int choice = in.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("Your balance is: " + balance + " rs");
                            break;

                        case 2:
                            System.out.print("Enter amount to deposit: ");
                            double deposit = in.nextDouble();
                            if (deposit > 0) {
                                balance += deposit;
                                System.out.println("Successfully deposited.");
                            } else {
                                System.out.println("Invalid deposit amount.");
                            }
                            System.out.println("Your balance is: " + balance + " rs");
                            break;

                        case 3:
                            System.out.print("Enter amount to withdraw: ");
                            double withdrawal = in.nextDouble();
                            if (withdrawal > 0 && withdrawal <= balance) {
                                balance -= withdrawal;
                                System.out.println("Successfully withdrawn.");
                            } else {
                                System.out.println("Insufficient balance or invalid amount.");
                            }
                            System.out.println("Your balance is: " + balance + " rs");
                            break;

                        case 4:
                            System.out.println("Thank you for using the ATMSimulator. Goodbye!");
                            in.close();
                            return; // Exit the program

                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            } else {
                attempts--;
                System.out.println("Incorrect PIN. Attempts left: " + attempts);
                if (attempts == 0) {
                    System.out.println("Too many failed attempts. Exiting...");
                    in.close();
                    return;
                }
            }
        }
    }
}

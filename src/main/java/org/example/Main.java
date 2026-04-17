package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Book[] bookInfo = {
                new Book(1, "9780140449136", "The Odyssey", true, "Bob"),
                new Book(2, "9780062457738", "Circe", false, ""),
                new Book(3, "9780525656627", "Normal People", true, "Alice"),
                new Book(4, "9781250301697", "The Silent Patient", false, ""),
                new Book(5, "9780525559474", "The Midnight Library", true, "John"),
                new Book(6, "9780525620785", "Mexican Gothic", false, ""),
                new Book(7, "9781984818479", "The Invisible Life of Addie LaRue", true, "Emma"),
                new Book(8, "9780553573428", "A Game of Thrones", false, ""),
                new Book(9, "9780345538376", "Ready Player One", true, "David"),
                new Book(10, "9780385545969", "Where the Crawdads Sing", false, ""),
                new Book(11, "9780062316097", "The Alchemist", true, "Sophia"),
                new Book(12, "9780141439518", "Pride and Prejudice", false, ""),
                new Book(13, "9780140449136", "Crime and Punishment", true, "Liam"),
                new Book(14, "9780307277671", "The Road", false, ""),
                new Book(15, "9780743273565", "The Great Gatsby", true, "Olivia"),
                new Book(16, "9780061120084", "To Kill a Mockingbird", false, ""),
                new Book(17, "9780451524935", "1984", true, "Noah"),
                new Book(18, "9780316769488", "The Catcher in the Rye", false, ""),
                new Book(19, "9780618640157", "The Hobbit", true, "Mia"),
                new Book(20, "9780547928227", "The Lord of the Rings", false, "")
        };


        while (true) {

            System.out.println("\n=== BOOK STORE HOME SCREEN ===");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int userInput = scan.nextInt();
            if (userInput == 1) {
                for (Book use : bookInfo) {
                    if (!use.isCheckedOut()) {
                        System.out.println("ID: " + use.getId());
                        System.out.println("ISBN: " + use.getIsbn());
                        System.out.println("Title: " + use.getTitle());
                        System.out.println("--------");
                    }
                }
                System.out.println("Enter Book ID (or 0 to EXIT)");
                int id = scan.nextInt();
                scan.nextLine();

                if (id != 0) {
                    boolean answer = false;
                    for (Book use : bookInfo) {
                        if (use.getId() == id) {
                            answer = true;
                            if (!use.isCheckedOut()) {
                                System.out.println("Enter your name");
                                String name = scan.nextLine();

                                use.checkOut(name);
                                System.out.println("Book checked out successfully!");

                            } else {
                                System.out.println("Book already checked out.");
                            }
                        }

                    }
                    if (!answer) {
                        System.out.println("Invalid Book ID");

                    }

                }
            } else if (userInput == 2) {
                for (Book use : bookInfo) {
                    if (use.isCheckedOut()) {
                        System.out.println("ID: " + use.getId());
                        System.out.println("ISBN: " + use.getIsbn());
                        System.out.println("Title: " + use.getTitle());
                        System.out.println("Checked out to: " + use.getCheckedOutTo());

                    }
                }
                System.out.print("Enter Book ID to check in (or 0 to go back): ");
                int id = scan.nextInt();

                if (id != 0) {
                    boolean found = false;

                    for (Book use : bookInfo) {
                        if (use.getId() == id) {
                            found = true;

                            if (use.isCheckedOut()) {
                                use.checkIn();
                                System.out.println("Book checked in successfully!");
                            } else {
                                System.out.println("Book is already available.");
                            }
                        }
                    }

                    if (!found) {
                        System.out.println("Invalid Book ID");
                    }
                }
            } else if (userInput == 3) {
                System.out.println("Exit");
                break;
            } else {
                System.out.println("Invalid input");
            }


        }
    }
}
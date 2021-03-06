package com.csvaddressbook;

import java.util.Objects;
import java.util.Scanner;

public class AddressBook {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many books do you want to create: ");
        int numOfBook;
        int numOfEntry;

        MainImplement[] book = new MainImplement[0];
        while(true){
            numOfBook = sc.nextInt();
            if (numOfBook>0){
                book = new MainImplement[numOfBook];
                break;
            }
            else System.out.print("You must create at least 1 book.");
        }

        for (int i=0;i<book.length;i++){
            book[i] = new MainImplement();
            while(true){
                System.out.print("How many entries in book "+(i+1)+": ");
                numOfEntry = sc.nextInt();
                if (numOfEntry>0) {
                    book[i].initEntries(numOfEntry);
                    break;
                }
                else System.out.println("You must create at least 1 Entry.");
            }
        }

        int selectBook = 0;
        int choice;
        Boolean done = true;
        while (done){
            System.out.println("Book "+(selectBook+1)+" is currently selected.");
            for (int i = 0;i<book[selectBook].getLength();i++){
                System.out.println("===========Entry "+(i+1)+" ===========");
                System.out.println(book[selectBook].list[i]);
                System.out.println("================================");
            }

            System.out.println("1. Add an entry");
            System.out.println("2. Edit an entry");
            System.out.println("3. Remove an entry");
            System.out.println("4. Select another book");
            System.out.println("5. Exit the menu");
            choice = sc.nextInt();
            String firstName, lastName, address, city, state, zip, phone, email;
            switch(choice){
                case 1:
                    System.out.print("First name: ");
                    firstName = sc.next();
                    System.out.print("Last name: ");
                    lastName = sc.next();
                    System.out.print("Address: ");
                    address = sc.next();
                    System.out.print("City: ");
                    city = sc.next();
                    System.out.print("State: ");
                    state = sc.next();
                    System.out.print("ZIP: ");
                    zip = sc.next();
                    System.out.print("Phone: ");
                    phone = sc.next();
                    System.out.print("Email: ");
                    email = sc.next();
                    book[selectBook].addEntry(firstName, lastName, address, city, state, zip, phone, email);
                    break;
                case 2:
                    System.out.print("Please enter the first name of Person u want to edit: ");
                    String name = sc.next();
                    System.out.print("First name: ");
                    firstName = sc.next();
                    System.out.print("Last name: ");
                    lastName = sc.next();
                    System.out.print("Address: ");
                    address = sc.next();
                    System.out.print("City: ");
                    city = sc.next();
                    System.out.print("State: ");
                    state = sc.next();
                    System.out.print("ZIP: ");
                    zip = sc.next();
                    System.out.print("Phone: ");
                    phone = sc.next();
                    System.out.print("Email: ");
                    email = sc.next();
                    book[selectBook].editEntry(firstName, lastName, address, city,
                            state, zip, phone, email, name);
                    break;
                case 3:
                    System.out.println("Please enter the first name of Person u want to delete: ");
                    name = sc.next();
                    book[selectBook].deleteEntry(name);
                    break;
                case 4:
                    System.out.print("Select which book: ");
                    selectBook = sc.nextInt();
                    break;
                case 5:
                    done = false;
                    break;
                default:
                    System.out.print("Invalid Choice");
            }
        }
    }
}

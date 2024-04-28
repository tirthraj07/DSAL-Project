import java.util.List;
import java.util.Scanner;

import utils.*;
//java -classpath ".;sqlite-jdbc-3.45.3.0.jar;slf4j-api-1.7.36.jar" Main


public class Menu {
    private HashTable ht;
    private int hashTableSize;
    List<String> authors;
    private int choice;
    Scanner sc;
    public Menu(){
        sc = new Scanner(System.in);
        clearScreen();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Establishing Database Connection. Please Wait...");
        initiateDatabaseConnection();
        clearScreen();
        askChoice();
        initOptions();
    }


    private void askChoice(){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("----- Welcome to Library Management System ------");
        System.out.println("Created by Tirthraj Mahajan, Advait Joshi and Rinit Jain");
        System.out.println("What do you want to do?");
        System.out.println("1. View the Entire Library");
        System.out.println("2. View List of Authors");
        System.out.println("3. List Books by Author");
        System.out.println("4. Search Book");
        System.out.println("5. Issue Book");
        System.out.println("6. Return Book");
        System.out.println("7. Exit");
        System.out.print(">> ");
        choice = sc.nextInt();
        sc.nextLine();
    }


    private void initOptions(){
        String author;
        String bookName;
        switch (choice) {
            case 1:
                System.out.println("Viewing Entire Library");
                ht.printTable();
                break;
            case 2:
                for(int i=0; i<authors.size(); i++){
                    System.out.println((i+1)+". "+authors.get(i));
                }
                break;
            case 3:
                System.out.print("Enter Author >> ");
                author = sc.nextLine();
                ht.viewBooksOfAuthors(author);
                break;
            case 4:
                System.out.print("Enter BookName >> ");
                bookName = sc.nextLine();
                System.out.print("Enter Author >> ");
                author = sc.nextLine();
                ht.searchBook(author, bookName);
                break;
            case 5:
                System.out.println("--- Checkout Counter ---");
                System.out.print("Enter BookName >> ");
                bookName = sc.nextLine();
                System.out.print("Enter Author >> ");
                author = sc.nextLine();
                ht.issueBook(author, bookName);
                break;
            case 6:
                System.out.println("--- Return Counter ---");
                System.out.print("Enter BookName >> ");
                bookName = sc.nextLine();
                System.out.print("Enter Author >> ");
                author = sc.nextLine();
                ht.returnBook(author, bookName);
                break;
            case 7:
                sc.close();
                System.out.println("Thank you for using! Have a nice day ;)");
                return;
            default:
                System.out.println("Enter a valid choice");
                break;
        }
        retry();
    }

    private void retry(){
        askChoice();
        initOptions();
    }



    private void clearScreen(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    private void initiateDatabaseConnection(){
        System.out.println("Starting.. This may take a while, please wait");
        authors = SQL_DB.RetrieveAuthors();
        System.out.println("Initiating Hash Table..");
        hashTableSize = authors.size();
        ht = new HashTable(hashTableSize);
        System.out.println("Copying Authors From Database into Hash Table..");
        for(String author: authors){
            if(author!=null) ht.insertAuthor(author);
        }
        System.out.println("Hash Table Initiating Complete!");
        System.out.println("Initiating AVL Trees");
        for(String author: authors){
            if(author!=null){
                int author_id = SQL_DB.findAuthorId(author);
                if(author_id!=-1){
                    List<String> bookNames = SQL_DB.RetrieveBooks(author_id);
                    for(String bookName: bookNames){
                        int total = SQL_DB.FindTotal(bookName);
                        if(bookName!=null&&total!=0) ht.insertBook(bookName, author, total);
                    }
                }
            }
        }
        System.out.println("Initiation Complete! Starting..");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

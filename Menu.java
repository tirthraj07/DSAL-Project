import java.util.List;
import utils.*;
//java -classpath ".;sqlite-jdbc-3.45.3.0.jar;slf4j-api-1.7.36.jar" Main


public class Menu {
    private HashTable ht;
    private int hashTableSize;
    public Menu(){
        clearScreen();
        System.out.println("Establishing Database Connection.. Please Wait");
        initiateDatabaseConnection();
        clearScreen();
        ht.printTable();
    }

    private void clearScreen(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    private void initiateDatabaseConnection(){
        System.out.println("Starting.. This may take a while, please wait");
        List<String> authors = SQL_DB.RetrieveAuthors();
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

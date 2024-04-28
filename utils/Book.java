package utils;

public class Book {
    public String title;
    public String author;
    public int total;

    public Book(String title, String author, int total){
        this.title = title;
        this.author = author;
        this.total = total;

    }

    public boolean isAvailable(){
        if(total <= 0) return false;
        return true;
    }

    public boolean issueBook(){
        if(!isAvailable()){
            System.out.println("No copies of "+this.title+" are available"); 
            return false;
        }

        System.out.println("Copy issued successfully");
        
        total--;
        return true;

    }

    public void returnBook(){
        total++;
        System.out.println("Book with Returned Successfully");
    }


}   

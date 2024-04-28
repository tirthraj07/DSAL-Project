package utils;

public class HashTable {
    public Vector table;
    int tableSize;

    public HashTable(int size){
        tableSize = size;
        table = new Vector(size);
    }

    private int hashFunction(String author){
        return author.length()%tableSize;
    }

    // public void insertBook(){

    // }

    public void printTable(){
        for(int i=0; i<tableSize; i++){
            System.out.println(table.at(i));
        }
    }

    private int searchAuthor(String author){
        int index = hashFunction(author);
        int i = index;
        do{
            if(table.at(i).key.equalsIgnoreCase(author))
            return i;
            i = (i+1)%tableSize;
        }
        while(i!=index);
        return -1;
    }

    public void viewBooksOfAuthors(String author){
        int index = searchAuthor(author);
        if(index==-1){
            System.out.println("No books of this author available!");
            return;
        }

        table.at(index).value.inorderTraversal();
    }

    public Node searchBook(String author, String title){
        int index = searchAuthor(author);
        if(index==-1){
            System.out.println("No books of this author available!");
            return null;
        }
        Node node = table.at(index).value.search(title);
        if(node!=null){
            System.out.println(node.data);
            return node;
        }
        System.out.println("Book not found!!");
        return null;
    }

    public void insertBook(String title, String author, int total){
        int index = searchAuthor(author);
        if(index==-1){
            System.out.println("Cannot find author");
            return;
        }

        table.at(index).value.insert(title, author, total);

    }

    public void issueBook(String author, String title){
        Node node = searchBook(author, title);
        if(node==null){
            return;
        }
        node.data.issueBook();
    }

    public void returnBook(String author, String title){
        Node node = searchBook(author, title);
        if(node==null){
            return;
        }
        node.data.returnBook();
    }

    public void insertAuthor(String author){
        HashNode node = new HashNode(author);
        int index = hashFunction(author);
        if(table.at(index) == null){
            table.insertInTable(index, node);
            
        }
        else{
            int i = index;
            do{
                if(table.at(i)==null){
                    table.insertInTable(i, node);
                    return;
                }
                i = (i+1)%tableSize;
            }
            while(i!=index);
            System.out.println("Table full!");
        }
    }
}

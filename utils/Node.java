package utils;

public class Node {
    Book data;
    Node left;
    Node right;
    int weight;

    public Node(String title, String author, int total){
        this.data = new Book(title, author,total);
        weight = 1;
        left = right = null;
    }    

    public boolean isGreaterThan(Node obj){
        return this.data.title.compareToIgnoreCase(obj.data.title)>0?true:false;
    } 

    public boolean isLessThan(Node obj){
        return this.data.title.compareToIgnoreCase(obj.data.title)<0?true:false;
    }

}

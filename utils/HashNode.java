package utils;

public class HashNode extends Object {
    public String key;      // Author Name
    public AVLTree value;   // Books
    public HashNode(String key){
        this.key = key;
        this.value = new AVLTree();
    }
    public void insertVal(String title, String author, int total){
        value.insert(title, author, total);
    }

    @Override
    public String toString(){
        System.out.println(this.key + " :  ");
        return value.toString();
    }
}

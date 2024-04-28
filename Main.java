class Vector{
    private String arr[];
    private int count;

    Vector(int length){
        count = 0;
        arr = new String[length];
    }

    public void insert(String element){
        if(count<arr.length){
            arr[count] = element;
            count++;
        }
        else{
            String newArr[] = new String[2*count];
            for(int i=0; i<count; i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
            arr[count] = element;
            count++;
        }
    }

    public void print(){
        for(int i=0; i<count; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public int getLength(){
        return arr.length;
    }

    


}

class TreeNode{
    public String bookName;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(){
        bookName = null;
        left = null;
        right = null;    
    }

    public TreeNode(String bookName){
        this.bookName = bookName;
        left = null;
        right = null;
    }

    public TreeNode(String bookName, TreeNode left, TreeNode right){
        this.bookName = bookName;
        this.left = left;
        this.right = right;
    }

}

class BST{
    private TreeNode root;
    public BST(){
        root = null;
    }
    public void insert(String bookName){
        if(root==null){
            root = new TreeNode(bookName);
            return;
        }

        TreeNode curr = root;
        TreeNode prev = null;
        while(curr!=null){
            prev = curr;
            if(curr.bookName.compareToIgnoreCase(bookName) > 0){
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        }

        if(prev.bookName.compareToIgnoreCase(bookName) > 0){
            prev.left = new TreeNode(bookName);
        }
        else{
            prev.right = new TreeNode(bookName);
        }
    }

    public TreeNode find(String bookName){
        if(root==null){
            return null;
        }

        TreeNode curr = root;

        while(curr!=null&&curr.bookName.equalsIgnoreCase(bookName)){
            if(curr.bookName.compareToIgnoreCase(bookName)>0){
                curr = curr.left;
            }
            else{
                curr = curr.right;
            }
        }

        return curr;
    }


    public void display(){
        inorder(root);
    }

    public void inorder(TreeNode node){
        if(node==null){
            return;
        }
        inorder(node.left);
        System.out.println(node.bookName);
        inorder(node.right);
    }
}


class HashTable{
    private Vector table;
    private int count;
    private int tableSize;

    private int hashFunction(String key){
        return key.length()%tableSize;
    }

    public HashTable(){
        tableSize = 10;
        table = new Vector(10);
        count = 0;
    }
}

class Main{
    public static void main(String[] args) {
        Vector vec = new Vector(4);
        vec.insert("Advait");
        vec.insert("Rinit");
        vec.insert("Tirthraj");
        vec.insert("Suvrat");
        vec.insert("Amey");
        vec.insert("Aniket");
        vec.insert("Sushrut");
        vec.print();


        BST tree = new BST();
        tree.insert("A Game of Thrones");
        tree.insert("The Winds of Winter");
        tree.insert("Fire and Blood");
        tree.insert("A Dance with Dragons");
        tree.insert("A Dream of Spring");
        tree.insert("The Hedge Knight");
        tree.insert("A Storm of Swords");
        tree.insert("A Clash of Kings");
        tree.insert("The Ice Dragon");
        tree.insert("The Rise of the Dragon");
        tree.insert("Fevre Dream");
        tree.insert("A Feast for Crows");

        tree.display();
    }
}
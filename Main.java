import utils.*;

class Main{
    public static void main(String[] args) {

        HashTable ht = new HashTable(5);
        String author = "AMEY KULKARNI";
        ht.insertAuthor(author);
        ht.insertBook("How to masterbate", author, 5);
        ht.insertBook("How to shit", author, 5);

        ht.printTable();
        // System.out.println(ht.searchAuthor("AMEY KULKARNI"));


        // AVLTree tree = new AVLTree();
        // String author = "AMEY KULKARNI";

        // tree.insert("ABC", author, 5);
        // tree.insert("DEF", author, 5);
        // tree.insert("GHI", author, 5);
        // tree.insert("HIJ", author, 5);
        // tree.insert("JLMN", author, 5);
        // tree.insert("OPQR", author, 5);
        // System.out.println(tree);
        // tree.preorderTraversal();

        // BST tree = new BST();
        // tree.insert("A Game of Thrones");
        // tree.insert("The Winds of Winter");
        // tree.insert("Fire and Blood");
        // tree.insert("A Dance with Dragons");
        // tree.insert("A Dream of Spring");
        // tree.insert("The Hedge Knight");
        // tree.insert("A Storm of Swords");
        // tree.insert("A Clash of Kings");
        // tree.insert("The Ice Dragon");
        // tree.insert("The Rise of the Dragon");
        // tree.insert("Fevre Dream");
        // tree.insert("A Feast for Crows");

        // tree.display();
    }
}
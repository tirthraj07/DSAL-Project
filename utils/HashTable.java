package utils;

public class HashTable {
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

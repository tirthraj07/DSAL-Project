package utils;

public class Vector{
    private HashNode arr[];
    private int count;
    private int length;

    Vector(int length){
        this.length = length;
        count = 0;
        arr = new HashNode[length];
    }

    public int getSize(){
        return length;
    }

    public HashNode at(int index){
        return arr[index];
    }

    public void insertInTable(int index, HashNode node){
        arr[index] = node;
    }

    public void push_back(String key){
        if(count<arr.length){
            arr[count] = new HashNode(key);
            count++;
        }
        else{
            HashNode newArr[] = new HashNode[2*count];
            for(int i=0; i<count; i++){
                newArr[i] = arr[i];
            }
            arr = newArr;
            arr[count] = new HashNode(key);
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

package utils;

public class Vector{
    private HashNode arr[];
    private int count;

    Vector(int length){
        count = 0;
        arr = new HashNode[length];
    }

    public void insert(String key){
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

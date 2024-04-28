package utils;

public class Vector{
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

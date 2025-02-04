import java.util.*;
public class Heap {
    int heapSize;
    int heap[];

    int capacity;
    Heap(int arr[] ){
        heap=arr;
        this.heapSize=arr.length;
        this.capacity=arr.length;
    }

    public void heapify(int index){
        int largest=index;
        int leftchildidx=2*index+1;
        int rightchildidx=2*index+2;
        if(leftchildidx<heapSize && heap[leftchildidx]>heap[largest]){
            largest=leftchildidx;
        }if(rightchildidx<heapSize && heap[rightchildidx]>heap[largest]){
            largest=rightchildidx;
        }
        if(largest!=index){
            swap(index,largest);
            heapify(largest);
        }
    }

    private void swap(int i, int j) {
        int temp=heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }

    public void buildTree(){
       //this is the method to construct the tree from the given array using the heapify function
        for(int index=heapSize/2-1;index>=0;index--){
            heapify(index);
        }
    }
    public void printheap(){
        for(int i=0;i<heapSize;i++){
            System.out.print(heap[i]+" ");
        }
        System.out.println();
    }
    int ExtractMax(){
        if (heapSize==0){
            System.out.println("Heap is Empty");
        }
        int max=heap[0];
        heap[0]=heap[heapSize-1];
        heapSize--;
        heapify(0);
        return max;
    }
    //code to increase the key
    void increaseKey(int key){
        key=heap[heapSize-1];
        heapify(0);
    }

    public static void main(String[] args) {
          int arr[]=new int[]{10,5,20,6,11};
          int arr2[]=new int[]{18,10,5,20,30};
     Heap heap=new Heap(arr2);
     heap.buildTree();
     heap.printheap();
      //  System.out.println(heap.ExtractMax());
        //heap.printheap();

    }

}

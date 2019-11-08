import java.util.Arrays;

public class BinaryHeap {
    public int[] data;
    public int size;
    public BinaryHeap(){
        data = new int[10];
        size = 0;
    }
    //add item to heap, grow heap if needed
    public void add(int value){
        if(size == data.length){
            data = Arrays.copyOf(data, data.length*2);
        }
        data[size++] = value;
        int current = size-1;
        int parent = (current-1)/2;
        while(current != 0 && data[current] < data[parent]){
            swap(data, current, parent);
            current = parent;
            parent = (parent-1)/2;
        }
    }
    void swap(int [] a, int i, int j){
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //remove item from heap, call shiftdown function
    public int remove() {
        try{
            if (size == 0){
                throw new Exception();
            }
        }
        catch (Exception e){
            System.out.println("error");
        }
        swap(data, 0, size-1);
        size--;
        if(size > 0){
            siftDown(0);
        }
        return data[size];
    }

    private void siftDown(int value){
        int parent = value;
        int left = 2*parent+1;
        int right = 2*parent+2;
        if (left >= size || right >= size) {
            return;
        }

        //find smallest child
        if (data[left] > data[right] && data[right] < data[parent]) {
            swap(data, parent, right);
            siftDown(right);
        }
        else if(data[right] > data[left] && data[left] < data[parent]) {
            swap(data, parent, left);
            siftDown(left);
        }
    }
}
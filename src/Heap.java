import java.util.*;

class Heap {
    public int[] HeapArray; // хранит неотрицательные числа-ключи
    int end;

    public Heap() {
        HeapArray = null;
        end = -1;
    }

    private int heapSize(int depth) {
        int treeSize = 0;

        while (depth >= 0) {
            treeSize += (int) Math.pow(2, depth--);
        }

        return treeSize;
    }

    public void MakeHeap(int[] a, int depth) {
        int size = heapSize(depth);

        HeapArray = new int[size];
        for (int i = 0; i < a.length; i++) {
            Add(a[i]);
        }

        for (int i = a.length; i < size; i++) {
            HeapArray[i] = -1;
        }

        end = a.length - 1;
    }

    public int GetMax() {
        if (HeapArray == null || HeapArray[0] == -1) {
            return -1;
        }

        int max = HeapArray[0];
        HeapArray[0] = HeapArray[end];
        HeapArray[end--] = -1;
        resort(0);

        return max;
    }

    private void resort(int i) {
        int leftChild = 2 * i + 1;
        int rightChild = leftChild + 1;

        if (leftChild >= HeapArray.length) {
            return;
        }

        int max = HeapArray[leftChild] > HeapArray[rightChild] ? leftChild : rightChild;

        if (HeapArray[max] < HeapArray[i]) {
            return;
        }

        int temp = HeapArray[i];
        HeapArray[i] = HeapArray[max];
        HeapArray[max] = temp;

        resort(max);
    }

    public boolean Add(int key) {
        if (HeapArray == null || end == HeapArray.length - 1) {
            return false;
        }

        if (end == -1) {
            HeapArray[0] = key;
            end++;
            return true;
        }

        HeapArray[++end] = key;
        AddRec(end);

        return true;
    }

    private void AddRec(int i) {
        if (i == 0 || HeapArray[i] < HeapArray[(i - 1) / 2]) {
            return;
        }

        int parent = (i - 1) / 2;
        int temp = HeapArray[parent];

        HeapArray[parent] = HeapArray[i];
        HeapArray[i] = temp;

        AddRec(parent);
    }
}
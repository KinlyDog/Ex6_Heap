import java.util.*;

class Heap {
    public int[] HeapArray; // хранит неотрицательные числа-ключи

    public Heap() {
        HeapArray = null;
    }

    public void MakeHeap(int[] a, int depth) {
        // создаём массив кучи HeapArray из заданного
        // размер массива выбираем на основе глубины depth
        // ...
    }

    public int GetMax() {
        // вернуть значение корня и перестроить кучу
        return -1; // если куча пуста
    }

    public boolean Add(int key) {
        // добавляем новый элемент key в кучу и перестраиваем её
        return false; // если куча вся заполнена
    }

}
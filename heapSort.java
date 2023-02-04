import java.util.Random;

public class heapSort
{
    /**
     * Функция сортировки
     * @param arr передаваемый массив
     */
    public void sort(int arr[]) // Суммарная сложность O(nlogn)
    {
        int n = arr.length;

        // Два невложенных цикла, сложность O(2n), эквивалент O(n)

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i=n-1; i>=0; i--)
        {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0); //Вот тут сложность O(Logn)
        }
    }

    /**
     * Функция преобразования поддерева в двоичную кучу. Временная сложность — O(Logn)
     * @param arr преобразовываемый массив
     * @param n раззмер кучи
     * @param i корневой узел
     */
    void heapify(int arr[], int n, int i)
    {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        // Если левый дочерний элемент больше корня
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (right < n && arr[right] > arr[largest])
            largest = right;
        // Если самый большой элемент не корень
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно преобразуем дерево в двоичную кучу
            heapify(arr, n, largest);
        }
    }

    /**
     * Функция вывода массива
     * @param arr выводимый массив
     */
    static void printArray(int arr[])
    {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    /**
     * Функция генерации массива
     * @param size размер генерируемого массива
     * @return
     */
    static int[] generateArray(int size)
    {
        int[] arr = new int[size];
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rnd.nextInt(0,20);
        }
        return arr;
    }

    public static void main(String args[])
    {
        int arr1[] = generateArray(100);
        int arr2[] = generateArray(1000);
        int arr3[] = generateArray(10000000);

        heapSort ob = new heapSort();
        ob.sort(arr1);
        ob.sort(arr2);
        ob.sort(arr3);

        System.out.println("Sorted array is");

        //Вывод закомментировал, чтобы не мусорить в консоли.

        //printArray(arr1);
        //printArray(arr2);
        //printArray(arr3);
    }
}

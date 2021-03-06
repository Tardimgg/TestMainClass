package CodeforcesProject;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main extends InputAndOutput {
    public static void main(String[] args) throws Exception {
        int[] quantity = ReadArrayInt(" ");
        Long[] base = ReadArrayLong(" ");
        FastSort.SortWithoutReturn(base, (long) quantity[1], 3);
    }
}

class method {

    protected static int gcd(int a, int b) { // NOD
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    protected static long gcd(long a, long b) {
        if (b == 0) {
            return a;

        }
        return gcd(b, a % b);
    }

    protected static float gcd(float a, float b) {
        if (b == 0) {
            return a;

        }
        return gcd(b, a % b);
    }

    protected static double gcd(double a, double b) {
        if (b == 0) {
            return a;

        }
        return gcd(b, a % b);
    }

    protected static double lcm(double a, double b) { // NOK
        return a / gcd(a, b) * b;
    }

    protected static float lcm(float a, float b) { // NOK
        return a / gcd(a, b) * b;
    }

    protected static int lcm(int a, int b) { // NOK
        return a / gcd(a, b) * b;
    }

    protected static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    protected static void exit() throws Exception {
        if (InputAndOutput.write == null) {
            return;
        }
        InputAndOutput.write.flush();
        InputAndOutput.read.close();
        InputAndOutput.write.close();
    }
}

class Division<T> extends Pair {

    private Division(T dividend, T divider) {
        super(dividend, divider);
        reduce();
    }

    protected static <K> Division<K> createDivision(K dividend, K divider) {
        return new Division<>(dividend, divider);
    }

    protected void reduce() {
        if (getFirstElement() instanceof Integer) {
            int Dividend = (int) getFirstElement();
            int Divider = (int) getSecondElement();
            int gcd = method.gcd(Dividend, Divider);
            setFirst(Dividend / gcd);
            setSecond(Divider / gcd);
        } else if (getFirstElement() instanceof Long) {
            long Dividend = (long) getFirstElement();
            long Divider = (long) getSecondElement();
            long gcd = method.gcd(Dividend, Divider);
            setFirst(Dividend / gcd);
            setSecond(Divider / gcd);
        } else if (getFirstElement() instanceof Float) {
            float Dividend = (float) getFirstElement();
            float Divider = (float) getSecondElement();
            float gcd = method.gcd(Dividend, Divider);
            setFirst(Dividend / gcd);
            setSecond(Divider / gcd);
        } else if (getFirstElement() instanceof Double) {
            double Dividend = (double) getFirstElement();
            double Divider = (double) getSecondElement();
            double gcd = method.gcd(Dividend, Divider);
            setFirst(Dividend / gcd);
            setSecond(Divider / gcd);
        }
        throw new UnsupportedOperationException();
    }

    protected void addWithoutReturn(Division number) throws UnsupportedOperationException {
        if (getFirstElement() instanceof Integer && getSecondElement() instanceof Integer && number.getFirstElement() instanceof Integer && number.getSecondElement() instanceof Integer) {
            int Dividend = (int) getFirstElement();
            int Divider = (int) getSecondElement();
            int Dividend1 = (int) number.getFirstElement();
            int Divider1 = (int) number.getSecondElement();
            int lcm = method.lcm(Divider, Divider1);
            setFirst((lcm / Divider) * Dividend + (lcm / Divider1) * Dividend1);
            setSecond(lcm);
            reduce();
        } else if (getFirstElement() instanceof Long && getSecondElement() instanceof Long && number.getFirstElement() instanceof Long && number.getSecondElement() instanceof Long) {
            long Dividend = (long) getFirstElement();
            long Divider = (long) getSecondElement();
            long Dividend1 = (long) number.getFirstElement();
            long Divider1 = (long) number.getSecondElement();
            long lcm = method.lcm(Divider, Divider1);
            setFirst((lcm / Divider) * Dividend + (lcm / Divider1) * Dividend1);
            setSecond(lcm);
            reduce();
        } else if (getFirstElement() instanceof Float && getSecondElement() instanceof Float && number.getFirstElement() instanceof Float && number.getSecondElement() instanceof Float) {
            float Dividend = (float) getFirstElement();
            float Divider = (float) getSecondElement();
            float Dividend1 = (float) number.getFirstElement();
            float Divider1 = (float) number.getSecondElement();
            float lcm = method.lcm(Divider, Divider1);
            setFirst((lcm / Divider) * Dividend + (lcm / Divider1) * Dividend1);
            setSecond(lcm);
        } else if (getFirstElement() instanceof Double && getSecondElement() instanceof Double && number.getFirstElement() instanceof Double && number.getSecondElement() instanceof Double) {
            double Dividend = (double) getFirstElement();
            double Divider = (double) getSecondElement();
            double Dividend1 = (double) number.getFirstElement();
            double Divider1 = (double) number.getSecondElement();
            double lcm = method.lcm(Divider, Divider1);
            setFirst((lcm / Divider) * Dividend + (lcm / Divider1) * Dividend1);
            setSecond(lcm);
        } else {
            throw new UnsupportedOperationException();

        }
    }

}

class Pair<T, T1> {

    private T first;
    private T1 second;

    Pair(T obj, T1 obj1) {
        this.first = obj;
        this.second = obj1;
    }

    protected static <K, V> Pair<K, V> createPair(K element, V element1) {
        return new Pair<>(element, element1);
    }

    protected T getFirstElement() {
        return first;
    }

    protected T1 getSecondElement() {
        return second;
    }

    protected void setFirst(T element) {
        first = element;
    }

    protected void setSecond(T1 element) {
        second = element;
    }

    @Override
    public int hashCode() {
        int result = (Integer) getFirstElement() * (Integer) getSecondElement();
        return result + (int) Math.sqrt(result);

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pair) {
            return (getFirstElement() == ((Division) obj).getFirstElement()) && (getSecondElement() == ((Division) obj).getSecondElement());
        }
        return false;
    }

}

class graph {

    private static int[][] base;
    private static boolean[] used;
    protected static int quantity = 0;
    private static Integer[] pred;

    protected static void start(int length) {
        used = new boolean[length];
        pred = new Integer[length];
    }

    protected static void RibMatrixToDefault(int length) throws Exception {
        start(length);
        base = new int[length][];
        int FirstSize, SecondSize;
        int[] rib, FirstArray, SecondArray, NewFirstArray, NewSecondArray;
        for (int i = 0; i < length; i++) {
            rib = Arrays.stream(InputAndOutput.ReadArrayInt(" ")).map(element -> element - 1).toArray();
            FirstArray = base[rib[0]];
            SecondArray = base[rib[1]];
            if (FirstArray == null) {
                FirstSize = 0;
            } else {
                FirstSize = FirstArray.length;
            }
            if (SecondArray == null) {
                SecondSize = 0;
            } else {
                SecondSize = SecondArray.length;
            }
            NewFirstArray = new int[FirstSize + 2];
            NewSecondArray = new int[SecondSize + 2];
            for (int index = 0; index < Math.max(FirstSize, SecondSize); index++) {
                if (index < FirstSize) {
                    NewFirstArray[index] = FirstArray[index];
                }
                if (index < SecondSize) {
                    NewSecondArray[index] = SecondArray[index];
                }
            }
            NewFirstArray[FirstSize] = rib[1];
            NewSecondArray[SecondSize] = rib[0];
            NewFirstArray[FirstSize + 1] = 1;
            NewSecondArray[SecondSize + 1] = 1;
            base[rib[0]] = NewFirstArray;
            base[rib[1]] = NewSecondArray;
        }
    }

    protected static void AdjacencyMatrixToDefault(int length, int dont) throws Exception {
        start(length);
        base = new int[length][];
        List<Integer> buffer = new ArrayList<>();
        int[] InputArray;;
        for (int i = 0; i < length; i++) {
            InputArray = InputAndOutput.ReadArrayInt(" ");
            for (int index = 0; index < length; index++) {
                if (i != index && InputArray[index] != dont) {
                    buffer.add(index);
                    buffer.add(InputArray[index]);
                }
            }
            base[i] = buffer.stream().mapToInt(element -> element).toArray();
            buffer.clear();
        }
    }

    protected static void dfs(int position) throws Exception {
        used[position] = true;
        quantity++;
        int next;
        for (int index = 0; index < base[position].length; index += 2) {
            next = base[position][index];
            if (!used[next]) {
                pred[next] = position;
                dfs(next);
            } else {
                if (next != pred[position]) { // if cycle
                    throw new Exception();
                }
            }
        }
    }

    protected static int dijkstra(int start, int stop, int size) {
        start--;
        stop--;
        int[] dist = new int[size];
        for (int i = 0; i < size; i++) {
            if (i != start) {
                dist[i] = Integer.MAX_VALUE;
            }
            pred[i] = start;
        }
        Queue<int[]> queue = new PriorityQueue<>((int[] first, int[] second) -> Integer.compare(first[1], second[1]));
        queue.add(new int[]{start, 0});
        int position;
        int[] GetQueue;
        while (queue.size() != 0) {
            GetQueue = queue.poll();
            position = GetQueue[0];
            if (GetQueue[1] > dist[position]) {
                continue;
            }
            for (int index = 0; index < base[position].length; index += 2) {
                if (dist[position] + base[position][index + 1] < dist[base[position][index]] && !used[base[position][index]]) {
                    dist[base[position][index]] = dist[position] + base[position][index + 1];
                    pred[base[position][index]] = position;
                    queue.add(new int[]{base[position][index], dist[base[position][index]]});
                }
            }
            used[position] = true;
        }
        return dist[stop] == Integer.MAX_VALUE ? -1 : dist[stop];
    }

    protected static boolean FloydWarshall(int[][] base, int length, int dont) {
        for (int k = 0; k < length; k++) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (base[i][k] == dont || base[k][j] == dont) {
                        continue;
                    }
                    int total = base[i][k] + base[k][j];
                    if (base[i][j] != dont) {
                        base[i][j] = Math.min(base[i][j], total);
                    } else {
                        base[i][j] = total;
                    }
                }
            }
        }
        for (int index = 0; index < length; index++) {
            if (base[index][index] != 0) { // if cycle
                return false;
            }

        }
        return true;
    }
}

class FastSort{

    protected static <T> void SortWithoutReturn(Number[] array, T length, int ShellHeapMergeMyInsertionSort) {
        sort(array, length, ShellHeapMergeMyInsertionSort);
    }

    //protected static <T> T[] SortWithReturn(T[] array, T length, int ShellHeapMergeMyInsertionSort) {
    //    T[] NewArray = array.clone();
    //    sort(array, length, ShellHeapMergeMyInsertionSort);
    //    SortWithoutReturn(array, 3, 5);
    //    return NewArray;
    //}

    private static <T> void sort(T[] array, T length, int ShellHeapMergeMyInsertionSort) {
        if (ShellHeapMergeMyInsertionSort < 0 || ShellHeapMergeMyInsertionSort > 4) {
            Random random = new Random();
            ShellHeapMergeMyInsertionSort = random.nextInt(4);
        }
        //if (ShellHeapMergeMyInsertionSort == 0) {
        //    ShellSort(array);
        //} else if (ShellHeapMergeMyInsertionSort == 1) {
        //    HeapSort(array);
        //} else if (ShellHeapMergeMyInsertionSort == 2) {
        //    MergeSort(array, 0, length - 1);
        //} else if (ShellHeapMergeMyInsertionSort == 3) {
              StraightMergeSort(new Long[] {234L, 34L, 254L}, length);
        //} else if (ShellHeapMergeMyInsertionSort == 4) {
        //    insertionSort(array);
        //}
    }

    private static <T> void StraightMergeSort(T[] array, T size) {
        if (compare(size, 0) == 0) {
            return;
        }
        Number length = add(divide(size, 2), ((compare(mod(size, 2), 0) == 0 ? 0 : 1)));
        T[][] ZeroBuffer = (T[][]) Array.newInstance(size.getClass(), 10, 10);
        ZeroBuffer[0][0] = size;
    }
        /*T[][] ZeroBuffer = new T[length + length % 2][2];
        T[][] FirstBuffer = new T[0][0];
        for (int index = 0; index < length; index++) {
            int ArrayIndex = index * 2;
            int NextArrayIndex = index * 2 + 1;
            if (NextArrayIndex < size) {
                if (array[ArrayIndex] > array[NextArrayIndex]) {
                    ZeroBuffer[index][0] = array[NextArrayIndex];
                    ZeroBuffer[index][1] = array[ArrayIndex];
                } else {
                    ZeroBuffer[index][0] = array[ArrayIndex];
                    ZeroBuffer[index][1] = array[NextArrayIndex];
                }
            } else {
                ZeroBuffer[index][0] = array[ArrayIndex];
            }
        }
        boolean position = false;
        int pointer0, pointer, pointer1, number = 4, NewPointer, count;
        Integer[][] NewBuffer;
        Integer[][] OldBuffer;
        length = (size / 4) + ((size % 4) == 0 ? 0 : 1);
        while (true) {
            pointer0 = 0;
            count = (number / 2) - 1;
            if (!position) {
                FirstBuffer = new Integer[length + length % 2][number];
                NewBuffer = FirstBuffer;
                OldBuffer = ZeroBuffer;
            } else {
                ZeroBuffer = new Integer[length + length % 2][number];
                NewBuffer = ZeroBuffer;
                OldBuffer = FirstBuffer;
            }
            for (int i = 0; i < length; i++) {
                pointer = 0;
                pointer1 = 0;
                NewPointer = pointer0 + 1;
                if (length == 1) {
                    for (int g = 0; g < size; g++) {
                        if (pointer > count || OldBuffer[pointer0][pointer] == null) {
                            array[g] = OldBuffer[NewPointer][pointer1];
                            pointer1++;
                        } else if (pointer1 > count || OldBuffer[NewPointer][pointer1] == null) {
                            if (OldBuffer[pointer0][pointer] == null) {
                                continue;
                            }
                            array[g] = OldBuffer[pointer0][pointer];
                            pointer++;
                        } else if (OldBuffer[pointer0][pointer] >= OldBuffer[NewPointer][pointer1]) {
                            array[g] = OldBuffer[NewPointer][pointer1];
                            pointer1++;
                        } else {
                            array[g] = OldBuffer[pointer0][pointer];
                            pointer++;
                        }
                    }
                    return;
                }
                for (int g = 0; g < number; g++) {
                    if (pointer > count || OldBuffer[pointer0][pointer] == null) {
                        if (OldBuffer[NewPointer][pointer1] == null) {
                            continue;
                        }
                        NewBuffer[i][g] = OldBuffer[NewPointer][pointer1];
                        pointer1++;
                    } else if (pointer1 > count || OldBuffer[NewPointer][pointer1] == null) {
                        if (OldBuffer[pointer0][pointer] == null) {
                            continue;
                        }
                        NewBuffer[i][g] = OldBuffer[pointer0][pointer];
                        pointer++;
                    } else if (OldBuffer[pointer0][pointer] >= OldBuffer[NewPointer][pointer1]) {
                        NewBuffer[i][g] = OldBuffer[NewPointer][pointer1];
                        pointer1++;
                    } else {
                        NewBuffer[i][g] = OldBuffer[pointer0][pointer];
                        pointer++;
                    }
                }
                pointer0 += 2;
            }
            position = !position;
            length = length / 2 + length % 2;
            number *= 2;
        }
    }

    private static void ShellSort(int[] array) {
        int j;
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int temp = array[i];
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }

    private static void HeapSort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--)
            shiftDown(array, i, array.length);
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            shiftDown(array, 0, i);
        }
    }

    private static void shiftDown(int[] array, int i, int n) {
        int child;
        int tmp;
        for (tmp = array[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && (array[child] < array[child + 1]))
                child++;
            if (tmp < array[child])
                array[i] = array[child];
            else
                break;
        }
        array[i] = tmp;
    }

    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void MergeSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            MergeSort(array, low, mid);
            MergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int n = high - low + 1;
        int[] Temp = new int[n];
        int i = low, j = mid + 1;
        int k = 0;
        while (i <= mid || j <= high) {
            if (i > mid)
                Temp[k++] = array[j++];
            else if (j > high)
                Temp[k++] = array[i++];
            else if (array[i] < array[j])
                Temp[k++] = array[i++];
            else
                Temp[k++] = array[j++];
        }
        for (j = 0; j < n; j++)
            array[low + j] = Temp[j];
    }

    private static void insertionSort(int[] elements) {
        for (int i = 1; i < elements.length; i++) {
            int key = elements[i];
            int j = i - 1;
            while (j >= 0 && key < elements[j]) {
                elements[j + 1] = elements[j];
                j--;
            }
            elements[j + 1] = key;
        }
    }
    */

    private static <T> int compare(T first, T second){
        if (first instanceof Integer){
            return Integer.compare((Integer) first, (Integer) second);
        }
        if (first instanceof Long){
            return Long.compare((Long) first, ((Integer) second).longValue());
        }
        if (first instanceof String){
            return ((String) first).compareTo((String) second);
        }
        throw new UnsupportedOperationException();
    }

    private static <T> Number divide(T first, T second){
        if (first instanceof Integer){
            return (Integer) first / (Integer) second;
        }
        if (first instanceof Long){
            return ((Long) first / ((Integer) second).longValue());
        }
        throw new UnsupportedOperationException();
    }

    private static <T> Number mod(T first, T second){
        if (first instanceof Integer){
            return (Integer) first % (Integer) second;
        }
        if (first instanceof Long){
            return ((Long) first % ((Integer) second).longValue());
        }
        throw new UnsupportedOperationException();
    }

    private static <T> Number add(T first, T second){
        if (first instanceof Integer){
            return (Integer) first + (Integer) second;
        }
        if (first instanceof Long){
            if (second instanceof Long) {
                return ((Long) first + (Long) second);
            }
            return ((Long) first + ((Integer) second).longValue());
        }
        throw new UnsupportedOperationException();
    }

}

class InputAndOutput {

    protected static BufferedReader read;
    protected static boolean FileInput = false;
    protected static BufferedWriter write;
    protected static boolean FileOutput = false;

    private static void startInput() {
        try {
            read = new BufferedReader(FileInput ? new FileReader("input.txt") : new InputStreamReader(System.in));
        } catch (Exception error) {
        }
    }

    private static void startOutput() {
        try {
            write = new BufferedWriter(FileOutput ? new FileWriter("output.txt") : new OutputStreamWriter(System.out));
        } catch (Exception error) {
        }
    }

    protected static int ReadInt() throws Exception {
        if (read == null) {
            startInput();
        }
        return Integer.parseInt(read.readLine());
    }

    protected static long ReadLong() throws Exception {
        if (read == null) {
            startInput();
        }
        return Long.parseLong(read.readLine());
    }

    protected static String ReadString() throws Exception {
        if (read == null) {
            startInput();
        }
        return read.readLine();
    }

    protected static int[] ReadArrayInt(String split) throws Exception {
        if (read == null) {
            startInput();
        }
        return Arrays.stream(read.readLine().split(split)).mapToInt(Integer::parseInt).toArray();
    }

    protected static long[] ReadArrayLong(String split) throws Exception {
        if (read == null) {
            startInput();
        }
        return Arrays.stream(read.readLine().split(split)).mapToLong(Long::parseLong).toArray();
    }

    protected static String[] ReadArrayString(String split) throws Exception {
        if (read == null) {
            startInput();
        }
        return read.readLine().split(split);
    }

    protected static void WriteArray(int[] array, String split) {
        if (write == null) {
            startOutput();
        }
        try {
            int length = array.length;
            for (int index = 0; index < length; index++) {
                write.write(Integer.toString(array[index]));
                if (index + 1 != length) {
                    write.write(split);
                }
            }
        } catch (Exception error) {
        }
    }

    protected static void WriteArray(long[] array, String split) {
        if (write == null) {
            startOutput();
        }
        try {
            int length = array.length;
            for (int index = 0; index < length; index++) {
                write.write(Long.toString(array[index]));
                if (index + 1 != length) {
                    write.write(split);
                }
            }
        } catch (Exception error) {
        }
    }

    public static void WriteArray(String[] array, String split) {
        if (write == null) {
            startOutput();
        }
        try {
            int length = array.length;
            for (int index = 0; index < length; index++) {
                write.write(array[index]);
                if (index + 1 != length) {
                    write.write(split);
                }
            }
        } catch (Exception error) {
        }
    }

    protected static void WriteArray(boolean[] array, String split) {
        if (write == null) {
            startOutput();
        }
        try {
            int length = array.length;
            for (int index = 0; index < length; index++) {
                write.write(Boolean.toString(array[index]));
                if (index + 1 != length) {
                    write.write(split);
                }
            }
        } catch (Exception error) {
        }
    }

    protected static void WriteInt(int number, String split) {
        if (write == null) {
            startOutput();
        }
        try {
            write.write(Integer.toString(number));
            write.write(split);
        } catch (Exception error) {
        }
    }

    protected static void WriteString(String word, String split) {
        if (write == null) {
            startOutput();
        }
        try {
            write.write(word);
            write.write(split);
        } catch (Exception error) {
        }
    }

    protected static void WriteLong(Long number, String split) {
        if (write == null) {
            startOutput();
        }
        try {
            write.write(Long.toString(number));
            write.write(split);
        } catch (Exception error) {
        }
    }

    protected static void WriteEnter() {
        if (write == null) {
            startOutput();
        }
        try {
            write.newLine();
        } catch (Exception e) {
        }
    }
}
package com.stepik.algo;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

public class priorityQueue {
    int[] massive;
    int elementsCount;

    List<Integer> Maximums = new ArrayList<>();


    private void insert(int number) {
        int[] copy;
        if (massive == null) {
            massive = new int[1000000];

            massive[0] = number;
            elementsCount ++;

        } else {


//            copy = Arrays.copyOf(massive, massive.length + 1);
//            massive = copy;
//            massive[massive.length - 1] = number;
            massive[elementsCount] = number;
            elementsCount ++;


            switchUP(massive);

        }


    }

    private void switchUP(int[] mas) {
        int last = mas[elementsCount - 1];
        int lastI = elementsCount - 1;
        boolean isSorted = false;
        while (!isSorted) {
            if (findParent(lastI) < 0) break;
            if (last > mas[findParent(lastI)]) {
                int switcher = mas[findParent(lastI)];
                mas[findParent(lastI)] = last;
                last = mas[findParent(lastI)];
                mas[lastI] = switcher;
                lastI = findParent(lastI);

            } else isSorted = true;
        }

    }

    private int findParent(int i) {
        if (i - 1 >= 0)
            return (i - 1) / 2;
        else return -1;
    }

    private int findLeftChild(int i) {
        return 2 * i + 1;
    }

    private int findRightChild(int i) {
        return 2 * i + 2;
    }

    private void ExtractMax() {
        int max = this.massive[0];
        elementsCount --;

        Maximums.add(max);
        if (elementsCount == 0) {
            this.massive = null;

            return;
        }

        this.massive[0] = this.massive[elementsCount];

       // massive = Arrays.copyOf(this.massive, massive.length - 1);
        int switcher = this.massive[0];
        int switcherPos = 0;
        boolean isSorted = false;
        while (!isSorted) {
            int leftChild = findLeftChild(switcherPos);
            int rightChild = findRightChild(switcherPos);
            int length = this.massive.length;
            int interMax;
            if (leftChild >= elementsCount) {
                break;
            } else if (rightChild >= elementsCount) {
                if (this.massive[leftChild] < switcher) {
                    break;
                }
                interMax = this.massive[leftChild];
                this.massive[leftChild] = switcher;
                this.massive[switcherPos] = interMax;

                isSorted = true;
            } else if (switcher <= this.massive[leftChild] || switcher <= this.massive[rightChild]) {


                if (this.massive[leftChild] >= this.massive[rightChild]) {
                    interMax = this.massive[leftChild];
                    this.massive[leftChild] = switcher;
                    this.massive[switcherPos] = interMax;
                    switcherPos = leftChild;

                } else if (this.massive[leftChild] < this.massive[rightChild]) {
                    interMax = this.massive[rightChild];
                    this.massive[rightChild] = switcher;
                    this.massive[switcherPos] = interMax;
                    switcherPos = rightChild;

                }
            } else isSorted = true;
        }

    }

    private void Test() {
        int okCount = 0;
        int errorCount = 0;

        List<Integer> test = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            int rand = (int) (Math.random() * 1000);
            this.insert(rand);
            test.add(rand);

        }
       // System.out.println(test.toString());
       // System.out.println(Arrays.toString(this.massive));
        test.sort((i, j) -> j - i);
       // System.out.println(test.toString());
        for (int i = 0; i < test.size(); i++) {
            this.ExtractMax();
            if (test.get(i).equals(this.Maximums.get(i))) {
              //  System.out.println("OK   " + "test " + test.get(i) + "---------massive:   " + this.Maximums.get(i));
                okCount++;
            } else {
              //  System.out.println("ERROR!!!!!!!!!!!!!!!!!!+test    " + test.get(i) + "---------massive:   " + this.Maximums.get(i));
                errorCount++;
            }
        }
        System.out.println("OK :" + okCount);
        System.out.println("Errors :" + errorCount);
    }

    public static void main(String[] args) throws IOException {
        priorityQueue queue = new priorityQueue();
        long startTime = System.currentTimeMillis();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        int operationsNumber = Integer.parseInt(reader.readLine());
//
//        for (int i = 0; i < operationsNumber; i++) {
//            String str = reader.readLine();
//            String[] input = str.split(" ");
//            String key = input[0];
//
//            if (key.equals("Insert")) {
//                int value = Integer.parseInt(input[1]);
//                queue.insert(value);
//            } else queue.ExtractMax();
//
//        }
//        reader.close();
//
//
//        for (int i : queue.Maximums) {
//            System.out.println(i);
//        }

        queue.Test();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}

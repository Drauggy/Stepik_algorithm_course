package com.stepik.algo;

import java.util.*;
import java.util.stream.Collectors;

public class huffman {
    private static String code = "";
    private static int length;
    private static Map<String, String> codeOut = new HashMap<>();

    static class Node implements Comparable<Node> {
        private int frequency;
        private String letter;
        private Node leftChild;
        private Node rightChild;
        private String code = "";

        Node(Character key, Integer value) {
            this.letter = key.toString();
            this.frequency = value;
        }

        Node(String s, int value, Node leftChild, Node rightChild) {
            this.letter = s;
            this.frequency = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return frequency == node.frequency &&
                    letter.equals(node.letter) &&
                    Objects.equals(leftChild, node.leftChild) &&
                    Objects.equals(rightChild, node.rightChild) &&
                    code.equals(node.code);
        }

        @Override
        public int hashCode() {
            return Objects.hash(frequency, letter, leftChild, rightChild, code);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "frequency=" + frequency +
                    ", letter='" + letter + '\'' +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    ", code='" + code + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Node node) {
            if (this.frequency < node.frequency) return -1;
            else if (this.frequency > node.frequency) return 1;
            return 0;
        }
    }

    private static void huffmanAlgo(Node root, String key) {
        Node current = root;
        while (!current.letter.equals(key)) {
            if (current.rightChild.letter.contains(key)) {
                current = current.rightChild;
                code += "1";
            } else {
                current = current.leftChild;
                code += "0";
            }
            if (current == null) return;
        }
        current.code = code;
        codeOut.put(current.letter, code);
        System.out.println(current.letter + ": " + code);
        code = "";

    }

    private static void Length(Queue<Node> queue) {
        for (Node node : queue) {
            if (node.letter.length() > 1)
                length += node.frequency;

        }
        System.out.println(length);
    }

    private static void HuffmanCode(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : str.toCharArray()) {
            stringBuilder.append(codeOut.get(c + ""));
        }
        System.out.println(stringBuilder.toString());
    }


    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        scanner.close();
        List<Character> charsOfInput;
        charsOfInput = input.chars()
                .mapToObj(i -> (char) i)
                .sorted()
                .collect(Collectors.toList());
        Map<Character, Integer> countChar = charsOfInput.stream().collect(HashMap::new, (m, c) -> {
            if (m.containsKey(c))
                m.put(c, m.get(c) + 1);
            else
                m.put(c, 1);
        }, HashMap::putAll);

        for (Map.Entry<Character, Integer> entry : countChar.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        System.out.print(countChar.size() + " ");


        Queue<Node> queue = new PriorityQueue<>(nodes);
        Queue<Node> codeLength = new PriorityQueue<>(nodes);
        Node left;
        Node right;
        if (countChar.size() > 1) {


            for (int k = countChar.size() + 1; k < 2 * countChar.size(); k++) {
                left = queue.poll();
                right = queue.poll();
                Node parentNode = new Node(left.letter + right.letter, left.frequency + right.frequency, left, right);
                queue.add(parentNode);
                codeLength.add(parentNode);
            }
            Length(codeLength);
            for (Node node : nodes) {
                huffmanAlgo(queue.peek(), node.letter);
            }
            HuffmanCode(input);
        } else {
            System.out.println(charsOfInput.size());
            System.out.println(charsOfInput.get(0) + ": 0");
            for (char c : charsOfInput) {
                System.out.print("0");
            }
        }
    }
}

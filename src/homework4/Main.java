package homework4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RedBlackTree rbTree = new RedBlackTree();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int value = scanner.nextInt();
                rbTree.add(value);
                System.out.println("value and color root => " + rbTree.root.value + " " + rbTree.root.color);
                System.out.println("value and color left => " + rbTree.root.leftChild.value + " " + rbTree.root.leftChild.color);
                System.out.println("value and color right => " + rbTree.root.rightChild.value + " " + rbTree.root.rightChild.color);
            } catch (Exception e) {
            }
        }
    }
}

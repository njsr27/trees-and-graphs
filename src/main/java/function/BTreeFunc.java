package function;

import model.BNode;
import model.BTree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

public abstract class BTreeFunc {

  public static BTree create() {
    BTree tree = new BTree();
    Queue<BNode> queue = new LinkedList<>();
    int auxVal;

    try (Scanner keyboard = new Scanner(System.in)) {
      System.out.print("Enter root value: ");
      tree.root = new BNode(Integer.parseInt(keyboard.nextLine()));
      tree.size++;
      queue.add(tree.root);
      while (!queue.isEmpty()) {
        BNode auxNode = queue.poll();
        System.out.print("Enter left child of " + auxNode.value + " (or else -1): ");
        auxVal = Integer.parseInt(keyboard.nextLine());
        if (auxVal != -1) {
          auxNode.left = new BNode(auxVal);
          queue.add(auxNode.left);
          tree.size++;
        }

        System.out.print("Enter right child of " + auxNode.value + " (or else -1): ");
        auxVal = Integer.parseInt(keyboard.nextLine());
        if (auxVal != -1) {
          auxNode.right = new BNode(auxVal);
          queue.add(auxNode.right);
          tree.size++;
        }
      }
    }

    return tree;
  }

  public static void printPreOrder(BNode root) {
    if (Objects.nonNull(root)) {
      System.out.print(root.value + " ");
      printPreOrder(root.left);
      printPreOrder(root.right);
    }
  }

}

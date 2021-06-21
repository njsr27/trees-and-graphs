package function;

import model.BNode;
import model.BTree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

/**
 * Solutions of the problems presented in the course
 */
public abstract class BTreeFunc {

  /**
   * Creation of Binary tree using Scanner
   *
   * @return created Binary tree
   */
  public static BTree create() {
    BTree tree = new BTree();
    Queue<BNode> queue = new LinkedList<>();
    int auxVal;
    BNode auxNode;

    try (Scanner keyboard = new Scanner(System.in)) {
      System.out.print("Enter root value: ");
      tree.root = new BNode(Integer.parseInt(keyboard.nextLine()));
      tree.size++;
      queue.add(tree.root);
      while (!queue.isEmpty()) {
        auxNode = queue.poll();
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

  /**
   * Print binary tree values in preorder
   *
   * @param root root of the binary tree
   */
  public static void printPreOrder(BNode root) {
    if (Objects.nonNull(root)) {
      System.out.print(root.value + " ");
      printPreOrder(root.left);
      printPreOrder(root.right);
    }
  }

  /**
   * Print binary tree values in inorder
   *
   * @param root root of the binary tree
   */
  public static void printInOrder(BNode root) {
    if (Objects.nonNull(root)) {
      printInOrder(root.left);
      System.out.print(root.value + " ");
      printInOrder(root.right);
    }
  }

  /**
   * Print binary tree values in postorder
   *
   * @param root root of the binary tree
   */
  public static void printPostOrder(BNode root) {
    if (Objects.nonNull(root)) {
      printPostOrder(root.left);
      printPostOrder(root.right);
      System.out.print(root.value + " ");
    }
  }

}

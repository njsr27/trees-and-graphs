package function;

import model.BNode;
import model.BTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * Solutions of the problems presented in the course,
 * with improvements added by myself for an easier testing
 */
public class BTreeFuncV2 {

  /**
   * Creation of Binary tree using an input array
   *
   * @return created Binary tree
   */
  public static BTree createFromArray(List<Integer> values) {
    BTree tree = new BTree();
    Queue<BNode> queue = new LinkedList<>();
    int auxVal;
    BNode auxNode;

    tree.root = new BNode(values.get(0));
    tree.size++;

    queue.add(tree.root);

    for (int i = 1; i < values.size(); i = i + 2) {
      auxNode = queue.poll();

      auxVal = values.get(i);

      if (auxVal != -1) {
        auxNode.left = new BNode(auxVal);
        queue.add(auxNode.left);
        tree.size++;
      }

      auxVal = values.get(i + 1);
      if (auxVal != -1) {
        auxNode.right = new BNode(auxVal);
        queue.add(auxNode.right);
        tree.size++;
      }
    }

    return tree;
  }

  /**
   * Generate list from the values of the binary tree in preorder
   *
   * @param root root of the binary tree
   * @param base list where the values will be stored
   * @return list with the values of the binary tree in preorder
   */
  public static List<Integer> generatePreOrderList(BNode root, List<Integer> base) {
    if (Objects.nonNull(root)) {
      base.add(root.value);
      generatePreOrderList(root.left, base);
      generatePreOrderList(root.right, base);
    }

    return base;
  }

  /**
   * Generate list from the values of the binary tree in inorder
   *
   * @param root root of the binary tree
   * @param base list where the values will be stored
   * @return list with the values of the binary tree in inorder
   */
  public static List<Integer> generateInOrderList(BNode root, List<Integer> base) {
    if (Objects.nonNull(root)) {
      generateInOrderList(root.left, base);
      base.add(root.value);
      generateInOrderList(root.right, base);
    }

    return base;
  }

  /**
   * Generate list from the values of the binary tree in postorder
   *
   * @param root root of the binary tree
   * @param base list where the values will be stored
   * @return list with the values of the binary tree in postorder
   */
  public static List<Integer> generatePostOrderList(BNode root, List<Integer> base) {
    if (Objects.nonNull(root)) {
      generatePostOrderList(root.left, base);
      generatePostOrderList(root.right, base);
      base.add(root.value);
    }

    return base;
  }

}

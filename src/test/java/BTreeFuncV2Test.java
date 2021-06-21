import function.BTreeFuncV2;
import model.BTree;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BTreeFuncV2Test {

  @Test
  public void binaryTreeIsCreatedCorrectly() {
    BTree tree = BTreeFuncV2.createFromArray(
      Arrays.asList(10, 20, 30, 40, 50, 60, 70, -1, -1, -1, -1, -1, -1, -1, -1)
    );

    Assert.assertEquals(7, tree.size);
    Assert.assertEquals(20, tree.root.left.value);
    Assert.assertEquals(30, tree.root.right.value);
    Assert.assertEquals(40, tree.root.left.left.value);
    Assert.assertEquals(50, tree.root.left.right.value);
    Assert.assertEquals(60, tree.root.right.left.value);
    Assert.assertEquals(70, tree.root.right.right.value);
  }

  @Test
  public void preOrderListIsGeneratedCorrectly() {
    BTree tree = BTreeFuncV2.createFromArray(
      Arrays.asList(10, 20, 30, 40, 50, 60, 70, -1, -1, -1, -1, -1, -1, -1, -1)
    );

    List<Integer> listPreOrder = BTreeFuncV2.generatePreOrderList(tree.root, new LinkedList<>()); // 10 20 40 50 30 60 70

    Assert.assertEquals(7, listPreOrder.size());
    Assert.assertEquals((Integer) 10, listPreOrder.get(0));
    Assert.assertEquals((Integer) 20, listPreOrder.get(1));
    Assert.assertEquals((Integer) 40, listPreOrder.get(2));
    Assert.assertEquals((Integer) 50, listPreOrder.get(3));
    Assert.assertEquals((Integer) 30, listPreOrder.get(4));
    Assert.assertEquals((Integer) 60, listPreOrder.get(5));
    Assert.assertEquals((Integer) 70, listPreOrder.get(6));
  }

  @Test
  public void postOrderListIsGeneratedCorrectly() {
    BTree tree = BTreeFuncV2.createFromArray(
      Arrays.asList(10, 20, 30, -1, -1, -1, -1)
    );

    List<Integer> listPostOrder = BTreeFuncV2.generatePostOrderList(tree.root, new LinkedList<>()); // 20 30 10

    Assert.assertEquals(3, listPostOrder.size());
    Assert.assertEquals((Integer) 20, listPostOrder.get(0));
    Assert.assertEquals((Integer) 30, listPostOrder.get(1));
    Assert.assertEquals((Integer) 10, listPostOrder.get(2));
  }

  @Test
  public void inOrderListIsGeneratedCorrectly() {
    BTree tree = BTreeFuncV2.createFromArray(
      Arrays.asList(10, 20, 30, -1, -1, -1, -1)
    );

    List<Integer> listInOrder = BTreeFuncV2.generateInOrderList(tree.root, new LinkedList<>()); // 20 30 10

    Assert.assertEquals(3, listInOrder.size());
    Assert.assertEquals((Integer) 20, listInOrder.get(0));
    Assert.assertEquals((Integer) 10, listInOrder.get(1));
    Assert.assertEquals((Integer) 30, listInOrder.get(2));
  }

}

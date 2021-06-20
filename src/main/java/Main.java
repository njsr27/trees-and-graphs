import function.BTreeFunc;
import model.BTree;

public class Main {
  public static void main(String[] args) {
    BTree tree = BTreeFunc.create();
    BTreeFunc.printPreOrder(tree.root);
    // Modify the methods
    // to accept (and return) and array instead of using Scanner, to create unit tests.
    // create unit tests
  }
}

package Trees;

import java.util.List;
import java.util.Vector;

public class UnlimitedChildrenTreeNode {
    public  int val;
    public Vector<UnlimitedChildrenTreeNode> children;
    UnlimitedChildrenTreeNode()
    {
        children = new Vector<UnlimitedChildrenTreeNode>();
    }

    public static UnlimitedChildrenTreeNode newNode(int key)
    {
        UnlimitedChildrenTreeNode temp = new UnlimitedChildrenTreeNode();
        temp.val = key;
        return temp;
    }


}

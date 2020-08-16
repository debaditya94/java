package Trees;

public class amazonAssessment2 {

    // resultant node with max sum of children
// and node
    static double maxAverage = Double.NEGATIVE_INFINITY;
    static UnlimitedChildrenTreeNode rootOfMaxAvg = null;

    public static UnlimitedChildrenTreeNode subtreeMaxAvg(UnlimitedChildrenTreeNode root) {
        if (root == null) {
            return null;
        }
        maxAverageUtil(root);
        return rootOfMaxAvg;
    }

    public static SubTreeStat maxAverageUtil(final UnlimitedChildrenTreeNode root) {
        if(root == null) {
            return new SubTreeStat(0.0, 0);
        }
        double sum = (double) root.val;
        long count = 1;
        for(UnlimitedChildrenTreeNode child : root.children) {
            SubTreeStat childStat = maxAverageUtil(child);
            sum += childStat.sum;
            count += childStat.count;
        }

        double average = sum/count;
        if(maxAverage < average) {
            maxAverage = average;
            rootOfMaxAvg = root;
        }
        return new SubTreeStat(sum, count);
    }
    public static void main(String args[])
    {
    /* Let us create below tree
                1
            / | \
            2 3 4
        / \ / | \ \
        5 6 7 8 9 10
    */

        UnlimitedChildrenTreeNode root = UnlimitedChildrenTreeNode.newNode(1);
        (root.children).add(UnlimitedChildrenTreeNode.newNode(-5));
        (root.children).add(UnlimitedChildrenTreeNode.newNode(13));
        (root.children).add(UnlimitedChildrenTreeNode.newNode(4));
//        (root.children).add(UnlimitedChildrenTreeNode.newNode(-1));
        (root.children.get(0).children).add(UnlimitedChildrenTreeNode.newNode(1));
        (root.children.get(0).children).add(UnlimitedChildrenTreeNode.newNode(2));
        (root.children.get(1).children).add(UnlimitedChildrenTreeNode.newNode(4));
        (root.children.get(1).children).add(UnlimitedChildrenTreeNode.newNode(-2));
//        (root.children.get(2).children).add(UnlimitedChildrenTreeNode.newNode(9));
//        (root.children.get(2).children).add(UnlimitedChildrenTreeNode.newNode(10));

        subtreeMaxAvg(root);
        System.out.print( rootOfMaxAvg.val );
    }
}
class SubTreeStat {
    double sum;
    long count;

    SubTreeStat(double sum, long count) {
        this.sum = sum;
        this.count = count;
    }
}

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeBuildingAndTraversals {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.left = null;
        }
    }

    static class BinaryTree {

        static int index = -1;

        static Node buildTree(int nodes[]) {
            index++;

            if (nodes[index] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        // pre-order : Root-->left-->Right (RLR)
        static void preOrderTraversal(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + ", ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }

        // in-order: Left-->Root-->Right (LRR)
        static void inOrderTraversal(Node root) {
            if (root == null) {
                return;
            }
            inOrderTraversal(root.left);
            System.out.print(root.data + ", ");
            inOrderTraversal(root.right);
        }

        static void postOrderTraversal(Node root) {
            if (root == null) {
                return;
            }
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + ", ");
        }

        static void levelOrderTraversal(Node root) {
            if (root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()) {

                Node currNode = q.remove();

                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    }
                    else {
                        q.add(currNode);
                    }
                }
                else {
                    System.out.print(currNode.data + ", ");
                    
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }

            }
        }

        static int height(Node root) {

            if (root == null) {
                return 0;
            }

            int lh = height(root.left);
            int rh = height(root.right);

            int heightOfTree = Math.max(lh, rh) + 1;
            
            return heightOfTree;
        }

        static int countNumberOfNodes(Node root) {

            if (root == null) {
                return 0;
            }

            int leftCount = countNumberOfNodes(root.left);
            int rightCount = countNumberOfNodes(root.right);

            int totalCount = leftCount + rightCount + 1;

            return totalCount;
        }
      
        static int sumOfNodes(Node root) {

            if (root == null) {
                return 0;
            }

            int leftSum =  sumOfNodes(root.left);
            int rightSum = sumOfNodes(root.right);

            int totalSum = leftSum + rightSum + root.data;

            return totalSum;
        }
    }

    public static void main(String[] args) {
        
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println("data of root node is: " + root.data);

        tree.preOrderTraversal(root);

        System.out.println();
        tree.inOrderTraversal(root);

        System.out.println();
        tree.postOrderTraversal(root);

        System.out.println();
        tree.levelOrderTraversal((root));

        System.out.println();
        System.out.println(tree.height(root));

        System.out.println(tree.countNumberOfNodes(root));

        System.out.println(tree.sumOfNodes(root));
    }
}
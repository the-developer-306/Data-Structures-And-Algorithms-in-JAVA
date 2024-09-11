/* 
        1
       / \
      2   3
     / \   \
    4   5   6  

*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class BinaryTreeBuildingAndTraversalsAndBasicOperations {

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

        // post-order: Left-->Right-->Root (LRR)
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

            while (!q.isEmpty()) {

                Node currNode = q.remove();

                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(currNode);
                    }
                } else {
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

            int leftSum = sumOfNodes(root.left);
            int rightSum = sumOfNodes(root.right);

            int totalSum = leftSum + rightSum + root.data;

            return totalSum;
        }

        // diameter of a binary tree is defined as the maximum no. of nodes between 2
        // leaves.
        static int diameterApproach1(Node root) { // O(n^2)

            if (root == null) {
                return 0;
            }

            int leftDiameter = diameterApproach1(root.left);
            int leftHeight = height(root.left);

            int rightDiameter = diameterApproach1(root.right);
            int rightHeight = height(root.right);

            int selfDiameter = leftHeight + rightHeight + 1;

            return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));
        }

        static class Info1 {
            int diam;
            int ht;

            Info1(int diam, int ht) {
                this.diam = diam;
                this.ht = ht;
            }
        }

        // here we have calculated the diameter and height for a root node in one go
        static Info1 diameterApproach2(Node root) { // O(n)

            if (root == null) {
                return new Info1(0, 0);
            }

            Info1 leftInfo = diameterApproach2(root.left);
            Info1 rightInfo = diameterApproach2(root.right);

            int selfDiameter = leftInfo.ht + rightInfo.ht + 1;

            int diameter = Math.max(selfDiameter, Math.max(leftInfo.diam, rightInfo.diam));
            int height = Math.max(leftInfo.ht, rightInfo.ht) + 1;

            return new Info1(diameter, height);
        }

        static boolean isIdentical(Node n, Node subRoot) {
            if (n == null && subRoot == null) {
                return true;
            } else if (n == null || subRoot == null || n.data != subRoot.data) {
                return false;
            }

            // checking for left and right subtrees
            if (!isIdentical(n.left, subRoot.left)) {
                return false;
            }
            if (!isIdentical(n.right, subRoot.right)) {
                return false;
            }

            return true;
        }

        static boolean isSubTree(Node root, Node subRoot) {

            if (root == null) {
                return false;
            }
            if (root.data == subRoot.data) {
                if (isIdentical(root, subRoot)) {
                    return true;
                }
            }
            return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
        }

        static class Info2 {
            Node node;
            int hd;

            Info2(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        static void topView(Node root) {

            Queue<Info2> q = new LinkedList<>();
            HashMap<Integer, Node> map = new HashMap<>();
            int min = 0, max = 0;

            q.add(new Info2(root, 0));
            q.add(null);

            while (!q.isEmpty()) {
                Info2 curr = q.remove();

                if (curr == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {

                    if (!map.containsKey(curr.hd)) {
                        map.put(curr.hd, curr.node);
                        min = Math.min(min, curr.hd);
                        max = Math.max(max, curr.hd);
                    }

                    if (curr.node.left != null) {
                        q.add(new Info2(curr.node.left, curr.hd - 1));

                    }

                    if (curr.node.right != null) {
                        q.add(new Info2(curr.node.right, curr.hd + 1));
                    }
                }
            }

            for (int i = min; i <= max; i++) {
                System.out.print(map.get(i).data + ", ");
            }

        }

        static void kthlvl_recursive(Node root, int lvl, int k) {
            if (root == null) {
                return;
            }

            if (lvl == k) {
                System.out.print(root.data + ", ");
                return;
            }

            kthlvl_recursive(root.left, lvl + 1, k);
            kthlvl_recursive(root.right, lvl + 1, k);
        }

        static void kthlvl_iterative(Node root, int lvl, int k) {

            if (root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node curr = q.remove();

                if (curr == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(curr);
                        lvl++;
                    }
                } else {

                    if (lvl == k) {
                        System.out.print(curr.data + ", ");
                    }

                    if (curr.left != null) {
                        q.add(curr.left);
                    }

                    if (curr.right != null) {
                        q.add(curr.right);
                    }
                }
            }
        }

        // approach 1
        static Node lca1(Node root, int n1, int n2) {

            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getPath(root, n1, path1);
            getPath(root, n2, path2);

            int i = 0;
            for (i = 0; i < path1.size() && i < path2.size(); i++) {
                if (path1.get(i) != path2.get(i)) {
                    break;
                }
            }

            Node lca = path1.get(i - 1);
            return lca;
        }

        static boolean getPath(Node root, int n, ArrayList<Node> path) {

            if (root == null) {
                return false;
            }
            path.add(root);

            if (root.data == n) {
                return true;
            }

            boolean foundLeft = getPath(root.left, n, path);
            boolean foundRight = getPath(root.right, n, path);

            if (foundRight || foundLeft) {
                return true;
            }

            path.remove(path.size() - 1);
            return false;
        }

        static Node lca2(Node root, int n1, int n2) {

            if (root == null || root.data == n1 || root.data == n2) { // if root is found then best
                return root;
            }

            Node leftLca = lca2(root.left, n1, n2); // searching in left subtree
            Node rightLca = lca2(root.right, n1, n2); // searching in right subtree

            if (rightLca == null) { // if not found in right then return leftLca
                return leftLca;
            }

            if (leftLca == null) { // if not found in left then return right
                return rightLca;
            }

            return root; // if found in both then root is the lca
        }

        static int lcaDist(Node root, int n) {
            if (root == null) {
                return -1;
            }

            if (root.data == n) {
                return 0;
            }

            int leftDist = lcaDist(root.left, n);
            int rightDist = lcaDist(root.right, n);

            if (leftDist == -1 && rightDist == -1) {
                return -1;
            } else if (leftDist == -1) {
                return ++rightDist;
            } else {
                return ++leftDist;
            }

        }

        static int minDist(Node root, int n1, int n2) {
            Node lca = lca2(root, n1, n2);

            return lcaDist(lca, n1) + lcaDist(lca, n2);
        }

        static int kthAncestor(Node root, int n, int k) {

            if (root == null) {
                return -1;
            }

            if (root.data == n) {
                return 0;
            }

            int leftDist = kthAncestor(root.left, n, k);
            int rightDist = kthAncestor(root.right, n, k);

            if (leftDist == -1 && rightDist == -1) {
                return -1;
            }

            int max = Math.max(leftDist, rightDist);

            if (max + 1 == k) {
                System.out.println(root.data);
            }
            return max + 1;
        }
        static int transformSumTree(Node root) {
            
            if (root == null) {
                return 0;
            }
    
            int leftChild = transformSumTree(root.left);
            int rightChild = transformSumTree(root.right);
    
            int data = root.data;
    
            int newL = root.left == null ? 0 : root.left.data;
            int newR = root.right == null ? 0 : root.right.data;
    
            root.data = newL + leftChild + newR + rightChild;
    
            return data;
    
        }
    }


    public static void main(String[] args) {

        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };

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

        System.out.println(tree.diameterApproach1(root));

        System.out.println(tree.diameterApproach2(root).diam);

        // creating a sub tree
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(tree.isSubTree(root, subRoot));

        tree.topView(root);

        System.out.println();

        tree.kthlvl_recursive(root, 1, 2);

        System.out.println();

        tree.kthlvl_iterative(root, 1, 3);

        System.out.println();

        System.out.println(tree.lca1(root, 4, 7).data);

        System.out.println(tree.lca2(root, 4, 7).data);

        System.out.println(tree.minDist(root, 4, 6));

        tree.kthAncestor(root, 5, 2);

        tree.transformSumTree(root);

        tree.preOrderTraversal(root);
    }
}
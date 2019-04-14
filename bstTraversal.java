import java.util.Deque;
import java.util.LinkedList;
public class bstTraversal
{
    Node root; // root of BST

    public void insert(String d) {
        if (root == null) {
            root = new Node(d);
            return;
        }

        Node node = root; // start search downward at root
        while (true) {
            if (d.compareTo(node.data) < 0) // look left
            {
                if (node.left != null) {
                    node = node.left;
                } else {
                    node.left = new Node(d);
                    break;
                }
            } else if (d.compareTo(node.data) > 0) //look right
            {
                if (node.right != null) {
                    node = node.right;
                } else {
                    node.right = new Node(d);
                    break;
                }
            } else //do not insert
            {
                break;
            }
        }
    }
    public void inorderTraversal()
    {
        inorderT(root);
    }

    public void preorderTraversal()
    {
        preorderT(root);
    }

    public void postorderTraversal()
    {

        postorderT(root);
    }

    private void inorderT(Node root){
        Deque<Node> stack = new LinkedList<Node>();
        Node node = root;
        while(true){
            if(node != null){
                stack.addFirst(node);
                node = node.left;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pollFirst();
                System.out.println(node.data);
                node = node.right;
            }
        }
    }

    public void preorderT(Node root){
        Deque<Node> stack = new LinkedList<Node>();
        stack.addFirst(root);
        while(!stack.isEmpty()){
            root = stack.pollFirst();
            System.out.println(root.data);
            if(root.right != null){
                stack.addFirst(root.right);
            }
            if(root.left!= null){
                stack.addFirst(root.left);
            }
        }
    }

    public void postorderT(Node root){
        Deque<Node> stack1 = new LinkedList<Node>();
        Deque<Node> stack2 = new LinkedList<Node>();
        stack1.addFirst(root);
        while(!stack1.isEmpty()){
            root = stack1.pollFirst();
            if(root.left != null){
                stack1.addFirst(root.left);
            }
            if(root.right != null){
                stack1.addFirst(root.right);
            }
            stack2.addFirst(root);
        }
        while(!stack2.isEmpty()){
            System.out.println(stack2.pollFirst().data);
        }
    }

}

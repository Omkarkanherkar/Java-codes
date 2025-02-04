import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}


public class Tree {


    public static void main(String[] args) {
        System.out.println("hello world");
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right.right=new TreeNode(6);
        root.right.right.left=new TreeNode(7);

        //Binary Search Tree Structure and example

        System.out.println(noofNoofNodes(root));
        TreeNode root2=new TreeNode(20);
        root2.right=new TreeNode(25);
        root2.left=new TreeNode(15);
        root2.left.right=new TreeNode(18);
        root2.left.left=new TreeNode(10);

        //System.out.println(rightview(root));
       // System.out.println(leftview(root));
       // ArrayList<Integer> res=new ArrayList<>();
        //inorder(root,res);
        //System.out.println(res.toString());
        //int sum=0;
      //  System.out.println(treesum(root));
        insertinBST(root2,30);
        ArrayList<Integer> bst=new ArrayList<>();
        inorder(root2,bst);
        System.out.println(bst.toString());




    }
    static ArrayList<Integer> rightview(TreeNode root){
        Queue<TreeNode> que= new LinkedList<>();
        ArrayList<Integer> res=new ArrayList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int size=que.size();

            for(int i=0;i<size;i++){
                TreeNode node=que.poll();

                if(node.left!=null){
                    que.offer(node.left);
                }
                if(node.right!=null){
                    que.offer(node.right);
                }

                if(i==size-1){
                    res.add(node.data);
                }
            }

        }
        return res;
    }
    //code for left view of the tree differrence is that the bfs traversal where the left side will come after
    static ArrayList<Integer> leftview(TreeNode root){
        Queue<TreeNode> que= new LinkedList<>();
        ArrayList<Integer> res=new ArrayList<>();
        que.offer(root);
        while(!que.isEmpty()){
            int size=que.size();

            for(int i=0;i<size;i++){
                TreeNode node=que.poll();


                if(node.right!=null){
                    que.offer(node.right);
                }
                if(node.left!=null){
                    que.offer(node.left);
                }

                if(i==size-1){
                    res.add(node.data);
                }
            }

        }
        return res;
    }
    public static ArrayList<Integer> inorder(TreeNode root,ArrayList<Integer> res ){
        if(root==null){
            return res;
        }
        inorder(root.left,res);
        res.add(root.data);
        inorder(root.right,res);
        return res;
    }
    public static ArrayList<Integer> preorder(TreeNode root,ArrayList<Integer> res ){
        if(root==null){
            return res;
        }
        res.add(root.data);

        inorder(root.left,res);
        inorder(root.right,res);
        return res;
    }
    public static ArrayList<Integer> postorder(TreeNode root,ArrayList<Integer> res ){
        if(root==null){
            return res;
        }

        inorder(root.left,res);
        inorder(root.right,res);
        res.add(root.data);

        return res;
    }
    //sum of al the nodes int he tree over here
    public static int treesum(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftsum=treesum(root.left);
       int rightsum= treesum(root.right);

        return (leftsum+rightsum+ root.data);

    }
    //number of nodes in the binary tree
    public static int noofNoofNodes(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=noofNoofNodes(root.left);
        int right=noofNoofNodes(root.right);
        return(left+right+1);
    }

    public static TreeNode insertinBST(TreeNode root,int val){
        if(root==null){
            root=new TreeNode(val);
            return root;
        }
        //traverse using temp node
        TreeNode temp=root;
        while(temp!=null){
            if(val<temp.data){
                if(temp.left==null){
                    temp.left=new TreeNode(val);
                    break;

                }
                else {
                    temp=temp.left;;
                }

            }
            else{
                if(temp.right==null){
                    temp.right=new TreeNode(val);
                    break;

                }
                else {
                    temp=temp.right;;
                }
            }
        }
        return root;




    }



}

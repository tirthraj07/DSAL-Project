package utils;

public class AVLTree {

    public int getWeight(Node node){
        if(node == null)
        return 0;
        else
        return node.weight;
    }

    public int getBalanceFactor(Node node){
        if(node == null)
        return 0;
        return(getWeight(node.left) - getWeight(node.right));
    }

    Node rightRotate(Node y){
        Node x = y.left;
        Node xr = x.right;
        x.right = y;
        y.left = xr;

        x.weight = 1 + Math.max(getWeight(x.left), getWeight(x.right));
        y.weight = 1 + Math.max(getWeight(y.left), getWeight(y.right));
        return x;
    }

    Node leftRotate(Node y){
        Node x = y.right;
        Node xl = x.left;
        x.left = y;
        y.right = xl;

        x.weight = 1 + Math.max(getWeight(x.left), getWeight(x.right));
        y.weight = 1 + Math.max(getWeight(y.left), getWeight(y.right));
        return x;
    }



    Node insertNode(Node node, String title, String author, int total){
        if(node==null){
            return(new Node(title,author,total));
        }
        Node newNode = new Node(title,author,total);
        
        if(newNode.isLessThan(node)){
            node.left = insertNode(node.left,title,author,total);
        }
        else if(newNode.isGreaterThan(node)){
            node.right = insertNode(node.right,title,author,total);
        }
        else
        return node;

        node.weight = 1 + Math.max(getWeight(node.left), getWeight(node.right));
        int bf = getBalanceFactor(node);

        //CASE1: LL
        
        if(node.left!=null && newNode.isLessThan(node.left) && bf > 1){
            // System.out.println("LL case");
            return(rightRotate(node));
        }
            

        //CASE2: RR

        if(node.right!=null && newNode.isGreaterThan(node.left) && bf < -1){
            // System.out.println(data+"RR case");
            return(leftRotate(node));
        }

        //CASE3: LR
        
        if(node.left!=null && newNode.isGreaterThan(node.left) && bf > 1){
            // System.out.println("LR case");
            node.left = leftRotate(node.left);
            return(rightRotate(node));
        }

        //CASE4: RL
        
        if(node.right!=null && newNode.isLessThan(node.right) && bf < -1){
            // System.out.println("RL case");
            node.right = rightRotate(node.right);
            return(leftRotate(node));
        }
        return node;
    }

    void inorder(Node node){
        if(node==null)return;
        inorder(node.left);
        System.out.println(node.data + " ");
        inorder(node.right);
    }    
}

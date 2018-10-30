// Given a binary tree and integer value,
// Check if there is a row in the tree that adds
// up to the provided integer value
// Amazon 

/**
target=9

  5
 /  \
2    7
**/

class Node {
    int val;
    Node left;
    Node right;
    
    Node(Integer val) {
        this.val = val;
    }
}

//Input - Node, target, output -boolean
boolean isRowSum(Node root, int target) {
    if(root == null) return false;
    
    Queue<Node> bfsQ = new LinkedList<>();
    Node dummy = new Node(null);
    
    bfsQ.add(root);
    bfsQ.add(dummy);
     
    int level = 0;
    int sum = 0;
    while(!bfsQ.isEmpty()) {
        Node curr = bfsQ.poll();
    
        if(curr.val == null) {
            //Level end
            if(sum == targetSum) {return true;}
            else {sum = 0;}
            level++;
            if(!bfsQ.isEmpty()) bfsQ.add(curr);
        } else {
            sum += current.val;
           if(curr.left != null) bfsQ.add(curr.left);
           if(curr.right != null) bfsQ.add(curr.right); 
        }
    }
    
    return false;
}

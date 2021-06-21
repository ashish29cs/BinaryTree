package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;



	
	



public class SumAtKthLevel {
	 static int sum=0;
	 int sumAtkLevel(Node root,int k)
	{
		if(root==null)
		{
			return -1;
		}
		Queue<Node> q= new LinkedList<>();
		q.add(root);
		q.add(null);
		int level=0;
		
		while(!q.isEmpty())
		{
				Node curr=q.remove();
				if(curr!=null) {
				if(level==k)
				{
					sum+=curr.data;
				}
					  
	             if (curr.left != null)
	                    q.add(curr.left);
	  
	               
	                if (curr.right != null)
	                    q.add(curr.right);
				
			
		}
				else if(!q.isEmpty()) {
					q.add(null);
					level++;
				}
		}
		
		
		return sum;
	}

	 
	 
	 static ArrayList<Integer> arr= new ArrayList<>();
	 static ArrayList <Integer> levelOrder(Node node) 
	    {
	     
	        if(node==null) return  arr;
	        Queue<Node> q= new ArrayDeque<Node>();
	        q.add(node);
	        while(q.size()>0)
	        {
	            Node curr=q.remove();
	            arr.add(curr.data);
	            if(curr.left!=null)
	            {
	               q.add(curr.left);
	            }
	            if(curr.right!=null)
	            {
	                q.add(curr.right);
	            }
	        }
	        return arr;
	    }
	 
	 public int sumOfAllNodes(Node root)
	 {
		 if(root==null)
		 {
			 return 0;
		 }
		 return   sumOfAllNodes(root.left)+sumOfAllNodes(root.right)+root.data;
	 }
	 public int height(Node root)
	 {
		 if(root==null)
		 {
			 return 0;
		 }
		 int lheight=height(root.left);
		 int rheight=height(root.right);
		 return Math.max(lheight, rheight)+1;
	 }
	 
	 public int count(Node root)
	 {
		 if(root==null)
		 {
			 return 0;
		 }
		 
		 return count(root.left)+count(root.right)+1;
	 }
	
	
	
	

	public static void main(String[] args) {
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.left=new Node(6);
		root.right.right=new Node(7);
		root.left.left.left=new Node(8);
		root.left.left.right=new Node(9);
		root.left.right.left=new Node(10);
		root.left.right.right=new Node(11);
		root.right.left.left=new Node(12);
		root.right.left.right=new Node(13);
		root.right.right.left=new Node(14);
		root.right.right.right=new Node(15);
		
		
		SumAtKthLevel ob= new SumAtKthLevel();
		ob.sumAtkLevel(root, 2);
		System.out.println(sum);
		
		
		ob.levelOrder(root);
		System.out.println(arr);
		
		
		System.out.println(ob.sumOfAllNodes(root));
		System.out.println(ob.count(root));
		
		
		System.out.println(ob.height(root));
		
		
		
		
		
		
		
		

	}

}

package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;



	
	



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
	 
	 
	 public int Diameter(Node root)
	 {
		 	if(root==null)
		 	{
		 		return 0;
		 	}
		 	
		 	if(root.left==null && root.right==null)
		 	{
		 		return 1;
		 	}
		 	int lheight=height(root.left);
		 	int rheight=height(root.right);
		 	int currDiameter=lheight+rheight+1;
		 	
		 	int lDiameter=Diameter(root.left);
		 	int rDaimeter=Diameter(root.right);
		 	
		 	return Math.max(currDiameter, Math.max(lDiameter, rDaimeter));
	 }
	 
	 int diameter;
	 public int optimiseDiameter(Node root)
	 {
		 
		 if(root==null)
		 {
			 return 0;
		 }
		 if(root.left==null && root.right==null)
		 	{
		 		return 1;
		 	}
		 
		 int lh=optimiseDiameter(root.left);
		 int rh=optimiseDiameter(root.right);
		 
		 
		 
		 diameter=Math.max(diameter,(lh+rh+1));
		 
		 return Math.max(lh,rh)+1;
	 }
	public int getDifferenceEvenOddValues(Node root)
	{
		if(root==null)
		{
			return 0;
		}
		return root.data-getDifferenceEvenOddValues(root.left)-getDifferenceEvenOddValues(root.right);
	}
	public int getNumberofLeafNode(Node root)
	{
		if(root==null)
		{
			return 0;
		}
		if(root.left==null && root.right==null)
		{
			return 1;
		}
		return getNumberofLeafNode(root.left)+getNumberofLeafNode(root.right);
	}
	public void printValueAtGivenlevel(Node root,int level)
	{
		if(root==null)
		{
			return;
		}
		if(level==1)
		{
			System.out.print(root.data + " ");
			return;
		}
		
		printValueAtGivenlevel(root.left,level-1);
		printValueAtGivenlevel(root.right,level-1);
	}
	
	
	public void reverseLevelOrder(Node root)
	{
		Node node;
		if(root==null)
		{
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		Stack<Node> s = new Stack<>();
		while(q.size()>0)
		{
		node=q.peek();
		q.remove();
		
			if(node.right!=null){
				q.add(node.right);
				
			}
			if(node.left!=null)
			{
				q.add(node.left);
			}
			s.push(node);
		}
		while(s.size()>0)
		{
			node=s.peek();
			System.out.print(node.data +" ");
			s.pop();
			
		}
		
	}
	
	
	void sumReplacement(Node root)
	{
		if(root==null)
		{
			return;
		}
		sumReplacement(root.left);
		sumReplacement(root.right);
		
		
		if(root.left!=null)
		{
			root.data+=root.left.data;
		}

		if(root.right!=null)
		{
			root.data+=root.right.data;
		}

	}
	
	void preorder(Node root)
	{
		if(root==null)
		{
			return;
		}
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	
	
	public void printBoundary(Node node) {
	    if (node != null) {
	      System.out.print(node.data + " ");

	      printBoundaryLeft(node.left);

	      printLeaves(node.left);
	      printLeaves(node.right);

	      printBoundaryRight(node.right);
	    }
	  }
	  
	  public void printBoundaryLeft(Node node) {
	    if (node == null) {
	      return;
	    }

	    if (node.left != null) {
	      System.out.print(node.data + " ");
	      printBoundaryLeft(node.left);
	    } else if (node.right != null) {
	      System.out.print(node.data + " ");
	      printBoundaryLeft(node.right);
	    }
	  }

	  public void printLeaves(Node node) {
	    if (node == null) {
	      return;
	    }

	    printLeaves(node.left);

	    if (node.left == null && node.right == null) {
	      System.out.print(node.data + " ");
	    }
	    printLeaves(node.right);
	  }

	  public void printBoundaryRight(Node node) {
	    if (node == null) {
	      return;
	    }

	    if (node.right != null) {
	      printBoundaryRight(node.right);
	      System.out.print(node.data + " ");
	    } else if (node.left != null) {
	      printBoundaryRight(node.left);
	      System.out.print(node.data + " ");
	    }
	  }
	  
	  
	  public  void printzigzagTraversal(Node root)
	  {
		  Stack<Node> s1=new Stack<Node>();
		  Stack<Node> s2=new Stack<Node>();
		  
		  s1.push(root);
		  while(!s1.isEmpty() || !s2.isEmpty())
		  {
			  while(!s1.isEmpty())
			  {
				  Node tmp=s1.pop();
				  System.out.print(tmp.data +" ");
				  
				  if(tmp.left!=null)
				  {
					  s2.push(tmp.left);
				  }
				  if(tmp.right!=null)
				  {
					  s2.push(tmp.right);
				  }
			  }
			  System.out.println();
			  while(!s2.isEmpty())
			  {
				  Node tmp=s2.pop();
				  System.out.print(tmp.data +" ");
				  
				  if(tmp.right!=null)
				  {
					  s1.push(tmp.right);
				  }
				  if(tmp.left!=null)
				  {
					  s1.push(tmp.left);
				  }
			  }
			  System.out.println();
			  
		  }
		  
	  }
	  
	  
	  public void topView(Node node) {
		    if (node == null) {
		      return;
		    }

		    TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();

		    Queue<Node> q = new LinkedList<Node>();
		    q.add(node);

		    while (!q.isEmpty()) {
		      Node temp = q.remove();
		      int hd = temp.height;
		      
		      if (m.get(hd) == null) {
		        m.put(hd, temp.data);
		      }

		      if (temp.left != null) {
		        temp.left.height = hd - 1;
		        q.add(temp.left);
		      }

		      if (temp.right != null) {
		        temp.right.height = hd + 1;
		        q.add(temp.right);
		      }
		    }
		    System.out.println(m.values());
		  }

	  
	  public void bottomView(Node node) {
		    if (node == null) {
		      return;
		    }

		    TreeMap<Integer, Integer> m = new TreeMap<Integer, Integer>();

		    Queue<Node> q = new LinkedList<Node>();
		    q.add(node);

		    while (!q.isEmpty()) {
		      Node temp = q.remove();
		      int hd = temp.height;
		      
		      m.put(hd, temp.data);
		  
		      if (temp.left != null) {
		        temp.left.height = hd - 1;
		        q.add(temp.left);
		      }

		      if (temp.right != null) {
		        temp.right.height = hd + 1;
		        q.add(temp.right);
		      }
		    }
		    System.out.println(m.values());
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
		
		ob.topView(root);
		
		ob.bottomView(root);
		
		
		System.out.println(ob.sumOfAllNodes(root));
		System.out.println(ob.count(root));
		
		
		System.out.println(ob.height(root));
		
		
		System.out.println(ob.Diameter(root));
		
		
		
		
		ob.optimiseDiameter(root);
		System.out.println(ob.diameter);
		
		System.out.println(ob.getDifferenceEvenOddValues(root));
		
		
		System.out.println(ob.getNumberofLeafNode(root));
		
		ob.printValueAtGivenlevel(root,3);
		
		
		ob.reverseLevelOrder(root);
		
		System.out.println();
		
		ob.preorder(root);
		System.out.println();
		ob.sumReplacement(root);
		ob.preorder(root);
		System.out.println();
		
		
		ob.printBoundary(root);
		System.out.println();
		
		
		
		ob.printzigzagTraversal(root);
		
		System.out.println();
		
		

	}

}

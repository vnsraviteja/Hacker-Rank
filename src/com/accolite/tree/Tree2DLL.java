package com.accolite.tree;

public class Tree2DLL {
	
	static BinarySearchTree prev = null,head=null;
	public static void main(String [] args) {
		int [] input = {1,2,3,4,5,6,7,8};
		Itree t = new BinarySearchTree(input);
		bst2dll((BinarySearchTree) t);
		while(head != null) {
			System.out.println(head.value);
			head = (BinarySearchTree) head.right;
		}
	}

	public static void bst2dll(BinarySearchTree t) {
		if(t==null){
			return ;
		}else {
			bst2dll((BinarySearchTree) t.left);
			if(prev == null) {
				head = t;
			}
			if(prev !=null) {		
				prev.right = t;
			}
			t.left = prev;
			prev = t;
			bst2dll((BinarySearchTree) t.right);
		}
		return ;
	}
}

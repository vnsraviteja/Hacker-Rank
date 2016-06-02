package com.accolite.tree.testing;

import com.accolite.tree.BinarySearchTree;
import com.accolite.tree.Itree;

public class LCA_BST {
	public static boolean a_present=false, b_present=false;
	public static void main(String [] args) {
		int [] input = {2,1,6,3,4,8,9,10,7,5};
		BinarySearchTree bst = new BinarySearchTree(input);
		BinarySearchTree ancestor = (BinarySearchTree)lca(bst,5,9);
		System.out.println(ancestor.getValue());
	}
	
	public static BinarySearchTree lca(BinarySearchTree bst,int a, int b) {
		if(bst == null) {
			return null;
		}
		Itree left = lca((BinarySearchTree) bst.getLeft(),a,b);
		Itree right= lca((BinarySearchTree) bst.getRight(),a,b);
		if(bst.getValue() == a) {
			a_present = true;
			return bst;
		}
		if(bst.getValue() == b) {
			b_present = true;
			return bst;
		}
		if(left !=null && right !=null) {
			return bst;
		}
		else {
			return (BinarySearchTree) (left == null? right: left);
		}
	}

}

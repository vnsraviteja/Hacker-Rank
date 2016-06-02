package com.accolite.tree.testing;

import com.accolite.tree.BinarySearchTree;
import com.accolite.tree.testing.LCA_BST;

public class LargestBst {
	
	private static BinarySearchTree prev = null,start = null,root = null,max_bst=null;
	private static int count = 0;
	private static int max_count = 0;
	public static void main(String [] args) {
		int [] input1 = {5,1,2,4,3,9,7,6,11,10};
		BinarySearchTree a = new BinarySearchTree(input1);
		root = a;
		solution(a);
		if(max_bst!=null){
			max_bst.print(max_bst);
		}
	}
	
	public static void solution(BinarySearchTree bst) {
		if(bst == null) {
			if(prev!=null) {
				if(count>max_count) {
					max_count = count ;
					max_bst = LCA_BST.lca(root,start.getValue(),prev.getValue());
				}
			}
			return ;
		}
		else {
			solution((BinarySearchTree) bst.getLeft());
			if(prev!=null) {
				if(prev.getValue()>=bst.getValue()){
					if(count>max_count){
						max_count = count ;
						max_bst = LCA_BST.lca(root,start.getValue(),prev.getValue());
						start = bst;
						count = 1;
					}
				}
				else {
					count++;
				}
				prev = bst;
				solution((BinarySearchTree) bst.getRight());
				
			}
			else {
				prev = bst;
				start = prev;
				count = 1;
				solution((BinarySearchTree) bst.getRight());
			}
		}
	}
	
	
}

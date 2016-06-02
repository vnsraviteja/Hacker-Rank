package com.accolite.tree.testing;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.accolite.tree.BinarySearchTree;
import com.accolite.tree.Itree;
import com.accolite.tree.testing.CreateBSTWithPrePostInOrder;;

public class IsBst {
	public static BinarySearchTree prev = null;
	public static int maxLevel = -1;
	public static Map<Integer,Integer> m = new TreeMap<Integer,Integer>();
	
	public static void main(String [] args) {
		int [] preOrderArr = {6,3,2,1,0,-14,5,9,8,7,10,11,12};
		Itree tree = CreateBSTWithPrePostInOrder.preOrder(preOrderArr,Integer.MIN_VALUE,Integer.MAX_VALUE);
		topView((BinarySearchTree) tree,0);
		Iterator itr = m.entrySet().iterator();
		while(itr.hasNext()) {
			Entry e=(Entry)itr.next();
			System.out.println(e.getValue());
		}
	}
	
	public static boolean isBst(BinarySearchTree root) {
		if(root == null) {
			return true;
		}
		else {
			boolean left = isBst((BinarySearchTree) root.getLeft());
			if(left == false ) 
				return false;
			else {
				if(prev != null && prev.getValue() < root.getValue()) {
					prev = root;
					return isBst((BinarySearchTree) root.getRight()); 
				}
				else if(prev != null && prev.getValue() >= root.getValue()){
					return false;
				}
				else {
					prev = root;
					return isBst((BinarySearchTree) root.getRight());
				}
			}
		}
	}

	public static void leftView(BinarySearchTree root,int level) {
		if(root== null) {
			return ;
		}
		if(level > maxLevel) {
			maxLevel = level;
			System.out.println(root.getValue());
		}
		leftView((BinarySearchTree) root.getLeft(),level+1);
		leftView((BinarySearchTree) root.getRight(),level+1);
	}
	
	public static void rightView(BinarySearchTree root,int level) {
		if(root== null) {
			return ;
		}
		if(level > maxLevel) {
			maxLevel = level;
			System.out.println(root.getValue());
		}
		rightView((BinarySearchTree) root.getRight(),level+1);
		rightView((BinarySearchTree) root.getLeft(),level+1);
	}

	public static void topView(BinarySearchTree root,int width) {	
		if(root == null) {
			return;
		}
		else {
			topView((BinarySearchTree) root.getLeft(),width-1);
			topView((BinarySearchTree) root.getRight(),width+1);
			m.put(width, root.getValue());
		}
	}
	

}

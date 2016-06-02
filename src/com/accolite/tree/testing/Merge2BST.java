package com.accolite.tree.testing;

import java.util.Stack;

import com.accolite.tree.BinarySearchTree;

public class Merge2BST {
	public static void main(String[] args) {
		int [] input1 = {1,2,3,4,5,7,9,11};
		int [] input2 = {2,10};
		BinarySearchTree a = new BinarySearchTree(input1);
		BinarySearchTree b = new BinarySearchTree(input2);
		merge2Bst(a,b);
	}
	
	public static void merge2Bst(BinarySearchTree a, BinarySearchTree b){
		Stack<BinarySearchTree> a_stack = new Stack<BinarySearchTree>();
		Stack<BinarySearchTree> b_stack = new Stack<BinarySearchTree>();
		a_stack.push(a);
		b_stack.push(b);
		stackify(a_stack);
		stackify(b_stack);
		while(!a_stack.isEmpty() || !b_stack.isEmpty()) {
			if(!a_stack.isEmpty()){
				if(!b_stack.isEmpty()) {
					if(a_stack.peek().getValue() < b_stack.peek().getValue()) {
						System.out.println(a_stack.peek().getValue());
						if(a_stack.peek().getRight() != null) {
							BinarySearchTree right = (BinarySearchTree) a_stack.pop().getRight();
							a_stack.push(right);
							stackify(a_stack);
						}
						else {
							a_stack.pop();
						}
					}
					else {
						System.out.println(b_stack.peek().getValue());
						if(b_stack.peek().getRight() != null) {
							BinarySearchTree right = (BinarySearchTree) b_stack.pop().getRight();
							b_stack.push(right);
							stackify(b_stack);
						}
						else {
							b_stack.pop();
						}
					}
				}
				else {
					IterativeInorderPart(a_stack);
				}
			}
			else {
				IterativeInorderPart(b_stack);
			}
		}
	}
	
	public static void stackify(Stack<BinarySearchTree> s) {
		if(!s.isEmpty()) {
			while(s.peek().getLeft() != null) {
				s.push((BinarySearchTree) s.peek().getLeft());
			}
		}
	}
	
	public static void IterativeInorderPart(Stack<BinarySearchTree> s) {
		while(!s.isEmpty()) {
			if(s.peek().getRight() != null) {
				System.out.println(s.peek().getValue());
				BinarySearchTree right = (BinarySearchTree) s.pop().getRight();
				s.push(right);
				stackify(s);
			}
			else {
				System.out.println(s.pop().getValue());
			}
		}
	}
}

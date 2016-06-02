package com.accolite.tree.testing;

import java.util.Stack;

import com.accolite.tree.BinarySearchTree;
import com.accolite.tree.Itree;

public class CreateBSTWithPrePostInOrder {

	public static int preOrderIndex =0;
	public static int postOrderIndex;
	public static int [] postOrderArray;
	
	public static void main(String [] args) {
		int [] inOrderArr = {0,1,2,3,4,5,6,7,8,9};
		int [] preOrderArr = {6,3,2,1,4,5,9,8,7,10,11};
//		Itree i = createBstInorder(arr);
//		i.print(i);
//		Itree i=preOrder(preOrderArr,Integer.MIN_VALUE,Integer.MAX_VALUE);
//		preOrderIndex = 0;
//		postOrderIndex = postOrderArr.length -1;
//		Itree i=postOrder(postOrderArr,Integer.MIN_VALUE,Integer.MAX_VALUE);
//		i.print(i);
//		postOrderArray = new int[preOrderArr.length];
//		postOrderArray = preOrderToPostOrder(preOrderArr,0,preOrderArr.length-1);
//		System.out.println(postOrderArray.length);
	}
	
	public static Itree createBstInorder(int [] input) {
		Itree tree = null;
		if(input.length > 0) {
			tree = inorderTopDown(input,0,input.length-1);
		}
		return tree;	
	}
	
	public static Itree inorderTopDown(int [] input,int s,int e) {
		BinarySearchTree bst = new BinarySearchTree();
		int mid = (s+e)/2;
		if(s == e) {
			bst.setValue(input[s]);
			return bst;
		}
		else if(s>e) {
			return null;
		}
		else {
			bst.setLeft(inorderTopDown(input,s,mid-1));
			bst.setValue(input[mid]);
			bst.setRight(inorderTopDown(input,mid+1,e));
			return bst;
		}	
	}
	
	public static Itree preOrder(int [] input,int min,int max) {
		if(preOrderIndex < input.length) {
			if(input[preOrderIndex] < max && input[preOrderIndex] > min) {
				BinarySearchTree bst = new BinarySearchTree();
				bst.setValue(input[preOrderIndex]);
				preOrderIndex++;
				bst.setLeft(preOrder(input,min,bst.getValue()));
				bst.setRight(preOrder(input,bst.getValue(),max));
				return bst;
			}
			else return null;
		}
		else return null;
	}
	
	public static Itree postOrder(int [] input,int min,int max) {
		if(postOrderIndex>-1) {
			if(input[postOrderIndex] < max && input[postOrderIndex] > min) {
				BinarySearchTree bst = new BinarySearchTree();
				bst.setValue(input[postOrderIndex]);
				postOrderIndex--;
				bst.setRight(postOrder(input,bst.getValue(),max));
				bst.setLeft(postOrder(input,min,bst.getValue()));
				return bst;
			}
			else return null;
		}
		return null;
	}

	public static int [] preOrderToPostOrderIncomplete(int [] preOrder) {
		Stack<Integer> s = new Stack<Integer>();
		int [] postOrder = new int[preOrder.length];
		int postOrderIndex=0;
		s.push(Integer.MAX_VALUE);
		int preOrderIndex = 0;
		int max=0,min =0;
		while(preOrderIndex < preOrder.length) {
			if(s.peek() > preOrder[preOrderIndex]) {
				max = s.peek();
				s.push(preOrder[preOrderIndex++]);
			}
			else {
				int temp = s.pop();
				while(max>preOrder[preOrderIndex] ) {
					postOrder[postOrderIndex++] = temp;
					temp = s.pop();
				}
				s.push(temp);
				s.push( preOrder[preOrderIndex++]);
			}
		}
		while(s.size() != 1) {
			postOrder[postOrderIndex++] = s.pop();
		}
		return postOrder;
	}
	
	public static int [] preOrderToPostOrder(int [] preOrder,int s,int e) {
		if(s==e) {
			postOrderArray[postOrderIndex++] = preOrder[s];
			return postOrderArray;
		}
		else if(s>e) {
			return null;
		}
		int pivot = binarySearchPreOrder(preOrder,s+1,e,preOrder[s]);
		preOrderToPostOrder(preOrder,s+1,pivot);
		preOrderToPostOrder(preOrder,pivot+1,e);
		postOrderArray[postOrderIndex++] = preOrder[s];
		return postOrderArray;
	}
	
	public static int binarySearchPreOrder(int [] input, int start,int end,int key) {
		int mid = (start+end)/2;
		if(end-start>1) {
			if(input[mid]<key && input[mid+1]>key) {
				return mid;
			}
			else if(input[mid]<key) {
				return binarySearchPreOrder(input,mid+1,end,key);
			}
			else {
				return binarySearchPreOrder(input,start,mid-1,key);
			}
		}
		else {
			if(input[start]<key && input[end] >key) {
				return start;
			}
			else if(input[start]<key && input[end]<key) {
				return end;
			}
			else 
				return start-1;
		}
	}
	

}

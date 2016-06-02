package com.accolite.tree.testing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.accolite.tree.BinarySearchTree;

public class topView {
	public static void main(String [] args) {
		int [] arr = {6,3,2,1,4,5,9,7,8,10};
		BinarySearchTree bst = new BinarySearchTree(arr);
		top_view(bst);
	}
	
	
	public static void top_view(BinarySearchTree bst) {
		Map<Integer,queueItem> m = new HashMap();
		List<queueItem> l = new LinkedList();
		queueItem temp = new queueItem(bst,0);
		l.add(temp);
		while(!l.isEmpty()){
			temp = l.remove(0);
			queueItem b = m.get(temp.hd);
			if(b == null) {
				m.put(temp.hd, temp);
			}
			if(temp.b.getLeft()!=null) {
				l.add(new queueItem((BinarySearchTree) temp.b.getLeft(),temp.hd-1));
			}
			if(temp.b.getRight()!=null) {
				l.add(new queueItem((BinarySearchTree) temp.b.getRight(),temp.hd+1));
			}
		}
		
		Iterator itr = m.values().iterator();
		while(itr.hasNext()) {
			temp = (queueItem) itr.next();
			System.out.print(temp.b.getValue()+ "  ");
			
		}
		System.out.println();
	}

}
class queueItem {
	BinarySearchTree b;
	int hd;
	
	public queueItem(BinarySearchTree b, int hd) {
		super();
		this.b = b;
		this.hd = hd;
	}

	
}
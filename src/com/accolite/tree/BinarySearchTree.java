package com.accolite.tree;

public class BinarySearchTree extends BinaryTree {

	Integer value;
	Itree parent;
	Itree left, right;

	
	public BinarySearchTree() {
		super();
		
	}
	
	public BinarySearchTree(int [] input) {
		super();
		this.value = input[0];
		this.left = null;
		this.right = null;
		this.parent = null;
		for(int i = 1; i<input.length; i++) {
			this.add(this, input[i]);
		}
	}

	@Override
	public void add(Itree t, Integer o) {
		if (t == null) {
			BinarySearchTree bst = new BinarySearchTree();
			bst.value = o;
			bst.parent = null;
			bst.left = null;
			bst.right = null;
			t = bst;
		} else {
			while (true) {
				BinarySearchTree bst = (BinarySearchTree) t;
				if (bst.value < o) {
					if (bst.right != null) {
						t = bst.right;
					} else {
						BinarySearchTree temp = new BinarySearchTree();
						temp.value = o;
						temp.left = null;
						temp.right = null;
						temp.parent = bst;
						bst.right = temp;
						break;
					}

				} else if (bst.value > 0) {
					if (bst.left != null) {
						t = bst.left;
					} else {
						BinarySearchTree temp = new BinarySearchTree();
						temp.value = o;
						temp.left = null;
						temp.right = null;
						temp.parent = bst;
						bst.left = temp;
						break;
					}
				}
			}
		}
	}

	@Override
	public void print(Itree t) {
		if(t == null) { 
			return;
		}
		else {
			BinarySearchTree bst = (BinarySearchTree) t;
			print(bst.left);
			System.out.println(bst.value );
			print(bst.right);
		}
	}

	@Override
	public Itree search(Itree t, Integer o) {
		while (true && t != null) {
			BinarySearchTree bst = (BinarySearchTree) t;
			if (bst.value < o) {
				if (bst.right != null) {
					t = bst.right;
				} else {
					return null;
				}

			} else if (bst.value > 0) {
				if (bst.left != null) {
					t = bst.left;
				} else {
					return null;
				}
			}
			else {
				return bst;
			}
		}
		return t;
	}

	@Override
	public void delete(Itree t, Integer o) {
		BinarySearchTree s = (BinarySearchTree) search(t,o);
		if(s.right == null) {
			
		}
	}

	public Itree successor(Itree t, Integer o) {
		Itree s = search(t,o) ;
		BinarySearchTree temp = null;
		BinarySearchTree bst = null;
		if(s != null) {
			bst = (BinarySearchTree) s;
			if(bst.right !=  null) {
				temp = (BinarySearchTree) bst.right;
				while(temp.left != null) {
					temp = (BinarySearchTree) temp.left; 
				}
			}
			else {
				while(true) {
					bst = (BinarySearchTree) t;
					if(bst.value > o) {
						temp = bst;
						t = bst.left;
					}
					else if(bst.value < o) {
						t = bst.right;
						continue;
					}
					else {
						break;
					}
					
				}
			}
		}
		return temp;			
	}
	
	public Itree predecessor(Itree t, Integer o) {
		Itree s = search(t,o) ;
		BinarySearchTree temp = null;
		BinarySearchTree bst = null;
		if(s != null) {
			bst = (BinarySearchTree) s;
			if(bst.left !=  null) {
				temp = (BinarySearchTree) bst.left;
				while(temp.right != null) {
					temp = (BinarySearchTree) temp.right; 
				}
			}
			else {
				while(true) {
					bst = (BinarySearchTree) t;
					if(bst.value > o) {
						t = bst.left;
						continue;
					}
					else if(bst.value < o) {
						temp = bst;
						t = bst.right;
					}
					else {
						break;
					}
				}
			}
		}
		return temp;			
	}
	
	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Itree getLeft() {
		return left;
	}

	public void setLeft(Itree left) {
		this.left = left;
	}

	public Itree getRight() {
		return right;
	}

	public void setRight(Itree right) {
		this.right = right;
	}

}

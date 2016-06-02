package com.accolite.tree;

public interface Itree {
	public void add(Itree t,Integer o);
	public void print(Itree t);
	public Itree search(Itree t,Integer o);
	public void delete(Itree t,Integer o);
	public Itree successor(Itree t,Integer i);
	public Itree predecessor(Itree t,Integer i);
}

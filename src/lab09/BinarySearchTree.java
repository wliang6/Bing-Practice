package lab09;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
	
	public class _Node{
		private Integer value;
		private _Node leftChild;
		private _Node rightChild;
		
		public _Node(Integer v){
			value = v;
		}
	}

	private _Node root;
	List<Integer> list = new ArrayList<Integer>(); 
	
	public void insert(int i) {
		_Node newNode = new _Node(i);
		if(root == null){
			root = newNode; 
		}
		else{
			insertHere(root, newNode);
		}
	}
	
	public void insertHere(_Node root, _Node newNode){
		_Node current = root;
		if(newNode.value < current.value){
			if(current.leftChild == null){
				current.leftChild = newNode;
			}
			insertHere(current.leftChild, newNode);
		}
		if(newNode.value > current.value){
			if(current.rightChild == null){
				current.rightChild = newNode;
			}
			insertHere(current.rightChild, newNode);
		}
	}


	public Integer find(int i) {
		_Node n = findNode(root, i);
		if(n == null) return null;
		return n.value;
	}
	
	private _Node findNode(_Node root, int i){
		_Node current = root;
		if(i < current.value){
			if(current.leftChild == null){
				return null;
			}
			return findNode(current.leftChild, i);
		}
		if(i > current.value){
			if(current.rightChild == null){
				return null;
			}
			return findNode(current.rightChild, i);
		}
		return root;
	}


	public List<Integer> getElems() {
		inOrderTraversal(root);
		return list;
	}
	
	private void inOrderTraversal(_Node root){
		if(root.leftChild != null){
			inOrderTraversal(root.leftChild);
		}
		list.add(root.value);
		if(root.rightChild != null){
			inOrderTraversal(root.rightChild);
		}
	}

}

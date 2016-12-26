package assignment08;


public class IntLinkedList {

	private Node head;
	private Node last;

	private class Node{
		private int i;
		private Node next;
	}

	public void startList(int i){
		if(head != null){
			throw new RuntimeException("List already created");
		}
		head = new Node();
		head.i = i;
		last = head;
	}

	public void appendList(int i){
		if(head == null){
			throw new RuntimeException("Must create list");
		}
		last.next = new Node();
		last = last.next;
		last.i = i;
	}

	public void remove(int i){
		if(head == null){
			throw new RuntimeException("List is empty");
		}
		Node temp = head;
		if(temp.i == i){
			head = head.next;
		} 
		while(temp.next != null && temp.next.next != null){
			if(temp.next.i == i){
				temp.next = temp.next.next;	
			}
			temp = temp.next;
		}
		if(last.i == i){
			last = temp;
			last.next = null;
		}	
	}
	
	@Override
	public String toString(){
		if(head == null) return "[]";
		StringBuffer sb = new StringBuffer("[");
		Node temp = head;
		sb.append(head.i);
		temp = temp.next;
		while(true){
			if(temp == null){
				sb.append("]");
				return sb.toString();
			}else{
				sb.append(", ");
				sb.append(temp.i);
				temp = temp.next;
			}
		}
	}
	
	
	
	public static void main(String[] args){
		IntLinkedList primes = new IntLinkedList();
		primes.startList(2);
		for(int i = 3; i <= 1000; i++){
			primes.appendList(i);
		}
		Node nextPrime = primes.head;
		System.out.print("[");
		try{
			while(true){
				System.out.print(nextPrime.i);
				Node temp = nextPrime;
				while(temp != null && temp.next != null){
					if(isMultiple(temp.next.i, nextPrime.i)){
						temp.next = temp.next.next;
					}
					temp = temp.next;
				}
				nextPrime = nextPrime.next;
				if(nextPrime != null){
					System.out.print(", ");
				}
			}
		} catch(RuntimeException e){
			System.out.print("]");
		}
	}


	private static boolean isMultiple(int n, int divisor) {
		if(n % divisor == 0) return true;
		else{ 
			return false; 
		}
	}
}



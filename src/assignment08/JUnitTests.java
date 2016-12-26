package assignment08;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTests {
	
	
	@Test public void test1(){
		IntLinkedList list = new IntLinkedList();
		assertEquals("[]", list.toString());
	}

	@Test public void test2(){  
		IntLinkedList list = new IntLinkedList();
		list.startList(1);
		list.appendList(2);
		list.appendList(3);
		assertEquals("[1, 2, 3]", list.toString()); 
	}
	
	@Test public void test3(){   //remove from beginning
		IntLinkedList list = new IntLinkedList();
		list.startList(1);
		list.appendList(5);
		list.appendList(4);
		list.appendList(9);
		list.remove(1);
		assertEquals("[5, 4, 9]", list.toString());
	}
	
	@Test public void test4(){   //remove from middle
		IntLinkedList list = new IntLinkedList();
		list.startList(100);
		list.appendList(25);
		list.appendList(5);
		list.appendList(10);
		list.remove(5);
		assertEquals("[100, 25, 10]", list.toString());
	}
	
	@Test public void test5(){   //remove from end
		IntLinkedList list = new IntLinkedList();
		list.startList(5);
		list.appendList(3);
		list.appendList(2);
		list.appendList(0);
		list.remove(0);
		assertEquals("[5, 3, 2]", list.toString());
	}
	
	
	@Test public void test6(){
		IntLinkedList list = new IntLinkedList();
		list.startList(1);
		list.remove(1);
		assertEquals("[]", list.toString());
	}
	
	
	
	
	
	
	
	
	
	@Test public void test01(){
		IntLinkedList2 list = new IntLinkedList2();
		assertEquals("[]", list.toString());
	}

	@Test public void test02(){  
		IntLinkedList2 list = new IntLinkedList2();
		list.startList(1);
		list.appendList(2);
		list.appendList(3);
		assertEquals("[1, 2, 3]", list.toString()); 
	}
	
	@Test public void test03(){   //remove from beginning
		IntLinkedList2 list = new IntLinkedList2();
		list.startList(1);
		list.appendList(5);
		list.appendList(4);
		list.appendList(9);
		list.remove(1);
		assertEquals("[5, 4, 9]", list.toString());
	}
	
	@Test public void test04(){   //remove from middle
		IntLinkedList2 list = new IntLinkedList2();
		list.startList(100);
		list.appendList(25);
		list.appendList(5);
		list.appendList(10);
		list.remove(5);
		assertEquals("[100, 25, 10]", list.toString());
	}
	
	@Test public void test05(){   //remove from end
		IntLinkedList2 list = new IntLinkedList2();
		list.startList(5);
		list.appendList(3);
		list.appendList(2);
		list.appendList(0);
		list.remove(0);
		assertEquals("[5, 3, 2]", list.toString());
	}
	
	
	@Test public void test06(){
		IntLinkedList2 list = new IntLinkedList2();
		list.startList(1);
		list.remove(1);
		assertEquals("[]", list.toString());
	}
}

package org.elsysbg.ip.java;

public class ControlFlowStatements {

	public static void main(String[] args) {
		// in eclipse select statements that should be extracted in methods
		// then press Ctrl+1
		// type "methodname();", mark it and then Ctrl+1 and select create method
		ifExample();
		forExample();
	}

	private static void forExample() {
		for(int i =0; i < 10; i++) {
			System.out.println(i);
		}
		
	}

	private static void ifExample() {
		if(true) {
			System.out.println("called");
		}
		if(1 > 2) {
			System.out.println("not called");
		} else {
			System.out.println("called");
		}
	}

}

package sla.manager.domain;

import java.util.UUID;

public class RandUUID {
	
	public static void main(String[] args) {
	
		// random UUID gen
		System.out.println("Random UUID: event =" + UUID.randomUUID());
		System.out.println("Random UUID: corrID=" + UUID.randomUUID());
		
//		UUID uid = UUID.fromString("030625e2-40b8-4fae-9a51-1699978ff5e0");
//		System.out.println(uid);
	}
}

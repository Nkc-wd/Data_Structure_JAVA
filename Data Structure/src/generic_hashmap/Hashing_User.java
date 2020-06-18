package generic_hashmap;

public class Hashing_User {

	public static void main(String[] args) throws Exception {
		Hashing<String, Integer> map = new Hashing<>(3);
		map.put("USA", 200);
		map.put("UK", 175);
		map.put("India", 300);
		map.put("China", 350);

		map.put("Sweden", 100);
		 map.display();
	

		map.put("nepal", 400);
		 map.display();
		 map.put("ire", 500);
		 map.display();

		// map.display();

		

	}

}

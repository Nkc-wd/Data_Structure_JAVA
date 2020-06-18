package generic_hashmap;

import java.util.*;

public class Hash_demo {

	public static void main(String[] args) {
		
		HashMap<String, Integer> map = new HashMap<>();

		map.put("USA", 200);
		map.put("UK", 175);
		map.put("India", 300);
		map.put("China", 350);
		System.out.println(map);

		System.out.println(map.get("India"));
		
		System.out.println(map.containsKey("USA"));
		
		System.out.println(map.containsValue(200));
		
		// Note: Remember don't use new after assignment of keyset and values 
		
		System.out.println("********keys******");
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(key);
		}
		System.out.println("********Values******");
		Collection<Integer> values = map.values();
		for (Integer value : values) {
			System.out.println(value);
		}

		System.out.println("********EntrySet*******");          // Set take only arguments <> 
		Set<Map.Entry<String, Integer>> entries = map.entrySet();   // To use both argument of keys and values need manipulation 
		for (Map.Entry<String, Integer> entry : entries) {
			System.out.println(entry.getKey() + "=>" + entry.getValue());
		}
		
	}

}

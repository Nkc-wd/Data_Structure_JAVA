package generic_hashmap;


public class Hashing<K,V> {
	   
      private class HTPair{  // HTpair class
    	          K key; // K type
    	          V value;  // V type
    	          
    	          HTPair(K key,V value){ // HTPair constructor
    	        	  this.key=key;
    	        	  this.value=value;
    	          }
    	          
    	          public boolean equals(Object op) { // for equals check
    	        	  HTPair other=(HTPair) op;
    	        	  return this.key.equals(other.key);
    	          }
    	          
    	          public String toString() { // to String 
    	        	  return "{ "+this.key+" - "+this.value+"}";
    	          }
      }
      
      public static final int DEFAULT_CAPACITY=10; // Hashtable default capacity
      public int size; // size
      
      LinkedList<HTPair>[] bucketArray; // Array of LinkedList 
      
      public Hashing() {    // default capacity Hashing constructor
  		this(DEFAULT_CAPACITY);
  	}

	public Hashing(int capacity) {  // for user given capacity Hashing constructor
		
		this.bucketArray=(LinkedList<HTPair>[]) new LinkedList[capacity];
		this.size=0;
		
	}
	
	public void put (K key,V value) throws Exception {
		int bi=hashFunction(key); // base index find
		LinkedList<HTPair> bucket=this.bucketArray[bi]; // pass in that array of LL
		HTPair pta=new HTPair(key,value); // new HTpair create
		
		if(bucket==null) { // if null
			bucket=new LinkedList<>(); // then make a new LL
			bucket.addLast(pta);  // Add pair in Last of LL
			this.bucketArray[bi]=bucket; // Add that LL in bucket Array base index
			this.size++;   // After add size need to increment
		}else {
			
			int findAt= bucket.find(pta);// find by generic LL
			if(findAt==-1) {  // if not find
				bucket.addLast(pta); // then add
				this.size++;
			}else {
				HTPair pair=bucket.getAt(findAt); // else 
				pair.value=value;
			}
			// lambda for rehasing as load factor
			double lambda=(this.size*1.0)/this.bucketArray.length;
			if(lambda>2) {
				rehash();
			}
			
			
		}
	}
	
	

	public V get(K key) throws Exception {  // for get value we need key 
		int bi = hashFunction(key); // base index 
		LinkedList<HTPair> bucket = this.bucketArray[bi]; // get bucket at that index
		HTPair ptf = new HTPair(key, null);

		if (bucket == null) { // if bucket is null
			return null;
		} else {
			int findAt = bucket.find(ptf); // if on find 
			if (findAt == -1) {  // not find then return null
				return null;
			} else {
				HTPair pair = bucket.getAt(findAt); // if found
				return pair.value;  // return that value
			}

		}
	}
	
	public V remove(K key) throws Exception { // for remove we need key
		int bi = hashFunction(key); // base index
		LinkedList<HTPair> bucket = this.bucketArray[bi]; // get bucket at that index
		HTPair ptf = new HTPair(key, null); // Pair create

		if (bucket == null) {  // if bucket null
			return null;
		} else {
			int findAt = bucket.find(ptf); // else find
			if (findAt == -1) {  // if not found
				return null;    // null
			} else {
				HTPair pair = bucket.getAt(findAt); //found
				bucket.removeAt(findAt);// remove by linkedlist remove At
				this.size--;   // size need to decrement
				return pair.value;  // return that key value 
			}

		}
	}
	private void rehash() throws Exception {  // rehash method
		LinkedList<HTPair>[] oba = this.bucketArray;  // old bucket array
		this.bucketArray = (LinkedList<HTPair>[]) new LinkedList[2 * oba.length]; // size of this will be double of oba
		this.size = 0; // size 0 has no Pair
		for (LinkedList<HTPair> ob : oba) {  // get old bucket
			while(ob!=null && !ob.isEmpty()) {  // while ob is not null
				HTPair pair=ob.removeFirst(); // remove first pair
				this.put(pair.key, pair.value); // and put in rehash array
			}
		}
		
	}


	private int hashFunction(K key) {
		int hc=key.hashCode(); // Hashcode generate as integer
		hc=Math.abs(hc); // convert in absolute
		int bi=hc%this.bucketArray.length; // base index in array of linkedlist
		return bi;
		
	}
	
	public void display() throws Exception {
		for (LinkedList<HTPair> bucket:this.bucketArray) {
			if (bucket != null && !bucket.isEmpty()) { // if not empty and null 
				bucket.display();  // then display
			}else {
				System.out.println("null"); // otherwise  print null
				System.out.println("***********************");
			}
		}
		System.out.println("==================");
		
	}
	
	
}










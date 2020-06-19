**What is Set in java ?**

>> Set is an interface which extends Collection.

   It is an unordered collection of objects in which duplicate values cannot be stored.
 
>> Basically, Set is implemented by HashSet, LinkedHashSet or TreeSet (sorted representation).

>> Set has various methods to add, remove clear, size, etc to enhance the usage of this interface 

**Simple Implementation**

Set<String> hash_Set = new HashSet<String>(); 


**HashMap**

Java HashMap class implements the Map interface which allows us to store key and value pair, where keys should be unique.

key and value is type of generic.

It is easy to perform operations using the key index like updation,

 deletion, etc. HashMap class is found in the java.util package.

* It inherits the AbstractMap class and implements the Map interface.

Java HashMap contains values based on the key.

**Java HashMap contains only unique keys**

Java HashMap may have one null key and multiple null values.

Java HashMap is non synchronized.

**Java HashMap maintains no order.**

The initial default capacity of Java HashMap class is 16 with a load factor of 0.75.


**Methods of Java HashMap class**

**V put(Object key, Object value) ==>	It is used to insert an entry in the map.**

**V remove(Object key) ==>	It is used to delete an entry for the specified key.**

**V get(Object key) ==>	This method returns the object that contains the value associated with the key.**

**V put(Object key, Object value) ==>	It is used to insert an entry in the map as update also**

V replace(K key, V value) ==>	It replaces the specified value for a specified key.

void clear() ==>	It is used to remove all of the mappings from this map.

int size() ==>	This method returns the number of entries in the map.

boolean containsValue(Object value) ==>	This method returns true if some value equal to the value exists within the map, else return false.

**boolean containsKey(Object key) ==>	This method returns true if some key equal to the key exists within the map, else return false.**

**Set keySet() ==>	It is used to return a set view of the keys contained in this map.**

**Collection<V> values() ==>	It returns a collection view of the values contained in the map.**

**Set entrySet() ==>	It is used to return a collection view of the mappings contained in this map.**

As **Set<Map.Entry<String, Integer>> entries = map.entrySet();**



























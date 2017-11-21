# These are the Answers
## Ensminger-Lorentz

Try using a TreeMap and a HashMap instead of MyHashMap.
  Are the resulting word frequencies any different?
  No they aren't
  Is the time performance any different? If so, how would you rank the three implementations (in increasing order of time complexity)?'
  Yes
  MyHashMap average 654ms
  HashMap average 769ms
  TreeMap average 814ms
How are % and Math.floorMod different? Which works more reliably for computing a hash table index?
   % finds the direct mod without rounding
   Math.floorMod find the mod with rounding down
   Math.floorMod is more reliable for a hashtable
What is the time complexity of MyHashMap.size(), and how could you make it much more efficient?
   It is O(n)
   You could make size an instance variable and increment the value as you add items to the hashmap
How does this implementation compare to one where you would directly use your linked Node class from the earlier assignment? Answer briefly in terms of ease of implementation, correctness, reliability, and performance.
   implementation
      The linked nodes are easier to implement
   correctness
      They are the same level of correctness or negligibly different
   reliability
      They are both reliable implementations
   performance
      While MyHashMap is more implementation, it does offer a performance boost. 

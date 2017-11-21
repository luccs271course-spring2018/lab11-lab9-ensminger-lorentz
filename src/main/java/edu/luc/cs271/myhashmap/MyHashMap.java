package edu.luc.cs271.myhashmap;

import java.util.*;

/**
 * A generic HashMap custom implementation using chaining. Concretely, the table is an ArrayList of
 * chains represented as LinkedLists.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public class MyHashMap<K, V> implements Map<K, V> {

  private static final int DEFAULT_TABLE_SIZE = 11; // a prime

  private List<List<Entry<K, V>>> table;

  public MyHashMap() {
    this(DEFAULT_TABLE_SIZE);
  }

  public MyHashMap(final int DEFAULT_TABLE_SIZE) {
    // allocate a table of the given size
    table = new ArrayList<>(DEFAULT_TABLE_SIZE);
    // then create an empty chain at each position
    for (int i = 0; i < DEFAULT_TABLE_SIZE; i += 1) {
      table.add(new LinkedList<>());
    }
  }

  @Override
  public int size() {
    // TODO add the sizes of all the chains
    int result = 0;
    for (int i = 0; i < DEFAULT_TABLE_SIZE; i++) {
      int chainSize = table.get(i).size();
      result = result + chainSize;
    }

    return result;
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public boolean containsKey(final Object key) {
    // done follow basic approach of remove below (though this will be much simpler)
    final int index = calculateIndex(key);
<<<<<<< HEAD
    // debugging shows that put method is not working
    System.out.println(key.toString());
    System.out.println(table.get(index).toString());
    // final Iterator<Entry<K, V>> iter = table.get(index).iterator();
    for (Entry<K, V> entry : table.get(index)) {
=======
    boolean value = false;
    final Iterator<Entry<K, V>> iter = table.get(index).iterator();
    while (iter.hasNext()) {
      final Entry<K, V> entry = iter.next();
>>>>>>> 6b040dc9a8a45877afbe617227b19448eba9d3b6
      if (entry.getKey().equals(key)) {
        value = true;
      }
    }
<<<<<<< HEAD

    return false;
=======
    return value;
>>>>>>> 6b040dc9a8a45877afbe617227b19448eba9d3b6
  }

  @Override
  public boolean containsValue(final Object value) {

<<<<<<< HEAD
    for (List<Entry<K, V>> index : table) {
      for (Entry<K, V> entry : index) {
        if (entry.getValue().equals(value)) {
          return true;
        }
=======
    final int index = calculateIndex(value);
    boolean value1 = false;
    final Iterator<Entry<K, V>> iter = table.get(index).iterator();
    while (iter.hasNext()) {
      final Entry<K, V> entry = iter.next();
      if (entry.getValue().equals(value)) {
        value1 = true;
>>>>>>> 6b040dc9a8a45877afbe617227b19448eba9d3b6
      }
    }
    return value1;
  }

  @Override
  public V get(final Object key) {
    // done follow basic approach of remove below (though this will be simpler)
    final int index = calculateIndex(key);
    V value = null;
    final Iterator<Entry<K, V>> iter = table.get(index).iterator();
    while (iter.hasNext()) {
      final Entry<K, V> entry = iter.next();
      if (entry.getKey().equals(key)) {
        value = entry.getValue();
      }
    }
    return value;
  }

  @Override
  public V put(final K key, final V value) {
    // TODO follow basic approach of remove below (this will be similar)
    final int index = calculateIndex(key);

    for (Entry<K, V> entry : table.get(index)) {
      if (entry.getKey().equals(key)) {
        V oldValue = entry.getValue();
        entry.setValue(value);
        return oldValue;
      }
    }

    table.get(index).add(0, new AbstractMap.SimpleEntry<K, V>(key, value));
    return null;
  }

  @Override
  public V remove(final Object key) {
    final int index = calculateIndex(key);
    final Iterator<Entry<K, V>> iter = table.get(index).iterator();
    while (iter.hasNext()) {
      final Entry<K, V> entry = iter.next();
      if (entry.getKey().equals(key)) {
        final V oldValue = entry.getValue();
        iter.remove();
        return oldValue;
      }
    }
    return null;
  }

  @Override
  public void putAll(final Map<? extends K, ? extends V> m) {
    // TODO add each entry in m's entrySet

    for (final Entry<? extends K, ? extends V> entry : m.entrySet()) {
      put(entry.getKey(), entry.getValue());
    }
  }

  // this is Ben's from here on out

  @Override
  public void clear() {
    for (final List<Entry<K, V>> chain : table) {
      chain.clear();
    }
  }

  /** The resulting keySet is not "backed" by the Map, so we keep it unmodifiable. */
  @Override
  public Set<K> keySet() {
    final Set<K> result = new HashSet<>();
    // TODO populate the set

    for (final List<Entry<K, V>> chain : table) {
      for (final Entry<K, V> entry : chain) {
        result.add(entry.getKey());
      }
    }

    return Collections.unmodifiableSet(result);
  }

  /** The resulting values collection is not "backed" by the Map, so we keep it unmodifiable. */
  @Override
  public Collection<V> values() {
    final List<V> result = new LinkedList<>();
    // TODO populate the list

    for (final List<Entry<K, V>> chain : table) {
      for (final Entry<K, V> entry : chain) {
        result.add(entry.getValue());
      }
    }

    return Collections.unmodifiableCollection(result);
  }

  /** The resulting entrySet is not "backed" by the Map, so we keep it unmodifiable. */
  @Override
  public Set<Entry<K, V>> entrySet() {
    final Set<Entry<K, V>> result = new HashSet<>();
    // TODO populate the set

    for (final List<Entry<K, V>> entry : table) {
      result.addAll(entry);
    }

    return Collections.unmodifiableSet(result);
  }

  @Override
  public String toString() {
    // TODO return the string representation of the underlying table

    return table.toString();
  }

  public boolean equals(final Object that) {
    if (this == that) {
      return true;
    } else if (!(that instanceof Map)) {
      return false;
    } else {
      return this.entrySet().equals(((Map) that).entrySet());
    }
  }

  private int calculateIndex(final Object key) {
    // positive remainder (as opposed to %)
    // required in case hashCode is negative!
    return Math.floorMod(key.hashCode(), table.size());
  }
}

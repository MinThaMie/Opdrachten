package ss.week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapUtil {

	/*@
	  ensures \result == (\forall K k, l; map.keySet().contains(k) && map.keySet().contains(l)
	  				&& k != l;	!map.get(k).equals(map.get(l)));
	 */
	public static <K, V> boolean isOneOnOne(Map<K, V> map) {
		boolean result = true;
		Object[] keys = map.keySet().toArray();

		for (int i = 0; i < keys.length && result; i++) {
			for (int j = i + 1; j < keys.length && result; j++) {
				if (map.get(keys[i]).equals(map.get(keys[j]))) {
					result = false;
				}
			}
		}

		return result;
	}

	/*@
	ensures \result == (\forall V v; range.contains(v);
	 						\exists K k;  map.get(k).equals(v));
	*/
	public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
		boolean result = true;
		Object[] valuesRange = range.toArray();

		for (int i = 0; i < valuesRange.length && result; i++) {
			result = map.containsValue(valuesRange[i]);
		}
		return result;
	}

	/*@
	ensures \forall K k; map.keySet().contains(k); \result.get(map.get(k)).contains(k);
	*/
	/* public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
		// need Map <V set<K>> because multiple keys can map to V, so the inverse has multiple keys per value
		Map<V, Set<K>> inverseMap = new HashMap<V, Set<K>>();
		HashSet<K> set;
		for (V v : map.values()) {
			set = new HashSet<K>();
			for (K k : map.keySet()) {
				if (map.get(k).equals(v))
					set.add(k);
			}
			inverseMap.put(v, set);
		}
		return inverseMap;
	}
	*/

/*	public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
		// need Map <V set<K>> because multiple keys can map to V, so the inverse has multiple keys per value
		Map<V, Set<K>> inverseMap = new HashMap<V, Set<K>>();
		HashSet<K> set = null;
		for (V v : map.values()) {
			for (K k : map.keySet()) {
				if (inverseMap.keySet().contains(v) && map.get(k).equals(v)) {
					inverseMap.get(v).add(k);
				} else {
					set = new HashSet<K>();
					if (map.get(k).equals(v)) {
						set.add(k);
						inverseMap.put(v, set);
					}
				}
			}

		}
		return inverseMap;
	}*/
	public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
		HashMap <V, Set<K>> inverseMap = new HashMap<V, Set<K>>();//create empty map
		
		for (V v : map.values()){ //create key with empty set for every unique value in map
			if (!inverseMap.containsKey(v)){
				inverseMap.put(v, new HashSet<K>());
			}
		}
		for (K k : map.keySet()){
			if (inverseMap.get(map.get(k))!=null)// ad key from map to key in inversemap
			inverseMap.get(map.get(k)).add(k);			
		}
		return inverseMap;	
	}

	/*@
	 requires (isOneOnOne(map) && isSurjectiveOnRange(map, (new HashSet<V>(map.values()))));
	 ensures (\forall K k;  map.keySet().contains(k); \result.get(map.get(k)).equals(k)); 
	 */
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
		//	if (!(isOneOnOne(map) && isSurjectiveOnRange(map, (new HashSet<V>(map.values())))))
		//	return null; //check hoeft niet vanwege preconditions toch

		HashMap<V, K> inverseMap = new HashMap<V, K>();
		for (K k : map.keySet())
			inverseMap.put(map.get(k), k);
		return inverseMap;

	}

	/*@
	 ensures \result==(\forall V v; f.values().contains(v); g.keySet().contains(v));
	 */
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
		boolean result = true;
		for (V valf : f.values()) {
			if (!g.keySet().contains(valf))
				result = false;
		}
		return result;
	}

	/*@
	 requires compatible(f,g);
	 ensures (\forall K k; \result.get(k)==g.get(f.get(k)));
	*/
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
		if (!compatible(f, g))
			return null;

		Map<K, W> composition = new HashMap<K, W>();

		for (K k : f.keySet()) {
			composition.put(k, g.get(f.get(k)));
		}
		return composition;
	}
}

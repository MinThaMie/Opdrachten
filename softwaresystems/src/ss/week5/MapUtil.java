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
			for (int j = i+1; j < keys.length && result; j++) {
				
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
		
		for (int i=0;i<valuesRange.length && result;i++){
			result = map.containsValue(valuesRange[i]);
		}
		
		return result;
	}

	
	public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
		// TODO: implement, see exercise P-5.3
		return null;
	}

	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
		// TODO: implement, see exercise P-5.3
		return null;
	}

	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
		// TODO: implement, see exercise P-5.4
		return false;
	}

	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
		// TODO: implement, see exercise P-5.5
		return null;
	}
}

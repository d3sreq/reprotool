package reprotool.fm.nusmv.mapping

import java.util.List
import java.util.Map
import org.eclipse.xtext.xbase.lib.Pair

class ReprotoolMappingExtensions {
	
	/**
	 * This helper function is used for construction of objects.
	 * e.g. $(factory.createObject)[ ...construction code... ]
	 */
	def <T> T $(T m, (T)=>void init ) {
		init.apply(m)
		return m
	}
	
	/**
	 * This helper function redefines the '->' operator for maps.
	 * Example: Instead of mymap.put(key, value)
	 * it is possible to use mymap += key -> value
	 */
	def <K,V> boolean operator_add(Map<K,V> map, Pair<K,V> pair) {
		map.put(pair.key, pair.value)
		return true
	}
	
	/**
	 * Also a list of pairs is accepted by the map.
	 * Example: mymap += mylist.map([ somekey -> somevalue ])
	 */
	def <K,V> boolean operator_add(Map<K,V> map, List<Pair<K,V>> listOfPairs) {
		for(pair : listOfPairs) {
			map.put(pair.key, pair.value);
		}
		return true
	}
		
	/**
	 * Provides a function which removes duplicates from an iterable.
	 * Example:
	 *   list = [3,5,1,2,3,3,4,4,5]
	 *   list.distinct = [1,2,3,4,5]
	 */
	def <T> List<T> distinct(Iterable<T> iterable) {
		iterable.toSet.toList
	}
	
}
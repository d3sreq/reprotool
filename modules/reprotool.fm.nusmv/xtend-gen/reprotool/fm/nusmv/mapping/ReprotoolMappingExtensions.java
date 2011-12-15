package reprotool.fm.nusmv.mapping;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ReprotoolMappingExtensions {
  /**
   * This helper function is used for construction of objects.
   * e.g. $(factory.createObject)[ ...construction code... ]
   */
  public <T extends Object> T $(final T m, final Procedure1<? super T> init) {
      init.apply(m);
      return m;
  }
  
  /**
   * This helper function redefines the '->' operator for maps.
   * Example: Instead of mymap.put(key, value)
   * it is possible to use mymap += key -> value
   */
  public <K extends Object, V extends Object> boolean operator_add(final Map<K,V> map, final Pair<K,V> pair) {
      K _key = pair.getKey();
      V _value = pair.getValue();
      map.put(_key, _value);
      return true;
  }
  
  /**
   * Also a list of pairs is accepted by the map.
   * Example: mymap += mylist.map([ somekey -> somevalue ])
   */
  public <K extends Object, V extends Object> boolean operator_add(final Map<K,V> map, final List<Pair<K,V>> listOfPairs) {
      for (final Pair<K,V> pair : listOfPairs) {
        K _key = pair.getKey();
        V _value = pair.getValue();
        map.put(_key, _value);
      }
      return true;
  }
  
  /**
   * Provides a function which removes duplicates from an iterable.
   * Example:
   *   list = [3,5,1,2,3,3,4,4,5]
   *   list.distinct = [1,2,3,4,5]
   */
  public <T extends Object> List<T> distinct(final Iterable<T> iterable) {
    Set<T> _set = IterableExtensions.<T>toSet(iterable);
    List<T> _list = IterableExtensions.<T>toList(_set);
    return _list;
  }
}

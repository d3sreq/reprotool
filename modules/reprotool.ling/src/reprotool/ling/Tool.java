package reprotool.ling;

/**
 * @author ofiala
 *
 */
public abstract class Tool {


	/**
	 * Execute selected linguistic tool operations
	 * 
	 * @param text Input text
	 * @return Output text
	 */
	abstract public String run(String text);
}

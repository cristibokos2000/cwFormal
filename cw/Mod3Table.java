/**
 * A deterministic finite-state automaton that 
 * recognizes strings that are binary representations
 * of natural numbers that are divisible
 * by 3. Leading zeros are permitted, and the
 * empty string is taken as a representation for 0
 * (along with "0", "00", and so on). This modification
 * uses table representation of the transitions instead
 */

public class Mod3Table {

  /* 
   * Constants q0 through q3 represent states, and
   * a private int holds the current state code.
   */
  private static final int Q = 0;
  private static final int R = 1;
  private static final int S = 2;
  private static final int T = 3;
  private static final int U = 4;
  private static final int V = 5;
  private static final int W = 6;
  private static final int X = 7;
  private static final int Y = 8;

  private int state;

  /**
   * The transition function implemented as a 
   * two-dimensional array
   * @param s state code (an int)
   * @param c char to make a transition on
   * @return the next state code
   */
  static private int[][] delta =
    {{R,Q},{S,Q},{T,V},{U,W},{U,U},{S,X},{Y,W},{Y,V},{U,X}};
  

  /**
   * Reset the current state to the start state.
   */
  public void reset() {
    state = Q;
  }

  /**
   * Make one transition on each char in the given
   * string.
   * @param in the String to use
   */
  public void process(String in) {
    for (int i = 0; i < in.length(); i++) {
      char c = in.charAt(i);
      try {
        state = delta[state][c-'0'];
      } catch (ArrayIndexOutOfBoundsException ex){ // reaching the end
        state = Y;
      }
    }
  }
  
  /**
   * Test whether the DFA accepted the string.
   * @return true if the final state was accepting
   */
  public boolean accepted() {
    return state==U;
  }
}

/**
	Env
*/
package symbols;

import java.util.*;
import lexer.*;
import inter.*;

public class Env{
	private Hashtable table;
	protected Env prev;
	
	public Env(Env e){
		table = new Hashtable();
		prev = e;
	}
	
	public void put(Token w, Id i){
		table.put(w, i);
	}
	
	public Id get(Token w){
		for (Env e = this; e != null; e = e.prev){
			Id found = (Id)(e.table.get(w));
			if (found != null){
				return found;
			}
		}
		return null;
	}
}
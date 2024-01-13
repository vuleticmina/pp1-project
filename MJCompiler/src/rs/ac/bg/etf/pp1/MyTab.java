package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Scope;
import rs.etf.pp1.symboltable.concepts.Struct;

public class MyTab extends Tab {
	public static final Struct boolType = new Struct(MyStruct.Bool);
	
	public static void init() {
		Tab.init();
		
		Scope universe = currentScope;
		
		universe.addToLocals(new Obj(Obj.Type, "bool",  boolType));
	}
	
	public static Obj findInCurrentScope(String name) {
		Obj resultObj = null;
		Scope s = currentScope; 
		if (s.getLocals() != null) {
				resultObj = s.getLocals().searchKey(name);
		}
		
		return (resultObj != null) ? resultObj : noObj;
	}

}

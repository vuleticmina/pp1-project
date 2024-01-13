package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.concepts.Struct;
import rs.etf.pp1.symboltable.structure.SymbolDataStructure;

public class MyStruct extends Struct {

	public static final int Bool = 5;
	
	public MyStruct(int kind, Struct elemType) {
		super(kind, elemType);
		// TODO Auto-generated constructor stub
	}

	public MyStruct(int kind, SymbolDataStructure members) {
		super(kind, members);
		// TODO Auto-generated constructor stub
	}

	public MyStruct(int kind) {
		super(kind);
		// TODO Auto-generated constructor stub
	}

	
	
}

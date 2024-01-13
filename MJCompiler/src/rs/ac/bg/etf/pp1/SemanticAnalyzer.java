package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import java_cup.internal_error;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticAnalyzer extends VisitorAdaptor{
	
	boolean errorDetected = false;
	int printCallCount = 0;
	int varDeclCount = 0;
	boolean isVoid = false;
	Struct constantType = Tab.noType;
	Struct variableType = Tab.noType;
	boolean isNamespace = false;
	boolean isStatic = false;
	boolean isDesignatorArrElem = false;
	String nsName = null;
	String designatorName = null;
	Obj currentMethod = null;
	int numberOfFormPars = 0;
	Logger log = Logger.getLogger(getClass());
	
	public SemanticAnalyzer() {
		System.out.println("=====================SEMANTIC ANALYSIS=========================");
	}
	
	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line).append(". ");
		log.error(msg.toString());
	}
	
	public void report_info(String msg, String name, SyntaxNode node, Obj object) {
		StringBuilder builder = new StringBuilder(msg); 
		builder.append(name);
		int line = (node == null) ? 0: node.getLine();
		if (line != 0) {
			builder.append (" na liniji ").append(line).append(". ");
			MyDumpSymbolTableVisitor stv = new MyDumpSymbolTableVisitor();
			stv.visitObjNode(object);
			builder.append(stv.getOutput());
		}
		
		log.info(builder.toString());
	}

	public void report_info1(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	public void visit(ProgName progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType );
		Tab.openScope();
	}
	
	private void checkMain() {
		Obj mainObj = Tab.find("main");
		if(mainObj == Tab.noObj )
			report_error("Ne postoji main metoda!",  null);
		else if(mainObj.getKind() != Obj.Meth) 
			report_error("Ime main nije deklarisano kao metoda!",  null);
		else if(mainObj.getType().getKind() != Struct.None)
			report_error("Povratna vrednost main metode mora biti void!",  null);
		else if(mainObj.getLevel() != 0)
			report_error("Main metoda ne sme imati argumente!",  null);
	}
	
	public void visit(Program program) {
		checkMain();
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
	}
	
	public void visit(NamespaceName namespaceName) {
		isNamespace = true;
		nsName = namespaceName.getName();
	}

	public void visit(Namespace namespace) {
		isNamespace = false;
	}
	
	private String makeName(String name) {
		 return isNamespace ? nsName + "::" + name :  name;
	}

	private void visitType(Type type, String name) {
		String nameType = makeName(name);
		Obj typeNode = Tab.find(nameType);
		if(typeNode == Tab.noObj) {typeNode = Tab.find(name);}
		
		if(typeNode == Tab.noObj) {
			report_error("Nije pronadjen tip (" + name + ") u tabeli simbola! ", type);
			type.struct = Tab.noType;
		} else {
			if(Obj.Type == typeNode.getKind()) {
				type.struct = typeNode.getType();
			} else {
				report_error("Ime (" + name + ") ne predstavlja tip! ", type);
				type.struct = Tab.noType;
			}
		}
	}
	
	public void visit(BasicType basicType) {
		visitType(basicType, basicType.getTypeName());
	}
	
	public void visit(NamespaceType namespaceType) {
		visitType(namespaceType, namespaceType.getNamespaceName() + "::" + namespaceType.getTypeName());
	}
	
	private void checkDoubleDeclaration(String name, SyntaxNode node) {
		if(MyTab.findInCurrentScope(name) != Tab.noObj) {
			report_error("Dupla deklaracija imena " + name + " u trenutnom opsegu " , node);
		}
	}
	
	public void visit(VoidMethodType voidMethodType) {
		isVoid = true;
		
		String methName = voidMethodType.getMethName();
		methName = makeName(methName);
		
		currentMethod = Tab.insert(Obj.Meth, methName, Tab.noType);
		currentMethod.setLevel(0);
		voidMethodType.obj = currentMethod; 
		Tab.openScope();
	}
	
	public void visit(MethodType methodType) {
		Struct type= methodType.getType().struct;
		isVoid = (type == Tab.noType);
		
		String methName = methodType.getMethName();
		methName = makeName(methName);
		
		currentMethod = Tab.insert(Obj.Meth, methName, type);
		currentMethod.setLevel(0);
		methodType.obj = currentMethod; 
		Tab.openScope();
	}
	
	public void visit(MethodDecl methodDecl) {
		currentMethod.setLevel(numberOfFormPars);
		numberOfFormPars = 0;
		
		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		
		currentMethod = null;
	}
	
	public void visit(FormParameter formParameter) {
		String formParName = formParameter.getFormParName();
		Struct formParType = formParameter.getType().struct;
		numberOfFormPars++;
		checkDoubleDeclaration(formParName, formParameter);
		Obj formParNode = Tab.insert(Obj.Var, formParName, formParType);
		formParNode.setFpPos(numberOfFormPars);
	}
	
	public void visit(FormParameterArr formParameterArr) {
		String formParName = formParameterArr.getFormParName();
		Struct formParTypeOfElems = formParameterArr.getType().struct; 
		
		numberOfFormPars++;
		checkDoubleDeclaration(formParName, formParameterArr);
		Obj formParNode = Tab.insert(Obj.Var, formParName, new Struct(Struct.Array, formParTypeOfElems));
		formParNode.setFpPos(numberOfFormPars);
	}

	public void visit(ConstType constType) {
		constantType  = constType.getType().struct;
	}
	
	private void checkType(Struct checkType, String constName) {
		if (checkType != constantType){
			report_error("Nepoklapanje tipova prilikom deklarisanja konstante: " + constName, null);
		}
	}
	
	public void visit(ConstNumDeclaration constNumDeclaration) {
		String constName = constNumDeclaration.getConstName();
		constName = makeName(constName);
		
		checkType(Tab.intType, constName);
		checkDoubleDeclaration(constName, constNumDeclaration);
		Obj constNode = Tab.insert(Obj.Con, constName, constantType);
		constNode.setAdr(constNumDeclaration.getNumConst());
	}
	
	public void visit(ConstBoolDeclaration constBoolDeclaration) {
		String constName = constBoolDeclaration.getConstName();
		constName = makeName(constName);
		
		checkType(MyTab.boolType, constName);
		checkDoubleDeclaration(constName, constBoolDeclaration);
		Obj constNode = Tab.insert(Obj.Con, constName, constantType);
		int value = 0;
		if(constBoolDeclaration.getBoolConst()) {
			value = 1;
		}
		constNode.setAdr(value);
	}
	
	public void visit(ConstCharDeclaration constCharDeclaration) {
		String constName = constCharDeclaration.getConstName();
		constName = makeName(constName);
		
		checkType(Tab.charType, constName);
		checkDoubleDeclaration(constName, constCharDeclaration);
		Obj constNode = Tab.insert(Obj.Con, constName, constantType);
		constNode.setAdr((int)constCharDeclaration.getCharConst());
	}

	public void visit(ClassName className) {
		String name = className.getName();
		name = makeName(name);
		className.obj = Tab.insert(Obj.Type, name, new Struct(Struct.Class));
		
		Tab.openScope();
		
	}
	
	public void visit(ClassDeclarationList classDeclarationList) {
		Tab.chainLocalSymbols(classDeclarationList.getClassDeclList().getClassName().obj.getType());
		Tab.closeScope();
	}

	public void visit(ExtendType extendType ) {
		if(extendType.getType().struct.getKind() != Struct.Class) {
			report_error("Klasa moze da prosiruje samo tip koji predstavlja klasu ", extendType);
		}
	}
	
	public void visit(Static stat) {
		isStatic = true;
	}

	public void visit(StaticVarDecl staticVarDecl) {
		isStatic = false;
	}
	
	public void visit(StaticInitializer staticInitializer) {
		isStatic = false;
	}
	
	public void visit(VarType varType) {
		variableType = varType.getType().struct;
	}
	
	public void visit(VarDeclaration varDeclaration) {
		String varName = varDeclaration.getVarName();
		varName = makeName(varName);
		
		checkDoubleDeclaration(varName, varDeclaration);
		Obj varNode = Tab.insert(Obj.Var, varName, variableType);
		if(isStatic) varNode.setLevel(1);
		else varNode.setLevel(0);
	}
	
	
	public void visit(VarDeclarationArr varDeclarationArr) {
		String varName = varDeclarationArr.getVarName();
		varName = makeName(varName);
		
		checkDoubleDeclaration(varName, varDeclarationArr);
		Tab.insert(Obj.Var, varName, new Struct(Struct.Array, variableType));
	}

	
	private Obj checkIfItIsDeclared(String name, SyntaxNode node) {
		Obj designatorNode = Tab.find(name);
		if(designatorNode == Tab.noObj) {
			report_error("Korisceno ime " + name + " nije deklarisano!" , node);
		}
		return designatorNode;
	}
	
	
	public void visit(DesignatorBasicName designatorBasicName) {
		designatorName = designatorBasicName.getDesignatorName();
		designatorBasicName.obj = checkIfItIsDeclared(designatorName, designatorBasicName);
		report_info("Pronadjen simbol ", designatorName, designatorBasicName, designatorBasicName.obj);
				
	}
	
	
	public void visit(DesignatorNamespaceName designatorNamespaceName) {
		designatorName = designatorNamespaceName.getDesignatorNamespaceName() + "::" + designatorNamespaceName.getDesignatorName();
		designatorNamespaceName.obj = checkIfItIsDeclared(designatorName, designatorNamespaceName);
		report_info("Pronadjen simbol ", designatorName, designatorNamespaceName, designatorNamespaceName.obj);

	}
	
	
	public void visit(DesignatorArr designatorArr) {
		if(designatorArr.getDesignator().obj.getType().getKind() != Struct.Array) {
			report_error("Ime: " + designatorName + " ne predstavlja ime niza " , designatorArr);
		} else {
			isDesignatorArrElem = true;
		}
		
		//TODO proveriti da li je tipe neterminala Expr int
	}
	
	
	public void visit(DesignatorField designatorField) {
		Obj designatorObj = designatorField.getDesignator().obj;
		Struct type = designatorObj.getType();
		String fieldName =  designatorField.getFieldName();
		if(type.getKind() != Struct.Class) {
			report_error("Ime: " + designatorName + " ne predstavlja ime klase! " , null);
		} else {
			if(designatorObj.getKind() == Obj.Type) {
				designatorObj = type.getMembers().searchKey(fieldName);
				 designatorField.obj  = designatorObj;

				if(designatorObj == null || designatorObj.getLevel() != 1) {
					report_error("U klasi " + designatorName + " ne posotoji staticko polje " +  fieldName, designatorField);
				}
			} else {
				designatorObj = designatorField.obj = type.getMembers().searchKey(fieldName);
				if(designatorObj == null || designatorObj.getLevel() != 0) {
					report_error("U klasi " + designatorName + " ne posotoji ime " +  fieldName, designatorField);
				}
			}
		}
		
		//TODO ident mora biti ili polje ili metoda objekta označenog neterminalom Designator),
		//ili Designator mora biti unutrašnja klasa (ident mora biti statičko polje).
	}
	
	public void visit(DesignatorStatementActPars designatorStatementActPars) {
		Obj designatorObj =  designatorStatementActPars.getDesignator().obj;
		int designatorObjKind = designatorObj.getKind();
		if(designatorObjKind != Obj.Meth) {
			report_error("Ime " + designatorObj.getName() + " ne predstavlja ime metode ", designatorStatementActPars);
		} else {
			report_info("Pronadjen poziv metode ", designatorObj.getName(), designatorStatementActPars, designatorObj);
		}
	}
	
	
	public void visit(DesignatorStatementChange designatorStatementChange) {
		Obj designatorNode  = designatorStatementChange.getDesignator().obj;
		Struct designatorType = designatorNode.getType();
		int designatorKind = designatorNode.getKind();
		if(designatorKind != Obj.Var && !isDesignatorArrElem && designatorKind != Obj.Fld) {
			report_error("Ime " + designatorNode.getName() + "mora predstavljati ime pormenljive, elemetn nize ili polje unutrasnje klase ", designatorStatementChange);
		}
		if(designatorType != Tab.intType) {
			report_error("Ime " + designatorNode.getName() + " mora biti tipa int ", designatorStatementChange);
		}
		isDesignatorArrElem = false;
	}
	
	public void visit(FactorNewActPars factorNewActPars) {
		if(factorNewActPars.getType().struct.getKind() != Struct.Class) {
			report_error("Tip nakon new mora predstavljati klasu " , factorNewActPars);
		}
	}
	
	public boolean passed() {
		return !errorDetected;
	}
}

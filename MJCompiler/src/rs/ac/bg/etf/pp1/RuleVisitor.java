package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;

public class RuleVisitor implements Visitor {

	boolean errorDetected = false;
	int printCallCount = 0;
	Obj currentMethod = null;
	boolean returnFound = false;
	int nVars;

	Logger log = Logger.getLogger(getClass());

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	public void visit(Program program) {		
		nVars = Tab.currentScope.getnVars();
		//Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
	}

	

	@Override
	public void visit(MethodDecl MethodDecl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Namespace Namespace) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean passed() {
		return !errorDetected;
	}

	@Override
	public void visit(ConstDecl ConstDecl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Type Type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ConstDeclList ConstDeclList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Const Const) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Decl Decl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(VarDeclList VarDeclList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ClassDeclList ClassDeclList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DeclarationList DeclarationList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DeclList DeclList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(BoolConst BoolConst) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void visit(NumConst NumConst) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FirstConstDeclaration FirstConstDeclaration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ConstDeclarations ConstDeclarations) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ConstDeclarationsList ConstDeclarationsList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(NoDeclarationList NoDeclarationList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(NoNamespace NoNamespace) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Declaration Declaration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Declarations Declarations) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FulDeclarationList FulDeclarationList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ShortType ShortType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FullType FullType) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void visit(CharConst CharConst) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(VarDecl VarDecl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(VarDeclarationArr VarDeclarationArr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(VarDeclaration VarDeclaration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FirstVarDeclaration FirstVarDeclaration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(VarDeclartions VarDeclartions) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(VarDeclarationsList VarDeclarationsList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(VarDeclarationList VarDeclarationList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ConstDeclarationList ConstDeclarationList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Unmatched Unmatched) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Mulop Mulop) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Matched Matched) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ForCondFact ForCondFact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Relop Relop) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Assignop Assignop) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StatementList StatementList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Extends Extends) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Addop Addop) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Factor Factor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(CondTerm CondTerm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Designator Designator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ClassVarDeclList ClassVarDeclList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Term Term) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StaticVarDeclList StaticVarDeclList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FormParsList FormParsList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Condition Condition) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(MethodDeclType MethodDeclType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DesignatorStatementList DesignatorStatementList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DesignatorListComma DesignatorListComma) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Expr Expr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ActPars ActPars) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DesignatorList DesignatorList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DesignatorStatement DesignatorStatement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Statement Statement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(CondFact CondFact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FormPar FormPar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(MethodDeclList MethodDeclList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Percent Percent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Divide Divide) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Times Times) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Minus Minus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Plus Plus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Lte Lte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Lt Lt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Gte Gte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Gt Gt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Neq Neq) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Eq Eq) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void visit(Label Label) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(NoDesList NoDesList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DesListExpr DesListExpr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DesListIdent DesListIdent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ShortDesignator ShortDesignator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(LongDesignator LongDesignator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FactorExpr FactorExpr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FactorNewParenPars FactorNewParenPars) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FactorNewParen FactorNewParen) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FactorNewExpr FactorNewExpr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FactorConst FactorConst) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FactorDesParenPars FactorDesParenPars) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FactorDesParen FactorDesParen) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FactorDes FactorDes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(TermFactor TermFactor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(TermFactors TermFactors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ExprList ExprList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ExprFirstMinusTerm ExprFirstMinusTerm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ExprFirstTerm ExprFirstTerm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(CondFactRelop CondFactRelop) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(CondFactNoRelop CondFactNoRelop) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FirstCondTerm FirstCondTerm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(CondTermList CondTermList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FirstCondition FirstCondition) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ConditionsList ConditionsList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FirstActPar FirstActPar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ActParsList ActParsList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(NoDesignatorListComma NoDesignatorListComma) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DesignatorListCommaOnly DesignatorListCommaOnly) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DesignatorListCommaDesignator DesignatorListCommaDesignator) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void visit(NoDesignatorStatementList NoDesignatorStatementList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FirstDesignatorStatement FirstDesignatorStatement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DesignatorStatements DesignatorStatements) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(NoForCondition NoForCondition) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ForCondition ForCondition) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(NoStatementList NoStatementList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(Statements Statements) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StatementStatements StatementStatements) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StatementFor StatementFor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StatementPrintNumConst StatementPrintNumConst) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StatementPrintNoNumConst StatementPrintNoNumConst) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StatementRead StatementRead) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StatementReturnExpr StatementReturnExpr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StatementReturnNoExpr StatementReturnNoExpr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StatementContinue StatementContinue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StatementBreak StatementBreak) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StatementIfElse StatementIfElse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StatementDesignatorStatement StatementDesignatorStatement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(UnmatchedIfElse UnmatchedIfElse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(UnmatchedIf UnmatchedIf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(UnmatchedStmt UnmatchedStmt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(MatchedStmt MatchedStmt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(NoClassVarDeclList NoClassVarDeclList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ClassVarDeclarations ClassVarDeclarations) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(NoStaticVarDeclList NoStaticVarDeclList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StaticVarDeclartions StaticVarDeclartions) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StaticVarDecl StaticVarDecl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(NoFormPars NoFormPars) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FirstFormPar FirstFormPar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FormPars FormPars) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FormParameterArr FormParameterArr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(FormParameter FormParameter) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(TypeMethodType TypeMethodType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(VoidMethodType VoidMethodType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(NoMethodDeclList NoMethodDeclList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(MethodDeclarationsList MethodDeclarationsList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StaticInitializer StaticInitializer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(NoExtend NoExtend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ExtendType ExtendType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ClassDeclListMethods ClassDeclListMethods) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ClassDeclListNoMethods ClassDeclListNoMethods) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ClassDeclarationList ClassDeclarationList) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void visit(NoStaticInitializer NoStaticInitializer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(StaticInitializerDefault StaticInitializerDefault) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void visit(ConstDeclDerived1 ConstDeclDerived1) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void visit(ConstDeclaration ConstDeclaration) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void visit(FormParDerived1 FormParDerived1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ConditionDerived1 ConditionDerived1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(ExtendsDerived1 ExtendsDerived1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DesignatorStatementDesignatorList DesignatorStatementDesignatorList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DesignatorStatementDec DesignatorStatementDec) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DesignatorStatementInc DesignatorStatementInc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DesignatorStatementActPars DesignatorStatementActPars) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(DesignatorStatementNoActPars DesignatorStatementNoActPars) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void visit(DesignatorStatementDesignator DesignatorStatementDesignator) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void visit(NamespaceList NamespaceList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(NamespaceListExists NamespaceListExists) {
		// TODO Auto-generated method stub
		
	}



}

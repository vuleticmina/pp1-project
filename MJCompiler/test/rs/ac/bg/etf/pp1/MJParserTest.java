package rs.ac.bg.etf.pp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java_cup.runtime.Symbol;
import rs.ac.bg.etf.pp1.ast.SyntaxNode;
import rs.ac.bg.etf.pp1.util.Log4JUtils;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;

//dodato
import rs.ac.bg.etf.pp1.ast.Program;

public class MJParserTest {

	static {
		DOMConfigurator.configure(Log4JUtils.instance().findLoggerConfigFile());
		Log4JUtils.instance().prepareLogFile(Logger.getRootLogger());
	}
	
	public static void main(String[] args) throws Exception {
		Logger log = Logger.getLogger(MJParserTest.class);
		if (args.length < 2) {
			log.error("Not enough arguments supplied! Usage: MJParser <source-file> <obj-file> ");
			return;
		}
		
		File sourceCode = new File("test/testSemantic3.mj");
		if (!sourceCode.exists()) {
			log.error("Source file [" + sourceCode.getAbsolutePath() + "] not found!");
			return;
		}
			
		log.info("Compiling source file: " + sourceCode.getAbsolutePath());
		
		try (BufferedReader br = new BufferedReader(new FileReader(sourceCode))) {
			Yylex lexer = new Yylex(br);
			MJParser p = new MJParser(lexer);
	        Symbol s = p.parse();  //pocetak parsiranja
	       // SyntaxNode prog = (SyntaxNode)(s.value);
	        
	        //dodato
	        Program prog = (Program)(s.value);
	        log.info(prog.toString(""));
	        
			MyTab.init(); // Universe scope
			SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
			prog.traverseBottomUp(semanticAnalyzer);
			
	        //log.info("Print calls = " + semanticAnalyzer.printCallCount);
	        MyTab.dump(new MyDumpSymbolTableVisitor());
	        
	        if (!p.errorDetected && semanticAnalyzer.passed()) {
	        	File objFile = new File(args[1]);
	        	log.info("Generating bytecode file: " + objFile.getAbsolutePath());
	        	if (objFile.exists())
	        		objFile.delete();
	        	
	        	// Code generation...
	        	//CodeGenerator codeGenerator = new CodeGenerator();
	        	//prog.traverseBottomUp(codeGenerator);
	        	//Code.dataSize = semanticCheck.nVars;
	        	//Code.mainPc = codeGenerator.getMainPc();
	        	//Code.write(new FileOutputStream(objFile));
	        	log.info("Parsiranje uspesno zavrseno!");
	        }
	        else {
	        	log.error("Parsiranje NIJE uspesno zavrseno!");
	        }
		}
	}
}

// generated with ast extension for cup
// version 0.8
// 13/0/2024 13:19:31


package rs.ac.bg.etf.pp1.ast;

public class ConstBoolDeclaration extends ConstDecl {

    private String constName;
    private Boolean boolConst;

    public ConstBoolDeclaration (String constName, Boolean boolConst) {
        this.constName=constName;
        this.boolConst=boolConst;
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) {
        this.constName=constName;
    }

    public Boolean getBoolConst() {
        return boolConst;
    }

    public void setBoolConst(Boolean boolConst) {
        this.boolConst=boolConst;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstBoolDeclaration(\n");

        buffer.append(" "+tab+constName);
        buffer.append("\n");

        buffer.append(" "+tab+boolConst);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstBoolDeclaration]");
        return buffer.toString();
    }
}

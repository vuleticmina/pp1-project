// generated with ast extension for cup
// version 0.8
// 13/0/2024 13:19:31


package rs.ac.bg.etf.pp1.ast;

public class FactorNewActPars extends Factor {

    private Type Type;
    private ActParsOption ActParsOption;

    public FactorNewActPars (Type Type, ActParsOption ActParsOption) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ActParsOption=ActParsOption;
        if(ActParsOption!=null) ActParsOption.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ActParsOption getActParsOption() {
        return ActParsOption;
    }

    public void setActParsOption(ActParsOption ActParsOption) {
        this.ActParsOption=ActParsOption;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ActParsOption!=null) ActParsOption.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ActParsOption!=null) ActParsOption.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ActParsOption!=null) ActParsOption.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorNewActPars(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActParsOption!=null)
            buffer.append(ActParsOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorNewActPars]");
        return buffer.toString();
    }
}

// generated with ast extension for cup
// version 0.8
// 13/0/2024 13:19:31


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementDesignatorList extends DesignatorStatement {

    private DesignatorListComma DesignatorListComma;
    private Designator Designator;
    private Designator Designator1;

    public DesignatorStatementDesignatorList (DesignatorListComma DesignatorListComma, Designator Designator, Designator Designator1) {
        this.DesignatorListComma=DesignatorListComma;
        if(DesignatorListComma!=null) DesignatorListComma.setParent(this);
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.Designator1=Designator1;
        if(Designator1!=null) Designator1.setParent(this);
    }

    public DesignatorListComma getDesignatorListComma() {
        return DesignatorListComma;
    }

    public void setDesignatorListComma(DesignatorListComma DesignatorListComma) {
        this.DesignatorListComma=DesignatorListComma;
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public Designator getDesignator1() {
        return Designator1;
    }

    public void setDesignator1(Designator Designator1) {
        this.Designator1=Designator1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorListComma!=null) DesignatorListComma.accept(visitor);
        if(Designator!=null) Designator.accept(visitor);
        if(Designator1!=null) Designator1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorListComma!=null) DesignatorListComma.traverseTopDown(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(Designator1!=null) Designator1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorListComma!=null) DesignatorListComma.traverseBottomUp(visitor);
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(Designator1!=null) Designator1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementDesignatorList(\n");

        if(DesignatorListComma!=null)
            buffer.append(DesignatorListComma.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Designator1!=null)
            buffer.append(Designator1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementDesignatorList]");
        return buffer.toString();
    }
}

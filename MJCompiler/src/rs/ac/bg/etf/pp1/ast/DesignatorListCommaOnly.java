// generated with ast extension for cup
// version 0.8
// 13/0/2024 13:19:31


package rs.ac.bg.etf.pp1.ast;

public class DesignatorListCommaOnly extends DesignatorListComma {

    private DesignatorListComma DesignatorListComma;

    public DesignatorListCommaOnly (DesignatorListComma DesignatorListComma) {
        this.DesignatorListComma=DesignatorListComma;
        if(DesignatorListComma!=null) DesignatorListComma.setParent(this);
    }

    public DesignatorListComma getDesignatorListComma() {
        return DesignatorListComma;
    }

    public void setDesignatorListComma(DesignatorListComma DesignatorListComma) {
        this.DesignatorListComma=DesignatorListComma;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorListComma!=null) DesignatorListComma.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorListComma!=null) DesignatorListComma.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorListComma!=null) DesignatorListComma.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorListCommaOnly(\n");

        if(DesignatorListComma!=null)
            buffer.append(DesignatorListComma.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorListCommaOnly]");
        return buffer.toString();
    }
}

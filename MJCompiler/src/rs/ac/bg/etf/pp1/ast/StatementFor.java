// generated with ast extension for cup
// version 0.8
// 13/0/2024 13:19:31


package rs.ac.bg.etf.pp1.ast;

public class StatementFor extends Matched {

    private DesignatorStatementList DesignatorStatementList;
    private ForCondFact ForCondFact;
    private DesignatorStatementList DesignatorStatementList1;
    private Matched Matched;

    public StatementFor (DesignatorStatementList DesignatorStatementList, ForCondFact ForCondFact, DesignatorStatementList DesignatorStatementList1, Matched Matched) {
        this.DesignatorStatementList=DesignatorStatementList;
        if(DesignatorStatementList!=null) DesignatorStatementList.setParent(this);
        this.ForCondFact=ForCondFact;
        if(ForCondFact!=null) ForCondFact.setParent(this);
        this.DesignatorStatementList1=DesignatorStatementList1;
        if(DesignatorStatementList1!=null) DesignatorStatementList1.setParent(this);
        this.Matched=Matched;
        if(Matched!=null) Matched.setParent(this);
    }

    public DesignatorStatementList getDesignatorStatementList() {
        return DesignatorStatementList;
    }

    public void setDesignatorStatementList(DesignatorStatementList DesignatorStatementList) {
        this.DesignatorStatementList=DesignatorStatementList;
    }

    public ForCondFact getForCondFact() {
        return ForCondFact;
    }

    public void setForCondFact(ForCondFact ForCondFact) {
        this.ForCondFact=ForCondFact;
    }

    public DesignatorStatementList getDesignatorStatementList1() {
        return DesignatorStatementList1;
    }

    public void setDesignatorStatementList1(DesignatorStatementList DesignatorStatementList1) {
        this.DesignatorStatementList1=DesignatorStatementList1;
    }

    public Matched getMatched() {
        return Matched;
    }

    public void setMatched(Matched Matched) {
        this.Matched=Matched;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStatementList!=null) DesignatorStatementList.accept(visitor);
        if(ForCondFact!=null) ForCondFact.accept(visitor);
        if(DesignatorStatementList1!=null) DesignatorStatementList1.accept(visitor);
        if(Matched!=null) Matched.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStatementList!=null) DesignatorStatementList.traverseTopDown(visitor);
        if(ForCondFact!=null) ForCondFact.traverseTopDown(visitor);
        if(DesignatorStatementList1!=null) DesignatorStatementList1.traverseTopDown(visitor);
        if(Matched!=null) Matched.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStatementList!=null) DesignatorStatementList.traverseBottomUp(visitor);
        if(ForCondFact!=null) ForCondFact.traverseBottomUp(visitor);
        if(DesignatorStatementList1!=null) DesignatorStatementList1.traverseBottomUp(visitor);
        if(Matched!=null) Matched.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementFor(\n");

        if(DesignatorStatementList!=null)
            buffer.append(DesignatorStatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForCondFact!=null)
            buffer.append(ForCondFact.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStatementList1!=null)
            buffer.append(DesignatorStatementList1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Matched!=null)
            buffer.append(Matched.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementFor]");
        return buffer.toString();
    }
}

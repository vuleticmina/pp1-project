// generated with ast extension for cup
// version 0.8
// 13/0/2024 13:19:31


package rs.ac.bg.etf.pp1.ast;

public class StaticVarDeclartions extends StaticVarDeclList {

    private StaticVarDeclList StaticVarDeclList;
    private StaticVarDecl StaticVarDecl;

    public StaticVarDeclartions (StaticVarDeclList StaticVarDeclList, StaticVarDecl StaticVarDecl) {
        this.StaticVarDeclList=StaticVarDeclList;
        if(StaticVarDeclList!=null) StaticVarDeclList.setParent(this);
        this.StaticVarDecl=StaticVarDecl;
        if(StaticVarDecl!=null) StaticVarDecl.setParent(this);
    }

    public StaticVarDeclList getStaticVarDeclList() {
        return StaticVarDeclList;
    }

    public void setStaticVarDeclList(StaticVarDeclList StaticVarDeclList) {
        this.StaticVarDeclList=StaticVarDeclList;
    }

    public StaticVarDecl getStaticVarDecl() {
        return StaticVarDecl;
    }

    public void setStaticVarDecl(StaticVarDecl StaticVarDecl) {
        this.StaticVarDecl=StaticVarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StaticVarDeclList!=null) StaticVarDeclList.accept(visitor);
        if(StaticVarDecl!=null) StaticVarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StaticVarDeclList!=null) StaticVarDeclList.traverseTopDown(visitor);
        if(StaticVarDecl!=null) StaticVarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StaticVarDeclList!=null) StaticVarDeclList.traverseBottomUp(visitor);
        if(StaticVarDecl!=null) StaticVarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StaticVarDeclartions(\n");

        if(StaticVarDeclList!=null)
            buffer.append(StaticVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StaticVarDecl!=null)
            buffer.append(StaticVarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StaticVarDeclartions]");
        return buffer.toString();
    }
}

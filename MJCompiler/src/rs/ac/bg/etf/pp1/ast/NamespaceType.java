// generated with ast extension for cup
// version 0.8
// 13/0/2024 13:19:31


package rs.ac.bg.etf.pp1.ast;

public class NamespaceType extends Type {

    private String NamespaceName;
    private String typeName;

    public NamespaceType (String NamespaceName, String typeName) {
        this.NamespaceName=NamespaceName;
        this.typeName=typeName;
    }

    public String getNamespaceName() {
        return NamespaceName;
    }

    public void setNamespaceName(String NamespaceName) {
        this.NamespaceName=NamespaceName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName=typeName;
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
        buffer.append("NamespaceType(\n");

        buffer.append(" "+tab+NamespaceName);
        buffer.append("\n");

        buffer.append(" "+tab+typeName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NamespaceType]");
        return buffer.toString();
    }
}

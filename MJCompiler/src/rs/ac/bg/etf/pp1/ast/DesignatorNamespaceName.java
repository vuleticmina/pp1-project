// generated with ast extension for cup
// version 0.8
// 13/0/2024 13:19:31


package rs.ac.bg.etf.pp1.ast;

public class DesignatorNamespaceName extends Designator {

    private String designatorNamespaceName;
    private String designatorName;

    public DesignatorNamespaceName (String designatorNamespaceName, String designatorName) {
        this.designatorNamespaceName=designatorNamespaceName;
        this.designatorName=designatorName;
    }

    public String getDesignatorNamespaceName() {
        return designatorNamespaceName;
    }

    public void setDesignatorNamespaceName(String designatorNamespaceName) {
        this.designatorNamespaceName=designatorNamespaceName;
    }

    public String getDesignatorName() {
        return designatorName;
    }

    public void setDesignatorName(String designatorName) {
        this.designatorName=designatorName;
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
        buffer.append("DesignatorNamespaceName(\n");

        buffer.append(" "+tab+designatorNamespaceName);
        buffer.append("\n");

        buffer.append(" "+tab+designatorName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorNamespaceName]");
        return buffer.toString();
    }
}

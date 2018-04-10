public class Test {
    public static void main(String[] args) {
        IExpression isMale = getMaleExpression();
        IExpression isMarriedWoman = getMarriedWomanExpression();

        System.out.println("John is male? " + isMale.interpret("John"));
        System.out.println("Julie is a married women? "
                + isMarriedWoman.interpret("Married Julie"));

    }

    //规则：Robert 和 John 是男性
    public static IExpression getMaleExpression() {
        IExpression robert = new TerminalExpression("Robert");
        IExpression john = new TerminalExpression("John");
        return new OrExpression(robert, john);
    }

    //规则：Julie 是一个已婚的女性
    public static IExpression getMarriedWomanExpression() {
        IExpression julie = new TerminalExpression("Julie");
        IExpression married = new TerminalExpression("Married");
        return new AndExpression(julie, married);
    }
}

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.Reporter;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Put your name here
 *
 */
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires * [exp is a subtree of a well-formed XML arithmetic expression]
     *           and [the label of the root of exp is not "expression"]
     *
     * @ensures evaluate = [the value of the expression]
     */
    private static NaturalNumber evaluate(XMLTree exp) {
        NaturalNumber result = new NaturalNumber2(0);
        if (exp.hasAttribute("value")) {
            result.setFromInt(Integer.parseInt(exp.attributeValue("value")));
        } else { //if has attribute "value" then set to the result "value"
            NaturalNumber child1 = evaluate(exp.child(0)); //each leaf
            NaturalNumber child2 = evaluate(exp.child(1));
            String sign = exp.label(); // +, -, *, /

            if (sign.equals("plus")) {
                child1.add(child2);
                result.copyFrom(child1); //must copy for natural numbers
            } else if (sign.equals("minus")) {
                child1.subtract(child2);
                result.copyFrom(child1);
            } else if (sign.equals("times")) {
                child1.multiply(child2);
                result.copyFrom(child1);
            } else if (sign.equals("divide")) {
                if (child2.isZero()) { //if divding by 0, error
                    Reporter.fatalErrorToConsole("Error: Divide by zero");
                } else {
                    child1.divide(child2);
                    result.copyFrom(child1);
                }
            }
        }
        return result; //results

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);
            out.println(evaluate(exp.child(0)));
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}

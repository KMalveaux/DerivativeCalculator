import Terms.Term;
import Tree.EquationTreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the equation here: ");
    String equation = scanner.nextLine();
    buildEquationTree(equation);
  }

  static void buildEquationTree(String equation) {
    EquationTreeNode root = new EquationTreeNode();
    String token = "";
    Term tokenizer = new Term();

    for (int i = 0; i < equation.length(); i++) {
      char c = equation.charAt(i);
      if (Character.isDigit(c) || c == '.') {
        token += c;
      } else if (Character.isLetter(c)) {
        Term term = tokenizer.terminize(1, token);
        Terms.Num term1 = (Terms.Num) term;
        term1.printValue();
        token = "";
        token += c;
      } else {
        if (token.length() > 0) {
          Term term = tokenizer.terminize(2, token);
          Terms.Var term1 = (Terms.Var) term;
          term1.printValue();
          token = "";
        }
        if (c != ' ') {
          System.out.println(c);
          if (c == '(') {
            tokenizer.terminize(3, String.valueOf(c));
          } else if (c == ')') {
            tokenizer.terminize(4, String.valueOf(c));
          }
        }
      }
    }

    if (token.length() > 0) {
      System.out.println(token);
    }
  }

  /**
   * Gets all terms in an equation
   * @param equation The equation to have its operands pulled
   * @return String array of all terms
   */
  static List<String> getTerms(String equation) {
    String[] operators = { "+", "-", "*", "/" };
    Scanner scanner = new Scanner(equation);
    String term = "";
    List<String> termList = new ArrayList<>();

    while (scanner.hasNext()) {
      String token = scanner.next();

      if (Arrays.asList(operators).contains(token)) {
        if (term.isEmpty()) {
          scanner.close();
          System.err.println("Invalid equation: " + equation);
          return null;
        }
        termList.add(term);
        term = "";
      } else {
        term += token;
      }
    }

    if (!term.isEmpty()) {
      termList.add(term);
    }

    scanner.close();
    return termList;
  }
}

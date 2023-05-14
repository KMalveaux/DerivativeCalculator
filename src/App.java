import Terms.Term;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the equation here: ");
    String equation = scanner.nextLine();
    List<Term> termList = Tokenizer.buildEquationTree(equation);

    System.out.println("Items in the termList: ");
    for (Term term : termList) {
      term.printValue();
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

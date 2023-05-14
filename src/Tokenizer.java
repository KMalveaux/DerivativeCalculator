import Terms.Term;
import java.util.ArrayList;
import java.util.List;

public class Tokenizer {

  static List<Term> buildEquationTree(String equation) {
    Term tokenizer = new Term();
    List<Term> termList = new ArrayList<Term>();
    StringBuilder token = new StringBuilder();

    for (int i = 0; i < equation.length(); i++) {
      char c = equation.charAt(i);

      if (Character.isLetter(c)) {
        while (Character.isLetter(c)) {
          token.append(c);

          if (i == equation.length() - 1) {
            termList.add(tokenizer.terminize(2, token.toString()));
            token.delete(0, token.length());
            return termList;
          }
          i++;
          c = equation.charAt(i);
        }
        i--;
        termList.add(tokenizer.terminize(2, token.toString()));
        token.delete(0, token.length());
      } else if (Character.isDigit(c)) {
        if (Character.isDigit(c)) {
          while (Character.isDigit(c)) {
            token.append(c);

            if (i == equation.length() - 1) {
              termList.add(tokenizer.terminize(1, token.toString()));
              token.delete(0, token.length());
              return termList;
            }
            i++;
            c = equation.charAt(i);
          }
          i--;
          termList.add(tokenizer.terminize(1, token.toString()));
          token.delete(0, token.length());
        }
      } else {
        switch (c) {
          case '(':
            termList.add(tokenizer.terminize(3, token.toString()));
            token.delete(0, token.length());
            break;
          case ')':
            termList.add(tokenizer.terminize(4, token.toString()));
            token.delete(0, token.length());
            break;
          case '+':
            termList.add(tokenizer.terminize(5, token.toString()));
            token.delete(0, token.length());
            break;
          case '*':
            termList.add(tokenizer.terminize(6, token.toString()));
            token.delete(0, token.length());
            break;
        }
      }
    }
    return termList;
  }
}

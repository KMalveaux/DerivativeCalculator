package Terms;

public class Term {

  public Term terminize(int termID, String value) {
    switch (termID) {
      case 1:
        return new Num(value);
      case 2:
        return new Var(value);
      case 3:
        return new Lparen();
      case 4:
        return new Rparen();
    }

    return null;
  }
}

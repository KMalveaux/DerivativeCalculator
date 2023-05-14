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
      case 5:
        return new Plus();
      case 6:
        return new Multiply();
    }
    return null;
  }

  public void printValue() {}
}

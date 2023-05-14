package Terms;

public class Var extends Term {

  public String name = null;

  public Var(String variableName) {
    name = variableName;
  }

  public void printValue() {
    System.out.println("Var: " + name);
  }
}

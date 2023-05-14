package Terms;

public class Var extends Term {

  public String name = null;

  public Var(String variableName) {
    name = variableName;
    System.out.println("Var: " + name);
  }

  @Override
  public void printValue() {
    System.out.println("Var: " + name);
  }
}

package Terms;

public class Num extends Term {

  private double value;

  public Num(String number) {
    value = Integer.parseInt(number);
    System.out.println("Const: " + value);
  }

  @Override
  public void printValue() {
    System.out.println("Const: " + value);
  }
}


public class AdditionCycles {

    public static int numberOfCycle = 0;

    public int cycleLength(int n) {

        Number original = new Number(n);
        Number a = new Number(n);

        while (true) {
            Number b = new Number(a.left + a.right);
            Number c = new Number(a.right, b.right);

            numberOfCycle++;

            if(c.equals(original)) {
                return numberOfCycle;
            } else {
                a = c;
            }
        }
    }

    public static void main(String args[]) {
        AdditionCycles a = new AdditionCycles();
        System.out.println("Number of cycles=" + a.cycleLength(71));
    }
}

class Number {
    int left;
    int right;

    public Number(int n) {
        this.left =  n /10;
        this.right = n % 10;
    }

    public Number(int left, int right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Number number = (Number) o;

        if (left != number.left) return false;
        return right == number.right;
    }

    @Override
    public int hashCode() {
        int result = left;
        result = 31 * result + right;
        return result;
    }
}



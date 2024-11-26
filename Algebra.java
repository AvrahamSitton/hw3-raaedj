// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {

	public static void main(String args[]) {
		// Tests some of the operations

		/*
		 * System.out.println(plus(-2, -3)); // 2 + 3 = 5
		 * System.out.println(minus(-7, -2)); // 7 - 2 = 5
		 * System.out.println(minus(-2, 7)); // 2 - 7 = -5
		 * System.out.println(times(0, -1)); // 3 * 4 = 12
		 * System.out.println(times(-3, 1)); // 3 * 4 = 12
		 * System.out.println(times(3, -1)); // 3 * 4 = 12
		 * System.out.println(times(-3, 1)); // 3 * 4 = 12
		 * System.out.println(times(3, 4)); // 3 * 4 = 12
		 * System.out.println(times(-3, -4)); // 3 * 4 = 12
		 * System.out.println(times(-3, -4)); // 3 * 4 = 12
		 * System.out.println(plus(2, times(4, 2))); // 2 + 4 * 2 = 10
		 * System.out.println(pow(-5, 3)); // 5^3 = 125
		 * System.out.println(pow(0, 3)); // 5^3 = 125
		 * 
		 * System.out.println(pow(-5, 0)); // 5^3 = 125
		 * System.out.println(pow(-5, -3)); // 5^3 = 125
		 * System.out.println(pow(5, 3)); // 5^3 = 125
		 * System.out.println(pow(-5, 3)); // 5^3 = 125
		 * 
		 * System.out.println(pow(-3, 4)); // 3^5 = 243
		 */System.out.println(div(12, -3)); // 12 / 3 = 4
		System.out.println(div(-12, 3)); // 12 / 3 = 4
		System.out.println(div(12, -3)); // 12 / 3 = 4
		System.out.println(div(12, 12)); // 12 / 3 = 4
		System.out.println(div(-12, -12)); // 12 / 3 = 4
		System.out.println(div(12, 0)); // 12 / 3 = 4
		System.out.println(div(0, 3)); // 12 / 3 = 4

		System.out.println(div(5, 4)); // 5 / 5 = 1
		System.out.println(div(25, -7)); // 25 / 7 =

		System.out.println(mod(25, 7)); // 25 % 7
		System.out.println(mod(120, 6)); // 120 % 6
		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
		System.out.println(sqrt(76123));
		System.out.println(sqrt(7));
		System.out.println(sqrt(13));
		System.out.println(sqrt(17));
		System.out.println(sqrt(3));
		System.out.println(sqrt(6));
		System.out.println(sqrt(2));
		System.out.println(sqrt(0));
		System.out.println(sqrt(100));


	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int result = x1;
		if (x2 >= 0) {
			for (int i = 0; i < x2; i++) {
				result++;
			}
		} else {
			for (int i = 0; i > x2; i--) {
				result--;
			}

		}
		return result;

	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int result = x1;
		if (x2 >= 0) {
			for (int i = 0; i < x2; i++) {
				result--;
			}
		} else {
			for (int i = 0; i > x2; i--) {
				result++;
			}

		}
		return result;

	}

	// return the absulot val of x
	public static int abs(int x) {
		int temp = 0;
		int result = x;
		if (x >= 0) {
			return result;
		} else
			while (x < 0) {
				x++;
				temp++;

			}
		return temp;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int result = 0;
		int i = abs(x1);
		int j = abs(x2);
		while (i > 0) {
			i--;
			result = plus(result, j);
		}
		if ((x1 > 0 && x2 < 0) || (x1 < 0 && x2 > 0)) {
			return -result;
		}
		return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int result = 1;
		if (n <= 0 || x == 1) {

			return 1;
		} else if (n < 0) {
			return result;
		}
		for (int i = 0; i < n; i++) {
			result = times(result, x);
		}

		return result;
	}

	// Returns the integer part of x1 / x2
	public static int div(int x1, int x2) {
		int result = 0;
		if (x2 == 0) {
			return result;
		} else if (x1 == x2) {
			return 1;
		} else if (abs(x1) == abs(x2)) {
			return -1;
		} else if (abs(x2) > abs(x1)) {
			return 0;
		} else
			while (times(result, abs(x2)) <= abs(x1)) {
				// System.out.println(result); // 12 / 3 = 4

				result++;
			}
		if ((x1 > 0 && x2 < 0) || (x1 < 0 && x2 > 0)) {
			return plus(times(result, -1), 1);

		} else
			return minus(result, 1);

	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int result = minus(x1, times(div(x1, x2), x2));
		return result;

	}
	// Returns the integer part of sqrt(x)
    public static int sqrt(int x) {
		int h = x ;
		int l = 1;
		int result = 0;
		if (x == 0 || x == 1) {
			return x;
		}
		while (l <= h) {
            result = plus(l , div((minus(h , l)) , 2));

            if (pow(result , 2) == x) {
                return result;
            } else if (pow(result , 2) < x) {
             //   result = result; 
                l = plus(result, 1);
            } else {
                h = minus(result, 1);
            }
        }

        return result;
    }

	}



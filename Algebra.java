// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		// Tests some of the operations
		System.out.println(plus(-2, -3)); // 2 + 3 = 5
		System.out.println(minus(-7, -2)); // 7 - 2 = 5
		System.out.println(minus(-2, 7)); // 2 - 7 = -5
		System.out.println(times(-3, -4)); // 3 * 4 = 12
		System.out.println(plus(2, times(4, 2))); // 2 + 4 * 2 = 10
		System.out.println(pow(-5, 3)); // 5^3 = 125
		System.out.println(pow(-3, 4)); // 3^5 = 243
		System.out.println(div(12, 3)); // 12 / 3 = 4
		System.out.println(div(5, 5)); // 5 / 5 = 1
		System.out.println(div(25, -7)); // 25 / 7 =
		System.out.println(mod(25, 7)); // 25 % 7
		System.out.println(mod(120, 6)); // 120 % 6
		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
		System.out.println(sqrt(76123));
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int result = x1;
		if (x2 > 0) {
			while (x2 > 0) {
				x1++;
				x2--;
			}
		} else if (x2 < 0) {
			while (x2 < 0) {
				x1--;
				x2++;
			}

		}
		return result;

	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int result = x1;
		if (x2 > 0) {
			while (x2 > 0) {
				x1--;
				x2--;
			}
		} else if (x2 < 0) {
			while (x2 < 0) {
				x1++;
				x2++;
			}

		}

		return result;
	}
//return the absulot val of x
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
		int result = 1;
		if (x1 == 0 || x2 == 0) {
			return 0;
		} else if (x1 < 0 ^ x2 < 0) {
			if (x1 < 0) {
				for (int i = 0; i < x2; i++) {
					result = minus(x1, result);
				}

			} else
				for (int i = 0; i > x2; i--) {
					result = minus(x1, result);
				}
		} else
			x1 = abs(x1);
		x2 = abs(x2);
		for (int i = 0; i < x2; i++) {
			result = plus(x1, result);
		}
		return result;
	}

}

// Returns x^n (for n >= 0)
public static int pow(int x, int n) {
	int result = 0;
	if (x == 0) {
		return result;
	} else if (n == 0 || x == 1) {
		result = 1;
		return result;
	} else {
		result = x;
		for (int i = 0; i < n - 1; i++) {
			result = times(x, result);
		}

		return result;
	}
}

// Returns the integer part of x1 / x2
public static int div(int x1, int x2) {
	int result = 0;
	if (x2 == 0) {
		break;
	} else if (x1 == x2) {
		return 1;
	} else if (abs(x1) == abs(x2)) {
		return -1;
	} else if (abs(x2) > abs(x1)) {
		return 0;
	} else
		x1 = abs(x1);
	x2 = abs(x2);
	while (times(result, x2) < x1) {
		result++;
	}
	if (x1 < 0 ^ x2 < 0) {
		return times(result, -1);

	} else
		return result;

}

// Returns x1 % x2
public static int mod(int x1, int x2) {
	int result = 0;
	if (x1 == x2) {
	} else if (x1 < x2) {
		result = x1;
	} else {
		for (int i = 1; i < x1; i++) {
			if (times(i, x2) == x1) {
				result = 0;
				break;
			} else {
				if (times(i, x2) > x1) {
					result = times(i - 1, x2);
					result = minus(x1, result);
					break;
				}
			}
		}

	}
	return result;

}

// Returns the integer part of sqrt(x)
public static int sqrt(int x) {
	int result = 0;
	if (x == 0) {
	} else if (x == 1) {
		result = 1;
	} else {
		for (int i = 1; i < x; i++) {
			if (times(i, i) == x) {
				result = i;
				break;
			} else {
				if (times(i, i) > x) {
					result = i - 1;
					break;
				}
			}
		}

	}
	return result;
}

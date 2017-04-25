import java.math.BigInteger;
import java.util.Scanner;

// calculate modular exponentiation given modular multiplication given an interger basis a, integer exponent e, integer modulus m. 
public class ModExp {
	
	public static BigInteger mod_exp(BigInteger base, BigInteger exponent, BigInteger modulus){
		BigInteger result = new BigInteger("1");
		BigInteger two = new BigInteger("2");
		
		// get binary representation of exponent and splits base to muĺtiple factors
	    while (exponent.doubleValue() > 0){ // do while exponent still has a '1' in binary repres.
	        if (exponent.mod(two).longValue() == 1){ // check if left-most bit is '1'
	        	result = result.multiply(base); // multiply with current base
	        	result = result.mod(modulus);
	        }
	        exponent = exponent.shiftRight(1); // shift binary presentation to right
	        base = base.multiply(base); // set base to new left-most binary
	        base = base.mod(modulus);
	    }
		return result;
	}
    public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		BigInteger a, e, n, r;

        while (stdin.hasNextLine()) {
            //Read the line and split the values into a string array
            String[] input = stdin.nextLine().split(" ");
            a = new BigInteger(input[0]);
            e = new BigInteger(input[1]);
            n = new BigInteger(input[2]);
            r = new BigInteger("0");
            
            r = mod_exp(a, e, n);
            
//            System.out.println(a.toString() + " " + e.toString() + " " + n.toString() + " " + r.toString());
            System.out.println(r.toString());

		}
    }
 
}

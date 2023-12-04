import java.util.Scanner; 

public class HugeInteger {
    private int[] digits = new int[40];
    private int digitsLen;

    public void parse(String s) {
        digitsLen=s.length();
        for(int i=0;i<s.length();i++) {
            digits[i] = Character.getNumericValue(s.charAt(s.length()-i-1));
        }
    }
    public String toString() {
        char[] chars = new char[40];
        for(int i=0;i<digitsLen;i++) {
            chars[digitsLen-i-1] = (char)(digits[i]+'0');
        }
        String s = new String(chars);
        return s;
    }

    public HugeInteger add(HugeInteger h2) {
        int carry=0;
        HugeInteger result = new HugeInteger();
        result.digitsLen=Math.max(digitsLen,h2.digitsLen)+1;
        for(int i=0;i<result.digitsLen;i++) {
            result.digits[i]=(digits[i]+h2.digits[i]+carry)%10;
            carry=(digits[i]+h2.digits[i]+carry)/10;
        }
        if(result.digits[result.digitsLen-1]==0) result.digitsLen-=1;
        return result;
    }

    public HugeInteger subtract(HugeInteger h2) {
        int borrow=0;
        HugeInteger result = new HugeInteger();
        result.digitsLen=Math.max(digitsLen,h2.digitsLen);
        for(int i=0;i<result.digitsLen;i++) {
            result.digits[i]=digits[i]-h2.digits[i]-borrow;
            if(result.digits[i]<0) {
                result.digits[i]+=10;
                borrow=1;
            }
            else borrow=0;
        }
        if(result.digits[result.digitsLen-1]==0) result.digitsLen-=1;
        return result;
    }
    public boolean isEqualTo(HugeInteger h2) {
        if(digitsLen!=h2.digitsLen) return false;
        for(int i=0;i<digitsLen;i++) {
            if(digits[i]!=h2.digits[i]) return false;
        }
        return true;
    }
    public boolean isNotEqualTo(HugeInteger h2) {
        if(!isEqualTo(h2)) return true;
        return false;
    }
    public boolean isGreaterThan(HugeInteger h2) {
        if(digitsLen > h2.digitsLen) return true;
        if(digitsLen < h2.digitsLen) return false;
        for(int i=digitsLen-1;i>=0;i--) {
            if(digits[i]<h2.digits[i])return false;
        }
        return true;
    }
    public boolean isLessThan(HugeInteger h2) {
        if(!isGreaterThan(h2) && !isEqualTo(h2)) return true;
        return false;
    }
    public boolean isGreaterThanOrEqualTo(HugeInteger h2) {
        if(isGreaterThan(h2) || isEqualTo(h2)) return true;
        return false;
    }
    public boolean isLessThanOrEqualTo(HugeInteger h2) {
        if(isLessThan(h2) || isEqualTo(h2)) return true;
        return false;
    }
    public boolean isZero() {
        for(int i=0;i<digitsLen;i++) {
            if(digits[i]!=0)return false;
        }
        return true;
    }
    public void introdution() {
        System.out.println("This program do a simple calculate on huge integer.");
        System.out.println("The Demo program let two huge integer be add.");
        System.out.println("Please input two integer(>=0), each one in a line.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;

        HugeInteger h1 = new HugeInteger();
        h1.introdution();
        s = scanner.nextLine();
        h1.parse(s);

        HugeInteger h2 = new HugeInteger();
        s=scanner.nextLine();
        h2.parse(s);

        //====== do something below ======
        System.out.println(h1.add(h2));
        scanner.close();
    }
}

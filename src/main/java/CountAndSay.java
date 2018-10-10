/*

The count-and-say sequence is the sequence of integers beginning as follows:

1, 11, 21, 1211, 111221, ...
1 is read off as one 1 or 11.
11 is read off as two 1s or 21.

21 is read off as one 2, then one 1 or 1211.

Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.

Example:

if n = 2,
the sequence is 11.

Solution:

Find n'th term by generating all terms from 3 to n-1. Every term is generated  using previous term.
Initialize previous term
    String str = "11";


 */
package main.java;

public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(countnndSay(23));
    }

    static String countnndSay(int n)
    {
        if (n == 1)
            return "1";
        if (n == 2)
            return "11";

        StringBuilder sb1 = new StringBuilder("11");
        for (int i = 3; i <= n; i++)
        {
            // In below for loop, previous
            // character is processed in
            // current iteration. That is
            // why a dummy character is
            // added to make sure that loop
            // runs one extra iteration.
            sb1.append("$");
            int len = sb1.length();

            int cnt = 1;
            StringBuilder sb2 = new StringBuilder();
            // Process previous term
            // to find the next term
            for (int j = 1; j < len; j++)
            {
                if (sb1.charAt(j) != sb1.charAt(j - 1)) {
                    sb2.append(cnt);
                    sb2.append(sb1.charAt(j - 1));
                    cnt = 1;
                }
                else {
                    cnt++;
                }
            }
            sb1 = sb2;
        }

        return sb1.toString();
    }

}

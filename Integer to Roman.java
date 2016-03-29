public class Solution {
    /**
     * @param n The integer
     * @return Roman representation
     */
    public String intToRoman(int n) {
        // Write your code here
    String [][] c={{"0","I","II","III","IV","V","VI","VII","VIII","IX"},{"0","X","XX","XXX","XL","L","LX"
    ,"LXX","LXXX","XC"},{"0","C","CC","CCC","CD","D",
    "DC","DCC","DCCC","CM"},{"0","M","MM","MMM"}};
    int t=1;
    String st = "";
    if(n/1000!=0) st+=c[3][n/1000];
    if((n%1000)/100!=0) st+=c[2][(n%1000)/100];
    if((n%100)/10!=0) st+=c[1][(n%100)/10];
    if(n%10!=0) st+=c[0][n%10];
    return st;
    }
}
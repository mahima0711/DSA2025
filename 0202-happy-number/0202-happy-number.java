class Solution {
    public boolean isHappy(int n) {
          
       int slow = n;
       int fast = sumOfSquare(n);

       while(fast!=1 && slow!=fast)
       {
        slow = sumOfSquare(slow);
        fast = sumOfSquare(sumOfSquare(fast));
       }
       return fast ==1;
    }
    public int sumOfSquare(int n)
    {
      int sum =0;
      while(n>0)
      {
        int num = n%10;
        sum =sum+(num*num);
        n/=10;
      }
      return sum;
    }
}
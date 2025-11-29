class Solution {
    public int maxArea(int[] height) {
        
        int i=0;
        int j=height.length-1;

        int ans =0;

        while(i<j)
        {
          int w = (j-i)* getMin(height[i],height[j]);
          if(ans<w)
          {
            ans=w;
          }
          if(height[i]>height[j])
          {
            j--;
          }
          else
          {
            i++;
          }

        }

        return ans;
    }

    public int getMin(int a, int b)
    {
        if(a>=b)
        return b;
        else
        return a;
    }
}
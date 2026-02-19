class Solution {
    public List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<>();

        StringBuilder str = new StringBuilder();
        int parts =0;

        backTrack(0, s, result, str, parts);
        return result;
    }

    void backTrack(int idx, String s, List<String> list, StringBuilder str, int parts)
    {
        if(idx == s.length() && parts == 4)
        {
            list.add(str.toString());
            return;
        }

        if(idx == s.length() || parts > 4)
          return;

        for(int i=idx;i<s.length();i++)
        {
            String curr = s.substring(idx, i+1);
            if(isValid(curr))
            {
                int len = str.length();
                if(len>0)
                {
                    str.append(".").append(curr);
                }
                else
                {
                    str.append(curr);
                }
                backTrack(i+1, s, list, str, parts+1);
                str.setLength(len);
            }
        }
    }

    boolean isValid(String s)
    {
        if (s.length() == 0 || s.length() > 3)
        return false;

    if (s.length() > 1 && s.charAt(0) == '0')
        return false;

    int num = Integer.parseInt(s);

    return num <= 255;
    }
}
/*Given a string n, your task is to find whether it contains an additive sequence or not. A string n contains an additive sequence if its digits can make a sequence of numbers in which every number is addition of previous two numbers. You are required to complete the function which returns true if the string is a valid sequence else returns false. For better understanding check the examples.*/

===============================================================================================================================================================
class Solution {
    public boolean isAdditiveSequence(String n) {
    
        // code here
              int m = (int)Math.min(18,n.length());
        for(int i=0;i<m;i++){
            int k = 0;
            for(int j=i+1;j<m;j++){
                long a = Long.parseLong(n.substring(k,i+1));
                long b = Long.parseLong(n.substring(i+1,j+1));
                long sum = a+b;
                int l = (sum+"").length();
                if(n.substring(j+1).length()>=l){
                    if(Long.parseLong(n.substring(j+1,j+l+1))==sum){
                        i = j;
                        k = i;
                        j = j+l-1;
                        if(j+1==m-1){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    
}

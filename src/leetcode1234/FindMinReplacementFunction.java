package leetcode1234;

public class FindMinReplacementFunction {
	// Sliding window method
    public int balancedString(String s) {
    	// 128 since it's QWER
        int[] map = new int[128];
        
        int n = s.length();
        
        // length of multiple of four
        int k = n / 4;
        
        int result = n;
        
        // count all the letters first
        for(char letter : s.toCharArray()){
            map[letter]++;
        }
        
        int left = 0, right = 0;
        
        while(right < n){
            map[s.charAt(right)]--;
            
            right++;
            
            // Left pointer will start moving when the right side of right pointer does not need replace anymore
            while(left < n && map['Q'] <= k && map['W'] <= k && map['E'] <= k && map['R'] <= k){
                result = Math.min(result, right - left);
                
                map[s.charAt(left)]++;
                
                left++;
            }
        }
    
        return result;
    }
}

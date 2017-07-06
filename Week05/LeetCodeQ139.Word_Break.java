/*LeetCodeQ139.Word_Break. !Essential
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
For example, given
s = "leetcode",
dict = ["leet", "code"].
Return true because "leetcode" can be segmented as "leet code".
*/
//Solve with dp
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null || s=="") return false;
        if(s.length()==1) return wordDict.contains(s) ? true : false;
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                if(dp[j] && wordDict.contains(s.substring(j,i)) ? true : false){
                    dp[i] = true;  //in this if, we already know that we can reach i.
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    
    //Solve with recursive call...
    //Below can solve normal problems. but cause Time Exceeded some times 
    // public boolean findWord(String s, List<String> wordDict) {      
    //     for(int i=1; i<=s.length(); i++){
    //         if(i==s.length())
    //             if(wordDict.contains(s) ? true : false)
    //                 return true;
    //         }
    //         else if(wordDict.contains(s.substring(0,i)) ? true : false){
    //             if(findWord(s.substring(i),wordDict)) return true;
    //         }
    //     }
    //     return false;
    // }
}
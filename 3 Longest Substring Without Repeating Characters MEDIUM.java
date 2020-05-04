//3 Longest Substring Without Repeating Characters MEDIUM.java
//TimeComplexity: O(n)
//SpaceComplexity: O(n) worst case we need to store all the elements in the hashmap
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        //assuming the string starts from the 0th index and end index is the same initially
        if(s.equals(""))
            return 0;
         if(s.equals(" "))
            return 1;
       
        int startIndex = 0;
        int endIndex = 0;
        int counter = 0;
        int maxCount = 0;
        HashMap<Character,Integer> seen = new HashMap<>();
        for( int i = 0; i < s.length(); ++i){
            char currentChar = s.charAt(i);
            
            if(!seen.containsKey(currentChar)){
                //new element from the substring
                //add to the seen part with index where it was seen
                seen.put(currentChar,i);
                //part of the longest substring without repeating
                //so increase the counter
                counter++;
            }
            else
            {
                //substring ends here
                //choosing for the max count
                if(counter >= maxCount){
                    maxCount = counter;
                    //counter = 1;
                }
                //have already seen in the substring
                //increase the index by one from last assigned value
                int newStartIndex = seen.get(currentChar);
                while(startIndex != newStartIndex){
                    //remove all the elements from the seen
                    //till we reach the new startIndex
                    seen.remove(s.charAt(startIndex));
                    startIndex++;
                    counter--;
                }
                startIndex = newStartIndex+1;
                seen.put(currentChar,i);
            }
            
        }
        if(counter > maxCount){
            maxCount = counter;
        }
        return maxCount;
    }
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int k=s1.length();
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);
            freq1[ch-'a']++;
        }
        int x=0;
        while(x<k){
            char ch=s2.charAt(x);
            freq2[ch-'a']++;
            x++;
        }
        if (Arrays.equals(freq1, freq2)) return true;
        int left=0;
        int right=k;
        while(right<s2.length()){
            char ch=s2.charAt(right);
            char ch1=s2.charAt(left);
            freq2[ch-'a']++;
            freq2[ch1-'a']--;
            if (Arrays.equals(freq1, freq2)) return true;
            left++;
            right++;
        }
        return false;
    }
}
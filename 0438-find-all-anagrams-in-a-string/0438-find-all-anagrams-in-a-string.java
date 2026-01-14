class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
        if(p.length()>s.length()){
            return list;
        }
        int k=p.length();
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < p.length(); i++) {
            freq1[p.charAt(i) - 'a']++;
            freq2[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(freq1, freq2)){
            list.add(0);
        }

        int left = 0;
        for (int right = k; right < s.length(); right++) {
            freq2[s.charAt(right) - 'a']++;
            freq2[s.charAt(left) - 'a']--;
            left++;

            if (Arrays.equals(freq1, freq2)){
                list.add(left);
            }
        }

        return list;
    }
}
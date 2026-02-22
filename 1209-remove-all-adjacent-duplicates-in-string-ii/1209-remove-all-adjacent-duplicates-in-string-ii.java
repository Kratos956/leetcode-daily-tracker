import java.util.*;
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Map.Entry<Character, Integer>> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!stack.isEmpty() && stack.peek().getKey() == ch) {
                stack.peek().setValue(stack.peek().getValue() + 1);
                if (stack.peek().getValue() == k) {
                    stack.pop();
                }
            } else {
                stack.push(new AbstractMap.SimpleEntry<>(ch, 1));
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            Map.Entry<Character, Integer> entry = stack.pop();
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }

        return sb.reverse().toString();
    }
}
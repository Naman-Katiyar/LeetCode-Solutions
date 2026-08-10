class Solution {
    public String largestEven(String s) {
        int n = s.length();

        if (s.charAt(n - 1) == '2') {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                break;
            }
        }

        return sb.toString();
    }
}
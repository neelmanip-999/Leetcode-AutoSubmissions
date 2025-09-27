class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int length = 1;

        while (count < n) {
            int half = (length + 1) / 2;
            long start = (long) Math.pow(10, half - 1);
            long end = (long) Math.pow(10, half);

            for (long root = start; root < end && count < n; root++) {
                String s = Long.toString(root);
                long pal;
                if (length % 2 == 0) {
                    pal = Long.parseLong(s + new StringBuilder(s).reverse());
                } else {
                    pal = Long.parseLong(s + new StringBuilder(s.substring(0, s.length() - 1)).reverse());
                }

                if (isPalindromeInBase(pal, k)) {
                    sum += pal;
                    count++;
                }
            }
            length++;
        }
        return sum;
    }

    private boolean isPalindromeInBase(long x, int base) {
        StringBuilder sb = new StringBuilder();
        while (x > 0) {
            sb.append(x % base);
            x /= base;
        }
        String str = sb.toString();
        return str.equals(sb.reverse().toString());
    }
}

class RomanToInt {
    public int romanToInt(String s) {
        Map<Character, Integer> romanIntMap = new HashMap<>();
        romanIntMap.put('M', 1000);
        romanIntMap.put('D', 500);
        romanIntMap.put('C', 100);
        romanIntMap.put('L', 50);
        romanIntMap.put('X', 10);
        romanIntMap.put('V', 5);
        romanIntMap.put('I', 1);

        // Right to left
        int length = s.length() - 1;
        int total = 0;
        int current = 0;
        int prev = 0;
        while (length >= 0) {
            current = romanIntMap.get(s.charAt(length));
            if (current >= prev) {
                total += current;
            } else {
                total -= current;
            }
            prev = current;
            length--;

        }
        return total;
    }

}
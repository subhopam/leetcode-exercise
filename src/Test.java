class Test {
	public static void main(String[] args) {
		String str = "abz";
		for (int i = 0; i < str.length(); i++) {
			System.out.println("char = " + str.charAt(i));
			System.out.println("a = " + 'a');
			int val = str.charAt(i) - 'a';
			System.out.println("val = " + (1 << val));
		}

	}
}
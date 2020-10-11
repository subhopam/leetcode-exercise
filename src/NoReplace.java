public String notReplace(String str) {
  String[] tokens = str.split("^[a-zA-Z0-9]+$");
  System.out.println(Arrays.toString(tokens));
  StringBuffer sb = new StringBuffer();
  for (int i = 0; i < tokens.length; i++) {
    if (tokens[i].equals("is")) {
      sb.append(" is not ");
    } else {
      sb.append(tokens[i]);
    }
  }
  return sb.toString();
}

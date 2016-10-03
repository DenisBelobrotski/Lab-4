class CommentCleaner {
    public static String deleteComments(String string) {
        StringBuilder sb = new StringBuilder();
        boolean isComment = false;
        for (String tempString : string.split("\n")) {
            StringBuilder newSb = new StringBuilder(tempString + "\n");
            for (int i = 0; i < newSb.length(); i++) {
                if (!isComment && newSb.charAt(i) == '"' && newSb.charAt(i - 1) != '\'') {
                    sb.append(newSb.charAt(i));
                    i++;
                    while (i < newSb.length() && !isEndOfString(newSb, i)) {
                        sb.append(newSb.charAt(i));
                        i++;
                    }
                }
                if (!isComment && i < newSb.length() - 1 && newSb.charAt(i) == '/' && newSb.charAt(i + 1) == '/') {
                    sb.append("\n");
                    break;
                }
                if (!isComment && i < newSb.length() - 1 && newSb.charAt(i) == '/' && newSb.charAt(i + 1) == '*') {
                    isComment = true;
                    i += 2;
                }
                if (isComment && i < newSb.length() - 1 && newSb.charAt(i) == '*' && newSb.charAt(i + 1) == '/') {
                    i += 2;
                    isComment = false;
                }
                if (!isComment && i < newSb.length()) {
                    sb.append(newSb.charAt(i));
                }
            }
        }
        return sb.toString();
    }

    private static boolean isEndOfString(StringBuilder str, int index) {
        if (index < str.length() && str.charAt(index) == '"') {
            if (str.charAt(index - 1) == '\\') {
                if (str.charAt(index - 2) == '\\') {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }
}
class GenerateParanthesis {
    public static List<String> generateParenthesis(int n) {
       List<String> result = new ArrayList<>();
       int openCount = 0;
       int closedCount = 0;
       recurse(2*n, "", openCount, closedCount, result);
       return result;
    }

    private static void recurse(int length, String paran, int openCount, int closedCount, List<String> result) {
        if(paran.length() == length) {
            result.add(paran);
            return;
        }

        if(openCount < length / 2) {
            recurse(length, paran + "(", openCount + 1, closedCount, result);
        }

        if (closedCount < openCount) {
            recurse(length, paran + ")", openCount, closedCount + 1, result);
        }
    }

    public static void main(String[] args) {
        System.out.println(GenerateParanthesis(3));
    }
}
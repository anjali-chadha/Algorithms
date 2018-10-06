package ctci;

public class UniqueCharacters {

    private boolean hasUniqueCharacters(String s) {
        char[] array = s.toCharArray();
        boolean[] indexArray = new boolean[128];

        for(char c: array) {
            if(indexArray[c]) {
                return false;
            } else {
                indexArray[c] = true;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        UniqueCharacters o = new UniqueCharacters();
        System.out.println(o.hasUniqueCharacters("anjali"));
    }
}

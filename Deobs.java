import java.util.Base64;
public class Deobs {
    public static final String key = "89JFSjo8HUbhou5776NJOMp9i90ghg7Y78G78t68899y79HY7g7y87y9ED45Ew30O0jkkl";

    public static void main(String args[]) {
        String enc = getBase64(new String(Base64.getDecoder().decode(args[0])), true);
        System.out.println(enc);
    }

    public static String getBase64(String str, boolean z) {
        byte[] bytes;
        try {
            if (z) {
                int length = str.length();
                char[] cArr = new char[length];
                for (int i = 0; i < length; i++) {
                    cArr[i] = 0;
                }
                for (int i2 = 0; i2 < length; i2++) {
                    cArr[i2] = (char) (str.charAt(i2) ^ key.charAt(i2 % 70));
                    if (cArr[i2] == 0) {
                        cArr[i2] = str.charAt(i2);
                    }
                }
                bytes = new String(cArr).getBytes("UTF-8");
            } else {
                bytes = str.getBytes("UTF-8");
            }
            return new String(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

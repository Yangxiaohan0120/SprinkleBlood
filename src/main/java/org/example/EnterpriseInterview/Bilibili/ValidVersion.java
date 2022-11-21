package org.example.EnterpriseInterview.Bilibili;

/**
 * @author Chris Yang
 * created 2022-08-11 13:24
 **/
public class ValidVersion {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n1 = v1.length;
        int n2 = v2.length;
        int len = Math.max(n1, n2);

        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < len; i++) {
            if (i < n1) {
                c1 = Integer.parseInt(v1[i]);
            }
            if (i < n2) {
                c2 = Integer.parseInt(v2[i]);
            }
            if (c1 == c2) {
                continue;
            } else if (c1 > c2) {
                return -1;
            } else {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String version1 = "1.01", version2 = "1.001";
        System.out.println(new ValidVersion().compareVersion(version1,version2));
    }
}

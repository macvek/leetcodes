import java.io.FileInputStream;

public class IntArrayFromFile {
    public static final Integer[] load(String path) {
        try (FileInputStream f = new FileInputStream(path)) {
            byte[] buffer = new byte[1024*1024];
            int count = f.read(buffer);
            String s = new String(buffer,0,count);
            String[] split = s.split(",");
            Integer[] ret = new Integer[split.length];
            for (int i=0;i<split.length;i++) {
                ret[i] = "null".equals(split[i]) ? null : Integer.valueOf(split[i]);
            }

            return ret;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

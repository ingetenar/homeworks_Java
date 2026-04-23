package Challenge2_Methods;

public class A_byte_converter {

        public static void convertBytes(long bytes) {
        double kb = bytes / 1024.0;
        double mb = kb / 1024.0;
        double gb = mb / 1024.0;
        double tb = gb / 1024.0;

        System.out.println("Bytes: " + bytes);
        System.out.println("Kilobytes: " + kb);
        System.out.println("Megabytes: " + mb);
        System.out.println("Gigabytes: " + gb);
        System.out.println("Terabytes: " + tb);
    }

    public static void main(String[] args) {
        convertBytes(123456789);
    }
}
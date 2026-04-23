package Challenge2_Methods;

public class A_barking_dog {
    
    public static boolean shouldWakeUp(boolean barking, int hourOfDay) {

        if (hourOfDay < 0 || hourOfDay > 23) {
            return false;
        }

        if (barking && (hourOfDay < 8 || hourOfDay > 22)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(shouldWakeUp(true, 1)); 
        System.out.println(shouldWakeUp(false, 2)); 
        System.out.println(shouldWakeUp(true, 23)); 
    }
}
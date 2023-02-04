package kozmetickisalon.alati;

public class Alati {
    
    public static boolean sadrziBrojeve(String str) {
        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                return true;
            }
        }
        return false;
    }
    
}

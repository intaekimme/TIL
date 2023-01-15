public class print52 {
    public static void main(String args[]){
        System.out.println(f(215, 5));
    }

    public static int f(int x,int y){
        if(x == 0) return 0;
        return f(x / 3, y * 3) + x % 3 * y;
    }
}


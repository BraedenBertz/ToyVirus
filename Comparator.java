/*
 * @Author Braeden Bertz
 */
import java.util.Random;

enum Comparator {

    //This acts as a + or - sign, so I can randomly assign an additive value of positive or negative
    AssignSign {
        int e(int a) {
            Random ran = new Random();
            int temp = ran.nextInt(100);
            if(temp % 2 == 0){
                return 0-a;
            }
            else {
                return a;
            }
        }
    },;
    abstract int e(int a);
}
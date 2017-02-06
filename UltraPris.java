import javax.swing.*;
import java.util.InputMismatchException;

/**
 * Created by olfi15 on 2017-02-06.
 */

public class UltraPris {
    public static void main(String[] Args) {

        Person Anton = new Person();

        String inputAge = JOptionPane.showInputDialog(null, "Hur gammal är du?");
        try {
            Anton.setAge(inputAge);
        } catch (IllegalArgumentException e) {                        //Här fångar jag IllegalArgumentExpection.
            System.out.println("Jag kastade ett IllegalArgumentException för att din ålder är under 0.");
        }


        System.out.println(Anton.getPrice());


    }
}
class Person {

    private int Age;
    private int[] Prices = {14, 28, 34, 28};    //Prislistan

    public int getAge() {
        return Age;
    }


    /*
    * Bara att kasta vidare IllegalArgumentException. Behöver den inte här.
    */
    public void setAge(String age) throws IllegalArgumentException {
        Age = validateAge(age);
    }


    /*
    * Kolla så att åldern är riktig, den måste vara en integer över 0.
    *
    *
     */
    private int validateAge(String age) {
        int validAge = 0;
        try {
            validAge = Integer.parseInt(age);   //Testa att parsa åldern. Eftersom att vi läser in den som en string måste vi parsa.
        } catch (NumberFormatException e) {     //Åldern är inte en siffra.
            System.out.println("Fick en NumberFormatExpection när jag försökte parsa din ålder. Din ålder är inte en siffra.");
        }
        if(Age <= 0) {
            throw new IllegalArgumentException();
        }
        return validAge;
    }
    /*
    * Skaffar biljettpriset från getAge.
    *
    * Se till att sätta priset med setAge innan.
    */
    public int getPrice() {
        if(getAge() <= 6) {
            return 0;
        } else if (getAge() <= 19) {
            return Prices[0];
        } else if (getAge() <= 25) {
            return Prices[1];
        } else if (getAge() <= 64) {
            return Prices[2];
        }
        return Prices[3];
    }
}

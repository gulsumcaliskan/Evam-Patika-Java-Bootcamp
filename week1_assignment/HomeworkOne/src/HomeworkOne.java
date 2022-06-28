
import java.util.Scanner;

public class HomeworkOne {
    
//    Homework Week 1

/*
    Aþaðýdaki kod satirlarina göre kaç tane obje yaratilacaktir ?
    
    String s1="Welcome"; 
    String s2="Welcome"; 
    String s3="Welcome"; 
   
  
Answer: Only one object will be created. All of three variables; s1, s2, and s3 will refer to the same object i.e. "Welcome".
So, in the string pool memory they will point the same reference. 
*/
    
    
/*1)  static ve String data tipinde degisken yaratalim. Ve degeri <<code>> olsun.*/

//Created a static and String data type which the value of variable is code.
    static String code = "code";
    
/* 2)   
Dönüþ tipi String olan ve String[] parametre alan bir metod yazalim. 
Gelen parametrenin içinde en az 5 farkli String olsun. 
Her bir eleman içinde static olarak belirledigimiz value içeriyor 
mu içermiyor mu kosulunu kontrol etsin. 
*/
    
/*Takes an array of Strings and return the first String that contains
code.*/
    public static String isContains(String[] strArray){
        
        for(String item : strArray){
            if(item.contains(code)){
                return "The value of the String that contains the defined value is\n"
                		+ "(Tanimli value'yu iceren String deger): " + item;
            }
        }
        return "It is not found the value of the String that contains the defined value.\n"
        		+ "(Tanimli value'yu iceren String deger bulunamadi.)";
    }


 /*3)
Main metod içerisinde metoda gönderecegimiz parametreleri 
kullanicidan Scanner ile input olarak alalim. Metod 
içerisinde belirlenen static <<code>> stringini içeren 
String bulunsun, bulunan String metoddan döndürülsün. 
(1 tane String belirledigimiz degeri içeriyor olacak) 
Console'a "Tanimli value yu içeren 
String deger: " + <<String_deger_adi>> 
*/
    
    public static void main (String[] args) {

        Scanner scan = new Scanner(System.in);
        
        System.out.print("How many numbers will you add?: ");
        int number = scan.nextInt();
        
        String[] inputArray = new String[number];
        
/* Given a condition until the statements will work by writing the inputs 
at the console if the user entered 5 or more than 5 inputs. */    
        if(number >= 5){
            for(int i = 0; i < number; i++){
                System.out.print("Item of the "  + (i+1) + ": ");
                inputArray[i] = scan.next();
            }
                      
            scan.close();
            
            System.out.println(isContains(inputArray));
        }else {
            System.out.println("The number of the (inputs) Strings can't be less than 5!!!");
        }
    }
}

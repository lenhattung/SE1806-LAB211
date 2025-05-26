/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tools;

/**
 *
 * @author tungi
 */
public interface Acceptable {
    public static String customerCodeRegex = "^[CGKcgk]\\d{4}$";
    public static String nameRegex = "^.{2,25}$";
    public static String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    // Viettel: 032, 033, 034, 035, 036, 037, 038, 039, 086, 096, 097, 098
    // Mobi: 090, 093, 089, 070, 079, 077, 076, và 078
    // Vina: 081, 082, 083, 084, 085, 088, 091 và 094
    // Vietnamobile: 052, 056, 058 và 092
    public static String phoneRegex = "^(03[2-9]|086|09[6-8]|090|093|089|070|079|077|076|078|081|082|083|084|085|088|091|094|052|056|058|092)\\d{7}$";
    
    public static boolean isValid(String data, String pattern){
        return data.matches(pattern);
    }
}

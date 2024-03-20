package com.example;

public class App {

    static void reversePalindrome(String palindrome){
        // String palindrome = "Dot saw I was Tod";
        int len = palindrome.length();
        char[] tempCharArray = new char[len];
        char[] charArray = new char[len];

        // put original string in an
        // array of chars
        for (int i = 0; i < len; i++) {
            tempCharArray[i] = palindrome.charAt(i);
        }

        // reverse array of chars
        for (int j = 0; j < len; j++) {
            charArray[j] = tempCharArray[len - 1 - j];
        }

        String reversedPalindrome = new String(charArray);
        System.out.println("Original: " + palindrome);
        System.out.println("Revesed palindrome: " + reversedPalindrome);
    }
    public static void main(String[] args) {
        reversePalindrome("Dot saw I was Tod");
        System.out.println();
        reversePalindrome("Anita lava la tina");
        System.out.println();
        reversePalindrome("¡Oro! ¡Ya hay oro!");
    }
}

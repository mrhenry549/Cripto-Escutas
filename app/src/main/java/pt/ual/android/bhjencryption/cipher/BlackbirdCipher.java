package pt.ual.android.bhjencryption.cipher;

import java.util.Random;

public class BlackbirdCipher extends Cipher {

    public BlackbirdCipher(CipherMessage cipherMessage) {
        super(cipherMessage);
    }

    @Override
    public CipherValidationResult validateEncrypt() {
        return null;
    }

    @Override
    public CipherValidationResult validateDecrypt() {
        return null;
    }

    @Override
    public CipherResult encrypt() {
        return new CipherResult(BlackbirdCipher.blackbirdEnc(getCipherMessage().getMessageAsText()));
    }

    @Override
    public CipherResult decrypt() {
        return new CipherResult(BlackbirdCipher.blackbirdDecode(getCipherMessage().getMessageAsText()));
    }

    public static String blackbirdEnc(String enc) {
        StringBuilder output = new StringBuilder();
        char[] alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        Random random = new Random();
        char[] inputLetters = enc.toCharArray();

        for (int i=0; i<inputLetters.length; i++){

            int randomChartPosition = random.nextInt(alfabeto.length -1);
            output.append(inputLetters[i]).append("").append(alfabeto[randomChartPosition]);
        }
        return output.toString();
    }

    public static String blackbirdDecode(String enc) {
        StringBuilder output = new StringBuilder();
        char[] inputLetters = enc.toCharArray();

        for (int i = 0; i < inputLetters.length; i += 2) {
            //char result = input.charAt(i);
            output.append(inputLetters[i]);
        }
        return output.toString();
    }

}
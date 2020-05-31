package pt.ual.android.bhjencryption.utils.cipher;

import java.util.Random;

public class LastFakeCipher extends Cipher {

    public LastFakeCipher(String message) {
        super(message);
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
        return new CipherResult(LastFakeCipher.lastFakeEnc(getMessage()));
    }

    @Override
    public CipherResult decrypt() {
        return new CipherResult(LastFakeCipher.lastFakeDecode(getMessage()));
    }

    public static String lastFakeEnc(String enc) {
        StringBuilder output = new StringBuilder();
        char[] alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        Random random = new Random();
        String [] inputLetters;
        inputLetters = enc.split("\\s+");
        for (String inputLetter : inputLetters) {
            int randomChartPosition = random.nextInt(alfabeto.length -1);
            if (!inputLetter.isEmpty()) {
                output.append(inputLetter).append(alfabeto[randomChartPosition]).append(" ");
            }
        }
        return output.toString();
    }


    public static String lastFakeDecode(String enc) {

        StringBuilder output = new StringBuilder();
        String [] inputLetters;
        inputLetters = enc.split("\\s+");
        for (String inputLetter : inputLetters) {

            if (!inputLetter.isEmpty()) {
                output.append(inputLetter.substring(0, inputLetter.length()-1)).append(" ");
            }
        }
        return output.toString();
    }
}
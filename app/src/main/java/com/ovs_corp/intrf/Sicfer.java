package com.ovs_corp.intrf;

public class Sicfer {
    private int smesh = (int) 'a';// смещение алфавита относительно таблицы юникодов
    private int smeshRu = (int) 'а';

    public String encrypt(String text, String keyWord) {
        StringBuilder ans = new StringBuilder();
        char c;

        text = text.toLowerCase();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i)))// если это буква
            {
                if ((int) text.charAt(i) >= (int) ('a') && (int) text.charAt(i) <= (int) 'z')// если это английская
                {
                    int num = ((text.charAt(i) + keyWord.charAt(i % keyWord.length()) - 2 * smesh) % 26);
                    c = (char) (num + smesh);// получаем нужный символ
                } else {
                    int num = ((text.charAt(i) + keyWord.charAt(i % keyWord.length()) - 2 * smeshRu) % 33);
                    c = (char) (num + smeshRu);// получаем нужный символ
                }
            } else {
                c = text.charAt(i);
            }
            ans.append(c);

        }
        return ans.toString();
    }

    public String decrypt(String shifr, String keyWord) {
        char c;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < shifr.length(); i++) {
            if (Character.isLetter(shifr.charAt(i))) {
                if ((int) shifr.charAt(i) >= (int) ('a') && (int) shifr.charAt(i) <= (int) 'z') {
                    int num = ((shifr.charAt(i) - keyWord.charAt(i % keyWord.length()) + 26) % 26); // обратные
                    // преобразования с
                    // номером буквы в
                    // алфавите
                    c = (char) (num + smesh);
                } else {
                    int num = ((shifr.charAt(i) - keyWord.charAt(i % keyWord.length()) + 33) % 33); // обратные

                    c = (char) (num + smeshRu);
                }

            } else {
                c = shifr.charAt(i);
            }
            ans.append(c);
        }
        return ans.toString();
    }
}

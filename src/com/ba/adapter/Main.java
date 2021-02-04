package com.ba.adapter;

public class Main {

	public static void main(String[] args) {

        Crypt crypt = new CryptA();
        crypt.encrypt("Ibrahim");
        crypt.decrypt("Koc");

        System.out.println("-------------");

        crypt = new CryptB();
        crypt.encrypt("Tugba");
        crypt.decrypt("Kurtulus");

        System.out.println("-------------");

        CodeX codeX = new CodeX();

        crypt = new CodeXAdapter(codeX);
        crypt.encrypt("Ali");
        crypt.decrypt("Kara");
    }
}

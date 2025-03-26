package ru.reflection.example;

public class MyClass {
    public String filedPublicString = "Это поле filedPublicString класса MyClass, имеющее тип данных String";
    public int publicInt = 50000;
    public byte publicByte = 127;
    private long privateLong = 999999999999999999L;
    private String filedPrivateString = "Это поле filedPrivateString класса MyClass, имеющее тип данных String";

    public MyClass() {
        System.out.println("\n " + filedPrivateString + "\n " + filedPublicString + "\n" + publicInt + "\n" + publicByte + "\n" + privateLong + "\n");
    }

    public String getFiledPublicString() {
        return filedPublicString;
    }

    public void setFiledPublicString(String filedPublicString) {
        this.filedPublicString = filedPublicString;
    }

    public int getPublicInt() {
        return publicInt;
    }

    public void setPublicInt(int publicInt) {
        this.publicInt = publicInt;
    }

    public byte getPublicByte() {
        return publicByte;
    }

    public void setPublicByte(byte publicByte) {
        this.publicByte = publicByte;
    }

    public String myMethod() {
        return "\nЭто обычный вызов метода myMethod, где он возвращает строку (то есть саму эту строу)";
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "filedPublicString='" + filedPublicString + '\'' +
                ", publicInt=" + publicInt +
                ", publicByte=" + publicByte +
                ", privateLong=" + privateLong +
                ", filedPrivateString='" + filedPrivateString + '\'' +
                '}';
    }
}

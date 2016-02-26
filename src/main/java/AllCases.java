public class AllCases {
    public int publicInt = 3;
    protected int protectedInt = 2;
    byte aByte = 10;
    short aShort = 111;
    int aInt = 1213;
    long aLong = 1225324234;
    float aFloat = 21432.1f;
    double aDouble = 12345.5678;
    char aChar = 'A';
    boolean aBoolean = true;
    private int privateInt = 1;

    public String toString(){
        return  "AllCases \n"
                + "publicInt = " + publicInt + "; \n"
                + "protectedInt = " + protectedInt + "; \n"
                + "aByte = " + aByte + "; \n"
                + "aShort = " + aShort + "; \n"
                + "aInt = " + aInt + "; \n"
                + "aLong = " + aLong + "; \n"
                + "aFloat = " + aFloat + "; \n"
                + "aDouble = " + aDouble + "; \n"
                + "aChar = " + aChar + "; \n"
                + "aBoolean = " + aBoolean + "; \n"
                + "privateInt = " + privateInt + ";";
    }
}
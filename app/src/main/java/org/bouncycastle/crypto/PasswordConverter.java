package org.bouncycastle.crypto;

public abstract enum PasswordConverter implements CharToByteConverter {
    enum org.bouncycastle.crypto.PasswordConverter$1 extends PasswordConverter {
        org.bouncycastle.crypto.PasswordConverter$1(String arg2, int arg3) {
            super(arg2, arg3, null);
        }

        public byte[] convert(char[] arg1) {
            return PBEParametersGenerator.PKCS5PasswordToBytes(arg1);
        }

        public String getType() {
            return "ASCII";
        }
    }

    enum org.bouncycastle.crypto.PasswordConverter$2 extends PasswordConverter {
        org.bouncycastle.crypto.PasswordConverter$2(String arg2, int arg3) {
            super(arg2, arg3, null);
        }

        public byte[] convert(char[] arg1) {
            return PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(arg1);
        }

        public String getType() {
            return "UTF8";
        }
    }

    enum org.bouncycastle.crypto.PasswordConverter$3 extends PasswordConverter {
        org.bouncycastle.crypto.PasswordConverter$3(String arg2, int arg3) {
            super(arg2, arg3, null);
        }

        public byte[] convert(char[] arg1) {
            return PBEParametersGenerator.PKCS12PasswordToBytes(arg1);
        }

        public String getType() {
            return "PKCS12";
        }
    }

    public static final enum PasswordConverter ASCII;
    public static final enum PasswordConverter PKCS12;
    public static final enum PasswordConverter UTF8;

    private static PasswordConverter[] $values() {
        return new PasswordConverter[]{PasswordConverter.ASCII, PasswordConverter.UTF8, PasswordConverter.PKCS12};
    }

    static {
        PasswordConverter.ASCII = new org.bouncycastle.crypto.PasswordConverter$1("ASCII", 0);
        PasswordConverter.UTF8 = new org.bouncycastle.crypto.PasswordConverter$2("UTF8", 1);
        PasswordConverter.PKCS12 = new org.bouncycastle.crypto.PasswordConverter$3("PKCS12", 2);
        PasswordConverter.$VALUES = PasswordConverter.$values();
    }

    private PasswordConverter(String arg1, int arg2) {
        super(arg1, arg2);
    }

    PasswordConverter(String arg1, int arg2, org.bouncycastle.crypto.PasswordConverter$1 arg3) {
        this(arg1, arg2);
    }

    public static PasswordConverter valueOf(String arg1) {
        return Enum.valueOf(PasswordConverter.class, arg1);
    }

    public static PasswordConverter[] values() {
        return PasswordConverter.$VALUES.clone();
    }
}


package com.google.errorprone.annotations;

public enum Modifier {
    public static final enum Modifier ABSTRACT;
    public static final enum Modifier DEFAULT;
    public static final enum Modifier FINAL;
    public static final enum Modifier NATIVE;
    public static final enum Modifier PRIVATE;
    public static final enum Modifier PROTECTED;
    public static final enum Modifier PUBLIC;
    public static final enum Modifier STATIC;
    public static final enum Modifier STRICTFP;
    public static final enum Modifier SYNCHRONIZED;
    public static final enum Modifier TRANSIENT;
    public static final enum Modifier VOLATILE;

    static {
        Modifier v0 = new Modifier("PUBLIC", 0);
        Modifier.PUBLIC = v0;
        Modifier v1 = new Modifier("PROTECTED", 1);
        Modifier.PROTECTED = v1;
        Modifier v2 = new Modifier("PRIVATE", 2);
        Modifier.PRIVATE = v2;
        Modifier v3 = new Modifier("ABSTRACT", 3);
        Modifier.ABSTRACT = v3;
        Modifier v4 = new Modifier("DEFAULT", 4);
        Modifier.DEFAULT = v4;
        Modifier v5 = new Modifier("STATIC", 5);
        Modifier.STATIC = v5;
        Modifier v6 = new Modifier("FINAL", 6);
        Modifier.FINAL = v6;
        Modifier v7 = new Modifier("TRANSIENT", 7);
        Modifier.TRANSIENT = v7;
        Modifier v8 = new Modifier("VOLATILE", 8);
        Modifier.VOLATILE = v8;
        Modifier v9 = new Modifier("SYNCHRONIZED", 9);
        Modifier.SYNCHRONIZED = v9;
        Modifier v10 = new Modifier("NATIVE", 10);
        Modifier.NATIVE = v10;
        Modifier v11 = new Modifier("STRICTFP", 11);
        Modifier.STRICTFP = v11;
        Modifier.$VALUES = new Modifier[]{v0, v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11};
    }

    private Modifier(String arg1, int arg2) {
        super(arg1, arg2);
    }

    public static Modifier valueOf(String arg1) {
        return Enum.valueOf(Modifier.class, arg1);
    }

    public static Modifier[] values() {
        return Modifier.$VALUES.clone();
    }
}


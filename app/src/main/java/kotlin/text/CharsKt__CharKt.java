package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0010\b\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\u001A\u000E\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004\u001A\u0016\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0001H\u0087\u0080\u0004\u001A\u0015\u0010\u0004\u001A\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0005\u001A\u001D\u0010\u0004\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0001H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0006\u001A\u000E\u0010\u0007\u001A\u00020\u0002*\u00020\u0001H\u0087\u0080\u0004\u001A\u0016\u0010\u0007\u001A\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0001H\u0087\u0080\u0004\u001A\u000E\u0010\b\u001A\u00020\t*\u00020\u0002H\u0087\u0080\u0004\u001A\u0016\u0010\n\u001A\u00020\t*\u00020\u00022\u0006\u0010\u000B\u001A\u00020\tH\u0087\u008A\u0004\u001A \u0010\f\u001A\u00020\r*\u00020\u00022\u0006\u0010\u000B\u001A\u00020\u00022\b\b\u0002\u0010\u000E\u001A\u00020\rH\u0086\u0080\u0004\u001A\u000E\u0010\u000F\u001A\u00020\r*\u00020\u0002H\u0086\u0080\u0004¨\u0006\u0010"}, d2={"digitToInt", "", "", "radix", "digitToIntOrNull", "(C)Ljava/lang/Integer;", "(CI)Ljava/lang/Integer;", "digitToChar", "titlecase", "", "plus", "other", "equals", "", "ignoreCase", "isSurrogate", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/text/CharsKt") class CharsKt__CharKt extends CharsKt__CharJVMKt {
    public CharsKt__CharKt() {
        super();
    }

    public static final char digitToChar(int arg3) {
        if(arg3 >= 0 && arg3 < 10) {
            return ((char)(arg3 + 0x30));
        }

        throw new IllegalArgumentException("Int " + arg3 + " is not a decimal digit");
    }

    public static final char digitToChar(int arg3, int arg4) {
        if(2 <= arg4 && arg4 < 37) {
            if(arg3 >= 0 && arg3 < arg4) {
                arg4 = 10;
                if(arg3 < arg4) {
                    arg3 += 0x30;
                }
                else {
                    arg3 = (((char)(arg3 + 65))) - arg4;
                }

                return ((char)arg3);
            }

            throw new IllegalArgumentException("Digit " + arg3 + " does not represent a valid digit in radix " + arg4);
        }

        throw new IllegalArgumentException("Invalid radix: " + arg4 + ". Valid radix values are in range 2..36");
    }

    public static final int digitToInt(char arg3) {
        int v0 = CharsKt.digitOf(arg3, 10);
        if(v0 >= 0) {
            return v0;
        }

        throw new IllegalArgumentException("Char " + arg3 + " is not a decimal digit");
    }

    public static final int digitToInt(char arg3, int arg4) {
        Integer v0 = CharsKt.digitToIntOrNull(arg3, arg4);
        if(v0 != null) {
            return v0.intValue();
        }

        throw new IllegalArgumentException("Char " + arg3 + " is not a digit in the given radix=" + arg4);
    }

    public static final Integer digitToIntOrNull(char arg1) {
        Integer v1 = Integer.valueOf(CharsKt.digitOf(arg1, 10));
        if(v1.intValue() >= 0) {
            return v1;
        }

        return null;
    }

    public static final Integer digitToIntOrNull(char arg0, int arg1) {
        CharsKt.checkRadix(arg1);
        Integer v0 = Integer.valueOf(CharsKt.digitOf(arg0, arg1));
        if(v0.intValue() >= 0) {
            return v0;
        }

        return null;
    }

    public static final boolean equals(char arg2, char arg3, boolean arg4) {
        if(arg2 == arg3) {
            return 1;
        }

        if(!arg4) {
            return 0;
        }

        arg2 = Character.toUpperCase(arg2);
        arg3 = Character.toUpperCase(arg3);
        if(arg2 != arg3) {
            if(Character.toLowerCase(arg2) == Character.toLowerCase(arg3)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public static boolean equals$default(char arg0, char arg1, boolean arg2, int arg3, Object arg4) {
        return CharsKt.equals(arg0, arg1, false);
    }

    public static final boolean isSurrogate(char arg2) {
        if(0xD800 <= arg2 && arg2 < 0xE000) {
            return 1;
        }

        return 0;
    }

    private static final String plus(char arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "other");
        return arg1 + arg2;
    }

    public static final String titlecase(char arg0) {
        return _OneToManyTitlecaseMappingsKt.titlecaseImpl(arg0);
    }
}


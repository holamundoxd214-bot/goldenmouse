package kotlin.text;

import java.util.Locale;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u001A\u000E\u0010\u0005\u001A\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\u0007\u001A\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\b\u001A\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\t\u001A\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\n\u001A\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\u000B\u001A\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\f\u001A\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\r\u001A\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\u000E\u001A\u00020\u0006*\u00020\u0002H\u0086\u0080\u0004\u001A\u000E\u0010\u000F\u001A\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\u0010\u001A\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\u0011\u001A\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\u0012\u001A\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\u0013\u001A\u00020\u0014*\u00020\u0002H\u0087\u0088\u0004\u001A\u0016\u0010\u0013\u001A\u00020\u0014*\u00020\u00022\u0006\u0010\u0015\u001A\u00020\u0016H\u0087\u0080\u0004\u001A\u000E\u0010\u0017\u001A\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\u0018\u001A\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\u0019\u001A\u00020\u0014*\u00020\u0002H\u0087\u0088\u0004\u001A\u0016\u0010\u0019\u001A\u00020\u0014*\u00020\u00022\u0006\u0010\u0015\u001A\u00020\u0016H\u0087\u0080\u0004\u001A\u000E\u0010\u001A\u001A\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\u001B\u001A\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\u001C\u001A\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004\u001A\u0016\u0010\u001D\u001A\u00020\u0014*\u00020\u00022\u0006\u0010\u0015\u001A\u00020\u0016H\u0087\u0080\u0004\u001A\u000E\u0010\"\u001A\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010#\u001A\u00020\u0006*\u00020\u0002H\u0087\u0088\u0004\u001A\u001A\u0010$\u001A\u00020%2\u0006\u0010&\u001A\u00020\u00022\u0006\u0010\'\u001A\u00020%H\u0080\u0080\u0004\u001A\u0012\u0010(\u001A\u00020%2\u0006\u0010\'\u001A\u00020%H\u0081\u0080\b\"\u0019\u0010\u0000\u001A\u00020\u0001*\u00020\u00028FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0004\"\u0019\u0010\u001E\u001A\u00020\u001F*\u00020\u00028FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b \u0010!¨\u0006)"}, d2={"category", "Lkotlin/text/CharCategory;", "", "getCategory", "(C)Lkotlin/text/CharCategory;", "isDefined", "", "isLetter", "isLetterOrDigit", "isDigit", "isIdentifierIgnorable", "isISOControl", "isJavaIdentifierPart", "isJavaIdentifierStart", "isWhitespace", "isUpperCase", "isLowerCase", "toUpperCase", "uppercaseChar", "uppercase", "", "locale", "Ljava/util/Locale;", "toLowerCase", "lowercaseChar", "lowercase", "isTitleCase", "toTitleCase", "titlecaseChar", "titlecase", "directionality", "Lkotlin/text/CharDirectionality;", "getDirectionality", "(C)Lkotlin/text/CharDirectionality;", "isHighSurrogate", "isLowSurrogate", "digitOf", "", "char", "radix", "checkRadix", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/text/CharsKt") class CharsKt__CharJVMKt {
    public CharsKt__CharJVMKt() {
        super();
    }

    @IgnorableReturnValue public static final int checkRadix(int arg4) {
        int v0 = 2;
        if(v0 <= arg4 && arg4 < 37) {
            return arg4;
        }

        throw new IllegalArgumentException("radix " + arg4 + " was not in valid range " + new IntRange(v0, 36));
    }

    public static final int digitOf(char arg0, int arg1) {
        return Character.digit(arg0, arg1);
    }

    public static final CharCategory getCategory(char arg1) {
        return CharCategory.Companion.valueOf(Character.getType(arg1));
    }

    public static final CharDirectionality getDirectionality(char arg1) {
        return CharDirectionality.Companion.valueOf(Character.getDirectionality(arg1));
    }

    private static final boolean isDefined(char arg0) {
        return Character.isDefined(arg0);
    }

    private static final boolean isDigit(char arg0) {
        return Character.isDigit(arg0);
    }

    private static final boolean isHighSurrogate(char arg0) {
        return Character.isHighSurrogate(arg0);
    }

    private static final boolean isISOControl(char arg0) {
        return Character.isISOControl(arg0);
    }

    private static final boolean isIdentifierIgnorable(char arg0) {
        return Character.isIdentifierIgnorable(arg0);
    }

    private static final boolean isJavaIdentifierPart(char arg0) {
        return Character.isJavaIdentifierPart(arg0);
    }

    private static final boolean isJavaIdentifierStart(char arg0) {
        return Character.isJavaIdentifierStart(arg0);
    }

    private static final boolean isLetter(char arg0) {
        return Character.isLetter(arg0);
    }

    private static final boolean isLetterOrDigit(char arg0) {
        return Character.isLetterOrDigit(arg0);
    }

    private static final boolean isLowSurrogate(char arg0) {
        return Character.isLowSurrogate(arg0);
    }

    private static final boolean isLowerCase(char arg0) {
        return Character.isLowerCase(arg0);
    }

    private static final boolean isTitleCase(char arg0) {
        return Character.isTitleCase(arg0);
    }

    private static final boolean isUpperCase(char arg0) {
        return Character.isUpperCase(arg0);
    }

    public static final boolean isWhitespace(char arg1) {
        if(!Character.isWhitespace(arg1)) {
            if(Character.isSpaceChar(arg1)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private static final String lowercase(char arg1) {
        String v1 = String.valueOf(arg1);
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type java.lang.String");
        v1 = v1.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(v1, "toLowerCase(...)");
        return v1;
    }

    public static final String lowercase(char arg1, Locale arg2) {
        Intrinsics.checkNotNullParameter(arg2, "locale");
        String v1 = String.valueOf(arg1);
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type java.lang.String");
        v1 = v1.toLowerCase(arg2);
        Intrinsics.checkNotNullExpressionValue(v1, "toLowerCase(...)");
        return v1;
    }

    private static final char lowercaseChar(char arg0) {
        return Character.toLowerCase(arg0);
    }

    public static final String titlecase(char arg3, Locale arg4) {
        Intrinsics.checkNotNullParameter(arg4, "locale");
        String v4 = CharsKt.uppercase(arg3, arg4);
        String v1 = "null cannot be cast to non-null type java.lang.String";
        if(v4.length() <= 1) {
            String v0 = String.valueOf(arg3);
            Intrinsics.checkNotNull(v0, v1);
            v0 = v0.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(v0, "toUpperCase(...)");
            if(!Intrinsics.areEqual(v4, v0)) {
                return v4;
            }

            goto label_36;
        }
        else if(arg3 == 329) {
        }
        else {
            arg3 = v4.charAt(0);
            Intrinsics.checkNotNull(v4, v1);
            v4 = v4.substring(1);
            Intrinsics.checkNotNullExpressionValue(v4, "substring(...)");
            Intrinsics.checkNotNull(v4, v1);
            v4 = v4.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(v4, "toLowerCase(...)");
            return arg3 + v4;
        }

        return v4;
    label_36:
        return String.valueOf(Character.toTitleCase(arg3));
    }

    private static final char titlecaseChar(char arg0) {
        return Character.toTitleCase(arg0);
    }

    @Deprecated(message="Use lowercaseChar() instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.5") private static final char toLowerCase(char arg0) {
        return Character.toLowerCase(arg0);
    }

    @Deprecated(message="Use titlecaseChar() instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.5") private static final char toTitleCase(char arg0) {
        return Character.toTitleCase(arg0);
    }

    @Deprecated(message="Use uppercaseChar() instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.5") private static final char toUpperCase(char arg0) {
        return Character.toUpperCase(arg0);
    }

    private static final String uppercase(char arg1) {
        String v1 = String.valueOf(arg1);
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type java.lang.String");
        v1 = v1.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(v1, "toUpperCase(...)");
        return v1;
    }

    public static final String uppercase(char arg1, Locale arg2) {
        Intrinsics.checkNotNullParameter(arg2, "locale");
        String v1 = String.valueOf(arg1);
        Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type java.lang.String");
        v1 = v1.toUpperCase(arg2);
        Intrinsics.checkNotNullExpressionValue(v1, "toUpperCase(...)");
        return v1;
    }

    private static final char uppercaseChar(char arg0) {
        return Character.toUpperCase(arg0);
    }
}


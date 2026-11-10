package kotlin.text;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u001E\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0001H\u0081\u0088\u0004\u001A\u001E\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0001H\u0081\u0088\u0004\u001A\u001E\u0010\u0007\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0001H\u0081\u0088\u0004\u001A\u001E\u0010\u0007\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0001H\u0081\u0088\u0004\u001A$\u0010\b\u001A\u00020\t*\u0004\u0018\u00010\u00022\b\u0010\n\u001A\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000B\u001A\u00020\tH\u0086\u0080\u0004\u001A(\u0010\f\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\r\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\u00042\b\b\u0002\u0010\u000B\u001A\u00020\tH\u0086\u0080\u0004\u001A(\u0010\f\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u000F\u001A\u00020\u00022\u0006\u0010\u0010\u001A\u00020\u00022\b\b\u0002\u0010\u000B\u001A\u00020\tH\u0086\u0080\u0004\u001A(\u0010\u0011\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\r\u001A\u00020\u00042\u0006\u0010\u000E\u001A\u00020\u00042\b\b\u0002\u0010\u000B\u001A\u00020\tH\u0086\u0080\u0004\u001A(\u0010\u0011\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u000F\u001A\u00020\u00022\u0006\u0010\u0010\u001A\u00020\u00022\b\b\u0002\u0010\u000B\u001A\u00020\tH\u0086\u0080\u0004\u001A\u000E\u0010\u0012\u001A\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\u0013\u001A\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\u0014\u001A\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\u0015\u001A\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004\u001A\u000E\u0010\u0016\u001A\u00020\u0002*\u00020\u0017H\u0087\u0080\u0004\u001A\"\u0010\u0016\u001A\u00020\u0002*\u00020\u00172\b\b\u0002\u0010\u0018\u001A\u00020\u00012\b\b\u0002\u0010\u0019\u001A\u00020\u0001H\u0087\u0080\u0004\u001A\"\u0010\u001A\u001A\u00020\u0017*\u00020\u00022\b\b\u0002\u0010\u0018\u001A\u00020\u00012\b\b\u0002\u0010\u0019\u001A\u00020\u0001H\u0087\u0080\u0004\u001A\u000E\u0010\u001B\u001A\u00020\u0002*\u00020\u001CH\u0087\u0080\u0004\u001A,\u0010\u001B\u001A\u00020\u0002*\u00020\u001C2\b\b\u0002\u0010\u0018\u001A\u00020\u00012\b\b\u0002\u0010\u0019\u001A\u00020\u00012\b\b\u0002\u0010\u001D\u001A\u00020\tH\u0087\u0080\u0004\u001A\u000E\u0010\u001E\u001A\u00020\u001C*\u00020\u0002H\u0087\u0080\u0004\u001A,\u0010\u001E\u001A\u00020\u001C*\u00020\u00022\b\b\u0002\u0010\u0018\u001A\u00020\u00012\b\b\u0002\u0010\u0019\u001A\u00020\u00012\b\b\u0002\u0010\u001D\u001A\u00020\tH\u0087\u0080\u0004\u001A\u000E\u0010\u001A\u001A\u00020\u0017*\u00020\u0002H\u0087\u0088\u0004\u001A4\u0010\u001A\u001A\u00020\u0017*\u00020\u00022\u0006\u0010\u001F\u001A\u00020\u00172\b\b\u0002\u0010 \u001A\u00020\u00012\b\b\u0002\u0010\u0018\u001A\u00020\u00012\b\b\u0002\u0010\u0019\u001A\u00020\u0001H\u0087\u0088\b\u001A+\u0010!\u001A\u00020\u0002*\u00020\u00022\u0016\u0010\"\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010$0#\"\u0004\u0018\u00010$H\u0087\u0088\u0004¢\u0006\u0002\u0010%\u001A3\u0010!\u001A\u00020\u0002*\u00020&2\u0006\u0010!\u001A\u00020\u00022\u0016\u0010\"\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010$0#\"\u0004\u0018\u00010$H\u0087\u0088\u0004¢\u0006\u0002\u0010\'\u001A5\u0010!\u001A\u00020\u0002*\u00020\u00022\b\u0010(\u001A\u0004\u0018\u00010)2\u0016\u0010\"\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010$0#\"\u0004\u0018\u00010$H\u0087\u0088\u0004¢\u0006\u0002\u0010*\u001A=\u0010!\u001A\u00020\u0002*\u00020&2\b\u0010(\u001A\u0004\u0018\u00010)2\u0006\u0010!\u001A\u00020\u00022\u0016\u0010\"\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010$0#\"\u0004\u0018\u00010$H\u0087\u0088\u0004¢\u0006\u0002\u0010+\u001A&\u0010,\u001A\b\u0012\u0004\u0012\u00020\u00020-*\u00020.2\u0006\u0010/\u001A\u0002002\b\b\u0002\u00101\u001A\u00020\u0001H\u0086\u0080\u0004\u001A\u0016\u00102\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u001E\u00102\u001A\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001A\u00020\u00012\u0006\u0010\u0019\u001A\u00020\u0001H\u0087\u0088\u0004\u001A \u00103\u001A\u00020\t*\u00020\u00022\u0006\u00104\u001A\u00020\u00022\b\b\u0002\u0010\u000B\u001A\u00020\tH\u0086\u0080\u0004\u001A(\u00103\u001A\u00020\t*\u00020\u00022\u0006\u00104\u001A\u00020\u00022\u0006\u0010\u0018\u001A\u00020\u00012\b\b\u0002\u0010\u000B\u001A\u00020\tH\u0086\u0080\u0004\u001A \u00105\u001A\u00020\t*\u00020\u00022\u0006\u00106\u001A\u00020\u00022\b\b\u0002\u0010\u000B\u001A\u00020\tH\u0086\u0080\u0004\u001A*\u00107\u001A\u00020\u00022\u0006\u00108\u001A\u00020\u001C2\u0006\u00109\u001A\u00020\u00012\u0006\u0010:\u001A\u00020\u00012\u0006\u0010;\u001A\u00020<H\u0087\u0088\u0004\u001A\u001A\u00107\u001A\u00020\u00022\u0006\u00108\u001A\u00020\u001C2\u0006\u0010;\u001A\u00020<H\u0087\u0088\u0004\u001A\"\u00107\u001A\u00020\u00022\u0006\u00108\u001A\u00020\u001C2\u0006\u00109\u001A\u00020\u00012\u0006\u0010:\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0012\u00107\u001A\u00020\u00022\u0006\u00108\u001A\u00020\u001CH\u0087\u0088\u0004\u001A\u0012\u00107\u001A\u00020\u00022\u0006\u0010=\u001A\u00020\u0017H\u0087\u0088\u0004\u001A\"\u00107\u001A\u00020\u00022\u0006\u0010=\u001A\u00020\u00172\u0006\u00109\u001A\u00020\u00012\u0006\u0010:\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\"\u00107\u001A\u00020\u00022\u0006\u0010>\u001A\u00020?2\u0006\u00109\u001A\u00020\u00012\u0006\u0010:\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0012\u00107\u001A\u00020\u00022\u0006\u0010@\u001A\u00020AH\u0087\u0088\u0004\u001A\u0012\u00107\u001A\u00020\u00022\u0006\u0010B\u001A\u00020CH\u0087\u0088\u0004\u001A\u0016\u0010D\u001A\u00020\u0001*\u00020\u00022\u0006\u0010E\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u0016\u0010F\u001A\u00020\u0001*\u00020\u00022\u0006\u0010E\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u001E\u0010G\u001A\u00020\u0001*\u00020\u00022\u0006\u0010H\u001A\u00020\u00012\u0006\u0010\u0019\u001A\u00020\u0001H\u0087\u0088\u0004\u001A \u0010I\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001A\u00020\u00022\b\b\u0002\u0010\u000B\u001A\u00020\tH\u0086\u0080\u0004\u001A\u0016\u0010J\u001A\u00020\t*\u00020\u00022\u0006\u0010K\u001A\u00020.H\u0087\u0088\u0004\u001A\u0016\u0010J\u001A\u00020\t*\u00020\u00022\u0006\u0010B\u001A\u00020AH\u0087\u0088\u0004\u001A\u001A\u0010J\u001A\u00020\t*\u0004\u0018\u00010.2\b\u0010\n\u001A\u0004\u0018\u00010.H\u0087\u0084\u0004\u001A\"\u0010J\u001A\u00020\t*\u0004\u0018\u00010.2\b\u0010\n\u001A\u0004\u0018\u00010.2\u0006\u0010\u000B\u001A\u00020\tH\u0087\u0080\u0004\u001A\u000E\u0010L\u001A\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004\u001A\u001E\u0010M\u001A\u00020\u0001*\u00020\u00022\u0006\u0010E\u001A\u00020\u00012\u0006\u0010N\u001A\u00020\u0001H\u0087\u0088\u0004\u001A8\u0010O\u001A\u00020\t*\u00020.2\u0006\u0010P\u001A\u00020\u00012\u0006\u0010\n\u001A\u00020.2\u0006\u0010Q\u001A\u00020\u00012\u0006\u0010:\u001A\u00020\u00012\b\b\u0002\u0010\u000B\u001A\u00020\tH\u0086\u0080\u0004\u001A8\u0010O\u001A\u00020\t*\u00020\u00022\u0006\u0010P\u001A\u00020\u00012\u0006\u0010\n\u001A\u00020\u00022\u0006\u0010Q\u001A\u00020\u00012\u0006\u0010:\u001A\u00020\u00012\b\b\u0002\u0010\u000B\u001A\u00020\tH\u0086\u0080\u0004\u001A\u0016\u0010\u0014\u001A\u00020\u0002*\u00020\u00022\u0006\u0010(\u001A\u00020)H\u0087\u0088\u0004\u001A\u0016\u0010\u0015\u001A\u00020\u0002*\u00020\u00022\u0006\u0010(\u001A\u00020)H\u0087\u0088\u0004\u001A\u0016\u0010\u0012\u001A\u00020\u0002*\u00020\u00022\u0006\u0010(\u001A\u00020)H\u0087\u0088\u0004\u001A\u0016\u0010\u0013\u001A\u00020\u0002*\u00020\u00022\u0006\u0010(\u001A\u00020)H\u0087\u0088\u0004\u001A\u0018\u0010R\u001A\u00020\u001C*\u00020\u00022\b\b\u0002\u0010;\u001A\u00020<H\u0087\u0088\u0004\u001A\u0018\u0010S\u001A\u000200*\u00020\u00022\b\b\u0002\u0010T\u001A\u00020\u0001H\u0087\u0088\u0004\u001A\u000E\u0010U\u001A\u00020\u0002*\u00020\u0002H\u0087\u0080\u0004\u001A\u0016\u0010U\u001A\u00020\u0002*\u00020\u00022\u0006\u0010(\u001A\u00020)H\u0087\u0080\u0004\u001A\u000E\u0010V\u001A\u00020\u0002*\u00020\u0002H\u0087\u0080\u0004\u001A\u0016\u0010V\u001A\u00020\u0002*\u00020\u00022\u0006\u0010(\u001A\u00020)H\u0087\u0080\u0004\u001A\u0016\u0010W\u001A\u00020\u0002*\u00020.2\u0006\u0010X\u001A\u00020\u0001H\u0086\u0080\u0004\")\u0010Y\u001A\u0012\u0012\u0004\u0012\u00020\u00020Zj\b\u0012\u0004\u0012\u00020\u0002`[*\u00020&8FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b\\\u0010]¨\u0006^"}, d2={"nativeIndexOf", "", "", "ch", "", "fromIndex", "str", "nativeLastIndexOf", "equals", "", "other", "ignoreCase", "replace", "oldChar", "newChar", "oldValue", "newValue", "replaceFirst", "toUpperCase", "uppercase", "toLowerCase", "lowercase", "concatToString", "", "startIndex", "endIndex", "toCharArray", "decodeToString", "", "throwOnInvalidSequence", "encodeToByteArray", "destination", "destinationOffset", "format", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Lkotlin/String$Companion;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "locale", "Ljava/util/Locale;", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "split", "", "", "regex", "Ljava/util/regex/Pattern;", "limit", "substring", "startsWith", "prefix", "endsWith", "suffix", "String", "bytes", "offset", "length", "charset", "Ljava/nio/charset/Charset;", "chars", "codePoints", "", "stringBuffer", "Ljava/lang/StringBuffer;", "stringBuilder", "Ljava/lang/StringBuilder;", "codePointAt", "index", "codePointBefore", "codePointCount", "beginIndex", "compareTo", "contentEquals", "charSequence", "intern", "offsetByCodePoints", "codePointOffset", "regionMatches", "thisOffset", "otherOffset", "toByteArray", "toPattern", "flags", "capitalize", "decapitalize", "repeat", "n", "CASE_INSENSITIVE_ORDER", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/text/StringsKt") class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt {
    public StringsKt__StringsJVMKt() {
        super();
    }

    private static final String String(StringBuffer arg1) {
        Intrinsics.checkNotNullParameter(arg1, "stringBuffer");
        return new String(arg1);
    }

    private static final String String(StringBuilder arg1) {
        Intrinsics.checkNotNullParameter(arg1, "stringBuilder");
        return new String(arg1);
    }

    private static final String String(byte[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "bytes");
        return new String(arg2, Charsets.UTF_8);
    }

    private static final String String(byte[] arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg2, "bytes");
        return new String(arg2, arg3, arg4, Charsets.UTF_8);
    }

    private static final String String(byte[] arg1, int arg2, int arg3, Charset arg4) {
        Intrinsics.checkNotNullParameter(arg1, "bytes");
        Intrinsics.checkNotNullParameter(arg4, "charset");
        return new String(arg1, arg2, arg3, arg4);
    }

    private static final String String(byte[] arg1, Charset arg2) {
        Intrinsics.checkNotNullParameter(arg1, "bytes");
        Intrinsics.checkNotNullParameter(arg2, "charset");
        return new String(arg1, arg2);
    }

    private static final String String(char[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "chars");
        return new String(arg1);
    }

    private static final String String(char[] arg1, int arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "chars");
        return new String(arg1, arg2, arg3);
    }

    private static final String String(int[] arg1, int arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "codePoints");
        return new String(arg1, arg2, arg3);
    }

    @Deprecated(message="Use replaceFirstChar instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(warningSince="1.5") public static final String capitalize(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Locale v0 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(v0, "getDefault(...)");
        return StringsKt.capitalize(arg2, v0);
    }

    @Deprecated(message="Use replaceFirstChar instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(warningSince="1.5") public static final String capitalize(String arg6, Locale arg7) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        Intrinsics.checkNotNullParameter(arg7, "locale");
        if(arg6.length() > 0) {
            char v1 = arg6.charAt(0);
            if(Character.isLowerCase(v1)) {
                StringBuilder v2 = new StringBuilder();
                char v3 = Character.toTitleCase(v1);
                String v4 = "substring(...)";
                if(v3 != Character.toUpperCase(v1)) {
                    v2.append(v3);
                }
                else {
                    String v0 = arg6.substring(0, 1);
                    Intrinsics.checkNotNullExpressionValue(v0, v4);
                    Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type java.lang.String");
                    String v7 = v0.toUpperCase(arg7);
                    Intrinsics.checkNotNullExpressionValue(v7, "toUpperCase(...)");
                    v2.append(v7);
                }

                arg6 = arg6.substring(1);
                Intrinsics.checkNotNullExpressionValue(arg6, v4);
                v2.append(arg6);
                arg6 = v2.toString();
            }
        }

        return arg6;
    }

    private static final int codePointAt(String arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.codePointAt(arg2);
    }

    private static final int codePointBefore(String arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.codePointBefore(arg2);
    }

    private static final int codePointCount(String arg1, int arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.codePointCount(arg2, arg3);
    }

    public static final int compareTo(String arg1, String arg2, boolean arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "other");
        if(arg3) {
            return arg1.compareToIgnoreCase(arg2);
        }

        return arg1.compareTo(arg2);
    }

    public static int compareTo$default(String arg0, String arg1, boolean arg2, int arg3, Object arg4) {
        return StringsKt.compareTo(arg0, arg1, false);
    }

    public static final String concatToString(char[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new String(arg1);
    }

    public static final String concatToString(char[] arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(arg3, arg4, arg2.length);
        return new String(arg2, arg3, arg4 - arg3);
    }

    public static String concatToString$default(char[] arg0, int arg1, int arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = arg0.length;
        }

        return StringsKt.concatToString(arg0, 0, arg2);
    }

    public static final boolean contentEquals(CharSequence arg1, CharSequence arg2) {
        if(((arg1 instanceof String)) && arg2 != null) {
            return ((String)arg1).contentEquals(arg2);
        }

        return StringsKt.contentEqualsImpl(arg1, arg2);
    }

    public static final boolean contentEquals(CharSequence arg0, CharSequence arg1, boolean arg2) {
        if(arg2) {
            return StringsKt.contentEqualsIgnoreCaseImpl(arg0, arg1);
        }

        return StringsKt.contentEquals(arg0, arg1);
    }

    private static final boolean contentEquals(String arg1, CharSequence arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "charSequence");
        return arg1.contentEquals(arg2);
    }

    private static final boolean contentEquals(String arg1, StringBuffer arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "stringBuilder");
        return arg1.contentEquals(arg2);
    }

    @Deprecated(message="Use replaceFirstChar instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(warningSince="1.5") public static final String decapitalize(String arg6) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        if(arg6.length() > 0 && !Character.isLowerCase(arg6.charAt(0))) {
            StringBuilder v1 = new StringBuilder();
            String v0 = arg6.substring(0, 1);
            Intrinsics.checkNotNullExpressionValue(v0, "substring(...)");
            Locale v4 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(v4, "getDefault(...)");
            Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type java.lang.String");
            v0 = v0.toLowerCase(v4);
            Intrinsics.checkNotNullExpressionValue(v0, "toLowerCase(...)");
            StringBuilder v0_1 = v1.append(v0);
            arg6 = arg6.substring(1);
            Intrinsics.checkNotNullExpressionValue(arg6, "substring(...)");
            arg6 = v0_1.append(arg6).toString();
        }

        return arg6;
    }

    @Deprecated(message="Use replaceFirstChar instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(warningSince="1.5") public static final String decapitalize(String arg5, Locale arg6) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "locale");
        if(arg5.length() > 0 && !Character.isLowerCase(arg5.charAt(0))) {
            StringBuilder v1 = new StringBuilder();
            String v0 = arg5.substring(0, 1);
            Intrinsics.checkNotNullExpressionValue(v0, "substring(...)");
            Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type java.lang.String");
            String v6 = v0.toLowerCase(arg6);
            Intrinsics.checkNotNullExpressionValue(v6, "toLowerCase(...)");
            StringBuilder v6_1 = v1.append(v6);
            arg5 = arg5.substring(1);
            Intrinsics.checkNotNullExpressionValue(arg5, "substring(...)");
            arg5 = v6_1.append(arg5).toString();
        }

        return arg5;
    }

    public static final String decodeToString(byte[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return new String(arg2, Charsets.UTF_8);
    }

    public static final String decodeToString(byte[] arg2, int arg3, int arg4, boolean arg5) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(arg3, arg4, arg2.length);
        if(!arg5) {
            return new String(arg2, arg3, arg4 - arg3, Charsets.UTF_8);
        }

        String v2 = Charsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(arg2, arg3, arg4 - arg3)).toString();
        Intrinsics.checkNotNullExpressionValue(v2, "toString(...)");
        return v2;
    }

    public static String decodeToString$default(byte[] arg1, int arg2, int arg3, boolean arg4, int arg5, Object arg6) {
        if((arg5 & 2) != 0) {
            arg3 = arg1.length;
        }

        return StringsKt.decodeToString(arg1, 0, arg3, false);
    }

    public static final byte[] encodeToByteArray(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        byte[] v1 = arg1.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(v1, "getBytes(...)");
        return v1;
    }

    public static final byte[] encodeToByteArray(String arg2, int arg3, int arg4, boolean arg5) {
        byte[] v2;
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(arg3, arg4, arg2.length());
        if(!arg5) {
            arg2 = arg2.substring(arg3, arg4);
            Intrinsics.checkNotNullExpressionValue(arg2, "substring(...)");
            Charset v3 = Charsets.UTF_8;
            Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type java.lang.String");
            v2 = arg2.getBytes(v3);
            Intrinsics.checkNotNullExpressionValue(v2, "getBytes(...)");
            return v2;
        }

        ByteBuffer v2_1 = Charsets.UTF_8.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).encode(CharBuffer.wrap(((CharSequence)arg2), arg3, arg4));
        if((v2_1.hasArray()) && v2_1.arrayOffset() == 0) {
            arg3 = v2_1.remaining();
            byte[] v4 = v2_1.array();
            Intrinsics.checkNotNull(v4);
            if(arg3 == v4.length) {
                v2 = v2_1.array();
                Intrinsics.checkNotNull(v2);
                return v2;
            }
        }

        byte[] v3_1 = new byte[v2_1.remaining()];
        v2_1.get(v3_1);
        return v3_1;
    }

    public static byte[] encodeToByteArray$default(String arg1, int arg2, int arg3, boolean arg4, int arg5, Object arg6) {
        if((arg5 & 2) != 0) {
            arg3 = arg1.length();
        }

        return StringsKt.encodeToByteArray(arg1, 0, arg3, false);
    }

    public static final boolean endsWith(String arg7, String arg8, boolean arg9) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "suffix");
        if(!arg9) {
            return arg7.endsWith(arg8);
        }

        return StringsKt.regionMatches(arg7, arg7.length() - arg8.length(), arg8, 0, arg8.length(), true);
    }

    public static boolean endsWith$default(String arg0, String arg1, boolean arg2, int arg3, Object arg4) {
        return StringsKt.endsWith(arg0, arg1, false);
    }

    public static final boolean equals(String arg0, String arg1, boolean arg2) {
        if(arg0 == null) {
            if(arg1 == null) {
                return 1;
            }

            return 0;
        }

        if(!arg2) {
            return arg0.equals(arg1);
        }

        return arg0.equalsIgnoreCase(arg1);
    }

    public static boolean equals$default(String arg0, String arg1, boolean arg2, int arg3, Object arg4) {
        return StringsKt.equals(arg0, arg1, false);
    }

    private static final String format(String arg1, Locale arg2, Object[] arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "args");
        arg1 = String.format(arg2, arg1, Arrays.copyOf(arg3, arg3.length));
        Intrinsics.checkNotNullExpressionValue(arg1, "format(...)");
        return arg1;
    }

    private static final String format(String arg1, Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "args");
        arg1 = String.format(arg1, Arrays.copyOf(arg2, arg2.length));
        Intrinsics.checkNotNullExpressionValue(arg1, "format(...)");
        return arg1;
    }

    private static final String format(StringCompanionObject arg1, String arg2, Object[] arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "format");
        Intrinsics.checkNotNullParameter(arg3, "args");
        String v1 = String.format(arg2, Arrays.copyOf(arg3, arg3.length));
        Intrinsics.checkNotNullExpressionValue(v1, "format(...)");
        return v1;
    }

    private static final String format(StringCompanionObject arg1, Locale arg2, String arg3, Object[] arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "format");
        Intrinsics.checkNotNullParameter(arg4, "args");
        String v1 = String.format(arg2, arg3, Arrays.copyOf(arg4, arg4.length));
        Intrinsics.checkNotNullExpressionValue(v1, "format(...)");
        return v1;
    }

    public static final Comparator getCASE_INSENSITIVE_ORDER(StringCompanionObject arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Comparator v1 = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.checkNotNullExpressionValue(v1, "CASE_INSENSITIVE_ORDER");
        return v1;
    }

    private static final String intern(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.intern();
        Intrinsics.checkNotNullExpressionValue(arg1, "intern(...)");
        return arg1;
    }

    private static final String lowercase(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(arg1, "toLowerCase(...)");
        return arg1;
    }

    private static final String lowercase(String arg1, Locale arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "locale");
        arg1 = arg1.toLowerCase(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "toLowerCase(...)");
        return arg1;
    }

    private static final int nativeIndexOf(String arg1, char arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.indexOf(arg2, arg3);
    }

    private static final int nativeIndexOf(String arg1, String arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "str");
        return arg1.indexOf(arg2, arg3);
    }

    private static final int nativeLastIndexOf(String arg1, char arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.lastIndexOf(arg2, arg3);
    }

    private static final int nativeLastIndexOf(String arg1, String arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "str");
        return arg1.lastIndexOf(arg2, arg3);
    }

    private static final int offsetByCodePoints(String arg1, int arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.offsetByCodePoints(arg2, arg3);
    }

    public static final boolean regionMatches(CharSequence arg6, int arg7, CharSequence arg8, int arg9, int arg10, boolean arg11) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "other");
        if(((arg6 instanceof String)) && ((arg8 instanceof String))) {
            return StringsKt.regionMatches(((String)arg6), arg7, ((String)arg8), arg9, arg10, arg11);
        }

        return StringsKt.regionMatchesImpl(arg6, arg7, arg8, arg9, arg10, arg11);
    }

    public static final boolean regionMatches(String arg6, int arg7, String arg8, int arg9, int arg10, boolean arg11) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "other");
        if(!arg11) {
            return arg6.regionMatches(arg7, arg8, arg9, arg10);
        }

        return arg6.regionMatches(arg11, arg7, arg8, arg9, arg10);
    }

    public static boolean regionMatches$default(CharSequence arg6, int arg7, CharSequence arg8, int arg9, int arg10, boolean arg11, int arg12, Object arg13) {
        return StringsKt.regionMatches(arg6, arg7, arg8, arg9, arg10, false);
    }

    public static boolean regionMatches$default(String arg6, int arg7, String arg8, int arg9, int arg10, boolean arg11, int arg12, Object arg13) {
        return StringsKt.regionMatches(arg6, arg7, arg8, arg9, arg10, false);
    }

    public static final String repeat(CharSequence arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        if(arg4 >= 0) {
            String v0 = "";
            if(arg4 != 0) {
                int v1 = 1;
                if(arg4 != 1) {
                    int v2 = arg3.length();
                    if(v2 != 0) {
                        if(v2 != 1) {
                            StringBuilder v0_1 = new StringBuilder(arg3.length() * arg4);
                            if(1 <= arg4) {
                                while(true) {
                                    v0_1.append(arg3);
                                    if(v1 != arg4) {
                                        ++v1;
                                        continue;
                                    }

                                    break;
                                }
                            }

                            String v3 = v0_1.toString();
                            Intrinsics.checkNotNull(v3);
                            return v3;
                        }

                        int v0_2 = 0;
                        char v3_1 = arg3.charAt(0);
                        char[] v1_1 = new char[arg4];
                        while(v0_2 < arg4) {
                            v1_1[v0_2] = v3_1;
                            ++v0_2;
                        }

                        return new String(v1_1);
                    }

                    return v0;
                }

                return arg3.toString();
            }

            return v0;
        }

        throw new IllegalArgumentException("Count \'n\' must be non-negative, but was " + arg4 + '.'.toString());
    }

    public static final String replace(String arg4, char arg5, char arg6, boolean arg7) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        if(!arg7) {
            arg4 = arg4.replace(arg5, arg6);
            Intrinsics.checkNotNullExpressionValue(arg4, "replace(...)");
            return arg4;
        }

        StringBuilder v1 = new StringBuilder(arg4.length());
        int v0;
        for(v0 = 0; v0 < ((CharSequence)arg4).length(); ++v0) {
            char v2 = ((CharSequence)arg4).charAt(v0);
            if(CharsKt.equals(v2, arg5, arg7)) {
                v2 = arg6;
            }

            v1.append(v2);
        }

        return v1.toString();
    }

    public static final String replace(String arg7, String arg8, String arg9, boolean arg10) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "oldValue");
        Intrinsics.checkNotNullParameter(arg9, "newValue");
        String v0 = arg7;
        int v1 = 0;
        int v2 = StringsKt.indexOf(((CharSequence)v0), arg8, 0, arg10);
        if(v2 < 0) {
            return arg7;
        }

        int v3 = arg8.length();
        int v4 = RangesKt.coerceAtLeast(v3, 1);
        int v5 = arg7.length() - v3 + arg9.length();
        if(v5 >= 0) {
            StringBuilder v6 = new StringBuilder(v5);
            do {
                v6.append(((CharSequence)v0), v1, v2).append(arg9);
                v1 = v2 + v3;
                if(v2 >= arg7.length()) {
                    break;
                }

                v2 = StringsKt.indexOf(((CharSequence)v0), arg8, v2 + v4, arg10);
            }
            while(v2 > 0);

            arg7 = v6.append(((CharSequence)v0), v1, arg7.length()).toString();
            Intrinsics.checkNotNullExpressionValue(arg7, "toString(...)");
            return arg7;
        }

        throw new OutOfMemoryError();
    }

    public static String replace$default(String arg0, char arg1, char arg2, boolean arg3, int arg4, Object arg5) {
        return StringsKt.replace(arg0, arg1, arg2, false);
    }

    public static String replace$default(String arg0, String arg1, String arg2, boolean arg3, int arg4, Object arg5) {
        return StringsKt.replace(arg0, arg1, arg2, false);
    }

    public static final String replaceFirst(String arg7, char arg8, char arg9, boolean arg10) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        String v1 = arg7;
        int v8 = StringsKt.indexOf$default(((CharSequence)v1), arg8, 0, arg10, 2, null);
        if(v8 < 0) {
            return arg7;
        }

        return StringsKt.replaceRange(((CharSequence)v1), v8, v8 + 1, String.valueOf(arg9)).toString();
    }

    public static final String replaceFirst(String arg7, String arg8, String arg9, boolean arg10) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "oldValue");
        Intrinsics.checkNotNullParameter(arg9, "newValue");
        String v1 = arg7;
        String v2 = arg8;
        int v8 = StringsKt.indexOf$default(((CharSequence)v1), v2, 0, arg10, 2, null);
        if(v8 < 0) {
            return arg7;
        }

        return StringsKt.replaceRange(((CharSequence)v1), v8, v2.length() + v8, ((CharSequence)arg9)).toString();
    }

    public static String replaceFirst$default(String arg0, char arg1, char arg2, boolean arg3, int arg4, Object arg5) {
        return StringsKt.replaceFirst(arg0, arg1, arg2, false);
    }

    public static String replaceFirst$default(String arg0, String arg1, String arg2, boolean arg3, int arg4, Object arg5) {
        return StringsKt.replaceFirst(arg0, arg1, arg2, false);
    }

    public static final List split(CharSequence arg1, Pattern arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "regex");
        StringsKt.requireNonNegativeLimit(arg3);
        if(arg3 == 0) {
            arg3 = -1;
        }

        String[] v1 = arg2.split(arg1, arg3);
        Intrinsics.checkNotNullExpressionValue(v1, "split(...)");
        return ArraysKt.asList(((Object[])v1));
    }

    public static List split$default(CharSequence arg0, Pattern arg1, int arg2, int arg3, Object arg4) {
        return StringsKt.split(arg0, arg1, 0);
    }

    public static final boolean startsWith(String arg6, String arg7, int arg8, boolean arg9) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        Intrinsics.checkNotNullParameter(arg7, "prefix");
        if(!arg9) {
            return arg6.startsWith(arg7, arg8);
        }

        return StringsKt.regionMatches(arg6, arg8, arg7, 0, arg7.length(), arg9);
    }

    public static final boolean startsWith(String arg6, String arg7, boolean arg8) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        Intrinsics.checkNotNullParameter(arg7, "prefix");
        if(!arg8) {
            return arg6.startsWith(arg7);
        }

        return StringsKt.regionMatches(arg6, 0, arg7, 0, arg7.length(), arg8);
    }

    public static boolean startsWith$default(String arg0, String arg1, int arg2, boolean arg3, int arg4, Object arg5) {
        return StringsKt.startsWith(arg0, arg1, arg2, false);
    }

    public static boolean startsWith$default(String arg0, String arg1, boolean arg2, int arg3, Object arg4) {
        return StringsKt.startsWith(arg0, arg1, false);
    }

    private static final String substring(String arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.substring(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "substring(...)");
        return arg1;
    }

    private static final String substring(String arg1, int arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.substring(arg2, arg3);
        Intrinsics.checkNotNullExpressionValue(arg1, "substring(...)");
        return arg1;
    }

    private static final byte[] toByteArray(String arg1, Charset arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "charset");
        byte[] v1 = arg1.getBytes(arg2);
        Intrinsics.checkNotNullExpressionValue(v1, "getBytes(...)");
        return v1;
    }

    static byte[] toByteArray$default(String arg0, Charset arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = Charsets.UTF_8;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "charset");
        byte[] v0 = arg0.getBytes(arg1);
        Intrinsics.checkNotNullExpressionValue(v0, "getBytes(...)");
        return v0;
    }

    private static final char[] toCharArray(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        char[] v1 = arg1.toCharArray();
        Intrinsics.checkNotNullExpressionValue(v1, "toCharArray(...)");
        return v1;
    }

    public static final char[] toCharArray(String arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(arg3, arg4, arg2.length());
        char[] v0 = new char[arg4 - arg3];
        arg2.getChars(arg3, arg4, v0, 0);
        return v0;
    }

    @IgnorableReturnValue private static final char[] toCharArray(String arg1, char[] arg2, int arg3, int arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "destination");
        arg1.getChars(arg4, arg5, arg2, arg3);
        return arg2;
    }

    public static char[] toCharArray$default(String arg0, int arg1, int arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = arg0.length();
        }

        return StringsKt.toCharArray(arg0, 0, arg2);
    }

    static char[] toCharArray$default(String arg1, char[] arg2, int arg3, int arg4, int arg5, int arg6, Object arg7) {
        if((arg6 & 8) != 0) {
            arg5 = arg1.length();
        }

        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "destination");
        arg1.getChars(0, arg5, arg2, 0);
        return arg2;
    }

    @Deprecated(message="Use lowercase() instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.5") private static final String toLowerCase(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(arg1, "toLowerCase(...)");
        return arg1;
    }

    @Deprecated(message="Use lowercase() instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.5") private static final String toLowerCase(String arg1, Locale arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "locale");
        arg1 = arg1.toLowerCase(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "toLowerCase(...)");
        return arg1;
    }

    private static final Pattern toPattern(String arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Pattern v1 = Pattern.compile(arg1, arg2);
        Intrinsics.checkNotNullExpressionValue(v1, "compile(...)");
        return v1;
    }

    static Pattern toPattern$default(String arg0, int arg1, int arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Pattern v0 = Pattern.compile(arg0, 0);
        Intrinsics.checkNotNullExpressionValue(v0, "compile(...)");
        return v0;
    }

    @Deprecated(message="Use uppercase() instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.5") private static final String toUpperCase(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(arg1, "toUpperCase(...)");
        return arg1;
    }

    @Deprecated(message="Use uppercase() instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.5") private static final String toUpperCase(String arg1, Locale arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "locale");
        arg1 = arg1.toUpperCase(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "toUpperCase(...)");
        return arg1;
    }

    private static final String uppercase(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(arg1, "toUpperCase(...)");
        return arg1;
    }

    private static final String uppercase(String arg1, Locale arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "locale");
        arg1 = arg1.toUpperCase(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "toUpperCase(...)");
        return arg1;
    }
}


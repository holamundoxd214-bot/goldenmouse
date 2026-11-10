package kotlin.text;

import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0000\u001A\u001E\u0010\u0000\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\b\u001A\u001E\u0010\u0000\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\u0005H\u0087\u0088\b\u001A&\u0010\u0006\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\b\u001A&\u0010\u0006\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\u0005H\u0087\u0088\b\u001A\u0016\u0010\t\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0087\u0080\b\u001A\"\u0010\n\u001A\u00020\u000B*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\fH\u0087\u008A\u0004\u001A.\u0010\r\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u000E\u001A\u00020\b2\u0006\u0010\u000F\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\u0010H\u0087\u0088\b\u001A\u001E\u0010\u0011\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0007\u001A\u00020\bH\u0087\u0088\b\u001A&\u0010\u0012\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u000E\u001A\u00020\b2\u0006\u0010\u000F\u001A\u00020\bH\u0087\u0088\b\u001A8\u0010\u0013\u001A\u00020\u000B*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0014\u001A\u00020\u00152\b\b\u0002\u0010\u0016\u001A\u00020\b2\b\b\u0002\u0010\u000E\u001A\u00020\b2\b\b\u0002\u0010\u000F\u001A\u00020\bH\u0087\u0088\u0004\u001A.\u0010\u0017\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\u00152\u0006\u0010\u000E\u001A\u00020\b2\u0006\u0010\u000F\u001A\u00020\bH\u0087\u0088\b\u001A.\u0010\u0017\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\u00182\u0006\u0010\u000E\u001A\u00020\b2\u0006\u0010\u000F\u001A\u00020\bH\u0087\u0088\b\u001A6\u0010\u0019\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\u00152\u0006\u0010\u000E\u001A\u00020\b2\u0006\u0010\u000F\u001A\u00020\bH\u0087\u0088\b\u001A6\u0010\u0019\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\u0003\u001A\u00020\u00182\u0006\u0010\u000E\u001A\u00020\b2\u0006\u0010\u000F\u001A\u00020\bH\u0087\u0088\b\u001A \u0010\u001A\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u001BH\u0087\u0088\b\u001A&\u0010\u001A\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u000E\u0010\u0003\u001A\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0087\u0088\b\u001A\u001E\u0010\u001A\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\bH\u0087\u0088\b\u001A\u001E\u0010\u001A\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\u0005H\u0087\u0088\b\u001A\u001E\u0010\u001A\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\b\u001A\u001E\u0010\u001A\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\u001CH\u0087\u0088\b\u001A\u001E\u0010\u001A\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\u001DH\u0087\u0088\b\u001A\u001E\u0010\u001A\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\u001EH\u0087\u0088\b\u001A\u0016\u0010\u001F\u001A\u00060 j\u0002`!*\u00060 j\u0002`!H\u0087\u0080\u0004\u001A \u0010\u001F\u001A\u00060 j\u0002`!*\u00060 j\u0002`!2\b\u0010\u0003\u001A\u0004\u0018\u00010\u0018H\u0087\u0088\u0004\u001A\u001E\u0010\u001F\u001A\u00060 j\u0002`!*\u00060 j\u0002`!2\u0006\u0010\u0003\u001A\u00020\fH\u0087\u0088\u0004\u001A\u0016\u0010\u001F\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0087\u0080\u0004\u001A \u0010\u001F\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u001BH\u0087\u0088\u0004\u001A \u0010\u001F\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u0018H\u0087\u0088\u0004\u001A \u0010\u001F\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u0010H\u0087\u0088\u0004\u001A \u0010\u001F\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\"H\u0087\u0088\u0004\u001A&\u0010\u001F\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u000E\u0010\u0003\u001A\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0087\u0088\u0004\u001A\u001E\u0010\u001F\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\u0015H\u0087\u0088\u0004\u001A\u001E\u0010\u001F\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\fH\u0087\u0088\u0004\u001A\u001E\u0010\u001F\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020#H\u0087\u0088\u0004\u001A\u001E\u0010\u001F\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\bH\u0087\u0088\u0004\u001A\u001E\u0010\u001F\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\u0005H\u0087\u0088\u0004\u001A\u001E\u0010\u001F\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004\u001A\u001E\u0010\u001F\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\u001CH\u0087\u0088\u0004\u001A\u001E\u0010\u001F\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\u001DH\u0087\u0088\u0004\u001A\u001E\u0010\u001F\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001A\u00020\u001EH\u0087\u0088\u0004¨\u0006$"}, d2={"append", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "value", "", "", "insert", "index", "", "clear", "set", "", "", "setRange", "startIndex", "endIndex", "", "deleteAt", "deleteRange", "toCharArray", "destination", "", "destinationOffset", "appendRange", "", "insertRange", "appendLine", "Ljava/lang/StringBuffer;", "", "", "", "appendln", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "", "", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/text/StringsKt") class StringsKt__StringBuilderJVMKt extends StringsKt__RegexExtensionsKt {
    public StringsKt__StringBuilderJVMKt() {
        super();
    }

    @IgnorableReturnValue private static final StringBuilder append(StringBuilder arg1, byte arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return arg1;
    }

    @IgnorableReturnValue private static final StringBuilder append(StringBuilder arg1, short arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return arg1;
    }

    @IgnorableReturnValue private static final StringBuilder appendLine(StringBuilder arg1, byte arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return arg1.append('\n');
    }

    @IgnorableReturnValue private static final StringBuilder appendLine(StringBuilder arg1, double arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return arg1.append('\n');
    }

    @IgnorableReturnValue private static final StringBuilder appendLine(StringBuilder arg1, float arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return arg1.append('\n');
    }

    @IgnorableReturnValue private static final StringBuilder appendLine(StringBuilder arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return arg1.append('\n');
    }

    @IgnorableReturnValue private static final StringBuilder appendLine(StringBuilder arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return arg1.append('\n');
    }

    @IgnorableReturnValue private static final StringBuilder appendLine(StringBuilder arg1, StringBuffer arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return arg1.append('\n');
    }

    @IgnorableReturnValue private static final StringBuilder appendLine(StringBuilder arg1, StringBuilder arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(((CharSequence)arg2));
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return arg1.append('\n');
    }

    @IgnorableReturnValue private static final StringBuilder appendLine(StringBuilder arg1, short arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return arg1.append('\n');
    }

    @IgnorableReturnValue private static final StringBuilder appendRange(StringBuilder arg1, CharSequence arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "value");
        arg1 = arg1.append(arg2, arg3, arg4);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return arg1;
    }

    @IgnorableReturnValue private static final StringBuilder appendRange(StringBuilder arg1, char[] arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "value");
        arg1 = arg1.append(arg2, arg3, arg4 - arg3);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return arg1;
    }

    @Deprecated(message="Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.4") public static final Appendable appendln(Appendable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return arg1;
    }

    @Deprecated(message="Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.4") private static final Appendable appendln(Appendable arg1, char arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return StringsKt.appendln(arg1);
    }

    @Deprecated(message="Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.4") private static final Appendable appendln(Appendable arg1, CharSequence arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return StringsKt.appendln(arg1);
    }

    @Deprecated(message="Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.4") public static final StringBuilder appendln(StringBuilder arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return arg1;
    }

    @Deprecated(message="Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.4") private static final StringBuilder appendln(StringBuilder arg1, byte arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return StringsKt.appendln(arg1);
    }

    @Deprecated(message="Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.4") private static final StringBuilder appendln(StringBuilder arg1, char arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return StringsKt.appendln(arg1);
    }

    @Deprecated(message="Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.4") private static final StringBuilder appendln(StringBuilder arg1, double arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return StringsKt.appendln(arg1);
    }

    @Deprecated(message="Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.4") private static final StringBuilder appendln(StringBuilder arg1, float arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return StringsKt.appendln(arg1);
    }

    @Deprecated(message="Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.4") private static final StringBuilder appendln(StringBuilder arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return StringsKt.appendln(arg1);
    }

    @Deprecated(message="Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.4") private static final StringBuilder appendln(StringBuilder arg1, long arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return StringsKt.appendln(arg1);
    }

    @Deprecated(message="Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.4") private static final StringBuilder appendln(StringBuilder arg1, CharSequence arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return StringsKt.appendln(arg1);
    }

    @Deprecated(message="Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.4") private static final StringBuilder appendln(StringBuilder arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return StringsKt.appendln(arg1);
    }

    @Deprecated(message="Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.4") private static final StringBuilder appendln(StringBuilder arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return StringsKt.appendln(arg1);
    }

    @Deprecated(message="Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.4") private static final StringBuilder appendln(StringBuilder arg1, StringBuffer arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return StringsKt.appendln(arg1);
    }

    @Deprecated(message="Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.4") private static final StringBuilder appendln(StringBuilder arg1, StringBuilder arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(((CharSequence)arg2));
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return StringsKt.appendln(arg1);
    }

    @Deprecated(message="Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.4") private static final StringBuilder appendln(StringBuilder arg1, short arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return StringsKt.appendln(arg1);
    }

    @Deprecated(message="Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.4") private static final StringBuilder appendln(StringBuilder arg1, boolean arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.append(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return StringsKt.appendln(arg1);
    }

    @Deprecated(message="Use appendLine instead. Note that the new method always appends the line feed character \'\\n\' regardless of the system line separator.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="2.1", warningSince="1.4") private static final StringBuilder appendln(StringBuilder arg1, char[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "value");
        arg1 = arg1.append(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "append(...)");
        return StringsKt.appendln(arg1);
    }

    @IgnorableReturnValue public static final StringBuilder clear(StringBuilder arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.setLength(0);
        return arg1;
    }

    @IgnorableReturnValue private static final StringBuilder deleteAt(StringBuilder arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.deleteCharAt(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "deleteCharAt(...)");
        return arg1;
    }

    @IgnorableReturnValue private static final StringBuilder deleteRange(StringBuilder arg1, int arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.delete(arg2, arg3);
        Intrinsics.checkNotNullExpressionValue(arg1, "delete(...)");
        return arg1;
    }

    @IgnorableReturnValue private static final StringBuilder insert(StringBuilder arg1, int arg2, byte arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.insert(arg2, arg3);
        Intrinsics.checkNotNullExpressionValue(arg1, "insert(...)");
        return arg1;
    }

    @IgnorableReturnValue private static final StringBuilder insert(StringBuilder arg1, int arg2, short arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.insert(arg2, arg3);
        Intrinsics.checkNotNullExpressionValue(arg1, "insert(...)");
        return arg1;
    }

    @IgnorableReturnValue private static final StringBuilder insertRange(StringBuilder arg1, int arg2, CharSequence arg3, int arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg1 = arg1.insert(arg2, arg3, arg4, arg5);
        Intrinsics.checkNotNullExpressionValue(arg1, "insert(...)");
        return arg1;
    }

    @IgnorableReturnValue private static final StringBuilder insertRange(StringBuilder arg1, int arg2, char[] arg3, int arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "value");
        arg1 = arg1.insert(arg2, arg3, arg4, arg5 - arg4);
        Intrinsics.checkNotNullExpressionValue(arg1, "insert(...)");
        return arg1;
    }

    private static final void set(StringBuilder arg1, int arg2, char arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1.setCharAt(arg2, arg3);
    }

    @IgnorableReturnValue private static final StringBuilder setRange(StringBuilder arg1, int arg2, int arg3, String arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "value");
        arg1 = arg1.replace(arg2, arg3, arg4);
        Intrinsics.checkNotNullExpressionValue(arg1, "replace(...)");
        return arg1;
    }

    private static final void toCharArray(StringBuilder arg1, char[] arg2, int arg3, int arg4, int arg5) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "destination");
        arg1.getChars(arg4, arg5, arg2, arg3);
    }

    static void toCharArray$default(StringBuilder arg1, char[] arg2, int arg3, int arg4, int arg5, int arg6, Object arg7) {
        if((arg6 & 8) != 0) {
            arg5 = arg1.length();
        }

        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "destination");
        arg1.getChars(0, arg5, arg2, 0);
    }
}


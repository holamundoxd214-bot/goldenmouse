package kotlin.text;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\u001A%\u0010\u0000\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004H\u0087\u0088\b¢\u0006\u0002\u0010\u0005\u001A7\u0010\u0006\u001A\u00020\u00072\u001B\u0010\b\u001A\u0017\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000BH\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001A?\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\r2\u001B\u0010\b\u001A\u0017\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\b\u000BH\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001A3\u0010\u0000\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0016\u0010\u000E\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u000F\"\u0004\u0018\u00010\u0007H\u0087\u0080\b¢\u0006\u0002\u0010\u0010\u001A3\u0010\u0000\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0016\u0010\u000E\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u000F\"\u0004\u0018\u00010\u0004H\u0087\u0080\b¢\u0006\u0002\u0010\u0011\u001A3\u0010\u0000\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\rH\u0087\u0088\b¢\u0006\u0002\u0010\u0016\u001A\u001B\u0010\u0017\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0087\u0088\b¢\u0006\u0002\u0010\u0018\u001A%\u0010\u0017\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u000E\u001A\u0004\u0018\u00010\u0019H\u0087\u0088\b¢\u0006\u0002\u0010\u001A\u001A%\u0010\u0017\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u000E\u001A\u0004\u0018\u00010\u0007H\u0087\u0088\b¢\u0006\u0002\u0010\u001B\u001A%\u0010\u0017\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u000E\u001A\u0004\u0018\u00010\u0004H\u0087\u0088\b¢\u0006\u0002\u0010\u0005\u001A#\u0010\u0017\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u000E\u001A\u00020\u0013H\u0087\u0088\b¢\u0006\u0002\u0010\u001C\u001A#\u0010\u0017\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u000E\u001A\u00020\u001DH\u0087\u0088\b¢\u0006\u0002\u0010\u001E\u001A#\u0010\u0017\u001A\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u000E\u001A\u00020\u001FH\u0087\u0088\b¢\u0006\u0002\u0010 \u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006!"}, d2={"append", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "obj", "", "(Ljava/lang/StringBuilder;Ljava/lang/Object;)Ljava/lang/StringBuilder;", "buildString", "", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "capacity", "", "value", "", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;[Ljava/lang/Object;)Ljava/lang/StringBuilder;", "str", "", "offset", "len", "(Ljava/lang/StringBuilder;[CII)Ljava/lang/StringBuilder;", "appendLine", "(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;[C)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;C)Ljava/lang/StringBuilder;", "", "(Ljava/lang/StringBuilder;Z)Ljava/lang/StringBuilder;", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/text/StringsKt") class StringsKt__StringBuilderKt extends StringsKt__StringBuilderJVMKt {
    public StringsKt__StringBuilderKt() {
        super();
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Use append(value: Any?) instead", replaceWith="<_subannotation>") @IgnorableReturnValue private static final StringBuilder append(StringBuilder arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.append(arg2);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Use appendRange instead.", replaceWith="<_subannotation>") @IgnorableReturnValue private static final StringBuilder append(StringBuilder arg0, char[] arg1, int arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg1, "str");
        throw new NotImplementedError(null, 1, null);
    }

    @IgnorableReturnValue public static final StringBuilder append(StringBuilder arg3, Object[] arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "value");
        int v0 = arg4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg3.append(arg4[v1]);
        }

        return arg3;
    }

    @IgnorableReturnValue public static final StringBuilder append(StringBuilder arg3, String[] arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "value");
        int v0 = arg4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg3.append(arg4[v1]);
        }

        return arg3;
    }

    @IgnorableReturnValue private static final StringBuilder appendLine(StringBuilder arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.append('\n');
    }

    @IgnorableReturnValue private static final StringBuilder appendLine(StringBuilder arg1, char arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.append(arg2).append('\n');
    }

    @IgnorableReturnValue private static final StringBuilder appendLine(StringBuilder arg1, CharSequence arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.append(arg2).append('\n');
    }

    @IgnorableReturnValue private static final StringBuilder appendLine(StringBuilder arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.append(arg2).append('\n');
    }

    @IgnorableReturnValue private static final StringBuilder appendLine(StringBuilder arg1, String arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.append(arg2).append('\n');
    }

    @IgnorableReturnValue private static final StringBuilder appendLine(StringBuilder arg1, boolean arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.append(arg2).append('\n');
    }

    @IgnorableReturnValue private static final StringBuilder appendLine(StringBuilder arg1, char[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "value");
        return arg1.append(arg2).append('\n');
    }

    private static final String buildString(int arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "builderAction");
        StringBuilder v0 = new StringBuilder(arg1);
        arg2.invoke(v0);
        return v0.toString();
    }

    private static final String buildString(Function1 arg1) {
        Intrinsics.checkNotNullParameter(arg1, "builderAction");
        StringBuilder v0 = new StringBuilder();
        arg1.invoke(v0);
        return v0.toString();
    }
}


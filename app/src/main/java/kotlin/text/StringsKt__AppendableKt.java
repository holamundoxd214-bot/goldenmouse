package kotlin.text;

import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000<\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A9\u0010\u0000\u001A\u0002H\u0001\"\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u0003*\u0002H\u00012\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0007H\u0087\u0080\b¢\u0006\u0002\u0010\t\u001A9\u0010\n\u001A\u0002H\u0001\"\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u0003*\u0002H\u00012\u0016\u0010\u0004\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u000B\"\u0004\u0018\u00010\u0005H\u0087\u0080\b¢\u0006\u0002\u0010\f\u001A\u001B\u0010\r\u001A\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u0003H\u0087\u0088\b¢\u0006\u0002\u0010\u000E\u001A%\u0010\r\u001A\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005H\u0087\u0088\b¢\u0006\u0002\u0010\u000F\u001A#\u0010\r\u001A\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001A\u00020\u0010H\u0087\u0088\b¢\u0006\u0002\u0010\u0011\u001A;\u0010\u0012\u001A\u00020\u0013\"\u0004\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0014\u001A\u0002H\u00012\u0014\u0010\u0015\u001A\u0010\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0016H\u0080\u0080\u0004¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2={"appendRange", "T", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "value", "", "startIndex", "", "endIndex", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;II)Ljava/lang/Appendable;", "append", "", "(Ljava/lang/Appendable;[Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "appendLine", "(Ljava/lang/Appendable;)Ljava/lang/Appendable;", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "", "(Ljava/lang/Appendable;C)Ljava/lang/Appendable;", "appendElement", "", "element", "transform", "Lkotlin/Function1;", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/text/StringsKt") class StringsKt__AppendableKt {
    public StringsKt__AppendableKt() {
        super();
    }

    @IgnorableReturnValue public static final Appendable append(Appendable arg3, CharSequence[] arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "value");
        int v0 = arg4.length;
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            arg3.append(arg4[v1]);
        }

        return arg3;
    }

    public static final void appendElement(Appendable arg1, Object arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg3 != null) {
            arg1.append(arg3.invoke(arg2));
            return;
        }

        boolean v3 = arg2 == null ? true : arg2 instanceof CharSequence;
        if(v3) {
            arg1.append(((CharSequence)arg2));
            return;
        }

        if((arg2 instanceof Character)) {
            arg1.append(((Character)arg2).charValue());
            return;
        }

        arg1.append(arg2.toString());
    }

    @IgnorableReturnValue private static final Appendable appendLine(Appendable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.append('\n');
    }

    @IgnorableReturnValue private static final Appendable appendLine(Appendable arg1, char arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.append(arg2).append('\n');
    }

    @IgnorableReturnValue private static final Appendable appendLine(Appendable arg1, CharSequence arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.append(arg2).append('\n');
    }

    @IgnorableReturnValue public static final Appendable appendRange(Appendable arg1, CharSequence arg2, int arg3, int arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "value");
        arg1 = arg1.append(arg2, arg3, arg4);
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type T of kotlin.text.StringsKt__AppendableKt.appendRange");
        return arg1;
    }
}


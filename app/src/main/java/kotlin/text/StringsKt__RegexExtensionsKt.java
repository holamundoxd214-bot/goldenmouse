package kotlin.text;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\u001A\u000E\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004\u001A\u0016\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004\u001A\u001C\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0087\u0088\u0004¨\u0006\u0007"}, d2={"toRegex", "Lkotlin/text/Regex;", "", "option", "Lkotlin/text/RegexOption;", "options", "", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/text/StringsKt") class StringsKt__RegexExtensionsKt extends StringsKt__RegexExtensionsJVMKt {
    public StringsKt__RegexExtensionsKt() {
        super();
    }

    private static final Regex toRegex(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new Regex(arg1);
    }

    private static final Regex toRegex(String arg1, Set arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "options");
        return new Regex(arg1, arg2);
    }

    private static final Regex toRegex(String arg1, RegexOption arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "option");
        return new Regex(arg1, arg2);
    }
}


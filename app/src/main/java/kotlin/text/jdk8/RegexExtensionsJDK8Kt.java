package kotlin.text.jdk8;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchNamedGroupCollection;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\u001A\u0018\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0082\u0004¨\u0006\u0005"}, d2={"get", "Lkotlin/text/MatchGroup;", "Lkotlin/text/MatchGroupCollection;", "name", "", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, pn="kotlin.text", xi=0x30) public final class RegexExtensionsJDK8Kt {
    public static final MatchGroup get(MatchGroupCollection arg1, String arg2) {
        MatchNamedGroupCollection v1;
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "name");
        if((arg1 instanceof MatchNamedGroupCollection)) {
        }
        else {
            v1 = null;
        }

        if(0 != 0) {
            return v1.get(arg2);
        }

        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }
}


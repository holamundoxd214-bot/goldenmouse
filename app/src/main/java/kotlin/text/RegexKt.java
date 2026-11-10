package kotlin.text;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u001C\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0014\u0010\u0000\u001A\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0082\u0080\u0004\u001A.\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0014\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00060\u00072\u0006\u0010\b\u001A\u00020\u0001H\u0082\u0088\u0004\u001A \u0010\t\u001A\u0004\u0018\u00010\n*\u00020\u000B2\u0006\u0010\f\u001A\u00020\u00012\u0006\u0010\r\u001A\u00020\u000EH\u0082\u0080\u0004\u001A\u0018\u0010\u000F\u001A\u0004\u0018\u00010\n*\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000EH\u0082\u0080\u0004\u001A\u000E\u0010\u0010\u001A\u00020\u0011*\u00020\u0012H\u0082\u0080\u0004\u001A\u0016\u0010\u0010\u001A\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0001H\u0082\u0080\u0004¨\u0006\u0014"}, d2={"toInt", "", "", "Lkotlin/text/FlagEnum;", "fromInt", "", "T", "", "value", "findNext", "Lkotlin/text/MatchResult;", "Ljava/util/regex/Matcher;", "from", "input", "", "matchEntire", "range", "Lkotlin/ranges/IntRange;", "Ljava/util/regex/MatchResult;", "groupIndex", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class RegexKt {
    public static final MatchResult access$findNext(Matcher arg0, int arg1, CharSequence arg2) {
        return RegexKt.findNext(arg0, arg1, arg2);
    }

    public static final MatchResult access$matchEntire(Matcher arg0, CharSequence arg1) {
        return RegexKt.matchEntire(arg0, arg1);
    }

    public static final IntRange access$range(java.util.regex.MatchResult arg0) {
        return RegexKt.range(arg0);
    }

    public static final IntRange access$range(java.util.regex.MatchResult arg0, int arg1) {
        return RegexKt.range(arg0, arg1);
    }

    public static final int access$toInt(Iterable arg0) {
        return RegexKt.toInt(arg0);
    }

    private static final MatchResult findNext(Matcher arg0, int arg1, CharSequence arg2) {
        if(!arg0.find(arg1)) {
            return null;
        }

        return new MatcherMatchResult(arg0, arg2);
    }

    private static final Set fromInt(int arg3) {
        Intrinsics.reifiedOperationMarker(4, "T");
        EnumSet v0 = EnumSet.allOf(Enum.class);
        Intrinsics.checkNotNull(v0);
        Intrinsics.needClassReification();
        CollectionsKt.retainAll(v0, new RegexKt$fromInt$1$1(arg3));
        Set v3 = Collections.unmodifiableSet(((Set)v0));
        Intrinsics.checkNotNullExpressionValue(v3, "unmodifiableSet(...)");
        return v3;
    }

    private static final MatchResult matchEntire(Matcher arg1, CharSequence arg2) {
        if(!arg1.matches()) {
            return null;
        }

        return new MatcherMatchResult(arg1, arg2);
    }

    private static final IntRange range(java.util.regex.MatchResult arg1) {
        return RangesKt.until(arg1.start(), arg1.end());
    }

    private static final IntRange range(java.util.regex.MatchResult arg1, int arg2) {
        return RangesKt.until(arg1.start(arg2), arg1.end(arg2));
    }

    private static final int toInt(Iterable arg2) {
        Iterator v2 = arg2.iterator();
        int v0;
        for(v0 = 0; v2.hasNext(); v0 |= v2.next().getValue()) {
        }

        return v0;
    }
}


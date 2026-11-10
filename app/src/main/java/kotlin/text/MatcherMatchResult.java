package kotlin.text;

import java.util.List;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\f\u0010\u001D\u001A\u0004\u0018\u00010\u0001H\u0096\u0080\u0004R\u000F\u0010\u0002\u001A\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000F\u0010\u0004\u001A\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\b\u001A\u00020\t8BX\u0082\u0084\b¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0015\u0010\f\u001A\u00020\r8VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0015\u0010\u0010\u001A\u00020\u00118VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0014\u001A\u00020\u0015X\u0096\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001A\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0019X\u0082\u008E\b¢\u0006\u0002\n\u0000R\u001B\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00110\u00198VX\u0096\u0084\b¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001C¨\u0006\u001E"}, d2={"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", "", "<init>", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "matchResult", "Ljava/util/regex/MatchResult;", "getMatchResult", "()Ljava/util/regex/MatchResult;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "", "getValue", "()Ljava/lang/String;", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "groupValues_", "", "groupValues", "getGroupValues", "()Ljava/util/List;", "next", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class MatcherMatchResult implements MatchResult {
    private List groupValues_;
    private final MatchGroupCollection groups;
    private final CharSequence input;
    private final Matcher matcher;

    public MatcherMatchResult(Matcher arg2, CharSequence arg3) {
        Intrinsics.checkNotNullParameter(arg2, "matcher");
        Intrinsics.checkNotNullParameter(arg3, "input");
        super();
        this.matcher = arg2;
        this.input = arg3;
        this.groups = new MatcherMatchResult$groups$1(this);
    }

    public static final java.util.regex.MatchResult access$getMatchResult(MatcherMatchResult arg0) {
        return arg0.getMatchResult();
    }

    public Destructured getDestructured() {
        return DefaultImpls.getDestructured(((MatchResult)this));
    }

    public List getGroupValues() {
        MatcherMatchResult$groupValues$1 v0_1;
        List v0 = this.groupValues_;
        if(v0 == null) {
            v0_1 = new MatcherMatchResult$groupValues$1(this);
            this.groupValues_ = ((List)v0_1);
        }

        Intrinsics.checkNotNull(v0_1);
        return ((List)v0_1);
    }

    public MatchGroupCollection getGroups() {
        return this.groups;
    }

    private final java.util.regex.MatchResult getMatchResult() {
        return this.matcher;
    }

    public IntRange getRange() {
        return RegexKt.access$range(this.getMatchResult());
    }

    public String getValue() {
        String v1 = this.getMatchResult().group();
        Intrinsics.checkNotNullExpressionValue(v1, "group(...)");
        return v1;
    }

    public MatchResult next() {
        int v0 = this.getMatchResult().end();
        int v1 = this.getMatchResult().end() == this.getMatchResult().start() ? 1 : 0;
        v0 += v1;
        if(v0 <= this.input.length()) {
            Matcher v1_1 = this.matcher.pattern().matcher(this.input);
            Intrinsics.checkNotNullExpressionValue(v1_1, "matcher(...)");
            return RegexKt.access$findNext(v1_1, v0, this.input);
        }

        return null;
    }
}


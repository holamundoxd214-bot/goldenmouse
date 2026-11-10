package androidx.compose.runtime.tooling;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u0011J\u000E\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0003J\u000E\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0010\u001A\u00020\u0011J\u000E\u0010\u0017\u001A\u00020\t2\u0006\u0010\u0018\u001A\u00020\u0003J\u000E\u0010\u0019\u001A\u00020\u00032\u0006\u0010\u0018\u001A\u00020\u0003J\u0006\u0010\u001A\u001A\u00020\u0003J\u000E\u0010\u001B\u001A\u00020\u000F2\u0006\u0010\u0018\u001A\u00020\u0003J\u0010\u0010\u001C\u001A\u00020\u000F2\b\b\u0002\u0010\u001D\u001A\u00020\tJ\u0006\u0010\u001E\u001A\u00020\u0011J\u0006\u0010\u001F\u001A\u00020\u0016R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u001A\u0010\b\u001A\u00020\tX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u000B\"\u0004\b\f\u0010\r¨\u0006 "}, d2={"Landroidx/compose/runtime/tooling/SourceInfoParserState;", "", "data", "", "<init>", "(Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "i", "", "getI", "()I", "setI", "(I)V", "expect", "", "char", "", "throwParseError", "", "message", "matches", "", "takeIntUntil", "separator", "takeUntil", "takeUntilEnd", "skipUntil", "advance", "count", "current", "atEnd", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class SourceInfoParserState {
    private final String data;
    private int i;

    public SourceInfoParserState(String arg1) {
        super();
        this.data = arg1;
    }

    public final void advance(int arg2) {
        this.i += arg2;
    }

    public static void advance$default(SourceInfoParserState arg0, int arg1, int arg2, Object arg3) {
        arg0.advance(1);
    }

    public final boolean atEnd() {
        if(this.i >= this.data.length()) {
            return 1;
        }

        return 0;
    }

    public final char current() {
        return this.data.charAt(this.i);
    }

    public final void expect(char arg3) {
        if(this.matches(arg3)) {
            return;
        }

        this.throwParseError("expected " + arg3);
        throw new KotlinNothingValueException();
    }

    public final String getData() {
        return this.data;
    }

    public final int getI() {
        return this.i;
    }

    public final boolean matches(char arg3) {
        if(this.i < this.data.length() && this.data.charAt(this.i) == arg3) {
            return 1;
        }

        return 0;
    }

    public final void setI(int arg1) {
        this.i = arg1;
    }

    public final void skipUntil(String arg6) {
        while(this.i < this.data.length()) {
            if(StringsKt.contains$default(arg6, this.data.charAt(this.i), false, 2, null)) {
                return;
            }

            ++this.i;
        }
    }

    public final int takeIntUntil(String arg1) {
        Integer v1 = StringsKt.toIntOrNull(this.takeUntil(arg1));
        if(v1 != null) {
            return v1.intValue();
        }

        this.throwParseError("expected int");
        throw new KotlinNothingValueException();
    }

    public final String takeUntil(String arg2) {
        int v0 = this.i;
        this.skipUntil(arg2);
        int v2 = this.i;
        if(v2 > v0) {
            String v1 = this.data.substring(v0, v2);
            Intrinsics.checkNotNullExpressionValue(v1, "substring(...)");
            return v1;
        }

        return "";
    }

    public final String takeUntilEnd() {
        String v2 = this.data.substring(this.i, this.data.length());
        Intrinsics.checkNotNullExpressionValue(v2, "substring(...)");
        return v2;
    }

    public final Void throwParseError(String arg5) {
        int v0 = Math.min(this.i, this.data.length());
        StringBuilder v5 = new StringBuilder("Error while parsing source information: ").append(arg5).append(" at ");
        String v2 = this.data.substring(0, v0);
        Intrinsics.checkNotNullExpressionValue(v2, "substring(...)");
        v5 = v5.append(v2).append('|');
        String v4 = this.data.substring(v0);
        Intrinsics.checkNotNullExpressionValue(v4, "substring(...)");
        throw new ParseException(v5.append(v4).toString());
    }
}


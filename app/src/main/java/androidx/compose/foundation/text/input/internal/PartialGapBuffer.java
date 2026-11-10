package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0001\u0018\u0000 \u001E2\u00020\u0001:\u0001\u001EB\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J2\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\b2\u0006\u0010\u0002\u001A\u00020\u00012\b\b\u0002\u0010\u0011\u001A\u00020\b2\b\b\u0002\u0010\u0012\u001A\u00020\bJ\u0011\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\bH\u0096\u0002J\u0018\u0010\u0016\u001A\u00020\u00012\u0006\u0010\u0017\u001A\u00020\b2\u0006\u0010\u0018\u001A\u00020\bH\u0016J\b\u0010\u0019\u001A\u00020\u001AH\u0016J\u000E\u0010\u001B\u001A\u00020\u001C2\u0006\u0010\u001D\u001A\u00020\u0001R\u000E\u0010\u0002\u001A\u00020\u0001X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001A\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\f¨\u0006\u001F"}, d2={"Landroidx/compose/foundation/text/input/internal/PartialGapBuffer;", "", "text", "<init>", "(Ljava/lang/CharSequence;)V", "buffer", "Landroidx/compose/foundation/text/input/internal/GapBuffer;", "bufStart", "", "bufEnd", "length", "getLength", "()I", "replace", "", "start", "end", "textStart", "textEnd", "get", "", "index", "subSequence", "startIndex", "endIndex", "toString", "", "contentEquals", "", "other", "Companion", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PartialGapBuffer implements CharSequence {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Landroidx/compose/foundation/text/input/internal/PartialGapBuffer$Companion;", "", "<init>", "()V", "BUF_SIZE", "", "SURROUNDING_SIZE", "NOWHERE", "foundation"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
        public Companion(DefaultConstructorMarker arg1) {
            this();
        }

        private Companion() {
            super();
        }
    }

    public static final int $stable = 0;
    public static final int BUF_SIZE = 0xFF;
    public static final Companion Companion = null;
    public static final int NOWHERE = -1;
    public static final int SURROUNDING_SIZE = 0x40;
    private int bufEnd;
    private int bufStart;
    private GapBuffer buffer;
    private CharSequence text;

    static {
        PartialGapBuffer.Companion = new Companion(null);
        PartialGapBuffer.$stable = 8;
    }

    public PartialGapBuffer(CharSequence arg1) {
        super();
        this.text = arg1;
        this.bufStart = -1;
        this.bufEnd = -1;
    }

    public final char charAt(int arg1) {
        return this.get(arg1);
    }

    public final boolean contentEquals(CharSequence arg1) {
        return Intrinsics.areEqual(this.toString(), arg1.toString());
    }

    public char get(int arg5) {
        GapBuffer v0 = this.buffer;
        if(v0 == null) {
            return this.text.charAt(arg5);
        }

        if(arg5 < this.bufStart) {
            return this.text.charAt(arg5);
        }

        int v1 = v0.length();
        int v2 = this.bufStart;
        if(arg5 < v1 + v2) {
            return v0.get(arg5 - v2);
        }

        return this.text.charAt(arg5 - (v1 - this.bufEnd + v2));
    }

    public int getLength() {
        GapBuffer v0 = this.buffer;
        CharSequence v1 = this.text;
        if(v0 == null) {
            return v1.length();
        }

        return v1.length() - (this.bufEnd - this.bufStart) + v0.length();
    }

    public final int length() {
        return this.getLength();
    }

    public final void replace(int arg9, int arg10, CharSequence arg11, int arg12, int arg13) {
        int v4;
        int v0 = 1;
        int v2 = arg9 <= arg10 ? 1 : 0;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("start=" + arg9 + " > end=" + arg10);
        }

        v2 = arg12 <= arg13 ? 1 : 0;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("textStart=" + arg12 + " > textEnd=" + arg13);
        }

        v2 = arg9 >= 0 ? 1 : 0;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("start must be non-negative, but was " + arg9);
        }

        if(arg12 >= 0) {
        }
        else {
            v0 = 0;
        }

        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("textStart must be non-negative, but was " + arg12);
        }

        GapBuffer v2_1 = this.buffer;
        v0 = arg13 - arg12;
        if(v2_1 == null) {
            v2 = Math.max(0xFF, v0 + 0x80);
            char[] v3 = new char[v2];
            int v5 = Math.min(arg9, 0x40);
            v4 = Math.min(this.text.length() - arg10, 0x40);
            int v7 = arg9 - v5;
            ToCharArray_androidKt.toCharArray(this.text, v3, 0, v7, arg9);
            v2 -= v4;
            v4 += arg10;
            ToCharArray_androidKt.toCharArray(this.text, v3, v2, arg10, v4);
            ToCharArray_androidKt.toCharArray(arg11, v3, v5, arg12, arg13);
            this.buffer = new GapBuffer(v3, v5 + v0, v2);
            this.bufStart = v7;
            this.bufEnd = v4;
            return;
        }

        int v3_1 = arg9 - this.bufStart;
        v4 = arg10 - this.bufStart;
        if(v3_1 >= 0) {
            if(v4 > v2_1.length()) {
            }
            else {
                v2_1.replace(v3_1, v4, arg11, arg12, arg13);
                return;
            }
        }

        this.text = this.toString();
        this.buffer = null;
        this.bufStart = -1;
        this.bufEnd = -1;
        this.replace(arg9, arg10, arg11, arg12, arg13);
    }

    public static void replace$default(PartialGapBuffer arg6, int arg7, int arg8, CharSequence arg9, int arg10, int arg11, int arg12, Object arg13) {
        if((arg12 & 16) != 0) {
            arg11 = arg9.length();
        }

        arg6.replace(arg7, arg8, arg9, 0, arg11);
    }

    public CharSequence subSequence(int arg1, int arg2) {
        return this.toString().subSequence(arg1, arg2);
    }

    public String toString() {
        GapBuffer v0 = this.buffer;
        CharSequence v1 = this.text;
        if(v0 == null) {
            return v1.toString();
        }

        StringBuilder v2 = new StringBuilder();
        v2.append(v1, 0, this.bufStart);
        v0.append(v2);
        v2.append(this.text, this.bufEnd, this.text.length());
        return v2.toString();
    }
}


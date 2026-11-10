package androidx.compose.ui.text.input;

import androidx.compose.ui.text.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001E\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\f2\u0006\u0010\u0014\u001A\u00020\f2\u0006\u0010\u0002\u001A\u00020\u0003J\u0011\u0010\u0015\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\fH\u0086\u0002J\b\u0010\u0018\u001A\u00020\u0003H\u0016R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u000E\u001A\u00020\f8F¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u001A"}, d2={"Landroidx/compose/ui/text/input/PartialGapBuffer;", "", "text", "", "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "setText", "buffer", "Landroidx/compose/ui/text/input/GapBuffer;", "bufStart", "", "bufEnd", "length", "getLength", "()I", "replace", "", "start", "end", "get", "", "index", "toString", "Companion", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PartialGapBuffer {
    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Landroidx/compose/ui/text/input/PartialGapBuffer$Companion;", "", "<init>", "()V", "BUF_SIZE", "", "SURROUNDING_SIZE", "NOWHERE", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
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
    private String text;

    static {
        PartialGapBuffer.Companion = new Companion(null);
        PartialGapBuffer.$stable = 8;
    }

    public PartialGapBuffer(String arg1) {
        super();
        this.text = arg1;
        this.bufStart = -1;
        this.bufEnd = -1;
    }

    public final char get(int arg5) {
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

    public final int getLength() {
        GapBuffer v0 = this.buffer;
        String v1 = this.text;
        if(v0 == null) {
            return v1.length();
        }

        return v1.length() - (this.bufEnd - this.bufStart) + v0.length();
    }

    public final String getText() {
        return this.text;
    }

    public final void replace(int arg8, int arg9, String arg10) {
        int v0 = 1;
        int v2 = arg8 <= arg9 ? 1 : 0;
        if(v2 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("start index must be less than or equal to end index: " + arg8 + " > " + arg9);
        }

        if(arg8 >= 0) {
        }
        else {
            v0 = 0;
        }

        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("start must be non-negative, but was " + arg8);
        }

        GapBuffer v0_1 = this.buffer;
        if(v0_1 == null) {
            v0 = Math.max(0xFF, arg10.length() + 0x80);
            char[] v2_1 = new char[v0];
            int v4 = Math.min(arg8, 0x40);
            int v3 = Math.min(this.text.length() - arg9, 0x40);
            int v6 = arg8 - v4;
            GapBuffer_jvmKt.toCharArray(this.text, v2_1, 0, v6, arg8);
            v0 -= v3;
            v3 += arg9;
            GapBuffer_jvmKt.toCharArray(this.text, v2_1, v0, arg9, v3);
            GapBufferKt.toCharArray(arg10, v2_1, v4);
            this.buffer = new GapBuffer(v2_1, v4 + arg10.length(), v0);
            this.bufStart = v6;
            this.bufEnd = v3;
            return;
        }

        v2 = arg8 - this.bufStart;
        int v1 = arg9 - this.bufStart;
        if(v2 >= 0) {
            if(v1 > v0_1.length()) {
            }
            else {
                v0_1.replace(v2, v1, arg10);
                return;
            }
        }

        this.text = this.toString();
        this.buffer = null;
        this.bufStart = -1;
        this.bufEnd = -1;
        this.replace(arg8, arg9, arg10);
    }

    public final void setText(String arg1) {
        this.text = arg1;
    }

    public String toString() {
        GapBuffer v0 = this.buffer;
        String v1 = this.text;
        if(v0 == null) {
            return v1;
        }

        StringBuilder v2 = new StringBuilder();
        v2.append(((CharSequence)v1), 0, this.bufStart);
        v0.append(v2);
        v2.append(this.text, this.bufEnd, this.text.length());
        return v2.toString();
    }
}


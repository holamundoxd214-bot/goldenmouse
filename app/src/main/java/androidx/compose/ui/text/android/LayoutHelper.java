package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.TextUtils;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u0019\n\u0002\b\b\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001:\u00010B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0012\u001A\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001A\u00020\nJ\u001A\u0010\u0017\u001A\u00020\n2\b\b\u0001\u0010\u0018\u001A\u00020\n2\b\b\u0002\u0010\u0019\u001A\u00020\u001AJ\u0010\u0010\u001B\u001A\u00020\n2\b\b\u0001\u0010\u0013\u001A\u00020\nJ\u0010\u0010\u001C\u001A\u00020\n2\b\b\u0001\u0010\u0013\u001A\u00020\nJ\u0010\u0010\u001D\u001A\u00020\u001A2\b\b\u0001\u0010\u0013\u001A\u00020\nJ\u001E\u0010\u001E\u001A\u00020\u001F2\u0006\u0010\u0018\u001A\u00020\n2\u0006\u0010 \u001A\u00020\u001A2\u0006\u0010\u0019\u001A\u00020\u001AJ\u000E\u0010!\u001A\u00020\n2\u0006\u0010\"\u001A\u00020\nJ\u0018\u0010#\u001A\u00020\u001F2\u0006\u0010\u0018\u001A\u00020\n2\u0006\u0010$\u001A\u00020\u001AH\u0002J\u0018\u0010%\u001A\u00020\n2\u0006\u0010&\u001A\u00020\n2\u0006\u0010\'\u001A\u00020\nH\u0002J\u001D\u0010(\u001A\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010\"\u001A\u00020\nH\u0000¢\u0006\u0004\b+\u0010,J\u000E\u0010-\u001A\u00020\u001A2\u0006\u0010.\u001A\u00020/R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000B\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001A\u00020\n¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016¨\u00061"}, d2={"Landroidx/compose/ui/text/android/LayoutHelper;", "", "layout", "Landroid/text/Layout;", "<init>", "(Landroid/text/Layout;)V", "getLayout", "()Landroid/text/Layout;", "paragraphEnds", "", "", "paragraphBidi", "", "Ljava/text/Bidi;", "bidiProcessedParagraphs", "", "tmpBuffer", "", "analyzeBidi", "paragraphIndex", "paragraphCount", "getParagraphCount", "()I", "getParagraphForOffset", "offset", "upstream", "", "getParagraphStart", "getParagraphEnd", "isRtlParagraph", "getHorizontalPosition", "", "usePrimaryDirection", "getLineVisibleEnd", "lineIndex", "getDownstreamHorizontal", "primary", "lineEndToVisibleEnd", "lineEnd", "lineStart", "getLineBidiRuns", "", "Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;", "getLineBidiRuns$ui_text", "(I)[Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;", "isLineEndSpace", "c", "", "BidiRun", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LayoutHelper {
    @Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u000E\n\u0002\u0010\u000E\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000F\u001A\u00020\u0006HÆ\u0003J\'\u0010\u0010\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001A\u00020\u00062\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001A\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\nR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\f¨\u0006\u0016"}, d2={"Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;", "", "start", "", "end", "isRtl", "", "<init>", "(IIZ)V", "getStart", "()I", "getEnd", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) public final class BidiRun {
        public static final int $stable;
        private final int end;
        private final boolean isRtl;
        private final int start;

        static {
        }

        public BidiRun(int arg1, int arg2, boolean arg3) {
            super();
            this.start = arg1;
            this.end = arg2;
            this.isRtl = arg3;
        }

        public final int component1() {
            return this.start;
        }

        public final int component2() {
            return this.end;
        }

        public final boolean component3() {
            return this.isRtl;
        }

        public final BidiRun copy(int arg1, int arg2, boolean arg3) {
            return new BidiRun(arg1, arg2, arg3);
        }

        public static BidiRun copy$default(BidiRun arg0, int arg1, int arg2, boolean arg3, int arg4, Object arg5) {
            if((arg4 & 1) != 0) {
                arg1 = arg0.start;
            }

            if((arg4 & 2) != 0) {
                arg2 = arg0.end;
            }

            if((arg4 & 4) != 0) {
                arg3 = arg0.isRtl;
            }

            return arg0.copy(arg1, arg2, arg3);
        }

        public boolean equals(Object arg5) {
            if(this == (((BidiRun)arg5))) {
                return 1;
            }

            if(!(arg5 instanceof BidiRun)) {
                return 0;
            }

            if(this.start != ((BidiRun)arg5).start) {
                return 0;
            }

            if(this.end != ((BidiRun)arg5).end) {
                return 0;
            }

            if(this.isRtl != ((BidiRun)arg5).isRtl) {
                return 0;
            }

            return 1;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getStart() {
            return this.start;
        }

        public int hashCode() {
            return (Integer.hashCode(this.start) * 0x1F + Integer.hashCode(this.end)) * 0x1F + Boolean.hashCode(this.isRtl);
        }

        public final boolean isRtl() {
            return this.isRtl;
        }

        public String toString() {
            return "BidiRun(start=" + this.start + ", end=" + this.end + ", isRtl=" + this.isRtl + ')';
        }
    }

    public static final int $stable = 8;
    private final boolean[] bidiProcessedParagraphs;
    private final Layout layout;
    private final List paragraphBidi;
    private final int paragraphCount;
    private final List paragraphEnds;
    private char[] tmpBuffer;

    static {
    }

    public LayoutHelper(Layout arg8) {
        super();
        this.layout = arg8;
        ArrayList v8 = new ArrayList();
        int v0 = 0;
        int v3 = 0;
        do {
            int v1 = StringsKt.indexOf$default(this.layout.getText(), '\n', v3, false, 4, null);
            if(v1 < 0) {
                v1 = this.layout.getText().length();
            }
            else {
                ++v1;
            }

            v3 = v1;
            ((List)v8).add(Integer.valueOf(v3));
        }
        while(v3 < this.layout.getText().length());

        this.paragraphEnds = ((List)v8);
        int v8_1 = ((List)v8).size();
        ArrayList v1_1 = new ArrayList(v8_1);
        while(v0 < v8_1) {
            v1_1.add(null);
            ++v0;
        }

        this.paragraphBidi = ((List)v1_1);
        this.bidiProcessedParagraphs = new boolean[this.paragraphEnds.size()];
        this.paragraphCount = this.paragraphEnds.size();
    }

    public final Bidi analyzeBidi(int arg11) {
        Object v3_2;
        if(this.bidiProcessedParagraphs[arg11]) {
            return this.paragraphBidi.get(arg11);
        }

        int v1 = arg11 == 0 ? 0 : this.paragraphEnds.get(arg11 - 1).intValue();
        int v2 = this.paragraphEnds.get(arg11).intValue();
        int v8 = v2 - v1;
        char[] v3 = this.tmpBuffer;
        if(v3 == null || v3.length < v8) {
            v3 = new char[v8];
        }

        char[] v4 = v3;
        TextUtils.getChars(this.layout.getText(), v1, v2, v4, 0);
        Object v1_1 = null;
        if(Bidi.requiresBidi(v4, 0, v8)) {
            Bidi v3_1 = new Bidi(v4, 0, null, 0, v8, this.isRtlParagraph(arg11));
            if(v3_1.getRunCount() == 1) {
                goto label_39;
            }
        }
        else {
        label_39:
            v3_2 = v1_1;
        }

        this.paragraphBidi.set(arg11, v3_2);
        this.bidiProcessedParagraphs[arg11] = true;
        if((((Bidi)v3_2)) != null) {
            char[] v11 = this.tmpBuffer;
            v4 = v4 == v11 ? ((char[])v1_1) : v11;
        }

        this.tmpBuffer = v4;
        return ((Bidi)v3_2);
    }

    private final float getDownstreamHorizontal(int arg3, boolean arg4) {
        arg3 = RangesKt.coerceAtMost(arg3, this.layout.getLineEnd(this.layout.getLineForOffset(arg3)));
        Layout v2 = this.layout;
        if(arg4) {
            return v2.getPrimaryHorizontal(arg3);
        }

        return v2.getSecondaryHorizontal(arg3);
    }

    public final float getHorizontalPosition(int arg17, boolean arg18, boolean arg19) {
        Layout v0_1;
        int v13;
        LayoutHelper v0 = this;
        int v1 = arg17;
        boolean v2 = arg19;
        if(!v2) {
            return this.getDownstreamHorizontal(arg17, arg18);
        }

        int v3 = LayoutCompat_androidKt.getLineForOffset(v0.layout, v1, v2);
        int v4 = v0.layout.getLineStart(v3);
        int v5 = v0.layout.getLineEnd(v3);
        if(v1 != v4 && v1 != v5) {
            return this.getDownstreamHorizontal(arg17, arg18);
        }

        if(v1 != 0) {
            if(v1 == v0.layout.getText().length()) {
            }
            else {
                int v2_1 = v0.getParagraphForOffset(v1, v2);
                boolean v6 = v0.isRtlParagraph(v2_1);
                v5 = v0.lineEndToVisibleEnd(v5, v4);
                int v7 = v0.getParagraphStart(v2_1);
                int v8 = v4 - v7;
                v7 = v5 - v7;
                Bidi v2_2 = v0.analyzeBidi(v2_1);
                v2_2 = v2_2 != null ? v2_2.createLineBidi(v8, v7) : null;
                boolean v7_1 = false;
                if(v2_2 != null) {
                    if(v2_2.getRunCount() == 1) {
                    }
                    else {
                        int v9 = v2_2.getRunCount();
                        BidiRun[] v10 = new BidiRun[v9];
                        int v11;
                        for(v11 = 0; v11 < v9; ++v11) {
                            v13 = v2_2.getRunStart(v11) + v4;
                            int v14 = v2_2.getRunLimit(v11) + v4;
                            boolean v15 = v2_2.getRunLevel(v11) % 2 == 1 ? true : false;
                            v10[v11] = new BidiRun(v13, v14, v15);
                        }

                        v11 = v2_2.getRunCount();
                        byte[] v12 = new byte[v11];
                        for(v13 = 0; v13 < v11; ++v13) {
                            v12[v13] = ((byte)v2_2.getRunLevel(v13));
                        }

                        Bidi.reorderVisually(v12, 0, ((Object[])v10), 0, v9);
                        v2_1 = -1;
                        if(v1 == v4) {
                            v4 = 0;
                            goto label_71;
                        }

                        if(v1 > v5) {
                            v1 = v0.lineEndToVisibleEnd(v1, v4);
                        }

                        v4 = 0;
                        while(v4 < v9) {
                            if(v10[v4].getEnd() == v1) {
                                v2_1 = v4;
                            }
                            else {
                                ++v4;
                                continue;
                            }

                            break;
                        }

                        BidiRun v1_1 = v10[v2_1];
                        if(!arg18) {
                            if(v6 == v1_1.isRtl()) {
                            }
                            else if(!v6) {
                                v6 = true;
                            }
                            else {
                                v6 = false;
                            }
                        }

                        if(v2_1 == 0 && (v6)) {
                            return v0.layout.getLineLeft(v3);
                        }

                        if(v2_1 == ArraysKt.getLastIndex(((Object[])v10)) && !v6) {
                            return v0.layout.getLineRight(v3);
                        }

                        v0_1 = v0.layout;
                        if(v6) {
                            return v0_1.getPrimaryHorizontal(v10[v2_1 - 1].getEnd());
                        }

                        return v0_1.getPrimaryHorizontal(v10[v2_1 + 1].getEnd());
                    label_71:
                        while(v4 < v9) {
                            if(v10[v4].getStart() == v1) {
                                v2_1 = v4;
                            }
                            else {
                                ++v4;
                                continue;
                            }

                            break;
                        }

                        v1_1 = v10[v2_1];
                        if((arg18) || v6 == v1_1.isRtl()) {
                            v6 = !v6 ? true : false;
                        }

                        if(v2_1 == 0 && (v6)) {
                            return v0.layout.getLineLeft(v3);
                        }

                        if(v2_1 == ArraysKt.getLastIndex(((Object[])v10)) && !v6) {
                            return v0.layout.getLineRight(v3);
                        }

                        v0_1 = v0.layout;
                        if(v6) {
                            return v0_1.getPrimaryHorizontal(v10[v2_1 - 1].getStart());
                        }

                        return v0_1.getPrimaryHorizontal(v10[v2_1 + 1].getStart());
                    }
                }

                v2 = v0.layout.isRtlCharAt(v4);
                if((arg18) || v6 == v2) {
                    v6 = !v6 ? true : false;
                }

                if(v1 == v4) {
                    v7_1 = v6;
                }
                else if(!v6) {
                    v7_1 = true;
                }

                v0_1 = v0.layout;
                if(v7_1) {
                    return v0_1.getLineLeft(v3);
                }

                return v0_1.getLineRight(v3);
            }
        }

        return this.getDownstreamHorizontal(arg17, arg18);
    }

    public final Layout getLayout() {
        return this.layout;
    }

    public final BidiRun[] getLineBidiRuns$ui_text(int arg11) {
        int v0 = this.layout.getLineStart(arg11);
        arg11 = this.layout.getLineEnd(arg11);
        int v3 = 2;
        int v1 = LayoutHelper.getParagraphForOffset$default(this, v0, false, v3, null);
        int v4 = this.getParagraphStart(v1);
        int v5 = v0 - v4;
        v4 = arg11 - v4;
        Bidi v1_1 = this.analyzeBidi(v1);
        if(v1_1 != null) {
            v1_1 = v1_1.createLineBidi(v5, v4);
            if(v1_1 == null) {
            }
            else {
                int v10 = v1_1.getRunCount();
                BidiRun[] v11 = new BidiRun[v10];
                for(v4 = 0; v4 < v10; ++v4) {
                    int v7 = v1_1.getRunStart(v4) + v0;
                    int v8 = v1_1.getRunLimit(v4) + v0;
                    boolean v9 = v1_1.getRunLevel(v4) % v3 == 1 ? true : false;
                    v11[v4] = new BidiRun(v7, v8, v9);
                }

                return v11;
            }
        }

        return new BidiRun[]{new BidiRun(v0, arg11, this.layout.isRtlCharAt(v0))};
    }

    public final int getLineVisibleEnd(int arg3) {
        return this.lineEndToVisibleEnd(this.layout.getLineEnd(arg3), this.layout.getLineStart(arg3));
    }

    public final int getParagraphCount() {
        return this.paragraphCount;
    }

    public final int getParagraphEnd(int arg1) {
        return this.paragraphEnds.get(arg1).intValue();
    }

    public final int getParagraphForOffset(int arg7, boolean arg8) {
        int v0 = CollectionsKt.binarySearch$default(this.paragraphEnds, Integer.valueOf(arg7), 0, 0, 6, null);
        if(v0 < 0) {
            v0 = -(v0 + 1);
        }
        else {
            ++v0;
        }

        if((arg8) && v0 > 0) {
            int v8 = v0 - 1;
            if(arg7 == this.paragraphEnds.get(v8).intValue()) {
                return v8;
            }
        }

        return v0;
    }

    public static int getParagraphForOffset$default(LayoutHelper arg0, int arg1, boolean arg2, int arg3, Object arg4) {
        return arg0.getParagraphForOffset(arg1, false);
    }

    public final int getParagraphStart(int arg1) {
        if(arg1 == 0) {
            return 0;
        }

        return this.paragraphEnds.get(arg1 - 1).intValue();
    }

    public final boolean isLineEndSpace(char arg1) {
        if(arg1 != 0x20 && arg1 != 10 && arg1 != 5760 && (Intrinsics.compare(arg1, 0x2000) < 0 || Intrinsics.compare(arg1, 0x200A) > 0 || arg1 == 0x2007) && arg1 != 0x205F && arg1 != 0x3000) {
            return 0;
        }

        return 1;
    }

    public final boolean isRtlParagraph(int arg2) {
        if(this.layout.getParagraphDirection(this.layout.getLineForOffset(this.getParagraphStart(arg2))) == -1) {
            return 1;
        }

        return 0;
    }

    private final int lineEndToVisibleEnd(int arg3, int arg4) {
        while(arg3 > arg4) {
            if(!this.isLineEndSpace(this.layout.getText().charAt(arg3 - 1))) {
                return arg3;
            }

            --arg3;
        }

        return arg3;
    }
}


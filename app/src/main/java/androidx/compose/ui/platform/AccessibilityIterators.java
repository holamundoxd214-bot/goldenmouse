package androidx.compose.ui.platform;

import android.graphics.Rect;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import java.text.BreakIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u000B"}, d2={"Landroidx/compose/ui/platform/AccessibilityIterators;", "", "<init>", "()V", "TextSegmentIterator", "AbstractTextSegmentIterator", "CharacterTextSegmentIterator", "WordTextSegmentIterator", "ParagraphTextSegmentIterator", "LineTextSegmentIterator", "PageTextSegmentIterator", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class AccessibilityIterators {
    @Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\u0004\u001A\u00020\u0005H\u0016J\u001A\u0010\u000E\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0010H\u0004R\u001A\u0010\u0004\u001A\u00020\u0005X\u0084.¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "<init>", "()V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "segment", "", "initialize", "", "getRange", "start", "", "end", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public abstract class AbstractTextSegmentIterator implements TextSegmentIterator {
        public static final int $stable = 8;
        private final int[] segment;
        protected String text;

        static {
        }

        public AbstractTextSegmentIterator() {
            super();
            this.segment = new int[2];
        }

        protected final int[] getRange(int arg2, int arg3) {
            if(arg2 >= 0 && arg3 >= 0) {
                if(arg2 == arg3) {
                }
                else {
                    int[] v1 = this.segment;
                    v1[0] = arg2;
                    v1[1] = arg3;
                    return v1;
                }
            }

            return null;
        }

        protected final String getText() {
            String v0 = this.text;
            if(v0 != null) {
                return v0;
            }

            Intrinsics.throwUninitializedPropertyAccessException("text");
            return null;
        }

        public void initialize(String arg1) {
            this.setText(arg1);
        }

        protected final void setText(String arg1) {
            this.text = arg1;
        }
    }

    @Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0017\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\u0012\u0010\f\u001A\u0004\u0018\u00010\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016J\u0012\u0010\u0010\u001A\u0004\u0018\u00010\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016J\u0010\u0010\u0011\u001A\u00020\t2\u0006\u0010\u0002\u001A\u00020\u0003H\u0002R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Landroidx/compose/ui/platform/AccessibilityIterators$CharacterTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "locale", "Ljava/util/Locale;", "<init>", "(Ljava/util/Locale;)V", "impl", "Ljava/text/BreakIterator;", "initialize", "", "text", "", "following", "", "current", "", "preceding", "onLocaleChanged", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public class CharacterTextSegmentIterator extends AbstractTextSegmentIterator {
        @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\bR\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\t"}, d2={"Landroidx/compose/ui/platform/AccessibilityIterators$CharacterTextSegmentIterator$Companion;", "", "<init>", "()V", "instance", "Landroidx/compose/ui/platform/AccessibilityIterators$CharacterTextSegmentIterator;", "getInstance", "locale", "Ljava/util/Locale;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class Companion {
            public Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private Companion() {
                super();
            }

            public final CharacterTextSegmentIterator getInstance(Locale arg2) {
                if(CharacterTextSegmentIterator.instance == null) {
                    CharacterTextSegmentIterator.instance = new CharacterTextSegmentIterator(arg2, null);
                }

                CharacterTextSegmentIterator v1 = CharacterTextSegmentIterator.instance;
                Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.CharacterTextSegmentIterator");
                return v1;
            }
        }

        public static final int $stable;
        public static final Companion Companion;
        private BreakIterator impl;
        private static CharacterTextSegmentIterator instance;

        static {
            CharacterTextSegmentIterator.Companion = new Companion(null);
            CharacterTextSegmentIterator.$stable = 8;
        }

        private CharacterTextSegmentIterator(Locale arg1) {
            super();
            this.onLocaleChanged(arg1);
        }

        public CharacterTextSegmentIterator(Locale arg1, DefaultConstructorMarker arg2) {
            this(arg1);
        }

        public static final CharacterTextSegmentIterator access$getInstance$cp() {
            return CharacterTextSegmentIterator.instance;
        }

        public static final void access$setInstance$cp(CharacterTextSegmentIterator arg0) {
            CharacterTextSegmentIterator.instance = arg0;
        }

        public int[] following(int arg6) {
            BreakIterator v3;
            String v2;
            int v0 = this.getText().length();
            int[] v1 = null;
            if(v0 <= 0) {
                return v1;
            }

            if(arg6 >= v0) {
                return v1;
            }

            if(arg6 < 0) {
                arg6 = 0;
            }

            do {
                BreakIterator v0_1 = this.impl;
                v2 = "impl";
                if(v0_1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v2);
                    v0_1 = ((BreakIterator)v1);
                }

                boolean v0_2 = v0_1.isBoundary(arg6);
                v3 = this.impl;
                int v4 = -1;
                if(v0_2) {
                    goto label_24;
                }

                if(v3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v2);
                    v3 = ((BreakIterator)v1);
                }

                arg6 = v3.following(arg6);
            }
            while(arg6 != v4);

            return v1;
        label_24:
            if(v3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v2);
                v3 = ((BreakIterator)v1);
            }

            v0 = v3.following(arg6);
            if(v0 == v4) {
                return v1;
            }

            return this.getRange(arg6, v0);
        }

        public void initialize(String arg1) {
            super.initialize(arg1);
            BreakIterator v0 = this.impl;
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                v0 = null;
            }

            v0.setText(arg1);
        }

        private final void onLocaleChanged(Locale arg1) {
            this.impl = BreakIterator.getCharacterInstance(arg1);
        }

        public int[] preceding(int arg6) {
            BreakIterator v3;
            String v2;
            int v0 = this.getText().length();
            int[] v1 = null;
            if(v0 <= 0) {
                return v1;
            }

            if(arg6 <= 0) {
                return v1;
            }

            if(arg6 > v0) {
                arg6 = v0;
            }

            do {
                BreakIterator v0_1 = this.impl;
                v2 = "impl";
                if(v0_1 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v2);
                    v0_1 = ((BreakIterator)v1);
                }

                boolean v0_2 = v0_1.isBoundary(arg6);
                v3 = this.impl;
                int v4 = -1;
                if(v0_2) {
                    goto label_24;
                }

                if(v3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v2);
                    v3 = ((BreakIterator)v1);
                }

                arg6 = v3.preceding(arg6);
            }
            while(arg6 != v4);

            return v1;
        label_24:
            if(v3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v2);
                v3 = ((BreakIterator)v1);
            }

            v0 = v3.preceding(arg6);
            if(v0 == v4) {
                return v1;
            }

            return this.getRange(v0, arg6);
        }
    }

    @Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\u0004\u001A\u00020\u0005J\u0012\u0010\n\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\f\u001A\u00020\rH\u0016J\u0012\u0010\u000E\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\f\u001A\u00020\rH\u0016J\u0018\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\u0012H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2={"Landroidx/compose/ui/platform/AccessibilityIterators$LineTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "<init>", "()V", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "initialize", "", "text", "", "following", "", "current", "", "preceding", "getLineEdgeIndex", "lineNumber", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class LineTextSegmentIterator extends AbstractTextSegmentIterator {
        @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001A\u00020\u0005R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"Landroidx/compose/ui/platform/AccessibilityIterators$LineTextSegmentIterator$Companion;", "", "<init>", "()V", "lineInstance", "Landroidx/compose/ui/platform/AccessibilityIterators$LineTextSegmentIterator;", "DirectionStart", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "DirectionEnd", "getInstance", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.compose.ui.platform.AccessibilityIterators$LineTextSegmentIterator$Companion {
            public androidx.compose.ui.platform.AccessibilityIterators$LineTextSegmentIterator$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.compose.ui.platform.AccessibilityIterators$LineTextSegmentIterator$Companion() {
                super();
            }

            public final LineTextSegmentIterator getInstance() {
                if(LineTextSegmentIterator.lineInstance == null) {
                    LineTextSegmentIterator.lineInstance = new LineTextSegmentIterator(null);
                }

                LineTextSegmentIterator v1 = LineTextSegmentIterator.lineInstance;
                Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.LineTextSegmentIterator");
                return v1;
            }
        }

        public static final int $stable;
        public static final androidx.compose.ui.platform.AccessibilityIterators$LineTextSegmentIterator$Companion Companion;
        private static final ResolvedTextDirection DirectionEnd;
        private static final ResolvedTextDirection DirectionStart;
        private TextLayoutResult layoutResult;
        private static LineTextSegmentIterator lineInstance;

        static {
            LineTextSegmentIterator.Companion = new androidx.compose.ui.platform.AccessibilityIterators$LineTextSegmentIterator$Companion(null);
            LineTextSegmentIterator.$stable = 8;
            LineTextSegmentIterator.DirectionStart = ResolvedTextDirection.Rtl;
            LineTextSegmentIterator.DirectionEnd = ResolvedTextDirection.Ltr;
        }

        private LineTextSegmentIterator() {
            super();
        }

        public LineTextSegmentIterator(DefaultConstructorMarker arg1) {
            this();
        }

        public static final LineTextSegmentIterator access$getLineInstance$cp() {
            return LineTextSegmentIterator.lineInstance;
        }

        public static final void access$setLineInstance$cp(LineTextSegmentIterator arg0) {
            LineTextSegmentIterator.lineInstance = arg0;
        }

        public int[] following(int arg5) {
            int[] v1 = null;
            if(this.getText().length() <= 0) {
                return v1;
            }

            if(arg5 >= this.getText().length()) {
                return v1;
            }

            TextLayoutResult v0 = this.layoutResult;
            String v2 = "layoutResult";
            if(arg5 < 0) {
                if(v0 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v2);
                    v0 = ((TextLayoutResult)v1);
                }

                arg5 = v0.getLineForOffset(0);
            }
            else {
                if(v0 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v2);
                    v0 = ((TextLayoutResult)v1);
                }

                int v0_1 = v0.getLineForOffset(arg5);
                if(this.getLineEdgeIndex(v0_1, LineTextSegmentIterator.DirectionStart) == arg5) {
                    arg5 = v0_1;
                    goto label_28;
                }

                arg5 = v0_1 + 1;
            }

        label_28:
            v0 = this.layoutResult;
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v2);
                v0 = ((TextLayoutResult)v1);
            }

            if(arg5 >= v0.getLineCount()) {
                return v1;
            }

            return this.getRange(this.getLineEdgeIndex(arg5, LineTextSegmentIterator.DirectionStart), this.getLineEdgeIndex(arg5, LineTextSegmentIterator.DirectionEnd) + 1);
        }

        private final int getLineEdgeIndex(int arg5, ResolvedTextDirection arg6) {
            TextLayoutResult v0 = this.layoutResult;
            String v1 = "layoutResult";
            TextLayoutResult v2 = null;
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
                v0 = v2;
            }

            int v0_1 = v0.getLineStart(arg5);
            TextLayoutResult v3 = this.layoutResult;
            if(v3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
                v3 = v2;
            }

            ResolvedTextDirection v0_2 = v3.getParagraphDirection(v0_1);
            TextLayoutResult v4 = this.layoutResult;
            if(arg6 != v0_2) {
                if(v4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v1);
                }
                else {
                    v2 = v4;
                }

                return v2.getLineStart(arg5);
            }

            if(v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
                v4 = v2;
            }

            return TextLayoutResult.getLineEnd$default(v4, arg5, false, 2, v2) - 1;
        }

        public final void initialize(String arg1, TextLayoutResult arg2) {
            this.setText(arg1);
            this.layoutResult = arg2;
        }

        public int[] preceding(int arg5) {
            int[] v1 = null;
            if(this.getText().length() <= 0) {
                return v1;
            }

            if(arg5 <= 0) {
                return v1;
            }

            int v0 = this.getText().length();
            TextLayoutResult v2 = this.layoutResult;
            String v3 = "layoutResult";
            if(arg5 > v0) {
                if(v2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v3);
                    v2 = ((TextLayoutResult)v1);
                }

                arg5 = v2.getLineForOffset(this.getText().length());
            }
            else {
                if(v2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v3);
                    v2 = ((TextLayoutResult)v1);
                }

                v0 = v2.getLineForOffset(arg5);
                if(this.getLineEdgeIndex(v0, LineTextSegmentIterator.DirectionEnd) + 1 == arg5) {
                    arg5 = v0;
                    goto label_30;
                }

                arg5 = v0 - 1;
            }

        label_30:
            if(arg5 < 0) {
                return v1;
            }

            return this.getRange(this.getLineEdgeIndex(arg5, LineTextSegmentIterator.DirectionStart), this.getLineEdgeIndex(arg5, LineTextSegmentIterator.DirectionEnd) + 1);
        }
    }

    @Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001E\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007J\u0012\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016J\u0012\u0010\u0012\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016J\u0018\u0010\u0013\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u00112\u0006\u0010\u0015\u001A\u00020\u0016H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"Landroidx/compose/ui/platform/AccessibilityIterators$PageTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "<init>", "()V", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "tempRect", "Landroid/graphics/Rect;", "initialize", "", "text", "", "following", "", "current", "", "preceding", "getLineEdgeIndex", "lineNumber", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class PageTextSegmentIterator extends AbstractTextSegmentIterator {
        @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001A\u00020\u0005R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2={"Landroidx/compose/ui/platform/AccessibilityIterators$PageTextSegmentIterator$Companion;", "", "<init>", "()V", "pageInstance", "Landroidx/compose/ui/platform/AccessibilityIterators$PageTextSegmentIterator;", "DirectionStart", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "DirectionEnd", "getInstance", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.compose.ui.platform.AccessibilityIterators$PageTextSegmentIterator$Companion {
            public androidx.compose.ui.platform.AccessibilityIterators$PageTextSegmentIterator$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.compose.ui.platform.AccessibilityIterators$PageTextSegmentIterator$Companion() {
                super();
            }

            public final PageTextSegmentIterator getInstance() {
                if(PageTextSegmentIterator.pageInstance == null) {
                    PageTextSegmentIterator.pageInstance = new PageTextSegmentIterator(null);
                }

                PageTextSegmentIterator v1 = PageTextSegmentIterator.pageInstance;
                Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.PageTextSegmentIterator");
                return v1;
            }
        }

        public static final int $stable;
        public static final androidx.compose.ui.platform.AccessibilityIterators$PageTextSegmentIterator$Companion Companion;
        private static final ResolvedTextDirection DirectionEnd;
        private static final ResolvedTextDirection DirectionStart;
        private TextLayoutResult layoutResult;
        private SemanticsNode node;
        private static PageTextSegmentIterator pageInstance;
        private Rect tempRect;

        static {
            PageTextSegmentIterator.Companion = new androidx.compose.ui.platform.AccessibilityIterators$PageTextSegmentIterator$Companion(null);
            PageTextSegmentIterator.$stable = 8;
            PageTextSegmentIterator.DirectionStart = ResolvedTextDirection.Rtl;
            PageTextSegmentIterator.DirectionEnd = ResolvedTextDirection.Ltr;
        }

        private PageTextSegmentIterator() {
            super();
            this.tempRect = new Rect();
        }

        public PageTextSegmentIterator(DefaultConstructorMarker arg1) {
            this();
        }

        public static final PageTextSegmentIterator access$getPageInstance$cp() {
            return PageTextSegmentIterator.pageInstance;
        }

        public static final void access$setPageInstance$cp(PageTextSegmentIterator arg0) {
            PageTextSegmentIterator.pageInstance = arg0;
        }

        public int[] following(int arg6) {
            TextLayoutResult v1_1;
            int v0_2;
            int[] v1 = null;
            if(this.getText().length() <= 0) {
                return v1;
            }

            if(arg6 >= this.getText().length()) {
                return v1;
            }

            try {
                SemanticsNode v0 = this.node;
                if(v0 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("node");
                    v0 = ((SemanticsNode)v1);
                }

                androidx.compose.ui.geometry.Rect v0_1 = v0.getBoundsInRoot();
                v0_2 = Math.round(v0_1.getBottom() - v0_1.getTop());
            }
            catch(IllegalStateException ) {
                return v1;
            }

            arg6 = RangesKt.coerceAtLeast(0, arg6);
            TextLayoutResult v2 = this.layoutResult;
            String v3 = "layoutResult";
            if(v2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3);
                v2 = ((TextLayoutResult)v1);
            }

            int v2_1 = v2.getLineForOffset(arg6);
            TextLayoutResult v4 = this.layoutResult;
            if(v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3);
                v4 = ((TextLayoutResult)v1);
            }

            float v2_2 = v4.getLineTop(v2_1) + (((float)v0_2));
            TextLayoutResult v0_3 = this.layoutResult;
            if(v0_3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3);
                v0_3 = ((TextLayoutResult)v1);
            }

            v4 = this.layoutResult;
            if(v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3);
                v4 = ((TextLayoutResult)v1);
            }

            v0_2 = Float.compare(v2_2, v0_3.getLineTop(v4.getLineCount() - 1));
            v4 = this.layoutResult;
            if(v0_2 < 0) {
                if(v4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v3);
                }
                else {
                    v1_1 = v4;
                }

                v0_2 = v1_1.getLineForVerticalPosition(v2_2);
            }
            else {
                if(v4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v3);
                }
                else {
                    v1_1 = v4;
                }

                v0_2 = v1_1.getLineCount();
            }

            return this.getRange(arg6, this.getLineEdgeIndex(v0_2 - 1, PageTextSegmentIterator.DirectionEnd) + 1);
        }

        private final int getLineEdgeIndex(int arg5, ResolvedTextDirection arg6) {
            TextLayoutResult v0 = this.layoutResult;
            String v1 = "layoutResult";
            TextLayoutResult v2 = null;
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
                v0 = v2;
            }

            int v0_1 = v0.getLineStart(arg5);
            TextLayoutResult v3 = this.layoutResult;
            if(v3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
                v3 = v2;
            }

            ResolvedTextDirection v0_2 = v3.getParagraphDirection(v0_1);
            TextLayoutResult v4 = this.layoutResult;
            if(arg6 != v0_2) {
                if(v4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v1);
                }
                else {
                    v2 = v4;
                }

                return v2.getLineStart(arg5);
            }

            if(v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v1);
                v4 = v2;
            }

            return TextLayoutResult.getLineEnd$default(v4, arg5, false, 2, v2) - 1;
        }

        public final void initialize(String arg1, TextLayoutResult arg2, SemanticsNode arg3) {
            this.setText(arg1);
            this.layoutResult = arg2;
            this.node = arg3;
        }

        public int[] preceding(int arg6) {
            TextLayoutResult v1_1;
            int v0_2;
            int[] v1 = null;
            if(this.getText().length() <= 0) {
                return v1;
            }

            if(arg6 <= 0) {
                return v1;
            }

            try {
                SemanticsNode v0 = this.node;
                if(v0 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("node");
                    v0 = ((SemanticsNode)v1);
                }

                androidx.compose.ui.geometry.Rect v0_1 = v0.getBoundsInRoot();
                v0_2 = Math.round(v0_1.getBottom() - v0_1.getTop());
            }
            catch(IllegalStateException ) {
                return v1;
            }

            arg6 = RangesKt.coerceAtMost(this.getText().length(), arg6);
            TextLayoutResult v2 = this.layoutResult;
            String v3 = "layoutResult";
            if(v2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3);
                v2 = ((TextLayoutResult)v1);
            }

            int v2_1 = v2.getLineForOffset(arg6);
            TextLayoutResult v4 = this.layoutResult;
            if(v4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v3);
                v4 = ((TextLayoutResult)v1);
            }

            float v4_1 = v4.getLineTop(v2_1) - (((float)v0_2));
            if(v4_1 > 0f) {
                TextLayoutResult v0_3 = this.layoutResult;
                if(v0_3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(v3);
                }
                else {
                    v1_1 = v0_3;
                }

                v0_2 = v1_1.getLineForVerticalPosition(v4_1);
            }
            else {
                v0_2 = 0;
            }

            if(arg6 == this.getText().length() && v0_2 < v2_1) {
                ++v0_2;
            }

            return this.getRange(this.getLineEdgeIndex(v0_2, PageTextSegmentIterator.DirectionStart), arg6);
        }
    }

    @Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0012\u0010\b\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016J\u0010\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0007H\u0002J\u0010\u0010\f\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u0007H\u0002¨\u0006\u000E"}, d2={"Landroidx/compose/ui/platform/AccessibilityIterators$ParagraphTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "<init>", "()V", "following", "", "current", "", "preceding", "isStartBoundary", "", "index", "isEndBoundary", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class ParagraphTextSegmentIterator extends AbstractTextSegmentIterator {
        @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001A\u00020\u0005R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2={"Landroidx/compose/ui/platform/AccessibilityIterators$ParagraphTextSegmentIterator$Companion;", "", "<init>", "()V", "instance", "Landroidx/compose/ui/platform/AccessibilityIterators$ParagraphTextSegmentIterator;", "getInstance", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.compose.ui.platform.AccessibilityIterators$ParagraphTextSegmentIterator$Companion {
            public androidx.compose.ui.platform.AccessibilityIterators$ParagraphTextSegmentIterator$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.compose.ui.platform.AccessibilityIterators$ParagraphTextSegmentIterator$Companion() {
                super();
            }

            public final ParagraphTextSegmentIterator getInstance() {
                if(ParagraphTextSegmentIterator.instance == null) {
                    ParagraphTextSegmentIterator.instance = new ParagraphTextSegmentIterator(null);
                }

                ParagraphTextSegmentIterator v1 = ParagraphTextSegmentIterator.instance;
                Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.ParagraphTextSegmentIterator");
                return v1;
            }
        }

        public static final int $stable;
        public static final androidx.compose.ui.platform.AccessibilityIterators$ParagraphTextSegmentIterator$Companion Companion;
        private static ParagraphTextSegmentIterator instance;

        static {
            ParagraphTextSegmentIterator.Companion = new androidx.compose.ui.platform.AccessibilityIterators$ParagraphTextSegmentIterator$Companion(null);
            ParagraphTextSegmentIterator.$stable = 8;
        }

        private ParagraphTextSegmentIterator() {
            super();
        }

        public ParagraphTextSegmentIterator(DefaultConstructorMarker arg1) {
            this();
        }

        public static final ParagraphTextSegmentIterator access$getInstance$cp() {
            return ParagraphTextSegmentIterator.instance;
        }

        public static final void access$setInstance$cp(ParagraphTextSegmentIterator arg0) {
            ParagraphTextSegmentIterator.instance = arg0;
        }

        public int[] following(int arg5) {
            int v0 = this.getText().length();
            int[] v1 = null;
            if(v0 <= 0) {
                return v1;
            }

            if(arg5 >= v0) {
                return v1;
            }

            if(arg5 < 0) {
                arg5 = 0;
            }

            while(arg5 < v0) {
                if(this.getText().charAt(arg5) != 10) {
                    break;
                }

                if(this.isStartBoundary(arg5)) {
                    break;
                }

                ++arg5;
            }

            if(arg5 >= v0) {
                return v1;
            }

            int v1_1;
            for(v1_1 = arg5 + 1; v1_1 < v0; ++v1_1) {
                if(this.isEndBoundary(v1_1)) {
                    break;
                }
            }

            return this.getRange(arg5, v1_1);
        }

        private final boolean isEndBoundary(int arg3) {
            if(arg3 > 0) {
                int v1 = 10;
                if(this.getText().charAt(arg3 - 1) != v1) {
                    if(arg3 != this.getText().length() && this.getText().charAt(arg3) != v1) {
                        return 0;
                    }

                    return 1;
                }
            }

            return 0;
        }

        private final boolean isStartBoundary(int arg3) {
            int v1 = 10;
            if(this.getText().charAt(arg3) != v1 && (arg3 == 0 || this.getText().charAt(arg3 - 1) == v1)) {
                return 1;
            }

            return 0;
        }

        public int[] preceding(int arg4) {
            int v0 = this.getText().length();
            int[] v1 = null;
            if(v0 <= 0) {
                return v1;
            }

            if(arg4 <= 0) {
                return v1;
            }

            if(arg4 > v0) {
                arg4 = v0;
            }

            while(arg4 > 0) {
                if(this.getText().charAt(arg4 - 1) != 10) {
                    break;
                }

                if(this.isEndBoundary(arg4)) {
                    break;
                }

                --arg4;
            }

            if(arg4 <= 0) {
                return v1;
            }

            for(v0 = arg4 - 1; v0 > 0; --v0) {
                if(this.isStartBoundary(v0)) {
                    break;
                }
            }

            return this.getRange(v0, arg4);
        }
    }

    @Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&J\u0012\u0010\u0006\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2={"Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "", "following", "", "current", "", "preceding", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public interface TextSegmentIterator {
        int[] following(int arg1);

        int[] preceding(int arg1);
    }

    @Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0016J\u0010\u0010\f\u001A\u00020\t2\u0006\u0010\u0002\u001A\u00020\u0003H\u0002J\u0012\u0010\r\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0016J\u0012\u0010\u0011\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0016J\u0010\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0010H\u0002J\u0010\u0010\u0015\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0010H\u0002J\u0010\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0010H\u0002R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2={"Landroidx/compose/ui/platform/AccessibilityIterators$WordTextSegmentIterator;", "Landroidx/compose/ui/platform/AccessibilityIterators$AbstractTextSegmentIterator;", "locale", "Ljava/util/Locale;", "<init>", "(Ljava/util/Locale;)V", "impl", "Ljava/text/BreakIterator;", "initialize", "", "text", "", "onLocaleChanged", "following", "", "current", "", "preceding", "isStartBoundary", "", "index", "isEndBoundary", "isLetterOrDigit", "Companion", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WordTextSegmentIterator extends AbstractTextSegmentIterator {
        @Metadata(d1={"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\bR\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\t"}, d2={"Landroidx/compose/ui/platform/AccessibilityIterators$WordTextSegmentIterator$Companion;", "", "<init>", "()V", "instance", "Landroidx/compose/ui/platform/AccessibilityIterators$WordTextSegmentIterator;", "getInstance", "locale", "Ljava/util/Locale;", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) public final class androidx.compose.ui.platform.AccessibilityIterators$WordTextSegmentIterator$Companion {
            public androidx.compose.ui.platform.AccessibilityIterators$WordTextSegmentIterator$Companion(DefaultConstructorMarker arg1) {
                this();
            }

            private androidx.compose.ui.platform.AccessibilityIterators$WordTextSegmentIterator$Companion() {
                super();
            }

            public final WordTextSegmentIterator getInstance(Locale arg2) {
                if(WordTextSegmentIterator.instance == null) {
                    WordTextSegmentIterator.instance = new WordTextSegmentIterator(arg2, null);
                }

                WordTextSegmentIterator v1 = WordTextSegmentIterator.instance;
                Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.WordTextSegmentIterator");
                return v1;
            }
        }

        public static final int $stable;
        public static final androidx.compose.ui.platform.AccessibilityIterators$WordTextSegmentIterator$Companion Companion;
        private BreakIterator impl;
        private static WordTextSegmentIterator instance;

        static {
            WordTextSegmentIterator.Companion = new androidx.compose.ui.platform.AccessibilityIterators$WordTextSegmentIterator$Companion(null);
            WordTextSegmentIterator.$stable = 8;
        }

        private WordTextSegmentIterator(Locale arg1) {
            super();
            this.onLocaleChanged(arg1);
        }

        public WordTextSegmentIterator(Locale arg1, DefaultConstructorMarker arg2) {
            this(arg1);
        }

        public static final WordTextSegmentIterator access$getInstance$cp() {
            return WordTextSegmentIterator.instance;
        }

        public static final void access$setInstance$cp(WordTextSegmentIterator arg0) {
            WordTextSegmentIterator.instance = arg0;
        }

        public int[] following(int arg5) {
            BreakIterator v0;
            String v2;
            int[] v1 = null;
            if(this.getText().length() <= 0) {
                return v1;
            }

            if(arg5 >= this.getText().length()) {
                return v1;
            }

            if(arg5 < 0) {
                arg5 = 0;
            }

            do {
                v2 = "impl";
                int v3 = -1;
                if(!this.isLetterOrDigit(arg5) && !this.isStartBoundary(arg5)) {
                    v0 = this.impl;
                    if(v0 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v2);
                        v0 = ((BreakIterator)v1);
                    }

                    arg5 = v0.following(arg5);
                    if(arg5 != v3) {
                        continue;
                    }

                    return v1;
                }

                goto label_24;
            }
            while(true);

            return v1;
        label_24:
            v0 = this.impl;
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v2);
                v0 = ((BreakIterator)v1);
            }

            int v0_1 = v0.following(arg5);
            if(v0_1 != v3) {
                if(!this.isEndBoundary(v0_1)) {
                }
                else {
                    return this.getRange(arg5, v0_1);
                }
            }

            return v1;
        }

        public void initialize(String arg1) {
            super.initialize(arg1);
            BreakIterator v0 = this.impl;
            if(v0 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                v0 = null;
            }

            v0.setText(arg1);
        }

        private final boolean isEndBoundary(int arg2) {
            if(arg2 > 0 && (this.isLetterOrDigit(arg2 - 1)) && (arg2 == this.getText().length() || !this.isLetterOrDigit(arg2))) {
                return 1;
            }

            return 0;
        }

        private final boolean isLetterOrDigit(int arg2) {
            if(arg2 >= 0 && arg2 < this.getText().length()) {
                return Character.isLetterOrDigit(this.getText().codePointAt(arg2));
            }

            return 0;
        }

        private final boolean isStartBoundary(int arg2) {
            if((this.isLetterOrDigit(arg2)) && (arg2 == 0 || !this.isLetterOrDigit(arg2 - 1))) {
                return 1;
            }

            return 0;
        }

        private final void onLocaleChanged(Locale arg1) {
            this.impl = BreakIterator.getWordInstance(arg1);
        }

        public int[] preceding(int arg5) {
            BreakIterator v3;
            String v0_1;
            int v0 = this.getText().length();
            int[] v1 = null;
            if(v0 <= 0) {
                return v1;
            }

            if(arg5 <= 0) {
                return v1;
            }

            if(arg5 > v0) {
                arg5 = v0;
            }

            do {
                v0_1 = "impl";
                int v2 = -1;
                if(arg5 > 0 && !this.isLetterOrDigit(arg5 - 1) && !this.isEndBoundary(arg5)) {
                    v3 = this.impl;
                    if(v3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(v0_1);
                        v3 = ((BreakIterator)v1);
                    }

                    arg5 = v3.preceding(arg5);
                    if(arg5 != v2) {
                        continue;
                    }

                    return v1;
                }

                goto label_24;
            }
            while(true);

            return v1;
        label_24:
            v3 = this.impl;
            if(v3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(v0_1);
                v3 = ((BreakIterator)v1);
            }

            v0 = v3.preceding(arg5);
            if(v0 != v2) {
                if(!this.isStartBoundary(v0)) {
                }
                else {
                    return this.getRange(v0, arg5);
                }
            }

            return v1;
        }
    }

    public static final int $stable;

    static {
    }

    public AccessibilityIterators() {
        super();
    }
}


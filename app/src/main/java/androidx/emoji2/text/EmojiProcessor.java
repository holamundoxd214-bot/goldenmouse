package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

final class EmojiProcessor {
    final class CodepointIndexFinder {
        private static final int INVALID_INDEX = -1;

        private CodepointIndexFinder() {
            super();
        }

        static int findIndexBackward(CharSequence arg5, int arg6, int arg7) {
            int v2;
            int v0 = arg5.length();
            int v1 = -1;
            if(arg6 >= 0) {
                if(v0 < arg6) {
                }
                else {
                    if(arg7 < 0) {
                        return v1;
                    }

                    while(true) {
                    label_8:
                        v2 = 0;
                        while(true) {
                        label_9:
                            if(arg7 == 0) {
                                return arg6;
                            }

                            --arg6;
                            if(arg6 < 0) {
                                if(v2 != 0) {
                                    return v1;
                                }

                                return 0;
                            }

                            char v3 = arg5.charAt(arg6);
                            if(v2 == 0) {
                                break;
                            }

                            if(!Character.isHighSurrogate(v3)) {
                                return v1;
                            }

                            --arg7;
                            goto label_8;
                        }
                    }

                    if(!Character.isSurrogate(v3)) {
                        --arg7;
                        goto label_9;
                    }

                    if(Character.isHighSurrogate(v3)) {
                        return v1;
                    }

                    v2 = 1;
                    goto label_9;
                    return arg6;
                }
            }

            return v1;
        }

        static int findIndexForward(CharSequence arg6, int arg7, int arg8) {
            int v3;
            int v0 = arg6.length();
            int v1 = -1;
            if(arg7 >= 0) {
                if(v0 < arg7) {
                }
                else {
                    if(arg8 < 0) {
                        return v1;
                    }

                    while(true) {
                    label_8:
                        v3 = 0;
                        while(true) {
                        label_9:
                            if(arg8 == 0) {
                                return arg7;
                            }

                            if(arg7 >= v0) {
                                if(v3 != 0) {
                                    return v1;
                                }

                                return v0;
                            }

                            char v4 = arg6.charAt(arg7);
                            if(v3 == 0) {
                                break;
                            }

                            if(!Character.isLowSurrogate(v4)) {
                                return v1;
                            }

                            --arg8;
                            ++arg7;
                            goto label_8;
                        }
                    }

                    if(!Character.isSurrogate(v4)) {
                        --arg8;
                        ++arg7;
                        goto label_9;
                    }

                    if(Character.isLowSurrogate(v4)) {
                        return v1;
                    }

                    ++arg7;
                    v3 = 1;
                    goto label_9;
                    return arg7;
                }
            }

            return v1;
        }
    }

    class EmojiProcessAddSpanCallback implements EmojiProcessCallback {
        private final SpanFactory mSpanFactory;
        public UnprecomputeTextOnModificationSpannable spannable;

        EmojiProcessAddSpanCallback(UnprecomputeTextOnModificationSpannable arg1, SpanFactory arg2) {
            super();
            this.spannable = arg1;
            this.mSpanFactory = arg2;
        }

        public UnprecomputeTextOnModificationSpannable getResult() {
            return this.spannable;
        }

        public Object getResult() {
            return this.getResult();
        }

        public boolean handleEmoji(CharSequence arg4, int arg5, int arg6, TypefaceEmojiRasterizer arg7) {
            SpannableString v4;
            if(arg7.isPreferredSystemRender()) {
                return 1;
            }

            if(this.spannable == null) {
                if((arg4 instanceof Spannable)) {
                }
                else {
                    v4 = new SpannableString(arg4);
                }

                this.spannable = new UnprecomputeTextOnModificationSpannable(((Spannable)v4));
            }

            this.spannable.setSpan(this.mSpanFactory.createSpan(arg7), arg5, arg6, 33);
            return 1;
        }
    }

    interface EmojiProcessCallback {
        Object getResult();

        boolean handleEmoji(CharSequence arg1, int arg2, int arg3, TypefaceEmojiRasterizer arg4);
    }

    class EmojiProcessLookupCallback implements EmojiProcessCallback {
        public int end;
        private final int mOffset;
        public int start;

        EmojiProcessLookupCallback(int arg2) {
            super();
            this.start = -1;
            this.end = -1;
            this.mOffset = arg2;
        }

        public EmojiProcessLookupCallback getResult() {
            return this;
        }

        public Object getResult() {
            return this.getResult();
        }

        public boolean handleEmoji(CharSequence arg1, int arg2, int arg3, TypefaceEmojiRasterizer arg4) {
            int v1 = this.mOffset;
            if(arg2 <= v1 && v1 < arg3) {
                this.start = arg2;
                this.end = arg3;
                return 0;
            }

            if(arg3 <= v1) {
                return 1;
            }

            return 0;
        }
    }

    class MarkExclusionCallback implements EmojiProcessCallback {
        private final String mExclusion;

        MarkExclusionCallback(String arg1) {
            super();
            this.mExclusion = arg1;
        }

        public MarkExclusionCallback getResult() {
            return this;
        }

        public Object getResult() {
            return this.getResult();
        }

        public boolean handleEmoji(CharSequence arg1, int arg2, int arg3, TypefaceEmojiRasterizer arg4) {
            if(TextUtils.equals(arg1.subSequence(arg2, arg3), this.mExclusion)) {
                arg4.setExclusion(true);
                return 0;
            }

            return 1;
        }
    }

    final class ProcessorSm {
        private static final int STATE_DEFAULT = 1;
        private static final int STATE_WALKING = 2;
        private int mCurrentDepth;
        private Node mCurrentNode;
        private final int[] mEmojiAsDefaultStyleExceptions;
        private Node mFlushNode;
        private int mLastCodepoint;
        private final Node mRootNode;
        private int mState;
        private final boolean mUseEmojiAsDefaultStyle;

        ProcessorSm(Node arg2, boolean arg3, int[] arg4) {
            super();
            this.mState = 1;
            this.mRootNode = arg2;
            this.mCurrentNode = arg2;
            this.mUseEmojiAsDefaultStyle = arg3;
            this.mEmojiAsDefaultStyleExceptions = arg4;
        }

        int check(int arg5) {
            Node v0 = this.mCurrentNode.get(arg5);
            int v3 = 2;
            if(this.mState != v3) {
                if(v0 == null) {
                    v3 = this.reset();
                }
                else {
                    this.mState = v3;
                    this.mCurrentNode = v0;
                    this.mCurrentDepth = 1;
                }
            }
            else if(v0 != null) {
                this.mCurrentNode = v0;
                ++this.mCurrentDepth;
            }
            else if(ProcessorSm.isTextStyle(arg5)) {
                v3 = this.reset();
            }
            else if(ProcessorSm.isEmojiStyle(arg5)) {
            }
            else if(this.mCurrentNode.getData() != null) {
                v3 = 3;
                if(this.mCurrentDepth != 1) {
                    this.mFlushNode = this.mCurrentNode;
                    this.reset();
                }
                else if(this.shouldUseEmojiPresentationStyleForSingleCodepoint()) {
                    this.mFlushNode = this.mCurrentNode;
                    this.reset();
                }
                else {
                    v3 = this.reset();
                }
            }
            else {
                v3 = this.reset();
            }

            this.mLastCodepoint = arg5;
            return v3;
        }

        TypefaceEmojiRasterizer getCurrentMetadata() {
            return this.mCurrentNode.getData();
        }

        TypefaceEmojiRasterizer getFlushMetadata() {
            return this.mFlushNode.getData();
        }

        private static boolean isEmojiStyle(int arg1) {
            if(arg1 == 0xFE0F) {
                return 1;
            }

            return 0;
        }

        boolean isInFlushableState() {
            if(this.mState == 2 && this.mCurrentNode.getData() != null && (this.mCurrentDepth > 1 || (this.shouldUseEmojiPresentationStyleForSingleCodepoint()))) {
                return 1;
            }

            return 0;
        }

        private static boolean isTextStyle(int arg1) {
            if(arg1 == 0xFE0E) {
                return 1;
            }

            return 0;
        }

        private int reset() {
            this.mState = 1;
            this.mCurrentNode = this.mRootNode;
            this.mCurrentDepth = 0;
            return 1;
        }

        private boolean shouldUseEmojiPresentationStyleForSingleCodepoint() {
            if(this.mCurrentNode.getData().isDefaultEmoji()) {
                return 1;
            }

            if(ProcessorSm.isEmojiStyle(this.mLastCodepoint)) {
                return 1;
            }

            if(this.mUseEmojiAsDefaultStyle) {
                if(this.mEmojiAsDefaultStyleExceptions == null) {
                    return 1;
                }
                else if(Arrays.binarySearch(this.mEmojiAsDefaultStyleExceptions, this.mCurrentNode.getData().getCodepointAt(0)) < 0) {
                    return 1;
                }
            }

            return 0;
        }
    }

    private static final int ACTION_ADVANCE_BOTH = 1;
    private static final int ACTION_ADVANCE_END = 2;
    private static final int ACTION_FLUSH = 3;
    private static final int MAX_LOOK_AROUND_CHARACTER = 16;
    private final int[] mEmojiAsDefaultStyleExceptions;
    private GlyphChecker mGlyphChecker;
    private final MetadataRepo mMetadataRepo;
    private final SpanFactory mSpanFactory;
    private final boolean mUseEmojiAsDefaultStyle;

    EmojiProcessor(MetadataRepo arg1, SpanFactory arg2, GlyphChecker arg3, boolean arg4, int[] arg5, Set arg6) {
        super();
        this.mSpanFactory = arg2;
        this.mMetadataRepo = arg1;
        this.mGlyphChecker = arg3;
        this.mUseEmojiAsDefaultStyle = arg4;
        this.mEmojiAsDefaultStyleExceptions = arg5;
        this.initExclusions(arg6);
    }

    private static boolean delete(Editable arg6, KeyEvent arg7, boolean arg8) {
        if(EmojiProcessor.hasModifiers(arg7)) {
            return 0;
        }

        int v7 = Selection.getSelectionStart(((CharSequence)arg6));
        int v1 = Selection.getSelectionEnd(((CharSequence)arg6));
        if(EmojiProcessor.hasInvalidSelection(v7, v1)) {
            return 0;
        }

        Object[] v1_1 = arg6.getSpans(v7, v1, EmojiSpan.class);
        if(v1_1 != null && v1_1.length > 0) {
            int v2 = v1_1.length;
            int v3;
            for(v3 = 0; v3 < v2; ++v3) {
                Object v4 = v1_1[v3];
                int v5 = arg6.getSpanStart(v4);
                int v4_1 = arg6.getSpanEnd(v4);
                if(!arg8 || v5 != v7) {
                    if(!arg8 && v4_1 == v7) {
                        goto label_26;
                    }

                    if(v7 > v5 && v7 < v4_1) {
                        goto label_26;
                    }
                }
                else {
                label_26:
                    arg6.delete(v5, v4_1);
                    return 1;
                }
            }
        }

        return 0;
    }

    int getEmojiEnd(CharSequence arg10, int arg11) {
        if(arg11 >= 0) {
            if(arg11 >= arg10.length()) {
            }
            else {
                if((arg10 instanceof Spanned)) {
                    CharSequence v0 = arg10;
                    Object[] v2 = ((Spanned)v0).getSpans(arg11, arg11 + 1, EmojiSpan.class);
                    if(v2.length > 0) {
                        return ((Spanned)v0).getSpanEnd(v2[0]);
                    }
                }

                return this.process(arg10, Math.max(0, arg11 - 16), Math.min(arg10.length(), arg11 + 16), 0x7FFFFFFF, true, new EmojiProcessLookupCallback(arg11)).end;
            }
        }

        return -1;
    }

    int getEmojiMatch(CharSequence arg11, int arg12) {
        int v5;
        ProcessorSm v0 = new ProcessorSm(this.mMetadataRepo.getRootNode(), this.mUseEmojiAsDefaultStyle, this.mEmojiAsDefaultStyleExceptions);
        int v10 = arg11.length();
        int v2 = 0;
        int v3 = 0;
        int v4;
        for(v4 = 0; true; ++v4) {
        label_11:
            v5 = 2;
            if(v2 >= v10) {
                break;
            }

            int v7 = Character.codePointAt(arg11, v2);
            int v8 = v0.check(v7);
            TypefaceEmojiRasterizer v9 = v0.getCurrentMetadata();
            if(v8 == 1) {
                v2 += Character.charCount(v7);
                v4 = 0;
            }
            else if(v8 == v5) {
                v2 += Character.charCount(v7);
            }
            else if(v8 != 3) {
            }
            else {
                v9 = v0.getFlushMetadata();
                if(v9.getCompatAdded() <= arg12) {
                    ++v3;
                }
            }

            if(v9 == null) {
                goto label_11;
            }

            if(v9.getCompatAdded() > arg12) {
                goto label_11;
            }
        }

        if(v3 != 0) {
            return v5;
        }

        if((v0.isInFlushableState()) && v0.getCurrentMetadata().getCompatAdded() <= arg12) {
            return 1;
        }

        if(v4 == 0) {
            return 0;
        }

        return v5;
    }

    int getEmojiMatch(CharSequence arg2) {
        return this.getEmojiMatch(arg2, this.mMetadataRepo.getMetadataVersion());
    }

    int getEmojiStart(CharSequence arg10, int arg11) {
        if(arg11 >= 0) {
            if(arg11 >= arg10.length()) {
            }
            else {
                if((arg10 instanceof Spanned)) {
                    CharSequence v0 = arg10;
                    Object[] v2 = ((Spanned)v0).getSpans(arg11, arg11 + 1, EmojiSpan.class);
                    if(v2.length > 0) {
                        return ((Spanned)v0).getSpanStart(v2[0]);
                    }
                }

                return this.process(arg10, Math.max(0, arg11 - 16), Math.min(arg10.length(), arg11 + 16), 0x7FFFFFFF, true, new EmojiProcessLookupCallback(arg11)).start;
            }
        }

        return -1;
    }

    static boolean handleDeleteSurroundingText(InputConnection arg5, Editable arg6, int arg7, int arg8, boolean arg9) {
        if(arg6 != null) {
            if(arg5 == null) {
            }
            else if(arg7 >= 0) {
                if(arg8 < 0) {
                }
                else {
                    int v1 = Selection.getSelectionStart(((CharSequence)arg6));
                    int v2 = Selection.getSelectionEnd(((CharSequence)arg6));
                    if(EmojiProcessor.hasInvalidSelection(v1, v2)) {
                        return 0;
                    }
                    else {
                        if(arg9) {
                            arg7 = CodepointIndexFinder.findIndexBackward(((CharSequence)arg6), v1, Math.max(arg7, 0));
                            arg8 = CodepointIndexFinder.findIndexForward(((CharSequence)arg6), v2, Math.max(arg8, 0));
                            int v9 = -1;
                            if(arg7 != v9 && arg8 != v9) {
                                goto label_26;
                            }

                            return 0;
                        }
                        else {
                            arg7 = Math.max(v1 - arg7, 0);
                            arg8 = Math.min(v2 + arg8, arg6.length());
                        }

                    label_26:
                        Object[] v9_1 = arg6.getSpans(arg7, arg8, EmojiSpan.class);
                        if(v9_1 == null) {
                            return 0;
                        }

                        if(v9_1.length <= 0) {
                            return 0;
                        }

                        v1 = v9_1.length;
                        for(v2 = 0; v2 < v1; ++v2) {
                            Object v3 = v9_1[v2];
                            int v4 = arg6.getSpanStart(v3);
                            int v3_1 = arg6.getSpanEnd(v3);
                            arg7 = Math.min(v4, arg7);
                            arg8 = Math.max(v3_1, arg8);
                        }

                        arg7 = Math.max(arg7, 0);
                        arg8 = Math.min(arg8, arg6.length());
                        arg5.beginBatchEdit();
                        arg6.delete(arg7, arg8);
                        arg5.endBatchEdit();
                        return 1;
                    }
                }
            }
        }

        return 0;
    }

    static boolean handleOnKeyDown(Editable arg3, int arg4, KeyEvent arg5) {
        boolean v4;
        if(arg4 == 67) {
            v4 = EmojiProcessor.delete(arg3, arg5, false);
        }
        else if(arg4 != 0x70) {
            v4 = false;
        }
        else {
            v4 = EmojiProcessor.delete(arg3, arg5, true);
        }

        if(v4) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(((Spannable)arg3));
            return 1;
        }

        return 0;
    }

    private boolean hasGlyph(CharSequence arg2, int arg3, int arg4, TypefaceEmojiRasterizer arg5) {
        if(arg5.getHasGlyph() == 0) {
            arg5.setHasGlyph(this.mGlyphChecker.hasGlyph(arg2, arg3, arg4, arg5.getSdkAdded()));
        }

        if(arg5.getHasGlyph() == 2) {
            return 1;
        }

        return 0;
    }

    private static boolean hasInvalidSelection(int arg1, int arg2) {
        int v0 = -1;
        if(arg1 != v0 && arg2 != v0) {
            if(arg1 != arg2) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private static boolean hasModifiers(KeyEvent arg0) {
        return KeyEvent.metaStateHasNoModifiers(arg0.getMetaState()) ^ 1;
    }

    private void initExclusions(Set arg9) {
        if(arg9.isEmpty()) {
        }
        else {
            Iterator v9 = arg9.iterator();
            while(v9.hasNext()) {
                Object v0 = v9.next();
                String v2 = new String(((int[])v0), 0, v0.length);
                this.process(((CharSequence)v2), 0, v2.length(), 1, true, new MarkExclusionCallback(v2));
            }
        }
    }

    CharSequence process(CharSequence arg10, int arg11, int arg12, int arg13, boolean arg14) {
        Spannable v9_2;
        boolean v7_1;
        EmojiProcessor v2;
        EmojiProcessAddSpanCallback v8_1;
        CharSequence v3_1;
        Throwable v9;
        int v4;
        UnprecomputeTextOnModificationSpannable v0_1;
        boolean v1 = arg10 instanceof SpannableBuilder;
        if(v1) {
            arg10.beginBatchEdit();
        }

        if(!v1) {
            try {
                if((arg10 instanceof Spannable)) {
                    goto label_25;
                }
                else if(((arg10 instanceof Spanned)) && arg10.nextSpanTransition(arg11 - 1, arg12 + 1, EmojiSpan.class) <= arg12) {
                    v0_1 = new UnprecomputeTextOnModificationSpannable(arg10);
                    goto label_28;
                }
            }
            catch(Throwable v0) {
                goto label_22;
            }

            v0_1 = null;
        }
        else {
            try {
            label_25:
                v0_1 = new UnprecomputeTextOnModificationSpannable(arg10);
            }
            catch(Throwable v0) {
                goto label_86;
            }
        }

    label_28:
        if(v0_1 != null) {
            try {
                Object[] v3 = v0_1.getSpans(arg11, arg12, EmojiSpan.class);
                if(v3 != null && v3.length > 0) {
                    v4 = v3.length;
                    int v5;
                    for(v5 = 0; v5 < v4; ++v5) {
                        Object v6 = v3[v5];
                        int v7 = v0_1.getSpanStart(v6);
                        int v8 = v0_1.getSpanEnd(v6);
                        if(v7 != arg12) {
                            v0_1.removeSpan(v6);
                        }

                        arg11 = Math.min(v7, arg11);
                        arg12 = Math.max(v8, arg12);
                    }
                }
            }
            catch(Throwable v0) {
                goto label_22;
            }
        }

        v4 = arg11;
        v5 = arg12;
        if(v4 != v5) {
            try {
                if(v4 >= arg10.length()) {
                }
                else {
                    goto label_53;
                }
            }
            catch(Throwable v0) {
                goto label_86;
            }

            goto label_81;
        label_53:
            if(arg13 != 0x7FFFFFFF && v0_1 != null) {
                try {
                    arg13 -= v0_1.getSpans(0, v0_1.length(), EmojiSpan.class).length;
                }
                catch(Throwable v0) {
                label_22:
                    v9 = v0;
                    v3_1 = arg10;
                    goto label_88;
                }
            }

            int v6_1 = arg13;
            try {
                v8_1 = new EmojiProcessAddSpanCallback(v0_1, this.mSpanFactory);
                v2 = this;
                v3_1 = arg10;
                v7_1 = arg14;
            }
            catch(Throwable v0) {
            label_86:
                v3_1 = arg10;
                goto label_87;
            }

            try {
                Object v9_1 = v2.process(v3_1, v4, v5, v6_1, v7_1, ((EmojiProcessCallback)v8_1));
                if(v9_1 == null) {
                    goto label_75;
                }

                v9_2 = ((UnprecomputeTextOnModificationSpannable)v9_1).getUnwrappedSpannable();
                if(!v1) {
                    goto label_74;
                }

                goto label_72;
            }
            catch(Throwable v0) {
            }

        label_87:
            v9 = v0;
        label_88:
            if(v1) {
                v3_1.endBatchEdit();
            }

            throw v9;
        label_72:
            v3_1.endBatchEdit();
        label_74:
            return ((CharSequence)v9_2);
        label_75:
            if(!v1) {
                return v3_1;
            }

            goto label_76;
        }
        else {
        label_81:
            v3_1 = arg10;
            if(!v1) {
                return v3_1;
            }

        label_76:
            v3_1.endBatchEdit();
            return v3_1;
        }

        return v3_1;
    }

    private Object process(CharSequence arg9, int arg10, int arg11, int arg12, boolean arg13, EmojiProcessCallback arg14) {
        int v1;
        ProcessorSm v0 = new ProcessorSm(this.mMetadataRepo.getRootNode(), this.mUseEmojiAsDefaultStyle, this.mEmojiAsDefaultStyleExceptions);
        int v4 = 0;
        boolean v5 = true;
        int v2 = Character.codePointAt(arg9, arg10);
        while(true) {
        label_12:
            v1 = arg10;
            while(true) {
            label_13:
                if(arg10 < arg11 && v4 < arg12 && (v5)) {
                    int v6 = v0.check(v2);
                    if(v6 == 1) {
                        goto label_37;
                    }
                    else if(v6 == 2) {
                        break;
                    }
                    else if(v6 != 3) {
                        continue;
                    }
                    else {
                        if(!arg13 && (this.hasGlyph(arg9, v1, arg10, v0.getFlushMetadata()))) {
                            goto label_12;
                        }

                        ++v4;
                        v5 = arg14.handleEmoji(arg9, v1, arg10, v0.getFlushMetadata());
                        goto label_12;
                    }
                }

                goto label_45;
            }
        }

        arg10 += Character.charCount(v2);
        if(arg10 >= arg11) {
            goto label_13;
        }

        v2 = Character.codePointAt(arg9, arg10);
        goto label_13;
    label_37:
        v1 += Character.charCount(Character.codePointAt(arg9, v1));
        if(v1 < arg11) {
            v2 = Character.codePointAt(arg9, v1);
        }

        arg10 = v1;
        goto label_13;
    label_45:
        if((v0.isInFlushableState()) && v4 < arg12 && (v5) && ((arg13) || !this.hasGlyph(arg9, v1, arg10, v0.getCurrentMetadata()))) {
            arg14.handleEmoji(arg9, v1, arg10, v0.getCurrentMetadata());
        }

        return arg14.getResult();
    }
}


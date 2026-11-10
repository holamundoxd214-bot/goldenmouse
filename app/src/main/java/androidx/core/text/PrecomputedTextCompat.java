package androidx.core.text;

import android.os.Build$VERSION;
import android.os.Trace;
import android.text.PrecomputedText$Params$Builder;
import android.text.PrecomputedText$Params;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout$Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class PrecomputedTextCompat implements Spannable {
    class Api28Impl {
        private Api28Impl() {
            super();
        }

        static Spannable castToSpannable(PrecomputedText arg0) {
            return arg0;
        }
    }

    public final class Params {
        public class Builder {
            private int mBreakStrategy;
            private int mHyphenationFrequency;
            private final TextPaint mPaint;
            private TextDirectionHeuristic mTextDir;

            public Builder(TextPaint arg1) {
                super();
                this.mPaint = arg1;
                this.mBreakStrategy = 1;
                this.mHyphenationFrequency = 1;
                this.mTextDir = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }

            public Params build() {
                return new Params(this.mPaint, this.mTextDir, this.mBreakStrategy, this.mHyphenationFrequency);
            }

            public Builder setBreakStrategy(int arg1) {
                this.mBreakStrategy = arg1;
                return this;
            }

            public Builder setHyphenationFrequency(int arg1) {
                this.mHyphenationFrequency = arg1;
                return this;
            }

            public Builder setTextDirection(TextDirectionHeuristic arg1) {
                this.mTextDir = arg1;
                return this;
            }
        }

        private final int mBreakStrategy;
        private final int mHyphenationFrequency;
        private final TextPaint mPaint;
        private final TextDirectionHeuristic mTextDir;
        final PrecomputedText$Params mWrapped;

        public Params(PrecomputedText$Params arg3) {
            super();
            this.mPaint = arg3.getTextPaint();
            this.mTextDir = arg3.getTextDirection();
            this.mBreakStrategy = arg3.getBreakStrategy();
            this.mHyphenationFrequency = arg3.getHyphenationFrequency();
            if(Build$VERSION.SDK_INT >= 29) {
            }
            else {
                arg3 = null;
            }

            this.mWrapped = arg3;
        }

        Params(TextPaint arg3, TextDirectionHeuristic arg4, int arg5, int arg6) {
            super();
            this.mWrapped = Build$VERSION.SDK_INT >= 29 ? new PrecomputedText$Params$Builder(arg3).setBreakStrategy(arg5).setHyphenationFrequency(arg6).setTextDirection(arg4).build() : null;
            this.mPaint = arg3;
            this.mTextDir = arg4;
            this.mBreakStrategy = arg5;
            this.mHyphenationFrequency = arg6;
        }

        public boolean equals(Object arg4) {
            if((((Params)arg4)) == this) {
                return 1;
            }

            if(!(arg4 instanceof Params)) {
                return 0;
            }

            if(!this.equalsWithoutTextDirection(((Params)arg4))) {
                return 0;
            }

            if(this.mTextDir == ((Params)arg4).getTextDirection()) {
                return 1;
            }

            return 0;
        }

        public boolean equalsWithoutTextDirection(Params arg4) {
            if(this.mBreakStrategy != arg4.getBreakStrategy()) {
                return 0;
            }

            if(this.mHyphenationFrequency != arg4.getHyphenationFrequency()) {
                return 0;
            }

            if(this.mPaint.getTextSize() != arg4.getTextPaint().getTextSize()) {
                return 0;
            }

            if(this.mPaint.getTextScaleX() != arg4.getTextPaint().getTextScaleX()) {
                return 0;
            }

            if(this.mPaint.getTextSkewX() != arg4.getTextPaint().getTextSkewX()) {
                return 0;
            }

            if(this.mPaint.getLetterSpacing() != arg4.getTextPaint().getLetterSpacing()) {
                return 0;
            }

            if(!TextUtils.equals(this.mPaint.getFontFeatureSettings(), arg4.getTextPaint().getFontFeatureSettings())) {
                return 0;
            }

            if(this.mPaint.getFlags() != arg4.getTextPaint().getFlags()) {
                return 0;
            }

            if(!this.mPaint.getTextLocales().equals(arg4.getTextPaint().getTextLocales())) {
                return 0;
            }

            if(this.mPaint.getTypeface() == null) {
                if(arg4.getTextPaint().getTypeface() != null) {
                    return 0;
                }
            }
            else if(!this.mPaint.getTypeface().equals(arg4.getTextPaint().getTypeface())) {
                return 0;
            }

            return 1;
        }

        public int getBreakStrategy() {
            return this.mBreakStrategy;
        }

        public int getHyphenationFrequency() {
            return this.mHyphenationFrequency;
        }

        public TextDirectionHeuristic getTextDirection() {
            return this.mTextDir;
        }

        public TextPaint getTextPaint() {
            return this.mPaint;
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocales(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency)});
        }

        public String toString() {
            StringBuilder v0 = new StringBuilder("{");
            v0.append("textSize=" + this.mPaint.getTextSize());
            v0.append(", textScaleX=" + this.mPaint.getTextScaleX());
            v0.append(", textSkewX=" + this.mPaint.getTextSkewX());
            v0.append(", letterSpacing=" + this.mPaint.getLetterSpacing());
            v0.append(", elegantTextHeight=" + this.mPaint.isElegantTextHeight());
            v0.append(", textLocale=" + this.mPaint.getTextLocales());
            v0.append(", typeface=" + this.mPaint.getTypeface());
            v0.append(", variationSettings=" + this.mPaint.getFontVariationSettings());
            v0.append(", textDir=" + this.mTextDir);
            v0.append(", breakStrategy=" + this.mBreakStrategy);
            v0.append(", hyphenationFrequency=" + this.mHyphenationFrequency);
            v0.append("}");
            return v0.toString();
        }
    }

    class PrecomputedTextFutureTask extends FutureTask {
        class PrecomputedTextCallback implements Callable {
            private Params mParams;
            private CharSequence mText;

            PrecomputedTextCallback(Params arg1, CharSequence arg2) {
                super();
                this.mParams = arg1;
                this.mText = arg2;
            }

            public PrecomputedTextCompat call() throws Exception {
                return PrecomputedTextCompat.create(this.mText, this.mParams);
            }

            public Object call() throws Exception {
                return this.call();
            }
        }

        PrecomputedTextFutureTask(Params arg2, CharSequence arg3) {
            super(new PrecomputedTextCallback(arg2, arg3));
        }
    }

    private static final char LINE_FEED = '\n';
    private final int[] mParagraphEnds;
    private final Params mParams;
    private final Spannable mText;
    private final PrecomputedText mWrapped;
    private static Executor sExecutor;
    private static final Object sLock;

    static {
        PrecomputedTextCompat.sLock = new Object();
    }

    private PrecomputedTextCompat(PrecomputedText arg3, Params arg4) {
        super();
        this.mText = Api28Impl.castToSpannable(arg3);
        this.mParams = arg4;
        int[] v4 = null;
        this.mParagraphEnds = v4;
        if(Build$VERSION.SDK_INT >= 29) {
        }
        else {
            arg3 = ((PrecomputedText)v4);
        }

        this.mWrapped = arg3;
    }

    private PrecomputedTextCompat(CharSequence arg2, Params arg3, int[] arg4) {
        super();
        this.mText = new SpannableString(arg2);
        this.mParams = arg3;
        this.mParagraphEnds = arg4;
        this.mWrapped = null;
    }

    public char charAt(int arg1) {
        return this.mText.charAt(arg1);
    }

    public static PrecomputedTextCompat create(CharSequence arg5, Params arg6) {
        PrecomputedTextCompat v0;
        Preconditions.checkNotNull(arg5);
        Preconditions.checkNotNull(arg6);
        try {
            Trace.beginSection("PrecomputedText");
            if(Build$VERSION.SDK_INT >= 29 && arg6.mWrapped != null) {
                v0 = new PrecomputedTextCompat(PrecomputedText.create(arg5, arg6.mWrapped), arg6);
                goto label_13;
            }

            goto label_15;
        }
        catch(Throwable v5) {
            goto label_56;
        }

    label_13:
        Trace.endSection();
        return v0;
        try {
        label_15:
            ArrayList v0_1 = new ArrayList();
            int v1 = arg5.length();
            int v3 = 0;
            while(v3 < v1) {
                v3 = TextUtils.indexOf(arg5, '\n', v3, v1);
                if(v3 < 0) {
                    v3 = v1;
                }
                else {
                    ++v3;
                }

                v0_1.add(Integer.valueOf(v3));
            }

            int[] v1_1 = new int[v0_1.size()];
            for(v3 = 0; v3 < v0_1.size(); ++v3) {
                v1_1[v3] = v0_1.get(v3).intValue();
            }

            StaticLayout$Builder.obtain(arg5, 0, arg5.length(), arg6.getTextPaint(), 0x7FFFFFFF).setBreakStrategy(arg6.getBreakStrategy()).setHyphenationFrequency(arg6.getHyphenationFrequency()).setTextDirection(arg6.getTextDirection()).build();
            v0 = new PrecomputedTextCompat(arg5, arg6, v1_1);
        }
        catch(Throwable v5) {
            goto label_56;
        }

        Trace.endSection();
        return v0;
    label_56:
        Trace.endSection();
        throw v5;
    }

    public int getParagraphCount() {
        if(Build$VERSION.SDK_INT >= 29) {
            return this.mWrapped.getParagraphCount();
        }

        return this.mParagraphEnds.length;
    }

    public int getParagraphEnd(int arg4) {
        Preconditions.checkArgumentInRange(arg4, 0, this.getParagraphCount(), "paraIndex");
        if(Build$VERSION.SDK_INT >= 29) {
            return this.mWrapped.getParagraphEnd(arg4);
        }

        return this.mParagraphEnds[arg4];
    }

    public int getParagraphStart(int arg4) {
        Preconditions.checkArgumentInRange(arg4, 0, this.getParagraphCount(), "paraIndex");
        if(Build$VERSION.SDK_INT >= 29) {
            return this.mWrapped.getParagraphStart(arg4);
        }

        if(arg4 == 0) {
            return 0;
        }

        return this.mParagraphEnds[arg4 - 1];
    }

    public Params getParams() {
        return this.mParams;
    }

    public PrecomputedText getPrecomputedText() {
        Spannable v1 = this.mText;
        if((v1 instanceof PrecomputedText)) {
            return ((PrecomputedText)v1);
        }

        return null;
    }

    public int getSpanEnd(Object arg1) {
        return this.mText.getSpanEnd(arg1);
    }

    public int getSpanFlags(Object arg1) {
        return this.mText.getSpanFlags(arg1);
    }

    public int getSpanStart(Object arg1) {
        return this.mText.getSpanStart(arg1);
    }

    public Object[] getSpans(int arg3, int arg4, Class arg5) {
        if(Build$VERSION.SDK_INT >= 29) {
            return this.mWrapped.getSpans(arg3, arg4, arg5);
        }

        return this.mText.getSpans(arg3, arg4, arg5);
    }

    public static Future getTextFuture(CharSequence arg1, Params arg2, Executor arg3) {
        PrecomputedTextFutureTask v0 = new PrecomputedTextFutureTask(arg2, arg1);
        if(arg3 == null) {
            Object v1 = PrecomputedTextCompat.sLock;
            __monitor_enter(v1);
            try {
                if(PrecomputedTextCompat.sExecutor == null) {
                    PrecomputedTextCompat.sExecutor = Executors.newFixedThreadPool(1);
                }

                arg3 = PrecomputedTextCompat.sExecutor;
                __monitor_exit(v1);
                goto label_16;
            label_14:
                __monitor_exit(v1);
            }
            catch(Throwable v2) {
                goto label_14;
            }

            throw v2;
        }

    label_16:
        arg3.execute(((Runnable)v0));
        return ((Future)v0);
    }

    public int length() {
        return this.mText.length();
    }

    public int nextSpanTransition(int arg1, int arg2, Class arg3) {
        return this.mText.nextSpanTransition(arg1, arg2, arg3);
    }

    public void removeSpan(Object arg3) {
        if(!(arg3 instanceof MetricAffectingSpan)) {
            if(Build$VERSION.SDK_INT >= 29) {
                this.mWrapped.removeSpan(arg3);
                return;
            }

            this.mText.removeSpan(arg3);
            return;
        }

        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    public void setSpan(Object arg3, int arg4, int arg5, int arg6) {
        if(!(arg3 instanceof MetricAffectingSpan)) {
            if(Build$VERSION.SDK_INT >= 29) {
                this.mWrapped.setSpan(arg3, arg4, arg5, arg6);
                return;
            }

            this.mText.setSpan(arg3, arg4, arg5, arg6);
            return;
        }

        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    public CharSequence subSequence(int arg1, int arg2) {
        return this.mText.subSequence(arg1, arg2);
    }

    public String toString() {
        return this.mText.toString();
    }
}


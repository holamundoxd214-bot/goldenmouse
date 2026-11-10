package androidx.emoji2.text;

import android.os.Build$VERSION;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import androidx.core.text.PrecomputedTextCompat;
import java.util.stream.IntStream;

class UnprecomputeTextOnModificationSpannable implements Spannable {
    class CharSequenceHelper_API24 {
        private CharSequenceHelper_API24() {
            super();
        }

        static IntStream chars(CharSequence arg0) {
            return arg0.chars();
        }

        static IntStream codePoints(CharSequence arg0) {
            return arg0.codePoints();
        }
    }

    class PrecomputedTextDetector {
        PrecomputedTextDetector() {
            super();
        }

        boolean isPrecomputedText(CharSequence arg1) {
            return arg1 instanceof PrecomputedTextCompat;
        }
    }

    class PrecomputedTextDetector_28 extends PrecomputedTextDetector {
        PrecomputedTextDetector_28() {
            super();
        }

        boolean isPrecomputedText(CharSequence arg1) {
            if(!(arg1 instanceof PrecomputedText)) {
                if((arg1 instanceof PrecomputedTextCompat)) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }
    }

    private Spannable mDelegate;
    private boolean mSafeToWrite;

    UnprecomputeTextOnModificationSpannable(CharSequence arg2) {
        super();
        this.mSafeToWrite = false;
        this.mDelegate = new SpannableString(arg2);
    }

    UnprecomputeTextOnModificationSpannable(Spannable arg2) {
        super();
        this.mSafeToWrite = false;
        this.mDelegate = arg2;
    }

    UnprecomputeTextOnModificationSpannable(Spanned arg2) {
        super();
        this.mSafeToWrite = false;
        this.mDelegate = new SpannableString(((CharSequence)arg2));
    }

    public char charAt(int arg1) {
        return this.mDelegate.charAt(arg1);
    }

    public IntStream chars() {
        return CharSequenceHelper_API24.chars(this.mDelegate);
    }

    public IntStream codePoints() {
        return CharSequenceHelper_API24.codePoints(this.mDelegate);
    }

    private void ensureSafeWrites() {
        Spannable v0 = this.mDelegate;
        if(!this.mSafeToWrite && (UnprecomputeTextOnModificationSpannable.precomputedTextDetector().isPrecomputedText(((CharSequence)v0)))) {
            this.mDelegate = new SpannableString(((CharSequence)v0));
        }

        this.mSafeToWrite = true;
    }

    public int getSpanEnd(Object arg1) {
        return this.mDelegate.getSpanEnd(arg1);
    }

    public int getSpanFlags(Object arg1) {
        return this.mDelegate.getSpanFlags(arg1);
    }

    public int getSpanStart(Object arg1) {
        return this.mDelegate.getSpanStart(arg1);
    }

    public Object[] getSpans(int arg1, int arg2, Class arg3) {
        return this.mDelegate.getSpans(arg1, arg2, arg3);
    }

    Spannable getUnwrappedSpannable() {
        return this.mDelegate;
    }

    public int length() {
        return this.mDelegate.length();
    }

    public int nextSpanTransition(int arg1, int arg2, Class arg3) {
        return this.mDelegate.nextSpanTransition(arg1, arg2, arg3);
    }

    static PrecomputedTextDetector precomputedTextDetector() {
        if(Build$VERSION.SDK_INT < 28) {
            return new PrecomputedTextDetector();
        }

        return new PrecomputedTextDetector_28();
    }

    public void removeSpan(Object arg1) {
        this.ensureSafeWrites();
        this.mDelegate.removeSpan(arg1);
    }

    public void setSpan(Object arg1, int arg2, int arg3, int arg4) {
        this.ensureSafeWrites();
        this.mDelegate.setSpan(arg1, arg2, arg3, arg4);
    }

    public CharSequence subSequence(int arg1, int arg2) {
        return this.mDelegate.subSequence(arg1, arg2);
    }

    public String toString() {
        return this.mDelegate.toString();
    }
}


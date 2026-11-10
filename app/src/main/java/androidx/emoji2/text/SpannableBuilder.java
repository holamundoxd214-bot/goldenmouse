package androidx.emoji2.text;

import android.os.Build$VERSION;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import androidx.core.util.Preconditions;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class SpannableBuilder extends SpannableStringBuilder {
    class WatcherWrapper implements SpanWatcher, TextWatcher {
        private final AtomicInteger mBlockCalls;
        final Object mObject;

        WatcherWrapper(Object arg3) {
            super();
            this.mBlockCalls = new AtomicInteger(0);
            this.mObject = arg3;
        }

        public void afterTextChanged(Editable arg1) {
            this.mObject.afterTextChanged(arg1);
        }

        public void beforeTextChanged(CharSequence arg1, int arg2, int arg3, int arg4) {
            this.mObject.beforeTextChanged(arg1, arg2, arg3, arg4);
        }

        final void blockCalls() {
            this.mBlockCalls.incrementAndGet();
        }

        private boolean isEmojiSpan(Object arg1) {
            return arg1 instanceof EmojiSpan;
        }

        public void onSpanAdded(Spannable arg2, Object arg3, int arg4, int arg5) {
            if(this.mBlockCalls.get() > 0 && (this.isEmojiSpan(arg3))) {
                return;
            }

            this.mObject.onSpanAdded(arg2, arg3, arg4, arg5);
        }

        public void onSpanChanged(Spannable arg9, Object arg10, int arg11, int arg12, int arg13, int arg14) {
            int v6;
            int v4;
            if(this.mBlockCalls.get() > 0 && (this.isEmojiSpan(arg10))) {
                return;
            }

            if(Build$VERSION.SDK_INT >= 28 || arg13 <= arg14) {
                v4 = 0;
                v6 = arg13;
            }
            else {
                v4 = 0;
                v6 = 0;
            }

            this.mObject.onSpanChanged(arg9, arg10, v4, arg12, v6, arg14);
        }

        public void onSpanRemoved(Spannable arg2, Object arg3, int arg4, int arg5) {
            if(this.mBlockCalls.get() > 0 && (this.isEmojiSpan(arg3))) {
                return;
            }

            this.mObject.onSpanRemoved(arg2, arg3, arg4, arg5);
        }

        public void onTextChanged(CharSequence arg1, int arg2, int arg3, int arg4) {
            this.mObject.onTextChanged(arg1, arg2, arg3, arg4);
        }

        final void unblockCalls() {
            this.mBlockCalls.decrementAndGet();
        }
    }

    private final Class mWatcherClass;
    private final List mWatchers;

    SpannableBuilder(Class arg2) {
        super();
        this.mWatchers = new ArrayList();
        Preconditions.checkNotNull(arg2, "watcherClass cannot be null");
        this.mWatcherClass = arg2;
    }

    SpannableBuilder(Class arg1, CharSequence arg2) {
        super(arg2);
        this.mWatchers = new ArrayList();
        Preconditions.checkNotNull(arg1, "watcherClass cannot be null");
        this.mWatcherClass = arg1;
    }

    SpannableBuilder(Class arg1, CharSequence arg2, int arg3, int arg4) {
        super(arg2, arg3, arg4);
        this.mWatchers = new ArrayList();
        Preconditions.checkNotNull(arg1, "watcherClass cannot be null");
        this.mWatcherClass = arg1;
    }

    public Editable append(char arg1) {
        return this.append(arg1);
    }

    public SpannableStringBuilder append(char arg1) {
        super.append(arg1);
        return this;
    }

    public Editable append(CharSequence arg1) {
        return this.append(arg1);
    }

    public SpannableStringBuilder append(CharSequence arg1) {
        super.append(arg1);
        return this;
    }

    public Editable append(CharSequence arg1, int arg2, int arg3) {
        return this.append(arg1, arg2, arg3);
    }

    public SpannableStringBuilder append(CharSequence arg1, int arg2, int arg3) {
        super.append(arg1, arg2, arg3);
        return this;
    }

    public SpannableStringBuilder append(CharSequence arg1, Object arg2, int arg3) {
        super.append(arg1, arg2, arg3);
        return this;
    }

    public Appendable append(char arg1) throws IOException {
        return this.append(arg1);
    }

    public Appendable append(CharSequence arg1) throws IOException {
        return this.append(arg1);
    }

    public Appendable append(CharSequence arg1, int arg2, int arg3) throws IOException {
        return this.append(arg1, arg2, arg3);
    }

    public void beginBatchEdit() {
        this.blockWatchers();
    }

    private void blockWatchers() {
        int v0;
        for(v0 = 0; v0 < this.mWatchers.size(); ++v0) {
            this.mWatchers.get(v0).blockCalls();
        }
    }

    public static SpannableBuilder create(Class arg1, CharSequence arg2) {
        return new SpannableBuilder(arg1, arg2);
    }

    public Editable delete(int arg1, int arg2) {
        return this.delete(arg1, arg2);
    }

    public SpannableStringBuilder delete(int arg1, int arg2) {
        super.delete(arg1, arg2);
        return this;
    }

    public void endBatchEdit() {
        this.unblockwatchers();
        this.fireWatchers();
    }

    private void fireWatchers() {
        int v1;
        for(v1 = 0; v1 < this.mWatchers.size(); ++v1) {
            this.mWatchers.get(v1).onTextChanged(((CharSequence)this), 0, this.length(), this.length());
        }
    }

    public int getSpanEnd(Object arg2) {
        WatcherWrapper v2;
        if(this.isWatcher(arg2)) {
            WatcherWrapper v0 = this.getWatcherFor(arg2);
            if(v0 != null) {
                v2 = v0;
            }
        }

        return super.getSpanEnd(v2);
    }

    public int getSpanFlags(Object arg2) {
        WatcherWrapper v2;
        if(this.isWatcher(arg2)) {
            WatcherWrapper v0 = this.getWatcherFor(arg2);
            if(v0 != null) {
                v2 = v0;
            }
        }

        return super.getSpanFlags(v2);
    }

    public int getSpanStart(Object arg2) {
        WatcherWrapper v2;
        if(this.isWatcher(arg2)) {
            WatcherWrapper v0 = this.getWatcherFor(arg2);
            if(v0 != null) {
                v2 = v0;
            }
        }

        return super.getSpanStart(v2);
    }

    public Object[] getSpans(int arg2, int arg3, Class arg4) {
        if(this.isWatcher(arg4)) {
            Object[] v1 = super.getSpans(arg2, arg3, WatcherWrapper.class);
            Object v2 = Array.newInstance(arg4, v1.length);
            for(arg3 = 0; arg3 < v1.length; ++arg3) {
                v2[arg3] = v1[arg3].mObject;
            }

            return ((Object[])v2);
        }

        return super.getSpans(arg2, arg3, arg4);
    }

    private WatcherWrapper getWatcherFor(Object arg4) {
        int v0;
        for(v0 = 0; v0 < this.mWatchers.size(); ++v0) {
            Object v1 = this.mWatchers.get(v0);
            if(((WatcherWrapper)v1).mObject == arg4) {
                return ((WatcherWrapper)v1);
            }
        }

        return null;
    }

    public Editable insert(int arg1, CharSequence arg2) {
        return this.insert(arg1, arg2);
    }

    public SpannableStringBuilder insert(int arg1, CharSequence arg2) {
        super.insert(arg1, arg2);
        return this;
    }

    public Editable insert(int arg1, CharSequence arg2, int arg3, int arg4) {
        return this.insert(arg1, arg2, arg3, arg4);
    }

    public SpannableStringBuilder insert(int arg1, CharSequence arg2, int arg3, int arg4) {
        super.insert(arg1, arg2, arg3, arg4);
        return this;
    }

    private boolean isWatcher(Class arg1) {
        if(this.mWatcherClass == arg1) {
            return 1;
        }

        return 0;
    }

    private boolean isWatcher(Object arg1) {
        if(arg1 != null && (this.isWatcher(arg1.getClass()))) {
            return 1;
        }

        return 0;
    }

    public int nextSpanTransition(int arg2, int arg3, Class arg4) {
        if(arg4 == null || (this.isWatcher(arg4))) {
            arg4 = WatcherWrapper.class;
        }

        return super.nextSpanTransition(arg2, arg3, arg4);
    }

    public void removeSpan(Object arg2) {
        WatcherWrapper v2;
        WatcherWrapper v0;
        if(this.isWatcher(arg2)) {
            v0 = this.getWatcherFor(arg2);
            if(v0 != null) {
                v2 = v0;
            }
        }
        else {
            v0 = null;
        }

        super.removeSpan(v2);
        if(v0 != null) {
            this.mWatchers.remove(v0);
        }
    }

    public Editable replace(int arg1, int arg2, CharSequence arg3) {
        return this.replace(arg1, arg2, arg3);
    }

    public SpannableStringBuilder replace(int arg1, int arg2, CharSequence arg3) {
        this.blockWatchers();
        super.replace(arg1, arg2, arg3);
        this.unblockwatchers();
        return this;
    }

    public Editable replace(int arg1, int arg2, CharSequence arg3, int arg4, int arg5) {
        return this.replace(arg1, arg2, arg3, arg4, arg5);
    }

    public SpannableStringBuilder replace(int arg1, int arg2, CharSequence arg3, int arg4, int arg5) {
        this.blockWatchers();
        super.replace(arg1, arg2, arg3, arg4, arg5);
        this.unblockwatchers();
        return this;
    }

    public void setSpan(Object arg2, int arg3, int arg4, int arg5) {
        WatcherWrapper v2;
        if(this.isWatcher(arg2)) {
            WatcherWrapper v0 = new WatcherWrapper(arg2);
            this.mWatchers.add(v0);
            v2 = v0;
        }

        super.setSpan(v2, arg3, arg4, arg5);
    }

    public CharSequence subSequence(int arg3, int arg4) {
        return new SpannableBuilder(this.mWatcherClass, ((CharSequence)this), arg3, arg4);
    }

    private void unblockwatchers() {
        int v0;
        for(v0 = 0; v0 < this.mWatchers.size(); ++v0) {
            this.mWatchers.get(v0).unblockCalls();
        }
    }
}


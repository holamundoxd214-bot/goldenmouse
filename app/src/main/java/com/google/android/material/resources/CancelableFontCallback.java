package com.google.android.material.resources;

import android.graphics.Typeface;

public final class CancelableFontCallback extends TextAppearanceFontCallback {
    public interface ApplyFont {
        void apply(Typeface arg1);
    }

    private final ApplyFont applyFont;
    private boolean cancelled;
    private final Typeface fallbackFont;

    public CancelableFontCallback(ApplyFont arg1, Typeface arg2) {
        super();
        this.fallbackFont = arg2;
        this.applyFont = arg1;
    }

    public void cancel() {
        this.cancelled = true;
    }

    public void onFontRetrievalFailed(int arg1) {
        this.updateIfNotCancelled(this.fallbackFont);
    }

    public void onFontRetrieved(Typeface arg1, boolean arg2) {
        this.updateIfNotCancelled(arg1);
    }

    private void updateIfNotCancelled(Typeface arg2) {
        if(!this.cancelled) {
            this.applyFont.apply(arg2);
        }
    }
}


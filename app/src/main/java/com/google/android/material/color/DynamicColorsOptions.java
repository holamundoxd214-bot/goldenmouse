package com.google.android.material.color;

import android.app.Activity;
import android.graphics.Bitmap;
import com.google.android.material.color.utilities.QuantizerCelebi;
import com.google.android.material.color.utilities.Score;

public class DynamicColorsOptions {
    class com.google.android.material.color.DynamicColorsOptions$1 implements Precondition {
        com.google.android.material.color.DynamicColorsOptions$1() {
            super();
        }

        public boolean shouldApplyDynamicColors(Activity arg1, int arg2) {
            return 1;
        }
    }

    class com.google.android.material.color.DynamicColorsOptions$2 implements OnAppliedCallback {
        com.google.android.material.color.DynamicColorsOptions$2() {
            super();
        }

        public void onApplied(Activity arg1) {
        }
    }

    public class Builder {
        private Bitmap contentBasedSourceBitmap;
        private Integer contentBasedSourceColor;
        private OnAppliedCallback onAppliedCallback;
        private Precondition precondition;
        private int themeOverlay;

        public Builder() {
            super();
            this.precondition = DynamicColorsOptions.ALWAYS_ALLOW;
            this.onAppliedCallback = DynamicColorsOptions.NO_OP_CALLBACK;
        }

        static int access$000(Builder arg0) {
            return arg0.themeOverlay;
        }

        static Precondition access$100(Builder arg0) {
            return arg0.precondition;
        }

        static OnAppliedCallback access$200(Builder arg0) {
            return arg0.onAppliedCallback;
        }

        static Integer access$300(Builder arg0) {
            return arg0.contentBasedSourceColor;
        }

        static Bitmap access$400(Builder arg0) {
            return arg0.contentBasedSourceBitmap;
        }

        public DynamicColorsOptions build() {
            return new DynamicColorsOptions(this, null);
        }

        public Builder setContentBasedSource(int arg2) {
            this.contentBasedSourceBitmap = null;
            this.contentBasedSourceColor = Integer.valueOf(arg2);
            return this;
        }

        public Builder setContentBasedSource(Bitmap arg1) {
            this.contentBasedSourceBitmap = arg1;
            this.contentBasedSourceColor = null;
            return this;
        }

        public Builder setOnAppliedCallback(OnAppliedCallback arg1) {
            this.onAppliedCallback = arg1;
            return this;
        }

        public Builder setPrecondition(Precondition arg1) {
            this.precondition = arg1;
            return this;
        }

        public Builder setThemeOverlay(int arg1) {
            this.themeOverlay = arg1;
            return this;
        }
    }

    private static final Precondition ALWAYS_ALLOW;
    private static final OnAppliedCallback NO_OP_CALLBACK;
    private Integer contentBasedSeedColor;
    private final OnAppliedCallback onAppliedCallback;
    private final Precondition precondition;
    private final int themeOverlay;

    static {
        DynamicColorsOptions.ALWAYS_ALLOW = new com.google.android.material.color.DynamicColorsOptions$1();
        DynamicColorsOptions.NO_OP_CALLBACK = new com.google.android.material.color.DynamicColorsOptions$2();
    }

    private DynamicColorsOptions(Builder arg2) {
        super();
        this.themeOverlay = Builder.access$000(arg2);
        this.precondition = Builder.access$100(arg2);
        this.onAppliedCallback = Builder.access$200(arg2);
        if(Builder.access$300(arg2) != null) {
            this.contentBasedSeedColor = Builder.access$300(arg2);
            return;
        }

        if(Builder.access$400(arg2) != null) {
            this.contentBasedSeedColor = Integer.valueOf(DynamicColorsOptions.extractSeedColorFromImage(Builder.access$400(arg2)));
        }
    }

    DynamicColorsOptions(Builder arg1, com.google.android.material.color.DynamicColorsOptions$1 arg2) {
        this(arg1);
    }

    static Precondition access$500() {
        return DynamicColorsOptions.ALWAYS_ALLOW;
    }

    static OnAppliedCallback access$600() {
        return DynamicColorsOptions.NO_OP_CALLBACK;
    }

    private static int extractSeedColorFromImage(Bitmap arg8) {
        int v3 = arg8.getWidth();
        int v7 = arg8.getHeight();
        int[] v1 = new int[v3 * v7];
        arg8.getPixels(v1, 0, v3, 0, 0, v3, v7);
        return Score.score(QuantizerCelebi.quantize(v1, 0x80)).get(0).intValue();
    }

    public Integer getContentBasedSeedColor() {
        return this.contentBasedSeedColor;
    }

    public OnAppliedCallback getOnAppliedCallback() {
        return this.onAppliedCallback;
    }

    public Precondition getPrecondition() {
        return this.precondition;
    }

    public int getThemeOverlay() {
        return this.themeOverlay;
    }
}


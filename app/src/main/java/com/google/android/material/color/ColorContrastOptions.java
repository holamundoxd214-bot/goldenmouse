package com.google.android.material.color;

public class ColorContrastOptions {
    class com.google.android.material.color.ColorContrastOptions$1 {
    }

    public class Builder {
        private int highContrastThemeOverlayResourceId;
        private int mediumContrastThemeOverlayResourceId;

        public Builder() {
            super();
        }

        static int access$000(Builder arg0) {
            return arg0.mediumContrastThemeOverlayResourceId;
        }

        static int access$100(Builder arg0) {
            return arg0.highContrastThemeOverlayResourceId;
        }

        public ColorContrastOptions build() {
            return new ColorContrastOptions(this, null);
        }

        public Builder setHighContrastThemeOverlay(int arg1) {
            this.highContrastThemeOverlayResourceId = arg1;
            return this;
        }

        public Builder setMediumContrastThemeOverlay(int arg1) {
            this.mediumContrastThemeOverlayResourceId = arg1;
            return this;
        }
    }

    private final int highContrastThemeOverlayResourceId;
    private final int mediumContrastThemeOverlayResourceId;

    private ColorContrastOptions(Builder arg2) {
        super();
        this.mediumContrastThemeOverlayResourceId = Builder.access$000(arg2);
        this.highContrastThemeOverlayResourceId = Builder.access$100(arg2);
    }

    ColorContrastOptions(Builder arg1, com.google.android.material.color.ColorContrastOptions$1 arg2) {
        this(arg1);
    }

    public int getHighContrastThemeOverlay() {
        return this.highContrastThemeOverlayResourceId;
    }

    public int getMediumContrastThemeOverlay() {
        return this.mediumContrastThemeOverlayResourceId;
    }
}


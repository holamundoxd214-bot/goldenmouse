package com.google.android.material.color;

import com.google.android.material.R$attr;

public class HarmonizedColorsOptions {
    class com.google.android.material.color.HarmonizedColorsOptions$1 {
    }

    public class Builder {
        private int colorAttributeToHarmonizeWith;
        private HarmonizedColorAttributes colorAttributes;
        private int[] colorResourceIds;

        public Builder() {
            super();
            this.colorResourceIds = new int[0];
            this.colorAttributeToHarmonizeWith = attr.colorPrimary;
        }

        static int[] access$000(Builder arg0) {
            return arg0.colorResourceIds;
        }

        static HarmonizedColorAttributes access$100(Builder arg0) {
            return arg0.colorAttributes;
        }

        static int access$200(Builder arg0) {
            return arg0.colorAttributeToHarmonizeWith;
        }

        public HarmonizedColorsOptions build() {
            return new HarmonizedColorsOptions(this, null);
        }

        public Builder setColorAttributeToHarmonizeWith(int arg1) {
            this.colorAttributeToHarmonizeWith = arg1;
            return this;
        }

        public Builder setColorAttributes(HarmonizedColorAttributes arg1) {
            this.colorAttributes = arg1;
            return this;
        }

        public Builder setColorResourceIds(int[] arg1) {
            this.colorResourceIds = arg1;
            return this;
        }
    }

    private final int colorAttributeToHarmonizeWith;
    private final HarmonizedColorAttributes colorAttributes;
    private final int[] colorResourceIds;

    private HarmonizedColorsOptions(Builder arg2) {
        super();
        this.colorResourceIds = Builder.access$000(arg2);
        this.colorAttributes = Builder.access$100(arg2);
        this.colorAttributeToHarmonizeWith = Builder.access$200(arg2);
    }

    HarmonizedColorsOptions(Builder arg1, com.google.android.material.color.HarmonizedColorsOptions$1 arg2) {
        this(arg1);
    }

    public static HarmonizedColorsOptions createMaterialDefaults() {
        return new Builder().setColorAttributes(HarmonizedColorAttributes.createMaterialDefaults()).build();
    }

    public int getColorAttributeToHarmonizeWith() {
        return this.colorAttributeToHarmonizeWith;
    }

    public HarmonizedColorAttributes getColorAttributes() {
        return this.colorAttributes;
    }

    public int[] getColorResourceIds() {
        return this.colorResourceIds;
    }

    int getThemeOverlayResourceId(int arg2) {
        HarmonizedColorAttributes v0 = this.colorAttributes;
        if(v0 != null && v0.getThemeOverlay() != 0) {
            return this.colorAttributes.getThemeOverlay();
        }

        return arg2;
    }
}


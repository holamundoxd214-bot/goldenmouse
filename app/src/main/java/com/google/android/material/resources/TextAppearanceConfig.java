package com.google.android.material.resources;

@Deprecated public class TextAppearanceConfig {
    private static boolean shouldLoadFontSynchronously;

    public TextAppearanceConfig() {
        super();
    }

    public static void setShouldLoadFontSynchronously(boolean arg0) {
        TextAppearanceConfig.shouldLoadFontSynchronously = arg0;
    }

    public static boolean shouldLoadFontSynchronously() {
        return TextAppearanceConfig.shouldLoadFontSynchronously;
    }
}


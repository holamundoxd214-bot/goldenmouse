package com.google.android.material.color.utilities;

import com.google.errorprone.annotations.CheckReturnValue;

@CheckReturnValue public class Scheme {
    private int background;
    private int error;
    private int errorContainer;
    private int inverseOnSurface;
    private int inversePrimary;
    private int inverseSurface;
    private int onBackground;
    private int onError;
    private int onErrorContainer;
    private int onPrimary;
    private int onPrimaryContainer;
    private int onSecondary;
    private int onSecondaryContainer;
    private int onSurface;
    private int onSurfaceVariant;
    private int onTertiary;
    private int onTertiaryContainer;
    private int outline;
    private int outlineVariant;
    private int primary;
    private int primaryContainer;
    private int scrim;
    private int secondary;
    private int secondaryContainer;
    private int shadow;
    private int surface;
    private int surfaceVariant;
    private int tertiary;
    private int tertiaryContainer;

    public Scheme() {
        super();
    }

    public Scheme(int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, int arg14, int arg15, int arg16, int arg17, int arg18, int arg19, int arg20, int arg21, int arg22, int arg23, int arg24, int arg25, int arg26, int arg27, int arg28, int arg29) {
        super();
        this.primary = arg1;
        this.onPrimary = arg2;
        this.primaryContainer = arg3;
        this.onPrimaryContainer = arg4;
        this.secondary = arg5;
        this.onSecondary = arg6;
        this.secondaryContainer = arg7;
        this.onSecondaryContainer = arg8;
        this.tertiary = arg9;
        this.onTertiary = arg10;
        this.tertiaryContainer = arg11;
        this.onTertiaryContainer = arg12;
        this.error = arg13;
        this.onError = arg14;
        this.errorContainer = arg15;
        this.onErrorContainer = arg16;
        this.background = arg17;
        this.onBackground = arg18;
        this.surface = arg19;
        this.onSurface = arg20;
        this.surfaceVariant = arg21;
        this.onSurfaceVariant = arg22;
        this.outline = arg23;
        this.outlineVariant = arg24;
        this.shadow = arg25;
        this.scrim = arg26;
        this.inverseSurface = arg27;
        this.inverseOnSurface = arg28;
        this.inversePrimary = arg29;
    }

    public static Scheme dark(int arg0) {
        return Scheme.darkFromCorePalette(CorePalette.of(arg0));
    }

    public static Scheme darkContent(int arg0) {
        return Scheme.darkFromCorePalette(CorePalette.contentOf(arg0));
    }

    private static Scheme darkFromCorePalette(CorePalette arg7) {
        return new Scheme().withPrimary(arg7.a1.tone(80)).withOnPrimary(arg7.a1.tone(20)).withPrimaryContainer(arg7.a1.tone(30)).withOnPrimaryContainer(arg7.a1.tone(90)).withSecondary(arg7.a2.tone(80)).withOnSecondary(arg7.a2.tone(20)).withSecondaryContainer(arg7.a2.tone(30)).withOnSecondaryContainer(arg7.a2.tone(90)).withTertiary(arg7.a3.tone(80)).withOnTertiary(arg7.a3.tone(20)).withTertiaryContainer(arg7.a3.tone(30)).withOnTertiaryContainer(arg7.a3.tone(90)).withError(arg7.error.tone(80)).withOnError(arg7.error.tone(20)).withErrorContainer(arg7.error.tone(30)).withOnErrorContainer(arg7.error.tone(80)).withBackground(arg7.n1.tone(10)).withOnBackground(arg7.n1.tone(90)).withSurface(arg7.n1.tone(10)).withOnSurface(arg7.n1.tone(90)).withSurfaceVariant(arg7.n2.tone(30)).withOnSurfaceVariant(arg7.n2.tone(80)).withOutline(arg7.n2.tone(60)).withOutlineVariant(arg7.n2.tone(30)).withShadow(arg7.n1.tone(0)).withScrim(arg7.n1.tone(0)).withInverseSurface(arg7.n1.tone(90)).withInverseOnSurface(arg7.n1.tone(20)).withInversePrimary(arg7.a1.tone(40));
    }

    public boolean equals(Object arg5) {
        if(this == (((Scheme)arg5))) {
            return 1;
        }

        if(!(arg5 instanceof Scheme)) {
            return 0;
        }

        if(!super.equals(arg5)) {
            return 0;
        }

        if(this.primary != ((Scheme)arg5).primary) {
            return 0;
        }

        if(this.onPrimary != ((Scheme)arg5).onPrimary) {
            return 0;
        }

        if(this.primaryContainer != ((Scheme)arg5).primaryContainer) {
            return 0;
        }

        if(this.onPrimaryContainer != ((Scheme)arg5).onPrimaryContainer) {
            return 0;
        }

        if(this.secondary != ((Scheme)arg5).secondary) {
            return 0;
        }

        if(this.onSecondary != ((Scheme)arg5).onSecondary) {
            return 0;
        }

        if(this.secondaryContainer != ((Scheme)arg5).secondaryContainer) {
            return 0;
        }

        if(this.onSecondaryContainer != ((Scheme)arg5).onSecondaryContainer) {
            return 0;
        }

        if(this.tertiary != ((Scheme)arg5).tertiary) {
            return 0;
        }

        if(this.onTertiary != ((Scheme)arg5).onTertiary) {
            return 0;
        }

        if(this.tertiaryContainer != ((Scheme)arg5).tertiaryContainer) {
            return 0;
        }

        if(this.onTertiaryContainer != ((Scheme)arg5).onTertiaryContainer) {
            return 0;
        }

        if(this.error != ((Scheme)arg5).error) {
            return 0;
        }

        if(this.onError != ((Scheme)arg5).onError) {
            return 0;
        }

        if(this.errorContainer != ((Scheme)arg5).errorContainer) {
            return 0;
        }

        if(this.onErrorContainer != ((Scheme)arg5).onErrorContainer) {
            return 0;
        }

        if(this.background != ((Scheme)arg5).background) {
            return 0;
        }

        if(this.onBackground != ((Scheme)arg5).onBackground) {
            return 0;
        }

        if(this.surface != ((Scheme)arg5).surface) {
            return 0;
        }

        if(this.onSurface != ((Scheme)arg5).onSurface) {
            return 0;
        }

        if(this.surfaceVariant != ((Scheme)arg5).surfaceVariant) {
            return 0;
        }

        if(this.onSurfaceVariant != ((Scheme)arg5).onSurfaceVariant) {
            return 0;
        }

        if(this.outline != ((Scheme)arg5).outline) {
            return 0;
        }

        if(this.outlineVariant != ((Scheme)arg5).outlineVariant) {
            return 0;
        }

        if(this.shadow != ((Scheme)arg5).shadow) {
            return 0;
        }

        if(this.scrim != ((Scheme)arg5).scrim) {
            return 0;
        }

        if(this.inverseSurface != ((Scheme)arg5).inverseSurface) {
            return 0;
        }

        if(this.inverseOnSurface != ((Scheme)arg5).inverseOnSurface) {
            return 0;
        }

        if(this.inversePrimary != ((Scheme)arg5).inversePrimary) {
            return 0;
        }

        return 1;
    }

    public int getBackground() {
        return this.background;
    }

    public int getError() {
        return this.error;
    }

    public int getErrorContainer() {
        return this.errorContainer;
    }

    public int getInverseOnSurface() {
        return this.inverseOnSurface;
    }

    public int getInversePrimary() {
        return this.inversePrimary;
    }

    public int getInverseSurface() {
        return this.inverseSurface;
    }

    public int getOnBackground() {
        return this.onBackground;
    }

    public int getOnError() {
        return this.onError;
    }

    public int getOnErrorContainer() {
        return this.onErrorContainer;
    }

    public int getOnPrimary() {
        return this.onPrimary;
    }

    public int getOnPrimaryContainer() {
        return this.onPrimaryContainer;
    }

    public int getOnSecondary() {
        return this.onSecondary;
    }

    public int getOnSecondaryContainer() {
        return this.onSecondaryContainer;
    }

    public int getOnSurface() {
        return this.onSurface;
    }

    public int getOnSurfaceVariant() {
        return this.onSurfaceVariant;
    }

    public int getOnTertiary() {
        return this.onTertiary;
    }

    public int getOnTertiaryContainer() {
        return this.onTertiaryContainer;
    }

    public int getOutline() {
        return this.outline;
    }

    public int getOutlineVariant() {
        return this.outlineVariant;
    }

    public int getPrimary() {
        return this.primary;
    }

    public int getPrimaryContainer() {
        return this.primaryContainer;
    }

    public int getScrim() {
        return this.scrim;
    }

    public int getSecondary() {
        return this.secondary;
    }

    public int getSecondaryContainer() {
        return this.secondaryContainer;
    }

    public int getShadow() {
        return this.shadow;
    }

    public int getSurface() {
        return this.surface;
    }

    public int getSurfaceVariant() {
        return this.surfaceVariant;
    }

    public int getTertiary() {
        return this.tertiary;
    }

    public int getTertiaryContainer() {
        return this.tertiaryContainer;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((super.hashCode() * 0x1F + this.primary) * 0x1F + this.onPrimary) * 0x1F + this.primaryContainer) * 0x1F + this.onPrimaryContainer) * 0x1F + this.secondary) * 0x1F + this.onSecondary) * 0x1F + this.secondaryContainer) * 0x1F + this.onSecondaryContainer) * 0x1F + this.tertiary) * 0x1F + this.onTertiary) * 0x1F + this.tertiaryContainer) * 0x1F + this.onTertiaryContainer) * 0x1F + this.error) * 0x1F + this.onError) * 0x1F + this.errorContainer) * 0x1F + this.onErrorContainer) * 0x1F + this.background) * 0x1F + this.onBackground) * 0x1F + this.surface) * 0x1F + this.onSurface) * 0x1F + this.surfaceVariant) * 0x1F + this.onSurfaceVariant) * 0x1F + this.outline) * 0x1F + this.outlineVariant) * 0x1F + this.shadow) * 0x1F + this.scrim) * 0x1F + this.inverseSurface) * 0x1F + this.inverseOnSurface) * 0x1F + this.inversePrimary;
    }

    public static Scheme light(int arg0) {
        return Scheme.lightFromCorePalette(CorePalette.of(arg0));
    }

    public static Scheme lightContent(int arg0) {
        return Scheme.lightFromCorePalette(CorePalette.contentOf(arg0));
    }

    private static Scheme lightFromCorePalette(CorePalette arg6) {
        return new Scheme().withPrimary(arg6.a1.tone(40)).withOnPrimary(arg6.a1.tone(100)).withPrimaryContainer(arg6.a1.tone(90)).withOnPrimaryContainer(arg6.a1.tone(10)).withSecondary(arg6.a2.tone(40)).withOnSecondary(arg6.a2.tone(100)).withSecondaryContainer(arg6.a2.tone(90)).withOnSecondaryContainer(arg6.a2.tone(10)).withTertiary(arg6.a3.tone(40)).withOnTertiary(arg6.a3.tone(100)).withTertiaryContainer(arg6.a3.tone(90)).withOnTertiaryContainer(arg6.a3.tone(10)).withError(arg6.error.tone(40)).withOnError(arg6.error.tone(100)).withErrorContainer(arg6.error.tone(90)).withOnErrorContainer(arg6.error.tone(10)).withBackground(arg6.n1.tone(99)).withOnBackground(arg6.n1.tone(10)).withSurface(arg6.n1.tone(99)).withOnSurface(arg6.n1.tone(10)).withSurfaceVariant(arg6.n2.tone(90)).withOnSurfaceVariant(arg6.n2.tone(30)).withOutline(arg6.n2.tone(50)).withOutlineVariant(arg6.n2.tone(80)).withShadow(arg6.n1.tone(0)).withScrim(arg6.n1.tone(0)).withInverseSurface(arg6.n1.tone(20)).withInverseOnSurface(arg6.n1.tone(0x5F)).withInversePrimary(arg6.a1.tone(80));
    }

    public void setBackground(int arg1) {
        this.background = arg1;
    }

    public void setError(int arg1) {
        this.error = arg1;
    }

    public void setErrorContainer(int arg1) {
        this.errorContainer = arg1;
    }

    public void setInverseOnSurface(int arg1) {
        this.inverseOnSurface = arg1;
    }

    public void setInversePrimary(int arg1) {
        this.inversePrimary = arg1;
    }

    public void setInverseSurface(int arg1) {
        this.inverseSurface = arg1;
    }

    public void setOnBackground(int arg1) {
        this.onBackground = arg1;
    }

    public void setOnError(int arg1) {
        this.onError = arg1;
    }

    public void setOnErrorContainer(int arg1) {
        this.onErrorContainer = arg1;
    }

    public void setOnPrimary(int arg1) {
        this.onPrimary = arg1;
    }

    public void setOnPrimaryContainer(int arg1) {
        this.onPrimaryContainer = arg1;
    }

    public void setOnSecondary(int arg1) {
        this.onSecondary = arg1;
    }

    public void setOnSecondaryContainer(int arg1) {
        this.onSecondaryContainer = arg1;
    }

    public void setOnSurface(int arg1) {
        this.onSurface = arg1;
    }

    public void setOnSurfaceVariant(int arg1) {
        this.onSurfaceVariant = arg1;
    }

    public void setOnTertiary(int arg1) {
        this.onTertiary = arg1;
    }

    public void setOnTertiaryContainer(int arg1) {
        this.onTertiaryContainer = arg1;
    }

    public void setOutline(int arg1) {
        this.outline = arg1;
    }

    public void setOutlineVariant(int arg1) {
        this.outlineVariant = arg1;
    }

    public void setPrimary(int arg1) {
        this.primary = arg1;
    }

    public void setPrimaryContainer(int arg1) {
        this.primaryContainer = arg1;
    }

    public void setScrim(int arg1) {
        this.scrim = arg1;
    }

    public void setSecondary(int arg1) {
        this.secondary = arg1;
    }

    public void setSecondaryContainer(int arg1) {
        this.secondaryContainer = arg1;
    }

    public void setShadow(int arg1) {
        this.shadow = arg1;
    }

    public void setSurface(int arg1) {
        this.surface = arg1;
    }

    public void setSurfaceVariant(int arg1) {
        this.surfaceVariant = arg1;
    }

    public void setTertiary(int arg1) {
        this.tertiary = arg1;
    }

    public void setTertiaryContainer(int arg1) {
        this.tertiaryContainer = arg1;
    }

    public String toString() {
        return "Scheme{primary=" + this.primary + ", onPrimary=" + this.onPrimary + ", primaryContainer=" + this.primaryContainer + ", onPrimaryContainer=" + this.onPrimaryContainer + ", secondary=" + this.secondary + ", onSecondary=" + this.onSecondary + ", secondaryContainer=" + this.secondaryContainer + ", onSecondaryContainer=" + this.onSecondaryContainer + ", tertiary=" + this.tertiary + ", onTertiary=" + this.onTertiary + ", tertiaryContainer=" + this.tertiaryContainer + ", onTertiaryContainer=" + this.onTertiaryContainer + ", error=" + this.error + ", onError=" + this.onError + ", errorContainer=" + this.errorContainer + ", onErrorContainer=" + this.onErrorContainer + ", background=" + this.background + ", onBackground=" + this.onBackground + ", surface=" + this.surface + ", onSurface=" + this.onSurface + ", surfaceVariant=" + this.surfaceVariant + ", onSurfaceVariant=" + this.onSurfaceVariant + ", outline=" + this.outline + ", outlineVariant=" + this.outlineVariant + ", shadow=" + this.shadow + ", scrim=" + this.scrim + ", inverseSurface=" + this.inverseSurface + ", inverseOnSurface=" + this.inverseOnSurface + ", inversePrimary=" + this.inversePrimary + '}';
    }

    public Scheme withBackground(int arg1) {
        this.background = arg1;
        return this;
    }

    public Scheme withError(int arg1) {
        this.error = arg1;
        return this;
    }

    public Scheme withErrorContainer(int arg1) {
        this.errorContainer = arg1;
        return this;
    }

    public Scheme withInverseOnSurface(int arg1) {
        this.inverseOnSurface = arg1;
        return this;
    }

    public Scheme withInversePrimary(int arg1) {
        this.inversePrimary = arg1;
        return this;
    }

    public Scheme withInverseSurface(int arg1) {
        this.inverseSurface = arg1;
        return this;
    }

    public Scheme withOnBackground(int arg1) {
        this.onBackground = arg1;
        return this;
    }

    public Scheme withOnError(int arg1) {
        this.onError = arg1;
        return this;
    }

    public Scheme withOnErrorContainer(int arg1) {
        this.onErrorContainer = arg1;
        return this;
    }

    public Scheme withOnPrimary(int arg1) {
        this.onPrimary = arg1;
        return this;
    }

    public Scheme withOnPrimaryContainer(int arg1) {
        this.onPrimaryContainer = arg1;
        return this;
    }

    public Scheme withOnSecondary(int arg1) {
        this.onSecondary = arg1;
        return this;
    }

    public Scheme withOnSecondaryContainer(int arg1) {
        this.onSecondaryContainer = arg1;
        return this;
    }

    public Scheme withOnSurface(int arg1) {
        this.onSurface = arg1;
        return this;
    }

    public Scheme withOnSurfaceVariant(int arg1) {
        this.onSurfaceVariant = arg1;
        return this;
    }

    public Scheme withOnTertiary(int arg1) {
        this.onTertiary = arg1;
        return this;
    }

    public Scheme withOnTertiaryContainer(int arg1) {
        this.onTertiaryContainer = arg1;
        return this;
    }

    public Scheme withOutline(int arg1) {
        this.outline = arg1;
        return this;
    }

    public Scheme withOutlineVariant(int arg1) {
        this.outlineVariant = arg1;
        return this;
    }

    public Scheme withPrimary(int arg1) {
        this.primary = arg1;
        return this;
    }

    public Scheme withPrimaryContainer(int arg1) {
        this.primaryContainer = arg1;
        return this;
    }

    public Scheme withScrim(int arg1) {
        this.scrim = arg1;
        return this;
    }

    public Scheme withSecondary(int arg1) {
        this.secondary = arg1;
        return this;
    }

    public Scheme withSecondaryContainer(int arg1) {
        this.secondaryContainer = arg1;
        return this;
    }

    public Scheme withShadow(int arg1) {
        this.shadow = arg1;
        return this;
    }

    public Scheme withSurface(int arg1) {
        this.surface = arg1;
        return this;
    }

    public Scheme withSurfaceVariant(int arg1) {
        this.surfaceVariant = arg1;
        return this;
    }

    public Scheme withTertiary(int arg1) {
        this.tertiary = arg1;
        return this;
    }

    public Scheme withTertiaryContainer(int arg1) {
        this.tertiaryContainer = arg1;
        return this;
    }
}


package com.google.android.material.color.utilities;

public final class DislikeAnalyzer {
    private DislikeAnalyzer() {
        super();
        throw new UnsupportedOperationException();
    }

    public static Hct fixIfDisliked(Hct arg7) {
        if(DislikeAnalyzer.isDisliked(arg7)) {
            arg7 = Hct.from(arg7.getHue(), arg7.getChroma(), 70);
        }

        return arg7;
    }

    public static boolean isDisliked(Hct arg8) {
        int v0 = Double.compare(((double)Math.round(arg8.getHue())), 90) < 0 || (((double)Math.round(arg8.getHue()))) > 111 ? 0 : 1;
        int v3 = (((double)Math.round(arg8.getChroma()))) > 16 ? 1 : 0;
        int v8 = (((double)Math.round(arg8.getTone()))) < 65 ? 1 : 0;
        if(v0 != 0 && v3 != 0 && v8 != 0) {
            return 1;
        }

        return 0;
    }
}


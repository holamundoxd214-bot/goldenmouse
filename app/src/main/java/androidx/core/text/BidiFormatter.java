package androidx.core.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;

public final class BidiFormatter {
    public final class Builder {
        private int mFlags;
        private boolean mIsRtlContext;
        private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;

        public Builder() {
            super();
            this.initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
        }

        public Builder(Locale arg1) {
            super();
            this.initialize(BidiFormatter.isRtlLocale(arg1));
        }

        public Builder(boolean arg1) {
            super();
            this.initialize(arg1);
        }

        public BidiFormatter build() {
            if(this.mFlags == 2 && this.mTextDirectionHeuristicCompat == BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC) {
                return Builder.getDefaultInstanceFromContext(this.mIsRtlContext);
            }

            return new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat);
        }

        private static BidiFormatter getDefaultInstanceFromContext(boolean arg0) {
            if(arg0) {
                return BidiFormatter.DEFAULT_RTL_INSTANCE;
            }

            return BidiFormatter.DEFAULT_LTR_INSTANCE;
        }

        private void initialize(boolean arg1) {
            this.mIsRtlContext = arg1;
            this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
            this.mFlags = 2;
        }

        public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat arg1) {
            this.mTextDirectionHeuristicCompat = arg1;
            return this;
        }

        public Builder stereoReset(boolean arg2) {
            int v0 = this.mFlags;
            if(arg2) {
                this.mFlags = v0 | 2;
                return this;
            }

            this.mFlags = v0 & -3;
            return this;
        }
    }

    class DirectionalityEstimator {
        private static final byte[] DIR_TYPE_CACHE = null;
        private static final int DIR_TYPE_CACHE_SIZE = 0x700;
        private int charIndex;
        private final boolean isHtml;
        private char lastChar;
        private final int length;
        private final CharSequence text;

        static {
            int v0 = 0x700;
            DirectionalityEstimator.DIR_TYPE_CACHE = new byte[v0];
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                DirectionalityEstimator.DIR_TYPE_CACHE[v1] = Character.getDirectionality(v1);
            }
        }

        DirectionalityEstimator(CharSequence arg1, boolean arg2) {
            super();
            this.text = arg1;
            this.isHtml = arg2;
            this.length = arg1.length();
        }

        byte dirTypeBackward() {
            char v0 = this.text.charAt(this.charIndex - 1);
            this.lastChar = v0;
            if(Character.isLowSurrogate(v0)) {
                int v0_1 = Character.codePointBefore(this.text, this.charIndex);
                this.charIndex -= Character.charCount(v0_1);
                return Character.getDirectionality(v0_1);
            }

            --this.charIndex;
            byte v0_2 = DirectionalityEstimator.getCachedDirectionality(this.lastChar);
            if(this.isHtml) {
                char v1 = this.lastChar;
                if(v1 == 62) {
                    return this.skipTagBackward();
                }
                else if(v1 == 59) {
                    return this.skipEntityBackward();
                }
            }

            return v0_2;
        }

        byte dirTypeForward() {
            char v0 = this.text.charAt(this.charIndex);
            this.lastChar = v0;
            if(Character.isHighSurrogate(v0)) {
                int v0_1 = Character.codePointAt(this.text, this.charIndex);
                this.charIndex += Character.charCount(v0_1);
                return Character.getDirectionality(v0_1);
            }

            ++this.charIndex;
            byte v0_2 = DirectionalityEstimator.getCachedDirectionality(this.lastChar);
            if(this.isHtml) {
                char v1 = this.lastChar;
                if(v1 == 60) {
                    return this.skipTagForward();
                }
                else if(v1 == 38) {
                    return this.skipEntityForward();
                }
            }

            return v0_2;
        }

        private static byte getCachedDirectionality(char arg1) {
            if(arg1 < 0x700) {
                return DirectionalityEstimator.DIR_TYPE_CACHE[arg1];
            }

            return Character.getDirectionality(arg1);
        }

        int getEntryDir() {
            int v6;
            this.charIndex = 0;
            int v1 = 0;
            int v2 = 0;
            int v3 = 0;
            while(true) {
                v6 = -1;
                if(this.charIndex < this.length && v1 == 0) {
                    int v4 = this.dirTypeForward();
                    if(v4 != 0) {
                        if(v4 != 1 && v4 != 2) {
                            if(v4 == 9) {
                                continue;
                            }

                            switch(v4) {
                                case 14: 
                                case 15: {
                                    goto label_26;
                                }
                                case 16: 
                                case 17: {
                                    goto label_23;
                                }
                                case 18: {
                                    goto label_20;
                                }
                            }

                            goto label_33;
                        label_20:
                            --v3;
                            v2 = 0;
                            continue;
                        label_23:
                            ++v3;
                            v2 = 1;
                            continue;
                        label_26:
                            ++v3;
                            v2 = v6;
                            continue;
                        }

                        if(v3 != 0) {
                            goto label_33;
                        }

                        return 1;
                    }
                    else {
                        if(v3 != 0) {
                            goto label_33;
                        }

                        return v6;
                    }

                label_33:
                    v1 = v3;
                    continue;
                }

                break;
            }

            if(v1 == 0) {
                return 0;
            }

            if(v2 != 0) {
                return v2;
            }

            while(this.charIndex > 0) {
                switch(this.dirTypeBackward()) {
                    case 14: 
                    case 15: {
                        goto label_48;
                    }
                    case 16: 
                    case 17: {
                        goto label_46;
                    }
                    case 18: {
                        goto label_44;
                    }
                }

                continue;
            label_44:
                ++v3;
                continue;
            label_46:
                if(v1 != v3) {
                    goto label_50;
                }

                return 1;
            label_48:
                if(v1 == v3) {
                    return v6;
                }

            label_50:
                --v3;
            }

            return 0;
        }

        int getExitDir() {
            this.charIndex = this.length;
            int v1 = 0;
            while(true) {
            label_4:
                int v2 = v1;
                do {
                label_5:
                    if(this.charIndex <= 0) {
                        return 0;
                    }

                    int v3 = this.dirTypeBackward();
                    int v4 = -1;
                    if(v3 != 0) {
                        if(v3 != 1 && v3 != 2) {
                            if(v3 == 9) {
                                goto label_5;
                            }

                            switch(v3) {
                                case 14: 
                                case 15: {
                                    goto label_23;
                                }
                                case 16: 
                                case 17: {
                                    goto label_21;
                                }
                                case 18: {
                                    goto label_19;
                                }
                            }

                            if(v2 != 0) {
                                goto label_5;
                            }

                            goto label_4;
                        label_19:
                            ++v1;
                            goto label_5;
                        label_21:
                            if(v2 == v1) {
                                return 1;
                            label_23:
                                if(v2 == v1) {
                                    return v4;
                                }
                                else {
                                    goto label_25;
                                }
                            }
                            else {
                            label_25:
                                --v1;
                                goto label_5;
                            }
                        }

                        if(v1 == 0) {
                            return 1;
                        }

                        if(v2 != 0) {
                            goto label_5;
                        }

                        goto label_4;
                    }

                    if(v1 == 0) {
                        return v4;
                    }
                }
                while(v2 != 0);
            }

            return 0;
        }

        private byte skipEntityBackward() {
            char v2;
            int v0 = this.charIndex;
            do {
                int v1 = this.charIndex;
                v2 = ';';
                if(v1 <= 0) {
                    break;
                }

                CharSequence v3 = this.text;
                --v1;
                this.charIndex = v1;
                char v1_1 = v3.charAt(v1);
                this.lastChar = v1_1;
                if(v1_1 == 38) {
                    return 12;
                }
                else if(v1_1 != v2) {
                    continue;
                }

                break;
            }
            while(true);

            this.charIndex = v0;
            this.lastChar = v2;
            return 13;
        }

        private byte skipEntityForward() {
            while(true) {
                int v0 = this.charIndex;
                if(v0 < this.length) {
                    CharSequence v1 = this.text;
                    this.charIndex = v0 + 1;
                    char v0_1 = v1.charAt(v0);
                    this.lastChar = v0_1;
                    if(v0_1 != 59) {
                        continue;
                    }
                }

                return 12;
            }

            return 12;
        }

        private byte skipTagBackward() {
            CharSequence v3;
            char v2;
            int v0 = this.charIndex;
            do {
            label_1:
                int v1 = this.charIndex;
                v2 = '>';
                if(v1 <= 0) {
                    break;
                }

                v3 = this.text;
                --v1;
                this.charIndex = v1;
                char v1_1 = v3.charAt(v1);
                this.lastChar = v1_1;
                if(v1_1 == 60) {
                    return 12;
                }
                else if(v1_1 == v2) {
                }
                else {
                    if(v1_1 != 34 && v1_1 != 39) {
                        continue;
                    }

                    goto label_19;
                }

                break;
            }
            while(true);

            this.charIndex = v0;
            this.lastChar = v2;
            return 13;
            while(true) {
            label_19:
                int v2_1 = this.charIndex;
                if(v2_1 <= 0) {
                    goto label_1;
                }

                v3 = this.text;
                --v2_1;
                this.charIndex = v2_1;
                v2 = v3.charAt(v2_1);
                this.lastChar = v2;
                if(v2 == v1_1) {
                    goto label_1;
                }
            }
        }

        private byte skipTagForward() {
            int v0 = this.charIndex;
            do {
            label_1:
                int v1 = this.charIndex;
                if(v1 >= this.length) {
                    break;
                }

                CharSequence v2 = this.text;
                this.charIndex = v1 + 1;
                char v1_1 = v2.charAt(v1);
                this.lastChar = v1_1;
                if(v1_1 == 62) {
                    return 12;
                }

                if(v1_1 != 34 && v1_1 != 39) {
                    continue;
                }

                goto label_17;
            }
            while(true);

            this.charIndex = v0;
            this.lastChar = '<';
            return 13;
            while(true) {
            label_17:
                int v2_1 = this.charIndex;
                if(v2_1 >= this.length) {
                    goto label_1;
                }

                CharSequence v3 = this.text;
                this.charIndex = v2_1 + 1;
                char v2_2 = v3.charAt(v2_1);
                this.lastChar = v2_2;
                if(v2_2 == v1_1) {
                    goto label_1;
                }
            }
        }
    }

    private static final int DEFAULT_FLAGS = 2;
    static final BidiFormatter DEFAULT_LTR_INSTANCE = null;
    static final BidiFormatter DEFAULT_RTL_INSTANCE = null;
    static final TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC = null;
    private static final int DIR_LTR = -1;
    private static final int DIR_RTL = 1;
    private static final int DIR_UNKNOWN = 0;
    private static final String EMPTY_STRING = "";
    private static final int FLAG_STEREO_RESET = 2;
    private static final char LRE = '‪';
    private static final char LRM = '‎';
    private static final String LRM_STRING = null;
    private static final char PDF = '‬';
    private static final char RLE = '‫';
    private static final char RLM = '‏';
    private static final String RLM_STRING;
    private final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
    private final int mFlags;
    private final boolean mIsRtlContext;

    static {
        TextDirectionHeuristicCompat v0 = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC = v0;
        BidiFormatter.LRM_STRING = Character.toString('‎');
        BidiFormatter.RLM_STRING = Character.toString('‏');
        BidiFormatter.DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, v0);
        BidiFormatter.DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, v0);
    }

    BidiFormatter(boolean arg1, int arg2, TextDirectionHeuristicCompat arg3) {
        super();
        this.mIsRtlContext = arg1;
        this.mFlags = arg2;
        this.mDefaultTextDirectionHeuristicCompat = arg3;
    }

    private static int getEntryDir(CharSequence arg2) {
        return new DirectionalityEstimator(arg2, false).getEntryDir();
    }

    private static int getExitDir(CharSequence arg2) {
        return new DirectionalityEstimator(arg2, false).getExitDir();
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    public static BidiFormatter getInstance(Locale arg1) {
        return new Builder(arg1).build();
    }

    public static BidiFormatter getInstance(boolean arg1) {
        return new Builder(arg1).build();
    }

    public boolean getStereoReset() {
        if((this.mFlags & 2) != 0) {
            return 1;
        }

        return 0;
    }

    public boolean isRtl(CharSequence arg3) {
        return this.mDefaultTextDirectionHeuristicCompat.isRtl(arg3, 0, arg3.length());
    }

    public boolean isRtl(String arg1) {
        return this.isRtl(((CharSequence)arg1));
    }

    public boolean isRtlContext() {
        return this.mIsRtlContext;
    }

    static boolean isRtlLocale(Locale arg1) {
        if(TextUtilsCompat.getLayoutDirectionFromLocale(arg1) == 1) {
            return 1;
        }

        return 0;
    }

    private String markAfter(CharSequence arg3, TextDirectionHeuristicCompat arg4) {
        boolean v4 = arg4.isRtl(arg3, 0, arg3.length());
        if(!this.mIsRtlContext && ((v4) || BidiFormatter.getExitDir(arg3) == 1)) {
            return BidiFormatter.LRM_STRING;
        }

        if((this.mIsRtlContext) && (!v4 || BidiFormatter.getExitDir(arg3) == -1)) {
            return BidiFormatter.RLM_STRING;
        }

        return "";
    }

    private String markBefore(CharSequence arg3, TextDirectionHeuristicCompat arg4) {
        boolean v4 = arg4.isRtl(arg3, 0, arg3.length());
        if(!this.mIsRtlContext && ((v4) || BidiFormatter.getEntryDir(arg3) == 1)) {
            return BidiFormatter.LRM_STRING;
        }

        if((this.mIsRtlContext) && (!v4 || BidiFormatter.getEntryDir(arg3) == -1)) {
            return BidiFormatter.RLM_STRING;
        }

        return "";
    }

    public CharSequence unicodeWrap(CharSequence arg3) {
        return this.unicodeWrap(arg3, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public CharSequence unicodeWrap(CharSequence arg3, TextDirectionHeuristicCompat arg4, boolean arg5) {
        if(arg3 == null) {
            return null;
        }

        boolean v4 = arg4.isRtl(arg3, 0, arg3.length());
        SpannableStringBuilder v0 = new SpannableStringBuilder();
        if((this.getStereoReset()) && (arg5)) {
            TextDirectionHeuristicCompat v1 = v4 ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR;
            v0.append(this.markBefore(arg3, v1));
        }

        if(v4 != this.mIsRtlContext) {
            char v1_1 = v4 ? '‫' : '‪';
            v0.append(v1_1);
            v0.append(arg3);
            v0.append('‬');
        }
        else {
            v0.append(arg3);
        }

        if(arg5) {
            arg4 = v4 ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR;
            v0.append(this.markAfter(arg3, arg4));
        }

        return ((CharSequence)v0);
    }

    public CharSequence unicodeWrap(CharSequence arg2, TextDirectionHeuristicCompat arg3) {
        return this.unicodeWrap(arg2, arg3, true);
    }

    public CharSequence unicodeWrap(CharSequence arg2, boolean arg3) {
        return this.unicodeWrap(arg2, this.mDefaultTextDirectionHeuristicCompat, arg3);
    }

    public String unicodeWrap(String arg3) {
        return this.unicodeWrap(arg3, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public String unicodeWrap(String arg1, TextDirectionHeuristicCompat arg2, boolean arg3) {
        if(arg1 == null) {
            return null;
        }

        return this.unicodeWrap(((CharSequence)arg1), arg2, arg3).toString();
    }

    public String unicodeWrap(String arg2, TextDirectionHeuristicCompat arg3) {
        return this.unicodeWrap(arg2, arg3, true);
    }

    public String unicodeWrap(String arg2, boolean arg3) {
        return this.unicodeWrap(arg2, this.mDefaultTextDirectionHeuristicCompat, arg3);
    }
}


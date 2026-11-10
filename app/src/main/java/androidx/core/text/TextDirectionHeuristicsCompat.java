package androidx.core.text;

import java.nio.CharBuffer;
import java.util.Locale;

public final class TextDirectionHeuristicsCompat {
    class AnyStrong implements TextDirectionAlgorithm {
        static final AnyStrong INSTANCE_RTL;
        private final boolean mLookForRtl;

        static {
            AnyStrong.INSTANCE_RTL = new AnyStrong(true);
        }

        private AnyStrong(boolean arg1) {
            super();
            this.mLookForRtl = arg1;
        }

        public int checkRtl(CharSequence arg5, int arg6, int arg7) {
            arg7 += arg6;
            int v1 = 0;
            while(arg6 < arg7) {
                int v2 = TextDirectionHeuristicsCompat.isRtlText(Character.getDirectionality(arg5.charAt(arg6)));
                if(v2 != 0) {
                    if(v2 != 1) {
                    }
                    else if(!this.mLookForRtl) {
                        return 1;
                    }
                    else {
                        goto label_17;
                    }
                }
                else if(this.mLookForRtl) {
                    return 0;
                }
                else {
                label_17:
                    v1 = 1;
                }

                ++arg6;
            }

            if(v1 != 0) {
                return this.mLookForRtl;
            }

            return 2;
        }
    }

    class FirstStrong implements TextDirectionAlgorithm {
        static final FirstStrong INSTANCE;

        static {
            FirstStrong.INSTANCE = new FirstStrong();
        }

        private FirstStrong() {
            super();
        }

        public int checkRtl(CharSequence arg2, int arg3, int arg4) {
            arg4 += arg3;
            int v1 = 2;
            int v0 = v1;
            while(arg3 < arg4) {
                if(v0 != v1) {
                    return v0;
                }

                v0 = TextDirectionHeuristicsCompat.isRtlTextOrFormat(Character.getDirectionality(arg2.charAt(arg3)));
                ++arg3;
            }

            return v0;
        }
    }

    interface TextDirectionAlgorithm {
        int checkRtl(CharSequence arg1, int arg2, int arg3);
    }

    abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {
        private final TextDirectionAlgorithm mAlgorithm;

        TextDirectionHeuristicImpl(TextDirectionAlgorithm arg1) {
            super();
            this.mAlgorithm = arg1;
        }

        protected abstract boolean defaultIsRtl();

        private boolean doCheck(CharSequence arg2, int arg3, int arg4) {
            int v2 = this.mAlgorithm.checkRtl(arg2, arg3, arg4);
            if(v2 != 0) {
                if(v2 != 1) {
                    return this.defaultIsRtl();
                }

                return 0;
            }

            return 1;
        }

        public boolean isRtl(CharSequence arg2, int arg3, int arg4) {
            if(arg2 != null && arg3 >= 0 && arg4 >= 0 && arg2.length() - arg4 >= arg3) {
                if(this.mAlgorithm == null) {
                    return this.defaultIsRtl();
                }
                else {
                    return this.doCheck(arg2, arg3, arg4);
                }
            }

            throw new IllegalArgumentException();
        }

        public boolean isRtl(char[] arg1, int arg2, int arg3) {
            return this.isRtl(CharBuffer.wrap(arg1), arg2, arg3);
        }
    }

    class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {
        private final boolean mDefaultIsRtl;

        TextDirectionHeuristicInternal(TextDirectionAlgorithm arg1, boolean arg2) {
            super(arg1);
            this.mDefaultIsRtl = arg2;
        }

        protected boolean defaultIsRtl() {
            return this.mDefaultIsRtl;
        }
    }

    class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {
        static final TextDirectionHeuristicLocale INSTANCE;

        static {
            TextDirectionHeuristicLocale.INSTANCE = new TextDirectionHeuristicLocale();
        }

        TextDirectionHeuristicLocale() {
            super(null);
        }

        protected boolean defaultIsRtl() {
            if(TextUtilsCompat.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
                return 1;
            }

            return 0;
        }
    }

    public static final TextDirectionHeuristicCompat ANYRTL_LTR = null;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_LTR = null;
    public static final TextDirectionHeuristicCompat FIRSTSTRONG_RTL = null;
    public static final TextDirectionHeuristicCompat LOCALE = null;
    public static final TextDirectionHeuristicCompat LTR = null;
    public static final TextDirectionHeuristicCompat RTL = null;
    private static final int STATE_FALSE = 1;
    private static final int STATE_TRUE = 0;
    private static final int STATE_UNKNOWN = 2;

    static {
        TextDirectionHeuristicsCompat.LTR = new TextDirectionHeuristicInternal(null, false);
        TextDirectionHeuristicsCompat.RTL = new TextDirectionHeuristicInternal(null, true);
        TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR = new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, false);
        TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL = new TextDirectionHeuristicInternal(FirstStrong.INSTANCE, true);
        TextDirectionHeuristicsCompat.ANYRTL_LTR = new TextDirectionHeuristicInternal(AnyStrong.INSTANCE_RTL, false);
        TextDirectionHeuristicsCompat.LOCALE = TextDirectionHeuristicLocale.INSTANCE;
    }

    private TextDirectionHeuristicsCompat() {
        super();
    }

    static int isRtlText(int arg1) {
        if(arg1 != 0) {
            if(arg1 != 1) {
                int v0 = 2;
                if(arg1 != v0) {
                    return v0;
                }
            }

            return 0;
        }

        return 1;
    }

    static int isRtlTextOrFormat(int arg2) {
        if(arg2 != 0) {
            if(arg2 != 1) {
                int v1 = 2;
                if(arg2 != v1) {
                    switch(arg2) {
                        case 14: 
                        case 15: {
                            return 1;
                        }
                        case 16: 
                        case 17: {
                            return 0;
                        }
                    }

                    return v1;
                }
            }

            return 0;
        }

        return 1;
    }
}


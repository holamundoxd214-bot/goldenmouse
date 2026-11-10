package androidx.constraintlayout.motion.utils;

import android.util.Log;
import java.util.Arrays;

public class Easing {
    class CubicEasing extends Easing {
        private static double d_error = 0.0001;
        private static double error = 0.01;
        double x1;
        double x2;
        double y1;
        double y2;

        static {
        }

        CubicEasing(String arg6) {
            super();
            this.str = arg6;
            int v0 = arg6.indexOf(40);
            int v2 = arg6.indexOf(44, v0);
            this.x1 = Double.parseDouble(arg6.substring(v0 + 1, v2).trim());
            ++v2;
            v0 = arg6.indexOf(44, v2);
            this.y1 = Double.parseDouble(arg6.substring(v2, v0).trim());
            ++v0;
            int v1 = arg6.indexOf(44, v0);
            this.x2 = Double.parseDouble(arg6.substring(v0, v1).trim());
            ++v1;
            this.y2 = Double.parseDouble(arg6.substring(v1, arg6.indexOf(41, v1)).trim());
        }

        public CubicEasing(double arg1, double arg3, double arg5, double arg7) {
            super();
            this.setup(arg1, arg3, arg5, arg7);
        }

        public double get(double arg9) {
            double v0 = 0;
            if(arg9 <= v0) {
                return v0;
            }

            v0 = 1;
            if(arg9 >= v0) {
                return v0;
            }

            v0 = 0.5;
            double v2 = v0;
            double v4;
            for(v4 = v2; v2 > CubicEasing.error; v4 -= v2) {
                v2 *= v0;
                if(this.getX(v4) < arg9) {
                    v4 += v2;
                    continue;
                }
            }

            v0 = v4 - v2;
            double v6 = this.getX(v0);
            v4 += v2;
            v2 = this.getX(v4);
            v0 = this.getY(v0);
            return (this.getY(v4) - v0) * (arg9 - v6) / (v2 - v6) + v0;
        }

        public double getDiff(double arg9) {
            double v0 = 0.5;
            double v2 = v0;
            double v4;
            for(v4 = v2; v2 > CubicEasing.d_error; v4 -= v2) {
                v2 *= v0;
                if(this.getX(v4) < arg9) {
                    v4 += v2;
                    continue;
                }
            }

            arg9 = v4 - v2;
            v4 += v2;
            return (this.getY(v4) - this.getY(arg9)) / (this.getX(v4) - this.getX(arg9));
        }

        private double getDiffX(double arg13) {
            double v2 = 1 - arg13;
            return v2 * 3 * v2 * this.x1 + v2 * 6 * arg13 * (this.x2 - this.x1) + 3 * arg13 * arg13 * (1 - this.x2);
        }

        private double getDiffY(double arg13) {
            double v2 = 1 - arg13;
            return v2 * 3 * v2 * this.y1 + v2 * 6 * arg13 * (this.y2 - this.y1) + 3 * arg13 * arg13 * (1 - this.y2);
        }

        private double getX(double arg7) {
            double v0 = 1 - arg7;
            double v2 = 3 * v0;
            return this.x1 * (v0 * v2 * arg7) + this.x2 * (v2 * arg7 * arg7) + arg7 * arg7 * arg7;
        }

        private double getY(double arg7) {
            double v0 = 1 - arg7;
            double v2 = 3 * v0;
            return this.y1 * (v0 * v2 * arg7) + this.y2 * (v2 * arg7 * arg7) + arg7 * arg7 * arg7;
        }

        void setup(double arg1, double arg3, double arg5, double arg7) {
            this.x1 = arg1;
            this.y1 = arg3;
            this.x2 = arg5;
            this.y2 = arg7;
        }
    }

    private static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final String ACCELERATE_NAME = "accelerate";
    private static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final String DECELERATE_NAME = "decelerate";
    private static final String LINEAR = "cubic(1, 1, 0, 0)";
    private static final String LINEAR_NAME = "linear";
    public static String[] NAMED_EASING = null;
    private static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    private static final String STANDARD_NAME = "standard";
    static Easing sDefault;
    String str;

    static {
        Easing.sDefault = new Easing();
        Easing.NAMED_EASING = new String[]{"standard", "accelerate", "decelerate", "linear"};
    }

    public Easing() {
        super();
        this.str = "identity";
    }

    public double get(double arg1) {
        return arg1;
    }

    public double getDiff(double arg1) {
        return 1;
    }

    public static Easing getInterpolator(String arg2) {
        if(arg2 == null) {
            return null;
        }

        if(arg2.startsWith("cubic")) {
            return new CubicEasing(arg2);
        }

        arg2.hashCode();
        int v1 = -1;
        switch(arg2.hashCode()) {
            case 1312628413: {
                if(!arg2.equals("standard")) {
                    goto label_37;
                }

                v1 = 3;
                break;
            }
            case -1354466595: {
                if(!arg2.equals("accelerate")) {
                    goto label_37;
                }

                v1 = 0;
                break;
            }
            case -1263948740: {
                if(!arg2.equals("decelerate")) {
                    goto label_37;
                }

                v1 = 1;
                break;
            }
            case -1102672091: {
                if(!arg2.equals("linear")) {
                    goto label_37;
                }

                v1 = 2;
                break;
            }
            default: {
                break;
            }
        }

    label_37:
        switch(v1) {
            case 0: {
                goto label_61;
            }
            case 1: {
                goto label_57;
            }
            case 2: {
                goto label_53;
            }
            case 3: {
                goto label_49;
            }
        }

        Log.e("ConstraintSet", "transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(Easing.NAMED_EASING));
        return Easing.sDefault;
    label_49:
        return new CubicEasing("cubic(0.4, 0.0, 0.2, 1)");
    label_53:
        return new CubicEasing("cubic(1, 1, 0, 0)");
    label_57:
        return new CubicEasing("cubic(0.0, 0.0, 0.2, 0.95)");
    label_61:
        return new CubicEasing("cubic(0.4, 0.05, 0.8, 0.7)");
    }

    public String toString() {
        return this.str;
    }
}


package androidx.constraintlayout.motion.utils;

public abstract class CurveFit {
    class Constant extends CurveFit {
        double mTime;
        double[] mValue;

        Constant(double arg1, double[] arg3) {
            super();
            this.mTime = arg1;
            this.mValue = arg3;
        }

        public double getPos(double arg1, int arg3) {
            return this.mValue[arg3];
        }

        public void getPos(double arg1, double[] arg3) {
            System.arraycopy(this.mValue, 0, arg3, 0, this.mValue.length);
        }

        public void getPos(double arg3, float[] arg5) {
            int v3;
            for(v3 = 0; true; ++v3) {
                double[] v4 = this.mValue;
                if(v3 >= v4.length) {
                    return;
                }

                arg5[v3] = ((float)v4[v3]);
            }
        }

        public double getSlope(double arg1, int arg3) {
            return 0;
        }

        public void getSlope(double arg3, double[] arg5) {
            int v3;
            for(v3 = 0; v3 < this.mValue.length; ++v3) {
                arg5[v3] = 0;
            }
        }

        public double[] getTimePoints() {
            return new double[]{this.mTime};
        }
    }

    public static final int CONSTANT = 2;
    public static final int LINEAR = 1;
    public static final int SPLINE;

    public CurveFit() {
        super();
    }

    public static CurveFit get(int arg3, double[] arg4, double[][] arg5) {
        int v2 = 2;
        if(arg4.length == 1) {
            arg3 = v2;
        }

        if(arg3 != 0) {
            if(arg3 != v2) {
                return new LinearCurveFit(arg4, arg5);
            }

            return new Constant(arg4[0], arg5[0]);
        }

        return new MonotonicCurveFit(arg4, arg5);
    }

    public static CurveFit getArc(int[] arg1, double[] arg2, double[][] arg3) {
        return new ArcCurveFit(arg1, arg2, arg3);
    }

    public abstract double getPos(double arg1, int arg2);

    public abstract void getPos(double arg1, double[] arg2);

    public abstract void getPos(double arg1, float[] arg2);

    public abstract double getSlope(double arg1, int arg2);

    public abstract void getSlope(double arg1, double[] arg2);

    public abstract double[] getTimePoints();
}


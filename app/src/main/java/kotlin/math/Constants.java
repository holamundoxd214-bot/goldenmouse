package kotlin.math;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u00058\u0000X\u0081\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u00058\u0000X\u0081\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001A\u00020\u00058\u0000X\u0081\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001A\u00020\u00058\u0000X\u0081\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001A\u00020\u00058\u0000X\u0081\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001A\u00020\u00058\u0000X\u0081\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"Lkotlin/math/Constants;", "", "<init>", "()V", "LN2", "", "epsilon", "taylor_2_bound", "taylor_n_bound", "upper_taylor_2_bound", "upper_taylor_n_bound", "kotlin-stdlib"}, k=1, mv={2, 3, 0}, xi=0x30) final class Constants {
    public static final Constants INSTANCE;
    public static final double LN2;
    public static final double epsilon;
    public static final double taylor_2_bound;
    public static final double taylor_n_bound;
    public static final double upper_taylor_2_bound;
    public static final double upper_taylor_n_bound;

    static {
        Constants.INSTANCE = new Constants();
        Constants.LN2 = Math.log(2);
        double v2 = Math.ulp(1);
        Constants.epsilon = v2;
        v2 = Math.sqrt(v2);
        Constants.taylor_2_bound = v2;
        double v4 = Math.sqrt(v2);
        Constants.taylor_n_bound = v4;
        Constants.upper_taylor_2_bound = 1 / v2;
        Constants.upper_taylor_n_bound = 1 / v4;
    }

    private Constants() {
        super();
    }
}


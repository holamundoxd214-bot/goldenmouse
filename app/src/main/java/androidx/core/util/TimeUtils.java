package androidx.core.util;

import java.io.PrintWriter;

public final class TimeUtils {
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static char[] sFormatStr;
    private static final Object sFormatSync;

    static {
        TimeUtils.sFormatSync = new Object();
        TimeUtils.sFormatStr = new char[24];
    }

    private TimeUtils() {
        super();
    }

    private static int accumField(int arg2, int arg3, boolean arg4, int arg5) {
        int v1 = 3;
        if(arg2 <= 99 && (!arg4 || arg5 < v1)) {
            v1 = 2;
            if(arg2 <= 9 && (!arg4 || arg5 < v1)) {
                if(!arg4) {
                    if(arg2 > 0) {
                    }
                    else {
                        return 0;
                    }
                }

                return arg3 + 1;
            }

            return arg3 + v1;
        }

        return arg3 + v1;
    }

    public static void formatDuration(long arg2, StringBuilder arg4) {
        Object v0 = TimeUtils.sFormatSync;
        __monitor_enter(v0);
        try {
            arg4.append(TimeUtils.sFormatStr, 0, TimeUtils.formatDurationLocked(arg2, 0));
            __monitor_exit(v0);
            return;
        label_9:
            __monitor_exit(v0);
        }
        catch(Throwable v2) {
            goto label_9;
        }

        throw v2;
    }

    public static void formatDuration(long arg2, long arg4, PrintWriter arg6) {
        if(arg2 == 0) {
            arg6.print("--");
            return;
        }

        TimeUtils.formatDuration(arg2 - arg4, arg6, 0);
    }

    public static void formatDuration(long arg2, PrintWriter arg4, int arg5) {
        Object v0 = TimeUtils.sFormatSync;
        __monitor_enter(v0);
        try {
            arg4.print(new String(TimeUtils.sFormatStr, 0, TimeUtils.formatDurationLocked(arg2, arg5)));
            __monitor_exit(v0);
            return;
        label_11:
            __monitor_exit(v0);
        }
        catch(Throwable v2) {
            goto label_11;
        }

        throw v2;
    }

    public static void formatDuration(long arg1, PrintWriter arg3) {
        TimeUtils.formatDuration(arg1, arg3, 0);
    }

    private static int formatDurationLocked(long arg16, int arg18) {
        int v8_1;
        boolean v8;
        int v13;
        int v7;
        int v6;
        char v3_2;
        int v0_1;
        long v0 = arg16;
        int v2 = arg18;
        char[] v3 = TimeUtils.sFormatStr;
        if(v3.length < v2) {
            v3 = new char[v2];
            TimeUtils.sFormatStr = v3;
        }

        char[] v4 = v3;
        int v3_1 = Long.compare(v0, 0);
        char v5 = ' ';
        if(v3_1 == 0) {
            v0_1 = v2 - 1;
            while(v0_1 > 0) {
                v4[0] = v5;
            }

            v4[0] = '0';
            return 1;
        }

        if(v3_1 > 0) {
            v3_2 = '+';
        }
        else {
            v0 = -v0;
            v3_2 = '-';
        }

        int v12 = ((int)(v0 % 1000));
        v0_1 = ((int)Math.floor(((double)(v0 / 1000))));
        int v1 = 86400;
        if(v0_1 > v1) {
            v6 = v0_1 / v1;
            v0_1 -= v1 * v6;
        }
        else {
            v6 = 0;
        }

        if(v0_1 > 3600) {
            v1 = v0_1 / 3600;
            v0_1 -= v1 * 3600;
        }
        else {
            v1 = 0;
        }

        if(v0_1 > 60) {
            v7 = v0_1 / 60;
            v0_1 -= v7 * 60;
            v13 = v7;
        }
        else {
            v13 = 0;
        }

        int v14 = 3;
        int v15 = 2;
        if(v2 != 0) {
            v7 = TimeUtils.accumField(v6, 1, false, 0);
            v8 = v7 > 0 ? true : false;
            v7 += TimeUtils.accumField(v1, 1, v8, v15);
            v8 = v7 > 0 ? true : false;
            v7 += TimeUtils.accumField(v13, 1, v8, v15);
            v8 = v7 > 0 ? true : false;
            v7 += TimeUtils.accumField(v0_1, 1, v8, v15);
            v8_1 = v7 > 0 ? v14 : 0;
            v7 += TimeUtils.accumField(v12, v15, true, v8_1) + 1;
            v8_1 = 0;
            while(v7 < v2) {
                v4[v8_1] = v5;
                ++v8_1;
                ++v7;
            }
        }
        else {
            v8_1 = 0;
        }

        v4[v8_1] = v3_2;
        v7 = v8_1 + 1;
        v2 = v2 != 0 ? 1 : 0;
        v3_1 = TimeUtils.printField(v4, v6, 'd', v7, false, 0);
        char[] v5_1 = v4;
        int v4_1 = v7;
        v8 = v3_1 != v4_1 ? true : false;
        int v9 = v2 != 0 ? v15 : 0;
        char[] v7_1 = v5_1;
        int v5_2 = v1;
        v1 = v4_1;
        v4 = v7_1;
        v7 = TimeUtils.printField(v4, v5_2, 'h', v3_1, v8, v9);
        v8 = v7 != v1 ? true : false;
        v9 = v2 != 0 ? v15 : 0;
        v7 = TimeUtils.printField(v4, v13, 'm', v7, v8, v9);
        v8 = v7 != v1 ? true : false;
        v9 = v2 != 0 ? v15 : 0;
        v7 = TimeUtils.printField(v4, v0_1, 's', v7, v8, v9);
        v9 = v2 == 0 || v7 == v1 ? 0 : v14;
        v0_1 = TimeUtils.printField(v4, v12, 'm', v7, true, v9);
        v4[v0_1] = 's';
        return v0_1 + 1;
    }

    private static int printField(char[] arg2, int arg3, char arg4, int arg5, boolean arg6, int arg7) {
        int v1;
        int v0;
        if(!arg6) {
            if(arg3 > 0) {
            }
            else {
                return arg5;
            }
        }

        if((arg6) && arg7 >= 3 || arg3 > 99) {
            v0 = arg3 / 100;
            arg2[arg5] = ((char)(v0 + 0x30));
            v1 = arg5 + 1;
            arg3 -= v0 * 100;
        }
        else {
            v1 = arg5;
        }

        v0 = 2;
        if((arg6) && arg7 >= v0 || (arg3 > 9 || arg5 != v1)) {
            arg5 = arg3 / 10;
            arg2[v1] = ((char)(arg5 + 0x30));
            ++v1;
            arg3 -= arg5 * 10;
        }

        arg2[v1] = ((char)(arg3 + 0x30));
        arg2[v1 + 1] = arg4;
        return v1 + v0;
    }
}


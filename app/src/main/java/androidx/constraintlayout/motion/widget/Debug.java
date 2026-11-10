package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources$NotFoundException;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Debug {
    public Debug() {
        super();
    }

    public static void dumpLayoutParams(ViewGroup$LayoutParams arg7, String arg8) {
        StackTraceElement v0 = new Throwable().getStackTrace()[1];
        arg8 = ".(" + v0.getFileName() + ":" + v0.getLineNumber() + ") " + arg8 + "  ";
        System.out.println(" >>>>>>>>>>>>>>>>>>. dump " + arg8 + "  " + arg7.getClass().getName());
        Field[] v0_1 = arg7.getClass().getFields();
        int v1 = 0;
        while(v1 < v0_1.length) {
            Field v2 = v0_1[v1];
            try {
                Object v3 = v2.get(arg7);
                String v2_1 = v2.getName();
                if(!v2_1.contains("To")) {
                }
                else if(v3.toString().equals("-1")) {
                }
                else {
                    System.out.println(arg8 + "       " + v2_1 + " " + v3);
                }

                goto label_60;
            }
            catch(IllegalAccessException ) {
            label_60:
                ++v1;
                continue;
            }
        }

        System.out.println(" <<<<<<<<<<<<<<<<< dump " + arg8);
    }

    public static void dumpLayoutParams(ViewGroup arg11, String arg12) {
        StackTraceElement v0 = new Throwable().getStackTrace()[1];
        String v0_1 = ".(" + v0.getFileName() + ":" + v0.getLineNumber() + ") " + arg12 + "  ";
        int v1 = arg11.getChildCount();
        System.out.println(arg12 + " children " + v1);
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            View v3 = arg11.getChildAt(v2);
            System.out.println(v0_1 + "     " + Debug.getName(v3));
            ViewGroup$LayoutParams v3_1 = v3.getLayoutParams();
            Field[] v4 = v3_1.getClass().getFields();
            int v5 = 0;
            while(v5 < v4.length) {
                Field v6 = v4[v5];
                try {
                    Object v7 = v6.get(v3_1);
                    if(!v6.getName().contains("To")) {
                    }
                    else if(v7.toString().equals("-1")) {
                    }
                    else {
                        System.out.println(v0_1 + "       " + v6.getName() + " " + v7);
                    }

                    goto label_75;
                }
                catch(IllegalAccessException ) {
                label_75:
                    ++v5;
                    continue;
                }
            }
        }
    }

    public static void dumpPoc(Object arg11) {
        StackTraceElement v0 = new Throwable().getStackTrace()[1];
        String v0_1 = ".(" + v0.getFileName() + ":" + v0.getLineNumber() + ")";
        Class v1 = arg11.getClass();
        String v4 = "------------- ";
        String v5 = " --------------------";
        System.out.println(v0_1 + v4 + v1.getName() + v5);
        Field[] v2 = v1.getFields();
        int v3 = 0;
        while(v3 < v2.length) {
            Field v6 = v2[v3];
            try {
                Object v7 = v6.get(arg11);
                if(!v6.getName().startsWith("layout_constraint")) {
                }
                else {
                    if(((v7 instanceof Integer)) && (v7.toString().equals("-1"))) {
                        goto label_82;
                    }

                    if(((v7 instanceof Integer)) && (v7.toString().equals("0"))) {
                        goto label_82;
                    }

                    if(((v7 instanceof Float)) && (v7.toString().equals("1.0"))) {
                        goto label_82;
                    }

                    if(((v7 instanceof Float)) && (v7.toString().equals("0.5"))) {
                        goto label_82;
                    }

                    System.out.println(v0_1 + "    " + v6.getName() + " " + v7);
                }

                goto label_82;
            }
            catch(IllegalAccessException ) {
            label_82:
                ++v3;
                continue;
            }
        }

        System.out.println(v0_1 + v4 + v1.getSimpleName() + v5);
    }

    public static String getActionType(MotionEvent arg5) {
        int v5 = arg5.getAction();
        Field[] v0 = MotionEvent.class.getFields();
        int v1 = 0;
        while(v1 < v0.length) {
            Field v2 = v0[v1];
            try {
                if((Modifier.isStatic(v2.getModifiers())) && (v2.getType().equals(Integer.TYPE)) && v2.getInt(null) == v5) {
                    String v5_1 = v2.getName();
                    return v5_1;
                }

                goto label_19;
            }
            catch(IllegalAccessException ) {
            label_19:
                ++v1;
                continue;
            }
        }

        return "---";
    }

    public static String getCallFrom(int arg2) {
        StackTraceElement v2 = new Throwable().getStackTrace()[arg2 + 2];
        return ".(" + v2.getFileName() + ":" + v2.getLineNumber() + ")";
    }

    public static String getLoc() {
        StackTraceElement v0 = new Throwable().getStackTrace()[1];
        return ".(" + v0.getFileName() + ":" + v0.getLineNumber() + ") " + v0.getMethodName() + "()";
    }

    public static String getLocation() {
        StackTraceElement v0 = new Throwable().getStackTrace()[1];
        return ".(" + v0.getFileName() + ":" + v0.getLineNumber() + ")";
    }

    public static String getLocation2() {
        StackTraceElement v0 = new Throwable().getStackTrace()[2];
        return ".(" + v0.getFileName() + ":" + v0.getLineNumber() + ")";
    }

    public static String getName(View arg1) {
        try {
            return arg1.getContext().getResources().getResourceEntryName(arg1.getId());
        }
        catch(Exception ) {
            return "UNKNOWN";
        }
    }

    public static String getName(Context arg1, int arg2) {
        if(arg2 == -1) {
            return "UNKNOWN";
        }

        try {
            return arg1.getResources().getResourceEntryName(arg2);
        }
        catch(Exception ) {
            return "?" + arg2;
        }
    }

    public static String getName(Context arg5, int[] arg6) {
        StringBuilder v0_1;
        int v1;
        String v0;
        try {
            v0 = arg6.length + "[";
            v1 = 0;
            while(true) {
            label_8:
                if(v1 >= arg6.length) {
                    goto label_39;
                }

                v0_1 = new StringBuilder().append(v0);
                break;
            }
        }
        catch(Exception v5) {
            goto label_49;
        }

        String v2 = " ";
        if(v1 == 0) {
            try {
                String v3 = "";
                goto label_18;
            label_17:
                v3 = v2;
            label_18:
                v0 = v0_1.append(v3).toString();
                try {
                    v2 = arg5.getResources().getResourceEntryName(arg6[v1]);
                }
                catch(Resources$NotFoundException ) {
                    v2 = "? " + arg6[v1] + v2;
                }

                v0 = v0 + v2;
                ++v1;
                goto label_8;
            label_39:
                return v0 + "]";
            }
            catch(Exception v5) {
            label_49:
                Log.v("DEBUG", v5.toString());
                return "UNKNOWN";
            }
        }
        else {
            goto label_17;
        }

        goto label_18;
    }

    public static String getState(MotionLayout arg1, int arg2) {
        if(arg2 == -1) {
            return "UNDEFINED";
        }

        return arg1.getContext().getResources().getResourceEntryName(arg2);
    }

    public static void logStack(String arg6, String arg7, int arg8) {
        StackTraceElement[] v0 = new Throwable().getStackTrace();
        int v2 = 1;
        arg8 = Math.min(arg8, v0.length - 1);
        String v1 = " ";
        String v3 = v1;
        while(v2 <= arg8) {
            String v4 = ".(" + v0[v2].getFileName() + ":" + v0[v2].getLineNumber() + ") " + v0[v2].getMethodName();
            v3 = v3 + v1;
            Log.v(arg6, arg7 + v3 + v4 + v3);
            ++v2;
        }
    }

    public static void printStack(String arg7, int arg8) {
        StackTraceElement[] v0 = new Throwable().getStackTrace();
        int v2 = 1;
        arg8 = Math.min(arg8, v0.length - 1);
        String v1 = " ";
        String v3 = v1;
        while(v2 <= arg8) {
            String v4 = ".(" + v0[v2].getFileName() + ":" + v0[v2].getLineNumber() + ") ";
            v3 = v3 + v1;
            System.out.println(arg7 + v3 + v4 + v3);
            ++v2;
        }
    }
}


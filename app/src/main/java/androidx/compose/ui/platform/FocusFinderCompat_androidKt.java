package androidx.compose.ui.platform;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1={"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u001E\u0010\u0000\u001A\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\u0002\u001A\"\u0010\u0005\u001A\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u00012\u0006\u0010\u0007\u001A\u00020\u0004H\u0002\u001A*\u0010\b\u001A\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u00012\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000B0\nH\u0002\u001A,\u0010\f\u001A\u0004\u0018\u00010\u0001*\u00020\u00012\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000B0\n2\b\u0010\r\u001A\u0004\u0018\u00010\u0001H\u0002\u001A,\u0010\u000E\u001A\u00020\u000F*\u00020\u00012\u0016\u0010\u0010\u001A\u0012\u0012\u0004\u0012\u00020\u00010\u0011j\b\u0012\u0004\u0012\u00020\u0001`\u00122\u0006\u0010\u0003\u001A\u00020\u0004H\u0002\u001A,\u0010\u000E\u001A\u00020\u000F*\u00020\u00012\u0016\u0010\u0010\u001A\u0012\u0012\u0004\u0012\u00020\u00010\u0011j\b\u0012\u0004\u0012\u00020\u0001`\u00122\u0006\u0010\u0013\u001A\u00020\u000BH\u0002¨\u0006\u0014"}, d2={"findUserSetNextFocus", "Landroid/view/View;", "root", "direction", "", "findViewInsideOutShouldExist", "start", "id", "findViewByPredicateInsideOut", "predicate", "Lkotlin/Function1;", "", "findViewByPredicateTraversal", "childToSkip", "addFocusableViews", "", "views", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "inTouchMode", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FocusFinderCompat_androidKt {
    public static final void access$addFocusableViews(View arg0, ArrayList arg1, int arg2) {
        FocusFinderCompat_androidKt.addFocusableViews(arg0, arg1, arg2);
    }

    public static final View access$findUserSetNextFocus(View arg0, View arg1, int arg2) {
        return FocusFinderCompat_androidKt.findUserSetNextFocus(arg0, arg1, arg2);
    }

    public static final View access$findViewInsideOutShouldExist(View arg0, View arg1, int arg2) {
        return FocusFinderCompat_androidKt.findViewInsideOutShouldExist(arg0, arg1, arg2);
    }

    private static final void addFocusableViews(View arg1, ArrayList arg2, int arg3) {
        arg1.addFocusables(arg2, arg3, arg1.isInTouchMode());
    }

    private static final void addFocusableViews(View arg10, ArrayList arg11, boolean arg12) {
        int v0;
        int v1 = 0;
        boolean v2 = true;
        if(arg10.getVisibility() != 0 || !arg10.isFocusable() || !arg10.isEnabled() || arg10.getWidth() <= 0 || arg10.getHeight() <= 0) {
        label_17:
            v0 = 0;
        }
        else {
            if((arg12) && !arg10.isFocusableInTouchMode()) {
                goto label_17;
            }

            v0 = 1;
        }

        if((arg10 instanceof ViewGroup)) {
            int v3 = arg11.size();
            View v4 = arg10;
            int v5 = ((ViewGroup)v4).getDescendantFocusability() == 0x20000 ? 1 : 0;
            if(v0 != 0 && v5 != 0) {
                arg11.add(arg10);
            }

            if(((ViewGroup)v4).getDescendantFocusability() != 0x60000) {
                int v6 = ((ViewGroup)v4).getChildCount();
                View[] v7 = new View[v6];
                int v8;
                for(v8 = 0; v8 < v6; ++v8) {
                    v7[v8] = ((ViewGroup)v4).getChildAt(v8);
                }

                FocusSorter v8_1 = FocusSorter.INSTANCE;
                if(((ViewGroup)v4).getLayoutDirection() == 1) {
                }
                else {
                    v2 = false;
                }

                v8_1.sort(v7, ((ViewGroup)v4), v2);
                while(v1 < v6) {
                    FocusFinderCompat_androidKt.addFocusableViews(v7[v1], arg11, arg12);
                    ++v1;
                }
            }

            if(v0 == 0) {
                return;
            }

            if(v5 != 0) {
                return;
            }

            if(v3 != arg11.size()) {
                return;
            }

            ((Collection)arg11).add(arg10);
            return;
        }
        else {
            if(v0 == 0) {
                return;
            }

            ((Collection)arg11).add(arg10);
        }
    }

    private static final View findUserSetNextFocus(View arg3, View arg4, int arg5) {
        int v1 = -1;
        View v2 = null;
        if(arg5 != 1) {
            if(arg5 != 2) {
                return v2;
            }

            arg5 = arg3.getNextFocusForwardId();
            if(arg5 == v1) {
                return v2;
            }

            return FocusFinderCompat_androidKt.findViewInsideOutShouldExist(arg4, arg3, arg5);
        }

        if(arg3.getId() == v1) {
            return v2;
        }

        return FocusFinderCompat_androidKt.findViewByPredicateInsideOut(arg4, arg3, new FocusFinderCompat_androidKt$findUserSetNextFocus$1(arg4, arg3));
    }

    private static final View findViewByPredicateInsideOut(View arg4, View arg5, Function1 arg6) {
        View v0 = null;
        View v1 = v0;
        while(true) {
            v1 = FocusFinderCompat_androidKt.findViewByPredicateTraversal(arg5, arg6, v1);
            if(v1 == null) {
                if(arg5 == arg4) {
                }
                else {
                    ViewParent v1_1 = arg5.getParent();
                    if(v1_1 != null) {
                        if(!(v1_1 instanceof View)) {
                        }
                        else {
                            ViewParent v3 = v1_1;
                            v1 = arg5;
                            ViewParent v5 = v3;
                            continue;
                        }
                    }

                    return v0;
                }
            }

            return v1;
        }

        return v0;
    }

    private static final View findViewByPredicateTraversal(View arg3, Function1 arg4, View arg5) {
        if(arg4.invoke(arg3).booleanValue()) {
            return arg3;
        }

        if((arg3 instanceof ViewGroup)) {
            int v0 = ((ViewGroup)arg3).getChildCount();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                View v2 = ((ViewGroup)arg3).getChildAt(v1);
                if(v2 != arg5) {
                    v2 = FocusFinderCompat_androidKt.findViewByPredicateTraversal(v2, arg4, arg5);
                    if(v2 != null) {
                        return v2;
                    }
                }
            }
        }

        return null;
    }

    private static final View findViewInsideOutShouldExist(View arg1, View arg2, int arg3) {
        return FocusFinderCompat_androidKt.findViewByPredicateInsideOut(arg1, arg2, new FocusFinderCompat_androidKt$findViewInsideOutShouldExist$1(arg3));
    }
}


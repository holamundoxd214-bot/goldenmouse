package androidx.compose.ui.focus;

import android.graphics.Rect;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\u001A\u0012\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0000\u001A\u0015\u0010\b\u001A\u0004\u0018\u00010\u0007*\u00020\u0005H\u0000¢\u0006\u0004\b\t\u0010\n\u001A\u0015\u0010\u0004\u001A\u0004\u0018\u00010\u0005*\u00020\u000BH\u0000¢\u0006\u0004\b\f\u0010\r\u001A\u0012\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0010\u001A\u00020\u0007H\u0000\u001A\u0014\u0010\u0011\u001A\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0013H\u0000\u001A%\u0010\u0015\u001A\u00020\u0016*\u00020\u00132\b\u0010\u0017\u001A\u0004\u0018\u00010\u00072\b\u0010\u0018\u001A\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0002\u0010\u0019\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2={"tempCoordinates", "", "tempRect", "Landroid/graphics/Rect;", "toFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "androidDirection", "", "toAndroidFocusDirection", "toAndroidFocusDirection-3ESFkO8", "(I)Ljava/lang/Integer;", "Landroidx/compose/ui/input/key/KeyEvent;", "toFocusDirection-ZmokQxo", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/focus/FocusDirection;", "toLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "androidLayoutDirection", "calculateFocusRectRelativeTo", "Landroidx/compose/ui/geometry/Rect;", "Landroid/view/View;", "view", "requestInteropFocus", "", "direction", "rect", "(Landroid/view/View;Ljava/lang/Integer;Landroid/graphics/Rect;)Z", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class FocusInteropUtils_androidKt {
    private static final int[] tempCoordinates;
    private static final Rect tempRect;

    static {
        FocusInteropUtils_androidKt.tempCoordinates = new int[2];
        FocusInteropUtils_androidKt.tempRect = new Rect();
    }

    public static final androidx.compose.ui.geometry.Rect calculateFocusRectRelativeTo(View arg5, View arg6) {
        int[] v0 = FocusInteropUtils_androidKt.tempCoordinates;
        arg5.getLocationInWindow(v0);
        int v2 = v0[0];
        int v4 = v0[1];
        arg6.getLocationInWindow(v0);
        float v6 = ((float)(v2 - v0[0]));
        float v0_1 = ((float)(v4 - v0[1]));
        Rect v1 = FocusInteropUtils_androidKt.tempRect;
        arg5.getFocusedRect(v1);
        return new androidx.compose.ui.geometry.Rect((((float)v1.left)) + v6, (((float)v1.top)) + v0_1, v6 + (((float)v1.left)) + (((float)v1.width())), v0_1 + (((float)v1.top)) + (((float)v1.height())));
    }

    public static final boolean requestInteropFocus(View arg3, Integer arg4, Rect arg5) {
        if(arg4 == null) {
            return arg3.requestFocus();
        }

        if(!(arg3 instanceof ViewGroup)) {
            return arg3.requestFocus(arg4.intValue(), arg5);
        }

        View v0 = arg3;
        if(((ViewGroup)v0).isFocused()) {
            return 1;
        }

        if((((ViewGroup)v0).isFocusable()) && !((ViewGroup)v0).hasFocus()) {
            return ((ViewGroup)v0).requestFocus(arg4.intValue(), arg5);
        }

        if((arg3 instanceof AndroidComposeView)) {
            return ((AndroidComposeView)arg3).requestFocus(arg4.intValue(), arg5);
        }

        if(arg5 != null) {
            arg3 = FocusFinder.getInstance().findNextFocusFromRect(((ViewGroup)v0), arg5, arg4.intValue());
            if(arg3 != null) {
                return arg3.requestFocus(arg4.intValue(), arg5);
            }

            return ((ViewGroup)v0).requestFocus(arg4.intValue(), arg5);
        }

        View v5 = ((ViewGroup)v0).hasFocus() ? ((ViewGroup)v0).findFocus() : null;
        v5 = FocusFinder.getInstance().findNextFocus(((ViewGroup)v0), v5, arg4.intValue());
        if(v5 != null) {
            return v5.requestFocus(arg4.intValue());
        }

        return arg3.requestFocus(arg4.intValue());
    }

    public static final Integer toAndroidFocusDirection-3ESFkO8(int arg1) {
        if(FocusDirection.equals-impl0(arg1, FocusDirection.Companion.getUp-dhqQ-8s())) {
            return Integer.valueOf(33);
        }

        if(FocusDirection.equals-impl0(arg1, FocusDirection.Companion.getDown-dhqQ-8s())) {
            return Integer.valueOf(130);
        }

        if(FocusDirection.equals-impl0(arg1, FocusDirection.Companion.getLeft-dhqQ-8s())) {
            return Integer.valueOf(17);
        }

        if(FocusDirection.equals-impl0(arg1, FocusDirection.Companion.getRight-dhqQ-8s())) {
            return Integer.valueOf(66);
        }

        if(FocusDirection.equals-impl0(arg1, FocusDirection.Companion.getNext-dhqQ-8s())) {
            return Integer.valueOf(2);
        }

        if(FocusDirection.equals-impl0(arg1, FocusDirection.Companion.getPrevious-dhqQ-8s())) {
            return Integer.valueOf(1);
        }

        return null;
    }

    public static final FocusDirection toFocusDirection(int arg1) {
        if(arg1 != 1) {
            if(arg1 != 2) {
                if(arg1 != 17) {
                    if(arg1 != 33) {
                        if(arg1 != 66) {
                            if(arg1 != 130) {
                                return null;
                            }

                            return FocusDirection.box-impl(FocusDirection.Companion.getDown-dhqQ-8s());
                        }

                        return FocusDirection.box-impl(FocusDirection.Companion.getRight-dhqQ-8s());
                    }

                    return FocusDirection.box-impl(FocusDirection.Companion.getUp-dhqQ-8s());
                }

                return FocusDirection.box-impl(FocusDirection.Companion.getLeft-dhqQ-8s());
            }

            return FocusDirection.box-impl(FocusDirection.Companion.getNext-dhqQ-8s());
        }

        return FocusDirection.box-impl(FocusDirection.Companion.getPrevious-dhqQ-8s());
    }

    public static final FocusDirection toFocusDirection-ZmokQxo(KeyEvent arg4) {
        long v0 = KeyEvent_androidKt.getKey-ZmokQxo(arg4);
        if(Key.equals-impl0(v0, Key.Companion.getNavigatePrevious-EK5gGoQ())) {
            return FocusDirection.box-impl(FocusDirection.Companion.getPrevious-dhqQ-8s());
        }

        if(Key.equals-impl0(v0, Key.Companion.getNavigateNext-EK5gGoQ())) {
            return FocusDirection.box-impl(FocusDirection.Companion.getNext-dhqQ-8s());
        }

        if(Key.equals-impl0(v0, Key.Companion.getTab-EK5gGoQ())) {
            int v4 = KeyEvent_androidKt.isShiftPressed-ZmokQxo(arg4) ? FocusDirection.Companion.getPrevious-dhqQ-8s() : FocusDirection.Companion.getNext-dhqQ-8s();
            return FocusDirection.box-impl(v4);
        }

        if(Key.equals-impl0(v0, Key.Companion.getDirectionRight-EK5gGoQ())) {
            return FocusDirection.box-impl(FocusDirection.Companion.getRight-dhqQ-8s());
        }

        if(Key.equals-impl0(v0, Key.Companion.getDirectionLeft-EK5gGoQ())) {
            return FocusDirection.box-impl(FocusDirection.Companion.getLeft-dhqQ-8s());
        }

        if(!Key.equals-impl0(v0, Key.Companion.getDirectionUp-EK5gGoQ())) {
            if(Key.equals-impl0(v0, Key.Companion.getPageUp-EK5gGoQ())) {
            }
            else {
                if(!Key.equals-impl0(v0, Key.Companion.getDirectionDown-EK5gGoQ())) {
                    if(Key.equals-impl0(v0, Key.Companion.getPageDown-EK5gGoQ())) {
                    }
                    else {
                        if(!Key.equals-impl0(v0, Key.Companion.getDirectionCenter-EK5gGoQ()) && !Key.equals-impl0(v0, Key.Companion.getEnter-EK5gGoQ())) {
                            if(Key.equals-impl0(v0, Key.Companion.getNumPadEnter-EK5gGoQ())) {
                            }
                            else {
                                if(!Key.equals-impl0(v0, Key.Companion.getBack-EK5gGoQ())) {
                                    if(Key.equals-impl0(v0, Key.Companion.getEscape-EK5gGoQ())) {
                                    }
                                    else {
                                        return null;
                                    }
                                }

                                return FocusDirection.box-impl(FocusDirection.Companion.getExit-dhqQ-8s());
                            }
                        }

                        return FocusDirection.box-impl(FocusDirection.Companion.getEnter-dhqQ-8s());
                    }
                }

                return FocusDirection.box-impl(FocusDirection.Companion.getDown-dhqQ-8s());
            }
        }

        return FocusDirection.box-impl(FocusDirection.Companion.getUp-dhqQ-8s());
    }

    public static final LayoutDirection toLayoutDirection(int arg1) {
        if(arg1 != 0) {
            if(arg1 != 1) {
                return null;
            }

            return LayoutDirection.Rtl;
        }

        return LayoutDirection.Ltr;
    }
}


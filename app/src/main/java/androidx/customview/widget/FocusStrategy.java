package androidx.customview.widget;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class FocusStrategy {
    public interface BoundsAdapter {
        void obtainBounds(Object arg1, Rect arg2);
    }

    public interface CollectionAdapter {
        Object get(Object arg1, int arg2);

        int size(Object arg1);
    }

    class SequentialComparator implements Comparator {
        private final BoundsAdapter mAdapter;
        private final boolean mIsLayoutRtl;
        private final Rect mTemp1;
        private final Rect mTemp2;

        SequentialComparator(boolean arg2, BoundsAdapter arg3) {
            super();
            this.mTemp1 = new Rect();
            this.mTemp2 = new Rect();
            this.mIsLayoutRtl = arg2;
            this.mAdapter = arg3;
        }

        public int compare(Object arg5, Object arg6) {
            Rect v0 = this.mTemp1;
            Rect v1 = this.mTemp2;
            this.mAdapter.obtainBounds(arg5, v0);
            this.mAdapter.obtainBounds(arg6, v1);
            int v2 = -1;
            if(v0.top < v1.top) {
                return v2;
            }

            if(v0.top > v1.top) {
                return 1;
            }

            if(v0.left < v1.left) {
                if(this.mIsLayoutRtl) {
                    return 1;
                }

                return v2;
            }

            if(v0.left > v1.left) {
                if(this.mIsLayoutRtl) {
                    return v2;
                }

                return 1;
            }

            if(v0.bottom < v1.bottom) {
                return v2;
            }

            if(v0.bottom > v1.bottom) {
                return 1;
            }

            if(v0.right < v1.right) {
                if(this.mIsLayoutRtl) {
                    return 1;
                }

                return v2;
            }

            if(v0.right > v1.right) {
                if(this.mIsLayoutRtl) {
                    return v2;
                }

                return 1;
            }

            return 0;
        }
    }

    private FocusStrategy() {
        super();
    }

    private static boolean beamBeats(int arg3, Rect arg4, Rect arg5, Rect arg6) {
        boolean v0 = FocusStrategy.beamsOverlap(arg3, arg4, arg5);
        if(!FocusStrategy.beamsOverlap(arg3, arg4, arg6)) {
            if(!v0) {
            }
            else if(!FocusStrategy.isToDirectionOf(arg3, arg4, arg6)) {
                return 1;
            }
            else {
                if(arg3 != 17) {
                    if(arg3 == 66) {
                    }
                    else if(FocusStrategy.majorAxisDistance(arg3, arg4, arg5) < FocusStrategy.majorAxisDistanceToFarEdge(arg3, arg4, arg6)) {
                        return 1;
                    }
                    else {
                        return 0;
                    }
                }

                return 1;
            }
        }

        return 0;
    }

    private static boolean beamsOverlap(int arg3, Rect arg4, Rect arg5) {
        if(arg3 != 17) {
            if(arg3 != 33) {
                if(arg3 == 66) {
                    goto label_23;
                }
                else if(arg3 == 130) {
                }
                else {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
            }

            if(arg5.right >= arg4.left && arg5.left <= arg4.right) {
                return 1;
            }

            return 0;
        }

    label_23:
        if(arg5.bottom >= arg4.top && arg5.top <= arg4.bottom) {
            return 1;
        }

        return 0;
    }

    public static Object findNextFocusInAbsoluteDirection(Object arg7, CollectionAdapter arg8, BoundsAdapter arg9, Object arg10, Rect arg11, int arg12) {
        Rect v0 = new Rect(arg11);
        int v2 = 0;
        if(arg12 == 17) {
            v0.offset(arg11.width() + 1, 0);
        }
        else if(arg12 == 33) {
            v0.offset(0, arg11.height() + 1);
        }
        else if(arg12 == 66) {
            v0.offset(-(arg11.width() + 1), 0);
        }
        else if(arg12 == 130) {
            v0.offset(0, -(arg11.height() + 1));
        }
        else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }

        int v1 = arg8.size(arg7);
        Rect v3 = new Rect();
        Object v4 = null;
        while(v2 < v1) {
            Object v5 = arg8.get(arg7, v2);
            if(v5 == arg10) {
            }
            else {
                arg9.obtainBounds(v5, v3);
                if(FocusStrategy.isBetterCandidate(arg12, arg11, v3, v0)) {
                    v0.set(v3);
                    v4 = v5;
                }
            }

            ++v2;
        }

        return v4;
    }

    public static Object findNextFocusInRelativeDirection(Object arg4, CollectionAdapter arg5, BoundsAdapter arg6, Object arg7, int arg8, boolean arg9, boolean arg10) {
        int v0 = arg5.size(arg4);
        ArrayList v1 = new ArrayList(v0);
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1.add(arg5.get(arg4, v2));
        }

        Collections.sort(((List)v1), new SequentialComparator(arg9, arg6));
        if(arg8 != 1) {
            if(arg8 == 2) {
                return FocusStrategy.getNextFocusable(arg7, v1, arg10);
            }

            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
        }

        return FocusStrategy.getPreviousFocusable(arg7, v1, arg10);
    }

    private static Object getNextFocusable(Object arg1, ArrayList arg2, boolean arg3) {
        int v0 = arg2.size();
        int v1 = arg1 == null ? -1 : arg2.lastIndexOf(arg1);
        ++v1;
        if(v1 < v0) {
            return arg2.get(v1);
        }

        if((arg3) && v0 > 0) {
            return arg2.get(0);
        }

        return null;
    }

    private static Object getPreviousFocusable(Object arg1, ArrayList arg2, boolean arg3) {
        int v0 = arg2.size();
        int v1 = arg1 == null ? v0 : arg2.indexOf(arg1);
        --v1;
        if(v1 >= 0) {
            return arg2.get(v1);
        }

        if((arg3) && v0 > 0) {
            return arg2.get(v0 - 1);
        }

        return null;
    }

    private static int getWeightedDistanceFor(int arg1, int arg2) {
        return arg1 * 13 * arg1 + arg2 * arg2;
    }

    private static boolean isBetterCandidate(int arg3, Rect arg4, Rect arg5, Rect arg6) {
        if(!FocusStrategy.isCandidate(arg4, arg5, arg3)) {
            return 0;
        }

        if(!FocusStrategy.isCandidate(arg4, arg6, arg3)) {
            return 1;
        }

        if(FocusStrategy.beamBeats(arg3, arg4, arg5, arg6)) {
            return 1;
        }

        if(FocusStrategy.beamBeats(arg3, arg4, arg6, arg5)) {
            return 0;
        }

        if(FocusStrategy.getWeightedDistanceFor(FocusStrategy.majorAxisDistance(arg3, arg4, arg5), FocusStrategy.minorAxisDistance(arg3, arg4, arg5)) < FocusStrategy.getWeightedDistanceFor(FocusStrategy.majorAxisDistance(arg3, arg4, arg6), FocusStrategy.minorAxisDistance(arg3, arg4, arg6))) {
            return 1;
        }

        return 0;
    }

    private static boolean isCandidate(Rect arg3, Rect arg4, int arg5) {
        if(arg5 != 17) {
            if(arg5 != 33) {
                if(arg5 != 66) {
                    if(arg5 == 130) {
                        if((arg3.top < arg4.top || arg3.bottom <= arg4.top) && arg3.bottom < arg4.bottom) {
                            return 1;
                        }

                        return 0;
                    }

                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }

                if((arg3.left < arg4.left || arg3.right <= arg4.left) && arg3.right < arg4.right) {
                    return 1;
                }

                return 0;
            }

            if((arg3.bottom > arg4.bottom || arg3.top >= arg4.bottom) && arg3.top > arg4.top) {
                return 1;
            }

            return 0;
        }

        if((arg3.right > arg4.right || arg3.left >= arg4.right) && arg3.left > arg4.left) {
            return 1;
        }

        return 0;
    }

    private static boolean isToDirectionOf(int arg3, Rect arg4, Rect arg5) {
        if(arg3 != 17) {
            if(arg3 != 33) {
                if(arg3 != 66) {
                    if(arg3 == 130) {
                        if(arg4.bottom <= arg5.top) {
                            return 1;
                        }

                        return 0;
                    }

                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }

                if(arg4.right <= arg5.left) {
                    return 1;
                }

                return 0;
            }

            if(arg4.top >= arg5.bottom) {
                return 1;
            }

            return 0;
        }

        if(arg4.left >= arg5.right) {
            return 1;
        }

        return 0;
    }

    private static int majorAxisDistance(int arg1, Rect arg2, Rect arg3) {
        return Math.max(0, FocusStrategy.majorAxisDistanceRaw(arg1, arg2, arg3));
    }

    private static int majorAxisDistanceRaw(int arg1, Rect arg2, Rect arg3) {
        int v2;
        if(arg1 == 17) {
            arg1 = arg2.left;
            v2 = arg3.right;
        }
        else if(arg1 == 33) {
            arg1 = arg2.top;
            v2 = arg3.bottom;
        }
        else if(arg1 == 66) {
            arg1 = arg3.left;
            v2 = arg2.right;
        }
        else if(arg1 == 130) {
            arg1 = arg3.top;
            v2 = arg2.bottom;
        }
        else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }

        return arg1 - v2;
    }

    private static int majorAxisDistanceToFarEdge(int arg1, Rect arg2, Rect arg3) {
        return Math.max(1, FocusStrategy.majorAxisDistanceToFarEdgeRaw(arg1, arg2, arg3));
    }

    private static int majorAxisDistanceToFarEdgeRaw(int arg1, Rect arg2, Rect arg3) {
        int v2;
        if(arg1 == 17) {
            arg1 = arg2.left;
            v2 = arg3.left;
        }
        else if(arg1 == 33) {
            arg1 = arg2.top;
            v2 = arg3.top;
        }
        else if(arg1 == 66) {
            arg1 = arg3.right;
            v2 = arg2.right;
        }
        else if(arg1 == 130) {
            arg1 = arg3.bottom;
            v2 = arg2.bottom;
        }
        else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }

        return arg1 - v2;
    }

    private static int minorAxisDistance(int arg1, Rect arg2, Rect arg3) {
        if(arg1 != 17) {
            if(arg1 != 33) {
                if(arg1 == 66) {
                    goto label_24;
                }
                else if(arg1 == 130) {
                }
                else {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
            }

            return Math.abs(arg2.left + arg2.width() / 2 - (arg3.left + arg3.width() / 2));
        }

    label_24:
        return Math.abs(arg2.top + arg2.height() / 2 - (arg3.top + arg3.height() / 2));
    }
}


package com.google.android.material.carousel;

import androidx.core.math.MathUtils;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class KeylineStateList {
    private static final int NO_INDEX = -1;
    private final KeylineState defaultState;
    private final float endShiftRange;
    private final List endStateSteps;
    private final float[] endStateStepsInterpolationPoints;
    private final float startShiftRange;
    private final List startStateSteps;
    private final float[] startStateStepsInterpolationPoints;

    private KeylineStateList(KeylineState arg4, List arg5, List arg6) {
        super();
        this.defaultState = arg4;
        this.startStateSteps = Collections.unmodifiableList(arg5);
        this.endStateSteps = Collections.unmodifiableList(arg6);
        float v0 = arg5.get(arg5.size() - 1).getFirstKeyline().loc - arg4.getFirstKeyline().loc;
        this.startShiftRange = v0;
        float v4 = arg4.getLastKeyline().loc - arg6.get(arg6.size() - 1).getLastKeyline().loc;
        this.endShiftRange = v4;
        this.startStateStepsInterpolationPoints = KeylineStateList.getStateStepInterpolationPoints(v0, arg5, true);
        this.endStateStepsInterpolationPoints = KeylineStateList.getStateStepInterpolationPoints(v4, arg6, false);
    }

    private KeylineState closestStateStepFromInterpolation(List arg1, float arg2, float[] arg3) {
        float[] v0 = KeylineStateList.getStateStepsRange(arg1, arg2, arg3);
        if(v0[0] > 0.5f) {
            return arg1.get(((int)v0[2]));
        }

        return arg1.get(((int)v0[1]));
    }

    private static int findFirstIndexAfterLastFocalKeylineWithMask(KeylineState arg2, float arg3) {
        int v0;
        for(v0 = arg2.getLastFocalKeylineIndex(); v0 < arg2.getKeylines().size(); ++v0) {
            if(arg3 == arg2.getKeylines().get(v0).mask) {
                return v0;
            }
        }

        return arg2.getKeylines().size() - 1;
    }

    private static int findFirstNonAnchorKeylineIndex(KeylineState arg2) {
        int v0;
        for(v0 = 0; v0 < arg2.getKeylines().size(); ++v0) {
            if(!arg2.getKeylines().get(v0).isAnchor) {
                return v0;
            }
        }

        return -1;
    }

    private static int findLastIndexBeforeFirstFocalKeylineWithMask(KeylineState arg2, float arg3) {
        int v0;
        for(v0 = arg2.getFirstFocalKeylineIndex() - 1; v0 >= 0; --v0) {
            if(arg3 == arg2.getKeylines().get(v0).mask) {
                return v0;
            }
        }

        return 0;
    }

    private static int findLastNonAnchorKeylineIndex(KeylineState arg2) {
        int v0;
        for(v0 = arg2.getKeylines().size() - 1; v0 >= 0; --v0) {
            if(!arg2.getKeylines().get(v0).isAnchor) {
                return v0;
            }
        }

        return -1;
    }

    static KeylineStateList from(Carousel arg2, KeylineState arg3) {
        return new KeylineStateList(arg3, KeylineStateList.getStateStepsStart(arg2, arg3), KeylineStateList.getStateStepsEnd(arg2, arg3));
    }

    KeylineState getDefaultState() {
        return this.defaultState;
    }

    KeylineState getEndState() {
        return this.endStateSteps.get(this.endStateSteps.size() - 1);
    }

    Map getKeylineStateForPositionMap(int arg11, int arg12, int arg13, boolean arg14) {
        int v5;
        float v0 = this.defaultState.getItemSize();
        HashMap v1 = new HashMap();
        int v3 = 0;
        int v4 = 0;
        while(true) {
            v5 = -1;
            if(v3 >= arg11) {
                break;
            }

            int v7 = arg14 ? arg11 - v3 - 1 : v3;
            float v8 = (((float)v7)) * v0;
            if(arg14) {
            }
            else {
                v5 = 1;
            }

            if(v8 * (((float)v5)) > (((float)arg13)) - this.endShiftRange || v3 >= arg11 - this.endStateSteps.size()) {
                ((Map)v1).put(Integer.valueOf(v7), this.endStateSteps.get(MathUtils.clamp(v4, 0, this.endStateSteps.size() - 1)));
                ++v4;
            }

            ++v3;
        }

        arg13 = arg11 - 1;
        v3 = 0;
        while(arg13 >= 0) {
            v4 = arg14 ? arg11 - arg13 - 1 : arg13;
            float v7_1 = (((float)v4)) * v0;
            int v8_1 = arg14 ? v5 : 1;
            if(v7_1 * (((float)v8_1)) < (((float)arg12)) + this.startShiftRange || arg13 < this.startStateSteps.size()) {
                ((Map)v1).put(Integer.valueOf(v4), this.startStateSteps.get(MathUtils.clamp(v3, 0, this.startStateSteps.size() - 1)));
                ++v3;
            }

            --arg13;
        }

        return ((Map)v1);
    }

    public KeylineState getShiftedState(float arg2, float arg3, float arg4) {
        return this.getShiftedState(arg2, arg3, arg4, false);
    }

    KeylineState getShiftedState(float arg6, float arg7, float arg8, boolean arg9) {
        float[] v8;
        List v7;
        float v0 = this.startShiftRange + arg7;
        float v1 = arg8 - this.endShiftRange;
        float v4 = 1f;
        if(Float.compare(arg6, v0) < 0) {
            arg6 = AnimationUtils.lerp(v4, 0f, arg7, v0, arg6);
            v7 = this.startStateSteps;
            v8 = this.startStateStepsInterpolationPoints;
        }
        else if(arg6 > v1) {
            arg6 = AnimationUtils.lerp(0f, v4, v1, arg8, arg6);
            v7 = this.endStateSteps;
            v8 = this.endStateStepsInterpolationPoints;
        }
        else {
            goto label_21;
        }

        if(arg9) {
            return this.closestStateStepFromInterpolation(v7, arg6, v8);
        }

        return KeylineStateList.lerp(v7, arg6, v8);
    label_21:
        return this.defaultState;
    }

    KeylineState getStartState() {
        return this.startStateSteps.get(this.startStateSteps.size() - 1);
    }

    private static float[] getStateStepInterpolationPoints(float arg6, List arg7, boolean arg8) {
        int v0 = arg7.size();
        float[] v1 = new float[v0];
        int v2;
        for(v2 = 1; v2 < v0; ++v2) {
            int v3 = v2 - 1;
            Object v4 = arg7.get(v3);
            Object v5 = arg7.get(v2);
            float v5_1 = arg8 ? ((KeylineState)v5).getFirstKeyline().loc - ((KeylineState)v4).getFirstKeyline().loc : ((KeylineState)v4).getLastKeyline().loc - ((KeylineState)v5).getLastKeyline().loc;
            v5_1 /= arg6;
            float v3_1 = v2 == v0 - 1 ? 1f : v1[v3] + v5_1;
            v1[v2] = v3_1;
        }

        return v1;
    }

    private static List getStateStepsEnd(Carousel arg13, KeylineState arg14) {
        ArrayList v0 = new ArrayList();
        ((List)v0).add(arg14);
        int v2 = KeylineStateList.findLastNonAnchorKeylineIndex(arg14);
        if(!KeylineStateList.isLastFocalItemVisibleAtRightOfContainer(arg13, arg14)) {
            if(v2 == -1) {
            }
            else {
                int v8 = v2 - arg14.getLastFocalKeylineIndex();
                int v13 = arg13.isHorizontal() ? arg13.getContainerWidth() : arg13.getContainerHeight();
                float v7 = ((float)v13);
                float v13_1 = arg14.getFirstKeyline().locOffset - arg14.getFirstKeyline().maskedItemSize / 2f;
                float v1 = 0f;
                if(v8 <= 0 && arg14.getLastFocalKeyline().cutoff > 0f) {
                    ((List)v0).add(KeylineStateList.shiftKeylinesAndCreateKeylineState(arg14, v13_1 - arg14.getLastFocalKeyline().cutoff, v7));
                    return ((List)v0);
                }

                int v10 = 0;
                while(v10 < v8) {
                    Object v3 = ((List)v0).get(((List)v0).size() - 1);
                    int v4 = v2 - v10;
                    float v11 = v1 + arg14.getKeylines().get(v4).cutoff;
                    ++v4;
                    int v1_1 = v4 < arg14.getKeylines().size() ? KeylineStateList.findLastIndexBeforeFirstFocalKeylineWithMask(((KeylineState)v3), arg14.getKeylines().get(v4).mask) + 1 : 0;
                    ((List)v0).add(KeylineStateList.moveKeylineAndCreateKeylineState(v3, v2, v1_1, v13_1 - v11, arg14.getFirstFocalKeylineIndex() + v10 + 1, arg14.getLastFocalKeylineIndex() + v10 + 1, v7));
                    ++v10;
                    v1 = v11;
                }
            }
        }

        return ((List)v0);
    }

    private static float[] getStateStepsRange(List arg7, float arg8, float[] arg9) {
        int v7 = arg7.size();
        float v1 = arg9[0];
        int v3 = 1;
        while(true) {
            int v4 = 3;
            if(v3 >= v7) {
                break;
            }

            float v5 = arg9[v3];
            if(arg8 <= v5) {
                arg8 = AnimationUtils.lerp(0f, 1f, v1, v5, arg8);
                float[] v1_1 = new float[v4];
                v1_1[0] = arg8;
                v1_1[1] = ((float)(v3 - 1));
                v1_1[2] = ((float)v3);
                return v1_1;
            }

            ++v3;
            v1 = v5;
        }

        return new float[]{0f, 0f, 0f};
    }

    private static List getStateStepsStart(Carousel arg12, KeylineState arg13) {
        ArrayList v0 = new ArrayList();
        ((List)v0).add(arg13);
        int v2 = KeylineStateList.findFirstNonAnchorKeylineIndex(arg13);
        if(!KeylineStateList.isFirstFocalItemAtLeftOfContainer(arg13)) {
            if(v2 == -1) {
            }
            else {
                int v8 = arg13.getFirstFocalKeylineIndex() - v2;
                int v12 = arg12.isHorizontal() ? arg12.getContainerWidth() : arg12.getContainerHeight();
                float v7 = ((float)v12);
                float v12_1 = arg13.getFirstKeyline().locOffset - arg13.getFirstKeyline().maskedItemSize / 2f;
                float v1 = 0f;
                if(v8 <= 0 && arg13.getFirstFocalKeyline().cutoff > 0f) {
                    ((List)v0).add(KeylineStateList.shiftKeylinesAndCreateKeylineState(arg13, v12_1 + arg13.getFirstFocalKeyline().cutoff, v7));
                    return ((List)v0);
                }

                int v9 = 0;
                while(v9 < v8) {
                    Object v3 = ((List)v0).get(((List)v0).size() - 1);
                    int v4 = v2 + v9;
                    int v5 = arg13.getKeylines().size() - 1;
                    float v10 = v1 + arg13.getKeylines().get(v4).cutoff;
                    --v4;
                    if(v4 >= 0) {
                        v5 = KeylineStateList.findFirstIndexAfterLastFocalKeylineWithMask(((KeylineState)v3), arg13.getKeylines().get(v4).mask) - 1;
                    }

                    ((List)v0).add(KeylineStateList.moveKeylineAndCreateKeylineState(v3, v2, v5, v12_1 + v10, arg13.getFirstFocalKeylineIndex() - v9 - 1, arg13.getLastFocalKeylineIndex() - v9 - 1, v7));
                    ++v9;
                    v1 = v10;
                }
            }
        }

        return ((List)v0);
    }

    private static boolean isFirstFocalItemAtLeftOfContainer(KeylineState arg3) {
        if(arg3.getFirstFocalKeyline().locOffset - arg3.getFirstFocalKeyline().maskedItemSize / 2f >= 0f && arg3.getFirstFocalKeyline() == arg3.getFirstNonAnchorKeyline()) {
            return 1;
        }

        return 0;
    }

    private static boolean isLastFocalItemVisibleAtRightOfContainer(Carousel arg3, KeylineState arg4) {
        int v0 = arg3.getContainerHeight();
        if(arg3.isHorizontal()) {
            v0 = arg3.getContainerWidth();
        }

        if(arg4.getLastFocalKeyline().locOffset + arg4.getLastFocalKeyline().maskedItemSize / 2f <= (((float)v0)) && arg4.getLastFocalKeyline() == arg4.getLastNonAnchorKeyline()) {
            return 1;
        }

        return 0;
    }

    private static KeylineState lerp(List arg1, float arg2, float[] arg3) {
        float[] v2 = KeylineStateList.getStateStepsRange(arg1, arg2, arg3);
        return KeylineState.lerp(arg1.get(((int)v2[1])), arg1.get(((int)v2[2])), v2[0]);
    }

    private static KeylineState moveKeylineAndCreateKeylineState(KeylineState arg8, int arg9, int arg10, float arg11, int arg12, int arg13, float arg14) {
        ArrayList v0 = new ArrayList(arg8.getKeylines());
        ((List)v0).add(arg10, ((List)v0).remove(arg9));
        Builder v1 = new Builder(arg8.getItemSize(), arg14);
        for(arg9 = 0; arg9 < ((List)v0).size(); ++arg9) {
            Object v10 = ((List)v0).get(arg9);
            float v2 = arg11 + ((Keyline)v10).maskedItemSize / 2f;
            boolean v5 = arg9 < arg12 || arg9 > arg13 ? false : true;
            v1.addKeyline(v2, ((Keyline)v10).mask, ((Keyline)v10).maskedItemSize, v5, ((Keyline)v10).isAnchor, ((Keyline)v10).cutoff);
            arg11 += ((Keyline)v10).maskedItemSize;
        }

        return v1.build();
    }

    private static KeylineState shiftKeylinesAndCreateKeylineState(KeylineState arg7, float arg8, float arg9) {
        return KeylineStateList.moveKeylineAndCreateKeylineState(arg7, 0, 0, arg8, arg7.getFirstFocalKeylineIndex(), arg7.getLastFocalKeylineIndex(), arg9);
    }
}


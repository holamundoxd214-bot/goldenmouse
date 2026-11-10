package androidx.constraintlayout.motion.widget;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R$id;
import java.util.HashMap;

public class DesignTool implements ProxyInterface {
    private static final boolean DEBUG = false;
    private static final String TAG = "DesignTool";
    static final HashMap allAttributes;
    static final HashMap allMargins;
    private String mLastEndState;
    private int mLastEndStateId;
    private String mLastStartState;
    private int mLastStartStateId;
    private final MotionLayout mMotionLayout;
    private MotionScene mSceneCache;

    static {
        HashMap v0 = new HashMap();
        DesignTool.allAttributes = v0;
        HashMap v1 = new HashMap();
        DesignTool.allMargins = v1;
        Integer v2 = Integer.valueOf(4);
        v0.put(Pair.create(v2, v2), "layout_constraintBottom_toBottomOf");
        Integer v3 = Integer.valueOf(3);
        v0.put(Pair.create(v2, v3), "layout_constraintBottom_toTopOf");
        v0.put(Pair.create(v3, v2), "layout_constraintTop_toBottomOf");
        v0.put(Pair.create(v3, v3), "layout_constraintTop_toTopOf");
        v2 = Integer.valueOf(6);
        v0.put(Pair.create(v2, v2), "layout_constraintStart_toStartOf");
        Integer v7 = Integer.valueOf(7);
        v0.put(Pair.create(v2, v7), "layout_constraintStart_toEndOf");
        v0.put(Pair.create(v7, v2), "layout_constraintEnd_toStartOf");
        v0.put(Pair.create(v7, v7), "layout_constraintEnd_toEndOf");
        v2 = Integer.valueOf(1);
        v0.put(Pair.create(v2, v2), "layout_constraintLeft_toLeftOf");
        Integer v11 = Integer.valueOf(2);
        v0.put(Pair.create(v2, v11), "layout_constraintLeft_toRightOf");
        v0.put(Pair.create(v11, v11), "layout_constraintRight_toRightOf");
        v0.put(Pair.create(v11, v2), "layout_constraintRight_toLeftOf");
        v2 = Integer.valueOf(5);
        v0.put(Pair.create(v2, v2), "layout_constraintBaseline_toBaselineOf");
        v1.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        v1.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        v1.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        v1.put("layout_constraintTop_toTopOf", "layout_marginTop");
        v1.put("layout_constraintStart_toStartOf", "layout_marginStart");
        v1.put("layout_constraintStart_toEndOf", "layout_marginStart");
        v1.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        v1.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        v1.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        v1.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        v1.put("layout_constraintRight_toRightOf", "layout_marginRight");
        v1.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    public DesignTool(MotionLayout arg2) {
        super();
        this.mLastStartState = null;
        this.mLastEndState = null;
        this.mLastStartStateId = -1;
        this.mLastEndStateId = -1;
        this.mMotionLayout = arg2;
    }

    private static void Connect(int arg8, ConstraintSet arg9, View arg10, HashMap arg11, int arg12, int arg13) {
        Object v0 = DesignTool.allAttributes.get(Pair.create(Integer.valueOf(arg12), Integer.valueOf(arg13)));
        Object v1 = arg11.get(v0);
        if(v1 != null) {
            v0 = DesignTool.allMargins.get(v0);
            arg8 = v0 != null ? DesignTool.GetPxFromDp(arg8, arg11.get(v0)) : 0;
            arg9.connect(arg10.getId(), arg12, Integer.parseInt(((String)v1)), arg13, arg8);
        }
    }

    private static int GetPxFromDp(int arg3, String arg4) {
        if(arg4 == null) {
            return 0;
        }

        int v1 = arg4.indexOf(100);
        if(v1 == -1) {
            return 0;
        }

        return ((int)((((float)(Integer.valueOf(arg4.substring(0, v1)).intValue() * arg3))) / 160f));
    }

    private static void SetAbsolutePositions(int arg2, ConstraintSet arg3, View arg4, HashMap arg5) {
        Object v0 = arg5.get("layout_editor_absoluteX");
        if(v0 != null) {
            arg3.setEditorAbsoluteX(arg4.getId(), DesignTool.GetPxFromDp(arg2, ((String)v0)));
        }

        Object v5 = arg5.get("layout_editor_absoluteY");
        if(v5 != null) {
            arg3.setEditorAbsoluteY(arg4.getId(), DesignTool.GetPxFromDp(arg2, ((String)v5)));
        }
    }

    private static void SetBias(ConstraintSet arg2, View arg3, HashMap arg4, int arg5) {
        String v1 = arg5 == 1 ? "layout_constraintVertical_bias" : "layout_constraintHorizontal_bias";
        Object v4 = arg4.get(v1);
        if(v4 != null) {
            if(arg5 == 0) {
                arg2.setHorizontalBias(arg3.getId(), Float.parseFloat(((String)v4)));
                return;
            }
            else if(arg5 == 1) {
                arg2.setVerticalBias(arg3.getId(), Float.parseFloat(((String)v4)));
            }
        }
    }

    private static void SetDimensions(int arg1, ConstraintSet arg2, View arg3, HashMap arg4, int arg5) {
        String v0 = arg5 == 1 ? "layout_height" : "layout_width";
        Object v4 = arg4.get(v0);
        if(v4 != null) {
            arg1 = !((String)v4).equalsIgnoreCase("wrap_content") ? DesignTool.GetPxFromDp(arg1, ((String)v4)) : -2;
            if(arg5 == 0) {
                arg2.constrainWidth(arg3.getId(), arg1);
                return;
            }

            arg2.constrainHeight(arg3.getId(), arg1);
        }
    }

    public int designAccess(int arg2, String arg3, Object arg4, float[] arg5, int arg6, float[] arg7, int arg8) {
        int v1;
        int v5 = -1;
        int[] v6 = null;
        if(arg2 == 0) {
            MotionController v4 = ((MotionController)v6);
        }
        else if(this.mMotionLayout.mScene == null) {
            return v5;
        }
        else {
            if(arg4 != null) {
                arg4 = this.mMotionLayout.mFrameArrayList.get(arg4);
                if(arg4 == null) {
                    return v5;
                }

                goto label_14;
            }

            return v5;
        }

    label_14:
        if(arg2 != 0) {
            if(arg2 != 1) {
                if(arg2 != 2) {
                    if(arg2 != 3) {
                        return v5;
                    }

                    this.mMotionLayout.mScene.getDuration();
                    return ((MotionController)arg4).getAttributeValues(arg3, arg7, arg8);
                }

                v1 = this.mMotionLayout.mScene.getDuration() / 16;
                ((MotionController)arg4).buildKeyFrames(arg7, v6);
                return v1;
            }

            v1 = this.mMotionLayout.mScene.getDuration() / 16;
            ((MotionController)arg4).buildPath(arg7, v1);
            return v1;
        }

        return 1;
    }

    public void disableAutoTransition(boolean arg1) {
        this.mMotionLayout.disableAutoTransition(arg1);
    }

    public void dumpConstraintSet(String arg5) {
        if(this.mMotionLayout.mScene == null) {
            this.mMotionLayout.mScene = this.mSceneCache;
        }

        int v0 = this.mMotionLayout.lookUpConstraintId(arg5);
        System.out.println(" dumping  " + arg5 + " (" + v0 + ")");
        try {
            this.mMotionLayout.mScene.getConstraintSet(v0).dump(this.mMotionLayout.mScene, new int[0]);
            return;
        }
        catch(Exception v4) {
            v4.printStackTrace();
            return;
        }
    }

    public int getAnimationKeyFrames(Object arg2, float[] arg3) {
        if(this.mMotionLayout.mScene == null) {
            return -1;
        }

        int v0 = this.mMotionLayout.mScene.getDuration() / 16;
        Object v1 = this.mMotionLayout.mFrameArrayList.get(arg2);
        if(v1 == null) {
            return 0;
        }

        ((MotionController)v1).buildKeyFrames(arg3, null);
        return v0;
    }

    public int getAnimationPath(Object arg2, float[] arg3, int arg4) {
        if(this.mMotionLayout.mScene == null) {
            return -1;
        }

        Object v1 = this.mMotionLayout.mFrameArrayList.get(arg2);
        if(v1 == null) {
            return 0;
        }

        ((MotionController)v1).buildPath(arg3, arg4);
        return arg4;
    }

    public void getAnimationRectangles(Object arg2, float[] arg3) {
        Object v1;
        int v0;
        if(this.mMotionLayout.mScene == null) {
        }
        else {
            v0 = this.mMotionLayout.mScene.getDuration() / 16;
            v1 = this.mMotionLayout.mFrameArrayList.get(arg2);
            if(v1 == null) {
                return;
            }

            goto label_13;
        }

        return;
    label_13:
        ((MotionController)v1).buildRectangles(arg3, v0);
    }

    public String getEndState() {
        int v0 = this.mMotionLayout.getEndState();
        if(this.mLastEndStateId == v0) {
            return this.mLastEndState;
        }

        String v1 = this.mMotionLayout.getConstraintSetNames(v0);
        if(v1 != null) {
            this.mLastEndState = v1;
            this.mLastEndStateId = v0;
        }

        return v1;
    }

    public int getKeyFrameInfo(Object arg1, int arg2, int[] arg3) {
        Object v0 = this.mMotionLayout.mFrameArrayList.get(arg1);
        if(v0 == null) {
            return 0;
        }

        return ((MotionController)v0).getKeyFrameInfo(arg2, arg3);
    }

    public float getKeyFramePosition(Object arg1, int arg2, float arg3, float arg4) {
        return this.mMotionLayout.mFrameArrayList.get(arg1).getKeyFrameParameter(arg2, arg3, arg4);
    }

    public int getKeyFramePositions(Object arg1, int[] arg2, float[] arg3) {
        Object v0 = this.mMotionLayout.mFrameArrayList.get(arg1);
        if(v0 == null) {
            return 0;
        }

        return ((MotionController)v0).getkeyFramePositions(arg2, arg3);
    }

    public Object getKeyframe(int arg2, int arg3, int arg4) {
        if(this.mMotionLayout.mScene == null) {
            return null;
        }

        return this.mMotionLayout.mScene.getKeyFrame(this.mMotionLayout.getContext(), arg2, arg3, arg4);
    }

    public Object getKeyframe(Object arg2, int arg3, int arg4) {
        if(this.mMotionLayout.mScene == null) {
            return null;
        }

        return this.mMotionLayout.mScene.getKeyFrame(this.mMotionLayout.getContext(), arg3, ((View)arg2).getId(), arg4);
    }

    public Object getKeyframeAtLocation(Object arg2, float arg3, float arg4) {
        if(this.mMotionLayout.mScene == null) {
            return Integer.valueOf(-1);
        }

        Object v0 = null;
        if(arg2 != null) {
            Object v1 = this.mMotionLayout.mFrameArrayList.get(arg2);
            if(v1 == null) {
                return v0;
            }

            ViewParent v2 = ((View)arg2).getParent();
            return ((MotionController)v1).getPositionKeyframe(((ViewGroup)v2).getWidth(), ((ViewGroup)v2).getHeight(), arg3, arg4);
        }

        return v0;
    }

    public Boolean getPositionKeyframe(Object arg9, Object arg10, float arg11, float arg12, String[] arg13, float[] arg14) {
        if((arg9 instanceof KeyPositionBase)) {
            this.mMotionLayout.mFrameArrayList.get(arg10).positionKeyframe(arg10, arg9, arg11, arg12, arg13, arg14);
            this.mMotionLayout.rebuildScene();
            this.mMotionLayout.mInTransition = true;
            return Boolean.valueOf(true);
        }

        return Boolean.valueOf(false);
    }

    public float getProgress() {
        return this.mMotionLayout.getProgress();
    }

    public String getStartState() {
        int v0 = this.mMotionLayout.getStartState();
        if(this.mLastStartStateId == v0) {
            return this.mLastStartState;
        }

        String v1 = this.mMotionLayout.getConstraintSetNames(v0);
        if(v1 != null) {
            this.mLastStartState = v1;
            this.mLastStartStateId = v0;
        }

        return this.mMotionLayout.getConstraintSetNames(v0);
    }

    public String getState() {
        if(this.mLastStartState != null && this.mLastEndState != null) {
            float v0 = this.getProgress();
            if(v0 <= 0.01f) {
                return this.mLastStartState;
            }
            else if(v0 >= 0.99f) {
                return this.mLastEndState;
            }
        }

        return this.mLastStartState;
    }

    public long getTransitionTimeMs() {
        return this.mMotionLayout.getTransitionTimeMs();
    }

    public boolean isInTransition() {
        if(this.mLastStartState != null && this.mLastEndState != null) {
            return 1;
        }

        return 0;
    }

    public void setAttributes(int arg7, String arg8, Object arg9, Object arg10) {
        Object v2 = arg9;
        Object v3 = arg10;
        int v8 = this.mMotionLayout.lookUpConstraintId(arg8);
        ConstraintSet v1 = this.mMotionLayout.mScene.getConstraintSet(v8);
        if(v1 == null) {
            return;
        }

        v1.clear(((View)v2).getId());
        DesignTool.SetDimensions(arg7, v1, ((View)v2), ((HashMap)v3), 0);
        DesignTool.SetDimensions(arg7, v1, ((View)v2), ((HashMap)v3), 1);
        DesignTool.Connect(arg7, v1, ((View)v2), ((HashMap)v3), 6, 6);
        DesignTool.Connect(arg7, v1, ((View)v2), ((HashMap)v3), 6, 7);
        DesignTool.Connect(arg7, v1, ((View)v2), ((HashMap)v3), 7, 7);
        DesignTool.Connect(arg7, v1, ((View)v2), ((HashMap)v3), 7, 6);
        DesignTool.Connect(arg7, v1, ((View)v2), ((HashMap)v3), 1, 1);
        DesignTool.Connect(arg7, v1, ((View)v2), ((HashMap)v3), 1, 2);
        DesignTool.Connect(arg7, v1, ((View)v2), ((HashMap)v3), 2, 2);
        DesignTool.Connect(arg7, v1, ((View)v2), ((HashMap)v3), 2, 1);
        DesignTool.Connect(arg7, v1, ((View)v2), ((HashMap)v3), 3, 3);
        DesignTool.Connect(arg7, v1, ((View)v2), ((HashMap)v3), 3, 4);
        DesignTool.Connect(arg7, v1, ((View)v2), ((HashMap)v3), 4, 3);
        DesignTool.Connect(arg7, v1, ((View)v2), ((HashMap)v3), 4, 4);
        DesignTool.Connect(arg7, v1, ((View)v2), ((HashMap)v3), 5, 5);
        DesignTool.SetBias(v1, ((View)v2), ((HashMap)v3), 0);
        DesignTool.SetBias(v1, ((View)v2), ((HashMap)v3), 1);
        DesignTool.SetAbsolutePositions(arg7, v1, ((View)v2), ((HashMap)v3));
        this.mMotionLayout.updateState(v8, v1);
        this.mMotionLayout.requestLayout();
    }

    public void setKeyFrame(Object arg2, int arg3, String arg4, Object arg5) {
        if(this.mMotionLayout.mScene != null) {
            this.mMotionLayout.mScene.setKeyframe(((View)arg2), arg3, arg4, arg5);
            this.mMotionLayout.mTransitionGoalPosition = (((float)arg3)) / 100f;
            this.mMotionLayout.mTransitionLastPosition = 0f;
            this.mMotionLayout.rebuildScene();
            this.mMotionLayout.evaluate(true);
        }
    }

    public boolean setKeyFramePosition(Object arg3, int arg4, int arg5, float arg6, float arg7) {
        if(this.mMotionLayout.mScene != null) {
            Object v4 = this.mMotionLayout.mFrameArrayList.get(arg3);
            arg5 = ((int)(this.mMotionLayout.mTransitionPosition * 100f));
            if(v4 != null && (this.mMotionLayout.mScene.hasKeyFramePosition(((View)arg3), arg5))) {
                float v0 = ((MotionController)v4).getKeyFrameParameter(2, arg6, arg7);
                float v4_1 = ((MotionController)v4).getKeyFrameParameter(5, arg6, arg7);
                this.mMotionLayout.mScene.setKeyframe(((View)arg3), arg5, "motion:percentX", Float.valueOf(v0));
                this.mMotionLayout.mScene.setKeyframe(((View)arg3), arg5, "motion:percentY", Float.valueOf(v4_1));
                this.mMotionLayout.rebuildScene();
                this.mMotionLayout.evaluate(true);
                this.mMotionLayout.invalidate();
                return 1;
            }
        }

        return 0;
    }

    public void setKeyframe(Object arg2, String arg3, Object arg4) {
        if((arg2 instanceof Key)) {
            ((Key)arg2).setValue(arg3, arg4);
            this.mMotionLayout.rebuildScene();
            this.mMotionLayout.mInTransition = true;
        }
    }

    public void setState(String arg4) {
        if(arg4 == null) {
            arg4 = "motion_base";
        }

        if(this.mLastStartState == arg4) {
            return;
        }

        this.mLastStartState = arg4;
        this.mLastEndState = null;
        if(this.mMotionLayout.mScene == null) {
            this.mMotionLayout.mScene = this.mSceneCache;
        }

        int v4 = arg4 != null ? this.mMotionLayout.lookUpConstraintId(arg4) : id.motion_base;
        this.mLastStartStateId = v4;
        if(v4 != 0) {
            int v0 = this.mMotionLayout.getStartState();
            MotionLayout v1 = this.mMotionLayout;
            if(v4 == v0) {
                v1.setProgress(0f);
            }
            else {
                v0 = v1.getEndState();
                v1 = this.mMotionLayout;
                float v2 = 1f;
                if(v4 == v0) {
                    v1.setProgress(v2);
                }
                else {
                    v1.transitionToState(v4);
                    this.mMotionLayout.setProgress(v2);
                }
            }
        }

        this.mMotionLayout.requestLayout();
    }

    public void setToolPosition(float arg3) {
        if(this.mMotionLayout.mScene == null) {
            this.mMotionLayout.mScene = this.mSceneCache;
        }

        this.mMotionLayout.setProgress(arg3);
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.requestLayout();
        this.mMotionLayout.invalidate();
    }

    public void setTransition(String arg4, String arg5) {
        if(this.mMotionLayout.mScene == null) {
            this.mMotionLayout.mScene = this.mSceneCache;
        }

        int v0 = this.mMotionLayout.lookUpConstraintId(arg4);
        int v1 = this.mMotionLayout.lookUpConstraintId(arg5);
        this.mMotionLayout.setTransition(v0, v1);
        this.mLastStartStateId = v0;
        this.mLastEndStateId = v1;
        this.mLastStartState = arg4;
        this.mLastEndState = arg5;
    }

    public void setViewDebug(Object arg2, int arg3) {
        arg2 = this.mMotionLayout.mFrameArrayList.get(arg2);
        if(arg2 != null) {
            ((MotionController)arg2).setDrawPath(arg3);
            this.mMotionLayout.invalidate();
        }
    }
}


package androidx.transition;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Scene {
    private Context mContext;
    private Runnable mEnterAction;
    private Runnable mExitAction;
    private View mLayout;
    private int mLayoutId;
    private ViewGroup mSceneRoot;

    public Scene(ViewGroup arg2) {
        super();
        this.mLayoutId = -1;
        this.mSceneRoot = arg2;
    }

    private Scene(ViewGroup arg1, int arg2, Context arg3) {
        super();
        this.mContext = arg3;
        this.mSceneRoot = arg1;
        this.mLayoutId = arg2;
    }

    public Scene(ViewGroup arg2, View arg3) {
        super();
        this.mLayoutId = -1;
        this.mSceneRoot = arg2;
        this.mLayout = arg3;
    }

    public void enter() {
        if(this.mLayoutId > 0 || this.mLayout != null) {
            this.getSceneRoot().removeAllViews();
            if(this.mLayoutId > 0) {
                LayoutInflater.from(this.mContext).inflate(this.mLayoutId, this.mSceneRoot);
            }
            else {
                this.mSceneRoot.addView(this.mLayout);
            }
        }

        Runnable v0 = this.mEnterAction;
        if(v0 != null) {
            v0.run();
        }

        Scene.setCurrentScene(this.mSceneRoot, this);
    }

    public void exit() {
        if(Scene.getCurrentScene(this.mSceneRoot) == this) {
            Runnable v1 = this.mExitAction;
            if(v1 != null) {
                v1.run();
            }
        }
    }

    public static Scene getCurrentScene(ViewGroup arg1) {
        return arg1.getTag(id.transition_current_scene);
    }

    public static Scene getSceneForLayout(ViewGroup arg2, int arg3, Context arg4) {
        SparseArray v0_1;
        Object v0 = arg2.getTag(id.transition_scene_layoutid_cache);
        if(v0 == null) {
            v0_1 = new SparseArray();
            arg2.setTag(id.transition_scene_layoutid_cache, v0_1);
        }

        Object v1 = v0_1.get(arg3);
        if(v1 != null) {
            return ((Scene)v1);
        }

        Scene v1_1 = new Scene(arg2, arg3, arg4);
        v0_1.put(arg3, v1_1);
        return v1_1;
    }

    public ViewGroup getSceneRoot() {
        return this.mSceneRoot;
    }

    boolean isCreatedFromLayoutResource() {
        if(this.mLayoutId > 0) {
            return 1;
        }

        return 0;
    }

    static void setCurrentScene(ViewGroup arg1, Scene arg2) {
        arg1.setTag(id.transition_current_scene, arg2);
    }

    public void setEnterAction(Runnable arg1) {
        this.mEnterAction = arg1;
    }

    public void setExitAction(Runnable arg1) {
        this.mExitAction = arg1;
    }
}


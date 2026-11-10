package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class StateSet {
    class State {
        int mConstraintID;
        int mId;
        boolean mIsLayout;
        ArrayList mVariants;

        public State(Context arg6, XmlPullParser arg7) {
            super();
            this.mVariants = new ArrayList();
            this.mConstraintID = -1;
            int v0 = 0;
            this.mIsLayout = false;
            TypedArray v7 = arg6.obtainStyledAttributes(Xml.asAttributeSet(arg7), styleable.State);
            int v1 = v7.getIndexCount();
            while(v0 < v1) {
                int v2 = v7.getIndex(v0);
                if(v2 == styleable.State_android_id) {
                    this.mId = v7.getResourceId(v2, this.mId);
                }
                else if(v2 == styleable.State_constraints) {
                    this.mConstraintID = v7.getResourceId(v2, this.mConstraintID);
                    String v2_1 = arg6.getResources().getResourceTypeName(this.mConstraintID);
                    arg6.getResources().getResourceName(this.mConstraintID);
                    if("layout".equals(v2_1)) {
                        this.mIsLayout = true;
                    }
                }

                ++v0;
            }

            v7.recycle();
        }

        void add(Variant arg1) {
            this.mVariants.add(arg1);
        }

        public int findMatch(float arg3, float arg4) {
            int v0;
            for(v0 = 0; v0 < this.mVariants.size(); ++v0) {
                if(this.mVariants.get(v0).match(arg3, arg4)) {
                    return v0;
                }
            }

            return -1;
        }
    }

    class Variant {
        int mConstraintID;
        int mId;
        boolean mIsLayout;
        float mMaxHeight;
        float mMaxWidth;
        float mMinHeight;
        float mMinWidth;

        public Variant(Context arg6, XmlPullParser arg7) {
            super();
            this.mMinWidth = NaNf;
            this.mMinHeight = NaNf;
            this.mMaxWidth = NaNf;
            this.mMaxHeight = NaNf;
            this.mConstraintID = -1;
            int v0 = 0;
            this.mIsLayout = false;
            TypedArray v7 = arg6.obtainStyledAttributes(Xml.asAttributeSet(arg7), styleable.Variant);
            int v1 = v7.getIndexCount();
            while(v0 < v1) {
                int v2 = v7.getIndex(v0);
                if(v2 == styleable.Variant_constraints) {
                    this.mConstraintID = v7.getResourceId(v2, this.mConstraintID);
                    String v2_1 = arg6.getResources().getResourceTypeName(this.mConstraintID);
                    arg6.getResources().getResourceName(this.mConstraintID);
                    if("layout".equals(v2_1)) {
                        this.mIsLayout = true;
                    }
                }
                else if(v2 == styleable.Variant_region_heightLessThan) {
                    this.mMaxHeight = v7.getDimension(v2, this.mMaxHeight);
                }
                else if(v2 == styleable.Variant_region_heightMoreThan) {
                    this.mMinHeight = v7.getDimension(v2, this.mMinHeight);
                }
                else if(v2 == styleable.Variant_region_widthLessThan) {
                    this.mMaxWidth = v7.getDimension(v2, this.mMaxWidth);
                }
                else if(v2 == styleable.Variant_region_widthMoreThan) {
                    this.mMinWidth = v7.getDimension(v2, this.mMinWidth);
                }
                else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }

                ++v0;
            }

            v7.recycle();
        }

        boolean match(float arg3, float arg4) {
            if(!Float.isNaN(this.mMinWidth) && arg3 < this.mMinWidth) {
                return 0;
            }

            if(!Float.isNaN(this.mMinHeight) && arg4 < this.mMinHeight) {
                return 0;
            }

            if(!Float.isNaN(this.mMaxWidth) && arg3 > this.mMaxWidth) {
                return 0;
            }

            if(!Float.isNaN(this.mMaxHeight) && arg4 > this.mMaxHeight) {
                return 0;
            }

            return 1;
        }
    }

    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    private SparseArray mConstraintSetMap;
    private ConstraintsChangedListener mConstraintsChangedListener;
    int mCurrentConstraintNumber;
    int mCurrentStateId;
    ConstraintSet mDefaultConstraintSet;
    int mDefaultState;
    private SparseArray mStateList;

    public StateSet(Context arg2, XmlPullParser arg3) {
        super();
        this.mDefaultState = -1;
        this.mCurrentStateId = -1;
        this.mCurrentConstraintNumber = -1;
        this.mStateList = new SparseArray();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintsChangedListener = null;
        this.load(arg2, arg3);
    }

    public int convertToConstraintSet(int arg4, int arg5, float arg6, float arg7) {
        Iterator v5_1;
        Object v3 = this.mStateList.get(arg5);
        if(v3 == null) {
            return arg5;
        }

        float v5 = -1f;
        if(arg6 != v5 && arg7 != v5) {
            v5_1 = ((State)v3).mVariants.iterator();
            Object v0 = null;
            while(true) {
                if(v5_1.hasNext()) {
                    Object v1 = v5_1.next();
                    if(!((Variant)v1).match(arg6, arg7)) {
                        continue;
                    }

                    if(arg4 == ((Variant)v1).mConstraintID) {
                    }
                    else {
                        v0 = v1;
                        continue;
                    }
                }
                else {
                    break;
                }

                return arg4;
            }

            if(v0 != null) {
                return ((Variant)v0).mConstraintID;
            }
            else {
                return ((State)v3).mConstraintID;
            }
        }
        else if(((State)v3).mConstraintID == arg4) {
        }
        else {
            v5_1 = ((State)v3).mVariants.iterator();
            do {
                if(!v5_1.hasNext()) {
                    break;
                }
                else if(arg4 != v5_1.next().mConstraintID) {
                    continue;
                }

                return arg4;
            }
            while(true);

            return ((State)v3).mConstraintID;
        }

        return arg4;
    }

    private void load(Context arg6, XmlPullParser arg7) {
        State v1_1;
        int v0_1;
        TypedArray v0 = arg6.obtainStyledAttributes(Xml.asAttributeSet(arg7), styleable.StateSet);
        int v1 = v0.getIndexCount();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            int v3 = v0.getIndex(v2);
            if(v3 == styleable.StateSet_defaultState) {
                this.mDefaultState = v0.getResourceId(v3, this.mDefaultState);
            }
        }

        try {
            v0_1 = arg7.getEventType();
            v1_1 = null;
        }
        catch(IOException v5) {
            goto label_70;
        }
        catch(XmlPullParserException v5_1) {
            goto label_73;
        }

        while(v0_1 != 1) {
            if(v0_1 != 0) {
                String v3_1 = "StateSet";
                if(v0_1 == 2) {
                    goto label_29;
                }
                else if(v0_1 != 3) {
                }
                else {
                    try {
                        if(v3_1.equals(arg7.getName())) {
                            return;
                        label_29:
                            String v0_2 = arg7.getName();
                            switch(v0_2.hashCode()) {
                                case 80204913: {
                                    if(v0_2.equals("State")) {
                                        v1_1 = new State(arg6, arg7);
                                        this.mStateList.put(v1_1.mId, v1_1);
                                    }
                                    else {
                                        goto label_57;
                                    }

                                    goto label_67;
                                }
                                case 1301459538: {
                                    if(v0_2.equals("LayoutDescription")) {
                                    }
                                    else {
                                        goto label_57;
                                    }

                                    goto label_67;
                                }
                                case 1382829617: {
                                    if(v0_2.equals(v3_1)) {
                                    }
                                    else {
                                        goto label_57;
                                    }

                                    goto label_67;
                                }
                                case 1901439077: {
                                    if(v0_2.equals("Variant")) {
                                        Variant v0_3 = new Variant(arg6, arg7);
                                        if(v1_1 != null) {
                                            v1_1.add(v0_3);
                                        }
                                    }
                                    else {
                                        goto label_57;
                                    }

                                    goto label_67;
                                }
                                default: {
                                    break;
                                }
                            }

                        label_57:
                            Log.v("ConstraintLayoutStates", "unknown tag " + v0_2);
                            goto label_67;
                        label_66:
                            arg7.getName();
                        }

                    label_67:
                        v0_1 = arg7.next();
                        continue;
                    }
                    catch(IOException v5) {
                    label_70:
                        v5.printStackTrace();
                        return;
                    }
                    catch(XmlPullParserException v5_1) {
                    label_73:
                        v5_1.printStackTrace();
                        return;
                    }
                }
            }
            else {
                goto label_66;
            }

            goto label_67;
        }
    }

    public boolean needsToChange(int arg6, float arg7, float arg8) {
        int v0 = this.mCurrentStateId;
        if(v0 != arg6) {
            return 1;
        }

        SparseArray v2 = this.mStateList;
        int v3 = -1;
        Object v6 = arg6 == v3 ? v2.valueAt(0) : v2.get(v0);
        if(this.mCurrentConstraintNumber != v3 && (((State)v6).mVariants.get(this.mCurrentConstraintNumber).match(arg7, arg8))) {
            return 0;
        }

        if(this.mCurrentConstraintNumber == ((State)v6).findMatch(arg7, arg8)) {
            return 0;
        }

        return 1;
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener arg1) {
        this.mConstraintsChangedListener = arg1;
    }

    public int stateGetConstraintID(int arg2, int arg3, int arg4) {
        return this.updateConstraints(-1, arg2, ((float)arg3), ((float)arg4));
    }

    public int updateConstraints(int arg3, int arg4, float arg5, float arg6) {
        int v2;
        int v0 = -1;
        if(arg3 != arg4) {
            goto label_28;
        }

        SparseArray v1 = this.mStateList;
        Object v4 = arg4 == v0 ? v1.valueAt(0) : v1.get(this.mCurrentStateId);
        if(v4 == null) {
            return v0;
        }

        if(this.mCurrentConstraintNumber == v0 || !((State)v4).mVariants.get(arg3).match(arg5, arg6)) {
            v2 = ((State)v4).findMatch(arg5, arg6);
            if(arg3 == v2) {
                return arg3;
            }

            goto label_21;
        }
        else {
        }

        return arg3;
    label_21:
        if(v2 == v0) {
            return ((State)v4).mConstraintID;
        }

        return ((State)v4).mVariants.get(v2).mConstraintID;
    label_28:
        Object v2_1 = this.mStateList.get(arg4);
        if(v2_1 == null) {
            return v0;
        }

        arg3 = ((State)v2_1).findMatch(arg5, arg6);
        if(arg3 == v0) {
            return ((State)v2_1).mConstraintID;
        }

        return ((State)v2_1).mVariants.get(arg3).mConstraintID;
    }
}


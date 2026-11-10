package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintLayoutStates {
    class State {
        int mConstraintID;
        ConstraintSet mConstraintSet;
        int mId;
        ArrayList mVariants;

        public State(Context arg6, XmlPullParser arg7) {
            super();
            this.mVariants = new ArrayList();
            this.mConstraintID = -1;
            TypedArray v7 = arg6.obtainStyledAttributes(Xml.asAttributeSet(arg7), styleable.State);
            int v0 = v7.getIndexCount();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                int v2 = v7.getIndex(v1);
                if(v2 == styleable.State_android_id) {
                    this.mId = v7.getResourceId(v2, this.mId);
                }
                else if(v2 == styleable.State_constraints) {
                    this.mConstraintID = v7.getResourceId(v2, this.mConstraintID);
                    String v2_1 = arg6.getResources().getResourceTypeName(this.mConstraintID);
                    arg6.getResources().getResourceName(this.mConstraintID);
                    if("layout".equals(v2_1)) {
                        ConstraintSet v2_2 = new ConstraintSet();
                        this.mConstraintSet = v2_2;
                        v2_2.clone(arg6, this.mConstraintID);
                    }
                }
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
        ConstraintSet mConstraintSet;
        int mId;
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
            TypedArray v7 = arg6.obtainStyledAttributes(Xml.asAttributeSet(arg7), styleable.Variant);
            int v0 = v7.getIndexCount();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                int v2 = v7.getIndex(v1);
                if(v2 == styleable.Variant_constraints) {
                    this.mConstraintID = v7.getResourceId(v2, this.mConstraintID);
                    String v2_1 = arg6.getResources().getResourceTypeName(this.mConstraintID);
                    arg6.getResources().getResourceName(this.mConstraintID);
                    if("layout".equals(v2_1)) {
                        ConstraintSet v2_2 = new ConstraintSet();
                        this.mConstraintSet = v2_2;
                        v2_2.clone(arg6, this.mConstraintID);
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
    private final ConstraintLayout mConstraintLayout;
    private SparseArray mConstraintSetMap;
    private ConstraintsChangedListener mConstraintsChangedListener;
    int mCurrentConstraintNumber;
    int mCurrentStateId;
    ConstraintSet mDefaultConstraintSet;
    private SparseArray mStateList;

    ConstraintLayoutStates(Context arg2, ConstraintLayout arg3, int arg4) {
        super();
        this.mCurrentStateId = -1;
        this.mCurrentConstraintNumber = -1;
        this.mStateList = new SparseArray();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintsChangedListener = null;
        this.mConstraintLayout = arg3;
        this.load(arg2, arg4);
    }

    private void load(Context arg6, int arg7) {
        XmlResourceParser v7 = arg6.getResources().getXml(arg7);
        try {
            int v0 = ((XmlPullParser)v7).getEventType();
            State v1 = null;
            while(v0 != 1) {
                if(v0 == 0) {
                    ((XmlPullParser)v7).getName();
                }
                else if(v0 != 2) {
                }
                else {
                    String v0_1 = ((XmlPullParser)v7).getName();
                    switch(v0_1.hashCode()) {
                        case 80204913: {
                            if(v0_1.equals("State")) {
                                v1 = new State(arg6, ((XmlPullParser)v7));
                                this.mStateList.put(v1.mId, v1);
                            }
                            else {
                                goto label_44;
                            }

                            goto label_54;
                        }
                        case 1382829617: {
                            if(v0_1.equals("StateSet")) {
                            }
                            else {
                                goto label_44;
                            }

                            goto label_54;
                        }
                        case 1657696882: {
                            if(v0_1.equals("layoutDescription")) {
                            }
                            else {
                                goto label_44;
                            }

                            goto label_54;
                        }
                        case 1901439077: {
                            if(v0_1.equals("Variant")) {
                                Variant v0_2 = new Variant(arg6, ((XmlPullParser)v7));
                                if(v1 != null) {
                                    v1.add(v0_2);
                                }
                            }
                            else {
                                goto label_44;
                            }

                            goto label_54;
                        }
                        case -1349929691: {
                            if(v0_1.equals("ConstraintSet")) {
                                this.parseConstraintSet(arg6, ((XmlPullParser)v7));
                            }
                            else {
                                goto label_44;
                            }

                            goto label_54;
                        }
                        default: {
                            break;
                        }
                    }

                label_44:
                    Log.v("ConstraintLayoutStates", "unknown tag " + v0_1);
                }

            label_54:
                v0 = ((XmlPullParser)v7).next();
            }
        }
        catch(IOException v5) {
            v5.printStackTrace();
        }
        catch(XmlPullParserException v5_1) {
            v5_1.printStackTrace();
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

    private void parseConstraintSet(Context arg9, XmlPullParser arg10) {
        ConstraintSet v0 = new ConstraintSet();
        int v1 = arg10.getAttributeCount();
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            String v4 = "id";
            if(v4.equals(arg10.getAttributeName(v2))) {
                String v1_1 = arg10.getAttributeValue(v2);
                int v3 = -1;
                v2 = v1_1.contains("/") ? arg9.getResources().getIdentifier(v1_1.substring(v1_1.indexOf(0x2F) + 1), v4, arg9.getPackageName()) : v3;
                if(v2 == v3) {
                    if(v1_1 != null && v1_1.length() > 1) {
                        v2 = Integer.parseInt(v1_1.substring(1));
                        goto label_34;
                    }

                    Log.e("ConstraintLayoutStates", "error in parsing id");
                }

            label_34:
                v0.load(arg9, arg10);
                this.mConstraintSetMap.put(v2, v0);
                return;
            }
        }
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener arg1) {
        this.mConstraintsChangedListener = arg1;
    }

    public void updateConstraints(int arg5, float arg6, float arg7) {
        ConstraintsChangedListener v4;
        ConstraintsChangedListener v6_1;
        int v0 = this.mCurrentStateId;
        int v1 = -1;
        if(v0 == arg5) {
            SparseArray v2 = this.mStateList;
            Object v5 = arg5 == v1 ? v2.valueAt(0) : v2.get(v0);
            if(this.mCurrentConstraintNumber != v1 && (((State)v5).mVariants.get(this.mCurrentConstraintNumber).match(arg6, arg7))) {
                return;
            }

            int v6 = ((State)v5).findMatch(arg6, arg7);
            if(this.mCurrentConstraintNumber == v6) {
                return;
            }

            ConstraintSet v7 = v6 == v1 ? this.mDefaultConstraintSet : ((State)v5).mVariants.get(v6).mConstraintSet;
            arg5 = v6 == v1 ? ((State)v5).mConstraintID : ((State)v5).mVariants.get(v6).mConstraintID;
            if(v7 == null) {
                return;
            }

            this.mCurrentConstraintNumber = v6;
            v6_1 = this.mConstraintsChangedListener;
            if(v6_1 != null) {
                v6_1.preLayoutChange(v1, arg5);
            }

            v7.applyTo(this.mConstraintLayout);
            v4 = this.mConstraintsChangedListener;
            if(v4 == null) {
                return;
            }

            v4.postLayoutChange(v1, arg5);
            return;
        }
        else {
            this.mCurrentStateId = arg5;
            Object v0_1 = this.mStateList.get(arg5);
            int v2_1 = ((State)v0_1).findMatch(arg6, arg7);
            ConstraintSet v3 = v2_1 == v1 ? ((State)v0_1).mConstraintSet : ((State)v0_1).mVariants.get(v2_1).mConstraintSet;
            v0 = v2_1 == v1 ? ((State)v0_1).mConstraintID : ((State)v0_1).mVariants.get(v2_1).mConstraintID;
            if(v3 == null) {
                Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + arg5 + ", dim =" + arg6 + ", " + arg7);
                return;
            }

            this.mCurrentConstraintNumber = v2_1;
            v6_1 = this.mConstraintsChangedListener;
            if(v6_1 != null) {
                v6_1.preLayoutChange(arg5, v0);
            }

            v3.applyTo(this.mConstraintLayout);
            v4 = this.mConstraintsChangedListener;
            if(v4 == null) {
                return;
            }

            v4.postLayoutChange(arg5, v0);
        }
    }
}


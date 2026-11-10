package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class KeyFrames {
    private static final String TAG = "KeyFrames";
    public static final int UNSET = -1;
    private HashMap mFramesMap;
    static HashMap sKeyMakers;

    static {
        HashMap v0 = new HashMap();
        KeyFrames.sKeyMakers = v0;
        try {
            v0.put("KeyAttribute", KeyAttributes.class.getConstructor());
            KeyFrames.sKeyMakers.put("KeyPosition", KeyPosition.class.getConstructor());
            KeyFrames.sKeyMakers.put("KeyCycle", KeyCycle.class.getConstructor());
            KeyFrames.sKeyMakers.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor());
            KeyFrames.sKeyMakers.put("KeyTrigger", KeyTrigger.class.getConstructor());
            return;
        }
        catch(NoSuchMethodException v0_1) {
            Log.e("KeyFrames", "unable to load", ((Throwable)v0_1));
            return;
        }
    }

    public KeyFrames(Context arg6, XmlPullParser arg7) {
        Object v0_3;
        String v0_1;
        AttributeSet v1;
        int v0;
        super();
        this.mFramesMap = new HashMap();
        try {
            v0 = arg7.getEventType();
            v1 = null;
            while(true) {
            label_6:
                if(v0 == 1) {
                    return;
                }

                if(v0 != 2) {
                    if(v0 != 3) {
                        goto label_50;
                    }

                    if(!"KeyFrameSet".equals(arg7.getName())) {
                        goto label_50;
                    }

                    return;
                }

                v0_1 = arg7.getName();
                if(!KeyFrames.sKeyMakers.containsKey(v0_1)) {
                    goto label_42;
                }

                break;
            }
        }
        catch(XmlPullParserException v5) {
            goto label_56;
        }
        catch(IOException v5_1) {
            goto label_53;
        }

        try {
            v0_3 = KeyFrames.sKeyMakers.get(v0_1).newInstance();
        }
        catch(Exception v0_2) {
            goto label_34;
        }
        catch(XmlPullParserException v5) {
            goto label_56;
        }
        catch(IOException v5_1) {
            goto label_53;
        }

        try {
            v1 = Xml.asAttributeSet(arg7);
            goto label_28;
        }
        catch(IOException v5_1) {
        }
        catch(XmlPullParserException v5) {
        }
        catch(Exception v1_1) {
        }
        catch(Exception v0_2) {
        label_34:
            AttributeSet v4 = v1;
            v1_1 = v0_2;
            AttributeSet v0_4 = v4;
            goto label_37;
            try {
            label_28:
                ((Key)v0_3).load(arg6, v1);
                this.addKey(((Key)v0_3));
                goto label_40;
            }
            catch(IOException v5_1) {
            }
            catch(XmlPullParserException v5) {
            }
            catch(Exception v1_1) {
                try {
                label_37:
                    Log.e("KeyFrames", "unable to create ", ((Throwable)v1_1));
                label_40:
                    Object v1_2 = v0_4;
                    goto label_50;
                label_42:
                    if((v0_1.equalsIgnoreCase("CustomAttribute")) && v1_2 != null && ((Key)v1_2).mCustomConstraints != null) {
                        ConstraintAttribute.parse(arg6, arg7, ((Key)v1_2).mCustomConstraints);
                    }

                label_50:
                    v0 = arg7.next();
                    goto label_6;
                }
                catch(IOException v5_1) {
                label_53:
                    v5_1.printStackTrace();
                }
                catch(XmlPullParserException v5) {
                label_56:
                    v5.printStackTrace();
                }
            }
        }
    }

    public void addFrames(MotionController arg4) {
        Object v0 = this.mFramesMap.get(Integer.valueOf(arg4.mId));
        if(v0 != null) {
            arg4.addKeys(((ArrayList)v0));
        }

        Object v3 = this.mFramesMap.get(Integer.valueOf(-1));
        if(v3 != null) {
            Iterator v3_1 = ((ArrayList)v3).iterator();
            while(v3_1.hasNext()) {
                v0 = v3_1.next();
                if(!((Key)v0).matches(arg4.mView.getLayoutParams().constraintTag)) {
                    continue;
                }

                arg4.addKey(((Key)v0));
            }
        }
    }

    private void addKey(Key arg4) {
        if(!this.mFramesMap.containsKey(Integer.valueOf(arg4.mTargetId))) {
            this.mFramesMap.put(Integer.valueOf(arg4.mTargetId), new ArrayList());
        }

        this.mFramesMap.get(Integer.valueOf(arg4.mTargetId)).add(arg4);
    }

    public ArrayList getKeyFramesForView(int arg1) {
        return this.mFramesMap.get(Integer.valueOf(arg1));
    }

    public Set getKeys() {
        return this.mFramesMap.keySet();
    }

    static String name(int arg0, Context arg1) {
        return arg1.getResources().getResourceEntryName(arg0);
    }
}


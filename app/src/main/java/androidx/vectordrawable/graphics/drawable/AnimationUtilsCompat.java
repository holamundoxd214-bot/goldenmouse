package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources$NotFoundException;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimationUtilsCompat {
    private AnimationUtilsCompat() {
        super();
    }

    private static Interpolator createInterpolatorFromXml(Context arg2, Resources arg3, Resources$Theme arg4, XmlPullParser arg5) throws XmlPullParserException, IOException {
        AccelerateInterpolator v4_5;
        OvershootInterpolator v0_6;
        int v3 = arg5.getDepth();
        Interpolator v4 = null;
        while(true) {
            int v0 = arg5.next();
            if((v0 != 3 || arg5.getDepth() > v3) && v0 != 1) {
                if(v0 != 2) {
                }
                else {
                    AttributeSet v4_1 = Xml.asAttributeSet(arg5);
                    String v0_1 = arg5.getName();
                    if(v0_1.equals("linearInterpolator")) {
                        LinearInterpolator v4_2 = new LinearInterpolator();
                    }
                    else {
                        if(v0_1.equals("accelerateInterpolator")) {
                            AccelerateInterpolator v0_2 = new AccelerateInterpolator(arg2, v4_1);
                        }
                        else if(v0_1.equals("decelerateInterpolator")) {
                            DecelerateInterpolator v0_3 = new DecelerateInterpolator(arg2, v4_1);
                        }
                        else if(v0_1.equals("accelerateDecelerateInterpolator")) {
                            AccelerateDecelerateInterpolator v4_3 = new AccelerateDecelerateInterpolator();
                            continue;
                        }
                        else if(v0_1.equals("cycleInterpolator")) {
                            CycleInterpolator v0_4 = new CycleInterpolator(arg2, v4_1);
                        }
                        else if(v0_1.equals("anticipateInterpolator")) {
                            AnticipateInterpolator v0_5 = new AnticipateInterpolator(arg2, v4_1);
                        }
                        else if(v0_1.equals("overshootInterpolator")) {
                            v0_6 = new OvershootInterpolator(arg2, v4_1);
                        }
                        else if(v0_1.equals("anticipateOvershootInterpolator")) {
                            AnticipateOvershootInterpolator v0_7 = new AnticipateOvershootInterpolator(arg2, v4_1);
                        }
                        else if(v0_1.equals("bounceInterpolator")) {
                            BounceInterpolator v4_4 = new BounceInterpolator();
                            continue;
                        }
                        else if(v0_1.equals("pathInterpolator")) {
                            PathInterpolatorCompat v0_8 = new PathInterpolatorCompat(arg2, v4_1, arg5);
                        }
                        else {
                            break;
                        }

                        v4_5 = ((AccelerateInterpolator)v0_6);
                    }
                }

                continue;
            }

            goto label_84;
        }

        throw new RuntimeException("Unknown interpolator name: " + arg5.getName());
    label_84:
        return ((Interpolator)v4_5);
    }

    public static Interpolator loadInterpolator(Context arg0, int arg1) throws Resources$NotFoundException {
        return AnimationUtils.loadInterpolator(arg0, arg1);
    }
}


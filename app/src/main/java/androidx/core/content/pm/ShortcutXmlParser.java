package androidx.core.content.pm;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ShortcutXmlParser {
    private static final String ATTR_SHORTCUT_ID = "shortcutId";
    private static final Object GET_INSTANCE_LOCK = null;
    private static final String META_DATA_APP_SHORTCUTS = "android.app.shortcuts";
    private static final String TAG = "ShortcutXmlParser";
    private static final String TAG_SHORTCUT = "shortcut";
    private static volatile ArrayList sShortcutIds;

    static {
        ShortcutXmlParser.GET_INSTANCE_LOCK = new Object();
    }

    private ShortcutXmlParser() {
        super();
    }

    private static String getAttributeValue(XmlPullParser arg1, String arg2) {
        String v0 = arg1.getAttributeValue("http://schemas.android.com/apk/res/android", arg2);
        if(v0 == null) {
            return arg1.getAttributeValue(null, arg2);
        }

        return v0;
    }

    public static List getShortcutIds(Context arg2) {
        if(ShortcutXmlParser.sShortcutIds == null) {
            Object v0 = ShortcutXmlParser.GET_INSTANCE_LOCK;
            __monitor_enter(v0);
            try {
                if(ShortcutXmlParser.sShortcutIds == null) {
                    ShortcutXmlParser.sShortcutIds = new ArrayList();
                    ShortcutXmlParser.sShortcutIds.addAll(ShortcutXmlParser.parseShortcutIds(arg2));
                }

                __monitor_exit(v0);
                goto label_17;
            label_15:
                __monitor_exit(v0);
            }
            catch(Throwable v2) {
                goto label_15;
            }

            throw v2;
        }

    label_17:
        return ShortcutXmlParser.sShortcutIds;
    }

    private static XmlResourceParser getXmlResourceParser(Context arg2, ActivityInfo arg3) {
        XmlResourceParser v2 = arg3.loadXmlMetaData(arg2.getPackageManager(), "android.app.shortcuts");
        if(v2 != null) {
            return v2;
        }

        throw new IllegalArgumentException("Failed to open android.app.shortcuts meta-data resource of " + arg3.name);
    }

    private static Set parseShortcutIds(Context arg5) {
        XmlResourceParser v2_1;
        HashSet v0 = new HashSet();
        Intent v1 = new Intent("android.intent.action.MAIN");
        v1.addCategory("android.intent.category.LAUNCHER");
        v1.setPackage(arg5.getPackageName());
        List v1_1 = arg5.getPackageManager().queryIntentActivities(v1, 0x80);
        if(v1_1 != null && v1_1.size() != 0) {
            try {
                Iterator v1_2 = v1_1.iterator();
                while(true) {
                label_17:
                    if(!v1_2.hasNext()) {
                        goto label_43;
                    }

                    ActivityInfo v2 = v1_2.next().activityInfo;
                    Bundle v3 = v2.metaData;
                    if(v3 == null) {
                        continue;
                    }

                    if(!v3.containsKey("android.app.shortcuts")) {
                        continue;
                    }

                    v2_1 = ShortcutXmlParser.getXmlResourceParser(arg5, v2);
                    break;
                }
            }
            catch(Exception v5) {
                goto label_42;
            }

            try {
                ((Set)v0).addAll(ShortcutXmlParser.parseShortcutIds(((XmlPullParser)v2_1)));
                if(v2_1 == null) {
                    goto label_17;
                }

                goto label_30;
            }
            catch(Throwable v5_1) {
                if(v2_1 == null) {
                    goto label_38;
                }

                try {
                    v2_1.close();
                    goto label_38;
                }
                catch(Throwable v1_3) {
                    try {
                        v5_1.addSuppressed(v1_3);
                    label_38:
                        throw v5_1;
                    label_30:
                        v2_1.close();
                        goto label_17;
                    }
                    catch(Exception v5) {
                    label_42:
                        Log.e("ShortcutXmlParser", "Failed to parse the Xml resource: ", ((Throwable)v5));
                    }
                }
            }
        }

    label_43:
        return ((Set)v0);
    }

    public static List parseShortcutIds(XmlPullParser arg6) throws IOException, XmlPullParserException {
        ArrayList v0 = new ArrayList(1);
        while(true) {
            int v2 = arg6.next();
            if(v2 != 1) {
                if(v2 == 3 && arg6.getDepth() <= 0) {
                    break;
                }

                int v3 = arg6.getDepth();
                String v4 = arg6.getName();
                int v5 = 2;
                if(v2 != v5) {
                    continue;
                }

                if(v3 != v5) {
                    continue;
                }

                if(!"shortcut".equals(v4)) {
                    continue;
                }

                String v2_1 = ShortcutXmlParser.getAttributeValue(arg6, "shortcutId");
                if(v2_1 == null) {
                    continue;
                }

                ((List)v0).add(v2_1);
                continue;
            }

            break;
        }

        return ((List)v0);
    }
}


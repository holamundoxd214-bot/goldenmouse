package androidx.appcompat.app;

import android.util.AttributeSet;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class LayoutIncludeDetector {
    private final Deque mXmlParserStack;

    LayoutIncludeDetector() {
        super();
        this.mXmlParserStack = new ArrayDeque();
    }

    boolean detect(AttributeSet arg4) {
        if(((arg4 instanceof XmlPullParser)) && ((XmlPullParser)arg4).getDepth() == 1) {
            XmlPullParser v0 = LayoutIncludeDetector.popOutdatedAttrHolders(this.mXmlParserStack);
            this.mXmlParserStack.push(new WeakReference(arg4));
            if(LayoutIncludeDetector.shouldInheritContext(((XmlPullParser)arg4), v0)) {
                return 1;
            }
        }

        return 0;
    }

    private static boolean isParserOutdated(XmlPullParser arg3) {
        if(arg3 != null) {
            try {
                if(arg3.getEventType() != 3) {
                    if(arg3.getEventType() == 1) {
                        return 1;
                    }
                    else {
                        return 0;
                    }
                }
            }
            catch(XmlPullParserException ) {
            }

            return 1;
        }

        return 1;
    }

    private static XmlPullParser popOutdatedAttrHolders(Deque arg2) {
        Object v0;
        while(true) {
            if(arg2.isEmpty()) {
                return null;
            }

            v0 = arg2.peek().get();
            if(!LayoutIncludeDetector.isParserOutdated(((XmlPullParser)v0))) {
                break;
            }

            arg2.pop();
        }

        return ((XmlPullParser)v0);
    }

    private static boolean shouldInheritContext(XmlPullParser arg1, XmlPullParser arg2) {
        if(arg2 != null && arg1 != arg2) {
            try {
                if(arg2.getEventType() == 2) {
                    return "include".equals(arg2.getName());
                }

                return 0;
            }
            catch(XmlPullParserException ) {
                return 0;
            }
        }

        return 0;
    }
}


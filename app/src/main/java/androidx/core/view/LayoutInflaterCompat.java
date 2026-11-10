package androidx.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater$Factory2;
import android.view.LayoutInflater$Factory;
import android.view.LayoutInflater;
import android.view.View;

public final class LayoutInflaterCompat {
    class Factory2Wrapper implements LayoutInflater$Factory2 {
        final LayoutInflaterFactory mDelegateFactory;

        Factory2Wrapper(LayoutInflaterFactory arg1) {
            super();
            this.mDelegateFactory = arg1;
        }

        public View onCreateView(View arg1, String arg2, Context arg3, AttributeSet arg4) {
            return this.mDelegateFactory.onCreateView(arg1, arg2, arg3, arg4);
        }

        public View onCreateView(String arg2, Context arg3, AttributeSet arg4) {
            return this.mDelegateFactory.onCreateView(null, arg2, arg3, arg4);
        }

        public String toString() {
            return this.getClass().getName() + "{" + this.mDelegateFactory + "}";
        }
    }

    private LayoutInflaterCompat() {
        super();
    }

    @Deprecated public static LayoutInflaterFactory getFactory(LayoutInflater arg1) {
        LayoutInflater$Factory v1 = arg1.getFactory();
        if((v1 instanceof Factory2Wrapper)) {
            return ((Factory2Wrapper)v1).mDelegateFactory;
        }

        return null;
    }

    @Deprecated public static void setFactory(LayoutInflater arg1, LayoutInflaterFactory arg2) {
        arg1.setFactory2(new Factory2Wrapper(arg2));
    }

    public static void setFactory2(LayoutInflater arg0, LayoutInflater$Factory2 arg1) {
        arg0.setFactory2(arg1);
    }
}


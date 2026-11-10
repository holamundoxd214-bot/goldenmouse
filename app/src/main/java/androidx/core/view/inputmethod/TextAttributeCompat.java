package androidx.core.view.inputmethod;

import android.os.Build$VERSION;
import android.os.PersistableBundle;
import android.view.inputmethod.TextAttribute$Builder;
import android.view.inputmethod.TextAttribute;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TextAttributeCompat {
    public final class Builder {
        private PersistableBundle mExtras;
        private List mTextConversionSuggestions;
        private boolean mTextSuggestionSelected;

        public Builder() {
            super();
            this.mTextConversionSuggestions = new ArrayList();
            this.mExtras = new PersistableBundle();
            this.mTextSuggestionSelected = false;
        }

        public TextAttributeCompat build() {
            return new TextAttributeCompat(this.mTextConversionSuggestions, this.mExtras, this.mTextSuggestionSelected, null);
        }

        public Builder setExtras(PersistableBundle arg1) {
            this.mExtras = arg1;
            return this;
        }

        public Builder setTextConversionSuggestions(List arg1) {
            this.mTextConversionSuggestions = arg1;
            return this;
        }

        public Builder setTextSuggestionSelected(boolean arg1) {
            this.mTextSuggestionSelected = arg1;
            return this;
        }
    }

    final class TextAttributeCompatApi33Impl implements TextAttributeCompatImpl {
        final TextAttribute mObject;
        private final boolean mTextSuggestionSelected;

        TextAttributeCompatApi33Impl(List arg2, PersistableBundle arg3, boolean arg4) {
            super();
            this.mObject = new TextAttribute$Builder().setTextConversionSuggestions(arg2).setExtras(arg3).build();
            this.mTextSuggestionSelected = arg4;
        }

        TextAttributeCompatApi33Impl(Object arg1) {
            super();
            this.mObject = ((TextAttribute)arg1);
            this.mTextSuggestionSelected = false;
        }

        public PersistableBundle getExtras() {
            return this.mObject.getExtras();
        }

        public Object getTextAttribute() {
            return this.mObject;
        }

        public List getTextConversionSuggestions() {
            return this.mObject.getTextConversionSuggestions();
        }

        public boolean isTextSuggestionSelected() {
            return this.mTextSuggestionSelected;
        }
    }

    final class TextAttributeCompatApi37Impl implements TextAttributeCompatImpl {
        final TextAttribute mObject;

        TextAttributeCompatApi37Impl(List arg2, PersistableBundle arg3, boolean arg4) {
            super();
            this.mObject = new TextAttribute$Builder().setTextConversionSuggestions(arg2).setExtras(arg3).setTextSuggestionSelected(arg4).build();
        }

        TextAttributeCompatApi37Impl(Object arg1) {
            super();
            this.mObject = ((TextAttribute)arg1);
        }

        public PersistableBundle getExtras() {
            return this.mObject.getExtras();
        }

        public Object getTextAttribute() {
            return this.mObject;
        }

        public List getTextConversionSuggestions() {
            return this.mObject.getTextConversionSuggestions();
        }

        public boolean isTextSuggestionSelected() {
            return this.mObject.isTextSuggestionSelected();
        }
    }

    final class TextAttributeCompatBaseImpl implements TextAttributeCompatImpl {
        private final PersistableBundle mExtras;
        private final List mTextConversionSuggestions;
        private final boolean mTextSuggestionSelected;

        TextAttributeCompatBaseImpl(List arg1, PersistableBundle arg2, boolean arg3) {
            super();
            this.mTextConversionSuggestions = Collections.unmodifiableList(arg1);
            this.mExtras = arg2;
            this.mTextSuggestionSelected = arg3;
        }

        public PersistableBundle getExtras() {
            return this.mExtras;
        }

        public Object getTextAttribute() {
            return null;
        }

        public List getTextConversionSuggestions() {
            return this.mTextConversionSuggestions;
        }

        public boolean isTextSuggestionSelected() {
            return this.mTextSuggestionSelected;
        }
    }

    interface TextAttributeCompatImpl {
        PersistableBundle getExtras();

        Object getTextAttribute();

        List getTextConversionSuggestions();

        boolean isTextSuggestionSelected();
    }

    private final TextAttributeCompatImpl mImpl;

    private TextAttributeCompat(TextAttributeCompatImpl arg1) {
        super();
        this.mImpl = arg1;
    }

    private TextAttributeCompat(List arg3, PersistableBundle arg4, boolean arg5) {
        super();
        if(Build$VERSION.SDK_INT >= 37) {
            this.mImpl = new TextAttributeCompatApi37Impl(arg3, arg4, arg5);
            return;
        }

        if(Build$VERSION.SDK_INT >= 33) {
            this.mImpl = new TextAttributeCompatApi33Impl(arg3, arg4, arg5);
            return;
        }

        this.mImpl = new TextAttributeCompatBaseImpl(arg3, arg4, arg5);
    }

    TextAttributeCompat(List arg1, PersistableBundle arg2, boolean arg3, TextAttributeCompat-IA arg4) {
        this(arg1, arg2, arg3);
    }

    public PersistableBundle getExtras() {
        return this.mImpl.getExtras();
    }

    public List getTextConversionSuggestions() {
        return this.mImpl.getTextConversionSuggestions();
    }

    public boolean isTextSuggestionSelected() {
        return this.mImpl.isTextSuggestionSelected();
    }

    public Object unwrap() {
        return this.mImpl.getTextAttribute();
    }

    public static TextAttributeCompat wrap(Object arg3) {
        TextAttributeCompat v0 = null;
        if(arg3 == null) {
            return v0;
        }

        if(Build$VERSION.SDK_INT >= 37) {
            return new TextAttributeCompat(new TextAttributeCompatApi37Impl(arg3));
        }

        if(Build$VERSION.SDK_INT >= 33) {
            v0 = new TextAttributeCompat(new TextAttributeCompatApi33Impl(arg3));
        }

        return v0;
    }
}


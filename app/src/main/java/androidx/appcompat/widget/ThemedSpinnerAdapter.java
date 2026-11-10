package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources$Theme;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;
import androidx.appcompat.view.ContextThemeWrapper;

public interface ThemedSpinnerAdapter extends SpinnerAdapter {
    public final class Helper {
        private final Context mContext;
        private LayoutInflater mDropDownInflater;
        private final LayoutInflater mInflater;

        public Helper(Context arg1) {
            super();
            this.mContext = arg1;
            this.mInflater = LayoutInflater.from(arg1);
        }

        public LayoutInflater getDropDownViewInflater() {
            LayoutInflater v0 = this.mDropDownInflater;
            if(v0 != null) {
                return v0;
            }

            return this.mInflater;
        }

        public Resources$Theme getDropDownViewTheme() {
            LayoutInflater v0 = this.mDropDownInflater;
            if(v0 == null) {
                return null;
            }

            return v0.getContext().getTheme();
        }

        public void setDropDownViewTheme(Resources$Theme arg3) {
            if(arg3 == null) {
                this.mDropDownInflater = null;
                return;
            }

            if(arg3.equals(this.mContext.getTheme())) {
                this.mDropDownInflater = this.mInflater;
                return;
            }

            this.mDropDownInflater = LayoutInflater.from(new ContextThemeWrapper(this.mContext, arg3));
        }
    }

    Resources$Theme getDropDownViewTheme();

    void setDropDownViewTheme(Resources$Theme arg1);
}


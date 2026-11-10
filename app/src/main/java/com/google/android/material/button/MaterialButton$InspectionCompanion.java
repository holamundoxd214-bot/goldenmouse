package com.google.android.material.button;

import android.view.inspector.InspectionCompanion$UninitializedPropertyMapException;
import android.view.inspector.InspectionCompanion;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import com.google.android.material.R$attr;

public final class MaterialButton$InspectionCompanion implements InspectionCompanion {
    private int mIconPaddingId;
    private boolean mPropertiesMapped;

    public MaterialButton$InspectionCompanion() {
        super();
        this.mPropertiesMapped = false;
    }

    public void mapProperties(PropertyMapper arg3) {
        this.mIconPaddingId = arg3.mapInt("iconPadding", attr.iconPadding);
        this.mPropertiesMapped = true;
    }

    public void readProperties(MaterialButton arg2, PropertyReader arg3) {
        if(this.mPropertiesMapped) {
            arg3.readInt(this.mIconPaddingId, arg2.getIconPadding());
            return;
        }

        throw new InspectionCompanion$UninitializedPropertyMapException();
    }

    public void readProperties(Object arg1, PropertyReader arg2) {
        this.readProperties(((MaterialButton)arg1), arg2);
    }
}


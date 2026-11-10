package com.google.android.material.color;

import com.google.android.material.R$color;
import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;

public final class MaterialColorUtilitiesHelper {
    private static final Map colorResourceIdToColorValue;
    private static final MaterialDynamicColors dynamicColors;

    static {
        MaterialDynamicColors v0 = new MaterialDynamicColors();
        MaterialColorUtilitiesHelper.dynamicColors = v0;
        HashMap v1 = new HashMap();
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_primary), v0.primary());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_on_primary), v0.onPrimary());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_primary_inverse), v0.inversePrimary());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_primary_container), v0.primaryContainer());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_on_primary_container), v0.onPrimaryContainer());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_secondary), v0.secondary());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_on_secondary), v0.onSecondary());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_secondary_container), v0.secondaryContainer());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_on_secondary_container), v0.onSecondaryContainer());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_tertiary), v0.tertiary());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_on_tertiary), v0.onTertiary());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_tertiary_container), v0.tertiaryContainer());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_on_tertiary_container), v0.onTertiaryContainer());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_background), v0.background());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_on_background), v0.onBackground());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_surface), v0.surface());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_on_surface), v0.onSurface());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_surface_variant), v0.surfaceVariant());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_on_surface_variant), v0.onSurfaceVariant());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_surface_inverse), v0.inverseSurface());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_on_surface_inverse), v0.inverseOnSurface());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_surface_bright), v0.surfaceBright());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_surface_dim), v0.surfaceDim());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_surface_container), v0.surfaceContainer());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_surface_container_low), v0.surfaceContainerLow());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_surface_container_high), v0.surfaceContainerHigh());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_surface_container_lowest), v0.surfaceContainerLowest());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_surface_container_highest), v0.surfaceContainerHighest());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_outline), v0.outline());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_outline_variant), v0.outlineVariant());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_error), v0.error());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_on_error), v0.onError());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_error_container), v0.errorContainer());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_on_error_container), v0.onErrorContainer());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_control_activated), v0.controlActivated());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_control_normal), v0.controlNormal());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_control_highlight), v0.controlHighlight());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_text_primary_inverse), v0.textPrimaryInverse());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_text_secondary_and_tertiary_inverse), v0.textSecondaryAndTertiaryInverse());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_text_secondary_and_tertiary_inverse_disabled), v0.textSecondaryAndTertiaryInverseDisabled());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_text_primary_inverse_disable_only), v0.textPrimaryInverseDisableOnly());
        ((Map)v1).put(Integer.valueOf(color.material_personalized_color_text_hint_foreground_inverse), v0.textHintInverse());
        MaterialColorUtilitiesHelper.colorResourceIdToColorValue = Collections.unmodifiableMap(((Map)v1));
    }

    private MaterialColorUtilitiesHelper() {
        super();
    }

    public static Map createColorResourcesIdsToColorValues(DynamicScheme arg4) {
        HashMap v0 = new HashMap();
        Iterator v1 = MaterialColorUtilitiesHelper.colorResourceIdToColorValue.entrySet().iterator();
        while(v1.hasNext()) {
            Object v2 = v1.next();
            v0.put(((Map$Entry)v2).getKey(), Integer.valueOf(((Map$Entry)v2).getValue().getArgb(arg4)));
        }

        return Collections.unmodifiableMap(((Map)v0));
    }
}


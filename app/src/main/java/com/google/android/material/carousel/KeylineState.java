package com.google.android.material.carousel;

import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class KeylineState {
    class com.google.android.material.carousel.KeylineState$1 {
    }

    final class Builder {
        private static final int NO_INDEX = -1;
        private static final float UNKNOWN_LOC = 1.401298E-45f;
        private final float availableSpace;
        private int firstFocalKeylineIndex;
        private final float itemSize;
        private int lastFocalKeylineIndex;
        private float lastKeylineMaskedSize;
        private int latestAnchorKeylineIndex;
        private Keyline tmpFirstFocalKeyline;
        private final List tmpKeylines;
        private Keyline tmpLastFocalKeyline;

        Builder(float arg3, float arg4) {
            super();
            this.tmpKeylines = new ArrayList();
            this.firstFocalKeylineIndex = -1;
            this.lastFocalKeylineIndex = -1;
            this.lastKeylineMaskedSize = 0f;
            this.latestAnchorKeylineIndex = -1;
            this.itemSize = arg3;
            this.availableSpace = arg4;
        }

        Builder addAnchorKeyline(float arg7, float arg8, float arg9) {
            return this.addKeyline(arg7, arg8, arg9, false, true);
        }

        Builder addKeyline(float arg2, float arg3, float arg4) {
            return this.addKeyline(arg2, arg3, arg4, false);
        }

        Builder addKeyline(float arg9, float arg10, float arg11, boolean arg12, boolean arg13) {
            float v0 = arg11 / 2f;
            float v1 = arg9 - v0;
            v0 += arg9;
            float v2 = this.availableSpace;
            if(v0 > v2) {
                v0 = Math.abs(v0 - Math.max(v0 - arg11, v2));
            }
            else {
                v0 = 0f;
                if(v1 < 0f) {
                    v0 = Math.abs(v1 - Math.min(v1 + arg11, 0f));
                }
            }

            return this.addKeyline(arg9, arg10, arg11, arg12, arg13, v0);
        }

        Builder addKeyline(float arg7, float arg8, float arg9, boolean arg10) {
            return this.addKeyline(arg7, arg8, arg9, arg10, false);
        }

        Builder addKeyline(float arg9, float arg10, float arg11, boolean arg12, boolean arg13, float arg14) {
            if(arg11 <= 0f) {
                return this;
            }

            int v0 = -1;
            if(arg13) {
                if(!arg12) {
                    int v1 = this.latestAnchorKeylineIndex;
                    if(v1 != v0) {
                        if(v1 == 0) {
                        }
                        else {
                            throw new IllegalArgumentException("Anchor keylines must be either the first or last keyline.");
                        }
                    }

                    this.latestAnchorKeylineIndex = this.tmpKeylines.size();
                }
                else {
                    throw new IllegalArgumentException("Anchor keylines cannot be focal.");
                }
            }

            float v5 = arg11;
            Keyline v1_1 = new Keyline(1.401298E-45f, arg9, arg10, v5, arg13, arg14);
            Keyline v9 = this.tmpFirstFocalKeyline;
            if(arg12) {
                if(v9 == null) {
                    this.tmpFirstFocalKeyline = v1_1;
                    this.firstFocalKeylineIndex = this.tmpKeylines.size();
                }

                if(this.lastFocalKeylineIndex != v0) {
                    if(this.tmpKeylines.size() - this.lastFocalKeylineIndex <= 1) {
                    }
                    else {
                        throw new IllegalArgumentException("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                    }
                }

                if(v5 == this.tmpFirstFocalKeyline.maskedItemSize) {
                    this.tmpLastFocalKeyline = v1_1;
                    this.lastFocalKeylineIndex = this.tmpKeylines.size();
                    goto label_81;
                }

                throw new IllegalArgumentException("Keylines that are marked as focal must all have the same masked item size.");
            }
            else {
                if(v9 == null) {
                    if(v1_1.maskedItemSize >= this.lastKeylineMaskedSize) {
                    }
                    else {
                        throw new IllegalArgumentException("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                    }
                }

                if(this.tmpLastFocalKeyline == null) {
                    goto label_81;
                }

                if(v1_1.maskedItemSize <= this.lastKeylineMaskedSize) {
                    goto label_81;
                }

                throw new IllegalArgumentException("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
            }

        label_81:
            this.lastKeylineMaskedSize = v1_1.maskedItemSize;
            this.tmpKeylines.add(v1_1);
            return this;
        }

        Builder addKeylineRange(float arg7, float arg8, float arg9, int arg10) {
            return this.addKeylineRange(arg7, arg8, arg9, arg10, false);
        }

        Builder addKeylineRange(float arg3, float arg4, float arg5, int arg6, boolean arg7) {
            if(arg6 > 0) {
                if(arg5 <= 0f) {
                }
                else {
                    int v0;
                    for(v0 = 0; v0 < arg6; ++v0) {
                        this.addKeyline((((float)v0)) * arg5 + arg3, arg4, arg5, arg7);
                    }
                }
            }

            return this;
        }

        KeylineState build() {
            if(this.tmpFirstFocalKeyline != null) {
                ArrayList v3 = new ArrayList();
                int v0;
                for(v0 = 0; v0 < this.tmpKeylines.size(); ++v0) {
                    Object v1 = this.tmpKeylines.get(v0);
                    ((List)v3).add(new Keyline(Builder.calculateKeylineLocationForItemPosition(this.tmpFirstFocalKeyline.locOffset, this.itemSize, this.firstFocalKeylineIndex, v0), ((Keyline)v1).locOffset, ((Keyline)v1).mask, ((Keyline)v1).maskedItemSize, ((Keyline)v1).isAnchor, ((Keyline)v1).cutoff));
                }

                return new KeylineState(this.itemSize, ((List)v3), this.firstFocalKeylineIndex, this.lastFocalKeylineIndex, null);
            }

            throw new IllegalStateException("There must be a keyline marked as focal.");
        }

        private static float calculateKeylineLocationForItemPosition(float arg0, float arg1, int arg2, int arg3) {
            return arg0 - (((float)arg2)) * arg1 + (((float)arg3)) * arg1;
        }
    }

    final class Keyline {
        final float cutoff;
        final boolean isAnchor;
        final float loc;
        final float locOffset;
        final float mask;
        final float maskedItemSize;

        Keyline(float arg1, float arg2, float arg3, float arg4, boolean arg5, float arg6) {
            super();
            this.loc = arg1;
            this.locOffset = arg2;
            this.mask = arg3;
            this.maskedItemSize = arg4;
            this.isAnchor = arg5;
            this.cutoff = arg6;
        }

        Keyline(float arg8, float arg9, float arg10, float arg11) {
            this(arg8, arg9, arg10, arg11, false, 0f);
        }

        static Keyline lerp(Keyline arg5, Keyline arg6, float arg7) {
            return new Keyline(AnimationUtils.lerp(arg5.loc, arg6.loc, arg7), AnimationUtils.lerp(arg5.locOffset, arg6.locOffset, arg7), AnimationUtils.lerp(arg5.mask, arg6.mask, arg7), AnimationUtils.lerp(arg5.maskedItemSize, arg6.maskedItemSize, arg7));
        }
    }

    private final int firstFocalKeylineIndex;
    private final float itemSize;
    private final List keylines;
    private final int lastFocalKeylineIndex;

    private KeylineState(float arg1, List arg2, int arg3, int arg4) {
        super();
        this.itemSize = arg1;
        this.keylines = Collections.unmodifiableList(arg2);
        this.firstFocalKeylineIndex = arg3;
        this.lastFocalKeylineIndex = arg4;
    }

    KeylineState(float arg1, List arg2, int arg3, int arg4, com.google.android.material.carousel.KeylineState$1 arg5) {
        this(arg1, arg2, arg3, arg4);
    }

    Keyline getFirstFocalKeyline() {
        return this.keylines.get(this.firstFocalKeylineIndex);
    }

    int getFirstFocalKeylineIndex() {
        return this.firstFocalKeylineIndex;
    }

    Keyline getFirstKeyline() {
        return this.keylines.get(0);
    }

    Keyline getFirstNonAnchorKeyline() {
        int v0;
        for(v0 = 0; v0 < this.keylines.size(); ++v0) {
            Object v1 = this.keylines.get(v0);
            if(!((Keyline)v1).isAnchor) {
                return ((Keyline)v1);
            }
        }

        return null;
    }

    List getFocalKeylines() {
        return this.keylines.subList(this.firstFocalKeylineIndex, this.lastFocalKeylineIndex + 1);
    }

    float getItemSize() {
        return this.itemSize;
    }

    List getKeylines() {
        return this.keylines;
    }

    Keyline getLastFocalKeyline() {
        return this.keylines.get(this.lastFocalKeylineIndex);
    }

    int getLastFocalKeylineIndex() {
        return this.lastFocalKeylineIndex;
    }

    Keyline getLastKeyline() {
        return this.keylines.get(this.keylines.size() - 1);
    }

    Keyline getLastNonAnchorKeyline() {
        int v0;
        for(v0 = this.keylines.size() - 1; v0 >= 0; --v0) {
            Object v1 = this.keylines.get(v0);
            if(!((Keyline)v1).isAnchor) {
                return ((Keyline)v1);
            }
        }

        return null;
    }

    static KeylineState lerp(KeylineState arg6, KeylineState arg7, float arg8) {
        if(arg6.getItemSize() == arg7.getItemSize()) {
            List v0 = arg6.getKeylines();
            List v1 = arg7.getKeylines();
            if(v0.size() == v1.size()) {
                ArrayList v2 = new ArrayList();
                int v3;
                for(v3 = 0; v3 < arg6.getKeylines().size(); ++v3) {
                    ((List)v2).add(Keyline.lerp(v0.get(v3), v1.get(v3), arg8));
                }

                return new KeylineState(arg6.getItemSize(), ((List)v2), AnimationUtils.lerp(arg6.getFirstFocalKeylineIndex(), arg7.getFirstFocalKeylineIndex(), arg8), AnimationUtils.lerp(arg6.getLastFocalKeylineIndex(), arg7.getLastFocalKeylineIndex(), arg8));
            }

            throw new IllegalArgumentException("Keylines being linearly interpolated must have the same number of keylines.");
        }

        throw new IllegalArgumentException("Keylines being linearly interpolated must have the same item size.");
    }

    static KeylineState reverse(KeylineState arg10, float arg11) {
        Builder v0 = new Builder(arg10.getItemSize(), arg11);
        float v6 = 2f;
        arg11 = arg11 - arg10.getLastKeyline().locOffset - arg10.getLastKeyline().maskedItemSize / v6;
        int v8;
        for(v8 = arg10.getKeylines().size() - 1; v8 >= 0; --v8) {
            Object v9 = arg10.getKeylines().get(v8);
            float v1 = ((Keyline)v9).maskedItemSize / v6 + arg11;
            boolean v4 = v8 < arg10.getFirstFocalKeylineIndex() || v8 > arg10.getLastFocalKeylineIndex() ? false : true;
            v0.addKeyline(v1, ((Keyline)v9).mask, ((Keyline)v9).maskedItemSize, v4, ((Keyline)v9).isAnchor);
            arg11 += ((Keyline)v9).maskedItemSize;
        }

        return v0.build();
    }
}


package androidx.compose.ui.node;

import kotlin.Metadata;

@Metadata(d1={"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0012\u001A \u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u0006H\u0002\u001A\u0018\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u00012\u0006\u0010\n\u001A\u00020\u0006H\u0002\u001A \u0010\u000B\u001A\u00020\b2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\u0006\u0010\n\u001A\u00020\u0006H\u0000\u001AO\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001AW\u0010\u0012\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0019\u001A\u00020\u00032\u0006\u0010\u0015\u001A\u00020\u0016H\u0002¢\u0006\u0004\b\u001A\u0010\u001B\u001AW\u0010\u0014\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0019\u001A\u00020\u00032\u0006\u0010\u0015\u001A\u00020\u0016H\u0002¢\u0006\u0004\b\u001C\u0010\u001B\u001A\r\u0010\u001D\u001A\u00020\u0003*\u00020\rH\u0082\b\u001A8\u0010\u001E\u001A\u00020\b2\u0006\u0010\u001F\u001A\u00020\u00032\u0006\u0010 \u001A\u00020\u00032\u0006\u0010!\u001A\u00020\u00032\u0006\u0010\"\u001A\u00020\u00032\u0006\u0010#\u001A\u00020\r2\u0006\u0010$\u001A\u00020\u0016H\u0000\u001A\u001C\u0010%\u001A\u00020\b*\u00020\u00162\u0006\u0010&\u001A\u00020\u00032\u0006\u0010\'\u001A\u00020\u0003H\u0002¨\u0006("}, d2={"calculateDiff", "Landroidx/compose/ui/node/IntStack;", "oldSize", "", "newSize", "cb", "Landroidx/compose/ui/node/DiffCallback;", "applyDiff", "", "diagonals", "callback", "executeDiff", "midPoint", "", "oldStart", "oldEnd", "newStart", "newEnd", "forward", "Landroidx/compose/ui/node/CenteredArray;", "backward", "snake", "", "midPoint-q5eDKzI", "(IIIILandroidx/compose/ui/node/DiffCallback;[I[I[I)Z", "d", "forward-4l5_RBY", "(IIIILandroidx/compose/ui/node/DiffCallback;[I[II[I)Z", "backward-4l5_RBY", "toInt", "fillSnake", "startX", "startY", "endX", "endY", "reverse", "data", "swap", "i", "j", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class MyersDiffKt {
    public static final void access$swap(int[] arg0, int arg1, int arg2) {
        MyersDiffKt.swap(arg0, arg1, arg2);
    }

    private static final void applyDiff(IntStack arg7, DiffCallback arg8) {
        int v0 = 0;
        int v1 = 0;
        int v2 = 0;
    label_3:
        if(v0 < arg7.getSize()) {
            int v4 = v0 + 2;
            int v3 = arg7.get(v0) - arg7.get(v4);
            int v5 = arg7.get(v0 + 1) - arg7.get(v4);
            v4 = arg7.get(v4);
            v0 += 3;
            while(v1 < v3) {
                arg8.remove(v2, v1);
                ++v1;
            }

            while(v2 < v5) {
                arg8.insert(v2);
                ++v2;
            }

            while(true) {
                v3 = v4 - 1;
                if(v4 <= 0) {
                    goto label_3;
                }

                arg8.same(v1, v2);
                ++v1;
                ++v2;
                v4 = v3;
            }
        }
    }

    private static final boolean backward-4l5_RBY(int arg17, int arg18, int arg19, int arg20, DiffCallback arg21, int[] arg22, int[] arg23, int arg24, int[] arg25) {
        int v11;
        int v10;
        int v0 = arg17;
        int v1 = arg19;
        int[] v2 = arg23;
        int v3 = arg24;
        int v4 = arg18 - v0 - (arg20 - v1);
        int v5 = (v4 & 1) == 0 ? 1 : 0;
        int v8 = -v3;
        int v9;
        for(v9 = v8; v9 <= v3; v9 += 2) {
            if(v9 != v8) {
                if(v9 != v3 && CenteredArray.get-impl(v2, v9 + 1) < CenteredArray.get-impl(v2, v9 - 1)) {
                    goto label_28;
                }

                v10 = CenteredArray.get-impl(v2, v9 - 1);
                v11 = v10 - 1;
            }
            else {
            label_28:
                v10 = CenteredArray.get-impl(v2, v9 + 1);
                v11 = v10;
            }

            int v12 = arg20 - (arg18 - v11 - v9);
            int v13 = v3 != 0 ? 1 : 0;
            int v14 = v11 == v10 ? 1 : 0;
            v13 = (v13 & v14) + v12;
            while(v11 > v0) {
                if(v12 <= v1) {
                    break;
                }

                if(!arg21.areItemsTheSame(v11 - 1, v12 - 1)) {
                    break;
                }

                --v11;
                --v12;
            }

            CenteredArray.set-impl(v2, v9, v11);
            if(v5 != 0) {
                v14 = v4 - v9;
                if(v14 >= v8 && v14 <= v3 && CenteredArray.get-impl(arg22, v14) >= v11) {
                    MyersDiffKt.fillSnake(v11, v12, v10, v13, true, arg25);
                    return 1;
                }
            }
        }

        return 0;
    }

    private static final IntStack calculateDiff(int arg19, int arg20, DiffCallback arg21) {
        int v0 = arg19;
        int v1 = arg20;
        int v3 = 1;
        int v4 = 2;
        int v2 = (v0 + v1 + 1) / v4;
        IntStack v5 = new IntStack(v2 * 3);
        IntStack v6 = new IntStack(v2 * 4);
        v6.pushRange(0, v0, 0, v1);
        v2 = v2 * v4 + 1;
        int[] v14 = CenteredArray.constructor-impl(new int[v2]);
        int[] v15 = CenteredArray.constructor-impl(new int[v2]);
        int[] v16;
        for(v16 = Snake.constructor-impl(new int[5]); v6.isNotEmpty(); v16 = v8) {
            int v12 = v6.pop();
            int v11 = v6.pop();
            int v10 = v6.pop();
            int v9 = v6.pop();
            int[] v8 = v16;
            if(MyersDiffKt.midPoint-q5eDKzI(v9, v10, v11, v12, arg21, v14, v15, v16)) {
                int v13 = 3;
                int v18 = v3;
                if(Math.min(v8[v4] - v8[0], v8[v13] - v8[v3]) > 0) {
                    Snake.addDiagonalToStack-impl(v8, v5);
                }

                v6.pushRange(v9, v8[0], v11, v8[v18]);
                v6.pushRange(v8[v4], v10, v8[v13], v12);
                v16 = v8;
                v3 = v18;
                continue;
            }
        }

        v5.sortDiagonals();
        v5.pushDiagonal(v0, v1, 0);
        return v5;
    }

    public static final void executeDiff(int arg0, int arg1, DiffCallback arg2) {
        MyersDiffKt.applyDiff(MyersDiffKt.calculateDiff(arg0, arg1, arg2), arg2);
    }

    public static final void fillSnake(int arg2, int arg3, int arg4, int arg5, boolean arg6, int[] arg7) {
        if(arg7.length < 5) {
            return;
        }

        arg7[0] = arg2;
        arg7[1] = arg3;
        arg7[2] = arg4;
        arg7[3] = arg5;
        arg7[4] = arg6;
    }

    private static final boolean forward-4l5_RBY(int arg17, int arg18, int arg19, int arg20, DiffCallback arg21, int[] arg22, int[] arg23, int arg24, int[] arg25) {
        int v16_1;
        int v11;
        int v10;
        int v0 = arg18;
        int v1 = arg20;
        int[] v2 = arg22;
        int v3 = arg24;
        int v4 = v0 - arg17 - (v1 - arg19);
        int v6 = 1;
        int v5 = (Math.abs(v4) & 1) == 1 ? 1 : 0;
        int v8 = -v3;
        int v9 = v8;
        while(v9 <= v3) {
            if(v9 != v8) {
                if(v9 != v3 && CenteredArray.get-impl(v2, v9 + 1) > CenteredArray.get-impl(v2, v9 - 1)) {
                    goto label_30;
                }

                v10 = CenteredArray.get-impl(v2, v9 - 1);
                v11 = v10 + 1;
            }
            else {
            label_30:
                v10 = CenteredArray.get-impl(v2, v9 + 1);
                v11 = v10;
            }

            int v12 = arg19 + (v11 - arg17) - v9;
            int v13 = v3 != 0 ? v6 : 0;
            int v14 = v11 == v10 ? v6 : 0;
            v13 = v12 - (v13 & v14);
            while(v11 < v0) {
                if(v12 >= v1) {
                    break;
                }

                if(!arg21.areItemsTheSame(v11, v12)) {
                    break;
                }

                ++v11;
                ++v12;
            }

            CenteredArray.set-impl(v2, v9, v11);
            if(v5 != 0) {
                int v15 = v4 - v9;
                boolean v16 = ((boolean)v6);
                if(v15 >= v8 + 1 && v15 <= v3 - 1 && CenteredArray.get-impl(arg23, v15) <= v11) {
                    MyersDiffKt.fillSnake(v10, v13, v11, v12, false, arg25);
                    return v16;
                }
            }
            else {
                v16_1 = v6;
            }

            v9 += 2;
            boolean v6_1 = ((boolean)v16_1);
        }

        return 0;
    }

    private static final boolean midPoint-q5eDKzI(int arg13, int arg14, int arg15, int arg16, DiffCallback arg17, int[] arg18, int[] arg19, int[] arg20) {
        int v0 = arg14 - arg13;
        int v1 = arg16 - arg15;
        if(v0 >= 1) {
            if(v1 < 1) {
            }
            else {
                v0 = (v0 + v1 + 1) / 2;
                int[] v9 = arg18;
                CenteredArray.set-impl(v9, 1, arg13);
                int[] v10 = arg19;
                CenteredArray.set-impl(v10, 1, arg14);
                int v11 = 0;
                while(v11 < v0) {
                    if(MyersDiffKt.forward-4l5_RBY(arg13, arg14, arg15, arg16, arg17, v9, v10, v11, arg20)) {
                        return 1;
                    }
                    else if(MyersDiffKt.backward-4l5_RBY(arg13, arg14, arg15, arg16, arg17, arg18, arg19, v11, arg20)) {
                        return 1;
                    }
                    else {
                        ++v11;
                        v9 = arg18;
                        v10 = arg19;
                        continue;
                    }

                    return 0;
                }
            }
        }

        return 0;
    }

    private static final void swap(int[] arg2, int arg3, int arg4) {
        int v0 = arg2[arg3];
        arg2[arg3] = arg2[arg4];
        arg2[arg4] = v0;
    }

    private static final int toInt(boolean arg0) {
        return arg0;
    }
}


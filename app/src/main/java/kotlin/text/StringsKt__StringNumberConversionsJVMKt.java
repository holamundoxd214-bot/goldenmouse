package kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000V\n\u0000\n\u0002\u0010\u000E\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\u0010\n\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\f\n\u0002\b\u000E\u001A\u0016\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004\u001A\u0016\u0010\u0000\u001A\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004\u001A\u0016\u0010\u0000\u001A\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004\u001A\u0016\u0010\u0000\u001A\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004\u001A\u0010\u0010\u0007\u001A\u00020\b*\u0004\u0018\u00010\u0001H\u0087\u0088\u0004\u001A\u000E\u0010\t\u001A\u00020\u0002*\u00020\u0001H\u0087\u0088\u0004\u001A\u0016\u0010\t\u001A\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004\u001A\u000E\u0010\n\u001A\u00020\u0005*\u00020\u0001H\u0087\u0088\u0004\u001A\u0016\u0010\n\u001A\u00020\u0005*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004\u001A\u000E\u0010\u000B\u001A\u00020\u0004*\u00020\u0001H\u0087\u0088\u0004\u001A\u0016\u0010\u000B\u001A\u00020\u0004*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004\u001A\u000E\u0010\f\u001A\u00020\u0006*\u00020\u0001H\u0087\u0088\u0004\u001A\u0016\u0010\f\u001A\u00020\u0006*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004\u001A\u000E\u0010\r\u001A\u00020\u000E*\u00020\u0001H\u0087\u0088\u0004\u001A\u000E\u0010\u000F\u001A\u00020\u0010*\u00020\u0001H\u0087\u0088\u0004\u001A\u0015\u0010\u0011\u001A\u0004\u0018\u00010\u000E*\u00020\u0001H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0012\u001A\u0015\u0010\u0013\u001A\u0004\u0018\u00010\u0010*\u00020\u0001H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0014\u001A\u000E\u0010\u0015\u001A\u00020\u0016*\u00020\u0001H\u0087\u0088\u0004\u001A\u0016\u0010\u0015\u001A\u00020\u0016*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004\u001A\u0010\u0010\u0017\u001A\u0004\u0018\u00010\u0016*\u00020\u0001H\u0087\u0080\u0004\u001A\u0018\u0010\u0017\u001A\u0004\u0018\u00010\u0016*\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0080\u0004\u001A\u000E\u0010\u0018\u001A\u00020\u0019*\u00020\u0001H\u0087\u0088\u0004\u001A\u0016\u0010\u0018\u001A\u00020\u0019*\u00020\u00012\u0006\u0010\u001A\u001A\u00020\u001BH\u0087\u0088\u0004\u001A\u0010\u0010\u001C\u001A\u0004\u0018\u00010\u0019*\u00020\u0001H\u0087\u0080\u0004\u001A\u0018\u0010\u001C\u001A\u0004\u0018\u00010\u0019*\u00020\u00012\u0006\u0010\u001A\u001A\u00020\u001BH\u0087\u0080\u0004\u001A5\u0010\u001D\u001A\u0004\u0018\u0001H\u001E\"\u0004\b\u0000\u0010\u001E2\u0006\u0010\u001F\u001A\u00020\u00012\u0012\u0010 \u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u001E0!H\u0082\u0088\u0004¢\u0006\u0004\b\"\u0010#\u001A5\u0010$\u001A\u0004\u0018\u0001H\u001E\"\u0004\b\u0000\u0010\u001E2\u0006\u0010\u001F\u001A\u00020\u00012\u0012\u0010 \u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u001E0!H\u0082\u0088\u0004¢\u0006\u0004\b%\u0010#\u001A\u0017\u0010&\u001A\u00020\b2\u0006\u0010\'\u001A\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b(\u001A\u0017\u0010)\u001A\u00020\b2\u0006\u0010\'\u001A\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b*\u001A!\u0010+\u001A\u0004\u0018\u00010\u00012\u0006\u0010,\u001A\u00020\u00042\u0006\u0010-\u001A\u00020\u0004H\u0083\u0088\u0004¢\u0006\u0002\b.\u001A\u0013\u0010/\u001A\u00020\b*\u000200H\u0083\u0088\u0004¢\u0006\u0002\b1\u001A\u0013\u00102\u001A\u00020\b*\u000200H\u0083\u0088\u0004¢\u0006\u0002\b3\u001A\u0013\u00104\u001A\u00020\u0004*\u000200H\u0083\u0088\u0004¢\u0006\u0002\b5\u001A7\u00106\u001A\u00020\u0004*\u00020\u00012\u0006\u0010,\u001A\u00020\u00042\u0006\u0010-\u001A\u00020\u00042\u0012\u00107\u001A\u000E\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b0!H\u0083\u0088\u0004¢\u0006\u0002\b8\u001A7\u00109\u001A\u00020\u0004*\u00020\u00012\u0006\u0010,\u001A\u00020\u00042\u0006\u0010-\u001A\u00020\u00042\u0012\u00107\u001A\u000E\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b0!H\u0083\u0088\u0004¢\u0006\u0002\b:\u001A?\u0010;\u001A\u00020\u0004*\u00020\u00012\u0006\u0010,\u001A\u00020\u00042\u0006\u0010-\u001A\u00020\u00042\u0006\u0010<\u001A\u00020\b2\u0012\u00107\u001A\u000E\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b0!H\u0083\u0088\u0004¢\u0006\u0002\b=¨\u0006>"}, d2={"toString", "", "", "radix", "", "", "", "toBoolean", "", "toByte", "toShort", "toInt", "toLong", "toFloat", "", "toDouble", "", "toFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "toDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "toBigInteger", "Ljava/math/BigInteger;", "toBigIntegerOrNull", "toBigDecimal", "Ljava/math/BigDecimal;", "mathContext", "Ljava/math/MathContext;", "toBigDecimalOrNull", "screenFloatValue", "T", "str", "parse", "Lkotlin/Function1;", "screenFloatValue$StringsKt__StringNumberConversionsJVMKt", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "screenBigDecimalValue", "screenBigDecimalValue$StringsKt__StringNumberConversionsJVMKt", "isValidFloat", "s", "isValidFloat$StringsKt__StringNumberConversionsJVMKt", "isValidBigDecimal", "isValidBigDecimal$StringsKt__StringNumberConversionsJVMKt", "guessNamedFloatConstant", "start", "endInclusive", "guessNamedFloatConstant$StringsKt__StringNumberConversionsJVMKt", "isAsciiDigit", "", "isAsciiDigit$StringsKt__StringNumberConversionsJVMKt", "isHexLetter", "isHexLetter$StringsKt__StringNumberConversionsJVMKt", "asciiLetterToLowerCaseCode", "asciiLetterToLowerCaseCode$StringsKt__StringNumberConversionsJVMKt", "advanceWhile", "predicate", "advanceWhile$StringsKt__StringNumberConversionsJVMKt", "backtrackWhile", "backtrackWhile$StringsKt__StringNumberConversionsJVMKt", "advanceAndValidateMantissa", "hexFormat", "advanceAndValidateMantissa$StringsKt__StringNumberConversionsJVMKt", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/text/StringsKt") class StringsKt__StringNumberConversionsJVMKt extends StringsKt__StringBuilderKt {
    public StringsKt__StringNumberConversionsJVMKt() {
        super();
    }

    private static final int advanceAndValidateMantissa$StringsKt__StringNumberConversionsJVMKt(String arg6, int arg7, int arg8, boolean arg9, Function1 arg10) {
        String v7;
        int v4;
        int v0;
        for(v0 = arg7; v0 <= arg8; ++v0) {
            if(!arg10.invoke(Character.valueOf(arg6.charAt(v0))).booleanValue()) {
                break;
            }
        }

        arg7 = arg7 != v0 ? 1 : 0;
        int v3 = -1;
        if(v0 > arg8) {
            if(arg9) {
                return v3;
            }

            return v0;
        }

        if(arg6.charAt(v0) == 46) {
            ++v0;
            v4 = v0;
            goto label_25;
        }
        else {
            int v10 = 0;
            goto label_40;
        label_25:
            while(v4 <= arg8) {
                if(!arg10.invoke(Character.valueOf(arg6.charAt(v4))).booleanValue()) {
                    break;
                }

                ++v4;
            }

            v10 = v0 != v4 ? 1 : 0;
            v0 = v4;
        }

    label_40:
        if(arg7 == 0 && v10 == 0) {
            if(arg9) {
                return v3;
            }
            else {
                if(arg8 == v0 + 2) {
                    v7 = "NaN";
                }
                else if(arg8 == v0 + 7) {
                    v7 = "Infinity";
                }
                else {
                    v7 = null;
                }

                if(v7 == null) {
                    return v3;
                }

                if(StringsKt.indexOf(((CharSequence)arg6), v7, v0, false) == v0) {
                    return arg8 + 1;
                }

                return v3;
            }
        }

        return v0;
    }

    private static final int advanceWhile$StringsKt__StringNumberConversionsJVMKt(String arg1, int arg2, int arg3, Function1 arg4) {
        while(arg2 <= arg3) {
            if(!arg4.invoke(Character.valueOf(arg1.charAt(arg2))).booleanValue()) {
                return arg2;
            }

            ++arg2;
        }

        return arg2;
    }

    private static final int asciiLetterToLowerCaseCode$StringsKt__StringNumberConversionsJVMKt(char arg0) {
        return arg0 | 0x20;
    }

    private static final int backtrackWhile$StringsKt__StringNumberConversionsJVMKt(String arg1, int arg2, int arg3, Function1 arg4) {
        while(arg3 > arg2) {
            if(!arg4.invoke(Character.valueOf(arg1.charAt(arg3))).booleanValue()) {
                return arg3;
            }

            --arg3;
        }

        return arg3;
    }

    private static final String guessNamedFloatConstant$StringsKt__StringNumberConversionsJVMKt(int arg1, int arg2) {
        if(arg2 == arg1 + 2) {
            return "NaN";
        }

        if(arg2 == arg1 + 7) {
            return "Infinity";
        }

        return null;
    }

    private static final boolean isAsciiDigit$StringsKt__StringNumberConversionsJVMKt(char arg1) {
        if((arg1 - 0x30 & 0xFFFF) < 10) {
            return 1;
        }

        return 0;
    }

    private static final boolean isHexLetter$StringsKt__StringNumberConversionsJVMKt(char arg1) {
        if(((arg1 | 0x20) - 97 & 0xFFFF) < 6) {
            return 1;
        }

        return 0;
    }

    private static final boolean isValidBigDecimal$StringsKt__StringNumberConversionsJVMKt(String arg8) {
        if(arg8.length() == 0) {
            return 0;
        }

        int v2 = 43;
        int v3 = 45;
        int v0 = arg8.charAt(0) == v3 || arg8.charAt(0) == v2 ? 1 : 0;
        int v5;
        for(v5 = v0; v5 < arg8.length(); ++v5) {
            if(!Character.isDigit(arg8.charAt(v5))) {
                break;
            }
        }

        if(v5 == arg8.length()) {
            if(v5 - v0 > 0) {
                return 1;
            }

            return 0;
        }

        if(arg8.charAt(v5) == 46) {
            ++v5;
            if(v5 == arg8.length()) {
                if(v5 - v0 > 1) {
                    return 1;
                }
                else {
                    return 0;
                }
            }

            while(v5 < arg8.length()) {
                if(!Character.isDigit(arg8.charAt(v5))) {
                    break;
                }

                ++v5;
            }
        }

        if(v5 == arg8.length()) {
            return 1;
        }

        if(arg8.charAt(v5) != 101 && arg8.charAt(v5) != 69) {
            return 0;
        }

        v0 = v5 + 1;
        if(v0 == arg8.length()) {
            return 0;
        }

        if(arg8.charAt(v0) == v2 || arg8.charAt(v0) == v3) {
            v0 = v5 + 2;
        }

        if(v0 == arg8.length()) {
            return 0;
        }

        while(v0 < arg8.length()) {
            if(!Character.isDigit(arg8.charAt(v0))) {
                break;
            }

            ++v0;
        }

        if(v0 == arg8.length()) {
            return 1;
        }

        return 0;
    }

    private static final boolean isValidFloat$StringsKt__StringNumberConversionsJVMKt(String arg19) {
        String v4_2;
        boolean v5_1;
        int v15;
        int v14;
        int v2_1;
        boolean v17;
        int v6;
        int v5;
        String v0 = arg19;
        boolean v2 = true;
        int v1 = v0.length() - 1;
        int v4 = 0;
        while(true) {
            v5 = 0x20;
            if(v4 <= v1 && v0.charAt(v4) <= v5) {
                ++v4;
                continue;
            }

            break;
        }

        if(v4 > v1) {
            return 0;
        }

        while(v1 > v4) {
            if(v0.charAt(v1) > v5) {
                break;
            }

            --v1;
        }

        int v7 = 45;
        int v8 = 43;
        if(v0.charAt(v4) == v8 || v0.charAt(v4) == v7) {
            ++v4;
        }

        if(v4 > v1) {
            return 0;
        }

        int v9 = 46;
        int v10 = 10;
        int v11 = 0x30;
        int v12 = 0xFFFF;
        int v13 = -1;
        if(v0.charAt(v4) == v11) {
            v6 = v4 + 1;
            if(v6 > v1) {
                return 1;
            }
            else if((v0.charAt(v6) | v5) == 120) {
                v4 += 2;
                v6 = v4;
                goto label_44;
            }
            else {
                goto label_105;
            }
        }
        else {
        label_105:
            v17 = true;
            v2_1 = 0;
            goto label_108;
            while(true) {
            label_44:
                v14 = 6;
                if(v6 > v1) {
                    break;
                }

                v15 = v0.charAt(v6);
                v17 = v2;
                if((v15 - 0x30 & v12) < v10) {
                }
                else {
                    if(((v15 | 0x20) - 97 & v12) < v14) {
                        goto label_56;
                    }

                    goto label_60;
                }

            label_56:
                ++v6;
                v2 = v17;
            }

            v17 = v2;
        label_60:
            if(v4 != v6) {
                v2 = v17;
            }
            else {
                v2_1 = 0;
            }

            if(v6 > v1) {
                goto label_66;
            }
            else {
                if(v0.charAt(v6) == v9) {
                    ++v6;
                    v4 = v6;
                    goto label_72;
                }
                else {
                    v5 = 0;
                    goto label_95;
                label_72:
                    while(v4 <= v1) {
                        v15 = v0.charAt(v4);
                        int v18 = v5;
                        if((v15 - 0x30 & v12) < v10) {
                        }
                        else {
                            if(((v15 | 0x20) - 97 & v12) < v14) {
                                goto label_83;
                            }

                            break;
                        }

                    label_83:
                        ++v4;
                        v5 = v18;
                    }

                    if(v6 != v4) {
                        v5_1 = v17;
                    }
                    else {
                        v5 = 0;
                    }

                    v6 = v4;
                }

            label_95:
                if(((((boolean)v2_1))) || (v5_1)) {
                    v4 = v6;
                    goto label_99;
                }

            label_66:
                v4 = v13;
            }

        label_99:
            if(v4 != v13) {
                if(v4 > v1) {
                }
                else {
                    v2 = v17;
                    goto label_108;
                }
            }

            return 0;
        }

    label_108:
        if(!(((boolean)v2_1))) {
            for(v5 = v4; v5 <= v1; ++v5) {
                if((v0.charAt(v5) - v11 & v12) >= v10) {
                    break;
                }
            }

            if(v4 != v5) {
                boolean v4_1 = v17;
            }
            else {
                v4 = 0;
            }

            if(v5 > v1) {
                v4 = v5;
            }
            else {
                if(v0.charAt(v5) == v9) {
                    ++v5;
                    v6 = v5;
                    goto label_128;
                }
                else {
                    v6 = v5;
                    goto label_139;
                label_128:
                    while(v6 <= v1) {
                        if((v0.charAt(v6) - v11 & v12) >= v10) {
                            break;
                        }

                        ++v6;
                    }

                    if(v5 != v6) {
                        v5_1 = v17;
                        goto label_140;
                    }

                label_139:
                    v5 = 0;
                }

            label_140:
                if(!(((boolean)v4)) && !v5_1) {
                    if(v1 == v6 + 2) {
                        v4_2 = "NaN";
                    }
                    else if(v1 == v6 + 7) {
                        v4_2 = "Infinity";
                    }
                    else {
                        v4_2 = null;
                    }

                    if(v4_2 != null && StringsKt.indexOf(v0, v4_2, v6, false) == v6) {
                        v4 = v1 + 1;
                        goto label_160;
                    }

                    v4 = v13;
                    goto label_160;
                }

                v4 = v6;
            }

        label_160:
            if(v4 == v13) {
                return 0;
            }

            if(v4 <= v1) {
                goto label_164;
            }

            return v17;
        }

    label_164:
        v5 = v4 + 1;
        v6 = v0.charAt(v4) | 0x20;
        v9 = (((boolean)v2_1)) ? 0x70 : 101;
        v13 = 100;
        v14 = 102;
        if(v6 != v9) {
            if(!(((boolean)v2_1)) && (v6 == v14 || v6 == v13) && v5 > v1) {
                return v17;
            }

            return 0;
        }

        if(v5 > v1) {
            return 0;
        }

        if(v0.charAt(v5) == v8 || v0.charAt(v5) == v7) {
            v5 = v4 + 2;
            if(v5 > v1) {
                return 0;
            }
        }

        while(v5 <= v1) {
            if((v0.charAt(v5) - v11 & v12) >= v10) {
                break;
            }

            ++v5;
        }

        if(v5 > v1) {
            return v17;
        }

        if(v5 == v1) {
            int v0_1 = v0.charAt(v5) | 0x20;
            if(v0_1 != v14) {
                if(v0_1 == v13) {
                }
                else {
                    return 0;
                }
            }

            return v17;
        }

        return 0;
    }

    private static final Object screenBigDecimalValue$StringsKt__StringNumberConversionsJVMKt(String arg2, Function1 arg3) {
        Object v0 = null;
        try {
            if(!StringsKt__StringNumberConversionsJVMKt.isValidBigDecimal$StringsKt__StringNumberConversionsJVMKt(arg2)) {
                return v0;
            }

            return arg3.invoke(arg2);
        }
        catch(NumberFormatException ) {
            return v0;
        }
    }

    private static final Object screenFloatValue$StringsKt__StringNumberConversionsJVMKt(String arg2, Function1 arg3) {
        Object v0 = null;
        try {
            if(!StringsKt__StringNumberConversionsJVMKt.isValidFloat$StringsKt__StringNumberConversionsJVMKt(arg2)) {
                return v0;
            }

            return arg3.invoke(arg2);
        }
        catch(NumberFormatException ) {
            return v0;
        }
    }

    private static final BigDecimal toBigDecimal(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new BigDecimal(arg1);
    }

    private static final BigDecimal toBigDecimal(String arg1, MathContext arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "mathContext");
        return new BigDecimal(arg1, arg2);
    }

    public static final BigDecimal toBigDecimalOrNull(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        BigDecimal v0 = null;
        try {
            if(!StringsKt__StringNumberConversionsJVMKt.isValidBigDecimal$StringsKt__StringNumberConversionsJVMKt(arg2)) {
                return v0;
            }

            return new BigDecimal(arg2);
        }
        catch(NumberFormatException ) {
            return v0;
        }
    }

    public static final BigDecimal toBigDecimalOrNull(String arg2, MathContext arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "mathContext");
        BigDecimal v0 = null;
        try {
            if(!StringsKt__StringNumberConversionsJVMKt.isValidBigDecimal$StringsKt__StringNumberConversionsJVMKt(arg2)) {
                return v0;
            }

            return new BigDecimal(arg2, arg3);
        }
        catch(NumberFormatException ) {
            return v0;
        }
    }

    private static final BigInteger toBigInteger(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new BigInteger(arg1);
    }

    private static final BigInteger toBigInteger(String arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new BigInteger(arg1, CharsKt.checkRadix(arg2));
    }

    public static final BigInteger toBigIntegerOrNull(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return StringsKt.toBigIntegerOrNull(arg1, 10);
    }

    public static final BigInteger toBigIntegerOrNull(String arg6, int arg7) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        CharsKt.checkRadix(arg7);
        int v0 = arg6.length();
        BigInteger v1 = null;
        if(v0 != 0) {
            int v2 = 0;
            if(v0 != 1) {
                if(arg6.charAt(0) == 45) {
                    v2 = 1;
                }

                while(v2 < v0) {
                    if(CharsKt.digitOf(arg6.charAt(v2), arg7) < 0) {
                        return v1;
                    }

                    ++v2;
                }
            }
            else {
                if(CharsKt.digitOf(arg6.charAt(0), arg7) >= 0) {
                    goto label_24;
                }

                return v1;
            }

        label_24:
            return new BigInteger(arg6, CharsKt.checkRadix(arg7));
        }

        return v1;
    }

    private static final boolean toBoolean(String arg0) {
        return Boolean.parseBoolean(arg0);
    }

    private static final byte toByte(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return Byte.parseByte(arg1);
    }

    private static final byte toByte(String arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return Byte.parseByte(arg1, CharsKt.checkRadix(arg2));
    }

    private static final double toDouble(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return Double.parseDouble(arg2);
    }

    public static final Double toDoubleOrNull(String arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Double v0 = null;
        try {
            if(!StringsKt__StringNumberConversionsJVMKt.isValidFloat$StringsKt__StringNumberConversionsJVMKt(arg3)) {
                return v0;
            }

            return Double.valueOf(Double.parseDouble(arg3));
        }
        catch(NumberFormatException ) {
            return v0;
        }
    }

    private static final float toFloat(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return Float.parseFloat(arg1);
    }

    public static final Float toFloatOrNull(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Float v0 = null;
        try {
            if(!StringsKt__StringNumberConversionsJVMKt.isValidFloat$StringsKt__StringNumberConversionsJVMKt(arg2)) {
                return v0;
            }

            return Float.valueOf(Float.parseFloat(arg2));
        }
        catch(NumberFormatException ) {
            return v0;
        }
    }

    private static final int toInt(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return Integer.parseInt(arg1);
    }

    private static final int toInt(String arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return Integer.parseInt(arg1, CharsKt.checkRadix(arg2));
    }

    private static final long toLong(String arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return Long.parseLong(arg2);
    }

    private static final long toLong(String arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return Long.parseLong(arg1, CharsKt.checkRadix(arg2));
    }

    private static final short toShort(String arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return Short.parseShort(arg1);
    }

    private static final short toShort(String arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return Short.parseShort(arg1, CharsKt.checkRadix(arg2));
    }

    private static final String toString(byte arg0, int arg1) {
        String v0 = Integer.toString(arg0, CharsKt.checkRadix(arg1));
        Intrinsics.checkNotNullExpressionValue(v0, "toString(...)");
        return v0;
    }

    private static final String toString(int arg0, int arg1) {
        String v0 = Integer.toString(arg0, CharsKt.checkRadix(arg1));
        Intrinsics.checkNotNullExpressionValue(v0, "toString(...)");
        return v0;
    }

    private static final String toString(long arg0, int arg2) {
        String v0 = Long.toString(arg0, CharsKt.checkRadix(arg2));
        Intrinsics.checkNotNullExpressionValue(v0, "toString(...)");
        return v0;
    }

    private static final String toString(short arg0, int arg1) {
        String v0 = Integer.toString(arg0, CharsKt.checkRadix(arg1));
        Intrinsics.checkNotNullExpressionValue(v0, "toString(...)");
        return v0;
    }
}


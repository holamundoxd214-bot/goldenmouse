package kotlin.time;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000F\n\u0000\n\u0002\u0010\u000B\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\f\n\u0002\u0010\u0015\n\u0002\b\u0006\u001A\u0012\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0010H\u0082\u0080\u0004\u001A\u0012\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u0002H\u0082\u0080\u0004\u001A(\u0010\u0017\u001A\u00020\t2\u0006\u0010\u0018\u001A\u00020\t2\u0006\u0010\u0019\u001A\u00020\t2\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u001C0\u001BH\u0082\u0088\u0004\u001A(\u0010\u001D\u001A\u00020\t2\u0006\u0010\u0018\u001A\u00020\t2\u0006\u0010\u0019\u001A\u00020\t2\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u001C0\u001BH\u0082\u0088\u0004\u001A\u0012\u0010%\u001A\u00020\u00012\u0006\u0010&\u001A\u00020\u0015H\u0080\u0080\u0004\u001A\u0016\u0010\'\u001A\u00020\u0015*\u00020\u00152\u0006\u0010%\u001A\u00020\u0001H\u0082\u0080\u0004\u001A\u0016\u0010-\u001A\u00020\u0012*\u00020\u00102\u0006\u0010.\u001A\u00020\u0015H\u0082\u0080\u0004\" \u0010\u0000\u001A\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0000\u0010\u0005\" \u0010\u0006\u001A\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0084\b¢\u0006\f\u0012\u0004\b\u0007\u0010\u0004\u001A\u0004\b\u0006\u0010\u0005\"\u000F\u0010\b\u001A\u00020\tX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010\n\u001A\u00020\tX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010\u000B\u001A\u00020\tX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010\f\u001A\u00020\tX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010\u0014\u001A\u00020\u0015X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010\u0016\u001A\u00020\u0015X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010\u001E\u001A\u00020\u0015X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010\u001F\u001A\u00020\u0015X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010 \u001A\u00020\u0015X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010!\u001A\u00020\u0015X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010\"\u001A\u00020\u0015X\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010#\u001A\u00020\u0015X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010$\u001A\u00020\u0015X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010(\u001A\u00020)X\u0082\u0084\b¢\u0006\u0002\n\u0000\"\u000F\u0010*\u001A\u00020)X\u0082\u0084\b¢\u0006\u0002\n\u0000\"\u000F\u0010+\u001A\u00020)X\u0082\u0084\b¢\u0006\u0002\n\u0000\"\u000F\u0010,\u001A\u00020)X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006/"}, d2={"isDistantPast", "", "Lkotlin/time/Instant;", "isDistantPast$annotations", "(Lkotlin/time/Instant;)V", "(Lkotlin/time/Instant;)Z", "isDistantFuture", "isDistantFuture$annotations", "DISTANT_PAST_SECONDS", "", "DISTANT_FUTURE_SECONDS", "MIN_SECOND", "MAX_SECOND", "parseIso", "Lkotlin/time/InstantParseResult;", "isoString", "", "formatIso", "", "instant", "DAYS_PER_CYCLE", "", "DAYS_0000_TO_1970", "safeAddOrElse", "a", "b", "action", "Lkotlin/Function0;", "", "safeMultiplyOrElse", "SECONDS_PER_HOUR", "SECONDS_PER_MINUTE", "HOURS_PER_DAY", "SECONDS_PER_DAY", "NANOS_PER_SECOND", "NANOS_PER_MILLI", "MILLIS_PER_SECOND", "isLeapYear", "year", "monthLength", "POWERS_OF_TEN", "", "asciiDigitPositionsInIsoStringAfterYear", "colonsInIsoOffsetString", "asciiDigitsInIsoOffsetString", "truncateForErrorMessage", "maxLength", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class InstantKt {
    private static final int DAYS_0000_TO_1970 = 0xAFAA8;
    private static final int DAYS_PER_CYCLE = 146097;
    private static final long DISTANT_FUTURE_SECONDS = 3093527980800L;
    private static final long DISTANT_PAST_SECONDS = -3217862419201L;
    private static final int HOURS_PER_DAY = 24;
    private static final long MAX_SECOND = 0x701CD2FA9578FFL;
    private static final int MILLIS_PER_SECOND = 1000;
    private static final long MIN_SECOND = -31557014167219200L;
    private static final int NANOS_PER_MILLI = 1000000;
    public static final int NANOS_PER_SECOND = 1000000000;
    private static final int[] POWERS_OF_TEN = null;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final int[] asciiDigitPositionsInIsoStringAfterYear;
    private static final int[] asciiDigitsInIsoOffsetString;
    private static final int[] colonsInIsoOffsetString;

    static {
        InstantKt.POWERS_OF_TEN = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
        InstantKt.asciiDigitPositionsInIsoStringAfterYear = new int[]{1, 2, 4, 5, 7, 8, 10, 11, 13, 14};
        InstantKt.colonsInIsoOffsetString = new int[]{3, 6};
        InstantKt.asciiDigitsInIsoOffsetString = new int[]{1, 2, 4, 5, 7, 8};
    }

    public static final String access$formatIso(Instant arg0) {
        return InstantKt.formatIso(arg0);
    }

    public static final InstantParseResult access$parseIso(CharSequence arg0) {
        return InstantKt.parseIso(arg0);
    }

    public static final String access$truncateForErrorMessage(CharSequence arg0, int arg1) {
        return InstantKt.truncateForErrorMessage(arg0, arg1);
    }

    private static final String formatIso(Instant arg7) {
        int[] v2_1;
        StringBuilder v0 = new StringBuilder();
        UnboundLocalDateTime v7 = UnboundLocalDateTime.Companion.fromInstant(arg7);
        int v1 = v7.getYear();
        int v4 = 0;
        int v6 = 10000;
        if(Math.abs(v1) < 1000) {
            StringBuilder v2 = new StringBuilder();
            String v3 = "deleteCharAt(...)";
            if(v1 >= 0) {
                Intrinsics.checkNotNullExpressionValue(v2.append(v1 + v6).deleteCharAt(0), v3);
            }
            else {
                Intrinsics.checkNotNullExpressionValue(v2.append(v1 - v6).deleteCharAt(1), v3);
            }

            v0.append(((CharSequence)v2));
        }
        else {
            if(v1 >= v6) {
                v0.append('+');
            }

            v0.append(v1);
        }

        v0.append('-');
        InstantKt.formatIso$lambda$0$appendTwoDigits(v0, v0, v7.getMonth());
        v0.append('-');
        InstantKt.formatIso$lambda$0$appendTwoDigits(v0, v0, v7.getDay());
        v0.append('T');
        InstantKt.formatIso$lambda$0$appendTwoDigits(v0, v0, v7.getHour());
        v0.append(':');
        InstantKt.formatIso$lambda$0$appendTwoDigits(v0, v0, v7.getMinute());
        v0.append(':');
        InstantKt.formatIso$lambda$0$appendTwoDigits(v0, v0, v7.getSecond());
        if(v7.getNanosecond() != 0) {
            v0.append('.');
            while(true) {
                v1 = v7.getNanosecond();
                v2_1 = InstantKt.POWERS_OF_TEN;
                int v3_1 = v4 + 1;
                if(v1 % v2_1[v3_1] != 0) {
                    break;
                }

                v4 = v3_1;
            }

            v4 -= v4 % 3;
            String v7_1 = String.valueOf(v7.getNanosecond() / v2_1[v4] + v2_1[9 - v4]);
            Intrinsics.checkNotNull(v7_1, "null cannot be cast to non-null type java.lang.String");
            v7_1 = v7_1.substring(1);
            Intrinsics.checkNotNullExpressionValue(v7_1, "substring(...)");
            v0.append(v7_1);
        }

        v0.append('Z');
        return v0.toString();
    }

    private static final void formatIso$lambda$0$appendTwoDigits(Appendable arg1, StringBuilder arg2, int arg3) {
        if(arg3 < 10) {
            arg1.append('0');
        }

        arg2.append(arg3);
    }

    private static final boolean isDistantFuture(Instant arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.compareTo(Instant.Companion.getDISTANT_FUTURE()) >= 0) {
            return 1;
        }

        return 0;
    }

    public static void isDistantFuture$annotations(Instant arg0) {
    }

    private static final boolean isDistantPast(Instant arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg1.compareTo(Instant.Companion.getDISTANT_PAST()) <= 0) {
            return 1;
        }

        return 0;
    }

    public static void isDistantPast$annotations(Instant arg0) {
    }

    public static final boolean isLeapYear(int arg1) {
        if((arg1 & 3) == 0 && (arg1 % 100 != 0 || arg1 % 400 == 0)) {
            return 1;
        }

        return 0;
    }

    private static final int monthLength(int arg1, boolean arg2) {
        if(arg1 != 2) {
            if(arg1 != 4 && arg1 != 6 && arg1 != 9 && arg1 != 11) {
                return 0x1F;
            }

            return 30;
        }

        if(arg2) {
            return 29;
        }

        return 28;
    }

    private static final InstantParseResult parseIso(CharSequence arg25) {
        int v15;
        int v22;
        int v10;
        int v12;
        int v11;
        int v7;
        CharSequence v0 = arg25;
        if(v0.length() == 0) {
            return new Failure("An empty string is not a valid Instant", v0);
        }

        int v2 = v0.charAt(0);
        int v3 = 0x20;
        int v4 = 43;
        int v5 = 45;
        if(v2 == v4 || v2 == v5) {
            v7 = 1;
        }
        else {
            v7 = 0;
            v2 = v3;
        }

        int v9 = 0;
        int v8 = v7;
        while(true) {
            v11 = 58;
            v12 = 0x30;
            if(v8 < v0.length()) {
                v10 = v0.charAt(v8);
                if(v12 <= v10 && v10 < v11) {
                    v9 = v9 * 10 + (v0.charAt(v8) - v12);
                    ++v8;
                    continue;
                }
            }

            break;
        }

        v10 = v8 - v7;
        String v13 = " digits";
        int v14 = 10;
        if(v10 > v14) {
            return InstantKt.parseIso$parseFailure(v0, "Expected at most 10 digits for the year number, got " + v10 + v13);
        }

        if(v10 == v14 && Intrinsics.compare(v0.charAt(v7), 50) >= 0) {
            return InstantKt.parseIso$parseFailure(v0, "Expected at most 9 digits for the year number or year 1000000000, got " + v10 + v13);
        }

        v7 = 4;
        if(v10 < v7) {
            return InstantKt.parseIso$parseFailure(v0, "The year number must be padded to 4 digits, got " + v10 + v13);
        }

        if(v2 == v4 && v10 == v7) {
            return InstantKt.parseIso$parseFailure(v0, "The \'+\' sign at the start is only valid for year numbers longer than 4 digits");
        }

        if(v2 == v3 && v10 != v7) {
            return InstantKt.parseIso$parseFailure(v0, "A \'+\' or \'-\' sign is required for year numbers longer than 4 digits");
        }

        if(v2 == v5) {
            v9 = -v9;
        }

        int v16 = v9;
        v3 = v8 + 16;
        if(v0.length() < v3) {
            return InstantKt.parseIso$parseFailure(v0, "The input string is too short");
        }

        String v7_1 = "\'-\'";
        Failure v2_1 = InstantKt.parseIso$expect(v0, v7_1, v8, new InstantKt$$ExternalSyntheticLambda0());
        if(v2_1 != null) {
            return ((InstantParseResult)v2_1);
        }

        v2_1 = InstantKt.parseIso$expect(v0, v7_1, v8 + 3, new InstantKt$$ExternalSyntheticLambda1());
        if(v2_1 != null) {
            return ((InstantParseResult)v2_1);
        }

        v2_1 = InstantKt.parseIso$expect(v0, "\'T\' or \'t\'", v8 + 6, new InstantKt$$ExternalSyntheticLambda2());
        if(v2_1 != null) {
            return ((InstantParseResult)v2_1);
        }

        String v9_1 = "\':\'";
        v2_1 = InstantKt.parseIso$expect(v0, v9_1, v8 + 9, new InstantKt$$ExternalSyntheticLambda3());
        if(v2_1 != null) {
            return ((InstantParseResult)v2_1);
        }

        v2_1 = InstantKt.parseIso$expect(v0, v9_1, v8 + 12, new InstantKt$$ExternalSyntheticLambda4());
        if(v2_1 != null) {
            return ((InstantParseResult)v2_1);
        }

        int[] v2_2 = InstantKt.asciiDigitPositionsInIsoStringAfterYear;
        v7 = v2_2.length;
        for(v9 = 0; v9 < v7; ++v9) {
            Failure v1 = InstantKt.parseIso$expect(v0, "an ASCII digit", v2_2[v9] + v8, new InstantKt$$ExternalSyntheticLambda5());
            if(v1 != null) {
                return ((InstantParseResult)v1);
            }
        }

        int v1_1 = InstantKt.parseIso$twoDigitNumber(v0, v8 + 1);
        v2 = InstantKt.parseIso$twoDigitNumber(v0, v8 + 4);
        v7 = InstantKt.parseIso$twoDigitNumber(v0, v8 + 7);
        v9 = InstantKt.parseIso$twoDigitNumber(v0, v8 + 10);
        v10 = InstantKt.parseIso$twoDigitNumber(v0, v8 + 13);
        v8 += 15;
        v4 = 9;
        if(v0.charAt(v8) == 46) {
            v8 = v3;
            v5 = 0;
            goto label_152;
        }
        else {
            v22 = 0;
            goto label_181;
        label_152:
            while(v8 < v0.length()) {
                v15 = v0.charAt(v8);
                if(v12 > v15) {
                    break;
                }

                if(v15 >= v11) {
                    break;
                }

                v5 = v5 * 10 + (v0.charAt(v8) - v12);
                ++v8;
            }

            v3 = v8 - v3;
            if(1 <= v3 && v3 < v14) {
                v22 = v5 * InstantKt.POWERS_OF_TEN[9 - v3];
                goto label_181;
            }

            return InstantKt.parseIso$parseFailure(v0, "1..9 digits are supported for the fraction of the second, got " + v3 + v13);
        }

    label_181:
        if(v8 >= v0.length()) {
            return InstantKt.parseIso$parseFailure(v0, "The UTC offset at the end of the string is missing");
        }

        char v3_1 = v0.charAt(v8);
        char v5_1 = '\'';
        v13 = ", got \'";
        if(v3_1 == 43 || v3_1 == 45) {
            v15 = v0.length() - v8;
            if(v15 > v4) {
                return InstantKt.parseIso$parseFailure(v0, "The UTC offset string \"" + InstantKt.truncateForErrorMessage(v0.subSequence(v8, v0.length()).toString(), 16) + "\" is too long");
            }

            if(v15 % 3 != 0) {
                return InstantKt.parseIso$parseFailure(v0, "Invalid UTC offset string \"" + v0.subSequence(v8, v0.length()).toString() + '\"');
            }

            int[] v4_1 = InstantKt.colonsInIsoOffsetString;
            int v6 = v4_1.length;
            v14 = 0;
            while(v14 < v6) {
                v12 = v8 + v4_1[v14];
                if(v12 >= v0.length()) {
                }
                else if(v0.charAt(v12) != v11) {
                    return InstantKt.parseIso$parseFailure(v0, "Expected \':\' at index " + v12 + v13 + v0.charAt(v12) + '\'');
                }
                else {
                    ++v14;
                    continue;
                }

                break;
            }

            v4_1 = InstantKt.asciiDigitsInIsoOffsetString;
            v5 = v4_1.length;
            v6 = 0;
            while(true) {
                if(v6 < v5) {
                    v12 = v4_1[v6] + v8;
                    if(v12 >= v0.length()) {
                    }
                    else {
                        v14 = v0.charAt(v12);
                        int[] v24 = v4_1;
                        if(0x30 <= v14 && v14 < v11) {
                            ++v6;
                            v4_1 = v24;
                            continue;
                        }

                        break;
                    }
                }

                goto label_307;
            }

            return InstantKt.parseIso$parseFailure(v0, "Expected an ASCII digit at index " + v12 + v13 + v0.charAt(v12) + '\'');
        label_307:
            v4 = InstantKt.parseIso$twoDigitNumber(v0, v8 + 1);
            v5 = v15 > 3 ? InstantKt.parseIso$twoDigitNumber(v0, v8 + 4) : 0;
            v6 = v15 > 6 ? InstantKt.parseIso$twoDigitNumber(v0, v8 + 7) : 0;
            v11 = 59;
            if(v5 > v11) {
                return InstantKt.parseIso$parseFailure(v0, "Expected offset-minute-of-hour in 0..59, got " + v5);
            }

            if(v6 > v11) {
                return InstantKt.parseIso$parseFailure(v0, "Expected offset-second-of-minute in 0..59, got " + v6);
            }

            if(v4 > 17 && (v4 != 18 || v5 != 0 || v6 != 0)) {
                return InstantKt.parseIso$parseFailure(v0, "Expected an offset in -18:00..+18:00, got " + v0.subSequence(v8, v0.length()).toString());
            }

            v4 = v4 * 3600 + v5 * 60 + v6;
            v3 = v3_1 == 45 ? -1 : 1;
            v3 *= v4;
            v4 = 1;
        }
        else {
            if(v3_1 != 90 && v3_1 != 0x7A) {
                return InstantKt.parseIso$parseFailure(v0, "Expected the UTC offset at position " + v8 + v13 + v3_1 + v5_1);
            }

            ++v8;
            if(v0.length() == v8) {
                v4 = 1;
                v3 = 0;
                goto label_365;
            }

            return InstantKt.parseIso$parseFailure(v0, "Extra text after the instant at position " + v8);
        }

    label_365:
        if(v4 <= v1_1 && v1_1 < 13) {
            if(v4 <= v2 && v2 <= InstantKt.monthLength(v1_1, InstantKt.isLeapYear(v16))) {
                if(v7 > 23) {
                    return InstantKt.parseIso$parseFailure(v0, "Expected hour in 0..23, got " + v7);
                }
                else {
                    v11 = 59;
                    if(v9 > v11) {
                        return InstantKt.parseIso$parseFailure(v0, "Expected minute-of-hour in 0..59, got " + v9);
                    }
                    else if(v10 > v11) {
                        return InstantKt.parseIso$parseFailure(v0, "Expected second-of-minute in 0..59, got " + v10);
                    }
                    else {
                        UnboundLocalDateTime v15_1 = new UnboundLocalDateTime(v16, v1_1, v2, v7, v9, v10, v22);
                        long v0_1 = ((long)v15_1.getYear());
                        long v4_2 = 365 * v0_1;
                        if(v0_1 >= 0) {
                            v4_2 += (3 + v0_1) / 4 - (99 + v0_1) / 100 + (v0_1 + 0x18F) / 400;
                        }
                        else {
                            v4_2 -= v0_1 / -4 - v0_1 / -100 + v0_1 / -400;
                        }

                        v4_2 = v4_2 + (((long)((v15_1.getMonth() * 0x16F - 362) / 12))) + (((long)(v15_1.getDay() - 1)));
                        if(v15_1.getMonth() > 2) {
                            v0_1 = -1 + v4_2;
                            if(!InstantKt.isLeapYear(v15_1.getYear())) {
                                v4_2 += -2;
                            }
                            else {
                                v4_2 = v0_1;
                            }
                        }

                        return new Success((v4_2 - 0xAFAA8) * 86400 + (((long)(v15_1.getHour() * 3600 + v15_1.getMinute() * 60 + v15_1.getSecond()))) - (((long)v3)), v15_1.getNanosecond());
                    }
                }
            }

            return InstantKt.parseIso$parseFailure(v0, "Expected a valid day-of-month for month " + v1_1 + " of year " + v16 + ", got " + v2);
        }

        return InstantKt.parseIso$parseFailure(v0, "Expected a month number in 1..12, got " + v1_1);
    }

    private static final Failure parseIso$expect(CharSequence arg2, String arg3, int arg4, Function1 arg5) {
        char v0 = arg2.charAt(arg4);
        if(arg5.invoke(Character.valueOf(v0)).booleanValue()) {
            return null;
        }

        return InstantKt.parseIso$parseFailure(arg2, "Expected " + arg3 + ", but got \'" + v0 + "\' at position " + arg4);
    }

    static final boolean parseIso$lambda$0(char arg1) {
        if(arg1 == 45) {
            return 1;
        }

        return 0;
    }

    static final boolean parseIso$lambda$10(char arg2) {
        if(0x30 <= arg2 && arg2 < 58) {
            return 1;
        }

        return 0;
    }

    static final boolean parseIso$lambda$2(char arg1) {
        if(arg1 == 45) {
            return 1;
        }

        return 0;
    }

    static final boolean parseIso$lambda$4(char arg1) {
        if(arg1 != 84) {
            if(arg1 == 0x74) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    static final boolean parseIso$lambda$6(char arg1) {
        if(arg1 == 58) {
            return 1;
        }

        return 0;
    }

    static final boolean parseIso$lambda$8(char arg1) {
        if(arg1 == 58) {
            return 1;
        }

        return 0;
    }

    private static final Failure parseIso$parseFailure(CharSequence arg2, String arg3) {
        return new Failure(arg3 + " when parsing an Instant from \"" + InstantKt.truncateForErrorMessage(arg2, 0x40) + '\"', arg2);
    }

    private static final int parseIso$twoDigitNumber(CharSequence arg1, int arg2) {
        return (arg1.charAt(arg2) - 0x30) * 10 + (arg1.charAt(arg2 + 1) - 0x30);
    }

    private static final long safeAddOrElse(long arg6, long arg8, Function0 arg10) {
        long v0 = arg6 + arg8;
        long v4 = 0;
        if((arg6 ^ v0) < v4) {
            if((arg6 ^ arg8) < v4) {
            }
            else {
                arg10.invoke();
                throw new KotlinNothingValueException();
            }
        }

        return v0;
    }

    private static final long safeMultiplyOrElse(long arg7, long arg9, Function0 arg11) {
        long v0 = 1;
        if(arg9 == v0) {
            return arg7;
        }

        if(arg7 == v0) {
            return arg9;
        }

        v0 = 0;
        if(arg7 != v0) {
            if(arg9 == v0) {
            }
            else {
                v0 = arg7 * arg9;
                if(v0 / arg9 == arg7) {
                    long v2 = -9223372036854775808L;
                    long v5 = -1;
                    if(Long.compare(arg7, v2) == 0 && arg9 == v5) {
                        goto label_20;
                    }

                    if(arg9 == v2 && arg7 == v5) {
                        goto label_20;
                    }

                    return v0;
                }

            label_20:
                arg11.invoke();
                throw new KotlinNothingValueException();
            }
        }

        return v0;
    }

    private static final String truncateForErrorMessage(CharSequence arg2, int arg3) {
        if(arg2.length() <= arg3) {
            return arg2.toString();
        }

        return arg2.subSequence(0, arg3).toString() + "...";
    }
}


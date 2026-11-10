package kotlin.text;

import java.util.Arrays;
import kotlin.IgnorableReturnValue;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000|\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0019\n\u0002\b\u000B\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u000E\u001A\u0018\u0010\u000B\u001A\u00020\u0001*\u00020\f2\b\b\u0002\u0010\r\u001A\u00020\u000EH\u0087\u0080\u0004\u001A,\u0010\u000B\u001A\u00020\u0001*\u00020\f2\b\b\u0002\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u00102\b\b\u0002\u0010\r\u001A\u00020\u000EH\u0087\u0080\u0004\u001A.\u0010\u0012\u001A\u00020\u0001*\u00020\f2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0004H\u0082\u0080\u0004\u001A.\u0010\u0016\u001A\u00020\u0001*\u00020\f2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0004H\u0082\u0080\u0004\u001A.\u0010\u0017\u001A\u00020\u0001*\u00020\f2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0004H\u0082\u0080\u0004\u001A.\u0010\u0018\u001A\u00020\u0001*\u00020\f2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0004H\u0082\u0080\u0004\u001A>\u0010\u0019\u001A\u00020\u0010*\u00020\f2\u0006\u0010\u001A\u001A\u00020\u00102\u0006\u0010\u001B\u001A\u00020\u00012\u0006\u0010\u001C\u001A\u00020\u00012\u0006\u0010\u0015\u001A\u00020\u00042\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020\u0010H\u0082\u0080\u0004\u001A.\u0010\u0019\u001A\u00020\u0010*\u00020\f2\u0006\u0010\u001A\u001A\u00020\u00102\u0006\u0010\u0015\u001A\u00020\u00042\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020\u0010H\u0082\u0080\u0004\u001A*\u0010 \u001A\u00020\u00102\u0006\u0010!\u001A\u00020\u00102\u0006\u0010\"\u001A\u00020\u00102\u0006\u0010#\u001A\u00020\u00102\u0006\u0010$\u001A\u00020\u0010H\u0082\u0080\u0004\u001AB\u0010 \u001A\u00020\u00102\u0006\u0010!\u001A\u00020\u00102\u0006\u0010%\u001A\u00020\u00102\u0006\u0010&\u001A\u00020\u00102\u0006\u0010\'\u001A\u00020\u00102\u0006\u0010\"\u001A\u00020\u00102\u0006\u0010#\u001A\u00020\u00102\u0006\u0010$\u001A\u00020\u0010H\u0080\u0080\u0004\u001A\u0012\u0010(\u001A\u00020\u00102\u0006\u0010)\u001A\u00020*H\u0082\u0080\u0004\u001A\u0018\u0010+\u001A\u00020\f*\u00020\u00012\b\b\u0002\u0010\r\u001A\u00020\u000EH\u0087\u0080\u0004\u001A,\u0010+\u001A\u00020\f*\u00020\u00012\b\b\u0002\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u00102\b\b\u0002\u0010\r\u001A\u00020\u000EH\u0082\u0080\u0004\u001A(\u0010,\u001A\u0004\u0018\u00010\f*\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u0014H\u0082\u0080\u0004\u001A(\u0010-\u001A\u0004\u0018\u00010\f*\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u0014H\u0082\u0080\u0004\u001A(\u0010.\u001A\u0004\u0018\u00010\f*\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u0014H\u0082\u0080\u0004\u001A&\u0010/\u001A\u00020\f*\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u0014H\u0082\u0080\u0004\u001A\u0016\u00100\u001A\u000201*\u00020\u00012\u0006\u0010\u001A\u001A\u00020\u0010H\u0082\u0080\u0004\u001AB\u00102\u001A\u00020\u00102\u0006\u00103\u001A\u00020\u00102\u0006\u0010%\u001A\u00020\u00102\u0006\u0010&\u001A\u00020\u00102\u0006\u0010\'\u001A\u00020\u00102\u0006\u0010\"\u001A\u00020\u00102\u0006\u0010#\u001A\u00020\u00102\u0006\u0010$\u001A\u00020\u0010H\u0080\u0080\u0004\u001A\"\u00104\u001A\u00020*2\u0006\u00105\u001A\u00020*2\u0006\u00106\u001A\u00020\u00102\u0006\u00107\u001A\u00020\u0010H\u0082\u0080\u0004\u001A\"\u00108\u001A\u00020*2\u0006\u00104\u001A\u00020*2\u0006\u00105\u001A\u00020*2\u0006\u00107\u001A\u00020\u0010H\u0082\u0080\u0004\u001A\u001E\u00109\u001A\u00020\u0010*\u00020\u00012\u0006\u0010\u001A\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0010H\u0082\u0080\u0004\u001A\u0018\u0010\u000B\u001A\u00020\u0001*\u0002012\b\b\u0002\u0010\r\u001A\u00020\u000EH\u0087\u0080\u0004\u001A\u0018\u0010:\u001A\u000201*\u00020\u00012\b\b\u0002\u0010\r\u001A\u00020\u000EH\u0087\u0080\u0004\u001A,\u0010:\u001A\u000201*\u00020\u00012\b\b\u0002\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u00102\b\b\u0002\u0010\r\u001A\u00020\u000EH\u0082\u0080\u0004\u001A\u0018\u0010\u000B\u001A\u00020\u0001*\u00020;2\b\b\u0002\u0010\r\u001A\u00020\u000EH\u0087\u0080\u0004\u001A\u0018\u0010<\u001A\u00020;*\u00020\u00012\b\b\u0002\u0010\r\u001A\u00020\u000EH\u0087\u0080\u0004\u001A,\u0010<\u001A\u00020;*\u00020\u00012\b\b\u0002\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u00102\b\b\u0002\u0010\r\u001A\u00020\u000EH\u0082\u0080\u0004\u001A\u0018\u0010\u000B\u001A\u00020\u0001*\u00020\u00102\b\b\u0002\u0010\r\u001A\u00020\u000EH\u0087\u0080\u0004\u001A\u0018\u0010=\u001A\u00020\u0010*\u00020\u00012\b\b\u0002\u0010\r\u001A\u00020\u000EH\u0087\u0080\u0004\u001A,\u0010=\u001A\u00020\u0010*\u00020\u00012\b\b\u0002\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u00102\b\b\u0002\u0010\r\u001A\u00020\u000EH\u0080\u0080\u0004\u001A\u0018\u0010\u000B\u001A\u00020\u0001*\u00020*2\b\b\u0002\u0010\r\u001A\u00020\u000EH\u0087\u0080\u0004\u001A\u0018\u0010>\u001A\u00020**\u00020\u00012\b\b\u0002\u0010\r\u001A\u00020\u000EH\u0087\u0080\u0004\u001A,\u0010>\u001A\u00020**\u00020\u00012\b\b\u0002\u0010\u000F\u001A\u00020\u00102\b\b\u0002\u0010\u0011\u001A\u00020\u00102\b\b\u0002\u0010\r\u001A\u00020\u000EH\u0080\u0080\u0004\u001A&\u0010?\u001A\u00020\u0001*\u00020*2\u0006\u0010@\u001A\u00020A2\u0006\u0010B\u001A\u00020\u00012\u0006\u0010C\u001A\u00020\u0010H\u0082\u0080\u0004\u001A\u001E\u0010D\u001A\u00020\u0010*\u00020\u00012\u0006\u0010\u001D\u001A\u00020\u001E2\u0006\u0010\u001F\u001A\u00020\u0010H\u0082\u0080\u0004\u001A.\u0010E\u001A\u00020\u0010*\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010F\u001A\u00020\u0010H\u0082\u0080\u0004\u001A.\u0010G\u001A\u00020**\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010F\u001A\u00020\u0010H\u0082\u0080\u0004\u001A>\u0010H\u001A\u00020I*\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010J\u001A\u00020\u00012\u0006\u0010K\u001A\u00020\u00012\u0006\u0010L\u001A\u00020M2\u0006\u0010F\u001A\u00020\u0010H\u0082\u0080\u0004\u001A&\u0010N\u001A\u00020I*\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010F\u001A\u00020\u0010H\u0082\u0080\u0004\u001A\u001E\u0010O\u001A\u00020I*\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0010H\u0082\u0080\u0004\u001A\u001E\u0010P\u001A\u00020\u0010*\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0010H\u0082\u0080\u0004\u001A@\u0010Q\u001A\u00020\u0010*\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u001D\u0010R\u001A\u0019\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020T0S¢\u0006\u0002\bUH\u0080\u0088\u0004ø\u0001\u0000\u001A\u001E\u0010V\u001A\u00020**\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0010H\u0082\u0080\u0004\u001A@\u0010W\u001A\u00020**\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u001D\u0010R\u001A\u0019\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020T0S¢\u0006\u0002\bUH\u0080\u0088\u0004ø\u0001\u0000\u001A6\u0010X\u001A\u00020\u0010*\u00020\u00012\u0006\u0010\u001A\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010Y\u001A\u00020\u00012\u0006\u0010L\u001A\u00020M2\u0006\u0010Z\u001A\u00020\u0001H\u0083\u0088\b\u001A5\u0010[\u001A\u00020\u0010*\u00020\u00012\u0006\u0010\u001A\u001A\u00020\u00102\u001D\u0010R\u001A\u0019\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020T0S¢\u0006\u0002\bUH\u0082\u0088\u0004\u001A5\u0010\\\u001A\u00020**\u00020\u00012\u0006\u0010\u001A\u001A\u00020\u00102\u001D\u0010R\u001A\u0019\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020T0S¢\u0006\u0002\bUH\u0082\u0088\u0004\u001A.\u0010]\u001A\u00020I*\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010^\u001A\u00020\u00012\u0006\u0010_\u001A\u00020\u0010H\u0082\u0080\u0004\u001A.\u0010`\u001A\u00020I*\u00020\u00012\u0006\u0010\u001A\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010Y\u001A\u00020\u00012\u0006\u0010Z\u001A\u00020\u0001H\u0082\u0080\u0004\u001A.\u0010a\u001A\u00020I*\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010J\u001A\u00020\u00012\u0006\u0010K\u001A\u00020\u0001H\u0082\u0080\u0004\u001A\u0016\u0010b\u001A\u00020T*\u00020\u00012\u0006\u0010\u001A\u001A\u00020\u0010H\u0082\u0080\u0004\"\u000F\u0010\u0000\u001A\u00020\u0001X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010\u0002\u001A\u00020\u0001X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u0015\u0010\u0003\u001A\u00020\u0004X\u0080\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006\"\u000F\u0010\u0007\u001A\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000\"\u000F\u0010\b\u001A\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000\"\u000F\u0010\t\u001A\u00020\nX\u0082\u0084\b¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006c"}, d2={"LOWER_CASE_HEX_DIGITS", "", "UPPER_CASE_HEX_DIGITS", "BYTE_TO_LOWER_CASE_HEX_DIGITS", "", "getBYTE_TO_LOWER_CASE_HEX_DIGITS", "()[I", "BYTE_TO_UPPER_CASE_HEX_DIGITS", "HEX_DIGITS_TO_DECIMAL", "HEX_DIGITS_TO_LONG_DECIMAL", "", "toHexString", "", "format", "Lkotlin/text/HexFormat;", "startIndex", "", "endIndex", "toHexStringNoLineAndGroupSeparator", "bytesFormat", "Lkotlin/text/HexFormat$BytesHexFormat;", "byteToDigits", "toHexStringShortByteSeparatorNoPrefixAndSuffix", "toHexStringNoLineAndGroupSeparatorSlowPath", "toHexStringSlowPath", "formatByteAt", "index", "bytePrefix", "byteSuffix", "destination", "", "destinationOffset", "formattedStringLength", "numberOfBytes", "byteSeparatorLength", "bytePrefixLength", "byteSuffixLength", "bytesPerLine", "bytesPerGroup", "groupSeparatorLength", "checkFormatLength", "formatLength", "", "hexToByteArray", "hexToByteArrayNoLineAndGroupSeparator", "hexToByteArrayShortByteSeparatorNoPrefixAndSuffix", "hexToByteArrayNoLineAndGroupSeparatorSlowPath", "hexToByteArraySlowPath", "parseByteAt", "", "parsedByteArrayMaxSize", "stringLength", "charsPerSet", "charsPerElement", "elementsPerSet", "elementSeparatorLength", "wholeElementsPerSet", "checkNewLineAt", "hexToByte", "", "hexToShort", "hexToInt", "hexToLong", "toHexStringImpl", "numberFormat", "Lkotlin/text/HexFormat$NumberHexFormat;", "digits", "bits", "toCharArrayIfNotEmpty", "hexToIntImpl", "typeHexLength", "hexToLongImpl", "checkPrefixSuffixNumberOfDigits", "", "prefix", "suffix", "ignoreCase", "", "checkNumberOfDigits", "checkZeroDigits", "parseInt", "parseHexToInt", "onError", "Lkotlin/Function2;", "", "Lkotlin/ExtensionFunctionType;", "parseLong", "parseHexToLong", "checkContainsAt", "part", "partName", "decimalFromHexDigitAt", "longDecimalFromHexDigitAt", "throwInvalidNumberOfDigits", "specifier", "expected", "throwNotContainedAt", "throwInvalidPrefixSuffix", "throwInvalidDigitAt", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class HexExtensionsKt {
    private static final int[] BYTE_TO_LOWER_CASE_HEX_DIGITS = null;
    private static final int[] BYTE_TO_UPPER_CASE_HEX_DIGITS = null;
    private static final int[] HEX_DIGITS_TO_DECIMAL = null;
    private static final long[] HEX_DIGITS_TO_LONG_DECIMAL = null;
    private static final String LOWER_CASE_HEX_DIGITS = "0123456789abcdef";
    private static final String UPPER_CASE_HEX_DIGITS = "0123456789ABCDEF";

    static {
        String v5;
        String v4;
        int v0 = 0x100;
        int[] v1 = new int[v0];
        int v2 = 0;
        int v3;
        for(v3 = 0; true; ++v3) {
            v4 = "0123456789abcdef";
            if(v3 >= v0) {
                break;
            }

            v1[v3] = v4.charAt(v3 & 15) | v4.charAt(v3 >> 4) << 8;
        }

        HexExtensionsKt.BYTE_TO_LOWER_CASE_HEX_DIGITS = v1;
        v1 = new int[v0];
        for(v3 = 0; true; ++v3) {
            v5 = "0123456789ABCDEF";
            if(v3 >= v0) {
                break;
            }

            v1[v3] = v5.charAt(v3 & 15) | v5.charAt(v3 >> 4) << 8;
        }

        HexExtensionsKt.BYTE_TO_UPPER_CASE_HEX_DIGITS = v1;
        v1 = new int[v0];
        for(v3 = 0; v3 < v0; ++v3) {
            v1[v3] = -1;
        }

        String v3_1 = v4;
        int v6 = 0;
        int v7;
        for(v7 = 0; v6 < ((CharSequence)v3_1).length(); ++v7) {
            v1[((CharSequence)v3_1).charAt(v6)] = v7;
            ++v6;
        }

        v3_1 = v5;
        v6 = 0;
        for(v7 = 0; v6 < ((CharSequence)v3_1).length(); ++v7) {
            v1[((CharSequence)v3_1).charAt(v6)] = v7;
            ++v6;
        }

        HexExtensionsKt.HEX_DIGITS_TO_DECIMAL = v1;
        long[] v1_1 = new long[v0];
        for(v3 = 0; v3 < v0; ++v3) {
            v1_1[v3] = -1;
        }

        v0 = 0;
        for(v3 = 0; v0 < ((CharSequence)v4).length(); ++v3) {
            v1_1[((CharSequence)v4).charAt(v0)] = ((long)v3);
            ++v0;
        }

        for(v0 = 0; v2 < ((CharSequence)v5).length(); ++v0) {
            v1_1[((CharSequence)v5).charAt(v2)] = ((long)v0);
            ++v2;
        }

        HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL = v1_1;
    }

    public static final int[] access$getHEX_DIGITS_TO_DECIMAL$p() {
        return HexExtensionsKt.HEX_DIGITS_TO_DECIMAL;
    }

    public static final long[] access$getHEX_DIGITS_TO_LONG_DECIMAL$p() {
        return HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL;
    }

    private static final long charsPerSet(long arg4, int arg6, int arg7) {
        if(arg6 > 0) {
            long v0 = ((long)arg6);
            return arg4 * v0 + (((long)arg7)) * (v0 - 1);
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @IgnorableReturnValue private static final int checkContainsAt(String arg4, int arg5, int arg6, String arg7, boolean arg8, String arg9) {
        String v0 = arg7;
        if(((CharSequence)v0).length() == 0) {
            return arg5;
        }

        int v0_1 = ((CharSequence)v0).length();
        int v1;
        for(v1 = 0; v1 < v0_1; ++v1) {
            if(!CharsKt.equals(arg7.charAt(v1), arg4.charAt(arg5 + v1), arg8)) {
                HexExtensionsKt.throwNotContainedAt(arg4, arg5, arg6, arg7, arg9);
            }
        }

        return arg5 + arg7.length();
    }

    private static final int checkFormatLength(long arg3) {
        if(0 <= arg3 && arg3 <= 0x7FFFFFFF) {
            return ((int)arg3);
        }

        throw new IllegalArgumentException("The resulting string length is too big: " + ULong.toString-impl(ULong.constructor-impl(arg3)));
    }

    private static final int checkNewLineAt(String arg3, int arg4, int arg5) {
        int v2 = 10;
        if(arg3.charAt(arg4) == 13) {
            int v0 = arg4 + 1;
            if(v0 < arg5 && arg3.charAt(v0) == v2) {
                return arg4 + 2;
            }

            return v0;
        }

        if(arg3.charAt(arg4) == v2) {
            return arg4 + 1;
        }

        throw new NumberFormatException("Expected a new line at index " + arg4 + ", but was " + arg3.charAt(arg4));
    }

    private static final void checkNumberOfDigits(String arg2, int arg3, int arg4, int arg5) {
        int v0 = arg4 - arg3;
        if(v0 < 1) {
            HexExtensionsKt.throwInvalidNumberOfDigits(arg2, arg3, arg4, "at least", 1);
            return;
        }

        if(v0 > arg5) {
            HexExtensionsKt.checkZeroDigits(arg2, arg3, v0 + arg3 - arg5);
        }
    }

    private static final void checkPrefixSuffixNumberOfDigits(String arg5, int arg6, int arg7, String arg8, String arg9, boolean arg10, int arg11) {
        int v0_1;
        if(arg7 - arg6 - arg8.length() <= arg9.length()) {
            HexExtensionsKt.throwInvalidPrefixSuffix(arg5, arg6, arg7, arg8, arg9);
        }

        String v0 = arg8;
        int v2 = 0;
        if(((CharSequence)v0).length() == 0) {
        }
        else {
            v0_1 = ((CharSequence)v0).length();
            int v1;
            for(v1 = 0; v1 < v0_1; ++v1) {
                if(!CharsKt.equals(arg8.charAt(v1), arg5.charAt(arg6 + v1), arg10)) {
                    HexExtensionsKt.throwNotContainedAt(arg5, arg6, arg7, arg8, "prefix");
                }
            }

            arg6 += arg8.length();
        }

        int v8 = arg7 - arg9.length();
        v0 = arg9;
        if(((CharSequence)v0).length() == 0) {
        }
        else {
            v0_1 = ((CharSequence)v0).length();
            while(v2 < v0_1) {
                if(!CharsKt.equals(arg9.charAt(v2), arg5.charAt(v8 + v2), arg10)) {
                    HexExtensionsKt.throwNotContainedAt(arg5, v8, arg7, arg9, "suffix");
                }

                ++v2;
            }

            arg9.length();
        }

        HexExtensionsKt.checkNumberOfDigits(arg5, arg6, v8, arg11);
    }

    private static final void checkZeroDigits(String arg2, int arg3, int arg4) {
        while(true) {
            if(arg3 >= arg4) {
                return;
            }

            if(arg2.charAt(arg3) != 0x30) {
                break;
            }

            ++arg3;
        }

        throw new NumberFormatException("Expected the hexadecimal digit \'0\' at index " + arg3 + ", but was \'" + arg2.charAt(arg3) + "\'.\nThe result won\'t fit the type being parsed.");
    }

    private static final int decimalFromHexDigitAt(String arg2, int arg3, Function2 arg4) {
        int v0 = arg2.charAt(arg3);
        if(v0 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_DECIMAL[v0] >= 0) {
            return HexExtensionsKt.HEX_DIGITS_TO_DECIMAL[v0];
        }

        arg4.invoke(arg2, Integer.valueOf(arg3));
        throw new KotlinNothingValueException();
    }

    private static final int formatByteAt(byte[] arg0, int arg1, String arg2, String arg3, int[] arg4, char[] arg5, int arg6) {
        return HexExtensionsKt.toCharArrayIfNotEmpty(arg3, arg5, HexExtensionsKt.formatByteAt(arg0, arg1, arg4, arg5, HexExtensionsKt.toCharArrayIfNotEmpty(arg2, arg5, arg6)));
    }

    private static final int formatByteAt(byte[] arg0, int arg1, int[] arg2, char[] arg3, int arg4) {
        int v0 = arg2[arg0[arg1] & 0xFF];
        arg3[arg4] = ((char)(v0 >> 8));
        arg3[arg4 + 1] = ((char)(v0 & 0xFF));
        return arg4 + 2;
    }

    private static final int formattedStringLength(int arg4, int arg5, int arg6, int arg7) {
        if(arg4 > 0) {
            long v2 = (((long)arg6)) + 2;
            long v5 = ((long)arg5);
            return HexExtensionsKt.checkFormatLength((((long)arg4)) * (v2 + (((long)arg7)) + v5) - v5);
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final int formattedStringLength(int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11) {
        if(arg5 > 0) {
            int v0 = arg5 - 1;
            int v1 = v0 / arg6;
            int v2 = (arg6 - 1) / arg7;
            int v3 = arg5 % arg6;
            if(v3 == 0) {
            }
            else {
                arg6 = v3;
            }

            v2 = v2 * v1 + (arg6 - 1) / arg7;
            return HexExtensionsKt.checkFormatLength((((long)v1)) + (((long)v2)) * (((long)arg8)) + (((long)(v0 - v1 - v2))) * (((long)arg9)) + (((long)arg5)) * ((((long)arg10)) + 2 + (((long)arg11))));
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final int[] getBYTE_TO_LOWER_CASE_HEX_DIGITS() {
        return HexExtensionsKt.BYTE_TO_LOWER_CASE_HEX_DIGITS;
    }

    private static final byte hexToByte(String arg1, int arg2, int arg3, HexFormat arg4) {
        return ((byte)HexExtensionsKt.hexToIntImpl(arg1, arg2, arg3, arg4, 2));
    }

    public static final byte hexToByte(String arg2, HexFormat arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "format");
        return HexExtensionsKt.hexToByte(arg2, 0, arg2.length(), arg3);
    }

    static byte hexToByte$default(String arg0, int arg1, int arg2, HexFormat arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = arg0.length();
        }

        if((arg4 & 4) != 0) {
            arg3 = HexFormat.Companion.getDefault();
        }

        return HexExtensionsKt.hexToByte(arg0, 0, arg2, arg3);
    }

    public static byte hexToByte$default(String arg0, HexFormat arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = HexFormat.Companion.getDefault();
        }

        return HexExtensionsKt.hexToByte(arg0, arg1);
    }

    private static final byte[] hexToByteArray(String arg2, int arg3, int arg4, HexFormat arg5) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(arg3, arg4, arg2.length());
        if(arg3 == arg4) {
            return new byte[0];
        }

        BytesHexFormat v5 = arg5.getBytes();
        if(v5.getNoLineAndGroupSeparator$kotlin_stdlib()) {
            byte[] v0 = HexExtensionsKt.hexToByteArrayNoLineAndGroupSeparator(arg2, arg3, arg4, v5);
            if(v0 != null) {
                return v0;
            }
        }

        return HexExtensionsKt.hexToByteArraySlowPath(arg2, arg3, arg4, v5);
    }

    public static final byte[] hexToByteArray(String arg2, HexFormat arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "format");
        return HexExtensionsKt.hexToByteArray(arg2, 0, arg2.length(), arg3);
    }

    static byte[] hexToByteArray$default(String arg0, int arg1, int arg2, HexFormat arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = arg0.length();
        }

        if((arg4 & 4) != 0) {
            arg3 = HexFormat.Companion.getDefault();
        }

        return HexExtensionsKt.hexToByteArray(arg0, 0, arg2, arg3);
    }

    public static byte[] hexToByteArray$default(String arg0, HexFormat arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = HexFormat.Companion.getDefault();
        }

        return HexExtensionsKt.hexToByteArray(arg0, arg1);
    }

    private static final byte[] hexToByteArrayNoLineAndGroupSeparator(String arg1, int arg2, int arg3, BytesHexFormat arg4) {
        if(arg4.getShortByteSeparatorNoPrefixAndSuffix$kotlin_stdlib()) {
            return HexExtensionsKt.hexToByteArrayShortByteSeparatorNoPrefixAndSuffix(arg1, arg2, arg3, arg4);
        }

        return HexExtensionsKt.hexToByteArrayNoLineAndGroupSeparatorSlowPath(arg1, arg2, arg3, arg4);
    }

    private static final byte[] hexToByteArrayNoLineAndGroupSeparatorSlowPath(String arg12, int arg13, int arg14, BytesHexFormat arg15) {
        int v5_1;
        String v0 = arg15.getBytePrefix();
        String v1 = arg15.getByteSuffix();
        String v2 = arg15.getByteSeparator();
        long v6 = ((long)v2.length());
        long v4 = (((long)v0.length())) + 2 + (((long)v1.length())) + v6;
        long v8 = ((long)(arg14 - arg13));
        int v3 = ((int)((v8 + v6) / v4));
        if((((long)v3)) * v4 - v6 != v8) {
            return null;
        }

        boolean v15 = arg15.getIgnoreCase$kotlin_stdlib();
        byte[] v4_1 = new byte[v3];
        String v5 = v0;
        int v7 = 0;
        if(((CharSequence)v5).length() == 0) {
        }
        else {
            v5_1 = ((CharSequence)v5).length();
            int v6_1;
            for(v6_1 = 0; v6_1 < v5_1; ++v6_1) {
                if(!CharsKt.equals(v0.charAt(v6_1), arg12.charAt(arg13 + v6_1), v15)) {
                    HexExtensionsKt.throwNotContainedAt(arg12, arg13, arg14, v0, "byte prefix");
                }
            }

            arg13 += v0.length();
        }

        v0 = v1 + v2 + v0;
        --v3;
        int v2_1;
        for(v2_1 = 0; v2_1 < v3; ++v2_1) {
            v4_1[v2_1] = HexExtensionsKt.parseByteAt(arg12, arg13);
            arg13 += 2;
            v5 = v0;
            if(((CharSequence)v5).length() == 0) {
            }
            else {
                v5_1 = ((CharSequence)v5).length();
                for(v6_1 = 0; v6_1 < v5_1; ++v6_1) {
                    if(!CharsKt.equals(v0.charAt(v6_1), arg12.charAt(arg13 + v6_1), v15)) {
                        HexExtensionsKt.throwNotContainedAt(arg12, arg13, arg14, v0, "byte suffix + byte separator + byte prefix");
                    }
                }

                arg13 += v0.length();
            }
        }

        v4_1[v3] = HexExtensionsKt.parseByteAt(arg12, arg13);
        arg13 += 2;
        v0 = v1;
        if(((CharSequence)v0).length() == 0) {
            return v4_1;
        }

        int v0_1 = ((CharSequence)v0).length();
        while(v7 < v0_1) {
            if(!CharsKt.equals(v1.charAt(v7), arg12.charAt(arg13 + v7), v15)) {
                HexExtensionsKt.throwNotContainedAt(arg12, arg13, arg14, v1, "byte suffix");
            }

            ++v7;
        }

        v1.length();
        return v4_1;
    }

    private static final byte[] hexToByteArrayShortByteSeparatorNoPrefixAndSuffix(String arg11, int arg12, int arg13, BytesHexFormat arg14) {
        int v0 = arg14.getByteSeparator().length();
        int v1 = 1;
        if(v0 <= 1) {
            arg12 = arg13 - arg12;
            byte[] v2 = null;
            int v3 = 2;
            int v4 = 0;
            if(v0 == 0) {
                if((arg12 & 1) != 0) {
                    return v2;
                }

                arg12 >>= 1;
                byte[] v13 = new byte[arg12];
                int v14 = 0;
                while(v4 < arg12) {
                    v13[v4] = HexExtensionsKt.parseByteAt(arg11, v14);
                    v14 += v3;
                    ++v4;
                }

                return v13;
            }

            if(arg12 % 3 != v3) {
                return v2;
            }

            arg12 = arg12 / 3 + 1;
            byte[] v0_1 = new byte[arg12];
            int v2_1 = arg14.getByteSeparator().charAt(0);
            v0_1[0] = HexExtensionsKt.parseByteAt(arg11, 0);
            while(v1 < arg12) {
                if(arg11.charAt(v3) != v2_1) {
                    String v5 = arg14.getByteSeparator();
                    boolean v6 = arg14.getIgnoreCase$kotlin_stdlib();
                    String v7 = v5;
                    if(((CharSequence)v7).length() == 0) {
                    }
                    else {
                        int v7_1 = ((CharSequence)v7).length();
                        int v8;
                        for(v8 = 0; v8 < v7_1; ++v8) {
                            if(!CharsKt.equals(v5.charAt(v8), arg11.charAt(v3 + v8), v6)) {
                                HexExtensionsKt.throwNotContainedAt(arg11, v3, arg13, v5, "byte separator");
                            }
                        }

                        v5.length();
                    }
                }

                v0_1[v1] = HexExtensionsKt.parseByteAt(arg11, v3 + 1);
                v3 += 3;
                ++v1;
            }

            return v0_1;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private static final byte[] hexToByteArraySlowPath(String arg18, int arg19, int arg20, BytesHexFormat arg21) {
        String v3_1;
        int v6;
        int v17;
        int v16;
        String v0 = arg18;
        int v1 = arg20;
        int v3 = arg21.getBytesPerLine();
        int v4 = arg21.getBytesPerGroup();
        String v9 = arg21.getBytePrefix();
        String v10 = arg21.getByteSuffix();
        String v11 = arg21.getByteSeparator();
        String v12 = arg21.getGroupSeparator();
        boolean v13 = arg21.getIgnoreCase$kotlin_stdlib();
        int v2 = HexExtensionsKt.parsedByteArrayMaxSize(v1 - arg19, v3, v4, v12.length(), v11.length(), v9.length(), v10.length());
        byte[] v5 = new byte[v2];
        int v7 = arg19;
        int v8 = 0;
        int v14 = 0;
        int v15 = 0;
        while(v7 < v1) {
            if(v14 == v3) {
                v7 = HexExtensionsKt.checkNewLineAt(v0, v7, v1);
                v16 = v3;
                v17 = v4;
                v14 = 0;
                goto label_26;
            }
            else if(v15 == v4) {
                String v15_1 = v12;
                if(((CharSequence)v15_1).length() == 0) {
                    v16 = v3;
                    v17 = v4;
                    goto label_26;
                }
                else {
                    v15 = ((CharSequence)v15_1).length();
                    v6 = 0;
                    while(v6 < v15) {
                        v16 = v3;
                        v17 = v4;
                        if(!CharsKt.equals(v12.charAt(v6), v0.charAt(v7 + v6), v13)) {
                            HexExtensionsKt.throwNotContainedAt(v0, v7, v1, v12, "group separator");
                        }

                        ++v6;
                        v3 = v16;
                        v4 = v17;
                    }

                    v16 = v3;
                    v17 = v4;
                    v7 += v12.length();
                label_26:
                    v15 = 0;
                }
            }
            else {
                v16 = v3;
                v17 = v4;
                if(v15 == 0) {
                    goto label_79;
                }

                v3_1 = v11;
                if(((CharSequence)v3_1).length() == 0) {
                    goto label_79;
                }

                v3 = ((CharSequence)v3_1).length();
                v4 = 0;
                while(v4 < v3) {
                    arg19 = v3;
                    if(!CharsKt.equals(v11.charAt(v4), v0.charAt(v7 + v4), v13)) {
                        HexExtensionsKt.throwNotContainedAt(v0, v7, v1, v11, "byte separator");
                    }

                    ++v4;
                    v3 = arg19;
                }

                v7 += v11.length();
            }

        label_79:
            ++v14;
            ++v15;
            v3_1 = v9;
            if(((CharSequence)v3_1).length() == 0) {
            }
            else {
                v3 = ((CharSequence)v3_1).length();
                v4 = 0;
                while(v4 < v3) {
                    arg19 = v3;
                    if(!CharsKt.equals(v9.charAt(v4), v0.charAt(v7 + v4), v13)) {
                        HexExtensionsKt.throwNotContainedAt(v0, v7, v1, v9, "byte prefix");
                    }

                    ++v4;
                    v3 = arg19;
                }

                v7 += v9.length();
            }

            if(v1 - 2 < v7) {
                HexExtensionsKt.throwInvalidNumberOfDigits(v0, v7, v1, "exactly", 2);
            }

            v3 = v8 + 1;
            v5[v8] = HexExtensionsKt.parseByteAt(v0, v7);
            v7 += 2;
            String v4_1 = v10;
            if(((CharSequence)v4_1).length() == 0) {
                arg19 = v3;
            }
            else {
                v4 = ((CharSequence)v4_1).length();
                v6 = 0;
                while(v6 < v4) {
                    arg19 = v3;
                    if(!CharsKt.equals(v10.charAt(v6), v0.charAt(v7 + v6), v13)) {
                        HexExtensionsKt.throwNotContainedAt(v0, v7, v1, v10, "byte suffix");
                    }

                    ++v6;
                    v3 = arg19;
                }

                arg19 = v3;
                v7 += v10.length();
            }

            v8 = arg19;
            v3 = v16;
            v4 = v17;
        }

        if(v8 == v2) {
            return v5;
        }

        byte[] v0_1 = Arrays.copyOf(v5, v8);
        Intrinsics.checkNotNullExpressionValue(v0_1, "copyOf(...)");
        return v0_1;
    }

    public static final int hexToInt(String arg1, int arg2, int arg3, HexFormat arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "format");
        return HexExtensionsKt.hexToIntImpl(arg1, arg2, arg3, arg4, 8);
    }

    public static final int hexToInt(String arg2, HexFormat arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "format");
        return HexExtensionsKt.hexToInt(arg2, 0, arg2.length(), arg3);
    }

    public static int hexToInt$default(String arg0, int arg1, int arg2, HexFormat arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = arg0.length();
        }

        if((arg4 & 4) != 0) {
            arg3 = HexFormat.Companion.getDefault();
        }

        return HexExtensionsKt.hexToInt(arg0, 0, arg2, arg3);
    }

    public static int hexToInt$default(String arg0, HexFormat arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = HexFormat.Companion.getDefault();
        }

        return HexExtensionsKt.hexToInt(arg0, arg1);
    }

    private static final int hexToIntImpl(String arg7, int arg8, int arg9, HexFormat arg10, int arg11) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(arg8, arg9, arg7.length());
        NumberHexFormat v10 = arg10.getNumber();
        if(v10.isDigitsOnly$kotlin_stdlib()) {
            HexExtensionsKt.checkNumberOfDigits(arg7, arg8, arg9, arg11);
            return HexExtensionsKt.parseInt(arg7, arg8, arg9);
        }

        String v3 = v10.getPrefix();
        String v4 = v10.getSuffix();
        HexExtensionsKt.checkPrefixSuffixNumberOfDigits(arg7, arg8, arg9, v3, v4, v10.getIgnoreCase$kotlin_stdlib(), arg11);
        return HexExtensionsKt.parseInt(arg7, arg8 + v3.length(), arg9 - v4.length());
    }

    public static final long hexToLong(String arg1, int arg2, int arg3, HexFormat arg4) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "format");
        return HexExtensionsKt.hexToLongImpl(arg1, arg2, arg3, arg4, 16);
    }

    public static final long hexToLong(String arg2, HexFormat arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "format");
        return HexExtensionsKt.hexToLong(arg2, 0, arg2.length(), arg3);
    }

    public static long hexToLong$default(String arg0, int arg1, int arg2, HexFormat arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = arg0.length();
        }

        if((arg4 & 4) != 0) {
            arg3 = HexFormat.Companion.getDefault();
        }

        return HexExtensionsKt.hexToLong(arg0, 0, arg2, arg3);
    }

    public static long hexToLong$default(String arg0, HexFormat arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = HexFormat.Companion.getDefault();
        }

        return HexExtensionsKt.hexToLong(arg0, arg1);
    }

    private static final long hexToLongImpl(String arg7, int arg8, int arg9, HexFormat arg10, int arg11) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(arg8, arg9, arg7.length());
        NumberHexFormat v10 = arg10.getNumber();
        if(v10.isDigitsOnly$kotlin_stdlib()) {
            HexExtensionsKt.checkNumberOfDigits(arg7, arg8, arg9, arg11);
            return HexExtensionsKt.parseLong(arg7, arg8, arg9);
        }

        String v3 = v10.getPrefix();
        String v4 = v10.getSuffix();
        HexExtensionsKt.checkPrefixSuffixNumberOfDigits(arg7, arg8, arg9, v3, v4, v10.getIgnoreCase$kotlin_stdlib(), arg11);
        return HexExtensionsKt.parseLong(arg7, arg8 + v3.length(), arg9 - v4.length());
    }

    private static final short hexToShort(String arg1, int arg2, int arg3, HexFormat arg4) {
        return ((short)HexExtensionsKt.hexToIntImpl(arg1, arg2, arg3, arg4, 4));
    }

    public static final short hexToShort(String arg2, HexFormat arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "format");
        return HexExtensionsKt.hexToShort(arg2, 0, arg2.length(), arg3);
    }

    static short hexToShort$default(String arg0, int arg1, int arg2, HexFormat arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = arg0.length();
        }

        if((arg4 & 4) != 0) {
            arg3 = HexFormat.Companion.getDefault();
        }

        return HexExtensionsKt.hexToShort(arg0, 0, arg2, arg3);
    }

    public static short hexToShort$default(String arg0, HexFormat arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = HexFormat.Companion.getDefault();
        }

        return HexExtensionsKt.hexToShort(arg0, arg1);
    }

    private static final long longDecimalFromHexDigitAt(String arg6, int arg7, Function2 arg8) {
        int v0 = arg6.charAt(arg7);
        if(v0 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v0] >= 0) {
            return HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v0];
        }

        arg8.invoke(arg6, Integer.valueOf(arg7));
        throw new KotlinNothingValueException();
    }

    private static final byte parseByteAt(String arg3, int arg4) {
        int v0 = arg3.charAt(arg4);
        if(v0 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_DECIMAL[v0] >= 0) {
            v0 = HexExtensionsKt.HEX_DIGITS_TO_DECIMAL[v0];
            ++arg4;
            int v1 = arg3.charAt(arg4);
            if(v1 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_DECIMAL[v1] >= 0) {
                return ((byte)(HexExtensionsKt.HEX_DIGITS_TO_DECIMAL[v1] | v0 << 4));
            }

            HexExtensionsKt.throwInvalidDigitAt(arg3, arg4);
            throw new KotlinNothingValueException();
        }

        HexExtensionsKt.throwInvalidDigitAt(arg3, arg4);
        throw new KotlinNothingValueException();
    }

    public static final int parseHexToInt(String arg3, int arg4, int arg5, Function2 arg6) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "onError");
        int v0 = 0;
        while(true) {
            if(arg4 >= arg5) {
                return v0;
            }

            v0 <<= 4;
            int v1 = arg3.charAt(arg4);
            if(v1 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_DECIMAL[v1] >= 0) {
                v0 |= HexExtensionsKt.HEX_DIGITS_TO_DECIMAL[v1];
                ++arg4;
                continue;
            }

            break;
        }

        arg6.invoke(arg3, Integer.valueOf(arg4));
        throw new KotlinNothingValueException();
        return v0;
    }

    public static final long parseHexToLong(String arg8, int arg9, int arg10, Function2 arg11) {
        Intrinsics.checkNotNullParameter(arg8, "<this>");
        Intrinsics.checkNotNullParameter(arg11, "onError");
        long v0 = 0;
        long v2 = v0;
        while(true) {
            if(arg9 >= arg10) {
                return v2;
            }

            v2 <<= 4;
            int v4 = arg8.charAt(arg9);
            if(v4 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v4] >= v0) {
                v2 |= HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v4];
                ++arg9;
                continue;
            }

            break;
        }

        arg11.invoke(arg8, Integer.valueOf(arg9));
        throw new KotlinNothingValueException();
        return v2;
    }

    private static final int parseInt(String arg3, int arg4, int arg5) {
        int v0 = 0;
        while(true) {
            if(arg4 >= arg5) {
                return v0;
            }

            v0 <<= 4;
            int v1 = arg3.charAt(arg4);
            if(v1 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_DECIMAL[v1] >= 0) {
                v0 |= HexExtensionsKt.HEX_DIGITS_TO_DECIMAL[v1];
                ++arg4;
                continue;
            }

            break;
        }

        HexExtensionsKt.throwInvalidDigitAt(arg3, arg4);
        throw new KotlinNothingValueException();
        return v0;
    }

    private static final long parseLong(String arg8, int arg9, int arg10) {
        long v0 = 0;
        long v2 = v0;
        while(true) {
            if(arg9 >= arg10) {
                return v2;
            }

            v2 <<= 4;
            int v4 = arg8.charAt(arg9);
            if(v4 >>> 8 == 0 && HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v4] >= v0) {
                v2 |= HexExtensionsKt.HEX_DIGITS_TO_LONG_DECIMAL[v4];
                ++arg9;
                continue;
            }

            break;
        }

        HexExtensionsKt.throwInvalidDigitAt(arg8, arg9);
        throw new KotlinNothingValueException();
        return v2;
    }

    public static final int parsedByteArrayMaxSize(int arg17, int arg18, int arg19, int arg20, int arg21, int arg22, int arg23) {
        long v9;
        int v0 = arg17;
        int v1 = arg18;
        int v2 = arg19;
        int v3 = arg20;
        int v4 = arg21;
        if(v0 > 0) {
            long v5 = (((long)arg22)) + 2 + (((long)arg23));
            long v7 = HexExtensionsKt.charsPerSet(v5, v2, v4);
            if(v1 <= v2) {
                v9 = HexExtensionsKt.charsPerSet(v5, v1, v4);
            }
            else {
                v9 = HexExtensionsKt.charsPerSet(v7, v1 / v2, v3);
                int v11 = v1 % v2;
                if(v11 != 0) {
                    v9 = v9 + (((long)v3)) + HexExtensionsKt.charsPerSet(v5, v11, v4);
                }
            }

            long v11_1 = ((long)v0);
            long v13 = HexExtensionsKt.wholeElementsPerSet(v11_1, v9, 1);
            v11_1 -= (v9 + 1) * v13;
            v9 = HexExtensionsKt.wholeElementsPerSet(v11_1, v7, v3);
            v11_1 -= (v7 + (((long)v3))) * v9;
            long v0_1 = HexExtensionsKt.wholeElementsPerSet(v11_1, v5, v4);
            v3 = v11_1 - (v5 + (((long)v4))) * v0_1 > 0 ? 1 : 0;
            return ((int)(v13 * (((long)arg18)) + v9 * (((long)v2)) + v0_1 + (((long)v3))));
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private static final Void throwInvalidDigitAt(String arg3, int arg4) {
        throw new NumberFormatException("Expected a hexadecimal digit at index " + arg4 + ", but was " + arg3.charAt(arg4));
    }

    private static final void throwInvalidNumberOfDigits(String arg3, int arg4, int arg5, String arg6, int arg7) {
        Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type java.lang.String");
        arg3 = arg3.substring(arg4, arg5);
        Intrinsics.checkNotNullExpressionValue(arg3, "substring(...)");
        throw new NumberFormatException("Expected " + arg6 + ' ' + arg7 + " hexadecimal digits at index " + arg4 + ", but was \"" + arg3 + "\" of length " + (arg5 - arg4));
    }

    private static final void throwInvalidPrefixSuffix(String arg1, int arg2, int arg3, String arg4, String arg5) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type java.lang.String");
        arg1 = arg1.substring(arg2, arg3);
        Intrinsics.checkNotNullExpressionValue(arg1, "substring(...)");
        throw new NumberFormatException("Expected a hexadecimal number with prefix \"" + arg4 + "\" and suffix \"" + arg5 + "\", but was " + arg1);
    }

    private static final void throwNotContainedAt(String arg2, int arg3, int arg4, String arg5, String arg6) {
        arg4 = RangesKt.coerceAtMost(arg5.length() + arg3, arg4);
        Intrinsics.checkNotNull(arg2, "null cannot be cast to non-null type java.lang.String");
        arg2 = arg2.substring(arg3, arg4);
        Intrinsics.checkNotNullExpressionValue(arg2, "substring(...)");
        throw new NumberFormatException("Expected " + arg6 + " \"" + arg5 + "\" at index " + arg3 + ", but was " + arg2);
    }

    private static final int toCharArrayIfNotEmpty(String arg3, char[] arg4, int arg5) {
        int v0 = arg3.length();
        if(v0 != 0) {
            if(v0 != 1) {
                v0 = arg3.length();
                Intrinsics.checkNotNull(arg3, "null cannot be cast to non-null type java.lang.String");
                arg3.getChars(0, v0, arg4, arg5);
            }
            else {
                arg4[arg5] = arg3.charAt(0);
            }
        }

        return arg5 + arg3.length();
    }

    public static final String toHexString(byte arg5, HexFormat arg6) {
        Intrinsics.checkNotNullParameter(arg6, "format");
        String v0 = arg6.getUpperCase() ? "0123456789ABCDEF" : "0123456789abcdef";
        NumberHexFormat v6 = arg6.getNumber();
        if(v6.isDigitsOnlyAndNoPadding$kotlin_stdlib()) {
            char v1 = v0.charAt(arg5 >> 4 & 15);
            char v0_1 = v0.charAt(arg5 & 15);
            int v2 = 2;
            char[] v3 = new char[v2];
            v3[0] = v1;
            v3[1] = v0_1;
            if(v6.getRemoveLeadingZeros()) {
                return StringsKt.concatToString$default(v3, RangesKt.coerceAtMost(Integer.numberOfLeadingZeros(arg5 & 0xFF) - 24 >> v2, 1), 0, v2, null);
            }

            return StringsKt.concatToString(v3);
        }

        return HexExtensionsKt.toHexStringImpl(((long)arg5), v6, v0, 8);
    }

    public static final String toHexString(int arg10, HexFormat arg11) {
        Intrinsics.checkNotNullParameter(arg11, "format");
        String v0 = arg11.getUpperCase() ? "0123456789ABCDEF" : "0123456789abcdef";
        NumberHexFormat v11 = arg11.getNumber();
        if(v11.isDigitsOnlyAndNoPadding$kotlin_stdlib()) {
            char v1 = v0.charAt(arg10 >> 28 & 15);
            char v2 = v0.charAt(arg10 >> 24 & 15);
            char v3 = v0.charAt(arg10 >> 20 & 15);
            char v4 = v0.charAt(arg10 >> 16 & 15);
            char v5 = v0.charAt(arg10 >> 12 & 15);
            char v6 = v0.charAt(arg10 >> 8 & 15);
            char v7 = v0.charAt(arg10 >> 4 & 15);
            char v0_1 = v0.charAt(arg10 & 15);
            char[] v8 = new char[8];
            v8[0] = v1;
            v8[1] = v2;
            int v1_1 = 2;
            v8[v1_1] = v3;
            v8[3] = v4;
            v8[4] = v5;
            v8[5] = v6;
            v8[6] = v7;
            int v2_1 = 7;
            v8[v2_1] = v0_1;
            if(v11.getRemoveLeadingZeros()) {
                return StringsKt.concatToString$default(v8, RangesKt.coerceAtMost(Integer.numberOfLeadingZeros(arg10) >> v1_1, v2_1), 0, v1_1, null);
            }

            return StringsKt.concatToString(v8);
        }

        return HexExtensionsKt.toHexStringImpl(((long)arg10), v11, v0, 0x20);
    }

    public static final String toHexString(long arg26, HexFormat arg28) {
        long v0 = arg26;
        HexFormat v3 = arg28;
        Intrinsics.checkNotNullParameter(v3, "format");
        String v2 = v3.getUpperCase() ? "0123456789ABCDEF" : "0123456789abcdef";
        NumberHexFormat v3_1 = v3.getNumber();
        if(v3_1.isDigitsOnlyAndNoPadding$kotlin_stdlib()) {
            char v4 = v2.charAt(((int)(v0 >> 60 & 15)));
            char v5 = v2.charAt(((int)(v0 >> 56 & 15)));
            char v8 = v2.charAt(((int)(v0 >> 52 & 15)));
            char v9 = v2.charAt(((int)(v0 >> 0x30 & 15)));
            char v10 = v2.charAt(((int)(v0 >> 44 & 15)));
            char v11 = v2.charAt(((int)(v0 >> 40 & 15)));
            char v12 = v2.charAt(((int)(v0 >> 36 & 15)));
            char v13 = v2.charAt(((int)(v0 >> 0x20 & 15)));
            char v14 = v2.charAt(((int)(v0 >> 28 & 15)));
            char v6 = v2.charAt(((int)(v0 >> 24 & 15)));
            char v28 = v4;
            char v7 = v5;
            v4 = v2.charAt(((int)(v0 >> 20 & 15)));
            char v19 = v6;
            v5 = v2.charAt(((int)(v0 >> 16 & 15)));
            char v20 = v7;
            v6 = v2.charAt(((int)(v0 >> 12 & 15)));
            char v22 = v8;
            v7 = v2.charAt(((int)(v0 >> 8 & 15)));
            char v24 = v9;
            v8 = v2.charAt(((int)(v0 >> 4 & 15)));
            v9 = v4;
            char v15 = v5;
            char v2_1 = v2.charAt(((int)(v0 & 15)));
            char[] v4_1 = new char[16];
            v4_1[0] = v28;
            v4_1[1] = v20;
            int v5_1 = 2;
            v4_1[v5_1] = v22;
            v4_1[3] = v24;
            v4_1[4] = v10;
            v4_1[5] = v11;
            v4_1[6] = v12;
            v4_1[7] = v13;
            v4_1[8] = v14;
            v4_1[9] = v19;
            v4_1[10] = v9;
            v4_1[11] = v15;
            v4_1[12] = v6;
            v4_1[13] = v7;
            v4_1[14] = v8;
            int v6_1 = 15;
            v4_1[v6_1] = v2_1;
            if(v3_1.getRemoveLeadingZeros()) {
                return StringsKt.concatToString$default(v4_1, RangesKt.coerceAtMost(Long.numberOfLeadingZeros(v0) >> v5_1, v6_1), 0, v5_1, null);
            }

            return StringsKt.concatToString(v4_1);
        }

        return HexExtensionsKt.toHexStringImpl(v0, v3_1, v2, 0x40);
    }

    public static final String toHexString(short arg7, HexFormat arg8) {
        Intrinsics.checkNotNullParameter(arg8, "format");
        String v0 = arg8.getUpperCase() ? "0123456789ABCDEF" : "0123456789abcdef";
        NumberHexFormat v8 = arg8.getNumber();
        int v2 = 16;
        if(v8.isDigitsOnlyAndNoPadding$kotlin_stdlib()) {
            char v1 = v0.charAt(arg7 >> 12 & 15);
            char v3 = v0.charAt(arg7 >> 8 & 15);
            char v4 = v0.charAt(arg7 >> 4 & 15);
            char v0_1 = v0.charAt(arg7 & 15);
            char[] v5 = new char[4];
            v5[0] = v1;
            v5[1] = v3;
            int v1_1 = 2;
            v5[v1_1] = v4;
            int v3_1 = 3;
            v5[v3_1] = v0_1;
            if(v8.getRemoveLeadingZeros()) {
                return StringsKt.concatToString$default(v5, RangesKt.coerceAtMost(Integer.numberOfLeadingZeros(arg7 & 0xFFFF) - v2 >> v1_1, v3_1), 0, v1_1, null);
            }

            return StringsKt.concatToString(v5);
        }

        return HexExtensionsKt.toHexStringImpl(((long)arg7), v8, v0, v2);
    }

    public static final String toHexString(byte[] arg2, int arg3, int arg4, HexFormat arg5) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "format");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(arg3, arg4, arg2.length);
        if(arg3 == arg4) {
            return "";
        }

        int[] v0 = arg5.getUpperCase() ? HexExtensionsKt.BYTE_TO_UPPER_CASE_HEX_DIGITS : HexExtensionsKt.BYTE_TO_LOWER_CASE_HEX_DIGITS;
        BytesHexFormat v5 = arg5.getBytes();
        if(v5.getNoLineAndGroupSeparator$kotlin_stdlib()) {
            return HexExtensionsKt.toHexStringNoLineAndGroupSeparator(arg2, arg3, arg4, v5, v0);
        }

        return HexExtensionsKt.toHexStringSlowPath(arg2, arg3, arg4, v5, v0);
    }

    public static final String toHexString(byte[] arg2, HexFormat arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "format");
        return HexExtensionsKt.toHexString(arg2, 0, arg2.length, arg3);
    }

    public static String toHexString$default(byte arg0, HexFormat arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = HexFormat.Companion.getDefault();
        }

        return HexExtensionsKt.toHexString(arg0, arg1);
    }

    public static String toHexString$default(int arg0, HexFormat arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = HexFormat.Companion.getDefault();
        }

        return HexExtensionsKt.toHexString(arg0, arg1);
    }

    public static String toHexString$default(long arg0, HexFormat arg2, int arg3, Object arg4) {
        if((arg3 & 1) != 0) {
            arg2 = HexFormat.Companion.getDefault();
        }

        return HexExtensionsKt.toHexString(arg0, arg2);
    }

    public static String toHexString$default(short arg0, HexFormat arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = HexFormat.Companion.getDefault();
        }

        return HexExtensionsKt.toHexString(arg0, arg1);
    }

    public static String toHexString$default(byte[] arg0, int arg1, int arg2, HexFormat arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = arg0.length;
        }

        if((arg4 & 4) != 0) {
            arg3 = HexFormat.Companion.getDefault();
        }

        return HexExtensionsKt.toHexString(arg0, 0, arg2, arg3);
    }

    public static String toHexString$default(byte[] arg0, HexFormat arg1, int arg2, Object arg3) {
        if((arg2 & 1) != 0) {
            arg1 = HexFormat.Companion.getDefault();
        }

        return HexExtensionsKt.toHexString(arg0, arg1);
    }

    private static final String toHexStringImpl(long arg16, NumberHexFormat arg18, String arg19, int arg20) {
        String v0 = arg19;
        if((arg20 & 3) == 0) {
            int v1 = arg20 >> 2;
            int v2 = arg18.getMinLength();
            int v3 = RangesKt.coerceAtLeast(v2 - v1, 0);
            String v5 = arg18.getPrefix();
            String v6 = arg18.getSuffix();
            boolean v7 = arg18.getRemoveLeadingZeros();
            int v8 = HexExtensionsKt.checkFormatLength((((long)v5.length())) + (((long)v3)) + (((long)v1)) + (((long)v6.length())));
            char[] v9 = new char[v8];
            int v5_1 = HexExtensionsKt.toCharArrayIfNotEmpty(v5, v9, 0);
            if(v3 > 0) {
                v3 += v5_1;
                ArraysKt.fill(v9, v0.charAt(0), v5_1, v3);
                v5_1 = v3;
            }

            v3 = arg20;
            int v10;
            for(v10 = 0; v10 < v1; ++v10) {
                v3 += -4;
                int v12 = ((int)(arg16 >> v3 & 15));
                v7 = !v7 || v12 != 0 || v3 >> 2 < v2 ? false : true;
                if(!v7) {
                    v9[v5_1] = v0.charAt(v12);
                    ++v5_1;
                }
            }

            int v0_1 = HexExtensionsKt.toCharArrayIfNotEmpty(v6, v9, v5_1);
            if(v0_1 == v8) {
                return StringsKt.concatToString(v9);
            }

            return StringsKt.concatToString$default(v9, 0, v0_1, 1, null);
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private static final String toHexStringNoLineAndGroupSeparator(byte[] arg1, int arg2, int arg3, BytesHexFormat arg4, int[] arg5) {
        if(arg4.getShortByteSeparatorNoPrefixAndSuffix$kotlin_stdlib()) {
            return HexExtensionsKt.toHexStringShortByteSeparatorNoPrefixAndSuffix(arg1, arg2, arg3, arg4, arg5);
        }

        return HexExtensionsKt.toHexStringNoLineAndGroupSeparatorSlowPath(arg1, arg2, arg3, arg4, arg5);
    }

    private static final String toHexStringNoLineAndGroupSeparatorSlowPath(byte[] arg7, int arg8, int arg9, BytesHexFormat arg10, int[] arg11) {
        String v2 = arg10.getBytePrefix();
        String v3 = arg10.getByteSuffix();
        String v10 = arg10.getByteSeparator();
        char[] v5 = new char[HexExtensionsKt.formattedStringLength(arg9 - arg8, v10.length(), v2.length(), v3.length())];
        byte[] v0 = arg7;
        int[] v4 = arg11;
        int v7 = HexExtensionsKt.formatByteAt(v0, arg8, v2, v3, v4, v5, 0);
        int v1;
        for(v1 = arg8 + 1; v1 < arg9; ++v1) {
            v7 = HexExtensionsKt.formatByteAt(v0, v1, v2, v3, v4, v5, HexExtensionsKt.toCharArrayIfNotEmpty(v10, v5, v7));
        }

        return StringsKt.concatToString(v5);
    }

    private static final String toHexStringShortByteSeparatorNoPrefixAndSuffix(byte[] arg8, int arg9, int arg10, BytesHexFormat arg11, int[] arg12) {
        int v0 = arg11.getByteSeparator().length();
        if(v0 <= 1) {
            int v2 = arg10 - arg9;
            int v3 = 0;
            if(v0 == 0) {
                char[] v11 = new char[HexExtensionsKt.checkFormatLength((((long)v2)) * 2)];
                while(arg9 < arg10) {
                    v3 = HexExtensionsKt.formatByteAt(arg8, arg9, arg12, v11, v3);
                    ++arg9;
                }

                return StringsKt.concatToString(v11);
            }

            char[] v0_1 = new char[HexExtensionsKt.checkFormatLength((((long)v2)) * 3 - 1)];
            char v11_1 = arg11.getByteSeparator().charAt(0);
            v2 = HexExtensionsKt.formatByteAt(arg8, arg9, arg12, v0_1, 0);
            ++arg9;
            while(arg9 < arg10) {
                v0_1[v2] = v11_1;
                v2 = HexExtensionsKt.formatByteAt(arg8, arg9, arg12, v0_1, v2 + 1);
                ++arg9;
            }

            return StringsKt.concatToString(v0_1);
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private static final String toHexStringSlowPath(byte[] arg17, int arg18, int arg19, BytesHexFormat arg20, int[] arg21) {
        int v15;
        int v14;
        int v0 = arg19;
        int v2 = arg20.getBytesPerLine();
        int v3 = arg20.getBytesPerGroup();
        String v8 = arg20.getBytePrefix();
        String v9 = arg20.getByteSuffix();
        String v11 = arg20.getByteSeparator();
        String v12 = arg20.getGroupSeparator();
        int v1 = HexExtensionsKt.formattedStringLength(v0 - arg18, v2, v3, v12.length(), v11.length(), v8.length(), v9.length());
        String v7 = v9;
        char[] v9_1 = new char[v1];
        int v5 = arg18;
        int v4 = 0;
        int v6 = 0;
        int v10 = 0;
        while(v5 < v0) {
            if(v6 == v2) {
                v9_1[v4] = '\n';
                ++v4;
                v14 = 0;
                v15 = 0;
            }
            else if(v10 == v3) {
                v4 = HexExtensionsKt.toCharArrayIfNotEmpty(v12, v9_1, v4);
                v14 = v6;
                v15 = 0;
            }
            else {
                v14 = v6;
                v15 = v10;
            }

            if(v15 != 0) {
                v4 = HexExtensionsKt.toCharArrayIfNotEmpty(v11, v9_1, v4);
            }

            v10 = HexExtensionsKt.formatByteAt(arg17, v5, v8, v7, arg21, v9_1, v4);
            ++v5;
            int v16 = v10;
            v10 = v15 + 1;
            v4 = v16;
            v8 = v8;
            v6 = v14 + 1;
        }

        if(v4 == v1) {
            return StringsKt.concatToString(v9_1);
        }

        throw new IllegalStateException("Check failed.");
    }

    private static final long wholeElementsPerSet(long arg3, long arg5, int arg7) {
        long v0 = 0;
        if(arg3 > v0) {
            if(arg5 <= v0) {
            }
            else {
                v0 = ((long)arg7);
                return (arg3 + v0) / (arg5 + v0);
            }
        }

        return v0;
    }
}


package cw;

import java.util.ArrayList;
import java.util.Arrays;

public class Utils {

    public static String EMPTY_LINE = "";
    public static String SHARP = "#";
    public static String DELETED = "deleted";
    public static String TRACES = "Traces";
    public static String REQ_START_LINE_1 = "4. FUNCTIONAL PERFORMANCE REQUIREMENTS";
    public static String REQ_START_LINE_2 = "EXOMARS 2020 MISSION REQUIREMENTS";
    public static String FORMATTED_REQ = "%s в строке %s в файле %s\n";
    public static String REASON_DELETED = "отсутствие описания требования\n";
    public static String REASON_PARENT = "отсутствие требования-предка\n";
    public static String NEW_LINE = "\n";

    public static ArrayList<String> FILE_NAMES = new ArrayList<>(Arrays.asList(
            "EXM-D2-SYS-AI-0019_12_signed_by_LAV.txt",
            "EXM-M2-SYS-AI-0020_06_signed_by_LAV.txt"
    ));
}

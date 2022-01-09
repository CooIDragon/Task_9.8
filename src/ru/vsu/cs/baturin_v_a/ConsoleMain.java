package ru.vsu.cs.baturin_v_a;

import ru.vsu.cs.baturin_v_a.util.ArrayUtils;
import ru.vsu.cs.baturin_v_a.util.ListUtils;

import java.io.PrintStream;
import java.util.List;

public class ConsoleMain {

    public static class CmdParams {
        public String inputFile1;
        public String inputFile2;
        public String outputFile;
        public boolean error;
        public boolean help;
        public boolean window;
    }

    public static CmdParams parseArgs(String[] args) {
        CmdParams params = new CmdParams();
        if (args.length > 0) {
            if (args[0].equals("--help")) {
                params.help = true;
                return params;
            }
            if (args[0].equals("--window")) {
                params.window = true;
                return params;
            }
            if (args.length < 2) {
                params.help = true;
                params.error = true;
                return params;
            }
            params.inputFile1 = args[0];
            params.inputFile2 = args[1];

            if (args.length > 2) {
                params.outputFile = args[2];
            }
        } else {
            params.help = true;
            params.error = true;
        }
        return params;
    }

    public static void main(String[] args) throws Exception {
        ConsoleMain.CmdParams params = parseArgs(args);
        FindingElementsThatOnlyInOneList findingElementsThatOnlyInOneList = new FindingElementsThatOnlyInOneList();
        if (params.help) {
            PrintStream out = params.error ? System.err : System.out;
            out.println("Usage:");
            out.println("  <cmd> args <input-file1> <input-file2> (<output-file>)");
            out.println("  <cmd> --help");
            out.println("  <cmd> --window  // show window");
            System.exit(params.error ? 1 : 0);
        }

        if (params.window) {
            GUIMain.winMain();
        } else {
            int[] arr1 = ArrayUtils.readIntArrayFromFile(params.inputFile1);
            int[] arr2 = ArrayUtils.readIntArrayFromFile(params.inputFile2);

            if (arr1 == null || arr2 == null) {
                System.err.printf("Can't read array from \"%s\"%n", params.inputFile1);
                System.err.printf("Can't read array from \"%s\"%n", params.inputFile2);
                System.exit(2);
            }

            List<Integer> list1 = ListUtils.intArrayToList(arr1);
            List<Integer> list2 = ListUtils.intArrayToList(arr2);

            List<Integer> locatedOnlyInTheFirstAndSecondListMadeInList = findingElementsThatOnlyInOneList.isOnlyInTheFirstAndSecondList(list1, list2);
            int[] locatedOnlyInTheFirstAndSecondListMadeInArray = ListUtils.intListToArray(locatedOnlyInTheFirstAndSecondListMadeInList);

            PrintStream out = (params.outputFile != null) ? new PrintStream(params.outputFile) : System.out;
            out.println(ArrayUtils.toString(locatedOnlyInTheFirstAndSecondListMadeInArray));
            out.close();
        }
    }
}

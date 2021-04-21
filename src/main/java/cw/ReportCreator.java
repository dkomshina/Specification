package cw;

import cw.model.db.Reqs;

import java.io.*;
import java.util.List;

import static cw.Utils.*;

public class ReportCreator {

    public static void createReport(List<ReqsReport> incorrectReqs){
        try (FileWriter fw = new FileWriter("Report.txt")) {
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(String.format("Требования, не удовлетворяющие критериям (количество %d):\n", incorrectReqs.size()));
                bw.write(NEW_LINE);
                for (ReqsReport reqsReport : incorrectReqs){
                    Reqs req = reqsReport.getIncorrectReq();
                    Reason reason = reqsReport.getReason();
                    bw.write(String.format(FORMATTED_REQ, req.getId(), req.getLine(), req.getFile()));
                    if (reason.equals(Reason.DELETED)) {
                        bw.write(REASON_DELETED);
                    }
                    if (reason.equals(Reason.PARENT)) {
                        bw.write(REASON_PARENT);
                    }
                    bw.write(NEW_LINE);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

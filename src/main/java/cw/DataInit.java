package cw;

import cw.model.db.Reqs;
import cw.model.db.Traces;
import cw.repository.ReqsRepository;
import cw.repository.TracesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static cw.Utils.*;

@Component
public class DataInit {

    private final List<ReqsReport> incorrectReq = new ArrayList<>();

    @Autowired
    private ReqsRepository reqsRepository;
    @Autowired
    private TracesRepository tracesRepository;

    private Integer lineNumber = 1;

    public List<ReqsReport> readFile() {
        for (String fileName : FILE_NAMES) {
            try (FileReader fr = new FileReader(fileName)) {
                try (BufferedReader br = new BufferedReader(fr)) {
                    String line = br.readLine();
                    while (line != null && !line.equals(REQ_START_LINE_1) & !line.equals(REQ_START_LINE_2)) {
                        line = br.readLine();
                        lineNumber++;
                    }
                    while (line != null) {
                        processReq(line, br, fileName);
                        line = br.readLine();
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            lineNumber = 1;
        }
        return incorrectReq;
    }

    private void processReq(String line, BufferedReader br, String fileName) throws IOException {
        if (line.length() != 0 && line.charAt(0) == '[' && line.contains("-")) {
            Reqs req = new Reqs();
            req.setLine(lineNumber);
            String id = line.substring(1, line.length() - 1);
            req.setId(id);
            req.setFile(fileName);
            line = br.readLine();
            if (!line.toLowerCase().contains(DELETED)) {
                br.readLine();
                lineNumber += 2;
                if (!processTraces(br, id)) {
                    incorrectReq.add(new ReqsReport(req, Reason.PARENT));
                }
                req.setText(readText(br));
            } else {
                incorrectReq.add(new ReqsReport(req, Reason.DELETED));
                req.setText(line);
                readText(br);
            }
            reqsRepository.save(req);
        }
        lineNumber++;
    }

    private boolean processTraces(BufferedReader br, String childId) throws IOException {
        String line = br.readLine();
        lineNumber++;
        if (line.contains(TRACES)) {
            line = br.readLine();
            lineNumber++;
        }
        if (line.length() == 0) {
            return false;
        }
        while (line.length() != 0) {
            line = br.readLine();
            lineNumber++;
            String parentDocName = separateDocName(line);
            if (parentDocName.length() != 0) {
                Traces trace = new Traces();
                trace.setParentDoc(separateDocName(line));
                trace.setParent(correctParentId(line));
                trace.setChild(childId);
                tracesRepository.save(trace);
            } else {
                return false;
            }
            line = br.readLine();
            lineNumber++;
        }
        return true;
    }

    private String readText(BufferedReader br) throws IOException {
        List<String> text = new ArrayList<>();
        String line = br.readLine();
        while (!line.equals(SHARP)) {
            text.add(line);
            line = br.readLine();
            lineNumber++;
        }
        lineNumber++;
        return StringUtils.join('\n', text);
    }

    private String correctParentId(String line) {
        if (line.indexOf(',') != -1) {
            return line.substring(0, line.length() - 1);
        }
        return line;
    }

    private String separateDocName(String line) {
        if (line.length() == 0) {
            return EMPTY_LINE;
        }
        return line.substring(0, line.lastIndexOf('-'));
    }
}

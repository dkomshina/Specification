package cw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Init implements ApplicationRunner {

    @Autowired
    private DataInit dataInit;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<ReqsReport> incorrectReqs = dataInit.readFile();
        ReportCreator.createReport(incorrectReqs);
    }
}

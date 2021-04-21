package cw;

import cw.model.db.Reqs;

public class ReqsReport {

    private Reqs incorrectReq;
    private Reason reason;

    public ReqsReport(Reqs req, Reason reason) {
        this.incorrectReq = req;
        this.reason = reason;
    }

    public Reqs getIncorrectReq() {
        return incorrectReq;
    }

    public Reason getReason() {
        return reason;
    }
}

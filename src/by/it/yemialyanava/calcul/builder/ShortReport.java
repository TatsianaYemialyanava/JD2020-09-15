package by.it.yemialyanava.calcul.builder;

/**
 * "ConcreteBuilder"
 */
class ShortReport extends ReportBuilder {

    public void buildHead() {
        report.setHead("Report");
    }

    public void buildTimeOfRun() {
        report.setTimeOfRun("????");
    }

    public void buildTimeOfEnd() {
        repotr.setTimeOfEnd("?????");
    }

    public void buildInformationPart() {
        repotr.setInformationPart("?????");
    }
}

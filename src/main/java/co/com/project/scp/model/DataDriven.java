package co.com.project.scp.model;

public class DataDriven {

    private Integer index;
    private String orientation;
    private String transactionName;
    private String expectResult;
    private String descriptionCP;
    private String entryData;
    private User user;

    public String getEntryData() {
        return entryData;
    }


    public User getUser() {
        return user;
    }


    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public String getExpectResult() {
        return expectResult;
    }

    public void setExpectResult(String expectResult) {
        this.expectResult = expectResult;
    }

    public String getDescriptionCP() {
        return descriptionCP;
    }

    public void setDescriptionCP(String descriptionCP) {
        this.descriptionCP = descriptionCP;
    }

}
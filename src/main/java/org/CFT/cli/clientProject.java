package org.CFT.cli;

public class clientProject {
    private String clientName;
    private String salesEmployeeName;
    private String project;

    public String getClientName() {
        return clientName;
    }

    public clientProject(String clientName, String salesEmployeeName, String project) {
        this.clientName = clientName;
        this.salesEmployeeName = salesEmployeeName;
        this.project = project;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getSalesEmployeeName() {
        return salesEmployeeName;
    }

    public void setSalesEmployeeName(String salesEmployeeName) {
        this.salesEmployeeName = salesEmployeeName;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}

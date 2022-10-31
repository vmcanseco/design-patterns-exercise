package oop.inheritance.application.transaction;

public class BaseTransactionResponse implements  ITransactionResponse{
    private boolean approved;
    private String hostReference;


    public BaseTransactionResponse(boolean approved,String hostReference){
        this.approved = approved;
        this.hostReference = hostReference;
    }

    @Override
    public boolean isApproved() {
        return approved;
    }

    @Override
    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    @Override
    public String getHostReference() {
        return hostReference;
    }

    @Override
    public void setHostReference(String hostReference) {
        this.hostReference = hostReference;
    }
}

public class BusinessDelegate {
    private BusinessLookUp businessLookUp = new BusinessLookUp();
    private IBusinessService businessService;
    private String type;

    public void setType(String type) {
        this.type = type;
    }

    public void doTask() {
        businessService = businessLookUp.getBusinessService(type);
        businessService.doProcessing();
    }
}

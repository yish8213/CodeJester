package override.hashcode.and.equals;

public class Robot {
    private int productNumber;
    private String modelName;

    public Robot(int productNumber, String modelName) {
        super();
        this.productNumber = productNumber;
        this.modelName = modelName;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

}


public abstract class Samsung extends Phone {

    private String operatingSystem;

    public Samsung(Integer batteryLife, String operatingSystem) {
        super(batteryLife);
        this.operatingSystem = operatingSystem;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    @Override
    public String toString() {
        return "Samsung{" +
                "operatingSystem='" + operatingSystem + '\'' +
                '}';
    }
}

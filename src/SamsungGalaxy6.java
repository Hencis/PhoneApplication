import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SamsungGalaxy6 extends Samsung {

    private String color;

    private String material;

    private String IMEI;

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

    public String getIMEI() { return IMEI; }

    public SamsungGalaxy6(Integer batteryLife, String operatingSystem, String color, String material, String IMEI) {
        super(batteryLife, operatingSystem);
        this.IMEI = IMEI;
        this.color = color;
        this.material = material;
    }

    @Override
    public String toString() {
        return "SamsungGalaxy6{" + "color='" + color + '\'' + ", material='" + material + '\'' + ", IMEI='" + IMEI + '\'' + '}';
    }
}

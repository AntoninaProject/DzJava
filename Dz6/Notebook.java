package Dz6;

public class Notebook {
    int id;
    String vendor;
    String model;
    String color;

    int RAMSize;
    int RAMFr;

    String CPUVendor;
    String CPUModel;
    int CPUCoreAmt;
    double CPUFr;

    int HDDSize;

    String DisplayType;
    double DisplaySize;

    public Notebook(int id,
                    String vendor,
                    String model,
                    String color,
                    int RAMSize,
                    int RAMFr,
                    String CPUVendor,
                    String CPUModel,
                    int CPUCoreAmt,
                    double CPUFr,
                    int HDDSize,
                    String DisplayType,
                    double DisplaySize) {
        this.id = id;
        this.vendor = vendor;
        this.model = model;
        this.color = color;

        this.RAMSize = RAMSize;
        this.RAMFr = RAMFr;

        this.CPUVendor = CPUVendor;
        this.CPUModel = CPUModel;
        this.CPUCoreAmt = CPUCoreAmt;
        this.CPUFr = CPUFr;

        this.HDDSize = HDDSize;

        this.DisplayType = DisplayType;
        this.DisplaySize = DisplaySize;
    }

    @Override
    public String toString() {
        return String.format("id: %s\n%s %s %s\nRAM: %s Gb\nHDD: %s\nCPU: %s %s\ncores: %s\nfr: %s GHz",
                             id, vendor, model, color,
                             RAMSize, HDDSize,
                             CPUVendor, CPUModel,
                             CPUCoreAmt,
                             CPUFr);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Notebook)) {
            return false;
        }
        Notebook other = (Notebook)obj;
        return this.vendor.equals(other.vendor) &&
               this.model.equals(other.model) &&
               this.RAMSize == other.RAMSize &&
               this.CPUVendor.equals(other.CPUVendor) &&
               this.CPUModel.equals(other.CPUModel) &&
               this.CPUCoreAmt == other.CPUCoreAmt &&
               this.CPUFr == other.CPUFr &&
               this.DisplaySize == other.DisplaySize;
    }
}

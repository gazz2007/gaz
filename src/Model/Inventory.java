package Model;

public class Inventory {
    private int maxCapacity;
    private int currentStock;
    private int quantity;
    private int storageTemperature;
    private String storageName;
    private int expDays;

    public Inventory(int maxCapacity, int currentStock, int storageTemperature, String storageName, int quantity, int expDays) {
        this.maxCapacity = maxCapacity;
        this.currentStock = currentStock;
        this.storageTemperature = storageTemperature;
        this.storageName = storageName;
        this.quantity = quantity;
        this.expDays = expDays;
    }

    public Inventory() {
        this.maxCapacity = 0;
        this.currentStock = 0;
        this.quantity = 0;
        this.storageTemperature = 0;
        this.storageName = "Unknown";
        this.expDays = 0;
    }

    public int getExpDays() {
        return expDays;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStorageName() {
        return storageName;
    }

    public int getStorageTemperature() {
        return storageTemperature;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setExpDays(int expDays) {
        this.expDays = expDays;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public void setStorageTemperature(int storageTemperature) {
        this.storageTemperature = storageTemperature;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
    public boolean checkMaxCapacity() {
        return quantity+currentStock>maxCapacity;
    }
    public boolean checkExpDays() {
        return expDays>15;
    }

    @Override
    public String toString() {
        return "Model.Inventory{" +
                "maxCapacity=" + maxCapacity +
                ", currentStock=" + currentStock +
                ", quantity=" + quantity +
                ", storageTemperature=" + storageTemperature +
                ", storageName='" + storageName + '\'' +
                ", expDays=" + expDays +
                '}';
    }
}
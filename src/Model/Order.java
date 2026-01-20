package Model;

public class Order {
    private int orderId;
    private String customerName;
    private double totalAmount;
    private String status;
    public Order(int orderId, String customerName, double totalAmount, String status) {
        setOrderId(orderId);
        setCustomerName(customerName);
        setTotalAmount(totalAmount);
        this.status = status;
    }
    public void setOrderId(int orderId) {
        if(orderId >= 0) {
            this.orderId = orderId;
        }
        else {
            System.out.println("Invalid Model.Order ID");
        }
    }

    public void setCustomerName(String customerName) {
        if(customerName != null&&customerName.trim().isEmpty()) {
            this.customerName = customerName;
        }
        else {
            System.out.println("Invalid Model.Customer Name");
        }
    }

    public void setTotalAmount(double totalAmount) {
        if(totalAmount >= 0) {
            this.totalAmount = totalAmount;
        }
        else {
            System.out.println("Invalid Total Amount");
        }
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }
    public void completeOrder() {
        this.status = "Completed";
    }
    public boolean isPending() {
        return status.equals("Pending");
    }
    @Override
    public String toString() {
        return "Model.Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                '}';
    }
}

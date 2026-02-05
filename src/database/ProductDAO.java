package database;
import Model.FreshProduct;
import Model.FrozenProduct;
import Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public void insertProduct(Product product) {
        String sql = "INSERT INTO product (name, price, quantity,barcode,brand,days_left,product_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            // Set parameters (? → actual values)
            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            statement.setInt(3, product.getQuantity());
            statement.setInt(4, product.getBarcode());
            statement.setString(5, product.getBrand());
            statement.setInt(6, product.getDaysLeft());
            statement.setInt(7,product.getProduct_id());
            // Execute INSERT
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" Product inserted successfully!✅");
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println(" Insert failed!❌");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
    public boolean deleteProduct(int product_id) {
        String sql = "DELETE FROM product WHERE product_id=?";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, product_id);
            int rowsDeleted = statement.executeUpdate();
            statement.close();
            if (rowsDeleted > 0) {
                System.out.println(" ✅Product deleted (ID: " + product_id + ")");
                return true;
            } else {
                System.out.println("⚠\uFE0F No Product found with ID: " + product_id);
            }
        } catch (SQLException e) {
            System.out.println("❌Delete failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }
    public List<Product> getAllProduct() {
        List<Product> ProductList = new ArrayList<>();
        String sql = "SELECT * FROM product ORDER BY product_id";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return ProductList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Product product = extractProductFromResultSet(resultSet);
                if (product != null) {
                    ProductList.add(product);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("✅ Retrieved " + ProductList.size() + " product from database");

        } catch (SQLException e) {
            System.out.println("❌ Select all products failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return ProductList;
    }
    public Product getProductById(int product_id) {
        String sql = "SELECT * FROM product WHERE product_id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return null;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, product_id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Product product = extractProductFromResultSet(resultSet);

                resultSet.close();
                statement.close();

                if (product != null) {
                    System.out.println("✅ Found staff with ID: " + product_id);
                }

                return product;
            }

            System.out.println("⚠️ No product found with ID: " + product_id);

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("❌ Select by ID failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return null;
    }
    public void displayAllProduct() {
        List<Product> ProductList = getAllProduct();

        System.out.println("\n========================================");
        System.out.println("   ALL Product FROM DATABASE");
        System.out.println("========================================");

        if (ProductList.isEmpty()) {
            System.out.println("No product  in database.");
        } else {
            for (int i = 0; i < ProductList.size(); i++) {
                Product s = ProductList.get(i);
                System.out.print((i + 1) + ". ");
                System.out.print("[" + s.getProductType() + "] ");
                System.out.println(s.toString());
            }
        }

        System.out.println("========================================\n");
    }
    public void ProductStatus() {
        List<Product> ProductList = getAllProduct();

        System.out.println("\n========================================");
        System.out.println("  POLYMORPHISM: Products from Database");
        System.out.println("========================================");

        if (ProductList.isEmpty()) {
            System.out.println("No Product to demonstrate.");
        } else {
            for (Product s : ProductList) {
                s.productVerification();
                s.productName();
            }
        }

        System.out.println("========================================\n");
    }

    public void insertFrozenProduct(FrozenProduct frozenproduct) {
        String sql = "INSERT INTO product (name, price, quantity,barcode,brand,days_left,product_id,temperature,is_frozen) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            // Set parameters (? → actual values)
            statement.setString(1, frozenproduct.getName());
            statement.setInt(2, frozenproduct.getPrice());
            statement.setInt(3, frozenproduct.getQuantity());
            statement.setInt(4, frozenproduct.getBarcode());
            statement.setString(5,frozenproduct.getBrand());
            statement.setInt(6, frozenproduct.getDaysLeft());
            statement.setInt(7,frozenproduct.getProduct_id());
            statement.setInt(8,frozenproduct.getTemperature());
            statement.setBoolean(9,frozenproduct.isFrozen());
            // Execute INSERT
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" Frozen Product inserted successfully!✅");
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println(" Insert failed!❌");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
    public boolean updateFrozenProduct(FrozenProduct frozenproduct) {
        String sql = "UPDATE product SET name = ?, price = ?,quantity=?,barcode=?,brand=?,days_left=?,temperature=?,is_frozen=? " +
                "WHERE product_id = ?";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, frozenproduct.getName());
            statement.setInt(2, frozenproduct.getPrice());
            statement.setInt(3, frozenproduct.getQuantity());
            statement.setInt(4, frozenproduct.getBarcode());
            statement.setString(5,frozenproduct.getBrand());
            statement.setInt(6, frozenproduct.getDaysLeft());
            statement.setInt(7, frozenproduct.getTemperature());
            statement.setBoolean(8, frozenproduct.isFrozen());
            statement.setInt(9, frozenproduct.getProduct_id()); // WHERE condition
            int rowsUpdated = statement.executeUpdate();
            statement.close();
            if (rowsUpdated > 0) {
                System.out.println("✅ Frozen Product updated: " + frozenproduct.getName());
                return true;
            }
        } catch (SQLException e) {
            System.out.println(" ❌Update failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }
    public List<FrozenProduct> getAllFrozenProducts() {
        List<FrozenProduct> frozenproducts = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE name IS NOT NULL";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return frozenproducts;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Product product = extractProductFromResultSet(resultSet);
                if (product instanceof FrozenProduct) {
                    frozenproducts.add((FrozenProduct) product);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("✅ Retrieved " + frozenproducts.size() + " frozen products");

        } catch (SQLException e) {
            System.out.println("❌ Select frozen products failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return frozenproducts;
    }
    public void insertFreshProduct(FreshProduct freshProduct) {
        String sql = "INSERT INTO product (name, price, quantity,barcode,brand,days_left,product_id,is_ripe,is_Organic_Product) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            // Set parameters (? → actual values)
            statement.setString(1, freshProduct.getName());
            statement.setInt(2, freshProduct.getPrice());
            statement.setInt(3, freshProduct.getQuantity());
            statement.setInt(4, freshProduct.getBarcode());
            statement.setString(5,freshProduct.getBrand());
            statement.setInt(6, freshProduct.getDaysLeft());
            statement.setInt(7,freshProduct.getProduct_id());
            statement.setBoolean(8,freshProduct.isRipe());
            statement.setBoolean(9,freshProduct.isOrganicProduct());
            // Execute INSERT
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" Fresh Product inserted successfully!✅");
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println(" Insert failed!❌");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
    public boolean updateFreshProduct(FreshProduct freshProduct) {
        String sql = "UPDATE product SET name = ?, price = ?,quantity=?,barcode=?,brand=?,days_left=?,is_ripe=?,is_organic_product=? " +
                "WHERE product_id = ?";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, freshProduct.getName());
            statement.setInt(2, freshProduct.getPrice());
            statement.setInt(3, freshProduct.getQuantity());
            statement.setInt(4, freshProduct.getBarcode());
            statement.setString(5,freshProduct.getBrand());
            statement.setInt(6, freshProduct.getDaysLeft());
            statement.setBoolean(7, freshProduct.isRipe());
            statement.setBoolean(8, freshProduct.isOrganicProduct());
            statement.setInt(9, freshProduct.getProduct_id()); // WHERE condition
            int rowsUpdated = statement.executeUpdate();
            statement.close();
            if (rowsUpdated > 0) {
                System.out.println("✅ Fresh product updated: " + freshProduct.getName());
                return true;
            }
        } catch (SQLException e) {
            System.out.println(" ❌Update failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }
    public List<FreshProduct> getAllFreshProducts() {
        List<FreshProduct> freshProducts = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE is_ripe IS NOT NULL";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return freshProducts;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Product product = extractProductFromResultSet(resultSet);
                if (product instanceof FreshProduct) {
                    freshProducts.add((FreshProduct) product);
                }
            }

            resultSet.close();
            statement.close();

            System.out.println("✅ Retrieved " + freshProducts.size() + " Fresh Products");

        } catch (SQLException e) {
            System.out.println("❌ Select Fresh products failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }

        return freshProducts;
    }

    public List<Product> searchByName(String name) {
        List<Product> ProductList = new ArrayList<>();
        // ILIKE = case-insensitive
        // % = wildcard (matches any characters)
        String sql = "SELECT * FROM product WHERE name ILIKE ? ORDER BY name";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return ProductList;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%"); // Add wildcards!
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Product product = extractProductFromResultSet(resultSet);
                if (product != null) {
                    ProductList.add(product);
                }
            }
            resultSet.close();
            statement.close();
            System.out.println("✅ Found " + ProductList.size() + " product");
        } catch (SQLException e) {
            System.out.println(" ❌Search failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return ProductList;
    }
    public List<Product> searchByPriceRange(double min, double max) {
        List<Product> ProductList = new ArrayList<>();
        // BETWEEN includes both min and max (inclusive)
        String sql = "SELECT * FROM product " +
                "WHERE price BETWEEN ? AND ? " +
                "ORDER BY price DESC";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return ProductList;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, min);
            statement.setDouble(2, max);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Product product = extractProductFromResultSet(resultSet);
                if (product != null) {
                    ProductList.add(product);
                }
            }
            resultSet.close();
            statement.close();
            System.out.println(" ✅Found " + ProductList.size() + "product");
        } catch (SQLException e) {
            System.out.println(" ❌Search failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return ProductList;
    }
    public List<Product> searchByMinPrice(double minPrice) {
        List<Product> ProductList = new ArrayList<>();
        String sql = "SELECT * FROM product " +
                "WHERE price >= ? " +
                "ORDER BY price DESC";
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return ProductList;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, minPrice);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Product product = extractProductFromResultSet(resultSet);
                if (product != null) {
                    ProductList.add(product);
                }
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return ProductList;
    }


    private Product extractProductFromResultSet(ResultSet rs) throws SQLException {
        int productId = rs.getInt("product_id");
        String name = rs.getString("name");
        int price = rs.getInt("price");
        int quantity = rs.getInt("quantity");
        int barcode = rs.getInt("barcode");
        String brand = rs.getString("brand");
        int daysLeft = rs.getInt("days_left");

        // Проверяем, есть ли поля FrozenProduct
        Integer temperature = null;
        Boolean isFrozen = null;
        try {
            temperature = rs.getInt("temperature");
            if (rs.wasNull()) temperature = null;
            isFrozen = rs.getBoolean("is_frozen");
            if (rs.wasNull()) isFrozen = null;
        } catch (SQLException ignored) {}

        if (temperature != null && isFrozen != null) {
            return new FrozenProduct(
                    name, price, quantity, barcode, brand, daysLeft,
                    temperature, isFrozen, productId
            );
        }

        // Проверяем, есть ли поля FreshProduct
        Boolean isRipe = null;
        Boolean isOrganic = null;
        try {
            isRipe = rs.getBoolean("is_ripe");
            if (rs.wasNull()) isRipe = null;
            isOrganic = rs.getBoolean("is_organic_product");
            if (rs.wasNull()) isOrganic = null;
        } catch (SQLException ignored) {}

        if (isRipe != null && isOrganic != null) {
            return new FreshProduct(
                    name, price, quantity, barcode, brand, daysLeft,
                    isRipe, isOrganic, productId
            );
        }

        // fallback — обычный Product
        return new Product(name, price, quantity, barcode, brand, daysLeft, productId) {
            @Override
            public String getProductType() {
                return "Product";
            }

            @Override
            public boolean isProductBig() {
                return false;
            }
        };
    }
}

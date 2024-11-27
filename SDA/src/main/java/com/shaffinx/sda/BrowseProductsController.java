import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BrowseProductsController {
    @FXML
    private GridPane gridPane;

    private Connection connection; // Initialize your DB connection

    public void initialize() {
        loadProducts();
    }

    private void loadProducts() {
        String query = "SELECT prodname, img FROM products";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            int column = 0;
            int row = 0;

            while (resultSet.next()) {
                String productName = resultSet.getString("prodname");
                InputStream imageStream = resultSet.getBinaryStream("img");

                if (imageStream != null) {
                    Image productImage = new Image(imageStream);
                    ImageView imageView = new ImageView(productImage);

                    // Set image dimensions
                    imageView.setFitWidth(150);
                    imageView.setFitHeight(150);
                    imageView.setPreserveRatio(true);

                    // Add product image to GridPane
                    gridPane.add(imageView, column, row);

                    column++;
                    if (column == 3) { // 3 images per row
                        column = 0;
                        row++;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

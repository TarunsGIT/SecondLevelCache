package ad.hibernate.com.modeltest;

import ad.hibernate.com.dto.ProductDTO;
import ad.hibernate.com.model.ProductModel;

public class ProductModelTest {

	public static ProductModel model = new ProductModel();
	public static ProductDTO dto = new ProductDTO();

	public static void main(String[] args) {
		 //addProduct();
		// upadteProduct();
		// deletePorduct();
		// getProduct();
		model.load();
	}

	private static void getProduct() {

		dto = model.getProduct(105);
		if (dto != null) {
			System.out.println("Product ID:: " + dto.getProductId());
			System.out.println("Product Name:: " + dto.getProductName());
			System.out.println("Product Price:: " + dto.getPrice());
		} else {
			System.out.println("No record Found For " + dto.getProductId());
		}

	}

	private static void deletePorduct() {

		dto.setId(8);
		model.deleteProduct(dto);
		if (dto.getId() != 8) {
			System.out.println("Product Deleted");
		} else {
			System.out.println("Product not deleted");
		}

	}

	private static void upadteProduct() {
		dto.setId(2);
		dto.setProductId(102);
		dto.setProductName("IPHONE 5s");
		dto.setPrice(22000);
		long record = model.updateProduct(dto);
		if (record > 0) {
			System.out.println("Product Updated At " + record);
		} else {
			System.out.println("Product Not Updated");
		}
	}

	private static void addProduct() {

		dto.setProductId(106);
		dto.setProductName("Motorola Z2 Force");
		dto.setPrice(35000);
		long record = model.addProduct(dto);

		if (record > 0) {
			System.out.println("PRODUCT ADDED AT " + record);
		} else {
			System.out.println("PRODUCT NOT ADDED");
		}

	}

}

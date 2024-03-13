package org.example.Businesslogic;
import org.example.DataAccess.ProductDAO;
import org.example.Model.Produs;

public class ProductBLL {
    /***
     *  Method that applies insert method from class ProductDAO
     * @param produs the product for witch the method applies
     * @return return the method call
     */
        public int insertProdus(Produs produs)
        {
            return ProductDAO.insertProduct(produs);
        }

    /***
     * Method that applies, delete method from class ProductDAO
     * @param product_id the product id for witch the method applies
     * @return return the method call
     */
    public int deleteProdus(int product_id)
        {
            return ProductDAO.deleteProduct(product_id);
        }

    /***
     * Method that applies edit method from class ProductDAO
     * @param produs the product for witch the method applies
     */
    public void editProdus(Produs produs)
        {
            ProductDAO.editProduct(produs);
        }

    /***
     * Method that applies findbyid method from class ProductDAO
     * @param productId the product id for witch the method applies
     * @return return the method call
     */
    public  Produs findById(int productId)
    {
        return ProductDAO.findById(productId);
    }
}

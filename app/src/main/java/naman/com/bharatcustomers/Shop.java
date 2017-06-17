package naman.com.bharatcustomers;

/**
 * Created by Naman on 17-06-2017.
 */

public class Shop {

    public String shop_name;
    public String address;
    public String contact;
    public int price;

    Shop(String name, String address, String contact, int price)
    {
        this.shop_name=name;
        this.address= address;
        this.contact=contact;
        this.price=price;
    }

}

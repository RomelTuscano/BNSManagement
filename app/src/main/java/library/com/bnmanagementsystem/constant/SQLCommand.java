
/**
 * SQL commands
 * Including select/delete/update/insert
 */
package library.com.bnmanagementsystem.constant;

public abstract class SQLCommand
{
    //list quantatity of sale by categories
    public static String QUERY_1 = "SELECT Category.Cat_ID,Category.Cat_Desc,sum(Product.P_ID) FROM Category,Product WHERE Category.Cat_ID=Product.Cat_ID GROUP BY Category.Cat_ID,Category.Cat_Desc";
    //list the products which need to be supply later
    public static String QUERY_2 = "SELECT Branch.Br_Name,Product_Line.P_ID,sum(Product_Line.Pl_quantity) FROM Branch,Product_Line WHERE Branch.Br_ID=Product_Line.Br_ID GROUP BY Branch.Br_Name,Product_Line.P_ID HAVING sum(Product_Line.Pl_quantity)<11";
    //list the books bought by female customers, order by descending
    public static String QUERY_3 = "SELECT Customer.C_Gender,Order_Line.P_ID,sum(Order_Line.Ol_quantity) FROM Customer,Order1,Order_Line WHERE Customer.C_ID=Order1.C_ID AND Order1.O_ID=Order_Line.O_ID GROUP BY Customer.C_Gender,Order_Line.P_ID HAVING Customer.C_Gender='F' ORDER BY sum(Order_Line.Ol_quantity) desc";
    //list the books bought by male customers, order by descending
    public static String QUERY_4 = "SELECT Customer.C_Gender,Order_Line.P_ID,sum(Order_Line.Ol_quantity) FROM Customer,Order1,Order_Line WHERE Customer.C_ID=Order1.C_ID AND Order1.O_ID=Order_Line.O_ID GROUP BY Customer.C_Gender,Order_Line.P_ID HAVING Customer.C_Gender='M' ORDER BY sum(Order_Line.Ol_quantity) desc";
    //list the sale for every month
    public static String QUERY_5 = "SELECT Order1.O_Month, sum(Product_Line.Pl_quantity*Product.P_Price) FROM Order1,Order_Line,Product,Product_Line WHERE Order1.O_ID=Order_Line.O_ID AND Order_Line.P_ID=Product.P_ID AND Product.P_ID=Product_Line.P_ID GROUP BY Order1.O_Month";



//    public static String QUERY_6 = "select checkout.lbcallnum, count(*) from checkout group by lbcallnum";
//    public static String QUERY_7 = "select stid from Checkout where coreturned='Y'";
//    public static String RETURN_BOOK = "update checkout set coreturned=? where stid=? and lbcallnum=?";
//    public static String CHECK_BOOK = "insert into checkout(stid,lbcallnum,coduedate,coreturned) values(?,?,?,?)";
//    //checkout summary
//    public static String CHECKOUT_SUMMARY = "select strftime('%m',coduedate) as month,count(*) as total from checkout where strftime('%Y',coduedate)='2011' group by month order by total desc";
//    public static String CHECKOUT_LIST = "select checkout.stid as _id, lbtitle, coduedate,coreturned,cofine,stname from checkout,student,libbook where student.stid=checkout.stid and libbook.lbcallnum=checkout.lbcallnum";


}



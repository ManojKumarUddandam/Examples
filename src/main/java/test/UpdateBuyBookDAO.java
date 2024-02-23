package test;
import java.sql.*;
public class UpdateBuyBookDAO {
	public int k=0;
    public int update(BookBean bb) {
   	 try {
   		Connection con=DBConnection.getCon();
   		float updatedPrice = bb.getPrice() * bb.getQty();
   		PreparedStatement ps=con.prepareStatement
   	("update bookdetails57 set qty=? ,price=? where code=?");
   		ps.setInt(1, bb.getQty());
   		ps.setString(3, bb.getCode());
   		k=ps.executeUpdate();
   	 }catch(Exception e) {
   		 e.printStackTrace();
   	 }
   	 return k;
    }
}

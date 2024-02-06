
package rs.ac.bg.fon.repository.db;

import java.util.List;
import rs.ac.bg.fon.ps.domain.Product;
import rs.ac.bg.fon.ps.repository.Repository;

/**
 *
 * @author Raso
 */
public interface DbRepository <T, K> extends Repository<T, K>{
    default public void connect() throws Exception{
        DbConnectionFactory.getInstance().getConnection();

}
    default public void disconnect() throws Exception{
        
        DbConnectionFactory.getInstance().getConnection().close();
    }
    default public void commit() throws Exception{
        
        DbConnectionFactory.getInstance().getConnection().commit();
    }
    default public void rollback() throws Exception{
        
        DbConnectionFactory.getInstance().getConnection().rollback();
    }

   
}

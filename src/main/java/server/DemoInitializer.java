package server;

import dao.IndexDao;
import dao.IndexDaoImpl;
import model.Index;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: Maciej
 * Date: 18.04.13
 * Time: 20:40
 * To change this template use File | Settings | File Templates.
 */
public class DemoInitializer {

    private IndexDao indexDao = new IndexDaoImpl();

    void initialize() {
        Index index = new Index();
        index.setId("WIG");
        index.setCurrentValue(new BigDecimal("1234.56"));
        index.setCurrency("PLN");

        indexDao.create(index);

        Index index2 = new Index();
        index2.setId("WIG20");
        index2.setCurrentValue(new BigDecimal("6543.21"));
        index2.setCurrency("PLN");

        indexDao.create(index2);
    }

}

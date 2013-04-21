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
public class DemoInitializer implements Initializer {

    private IndexDao indexDao = new IndexDaoImpl();

    @Override
    public void initialize() {
        Index index;

        index = new Index();
        index.setId("WIG");
        index.setCurrentValue(new BigDecimal("1234.56"));
        index.setCurrency("PLN");

        indexDao.create(index);

        index = new Index();
        index.setId("WIG20");
        index.setCurrentValue(new BigDecimal("6543.21"));
        index.setCurrency("PLN");

        indexDao.create(index);

        index = new Index();
        index.setId("TestIndexA");
        index.setCurrentValue(new BigDecimal("8888.88"));
        index.setCurrency("EUR");

        indexDao.create(index);
    }

}

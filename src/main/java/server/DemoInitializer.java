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

        String[][] values = new String[][]{
                {"WIG", "1234.56", "PLN"},
                {"WIG20", "6543.21", "PLN"},
                {"TestIndexA", "8888.88", "EUR"},
        };

        Index index;

        for (String[] val : values) {

            index = new Index();
            index.setId(val[0]);
            index.setCurrentValue(new BigDecimal(val[1]));
            index.setCurrency(val[2]);

            indexDao.create(index);

        }

    }

}

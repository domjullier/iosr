package server;

import dao.IndexDao;
import dao.IndexDaoImpl;
import model.Index;

import java.math.BigDecimal;

/**
 * Seeds database with sample data for demonstration purposes
 */
public class DemoInitializer implements Initializer {

    private IndexDao indexDao = new IndexDaoImpl();

    /**
     * Adds some values to the database
     */
    @Override
    public void initialize() {

        String[][] values = new String[][]{
                {"PZU", "448.00", "PLN"},
                {"PKO_BP", "33.18", "PLN"},
                {"KGHM_POLSKA_MIEDZ_SA", "146.05", "PLN"},
                {"PEKAO", "150.70", "PLN"},
                {"PKN_ORLEN", "48.32", "PLN"},
                {"PGE", "16.81", "PLN"},
                {"PGNIG", "5.68", "PLN"},
                {"LPP", "7011.00", "PLN"},
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

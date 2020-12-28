package service;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import model.Bulka;
public class BulkaCreator {



        public  static  final String TESTDATA_PRODUCT_NAME= "testdata.bulka.name";
        public  static  final String TESTDATA_PRODUCT_COUNT = "testdata.bulka.count";
        public  static  final String TESTDATA_PRODUCT_COST = "testdata.bulka.cost";
        public  static  final String TESTDATA_PRODUCT_ERRORM = "testdata.bulka.errorMessage";

        public  static Bulka withCredentialsFromProperty(){
            return  new Bulka(TestDataReader.getTestData(TESTDATA_PRODUCT_NAME),
                    TestDataReader.getTestData(TESTDATA_PRODUCT_COUNT),
                    TestDataReader.getTestData(TESTDATA_PRODUCT_COST),
                    TestDataReader.getTestData(TESTDATA_PRODUCT_ERRORM));
        }

}

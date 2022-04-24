package testData;

import lombok.Data;
import utils.PropertyLoader;

@Data
public class WordsTestData extends BaseTestData {

    public String word1;
    public String word2;
    public String word3;



    public WordsTestData(final String key){
        String stendKey = System.getProperty("StendKey");
        String propPath = "testData/words.properties";

        word1 = PropertyLoader.loadProperty(stendKey+"_"+key+"_1",propPath);
        word2 = PropertyLoader.loadProperty(stendKey+"_"+key+"_2",propPath);
        word3 = PropertyLoader.loadProperty(stendKey+"_"+key+"_3",propPath);

    }

}

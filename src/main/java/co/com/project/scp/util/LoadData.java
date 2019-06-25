package co.com.project.scp.util;

import co.com.project.scp.model.DataDriven;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class LoadData {


    private static final Logger LOGGER = Logger.getLogger(LoadData.class.getName());
    public static DataDriven currentCase;
    private FileReader json = null;

    private LoadData(int index, String fileName) {

        try {
            Gson gson = new Gson();
            json = new FileReader("src/test/resources/dataDriven/" + fileName + ".json");
            List<DataDriven> listDataDriven = gson.fromJson(json, new TypeToken<List<DataDriven>>() {

            }.getType());
            json.close();

            if (listDataDriven != null) {
                currentCase = listDataDriven.get(index - 1);
                if (currentCase.getIndex() != (index)) {
                    throw new IllegalArgumentException("index does not correspond in dataDriven");
                }
            }
        } catch (JsonSyntaxException | IOException e) {
            LOGGER.info("JsonSyntaxException " + e.getMessage());
        }
    }

    public static LoadData in(int index, String fileName) {
        return new LoadData(index, fileName);
    }

}

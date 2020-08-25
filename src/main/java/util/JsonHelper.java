package util;
import api.Molde.BreweriesModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;


public class JsonHelper {
    private static final String NOMBRE_ARCHIVO = "ModeloDato";
    public static  BreweriesModel breweriesModel ;

    // Writing to a file
    public static void guardarJson(BreweriesModel dato) throws IOException {
        File file = new File(System.getProperty("user.dir") + File.separator + "src\\test\\resources\\jsons\\response\\" + NOMBRE_ARCHIVO + ".json");
       ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, dato);
    }

    public static void leerJson() throws IOException {
        File file = new File(System.getProperty("user.dir") + File.separator + "src\\test\\resources\\jsons\\response\\" + NOMBRE_ARCHIVO + ".json");
        ObjectMapper mapper = new ObjectMapper();
        BreweriesModel tmp = mapper.readValue(file,BreweriesModel.class);
        breweriesModel = tmp;
    }
}


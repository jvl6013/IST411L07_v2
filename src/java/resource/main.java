
package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

/**
 *
 * @author Group 2
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static  void main(String[] args) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File("json/songs.json"));
            Reader reader = new InputStreamReader(inputStream);
            JsonReader jsonReader = Json.createReader(reader);
            JsonArray songArray = jsonReader.readArray();
            List<Song> songList = new ArrayList<Song>();
            for (JsonValue jsonValue : songArray) {
                if (jsonValue.getValueType().equals(JsonValue.ValueType.OBJECT)) {
                    JsonObject jsonObject = (JsonObject) jsonValue;
                    Song song = new Song();
                    song.setName(jsonObject.getString("name"));
                    song.setArtist(jsonObject.getString("artist"));
                    song.setAlbum(jsonObject.getString("album"));
                    songList.add(song);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

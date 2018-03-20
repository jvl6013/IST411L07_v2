/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

/**
 *
 * @author myphs
 */
public class main {

    /**
     * @param args the command line arguments
     */
    
     
     
     
    public static  void main(String[] args) {
       
        InputStream inputStream = Song.class.getClass().getResourceAsStream("L07/songs.json");
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
    }
    
}

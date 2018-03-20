
package resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.persistence.EntityManager;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

/**
 * REST Web Service
 *
 * @author Group 2
 */
@Path("music")
public class Music {

    @Context
    private UriInfo context;

    public Music() {
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }

    

    @GET
    @Path("/song")
    @Produces(MediaType.TEXT_HTML)
    public String findAllSongs() throws FileNotFoundException {
        String rstr = "";
        List<JsonObject> songList = new ArrayList<JsonObject>();
        InputStream inputStream = new FileInputStream("C:\\Users\\myphs\\Documents\\NetBeansProjects\\L07\\json\\songs.json");
        JsonReader jr = Json.createReader(inputStream);
        JsonArray songArray = jr.readArray();
    
        for(JsonValue song : songArray){
            songList.add((JsonObject) song);
            rstr += song.toString();
        }
        
        return rstr;
        //return songList;
    }
}
    

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author myphs
 */
@XmlRootElement
public class Song {
    private String name, artist, album;
    
    public Song(){}
    
    public Song(String name, String artist, String album){
        this.name = name;
        this.artist = artist;
        this.album = album;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
    
    @Override
    public String toString(){
        return name + " by " + artist + " from " + album;
    }
    
}

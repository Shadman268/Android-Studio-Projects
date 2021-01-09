package com.example.firebaserealtimedatabase;

public class Artist {
    String ArtistId,ArtistName,ArtistGenre;
    public Artist()
    {

    }

    public Artist(String artistId, String artistName, String artistGenre) {
        ArtistId = artistId;
        ArtistName = artistName;
        ArtistGenre = artistGenre;
    }

    public String getArtistId() {
        return ArtistId;
    }

    public String getArtistName() {
        return ArtistName;
    }

    public String getArtistGenre() {
        return ArtistGenre;
    }
}

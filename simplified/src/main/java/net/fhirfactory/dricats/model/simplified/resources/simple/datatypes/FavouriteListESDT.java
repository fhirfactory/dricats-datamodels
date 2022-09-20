package net.fhirfactory.dricats.model.simplified.resources.simple.datatypes;

import java.util.ArrayList;

public class FavouriteListESDT {
    ArrayList<String> favourites;

    public FavouriteListESDT(){
        favourites = new ArrayList<>();
    }

    public ArrayList<String> getFavourites() {
        return favourites;
    }

    public void setFavourites(ArrayList<String> favourites) {
        this.favourites = favourites;
    }
}

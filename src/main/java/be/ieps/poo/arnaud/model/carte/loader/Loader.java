package be.ieps.poo.arnaud.model.carte.loader;

import be.ieps.poo.arnaud.model.carte.Carte;

import java.io.File;

public interface Loader {

    Carte load(File file) throws LoadingException;
    Carte loadResource(String resourceName) throws LoadingException;
}

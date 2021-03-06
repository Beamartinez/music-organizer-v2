import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }
    
    /*
     * Lista de todos los archivos
     */
    public void listAllFiles()
    {
        int posicion = 1;
        for(String filename : files)
        {
            System.out.println(posicion + ". " + filename);
            posicion = posicion + 1;
        }
    }
    
    /*
     * Lista de archivos que estan dentro de una cadena
     */
    public void listMachine(String searchString)
    {
        boolean contiene = false;
        for(String filename : files)
        {
            if(filename.contains(searchString))
            {
                System.out.println(filename);
                contiene = true;
            }
        }
        
        if(contiene == false)
        {
            System.out.println("ERROR: no hay ningun archivo que contenga ese nombre");
        }
    }
    
    /*
     * Reproduce los primeros segundos de un archivo
     */
    public void playArtist(String artist)
    {
        int contador = 0;
        for(String filename : files)
        {
            if(filename.contains(artist))
            {
                player.playSample(filename);
                contador = contador + 1;
            }
        }
        
        if(contador == 0)
        {
            System.out.println("ERROR: no hay ningun archivo que contenga ese nombre");
        }
    }
    
    /*
     * Devuelve el primer archivo que contiene una cadena o el valor -1 y si no hay
     * ningun archivo que cumpla la condicion usar un bucle while
     */
    public int findFirst(String busca)
    {
        int index = 0;
        boolean found = true;
        int size = files.size();
        
        while (!found && index < size)
        {
            String filename = files.get(index);
            if(filename.contains(busca))
            {
                found = false;
            }
            else
            {
                index = index + 1;
            }
        }
        
        if(found)
        {
            return - 1;
        }
        else
        {
            return index;
        }
    }
}

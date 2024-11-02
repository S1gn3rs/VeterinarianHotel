package hva;

import java.io.*;
import hva.exceptions.*;


/**
 * Class that represents the hotel application.
 */
public class HotelManager {

    /** This is the current hotel. */
    private Hotel _hotel = new Hotel();

    /** This is the filename associated with the current hotel. */
    private String _filename = "";


    /**
     * Saves the serialized application's state into the file
     * associated with the current hotel.
     *
     * @throws FileNotFoundException if for some reason the file
     * cannot be created or opened.
     * @throws MissingFileAssociationException if the current hotel
     * does not have a file.
     * @throws IOException if there is some error while serializing
     * the state of the hotel to disk.
     */
    public void save() throws FileNotFoundException,
    MissingFileAssociationException, IOException {
        if (_filename == null || _filename.equals(""))
            throw new MissingFileAssociationException();
        try (ObjectOutputStream oos = new ObjectOutputStream(
        new BufferedOutputStream(new FileOutputStream(_filename)))) {
            oos.writeObject(_hotel);
            _hotel.setChanged(false);
        }
    }


    /**
     * Saves the serialized application's state into a specified file.
     *
     * @param filename name of the file to save the hotel state to.
     * @throws FileNotFoundException if for some reason the file
     * cannot be created or opened.
     * @throws MissingFileAssociationException if the current hotel
     * does not have a file.
     * @throws IOException if there is some error while serializing
     * the state of the hotel to disk.
     */
    public void saveAs(String filename) throws FileNotFoundException,
    MissingFileAssociationException, IOException {
        _filename = filename;
        save();
    }


    /**
     * Loads the state of the hotel from a specified file.
     *
     * @param filename name of the file to load.
     * @throws UnavailableFileException if the specified file does
     * not exist or there is an error while processing this file.
     * @throws IOException if there is some error while deserializing
     * the state of the hotel from disk.
     * @throws ClassNotFoundException if the class of the serialized
     * object cannot be found.
     */
    public void load(String filename)
        throws UnavailableFileException, IOException,
        ClassNotFoundException {

        try (ObjectInputStream ois = new ObjectInputStream(
            new BufferedInputStream(new FileInputStream(filename)))) {

            _hotel = (Hotel) ois.readObject();
            _hotel.setChanged(false);
        }
        _filename = filename;

    }


    /**
     * Read text input file.
     *
     * @param filename name of the text input file
     * @throws ImportFileException
     */
    public void importFile(String filename)
        throws ImportFileException {

        _hotel.importFile(filename);
    }


    /**
     * @return the current hotel.
     */
    public Hotel getHotel() {
        return _hotel;
    }


    /**
     * Checks if the state of the hotel has changed.
     *
     * @return true if the hotel state has changed, false otherwise.
     */
    public boolean changed() {
        return _hotel.hasChanged();
    }


    /**
     * Resets the hotel.
     */
    public void reset() {
    _hotel = new Hotel();
    _filename = "";
    }


    /**
     * Show the global satisfaction of the hotel.
     *
     * @return the global satisfaction of the hotel.
     */
    public double showGlobalSatisfaction() {
        return getHotel().showGlobalSatisfaction();
    }


    /**
     * Advance the season.
     *
     * @return identifier of the new season.
     */
    public int advanceSeason(){
        return getHotel().advanceSeason();
    }

}

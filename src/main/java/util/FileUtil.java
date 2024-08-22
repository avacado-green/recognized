package util;

import model.FamilyTree;

import java.io.*;

public class FileUtil<T> implements FileOperations {
    private FamilyTree<T> familyTree;

    public FileUtil(FamilyTree<T> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(familyTree);
        }
    }

    @Override
    public void readFromFile(String filename) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            familyTree = (FamilyTree<T>) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


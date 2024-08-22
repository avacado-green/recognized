package util;

import java.io.IOException;

public interface FileOperations {
    void writeToFile(String filename) throws IOException;
    void readFromFile(String filename) throws IOException;
}


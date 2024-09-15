package oop.patterns.chainofresponsibility;

public class Main {

    public static void main(String[] args) {
        String path1 = "/home/myfile.txt";
        String path2 = "/home/myfile.zip";
        String path3 = "/home/myfile.doc";
        String path4 = "/home/myfile.jpg";
        String path5 = "/home/myfile.data";

        Handler textHandler = new TextFileHandler("handler 1");
        Handler docHandler = new DocFileHandler("handler 2");
        Handler imageHandler = new ImageFileHandler("handler 3");

        // Setting up the chain of responsibility
        textHandler.setNextHandler(docHandler);
        docHandler.setNextHandler(imageHandler);

        // Processing files
        textHandler.process(path1); // .txt file
        textHandler.process(path2); // .zip file
        textHandler.process(path3); // .doc file
        textHandler.process(path4); // .jpg file
        textHandler.process(path5); // .data file
    }
}

package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

/*
HTML Editor
 */

public class Controller {
   private View view;

    public HTMLDocument getDocument() {
        return document;
    }
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
       View v = new View();
       Controller controller = new Controller(v);
       v.setController(controller);
       v.init();
       controller.init();
    }

    public void init(){
        createNewDocument();

    }

    public void exit() {
        System.exit(0);

    }

    public void resetDocument(){
        if (document != null) document.removeUndoableEditListener(view.getUndoListener());
        HTMLEditorKit htmlKit = new HTMLEditorKit();
        document = (HTMLDocument) htmlKit.createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        document.putProperty("IgnoreCharsetDirective", true);
        view.update();
    }

    public void setPlainText(String text){
        resetDocument();

        try (StringReader stringReader = new StringReader(text)) {
            HTMLEditorKit htmlKit = new HTMLEditorKit();
            htmlKit.read(stringReader,document,0);
        }
        catch (IOException | BadLocationException e){
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText(){
        try(StringWriter writer = new StringWriter()) {
            new HTMLEditorKit().write(writer, document, 0, document.getLength());
            return writer.toString();
        } catch (Exception e){
            ExceptionHandler.log(e);
        }
     return null;
    }

    public void createNewDocument(){
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;

    }

    public void saveDocument(){
        view.selectHtmlTab();
        if (currentFile == null) saveDocumentAs();
        else {
            view.setTitle(currentFile.getName());
            try (FileWriter fileWriter = new FileWriter(currentFile + ".html")) {
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());
            } catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocumentAs(){
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());
        int index = fileChooser.showSaveDialog(view);
        if (index == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            try(FileWriter fileWriter = new FileWriter(currentFile + ".html")){
                new HTMLEditorKit().write(fileWriter, document, 0, document.getLength());

            }catch (Exception e){
                ExceptionHandler.log(e);
            }
        }
    }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new HTMLFileFilter());
        int index = fileChooser.showOpenDialog(view);
        if (index == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());

            try(FileReader fileReader = new FileReader(currentFile)) {
                new HTMLEditorKit().read(fileReader, document, 0);
                view.resetUndo();
            }
            catch (Exception e){
                ExceptionHandler.log(e);
            }
        }
    }
}
